package com.edifixio.soc.web.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.json.JSONException;

import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.Place;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UserList;
import twitter4j.http.AccessToken;

import com.edifixio.soc.biz.ParameterMgr;
import com.edifixio.soc.biz.dto.CachedListItemDTO;
import com.edifixio.soc.biz.dto.CachedOutboundDTO;
import com.edifixio.soc.biz.dto.ProfilePreferenceDTO;
import com.edifixio.soc.biz.dto.RTOPScheduleDTO;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfilePreference;
import com.edifixio.soc.web.beans.FindLocationOrLatLng;
import com.edifixio.soc.web.beans.ManageTwitterOperations;
import com.edifixio.soc.web.dto.FilterTwitterDataDTO;
import com.edifixio.soc.web.dto.ListItemDTO;
import com.edifixio.soc.web.dto.TwitterInformationDTO;
import com.edifixio.soc.web.dto.TwitterInformationTopDTO;

public class TwitterController extends BaseWebObject {
    
    private static final String BROWSER_LOC = "browserLoc";
    private static final String GETTING_YOUR_LOCATION = "GETTING YOUR LOCATION";
    private static final String YOUR_LOC = "yourLoc";
    public static final String LOCATION = "location";
    public static final String GEO_LOCATION = "geoLocation";
    public static final String SEARCH_LOC = "searchLoc";
    public static final String NEAR_BY_LOC = "nearByLoc";
    
    private String twtmessage;
    private String individualTweet;
    private String geoEnabled=TwitterControllerConstants.OFF;
    private String totalClicked = "";
    private String twitterUsername;
    
    private String sideClicked;
    private String clickedCustomer = "";
    private String firstCustomerName = "";
    private String ownerProfileImage="../images/demoPerson.png";
    private String openEditProfile = "";
    private String filterString;
    private String location = TwitterControllerConstants.ADD_YOUR_LOCATION;
    private String replyMessage;
    private String yourLocation=GETTING_YOUR_LOCATION;
    private String searchGEOLocation;
    private String geoLocation;
    List<String>  geoLocationListOfHandler;
    private String geoLatLong;
    private int clickedIndex;
    
    private boolean isValidCredentials;
    private boolean availableList = false;
    private boolean operated = false;
    private boolean loadRefreshPage=false;
    private boolean actionTaken;
    private boolean searchGeolocationFieldBlank;
    private boolean alwaysAskPopupOpen;
    
    
    private ChannelPerformanceController channelPerformanceController;
    
    public TwitterController() throws IllegalStateException, Exception 
    {
        
       System.out.println("Twitter Controller Constructor Called !!!!!!! ");
       
       if(getParameter("chkrpt")!= null) //Need to refactor
           setLocationToSession(getParameter("chkrpt"));
       
       setCurrentProfileId(getprofileId());
       getValueFromSession();
    }
    
    @SuppressWarnings("unchecked")
    public void getValueFromSession() throws IllegalStateException, Exception       {
         setAlwaysAskPopupOpen(isAlwaysASKPopupOpenFromPersistence()); // set value for always ask popup
         setOpenEditProfile("");
         setValidCredentials(true);
         setLoadRefreshPage(false);

         if(getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME) != null)        {
             String firstCust = getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME);
             setFirstCustomerName(firstCust);
             setClickedCustomer(firstCust);
         }
         
         
        List<TwitterInformationTopDTO> twitterInfoList = null;
         if(getObjSessionAttribute(TwitterControllerConstants.GET_TWITTER_INFO_LIST) != null)    {
             twitterInfoList = (List<TwitterInformationTopDTO>)getObjSessionAttribute(TwitterControllerConstants.GET_TWITTER_INFO_LIST);
             setTwitterInfoList(twitterInfoList);
             //setAvailableList( twitterInfoList.size() > 0 ? true : false );
             setAvailableList(getTweetInfoList());
         }
         
         if(getSessionAttribute(TwitterControllerConstants.ACTION_TAKEN_ON_POPUP) != null) {
             String popupType = getSessionAttribute(TwitterControllerConstants.ACTION_TAKEN_ON_POPUP);
             if(popupType.equals(TwitterControllerConstants.CREATE_PROFILE))
                 setOpenEditProfile(TwitterControllerConstants.CREATE_PROFILE_AUTH);
             else if(popupType.equals(TwitterControllerConstants.EDIT_PROFILE))
                 setOpenEditProfile(TwitterControllerConstants.EDIT_PROFILE_AUTH);
             else setOpenEditProfile("");
                 
         }
         
         //set owner profile image after twitter authentication
         if(getSessionAttribute(TwitterControllerConstants.OWNER_IMAGE) !=null)
             setOwnerProfileImage(getSessionAttribute(TwitterControllerConstants.OWNER_IMAGE));
         
         //set owner location information after twitter authentication
         if(getSessionAttribute(LOCATION) !=null)
             setLocation(getSessionAttribute(LOCATION));
         
         if(getSessionAttribute("replyInitials") != null)
             setReplyMessage(getSessionAttribute("replyInitials"));
         
         //Persist filter type in session and display on the screen
         if(getSessionAttribute(TwitterControllerConstants.FILTER_STRING) ==null)
             setFilterString(TwitterControllerConstants.OFF);
         else
             setFilterString(getSessionAttribute(TwitterControllerConstants.FILTER_STRING));
         
         //It sets the profile image at WHAT'S HAPPENNING
         /*if(getSessionAttribute(TwitterControllerConstants.PROFILE_IMAGE) != null)
              setOwnerProfileImage(getSessionAttribute(TwitterControllerConstants.PROFILE_IMAGE));*/
         
         //To open valid credential popup 
         if(getObjSessionAttribute(TwitterControllerConstants.VALID_CREDENTIALS) != null)  
              setValidCredentials((Boolean)getObjSessionAttribute(TwitterControllerConstants.VALID_CREDENTIALS));
         
         //Used in searchLocationDetails.jsp
         if(getObjSessionAttribute(TwitterControllerConstants.SEARCH_LOCATION_HANDLER)!=null)
              setSearchGeolocationFieldBlank((Boolean)getObjSessionAttribute(TwitterControllerConstants.SEARCH_LOCATION_HANDLER));
         
         //Used in searchLocationDetails.jsp
         if(getSessionAttribute(TwitterControllerConstants.SEARCH_LOCATION_TEXT)!=null)
              setSearchGEOLocation(getSessionAttribute(TwitterControllerConstants.SEARCH_LOCATION_TEXT));
         
         //Display geo-location
         if(getSessionAttribute(GEO_LOCATION)!=null)
              setYourLocation(getSessionAttribute(GEO_LOCATION));
         
         // display near by geo-locations
              //setNearByLocationFromSession(); //commented on 23-05-2011
         
         //display search location in searchLocationDetails.jsp
         if(getSessionAttribute(SEARCH_LOC) != null)
              setSearchGEOLocation(getSessionAttribute(SEARCH_LOC));
         
         //Your location
         if(getLocationFromSession() != null)
             setYourLocation(getLocationFromSession());
    }
    
    private void setLocationToSession(String loc) {
        setSessionAttribute(YOUR_LOC, loc);
    }
    
    private String getLocationFromSession() {
        return getSessionAttribute(YOUR_LOC);
    }
    
    public boolean isAlwaysASKPopupOpenFromPersistence() throws SVTException    {
        if(getProfilePreferenceObj() != null){
            return getProfilePreferenceObj().isWarningAlert(); 
        }
        return true;
    }
    
    public ProfilePreference getProfilePreferenceObj() throws SVTException {
        return getProfilePreferenceMgr()
               .getByProfilePreferenceId(getCurrentProfileId())
               .getProfilePreference();
    }
    /**
     * When Always Asked value changed from RTO's Refresh List option
     * 
     * @param vce
     * @throws IllegalStateException
     * @throws Exception
     */
    public void onAlwaysAskClicked(ValueChangeEvent vce) throws IllegalStateException, Exception {
        Boolean isChecked = (Boolean)vce.getNewValue();
        if(!isChecked)
            showRefreshListPopup(null);
        setAlwaysAskPopupOpen(isAlwaysASKPopupOpenFromPersistence());
    }
    
    /**
     * Enables/Disable the popup for refresh the list
     */
    public void showRefreshListPopup(ActionEvent ae)throws IllegalStateException, Exception {
        ProfilePreferenceDTO dto = getProfilePreferenceMgr().getByProfilePreferenceId(getprofileId());        
        UserProfileDetailDTO userProfileDto = new UserProfileDetailDTO();
        userProfileDto.setProfilePreference(dto.getProfilePreference());
        userProfileDto.setWarningAlert(false);
        getProfilePreferenceMgr().updateAlwaysAskWarningAlert(userProfileDto);
    }
       
    public void setParametersInSession() throws SVTException    {
      ParameterMgr mgr = getParameterMgr();
      setSessionAttribute(TwitterControllerConstants.CALLBACK_URL,mgr.getCallbackURL().trim());
      setSessionAttribute(TwitterControllerConstants.CONSUMER_KEY,mgr.getConsumerKey().trim());
      setSessionAttribute(TwitterControllerConstants.CONSUMER_KEY_SECRETE,mgr.getConsumerKeySecret().trim());
    }
    
    public void setIndividualTweet(String individualTweet) throws Exception {
        this.individualTweet = individualTweet;
        sendTweetBasedOnRule();
    }
    
    public void pushAlreadyViewedDataToDB() throws Exception    {
     // TODO : toWhom and fromWhom is intentionally left blank
        //String toWhom = "";
        //String fromWhom = "";
        List<TwitterInformationTopDTO> twitterInformationDTO = getTwitterInfoList();
        if(twitterInformationDTO.size() !=0 || twitterInformationDTO != null) {
            for(int j = 0; j < twitterInformationDTO.size(); j++)   {
                if(twitterInformationDTO.get(j).getDtoLeft() != null) { 
                    persist(twitterInformationDTO.get(j).getDtoLeft().getTwitterStatusID(), 
                        getFirstCustomerName());
                }
                if(twitterInformationDTO.get(j).getDtoRight() != null ){ 
                    persist(twitterInformationDTO.get(j).getDtoRight().getTwitterStatusID(), 
                        getFirstCustomerName());
                }
            }
            System.out.println("Twitter Information SAVED Successfully !!!!!!!! ");
        }
    }
    
    public void persist(long twtStatusID, String twitterUserName) throws SVTException    {
        FilterTwitterDataDTO filterTwitterData = null;
        filterTwitterData  = collectAllValidTweets(twtStatusID, filterTwitterData,twitterUserName);
        updateOrSaveOperations(filterTwitterData,TwitterControllerConstants.SAVE);//Saves the information.
    }
    
    public void updateOrSaveOperations(FilterTwitterDataDTO filterTwitterData, String operation)
    throws SVTException {
        if(operation.equalsIgnoreCase(TwitterControllerConstants.SAVE))
            getTwitLogMgr().add(filterTwitterData);
        else
            getTwitLogMgr().update(filterTwitterData);
    }
    
    public  FilterTwitterDataDTO  collectAllValidTweets(long twitStatusID,
                                        FilterTwitterDataDTO filterTwitterData, String twitterUsername) { 
        
            filterTwitterData = new FilterTwitterDataDTO();
            filterTwitterData.setToWhom("");//(toWhom);
            filterTwitterData.setFrom("");//(fromWhom);
            filterTwitterData.setRetweet(false);//(reTweet);
            filterTwitterData.setReply(false);//(reply);
            filterTwitterData.setSendTweet(false);//(sendTweet);
            filterTwitterData.setActionTakenOn(new Date());
            filterTwitterData.setTwittStatusID(twitStatusID);
            filterTwitterData.setTwitterUsername(twitterUsername);
            filterTwitterData.setLoginProfileId(getCurrentProfileId());
            return filterTwitterData;
    }
    //For database storing Operation, ended Here .........................
    
    /**
     * Fetch Tweet message
     * 1. It search for the token
     */
    public void twittMessage(ActionEvent ae) throws IllegalStateException, Exception 
    {
        setTotalClicked("");
        setOperated(false);
        setOpenEditProfile("");
        setFirstCustomerName("");
        
        String lActionTakenOnComponentID = ae.getComponent().getId();
        
        System.out.println("lActionTakenOnComponentID  : "+lActionTakenOnComponentID);
        setSessionAttribute(TwitterControllerConstants.ACTION_TAKEN_ON_POPUP,lActionTakenOnComponentID);
        
        if(lActionTakenOnComponentID.equals(TwitterControllerConstants.REFRESH_LIST)) // onClick: "Refresh button"
        {
            if(getTwitterInfoList() == null);
            else if(getTwitterInfoList().size() != 0)
                    pushAlreadyViewedDataToDB();
        }
        
        /**
         * when user clicks on drop down button or "Refresh list" from RTO
         */
        if(getParameter(TwitterControllerConstants.AUTH_NAME) == null && 
                (getClickedCustomer() == null || getClickedCustomer().equals("")))        {
            setCustNameToSession(getFirstCustomerName());
        }
        
        /**
         * when user authenticate from editProfile page
         */
        else if(getParameter(TwitterControllerConstants.AUTH_NAME) != null)  {
            setCustNameToSession(getParameter(TwitterControllerConstants.AUTH_NAME));
        }
        
        /**
         * When user selects the handler from the RTO drop down list.
         */
        //if(lActionTakenOnComponentID.equalsIgnoreCase(TwitterControllerConstants.SELECTED_HANDLER))  {
        if(getParameter(TwitterControllerConstants.HANDLER_FROM_LIST) != null)  {
            setCustNameToSession(getParameter(TwitterControllerConstants.HANDLER_FROM_LIST));
            setProfileImageAndLocationJSON(); // Setting the profile image and location for first time or handler change
        }
        try {
           Twitter twitter = validateTwitterObject(getFirstCustomerName()); 
           if(twitter != null)  {
               setTweetsDataList(twitter);
           } else  {
               setParametersInSession();
               FacesContext.getCurrentInstance().getExternalContext().redirect("./signin");
               setSessionAttribute(TwitterControllerConstants.MSG, TwitterControllerConstants.SHOW_TWEET);
           }
        }
        catch(Exception e) {
            System.out.println("Twitter access problem ."+e.getMessage());
        }
    }
    
    public void setCustNameToSession(String parameter) {
        setSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME, parameter);        
        setClickedCustomer(parameter);
    }
    
    /**
     * Works during page load or any handler change from the list.
     * @throws TwitterException
     * @throws JSONException
     */
   private void setProfileImageAndLocationJSON() throws TwitterException, JSONException {
       try {
           //setProfileImageAndLocation(getFirstCustomerName());
           //setProfileLocation(getFirstCustomerName(), getTwitterInstance());
           setProfileImage(getFirstCustomerName(), getTwitterInstance());
           //setProfileLocationByTwitterStatusGEO(getFirstCustomerName());
       }    catch(Exception e) {
           System.out.println("Image or Location not found.....");
       }
   }
    
    /**
     * Sets the profile location from tweet status (Temporary Solution, Need to be change).
     * @param screenName
     * @throws TwitterException 
     * @throws JSONException 
     */
    private void setProfileLocationByTwitterStatusGEO(String screenName) throws TwitterException, JSONException {
        System.out.println("Inside setProfileLocationByTwitterStatusGEO :::::::: "+screenName);
        GeoLocation geoLocation = getLatLngOfProfileByStatus(screenName);
        String location="";
        if(geoLocation != null)  {
            String latLng = geoLocation.getLatitude()+","+geoLocation.getLongitude();
            location = new FindLocationOrLatLng()
                                    .getLocationOrLatLng(latLng,
                                            FindLocationOrLatLng.BY_LOCATION);
        }
        setLocation(getActualLoc(location));
        //setSessionAttribute(TwitterControllerConstants.LOCATION,location);
    }
    
    private GeoLocation getLatLngOfProfileByStatus(String screenName) throws TwitterException {
        Query query = new Query(screenName).rpp(50); //Takes up to 50 Tweets and search GEO location
        QueryResult result = getTwitterInstance().search(query);
        GeoLocation geoLocation = null;
        for (Tweet tweet : result.getTweets())     {
            if(tweet.getGeoLocation() != null) {
                geoLocation = tweet.getGeoLocation();  break;
            } 
        }
        return geoLocation;
    }
    
    private void setProfileImage(String screenName, Twitter twitter) {
        try   {
            setOwnerProfileImage(twitter.showUser(screenName).getProfileImageURL().toString());
        } catch(Exception e) {
              System.out.println("Profile image not found ."+e.getMessage());
        }
        setSessionAttribute(TwitterControllerConstants.OWNER_IMAGE, getOwnerProfileImage());
    }
    
    private String getActualLoc(String loc) {
        return (loc == null || loc.equals("")) ? TwitterControllerConstants.ADD_YOUR_LOCATION : "from "+loc;
    }
    public void broadcastGlobalMessage(ActionEvent ae)throws IllegalStateException, Exception {
        
        //If 'tweetmessage' is empty get the message from param
        
        String scheduleId = getParameter("scheduleId");
        String index = getParameter("indexClk");
        
        String grade = getParameter("rtopGrade_"+index);
        
        if(grade == null || grade.trim().length() == 0)
        {
            grade = getParameter("scheduleGrade");
        }
        
        if(getTwtmessage() != null && getTwtmessage().trim().length() > 0)
        {
            sendTweetAsWhatIsHappening(getTwtmessage(),scheduleId, grade);
        }
        else
        {
            
            sendTweetAsWhatIsHappening(getParameter("twtMessage_"+index),scheduleId, grade);
        }
        
    }
    
    //This send the tweet as WHAT IS HAPPENING type
    public void sendTweetAsWhatIsHappening(String message, String scheduleId, String rtopGrade) throws IllegalStateException, Exception  {
        
        // Code Refactored
        
        if(message != null && message.trim().length() > 0)
        {
            try
            {
                replyOrGlobalMessage(message,getFirstCustomerName(), scheduleId, rtopGrade);
                //validateTwitterObject(getFirstCustomerName()).updateStatus(message);
            } 
            catch(Exception e)
            {
                System.out.println("Couldn't send message. "+e.getMessage());
            }
            
        }
        else
        {
            System.out.println("Empty Data Can't Be Twitt !!!!");
            setTwtmessage("");
        }
        
        setTwtmessage("");
        
    }
    
    public void fetchTwitterAccount(ActionEvent ae) throws IllegalStateException, Exception   {
        getRTOPHandler().setOptimizeActionDTOs(null);
        twittMessage(ae);
    }
    
    public String getProfileImageAndLocationFirstTime() throws IllegalStateException, TwitterException, JSONException {
            //setProfileImageAndLocation(getFirstCustomerName());
            //setProfileImage(getFirstCustomerName(), getTwitterInstance());
            //setProfileLocation(getFirstCustomerName(), getTwitterInstance());
            //setProfileLocationByTwitterStatusGEO(getFirstCustomerName());
            setProfileImageAndLocationJSON();
         return "";
     }
    
    /**
     * Used in geoLocation.jsp
     * @param ae
     * @throws IllegalStateException, Exception
     */
    public void searchGeoLocationForHandler(ActionEvent ae) throws IllegalStateException, Exception  {
        setBrowserLocationOnceInSession(getGeoLatLong()); // Sets current browser location in session
        setYourLocation(getLocationByLongituteLatitude(getBrowserLocationFromSession()));
        setLocationToSession(getBrowserLocationFromSession()); 
    }
    
    /**
     * If browser fails to get the location, then it takes 
     * the previous location from the session and use it.
     * @param loc
     */
    public void setBrowserLocationOnceInSession(String loc) {
        if(loc == null || loc.equals("")) return;
            setSessionAttribute(BROWSER_LOC, loc);
    }
    
    public String getBrowserLocationFromSession() {
        if(getGeoLatLong() == null || getGeoLatLong().equals(""))
            return getSessionAttribute(BROWSER_LOC);
        else
            return getGeoLatLong();
    }
    
    private String getLocationByLongituteLatitude(String geoLocation) throws JSONException {        
        return new FindLocationOrLatLng().getLocationOrLatLng(geoLocation,FindLocationOrLatLng.BY_LOCATION);
    }

    /**
     * Used in searLocation.jsp, Provides near by location
     * @param ae
     * @throws IllegalStateException
     * @throws Exception
     */

    public void searchNearByGeoLocationByPlace(ActionEvent ae) throws IllegalStateException, Exception  {
        System.out.println("Inside near by location :"+getLocationFromSession()+"  :  "+getSearchGEOLocation());
        if(getSearchGEOLocation() == null)
            setSearchGEOLocation(getLocationFromSession());
        getNearByLocUsingTwitterAPI(getSearchGEOLocation());
        setSessionAttribute(SEARCH_LOC, getSearchGEOLocation() != null ? getSearchGEOLocation() : "");
    }
    /**
     * When user clicks on drop down from RTO GEO-Location
     * @param ae
     * @throws TwitterException
     */
    public void searchNearByLocationOnDropDownClicked(ActionEvent ae) throws TwitterException {
        try {
            List<String> handlerGeoLocationList = getNearByLocUsingTwitterAPI(getYourLocation());
            setNearByLocationListForDropDown(handlerGeoLocationList);
        }  catch(Exception e) {
            System.out.println("Twitter Error(searchNearByLocationOnDropDownClicked) : "+e.getMessage());
        }
    }
    
    private void setNearByLocationListForDropDown(List<String> handlerGeoLocationList) {
        if(handlerGeoLocationList.size() !=0) {
            if(handlerGeoLocationList.contains(getYourLocation()));
            else
                handlerGeoLocationList.add(0, getYourLocation()); // add in the first place to the list.
        }
        setGeoLocationListOfHandler(handlerGeoLocationList);
    }
    
    public void whatIsHappeningDropDownClicked(ActionEvent ae) throws TwitterException {
       String location="";
        if(getParameter("fromLocation") != null || getParameter("fromLocation").equals("")) 
            location = getParameter("fromLocation");
        
        if(!(location.equalsIgnoreCase(TwitterControllerConstants.ADD_YOUR_LOCATION)))
            setGeoLocationListOfHandler(getNearByLocUsingTwitterAPI(location));
    }
    
    /**
     * Returns nearby location using twitter API
     * @return
     * @throws TwitterException
     */
    public List<String> getNearByLocUsingTwitterAPI(String location) throws TwitterException {
        List<String> handlerGeoLocationList=new ArrayList<String>();
        try  {
                /*String [] latLng =new FindLocationOrLatLng()
                        .getLocationOrLatLng(location,FindLocationOrLatLng.BY_LAT_LNG).split(",");  
                GeoLocation geoLocation = new GeoLocation(Double.parseDouble(latLng[1].trim()),
                                        Double.parseDouble(latLng[0].trim()));*/
                GeoLocation geoLocation = getSelectedGeoLatLng(location);
                GeoQuery query = new GeoQuery(geoLocation);
                Twitter twitter = getTwitterInstance();
                for(Place place : twitter.getNearbyPlaces(query))
                    handlerGeoLocationList.add(place.getFullName());
        }
        catch(Exception e) {
            System.out.println("Wrong location OR location not found. "+e.getMessage());
        }
        System.out.println("Near by location  : "+handlerGeoLocationList);
        setGeoLocationListOfHandler(handlerGeoLocationList);
        setSessionAttribute(NEAR_BY_LOC, handlerGeoLocationList);
        return handlerGeoLocationList;
    }
    
    public List<String> getGeoLocationListOfHandler() {
        return geoLocationListOfHandler;
    }

    public void setGeoLocationListOfHandler(List<String> geoLocationListOfHandler) {
        this.geoLocationListOfHandler = geoLocationListOfHandler;
    }
    
    public void updateGeoLocationForHandler(ActionEvent ae) {
        setYourLocation(getParameter("newLocation"));
        setLocationToSession(getYourLocation());
        System.out.println("Inside update geo location for handler : !!!! : "+getYourLocation());
        //setSessionAttribute("yourLoc", getYourLocation());
    }
    
    public void setTweetsDataList(Twitter twitter) throws IllegalStateException, Exception    {
        
        ManageTwitterOperations opt = new ManageTwitterOperations();
        List<TwitterInformationTopDTO> infoDTO = opt.getTwitterInformationList(twitter,getFirstCustomerName());
        setSessionAttribute(TwitterControllerConstants.GET_TWITTER_INFO_LIST,infoDTO);
        setTwitterInfoList(infoDTO);
        
        if(infoDTO.size()>0)
            setAvailableList(true);
    }
    
   public Twitter getTwitterInstance() {
       try  {
           TwitterFactory twitterFactory = new TwitterFactory();
           Twitter twitter = twitterFactory.getInstance();
           return twitter;
       }  catch (Exception e) {
               System.out.println("Twitter instance couldn't be created. "+e.getMessage());
       }
       return null;
   }
   /**
    *  This method is responsible for validating the 
    *  twitter object based on token key and secrete (getting from the database)
    */
   public Twitter validateTwitterObject(String twitterUserName) throws IllegalStateException, Exception {
       Twitter twitter = null;
       try   {
           if((twitter = getTwitterInstance()) != null)
               //return twitter;
            twitter = getTwitterAccessToken(twitter, twitterUserName);
       }    catch(Exception e)       {
           System.out.println("Twitter object validation error. "+e.getMessage());
       }
        return twitter;
    }
   
   /**
    * Get twitter accessToken and secrete from the database. If not fund, it returns null.
    * @param twitter, @param dto, @return, @throws SVTException
    */
   private Twitter getTwitterAccessToken(Twitter twitter, String twitterUserName) throws SVTException {
       TwitterAccountDTO dto = getByTwitterProfIdUsername(getCurrentProfileId(),twitterUserName);
       if(!isTokenExists(dto))  
           return null;
       ParameterMgr mgr = getParameterMgr();
       twitter.setOAuthConsumer(mgr.getConsumerKey().trim(), mgr.getConsumerKeySecret().trim());
       AccessToken accessToken = new AccessToken(dto.getAccessToken(),dto.getAccessTokenSecret());
       twitter.setOAuthAccessToken(accessToken);
       return twitter;
   }
   
   private boolean isTokenExists(TwitterAccountDTO dto) {
       if(dto.getAccessToken()== null || dto.getAccessTokenSecret()==null ||
               dto.getAccessToken().equals("") || dto.getAccessTokenSecret().equals("")) 
           return false;
       else return true;
   }
   
   public TwitterAccountDTO getByTwitterProfIdUsername(String profilePrefId, String twitterUsername) throws SVTException {
       return getTwitterAccountMgr().getByTwitterProfIdUsername(profilePrefId, twitterUsername);
   }
   
   /** 
    * This method is used to get the Lists created by the user in Twitter ("Lists By You")
    * @author SandipanM 
    **/
   public List<ListItemDTO> getUserList() throws IllegalStateException, Exception
   {

       // 1st use cached data, rate limit concern(don't hit twitter if not required)
       String mapKey = "";
       if(getFirstCustomerName() != null){
           mapKey = getFirstCustomerName();
       }
       long delayinSeconds = getParameterMgr().getDelayInSeconds();
       
       CachedListItemDTO dto = mapListItemDTO.get(mapKey);
       if(dto != null && ((System.currentTimeMillis() - dto.getDelayPeriod()) < (delayinSeconds *1000) )){
           System.out.println("UserList Cached data........[" +  mapKey + "]");
           return dto.getDtos();
       }
       
       dto = new CachedListItemDTO();
       dto.setDelayPeriod(System.currentTimeMillis());
       dto.setDtos(getUserListFromTwitter(getFirstCustomerName()));
       mapListItemDTO.put(mapKey, dto);
       return dto.getDtos();
   }
   
   private List<ListItemDTO> getUserListFromTwitter(String firstCustomerName2) throws IllegalStateException, Exception {
       Twitter twitter = validateTwitterObject(getFirstCustomerName());
       List<ListItemDTO> listByUser = new ArrayList<ListItemDTO>(); 
       try  {
           for(UserList list : twitter.getUserLists(getFirstCustomerName(), -1)){
               ListItemDTO dto =new ListItemDTO();
               dto.setId(""+list.getId());
               dto.setName(list.getName());
               listByUser.add(dto);
           }
       }  catch(Exception e)       {
           System.out.println("Error in Twitter Controller getUserList(). "+e.getMessage());
       }

    return listByUser;
}

@SuppressWarnings("unchecked")
   public List<TwitterInformationTopDTO> getListFromSession()   {
       return (List<TwitterInformationTopDTO>)getObjSessionAttribute(TwitterControllerConstants.GET_TWITTER_INFO_LIST);
   }
   
   public String sendTweetBasedOnRule() throws Exception    {

       String sideClicked = getParameter("sideClk");
       if(getParameter("index") == null){
           System.out.println("TwitterController.sendTweetBasedOnRule-Parameter('index') is null."); // This cannot be null, if so, there is bug in the code that needs to be handled...
           setActionTaken(false);
           return "";
       }
       int index = calculateFinalIndex(getParameter("index"));
       
       List<TwitterInformationTopDTO> twitterInfoList = getListFromSession();
       TwitterInformationDTO twitterInformationDTO = null;
       try {
           if (twitterInfoList!= null) {
               if (sideClicked.equalsIgnoreCase(TwitterControllerConstants.LEFT))  
                   twitterInformationDTO = twitterInfoList.get(index).getDtoLeft();
               else   
                   twitterInformationDTO = twitterInfoList.get(index).getDtoRight();
           }
           //validateTwitterObject(getFirstCustomerName()).updateStatus(getIndividualTweet());
           //replyOrGlobalMessage(getIndividualTweet(),getFirstCustomerName());
           //setActionTaken(true);
           setActionTaken(replyOrGlobalMessage(getIndividualTweet(),getFirstCustomerName()));
           saveRetweetReplySendTweet("",TwitterControllerConstants.SEND_TWEET, 
                   twitterInformationDTO.getTwitterStatusID(),getFirstCustomerName(),
                   twitterInfoList, sideClicked, index);
           setSessionAttribute("setOperated", true);
       } catch (Exception e) {
           //e.printStackTrace();
           System.out.println("Couldn't send the tweet: " + e.getMessage());
           setActionTaken(false);
       }
       return "";
   }
   
   /**
    * It retweet the same tweet message to the sender
    * @param index, @throws Exception, @throws IllegalStateException 
    */
   public void reTwittMessage(ActionEvent ae) throws IllegalStateException, Exception   {
       String sideClicked = getSessionAttribute("sideClicked");
       if(getSessionAttribute("clickSideIndex") == null){
           System.out.println("TwitterController.reTwittMessage-getSessionAttribute('clickSideIndex') is null."); // This cannot be null, if so, there is bug in the code that needs to be handled...
           setActionTaken(false);
       }
       int index = calculateFinalIndex(getSessionAttribute("clickSideIndex"));
       String originalTweet = "";
       String textToCheck = "";
       String twtScreenName = getParameter("twtScreenName");
       String reTweetMsg = getParameter("reTweetMsg");
       
       twtScreenName = "RT @" + twtScreenName + " ";
       List<TwitterInformationTopDTO> twitterInfoList = getListFromSession();
       TwitterInformationDTO twitterInformationDTO = null;
       long statusID=0l;
       Status status = null;
       try 
       {
           if (twitterInfoList!= null) {
              if (sideClicked.equalsIgnoreCase(TwitterControllerConstants.LEFT))  {
                   statusID = twitterInfoList.get(index).getDtoLeft().getTwitterStatusID();
                   twitterInformationDTO = twitterInfoList.get(index).getDtoLeft();
               }  else   {
                   statusID = twitterInfoList.get(index).getDtoRight().getTwitterStatusID();
                   twitterInformationDTO = twitterInfoList.get(index).getDtoRight();
               }
           }
           
          originalTweet = validateTwitterObject(getFirstCustomerName()).showStatus(statusID).getText();
           textToCheck = reTweetMsg.substring(twtScreenName.length(), reTweetMsg.length());
           
           if(originalTweet!=null && reTweetMsg!=null)  {
               if(originalTweet.equals(textToCheck))  {
                   status = validateTwitterObject(getFirstCustomerName()).retweetStatus(statusID);
                   System.out.println("Retwitted : " + status.isRetweet() + " : "+status.getRetweetCount());
               }  else  {
                   //reTweetMsg = "RT @" + twtScreenName + " " + reTweetMsg;
                   validateTwitterObject(getFirstCustomerName()).updateStatus(getValidFormattedRetweetMessage(reTweetMsg));
                   System.out.println("Retwitted via RT : "+reTweetMsg);
               }
           }
           saveRetweetReplySendTweet("",TwitterControllerConstants.RETWEET, twitterInformationDTO.getTwitterStatusID(),
                                        getFirstCustomerName(), twitterInfoList, sideClicked, index);
           setSessionAttribute("setOperated", true);
           setActionTaken(true);
       }  catch(Exception e) {
               System.out.println("Couldn't retweet. "+e.getMessage());
               setActionTaken(false);
       }
   }
   
   /**
    * The tweet should be within 140 character in length. The extra characters will be 
    * truncated and will be replaced by ellipsis     
    * @param message
    * @return message
    * @author tapasb
    */
   private String getValidFormattedRetweetMessage(String message) {
       return ((message.length() <= 140) ? message : message.substring(0, 137) + "..."); 
   }
   
  /**
   * Retweet message
   */
   public Status reTweetMessage(long statusId, String screenName) throws IllegalStateException, TwitterException, Exception {
       Twitter twitter = validateTwitterObject(screenName);
       if(twitter != null)
           return twitter.retweetStatus(statusId);
       else return null;
       
   }
   /**
    * Reply and send tweet message
    */
    public boolean replyOrGlobalMessage(String message, String screenName) throws IllegalStateException, TwitterException, Exception {        
        long twittStatusID = 0;
        return sendWhatsHappenningTweet(message, screenName, twittStatusID);
    }


   /**
    * What's Happenning Tweet
    * This updates status in RTOPSchedule
    */
    private boolean replyOrGlobalMessage(String message, String screenName, String rtopScheduleId, String rtopGrade) throws IllegalStateException, TwitterException, Exception
    {
        long twittStatusID = 0;
        boolean success = sendWhatsHappenningTweet(message, screenName, twittStatusID);
        if(success)
        {
            // need to log the operation ( sending global tweet )
            FilterTwitterDataDTO persistDataDTO = new FilterTwitterDataDTO();
            persistDataDTO = setBasicInitialValues(null, TwitterControllerConstants.SEND_TWEET, persistDataDTO);
            persistDataDTO.setTwittStatusID(twittStatusID);
            persistDataDTO.setActionTakenOn(new Date());
            persistDataDTO.setTwitterUsername(screenName);
            persistDataDTO.setLoginProfileId(getCurrentProfileId());
            updateOrSaveOperations(persistDataDTO, TwitterControllerConstants.SAVE);
            
            RTOPScheduleDTO rtopScheduleDTO = new RTOPScheduleDTO();
            
            rtopScheduleDTO.setRtopScheduleId(rtopScheduleId);
            rtopScheduleDTO.setTweetMessage(message);
            rtopScheduleDTO.setGrade(rtopGrade);
            rtopScheduleDTO.setStatus(3); // remove tweet
            getRTOPScheduleMgr().updateStatus(rtopScheduleDTO);
        }
        return success;
    }
    
    private boolean sendWhatsHappenningTweet(String message, String screenName, long twittStatusID) throws Exception, JSONException, TwitterException
    {
        //validateTwitterObject(getFirstCustomerName()).updateStatus(getReplyMessage(),statusID);
        Twitter twitter = validateTwitterObject(screenName);
        if(twitter != null)
        {
            GeoLocation geoLocation = getSelectedGeoLatLng(getParameter("locForTweet"));
            if(geoLocation != null)
                twittStatusID = twitter.updateStatus(message,geoLocation).getId();
            else
                twittStatusID = twitter.updateStatus(message).getId();
            System.out.println("Message sent."+message);
            return true;
        }
        return false;
    }
    
    public GeoLocation getSelectedGeoLatLng(String location) throws JSONException {
        GeoLocation geoLocation = null;
        try {
                String [] latLng = new FindLocationOrLatLng()
                   .getLocationOrLatLng(location,FindLocationOrLatLng.BY_LAT_LNG)
                   .split(",");  
                geoLocation = new GeoLocation(Double.parseDouble(latLng[1].trim()),
                                              Double.parseDouble(latLng[0].trim()));
        }   catch(Exception e) {
            System.out.println("GeoLocationError : "+e.getMessage());
        }
        return geoLocation;
    }
   /**
    * It replies the given tweet message to the sender
    * @param index, @throws TwitterException, @throws IOException 
    */
   public void replyToTweet(ActionEvent ae) throws Exception    {
       String sideClicked = getSessionAttribute("sideClicked");
       int index = calculateFinalIndex(getSessionAttribute("clickSideIndex"));
       TwitterInformationDTO twitterInformationDTO = null;
       long statusID=0l;
       try {
           List<TwitterInformationTopDTO> twitterInfoList = getListFromSession();
           if (getTwitterInfoList() != null)    {
               if (sideClicked.equalsIgnoreCase(TwitterControllerConstants.LEFT)) {
                   statusID = twitterInfoList.get(index).getDtoLeft().getReplyStatusID();
                   twitterInformationDTO = twitterInfoList.get(index).getDtoLeft();
               } else {
                   statusID = twitterInfoList.get(index).getDtoRight().getReplyStatusID();
                   twitterInformationDTO = twitterInfoList.get(index).getDtoRight();
               }
               //validateTwitterObject(getFirstCustomerName()).updateStatus(getReplyMessage(),statusID);
               //replyOrGlobalMessage(getReplyMessage(),getFirstCustomerName());
               setActionTaken(replyOrGlobalMessage(getReplyMessage(),getFirstCustomerName()));
               //setActionTaken(true);
               saveRetweetReplySendTweet("",TwitterControllerConstants.REPLY, twitterInformationDTO.getTwitterStatusID(),getFirstCustomerName(),
                           twitterInfoList, sideClicked, index);
               setSessionAttribute("setOperated", true);
           }
       }  catch(Exception e) {
           System.out.println("Couldn't reply");
           setActionTaken(false);
       }
   }
   
   public void saveRetweetReplySendTweet(String toWhom, 
           String operationMode, long twittStatusID, String twitterUsername,List<TwitterInformationTopDTO> twitterInfoList, 
           String sideClicked,int index) throws SVTException    {
       /**
        * TODO : For now, It is not storing the 'toWhom' information to the database for 
        * "Re-tweet" and "Send Tweet" operation, becuase retweet, tweets the same message to all of its followers
        * and "Send Tweet" will be global tweet with reference(bitly/negative/hashtags etc). If required, 
        * we can store all the followers name later on.
        */
       
       FilterTwitterDataDTO persistDataDTO = new FilterTwitterDataDTO();
       persistDataDTO = setBasicInitialValues(toWhom, operationMode, persistDataDTO);
       persistDataDTO.setTwittStatusID(twittStatusID);
       persistDataDTO.setActionTakenOn(new Date());
       persistDataDTO.setTwitterUsername(twitterUsername);
       persistDataDTO.setLoginProfileId(getCurrentProfileId());
       updateOrSaveOperations(persistDataDTO, TwitterControllerConstants.SAVE);
       twitterInfoList =removeListDataAfterPersist(twitterInfoList, index, sideClicked);
    }
   /**
    * removes the data after taking operation(reply, re-tweet or send tweet) on it.
    * @param twitterInfoList, @param index, @param sideClicked, @return
    */
   private List<TwitterInformationTopDTO> removeListDataAfterPersist(List<TwitterInformationTopDTO> twitterInfoList,
           int index, String sideClicked) {
       if(sideClicked.equalsIgnoreCase(TwitterControllerConstants.LEFT))   
           twitterInfoList.get(index).setDtoLeft(null);
       else    
           twitterInfoList.get(index).setDtoRight(null);
       return twitterInfoList;
   }
   
   private FilterTwitterDataDTO setBasicInitialValues(String toWhom, String operationMode, 
                                                                       FilterTwitterDataDTO persistDataDTO) {
        if(operationMode.equalsIgnoreCase(TwitterControllerConstants.REPLY))  {
            persistDataDTO.setReply(true);
            persistDataDTO.setToWhom(toWhom);
        }
        else if(operationMode.equalsIgnoreCase(TwitterControllerConstants.SEND_TWEET))
            persistDataDTO.setSendTweet(true);
        
        else if(operationMode.equalsIgnoreCase(TwitterControllerConstants.RETWEET))
            persistDataDTO.setRetweet(true);
        return persistDataDTO;
   }

   public String getFirstCustomerName()   {
     try {
            if(getClickedCustomer() == null || getClickedCustomer().equals(""))
                return getChannelPerformanceController().getTwitterAccount().get(0).getTwitterUsername();
            else return getClickedCustomer();
     } catch(Exception e){ return "";}
   }

   public void autenticateTwitterUser(ActionEvent ae) throws IllegalStateException, Exception {
        setSessionAttribute("from", getParameter("from"));
        //setSessionAttribute("forAuthName", getParameter(TwitterControllerConstants.AUTH_NAME));
        setSessionAttribute("buttonSource", ae.getComponent().getId());
        twittMessage(ae);
    }
    
    public void filterClickListener(ActionEvent ae) throws Exception    {
        String filterStr = ae.getComponent().getId();
        setSessionAttribute(TwitterControllerConstants.FILTER_STRING,filterStr);
        setFilterString(filterStr);
        twittMessage(ae);
    }

    public void openCloseWindow(ActionEvent ae) throws IllegalStateException, Exception    {
            twittMessage(ae);
    }
    
    public List<TwitterInformationTopDTO> getTwitterInfoList() throws Exception {
        if(getParameter("individualTweet") != null)
            setIndividualTweet(getParameter("individualTweet").toString());
        return twitterInfoList;
    }
    
    public void setTwitterInfoList(List<TwitterInformationTopDTO> twitterInfoList) {
        this.twitterInfoList = twitterInfoList;
    }
    
    public String stringNormalForm(String str)    {
      if(str.equalsIgnoreCase(TwitterControllerConstants.ALL))                 return TwitterControllerConstants.OFF;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.BITLY))          return TwitterControllerConstants.BIT_LY;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.NEGATIVE))       return TwitterControllerConstants.NEGATIVE_SENTIMENT;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.POSITIVE))       return TwitterControllerConstants.POSITIVE_SENTIMENT;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.HASHTAG))        return TwitterControllerConstants.HASHTAG_LABEL;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.THEME))          return TwitterControllerConstants.THEME_LABEL;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.BRAND))          return TwitterControllerConstants.BRAND_MENTION;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.PRODUCT))        return TwitterControllerConstants.PRODUCT_MENTION;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.INDUSTRY))       return TwitterControllerConstants.INDUSTRY_MENTION;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.ALL_MENTIONS))   return TwitterControllerConstants.ALL_MENTION;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.INFLUENCER))     return TwitterControllerConstants.INFLUENCER_LABEL;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.MENTION))        return TwitterControllerConstants.HANDLE_MENTION;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.COMPMENTION))        return TwitterControllerConstants.HANDLE_COMPMENTION;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.FOLLOWING))      return TwitterControllerConstants.FOLLOWING_LABEL;
      else if(str.equalsIgnoreCase(TwitterControllerConstants.LIST))           return TwitterControllerConstants.LIST_LABEL;
    
    return TwitterControllerConstants.OFF;
    }

    private int calculateFinalIndex(String index)   {
        int idx = Integer.parseInt(index);
        if(idx == 2) 
            return (idx-1);
        
        else if(idx %2 == 0 && idx >2) 
            return (idx/2);
        
        else if(idx %2 !=0 && idx==1) 
            return (idx/2);
        
        else if(idx%2 !=0) 
            return ((idx-1)/2);
        
        return 0;
    }
    
    public SelectItem[] getTwitterAccounts()
    {
        List<TwitterAccountDTO> twtAccList = getTwitterAccount();
        if(twtAccList !=null && twtAccList.size()>0) {
            SelectItem[] acc = new SelectItem[twtAccList.size()];
            
            for (int i = 0; i <twtAccList.size(); i++) {
                acc[i] = new SelectItem();
                acc[i].setLabel("@"+twtAccList.get(i).getTwitterUsername().replace(" ","").replace("#", ""));
                acc[i].setValue("@"+twtAccList.get(i).getTwitterUsername().replace(" ","").replace("#", ""));
            }
            return acc;
        }
        return null;
    }

     /**
     *  Method used to get the size of tweet list. Used to display message "No Result" in Channel Optimization tab if no tweet available 
     *  Refer Optimizer_Test 1.6.ppt --> slide 43
     *  @return boolean
     */
    public boolean getTweetInfoList()    {
        if(twitterInfoList == null)
            return false;
        else
            return  twitterInfoList.size() > 0 ? true : false ;
    }
    
  //commented on 23-05-2011
    /* @SuppressWarnings("unchecked")
     private void setNearByLocationFromSession() {
         if(getObjSessionAttribute(NEAR_BY_LOC) != null )   
             setGeoLocationListOfHandler((List<String>)getObjSessionAttribute(NEAR_BY_LOC));
     }*/
    
    public void closeButtonOperation(ActionEvent ae) {
        System.out.println("closeButtonOperation called !!!!!!!!!!!!!!!!!!!!!! : "+ae.getComponent().getId());
        setYourLocation(GETTING_YOUR_LOCATION);
        setLocationToSession(getYourLocation());
    }
    
    
    /***
     * 
     * This method is used to retrieve the list of scheduled un-sent tweets from DB for the selected handler.
     * This method is invoked from 'whatsHappening.jsp'
     * 
     * @return scheduledList
     * @throws Exception 
     * 
     ***/
    
    public List<RTOPScheduleDTO> getScheduledTweets() throws Exception
    {
        List<RTOPScheduleDTO> scheduledList = new ArrayList<RTOPScheduleDTO>();
        String twitterUserName = getFirstCustomerName();
        
        TwitterAccountDTO accountDTO = getTwitterAccountMgr().getByTwitterProfIdUsername(getCurrentProfileId(), twitterUserName);
        
        if(accountDTO != null && accountDTO.getTwitterAccount() != null)
        {
            scheduledList = getRTOPScheduleMgr().getByTwitterAccountScheduledTweetDTO(accountDTO.getTwitterAccountId());
        }
        
        return scheduledList;
    }
    
    public void setFirstCustomerName(String firstCustomerName) {
        this.firstCustomerName = firstCustomerName;
    }
    public String getGeoLatLong() {
        return geoLatLong;
    }

    public void setGeoLatLong(String geoLatLong) {
        this.geoLatLong = geoLatLong;
    }
    
    public boolean isOperated() {
        return operated;
    }
    public void setOperated(boolean operated) {
        this.operated = operated;
    }
    public int getClickedIndex() {
        return clickedIndex;
    }
    public void setClickedIndex(int clickedIndex) {
        this.clickedIndex = clickedIndex;
    }
    public String getTotalClicked() {
        return totalClicked;
    }
    public void setTotalClicked(String totalClicked) {
        this.totalClicked = totalClicked;
    }
    public String getSideClicked() {
        return sideClicked;
    }
    public void setSideClicked(String sideClicked) {
        this.sideClicked = sideClicked;
    }
    public boolean isAvailableList() {
        return availableList;
    }
    public void setAvailableList(boolean availableList) {
        this.availableList = availableList;
    }
    public String getClickedCustomer() {
        return clickedCustomer;
    }
    public void setClickedCustomer(String clickedCustomer) {
        this.clickedCustomer = clickedCustomer;
    }
    public String getOpenEditProfile() {
        return openEditProfile;
    }
    public void setOpenEditProfile(String openEditProfile) {
        this.openEditProfile = openEditProfile;
    }
    public String getOwnerProfileImage() {
        return ownerProfileImage;
    }
    public void setOwnerProfileImage(String ownerProfileImage) {
        this.ownerProfileImage = ownerProfileImage;
    }
    public boolean isValidCredentials() {
        return isValidCredentials;
    }
    public void setValidCredentials(boolean isValidCredentials) {
        this.isValidCredentials = isValidCredentials;
    }
    public boolean isLoadRefreshPage() {
        return loadRefreshPage;
    }
    public void setLoadRefreshPage(boolean loadRefreshPage) {
        this.loadRefreshPage = loadRefreshPage;
    }

    public String getFilterString() {
        return stringNormalForm(filterString);
    }

    public void setFilterString(String filterString) {
        this.filterString = filterString;
    }
    public ChannelPerformanceController getChannelPerformanceController() {
        return channelPerformanceController;
    }

    public void setChannelPerformanceController(
            ChannelPerformanceController channelPerformanceController) {
        this.channelPerformanceController = channelPerformanceController;
    }
    
    public String getGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(String geoEnabled) {
        this.geoEnabled = geoEnabled;
    }
    private List<TwitterInformationTopDTO> twitterInfoList;

    public String getTwtmessage() {
        return twtmessage;
    }

    public void setTwtmessage(String twtmessage) {
        this.twtmessage = twtmessage;
    }
   
    public String getIndividualTweet() {
        return individualTweet;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }

    public boolean isActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(boolean actionTaken) {
        this.actionTaken = actionTaken;
    }

    public String getSearchGEOLocation() {
        return searchGEOLocation;
    }

    public void setSearchGEOLocation(String searchGEOLocation) {
        this.searchGEOLocation = searchGEOLocation;
    }

    public boolean isSearchGeolocationFieldBlank() {
        return searchGeolocationFieldBlank;
    }

    public void setSearchGeolocationFieldBlank(boolean searchGeolocationFieldBlank) {
        this.searchGeolocationFieldBlank = searchGeolocationFieldBlank;
    }
    
    public String getTwitterUsername() {
        return twitterUsername;
    }

    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    public String getYourLocation() {
        return yourLocation;
    }

    public void setYourLocation(String yourLocation) {
        this.yourLocation = yourLocation;
    }
    
    public boolean isAlwaysAskPopupOpen() {
        return alwaysAskPopupOpen;
    }

    public void setAlwaysAskPopupOpen(boolean alwaysAskPopupOpen) {
        this.alwaysAskPopupOpen = alwaysAskPopupOpen;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }
}