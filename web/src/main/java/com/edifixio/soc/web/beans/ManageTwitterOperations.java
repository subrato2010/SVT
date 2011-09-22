package com.edifixio.soc.web.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.http.AccessToken;
import twitter4j.http.RequestToken;

import com.edifixio.analysis.twt.KeywordFreq;
import com.edifixio.analysis.twt.TwitterLocalSearch;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.TwitLog;
import com.edifixio.soc.web.controllers.BaseWebObject;
import com.edifixio.soc.web.controllers.ReplyTwitterDataController;
import com.edifixio.soc.web.controllers.TwitterControllerConstants;
import com.edifixio.soc.web.controllers.UserProfileController;
import com.edifixio.soc.web.dto.BaseTwitterObject;
import com.edifixio.soc.web.dto.FilterTwitterDataDTO;
import com.edifixio.soc.web.dto.PicksTwitterObjectDTO;
import com.edifixio.soc.web.dto.Tweets;
import com.edifixio.soc.web.dto.TwitterActionsDTO;
import com.edifixio.soc.web.dto.TwitterInformationDTO;
import com.edifixio.soc.web.dto.TwitterInformationTopDTO;
import com.edifixio.soc.web.dto.TwitterObjectDTO;
import com.edifixio.soc.web.util.FilterSequence;
import com.google.gson.Gson;


public class ManageTwitterOperations extends BaseWebObject  {
    private static final String UNIQUEKEY = "s29082011889932s";
    private final static Log log = LogFactory.getLog(ManageTwitterOperations.class);
    private static final String RETWEET = "retweet";
    private static final String REPLY = "reply";
    private static final String GET_TWITTER_INFO_LIST = "getTwitterInfoList";
    private static final String SHOW_TWEET = "showTweet"; 
    
    private ReplyTwitterDataController replyTwitterDataController;

    private String filterString="All";
    
    private final int MAX_TWEET_IN_PAGE = 8;
    private String firstActionInfluencerTwitterAccounts = "";
    
   // private ActionsInfluencers actionInfluencersObj;
    
    int index;
    
    long id;
    long statusID;
    
    String status;
    String leftOrRight;
    
    public ReplyTwitterDataController getReplyTwitterDataController() {
        return replyTwitterDataController;
    }
    
    public void setReplyTwitterDataController(ReplyTwitterDataController replyTwitterDataController) {
        this.replyTwitterDataController = replyTwitterDataController;
    }   
    
    public TwitterAccountDTO getByTwitterProfIdUsername(String profilePrefId, String twitterUsername) throws SVTException {
        return getTwitterAccountMgr().getByTwitterProfIdUsername(profilePrefId, twitterUsername);
    }
    
    /**
     * After valid login to the twitter, it stores the access token and secrete to the database
     * 
     */
    public Twitter persistTokenAndSecrete(AccessToken accessToken,Twitter twitter, 
            RequestToken requestToken, String screenName,HttpServletRequest request,String verifier) throws TwitterException, SVTException
    {
        accessToken = twitter.getOAuthAccessToken(requestToken,verifier);
        String profileID = request.getSession().getAttribute("currentProfileId").toString();
        String aboutToAuthenticateUser = request.getSession().getAttribute("firstCustName").toString(); // for Selected handler
        
        TwitterAccountDTO accountDTO = getByTwitterProfIdUsername(profileID,getSessionAttribute("firstCustName"));
        if(aboutToAuthenticateUser.equalsIgnoreCase(twitter.getScreenName())) {
            accountDTO.setAccessToken(twitter.getOAuthAccessToken().getToken());
            accountDTO.setAccessTokenSecret(twitter.getOAuthAccessToken().getTokenSecret());
            accountDTO.setProfilePreferenceId(profileID);
            getTwitterAccountMgr().add(accountDTO);
            setSessionAttribute(TwitterControllerConstants.VALID_CREDENTIALS, true);
            
            setSessionAttribute("ownerImage", twitter.showUser(twitter.getId()).getProfileImageURL().toString());
            //TODO : Refactor later on
            try  {
                String location = twitter.showUser(screenName).getLocation();
                setSessionAttribute("location", (location.equals("") || location == null) ? "Add your location" : "from "+location);
            }  catch(Exception e) {
                  System.out.println("Location Error. "+e.getMessage());
            }
            screenName = twitter.getScreenName();
            System.out.println("Data Saved Successfully..................................");
        }  else   {
            System.out.println("The given user credentials are not valid, please try again !!!");
            request.getSession().setAttribute(TwitterControllerConstants.MSG,"");
            setSessionAttribute(TwitterControllerConstants.VALID_CREDENTIALS, false);
            setSessionAttribute(GET_TWITTER_INFO_LIST, 
                                        setLeftRightView(new ArrayList<TwitterInformationTopDTO>()));
           
        }
        String profileType = getSessionAttribute("actionTakenOnPopup");
        
        if(profileType != null) {
            if(profileType.equalsIgnoreCase("editProfile") || profileType.equalsIgnoreCase("createProfile"))
                request.getSession().setAttribute(TwitterControllerConstants.MSG,"");
        }
        return twitter;
    }
    
    /**
     * 
     * @param twitter
     * @param requestToken
     * @param verifier
     * @param accessToken
     * @param request
     * @param response
     * @param flag
     * @throws Exception 
     */
    public void createInstances(Twitter twitter, RequestToken requestToken,
            String verifier, AccessToken accessToken,
            HttpServletRequest request, HttpServletResponse response,
            boolean flag)
            throws Exception {
       
        boolean individualTwt = false;

        String screenName="";
        setFilterString(getSessionAttribute("filterString"));
        
        if(getFilterString() == null) setFilterString("All");
        try {
            if(accessToken == null)            {
                 twitter = persistTokenAndSecrete(accessToken, twitter,requestToken, 
                                                     screenName, request, verifier);   
            }
        } catch (Exception e) {
            request.getSession().setAttribute(TwitterControllerConstants.MSG,"");
            setSessionAttribute(TwitterControllerConstants.VALID_CREDENTIALS, false);
            System.out.println("Exception : Credentials not valid or twitter operation cancelled by user. "+e.getMessage());
            setSessionAttribute(GET_TWITTER_INFO_LIST, 
                                        setLeftRightView(new ArrayList<TwitterInformationTopDTO>()));
            //e.printStackTrace();
        }
        
        if(accessToken != null) {
            screenName = twitter.getScreenName();
            setSessionAttribute("profileImage",twitter.showUser(screenName).getProfileImageURL().toString());
        }
        
        //String buttonSource =request.getSession().getAttribute("buttonSource").toString(); 
        if(request.getSession().getAttribute("buttonSource") !=null) {
            if(request.getSession().getAttribute("buttonSource").toString().equalsIgnoreCase("createProfile"))
                request.getSession().setAttribute(TwitterControllerConstants.MSG,"");
        }
       operateOnTwitter(twitter, request, response,flag, 
                                   individualTwt, screenName);
    }

    public void operateOnTwitter(Twitter twitter, HttpServletRequest request, HttpServletResponse response, boolean flag,
            boolean individualTwt, String screenName) throws Exception {
            
                try {
                    
                    if (request.getSession().getAttribute(TwitterControllerConstants.MSG) != null && 
                            !(request.getSession().getAttribute(TwitterControllerConstants.MSG).equals(""))) {
                        if (request.getSession().getAttribute(TwitterControllerConstants.MSG).equals(SHOW_TWEET)) {
                                setSessionAttribute(GET_TWITTER_INFO_LIST, getTwitterInformationList(twitter,screenName));
                            flag = true;
                        } 
                        request.getSession().setAttribute(TwitterControllerConstants.MSG, "");
                    }
                    //For persist to the database after clicking on refreshList button in the page
                    else if(request.getSession().getAttribute("auth") != null && !(request.getSession().getAttribute("auth").equals("")))
                    {
                        boolean openCloseCreate = false;
                        boolean openCloseEdit = false;
                        
                        if(getSessionAttribute("from").equals("createProfileAuth"))
                            openCloseCreate = true;
                        else
                        {
                            openCloseEdit = true;
                            //setSessionAttribute("showPopup", "editProfileAuth");
                            setSessionAttribute("from", "");
                            request.getSession().setAttribute("auth", "");
                        }
                    }
            } catch (TwitterException e) {
                System.out.println("Error Generated Inside Manage TwitterOperation. "+e.getMessage());
            }
            
            if (flag == true || individualTwt == true)
            {
                System.out.println(12345);
                response.sendRedirect("./twitterChannelOptimization.jsp?refresh=0");
            }
            else
                response.sendRedirect("./twt.jsp");
    }

    /**
     * Persists to the database according to which the operations are takes
     * place over the tweet message
     * 
     * @param idx
     * @param clickSide
     * @param operationType
     * @throws TwitterException
     * @throws SVTException
     * @throws IOException 
     */
    @SuppressWarnings("unchecked")
    public  FilterTwitterDataDTO  collectValuesForPersist(int idx, String clickSide,
            String operationType, FilterTwitterDataDTO filterTwitterData) throws TwitterException, SVTException, IOException {
        
        filterTwitterData = new FilterTwitterDataDTO();
        if (clickSide.equals("Left")) {
            
            filterTwitterData.setTweetMessage(getTwitterInfoList().get(idx).getDtoLeft().getTwittMessage());
            filterTwitterData.setToWhom(getTwitterInfoList().get(idx).getDtoLeft().getTwitterName());
            filterTwitterData.setFrom(getTwitterInfoList().get(idx).getDtoLeft().getLoggedInName());
            filterTwitterData.setTwittStatusID(getTwitterInfoList().get(idx).getDtoLeft().getTwitterStatusID());
        } else {
            
            filterTwitterData.setTweetMessage(getTwitterInfoList().get(idx).getDtoRight().getTwittMessage());
            filterTwitterData.setToWhom(getTwitterInfoList().get(idx).getDtoRight().getTwitterName());
            filterTwitterData.setFrom(getTwitterInfoList().get(idx).getDtoRight().getLoggedInName());
            filterTwitterData.setTwittStatusID(getTwitterInfoList().get(idx).getDtoRight().getTwitterStatusID());
        }
        filterTwitterData.setActionTakenOn(new Date());
        if (clickSide.equals(REPLY)) {
            filterTwitterData.setRetweet   (false);
            filterTwitterData.setReply     (true);
            filterTwitterData.setSendTweet (false);
        } else if(clickSide.equals(RETWEET)){
            filterTwitterData.setRetweet   (true);
            filterTwitterData.setReply     (false);
            filterTwitterData.setSendTweet (false);
        } else {
            filterTwitterData.setRetweet   (false);
            filterTwitterData.setReply     (false);
            filterTwitterData.setSendTweet (true);
        }
        return  filterTwitterData;
    }


    @SuppressWarnings("unchecked")
    public  List<TwitterInformationTopDTO> getTwitterInfoList() {
        List<TwitterInformationTopDTO> infoList =(List<TwitterInformationTopDTO>)getObjSessionAttribute(GET_TWITTER_INFO_LIST);
        if(infoList != null)
            return infoList;
        return null;
    }
    
    /**
     * It collects the Twitter Timeline informations and stored inside the array
     * list(Left and Right). then that particular array list will again attached
     * with the main array list.
     * 
     * @return
     * @throws TwitterException
     * @throws SVTException
     * @throws IllegalStateException
     */
    boolean isManupulate = false;
    
    @SuppressWarnings("unchecked")
    public List<TwitterInformationTopDTO> getTwitterInformationList(Twitter twitter, String screenName) throws Exception
    {
        System.out.println("Starting RTO ----------------------------------------");
        long startTime = System.currentTimeMillis();

        
        //List<Status> response = getResponseStatus(twitter, screenName);
        
        //Get all exist message ID from database
        ArrayList<String> twtMsgExcludeIDs = new ArrayList<String>();
        //TwitterLocalSearch twtLocalSearch = new TwitterLocalSearch();
        
        //The words which is mentioned in the list will not search.
        //twtLocalSearch.setStopWordsTrendIndex(TwtStopWords.getInstance().getAllStopWords());
        
       
        //List<String> stopWordsSearch = Arrays.asList("ddddd");
        //twtLocalSearch.setStopWordsSearchIndex(stopWordsSearch);
        
        System.out.println("Inside Manage Twitter Operation Screen Name : "+screenName);
        List<TwitLog> twtIDList =  getTwitLogMgr().findByTwitterUsername(screenName, new Date()); //Collect the Tweet IDs from the database, if exist.
        for(TwitLog scrName : twtIDList)
            twtMsgExcludeIDs.add(scrName.getTwittStatusId().toString());
        
        //Object[] objTrendsTwts = twtLocalSearch.getKeywordAndHashTrends(response, 10, 5, true, 
                //twtMsgExcludeIDs, twitter.getScreenName(), true); // It provides Theme, Hashtags and no. of tweets as [0],[1],[2] respectively
        
        List<TwitterInformationDTO> informationListDto=new ArrayList<TwitterInformationDTO>();
        
        if(getFilterString().equalsIgnoreCase(TwitterControllerConstants.THEME)){ 
            //informationListDto = getKeyWordBasedTwt(objTrendsTwts,twtLocalSearch,twitter.getScreenName(),false, null, MAX_TWEET_IN_PAGE); //Theme based
            setSentimentFromJSONObject(informationListDto, screenName, "collectThemes", twtMsgExcludeIDs, null);
        }
        else if (getFilterString().equalsIgnoreCase(TwitterControllerConstants.HASHTAG)){  
            //informationListDto = getKeyWordBasedTwt(objTrendsTwts,twtLocalSearch,twitter.getScreenName(),true, null, MAX_TWEET_IN_PAGE); //Hashtag based
            setSentimentFromJSONObject(informationListDto, screenName, "collectHashtags", twtMsgExcludeIDs, null);
        }
        else if (getFilterString().equalsIgnoreCase(TwitterControllerConstants.BITLY)) { 
            //informationListDto = getBitlyBasedTweets(objTrendsTwts,twtLocalSearch, twitter.getScreenName(),null,MAX_TWEET_IN_PAGE);
            setSentimentFromJSONObject(informationListDto, screenName, "collectBitly", twtMsgExcludeIDs, null);
        }
        else if(getFilterString().equalsIgnoreCase(TwitterControllerConstants.NEGATIVE)) {
          //informationListDto = getPositiveNegativeBasedTweets(objTrendsTwts,twtLocalSearch, false,null,MAX_TWEET_IN_PAGE);
          setSentimentFromJSONObject(informationListDto, screenName, "collectNegative", twtMsgExcludeIDs, null);
        }            
        else if(getFilterString().equalsIgnoreCase(TwitterControllerConstants.POSITIVE)){  
            //informationListDto = getPositiveNegativeBasedTweets(objTrendsTwts,twtLocalSearch,true,null,MAX_TWEET_IN_PAGE);
            setSentimentFromJSONObject(informationListDto, screenName, "collectPositive", twtMsgExcludeIDs, null);
        }
        else if(getFilterString().equalsIgnoreCase(TwitterControllerConstants.INFLUENCER)) { 
            //informationListDto  = getInfluencerBasedTweets(objTrendsTwts,twtLocalSearch, null,MAX_TWEET_IN_PAGE);
            setSentimentFromJSONObject(informationListDto, screenName, "collectInfluence", twtMsgExcludeIDs, null);
        }
        else if(getFilterString().equalsIgnoreCase(TwitterControllerConstants.BRAND)) { 
            setSentimentFromJSONObject(informationListDto, screenName, "collectBrand", twtMsgExcludeIDs, null);
        }else if(getFilterString().equalsIgnoreCase(TwitterControllerConstants.PRODUCT)) { 
            setSentimentFromJSONObject(informationListDto, screenName, "collectProduct", twtMsgExcludeIDs, null);
        }else if(getFilterString().equalsIgnoreCase(TwitterControllerConstants.INDUSTRY)) { 
             setSentimentFromJSONObject(informationListDto, screenName, "collectIndustry", twtMsgExcludeIDs, null);
        }else if(getFilterString().equalsIgnoreCase(TwitterControllerConstants.MENTION)) { 
             setSentimentFromJSONObject(informationListDto, screenName, "collectMention", twtMsgExcludeIDs, null);
        }else if(getFilterString().equalsIgnoreCase(TwitterControllerConstants.COMPMENTION)) { 
             setSentimentFromJSONObject(informationListDto, screenName, "collectCompetitor", twtMsgExcludeIDs, null);
        }else if(getFilterString().equalsIgnoreCase(TwitterControllerConstants.FOLLOWING)) { 
            //informationListDto = getAllTweets(objTrendsTwts, twtLocalSearch, twitter.getScreenName());
            setSentimentFromJSONObject(informationListDto, screenName, "following", twtMsgExcludeIDs, null);
        }else if(getFilterString().equalsIgnoreCase(TwitterControllerConstants.LIST)){
            //informationListDto = getAllTweets(objTrendsTwts, twtLocalSearch, twitter.getScreenName());
            setSentimentFromJSONObject(informationListDto, screenName, "list", twtMsgExcludeIDs, getParameter("listid"));
        }else if(getFilterString().equalsIgnoreCase(TwitterControllerConstants.ALL) || 
                                        getFilterString().equalsIgnoreCase(TwitterControllerConstants.OFF))  {
            //informationListDto = getAllTweets(objTrendsTwts, twtLocalSearch, twitter.getScreenName());
            setSentimentFromJSONObject(informationListDto, screenName, "all", twtMsgExcludeIDs, null);
        }
        System.out.println("Filter Type : "+getFilterString());
        //twtLocalSearch.closeStore();
        
        System.out.println("time taken by 'getTwitterInformationList' (fetch 8 tweet method =)" + (System.currentTimeMillis() - startTime));
        
        long l = System.currentTimeMillis();
        List  list =  setLeftRightView(informationListDto);
        
        System.out.println("tiem to set l-r view" + (System.currentTimeMillis() - l));
        
        return list;
    }

    public List setLeftRightView(List arAllDto)
    {
        System.out.println("Size arAllDto.size()=" +arAllDto.size());
     List<TwitterInformationTopDTO> informationDTOList = new ArrayList<TwitterInformationTopDTO>();
        for(int j = 0; j < arAllDto.size(); j++)      {
            TwitterInformationTopDTO lineDto = new TwitterInformationTopDTO();
            lineDto.setDtoLeft((TwitterInformationDTO)arAllDto.get(j));
            if(j+1 < arAllDto.size())  {
                lineDto.setDtoRight((TwitterInformationDTO)arAllDto.get(j+1));
            }
            j++;  
            informationDTOList.add(lineDto);
        }
        return informationDTOList;
    }
    
    
    public String getBitlyUrlString(String twtMsg)
    {
        int place = 0; 
        String fullBitlyURL="";
        String[] tempMsgArr = twtMsg.trim().split(" ");
        for (String bitly : tempMsgArr) {
            if(bitly.startsWith("http://bit.ly/"))   {
                fullBitlyURL = tempMsgArr[place];
                break;
            }
            place++; 
        }
        return fullBitlyURL;
    }
    
    /**
     * Add the value in the database.
     * 
     * @param filterTwitterDataDTO
     * @throws SVTException
     */
    public void updateOrSaveOperations(FilterTwitterDataDTO filterTwitterData, String operation)
    throws SVTException {
        if(operation.equalsIgnoreCase("save"))
            getTwitLogMgr().add(filterTwitterData);
        else
            getTwitLogMgr().update(filterTwitterData);
    }

    /*public String getActualAvatarImageURL(Twitter twitter, Status twittStatus,String message) 
                    throws TwitterException    {
        if(message.contains("RT"))  {
            try  {
                String arr[] = message.split(" ");
                String urlString="";
                int idx = 0;
                for(String temp : arr) {
                    idx++;
                    if(temp.startsWith("RT"))  {
                        String userName = arr[idx].substring(1,arr[idx].length()-1);
                        List<Status> response = twitter.getUserTimeline(userName);
                        urlString = response.get(0).getUser().getProfileImageURL().toString();
                    }
                }
                return urlString;
            }catch(Exception e){
            }
        }
        return twittStatus.getUser().getProfileImageURL().toString();
    }*/
    

   /* public List<String> collectAllTrends(boolean flag, Twitter twitter) throws TwitterException {
        List<String> trendsList = new ArrayList<String>();
        Trends trnds = twitter.getCurrentTrends(flag); // Removes all HashTags
        for (int j = 0; j < trnds.getTrends().length; j++)
            trendsList.add(trnds.getTrends()[j].toString());
        trendsList = parseByTags(trendsList, flag);
        return trendsList;
    }
   */

    /*public ArrayList<String> parseByTags(List<String> trendsList, boolean flag) {
        ArrayList<String> temp = new ArrayList<String>();
        for (String text : trendsList) {
            String arr[] = text.split(",");
            if (flag == true) {
                arr[0] = (arr[0].replace("TrendJSONImpl{name=", "").replace(
                        "'", "")).trim().toLowerCase();
                temp.add(arr[0]);
            } else {
                arr[0] = (arr[0].replace("TrendJSONImpl{name=", "").replace(
                        "'", "")).trim().toLowerCase();
                if (arr[0].charAt(0) == '#')
                    temp.add(arr[0]);
            }
        }
        return temp;
    }*/

    public List<Object> filterForAllAtMentions(String mentionString, String message)
    {
        return null;
    }

    public String getFilterString() {
        return filterString;
    }

    public void setFilterString(String filterString) {
        this.filterString = filterString;
    }
    
    public ManageTwitterOperations() throws TwitterException    {
        if(getSessionAttribute("filterString") == null )
            setFilterString("OFF");
        else setFilterString(getSessionAttribute("filterString"));
    }
    
    private void setSentimentFromJSONObject(
        List<TwitterInformationDTO> informationListDto, String screenName,String jsonApiName, ArrayList<String> twtMsgExcludeIDs, String twitterListId) throws SVTException {        
        String json = readFromURL(getDatashiftAPIURL(jsonApiName, screenName, twitterListId));
        Gson gson = new Gson(); // json-1.7.1
        
        //convert JSON into java object
        BaseTwitterObject obj = (BaseTwitterObject)gson.fromJson(json, getClassName(jsonApiName)); // Factory Pattern
        if(obj == null){
            System.out.println("no data received from Datashift API...");
            return;
        }
        if(obj.getTweets() == null){
            System.out.println("incomplete data received from Datashift API...");
            return;            
        }
        int iMaxTwtCtr = 1;
        for(Tweets twt: obj.getTweets()){
            
            if(twtMsgExcludeIDs.contains(""+twt.getTweet_id())){
                //System.out.println(" Already Exist....: " + twt.getTweet_id());
                continue;
            }
            TwitterInformationDTO dtoDetails =  new TwitterInformationDTO();
            
            dtoDetails.setIs_friend(twt.isIs_friend());
            
            dtoDetails.setTwitterName(twt.getName());   //Twitter Name
            dtoDetails.setTwitterScreenName(twt.getScreen_name()); //Twitter Screen Name
            dtoDetails.setNoOfFollowers(twt.getFollowers_count());
            dtoDetails.setNoOfFollowings(twt.getFriends_count());
            dtoDetails.setNoOfListed(twt.getListed_count());
            dtoDetails.setNoOfTweets(twt.getStatuses_count());
            dtoDetails.setInfluence(twt.getInfluence());
            dtoDetails.setTwittLocation(twt.getLocation());
            dtoDetails.setTwittDate(twt.getCreated_at()); //twittDate and createdAt is same
            dtoDetails.setSource(twt.getSource());
            dtoDetails.setProfileImage(twt.getAvatar().trim());
            setTextAreaConstants(dtoDetails, jsonApiName, twt);
            dtoDetails.setTweetID(twt.getUser_id()); // userId
            dtoDetails.setTwitterStatusID(twt.getTweet_id());// status id of tweet
            dtoDetails.setRetwittable(false); //not yet implemented
            dtoDetails.setReplyStatusID(twt.getInreplytostatus_id());
            dtoDetails.setCreatedAt(getDate(twt.getCreated_at()));
            dtoDetails.setCnt(iMaxTwtCtr++); // td counter for UI loop
            informationListDto.add(dtoDetails);
            
            // Display max 8 tweets at a time
            /*if(iMaxTwtCtr > MAX_TWEET_IN_PAGE){
                break;
            }*/
        }
    }

    private String setTextAreaConstants(TwitterInformationDTO dtoDetails, String sentimentName, Tweets twt) {
        if(sentimentName.equalsIgnoreCase("all")){
            if(twt.getProcessing() != null){
                sentimentName = twt.getProcessing().getPicker();
            }
        }
        if(sentimentName == null){
            return "";
        }
        
        dtoDetails.setReferenceName(twt.getKeyword());
        twt.setText(twt.getText());
        dtoDetails.setFullTweetMsg(twt.getText());



        
        if(sentimentName.equalsIgnoreCase("collectNegative")){
            dtoDetails.setTextAreaImage(FilterSequence.NEGATIVE_IMG);
            dtoDetails.setTextAreaLogoTooltip(FilterSequence.NEGATIVE_TOOLTIP);
            dtoDetails.setTweetReferenceType(FilterSequence.NEGATIVE);
            dtoDetails.setBoxHeaderColor(TwitterControllerConstants.NEGATIVE_BOX_HEADER_COLOR); 
            dtoDetails.setReferenceName(twt.getProcessing().getCollectNegative());
        }
        else if(sentimentName.equalsIgnoreCase("collectPositive")){
            dtoDetails.setTextAreaImage(FilterSequence.POSITIVE_IMG);
            dtoDetails.setTextAreaLogoTooltip(FilterSequence.POSITIVE_TOOLTIP);
            dtoDetails.setTweetReferenceType(FilterSequence.POSITIVE);
            dtoDetails.setBoxHeaderColor(TwitterControllerConstants.NORMAL_BOX_HEADER_COLOR);
            dtoDetails.setReferenceName(twt.getProcessing().getCollectPositive());
        }
        else if(sentimentName.equalsIgnoreCase("collectBitly")){
            dtoDetails.setTextAreaImage(FilterSequence.BITLY_IMG);
            dtoDetails.setTextAreaLogoTooltip(FilterSequence.BITLY_TOOLTIP);
            dtoDetails.setTweetReferenceType(FilterSequence.BITLY);
            dtoDetails.setReferenceName(twt.getProcessing().getCollectBitly());
            //dtoDetails.setTwittMessage(addBitlyHyperlink(twt.getText(),twt.getKeyword()));
        }
        else if(sentimentName.equalsIgnoreCase("collectInfluence")){
            dtoDetails.setTextAreaImage(FilterSequence.INFLUENCER_IMG);
            dtoDetails.setTextAreaLogoTooltip(FilterSequence.INFLUENCER_TOOLTIP);
            dtoDetails.setTweetReferenceType(FilterSequence.INFLUENCER);
            dtoDetails.setReferenceName(twt.getProcessing().getCollectInfluence());
        }
        else if(sentimentName.equalsIgnoreCase("collectBrand")){
            dtoDetails.setTextAreaImage(FilterSequence.BRAND_IMG);
            dtoDetails.setTextAreaLogoTooltip(FilterSequence.BRAND_TOOLTIP);
            dtoDetails.setTweetReferenceType(FilterSequence.BRAND);
            dtoDetails.setReferenceName(twt.getProcessing().getCollectBrand());
        }
        else if(sentimentName.equalsIgnoreCase("collectProduct")){
            dtoDetails.setTextAreaImage(FilterSequence.PRODUCT_IMG);
            dtoDetails.setTextAreaLogoTooltip(FilterSequence.PRODUCT_TOOLTIP);
            dtoDetails.setTweetReferenceType(FilterSequence.PRODUCT);
            dtoDetails.setReferenceName(twt.getProcessing().getCollectProduct());
        }
        else if(sentimentName.equalsIgnoreCase("collectIndustry")){
            dtoDetails.setTextAreaImage(FilterSequence.INDUSTRY_IMG);
            dtoDetails.setTextAreaLogoTooltip(FilterSequence.INDUSTRY_TOOLTIP);
            dtoDetails.setTweetReferenceType(FilterSequence.INDUSTRY);
            dtoDetails.setReferenceName(twt.getProcessing().getCollectIndustry());
        }
        else if(sentimentName.equalsIgnoreCase("collectMention")){
            dtoDetails.setTextAreaImage(FilterSequence.INFLUENCER_IMG); // need to ask what image to implement?
            dtoDetails.setTextAreaLogoTooltip(FilterSequence.MENTION_TOOLTIP); // need to ask the tool-tip text?
            dtoDetails.setTweetReferenceType(FilterSequence.MENTION);
            dtoDetails.setReferenceName(twt.getProcessing().getCollectMention());
        }
        else if(sentimentName.equalsIgnoreCase("collectCompetitor")){
            dtoDetails.setTextAreaImage(FilterSequence.MENTIONCMPT_IMG);
            dtoDetails.setTextAreaLogoTooltip(FilterSequence.MENTIONCMPT_TOOLTIP); // need to ask the tool-tip text?
            dtoDetails.setTweetReferenceType(FilterSequence.MENTIONCMPT);
            dtoDetails.setReferenceName(twt.getProcessing().getCollectCompetitor());
        }
        else if(sentimentName.equalsIgnoreCase("collectThemes")){
            dtoDetails.setTextAreaImage(FilterSequence.THEME_IMG); // need to ask what image to implement?
            dtoDetails.setTextAreaLogoTooltip(FilterSequence.THEME_TOOLTIP);
            dtoDetails.setTweetReferenceType(FilterSequence.THEME);
            dtoDetails.setReferenceName(twt.getProcessing().getCollectThemes());
        }
        else if(sentimentName.equalsIgnoreCase("collectHashtags")){
            dtoDetails.setTextAreaImage(FilterSequence.HASHTAGS_IMG); // need to ask what image to implement?
            dtoDetails.setTextAreaLogoTooltip(FilterSequence.HASHTAGS_TOOLTIP);
            dtoDetails.setTweetReferenceType(FilterSequence.HASHTAGS);
            dtoDetails.setReferenceName(twt.getProcessing().getCollectHashtags());
        }
        else{
            // Picker is not sending the correct theme, so lets put defaultValue
            sentimentName="";
            dtoDetails.setTextAreaImage(FilterSequence.DEFAULT_IMG); //default
            dtoDetails.setTextAreaLogoTooltip(FilterSequence.FOLLOWING_TOOLTIP); // default value
            dtoDetails.setTweetReferenceType("FOLLOWING");
            dtoDetails.setReferenceName(twt.getKeyword());
            }
        
        dtoDetails.setTwittMessage(addBitlyHyperlink(twt.getText(),dtoDetails.getReferenceName(),dtoDetails.getTextAreaImage()));
        
        return "";
    }

    /**
     * Factory to get specific class
     * @param jsonApiName
     * @return
     */
    private Class getClassName(String jsonApiName) {
        if(jsonApiName.equalsIgnoreCase("all")){
            return PicksTwitterObjectDTO.class;
        }else{
            return TwitterObjectDTO.class;
        }
    }

    private String addBitlyHyperlink(String text, String stringToSearch, String textAreaImage){
        //System.out.println("inside addBitlyHyperlink : "+text);
        if(text != null) {
            return collectBiltyLinks(text, stringToSearch, textAreaImage);
            /*return text.replaceAll(stringToSearch, 
                    "<a style='font-size:13px;text-decoration: none;cursor: pointer' target='_blank' href='"+stringToSearch+"'>"+stringToSearch+"</a>");*/ 
       }
            return text;
    }
       
    private static String collectBiltyLinks(String text, String stringToSearch,String textAreaImage) {
        
        String imageTag = "<img src=\\\\'../images/" + textAreaImage + "\\\\'>"; //"<img src='../images/9.gif'>"
        
        
        Pattern pattern1 = Pattern.compile("(?<=[\\s])*@\\w+", Pattern.CASE_INSENSITIVE); //"@"
        Pattern pattern2 = Pattern.compile("http://", Pattern.CASE_INSENSITIVE);

        // taking care of some special case TODO: need to have some kind of logic for this...
        stringToSearch = stringToSearch.replaceAll("\\)", "\\\\)");
        // This is really f...... logic
        Matcher m2 = pattern2.matcher(text);
        List<String> searchList = new ArrayList<String>();
        Map<String,String> linkMap = new HashMap<String, String>();
        int ilink = 0;
        while (m2.find()) {
            int stpos = m2.start();
            int edpos = text.indexOf(" ",m2.start() + 1);
            if(edpos < 0){
                edpos = text.length();
            }
            String toReplace = text.substring(stpos,edpos);
            searchList.add(toReplace);
          }  
        for(String replaceString : searchList){
            String fromReplace = replaceString.replaceAll("\\)",""); // removing special character ")" 
            linkMap.put(UNIQUEKEY+ilink, replaceString);
            text = text.replaceAll(fromReplace,"<a target='_blank' href='"+UNIQUEKEY+(ilink++)+"'>"+fromReplace+"</a>");
        }
        
        Matcher m1 = pattern1.matcher(text);
        while (m1.find()) {
            String grp = m1.group();
            linkMap.put(UNIQUEKEY+ilink, "http://twitter.com/" + grp);
            text = text.replaceAll(grp,"<a target='_blank' href='"+UNIQUEKEY+(ilink++)+"'>"+grp+"</a>");
        }
        
        if(StringUtils.isNotBlank(stringToSearch)){
           
            String nonWordChars = "#:)(;";
            String prefix = stringToSearch.substring(0,1);

            if(nonWordChars.contains(prefix)){
                text = text.replaceAll("(?i)" + stringToSearch + "", "<span style='background-color: #B6D976; cursor: pointer;' onmouseover=\"instanceCount(this,'"+ stringToSearch + "',\'" + imageTag + "\', event)\">"+stringToSearch+"</span>"); // background color of matching text
            }
            else if(stringToSearch.startsWith("http://") || stringToSearch.startsWith("@")){
                text = text.replaceAll("(?i)>" + stringToSearch + "<", "><span style='background-color: #B6D976; cursor: pointer;' onmouseover=\"instanceCount(this,'"+ stringToSearch + "',\'" + imageTag + "\', event)\">"+stringToSearch+"</span><"); // background color of matching text
            }
            else{
                text = text.replaceAll("\\b(?i)" + stringToSearch + "(\\b|$)", "<span style='background-color: #B6D976; cursor: pointer;' onmouseover=\"instanceCount(this,'"+ stringToSearch + "',\'" + imageTag + "\', event)\">"+stringToSearch+"</span>"); // background color of matching text
            }
        }
        
        for(int j=0; j < ilink; j++){
            text = text.replaceAll(UNIQUEKEY+j, linkMap.get(UNIQUEKEY+j));
        }
        
        return text;
    }
    
    
    private String collectBiltyLinksOld(String text, String stringToSearch) {
        String arr[] = text.split(" ");
        for(int cnt = 0 ; cnt < arr.length; cnt++) {
            if(arr[cnt].contains("http://")){   
                text = text.replaceAll(arr[cnt],"<a style='font-size:13px;text-decoration: none;cursor: pointer' target='_blank' href='"+arr[cnt]+"'>"+arr[cnt]+"</a>");
            }
            if(arr[cnt].contains("@")){
                text = text.replaceAll(arr[cnt],"<a style='font-size:13px;text-decoration: none;cursor: pointer' target='_blank' href='http://twitter.com/"+arr[cnt].substring(1)+"'>"+arr[cnt]+"</a>"); 
            }
        }
        
        return text.replaceAll(stringToSearch, "<font style='background-color: lightblue;'>"+stringToSearch+"</font>");
    }
    
    private int getListId(String listId) {
        if(listId != null){
                return Integer.parseInt(listId); 
        }
        return 0;
    }


    
    /**
     * 
     * This method is used to get the first twitter account name for 'Influencers to Follow' popup
     * @throws SVTException
     * @return firstActionInfluencerTwitterAccounts
     * 
     * **/
    
    public String getFirstActionInfluencerTwitterAccounts() throws SVTException
    {
        String json = readFromURL(getDatashiftAPIURL("actions", null, null));
        Gson gson = new Gson(); // json-1.7.1
        
        //convert JSON into java object
        TwitterActionsDTO obj = gson.fromJson(json, TwitterActionsDTO.class);
        String firstActionInfluencerTwitterAccounts = "";
        
        if(this.firstActionInfluencerTwitterAccounts != null && this.firstActionInfluencerTwitterAccounts.trim().length() > 0)
        {
            firstActionInfluencerTwitterAccounts = this.firstActionInfluencerTwitterAccounts;
        }
        else
        {
            if(obj.getTwitter_accounts() != null && obj.getTwitter_accounts().size() > 0)
            {
                firstActionInfluencerTwitterAccounts = obj.getTwitter_accounts().get(0).getAccountname();
                
            }
        }
        return firstActionInfluencerTwitterAccounts;
    }

    public void setFirstActionInfluencerTwitterAccounts(String firstActionInfluencerTwitterAccounts)
    {
        this.firstActionInfluencerTwitterAccounts = firstActionInfluencerTwitterAccounts;
    }

    private String getDatashiftAPIURL(String apiName, String twitterUserId, String twitterListId) throws SVTException{
        String url = getParameterMgr().getDatashiftAppURL();
        if(url == null){
            url = "http://twitterroiqa.edifixio.co.in:8001/";
        }
        if(apiName.equalsIgnoreCase("collectNegative")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectNegative?pick=1"; 
        }else if(apiName.equalsIgnoreCase("collectPositive")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectPositive?pick=1"; 
        }else if(apiName.equalsIgnoreCase("collectBitly")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectBitly?pick=1"; 
        }
        else if(apiName.equalsIgnoreCase("collectInfluence")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectInfluence?pick=1"; 
        }
        else if(apiName.equalsIgnoreCase("collectBrand")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectBrand?pick=1"; 
        }
        else if(apiName.equalsIgnoreCase("collectProduct")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectProduct?pick=1"; 
        }
        else if(apiName.equalsIgnoreCase("collectIndustry")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectIndustry?pick=1"; 
        }
        else if(apiName.equalsIgnoreCase("collectMention")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectMention?pick=1"; 
        }
        else if(apiName.equalsIgnoreCase("collectMentionAlert")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/menuStats"; 
        }
        else if(apiName.equalsIgnoreCase("collectCompetitor")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectCompetitor?pick=1"; 
        }
        else if(apiName.equalsIgnoreCase("collectThemes")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectThemes?pick=1"; 
        }
        else if(apiName.equalsIgnoreCase("collectHashtags")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectHashtags?pick=1"; 
        }
        else if(apiName.equalsIgnoreCase("following")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/following?pick=1"; 
        }
        else if(apiName.equalsIgnoreCase("list")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/list/" + twitterListId; 
        }
        else if(apiName.equalsIgnoreCase("all")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/picks"; 
        }
        else if(apiName.equalsIgnoreCase("actions")){
            //http://twitterroiqa.edifixio.co.in:8001/profile/1/actions
            url += "profile/" + getCurrentProfileId() + "/actions"; 
        }
        else if(apiName.equalsIgnoreCase("actionsinfluencers")){
            //http://twitterroiqa.edifixio.co.in:8001/profile/1/twitter/terametric/actions/influencers
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/actions/influencers"; 
        }
        System.out.println(url);
        return url;
    }
    
    
    // -------------------- To be moved out when complete by Tim (Datashift) ------------------------------------//
    private List<Status> getResponseStatus(Twitter twitter, String screenName) throws TwitterException {
        TweetResponseRetriever retriever = new TweetResponseRetriever();
        if(getFilterString().equalsIgnoreCase("LIST")){
            int listId = getListId(getParameter("listid"));
            return retriever.getResponse(twitter,screenName,listId); // filter, get only the tweets of selected list
        }else{
            return retriever.getResponse(twitter,screenName,0); // collects all the tweets from hometimeline 
        }
    }

    private List<TwitterInformationDTO> getAllTweets(Object[] objTrendsTwts, 
            TwitterLocalSearch twtLocalSearch, String strScreenName) throws Exception
    {
        int iTwtCtr = 0;
        
        System.out.println("getAllTweets Executed !!!!! ");
        
        List<TwitterInformationDTO> lThemeTweets = getKeyWordBasedTwt(objTrendsTwts, twtLocalSearch, 
                strScreenName, false, null, MAX_TWEET_IN_PAGE);
        
        List<TwitterInformationDTO> lAllTweets = new ArrayList<TwitterInformationDTO>(); //collect the tweets for view
        List<String> lStepExclude = new ArrayList<String>(); // for exclude list
        
        iTwtCtr = lThemeTweets.size();
        if(iTwtCtr == MAX_TWEET_IN_PAGE) return lThemeTweets;
        else
        {
            if(lThemeTweets.size() !=0) // less than 8 but not 0
                lAllTweets.addAll(lThemeTweets);
            
            iTwtCtr = lAllTweets.size();
            
            //prepare exclude list
            for (TwitterInformationDTO twitterInformationDTO : lThemeTweets)        {
                lStepExclude.add(String.valueOf(twitterInformationDTO.getTweetID()));    
            }
            
            //for hashtag
            List<TwitterInformationDTO> lHashTweets = getKeyWordBasedTwt(objTrendsTwts, twtLocalSearch, 
                    strScreenName, true, lStepExclude, 200);
            if( lHashTweets.size() >= MAX_TWEET_IN_PAGE )
                lAllTweets.addAll(lHashTweets.subList(0, MAX_TWEET_IN_PAGE-iTwtCtr));
            else   {
                if(lHashTweets.size() !=0)
                    lAllTweets.addAll(lHashTweets);
            }
            
            iTwtCtr = lAllTweets.size();
            
            if(iTwtCtr == MAX_TWEET_IN_PAGE) return lAllTweets;
            else
            {
              //prepare exclude list
                for (TwitterInformationDTO twitterInformationDTO : lHashTweets)  {
                    lStepExclude.add(String.valueOf(twitterInformationDTO.getTweetID()));    
                }
                //for bitly
                List<TwitterInformationDTO> lBitlyTweets = getBitlyBasedTweets(objTrendsTwts, twtLocalSearch, strScreenName, 
                        lStepExclude, 200);
                if(lBitlyTweets.size() >= MAX_TWEET_IN_PAGE)
                    lAllTweets.addAll(lBitlyTweets.subList(0, MAX_TWEET_IN_PAGE-iTwtCtr));
                else {
                    if(lBitlyTweets.size() != 0)
                        lAllTweets.addAll(lBitlyTweets);
                }
                iTwtCtr = lAllTweets.size();
                
                if(iTwtCtr == MAX_TWEET_IN_PAGE) return lAllTweets;
                else
                {
                  //prepare exclude list
                    for (TwitterInformationDTO twitterInformationDTO : lBitlyTweets)  {
                        lStepExclude.add(String.valueOf(twitterInformationDTO.getTweetID()));    
                    }
                    //for negative
                    List<TwitterInformationDTO> lNegativeTweets = getPositiveNegativeBasedTweets(objTrendsTwts, twtLocalSearch, 
                                                         false, lStepExclude,200); 
                    if(lNegativeTweets.size() >= MAX_TWEET_IN_PAGE)
                        lAllTweets.addAll(lNegativeTweets.subList(0, MAX_TWEET_IN_PAGE - iTwtCtr));
                    else {
                        if(lNegativeTweets.size() !=0)
                            lAllTweets.addAll(lNegativeTweets);
                    }
                    iTwtCtr = lAllTweets.size();
                    if(iTwtCtr == MAX_TWEET_IN_PAGE) return lAllTweets;
                    else
                    {
                      //prepare exclude list
                        for (TwitterInformationDTO twitterInformationDTO : lNegativeTweets)  {
                            lStepExclude.add(String.valueOf(twitterInformationDTO.getTweetID()));    
                        }
                        //for positive
                        List<TwitterInformationDTO> lPositiveTweets = getPositiveNegativeBasedTweets(objTrendsTwts, twtLocalSearch, 
                                                             true, lStepExclude,200);
                        if(lPositiveTweets.size() >= MAX_TWEET_IN_PAGE)
                            lAllTweets.addAll(lPositiveTweets.subList(0, MAX_TWEET_IN_PAGE - iTwtCtr));
                        else
                        {
                            if(lPositiveTweets.size() !=0)
                                lAllTweets.addAll(lPositiveTweets);
                        }
                        iTwtCtr = lAllTweets.size();
                        if(iTwtCtr == MAX_TWEET_IN_PAGE) return lAllTweets;
                        else
                        {
                          //prepare exclude list
                            for (TwitterInformationDTO twitterInformationDTO : lPositiveTweets)  {
                                lStepExclude.add(String.valueOf(twitterInformationDTO.getTweetID()));    
                            }
                            //for influencer
                            List<TwitterInformationDTO> lInfluencerTweets = getInfluencerBasedTweets(objTrendsTwts, twtLocalSearch, 
                                    lStepExclude,200);
                            if(lInfluencerTweets.size() >= MAX_TWEET_IN_PAGE)
                                lAllTweets.addAll(lInfluencerTweets.subList(0, MAX_TWEET_IN_PAGE - iTwtCtr));
                            else
                            {
                                if(lInfluencerTweets.size() !=0)
                                    lAllTweets.addAll(lInfluencerTweets);
                            }
                            iTwtCtr = lAllTweets.size();
                            if(iTwtCtr == MAX_TWEET_IN_PAGE) return lInfluencerTweets;
                            else
                            {
                              //prepare exclude list
                                for (TwitterInformationDTO twitterInformationDTO : lInfluencerTweets)  {
                                    lStepExclude.add(String.valueOf(twitterInformationDTO.getTweetID()));    
                                }
                                //for brand
                                List<TwitterInformationDTO> lBrandTweets = getKeywordBrandProdIndBasedTweets(objTrendsTwts, twtLocalSearch, 
                                        TwitterControllerConstants.BRAND, lStepExclude, 200);
                                if(lBrandTweets.size() >= MAX_TWEET_IN_PAGE)
                                    lAllTweets.addAll(lBrandTweets.subList(0, MAX_TWEET_IN_PAGE - iTwtCtr));
                                else
                                {
                                    if(lBrandTweets.size() !=0)
                                        lAllTweets.addAll(lBrandTweets);
                                }
                                iTwtCtr = lAllTweets.size();
                                if(iTwtCtr == MAX_TWEET_IN_PAGE) return lBrandTweets;
                                else
                                {
                                    //prepare exclude list
                                    for (TwitterInformationDTO twitterInformationDTO : lBrandTweets)  {
                                        lStepExclude.add(String.valueOf(twitterInformationDTO.getTweetID()));    
                                    }
                                    //for product
                                    List<TwitterInformationDTO> lProductTweets = getKeywordBrandProdIndBasedTweets(objTrendsTwts, twtLocalSearch, 
                                            TwitterControllerConstants.PRODUCT, lStepExclude, 200);
                                    if(lProductTweets.size() >= MAX_TWEET_IN_PAGE)
                                        lAllTweets.addAll(lProductTweets.subList(0, MAX_TWEET_IN_PAGE - iTwtCtr));
                                    else
                                    {
                                        if(lProductTweets.size() !=0)
                                            lAllTweets.addAll(lProductTweets);
                                    }
                                    iTwtCtr = lAllTweets.size();
                                    if(iTwtCtr == MAX_TWEET_IN_PAGE) return lProductTweets;
                                    else
                                    {
                                        //prepare exclude list
                                        for (TwitterInformationDTO twitterInformationDTO : lProductTweets)  {
                                            lStepExclude.add(String.valueOf(twitterInformationDTO.getTweetID()));    
                                        }
                                        //for industry
                                        List<TwitterInformationDTO> lIndustryTweets = getKeywordBrandProdIndBasedTweets(objTrendsTwts, twtLocalSearch, 
                                                TwitterControllerConstants.INDUSTRY, lStepExclude, 200);
                                        if(lIndustryTweets.size() >= MAX_TWEET_IN_PAGE)
                                            lAllTweets.addAll(lIndustryTweets.subList(0, MAX_TWEET_IN_PAGE - iTwtCtr));
                                        else
                                        {
                                            if(lIndustryTweets.size() !=0)
                                                lAllTweets.addAll(lIndustryTweets);
                                        }
                                        iTwtCtr = lAllTweets.size();
                                        if(iTwtCtr == MAX_TWEET_IN_PAGE) return lIndustryTweets;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return lAllTweets;
    }
    
    
    private List<TwitterInformationDTO> getKeyWordBasedTwt(Object[] objTrendsTwts, 
            TwitterLocalSearch twtLocalSearch, String strScreenName, boolean isHashTags, List<String> lExculdeList, 
            int maxResult) throws Exception    {
        
        int iTrendIndex = (isHashTags) ? 1 : 0; // Based on 0 and 1, the index value will be change for getting the Theme or Hashtags
        KeywordFreq keyFreq[] = (KeywordFreq[])objTrendsTwts[iTrendIndex]; // if 0 then Theme, if 1 then hashtag.
        int iEightPieceCtr = 1;
        
        Hashtable<String, Status> htAllTwts = (Hashtable<String, Status>)objTrendsTwts[2]; // It collects the tweets 
        ArrayList<TwitterInformationDTO> arAllDto = new ArrayList<TwitterInformationDTO>();
        
        boolean bIsEclude = (lExculdeList!= null && lExculdeList.size() > 0)? true: false;
        // keyFreq: this object contains top 10 thems/top 5 hashtags
        for (KeywordFreq keywordFreq : keyFreq) 
        {
            String strThemeTwtIDs[] = twtLocalSearch.searchForTweets(keywordFreq.getStrKeyword(), maxResult );
            for (String string : strThemeTwtIDs) 
            {
                if(bIsEclude && lExculdeList.contains(string))  continue;
                
                TwitterInformationDTO dtoDetails =  new TwitterInformationDTO();
                Status stat = htAllTwts.get(string);                 
                dtoDetails.setTweetReferenceType((isHashTags) ? FilterSequence.HASHTAGS : FilterSequence.THEME); // It sets the tweet type
                dtoDetails.setReferenceName(keywordFreq.getStrKeyword());  // It sets the reference name
                dtoDetails.setTweetStat(stat); // It sets tweet informations
                dtoDetails.setCnt(iEightPieceCtr++);
                dtoDetails.setLoggedInName(strScreenName);
                //dtoDetails.setReferenceName(keywordFreq.getStrKeyword() + ":" + keywordFreq.getIFreq());
                
                //dtoDetails.setTweetReferenceType((isHashTags) ? FilterSequence.HASHTAGS : FilterSequence.THEME); // It sets the tweet type
                dtoDetails.setTextAreaImage((isHashTags) ? FilterSequence.HASHTAGS_IMG : FilterSequence.THEME_IMG);  // It sets the Image Name
                //dtoDetails.setReferenceName(keywordFreq.getStrKeyword());  // It sets the reference name
                dtoDetails.setBoxHeaderColor(TwitterControllerConstants.NORMAL_BOX_HEADER_COLOR);
                arAllDto.add(dtoDetails);
                
                if(iEightPieceCtr > MAX_TWEET_IN_PAGE)break;
            }
            if(iEightPieceCtr > MAX_TWEET_IN_PAGE)break;
        }
        return arAllDto;
    }
    
    //For Bit.ly based
    private List<TwitterInformationDTO> getBitlyBasedTweets(Object[] objTrendsTwts, 
            TwitterLocalSearch twtLocalSearch, String strScreenName,List<String> lExculdeList, 
            int maxResult) throws Exception     {
        
        Hashtable<String, Status> htAllTwts = (Hashtable<String, Status>)objTrendsTwts[2];
        
        String strTwtIds[] = twtLocalSearch.searchForTweets("http\\://bit.ly*", MAX_TWEET_IN_PAGE);
        int iMaxTwtCtr = 1;
        ArrayList<TwitterInformationDTO> arAllDto = new ArrayList<TwitterInformationDTO>();
        
        boolean bIsEclude = (lExculdeList!= null && lExculdeList.size() > 0) ? true: false;
        
        for (String string : strTwtIds)  {
            
            if(bIsEclude && lExculdeList.contains(string)) continue;
            
            TwitterInformationDTO dtoDetails =  new TwitterInformationDTO();
            Status stat = htAllTwts.get(string);  
                        
            String bitlyURL = getBitlyUrlString(stat.getText());
            dtoDetails.setTweetReferenceType(FilterSequence.BITLY);
            dtoDetails.setReferenceName(bitlyURL);
            dtoDetails.setTweetStat(stat);
            dtoDetails.setCnt(iMaxTwtCtr++);
            //dtoDetails.setTweetReferenceType(FilterSequence.BITLY);
            dtoDetails.setReferenceType("bitly");
            dtoDetails.setTextAreaImage(FilterSequence.BITLY_IMG);
            //dtoDetails.setReferenceName(bitlyURL);
            dtoDetails.setBoxHeaderColor(TwitterControllerConstants.NORMAL_BOX_HEADER_COLOR);
                     
            arAllDto.add(dtoDetails);
        }
        return arAllDto;
    }
    
    private List<TwitterInformationDTO> getPositiveNegativeBasedTweets(Object[] objTrendsTwts, 
            TwitterLocalSearch twtLocalSearch,  boolean isPositive, List<String> lExculdeList, 
            int maxResult) throws Exception
    {
        
        Hashtable<String , Status> htAllTwts = (Hashtable<String, Status>)objTrendsTwts[2];
        Object[] twtPosNegTwt = twtLocalSearch.getPositiveNegetaiveTweets(htAllTwts, TwtStopWords.getInstance().getOnlyPositiveWordList(),
            TwtStopWords.getInstance().getOnlyNegativeWordList(),  lExculdeList, 200, MAX_TWEET_IN_PAGE, true);
        
            int iPosIndex = (isPositive) ? 0 : 1;
            
            KeywordFreq[] keyFreq = (KeywordFreq[]) twtPosNegTwt[iPosIndex];
            
            if(keyFreq == null)        {
                System.out.println("Key Frequency is null");
                //return new ArrayList<TwitterInformationTopDTO>();
                return new ArrayList<TwitterInformationDTO>();
            }
            
            ArrayList<TwitterInformationDTO> arAllDto = new ArrayList<TwitterInformationDTO>();
            boolean bIsEclude = (lExculdeList!= null && lExculdeList.size() > 0) ? true: false;
            
            int iMaxTwtCtr = 1;
            
            for (KeywordFreq keywordFreq : keyFreq)   {
                
                if(bIsEclude && lExculdeList.contains(htAllTwts.get(keywordFreq.getStrTweetId()))) continue;
                    
                TwitterInformationDTO dtoDetails =  new TwitterInformationDTO();
                Status stat = htAllTwts.get(keywordFreq.getStrTweetId());                 
                dtoDetails.setTweetReferenceType((isPositive)?FilterSequence.POSITIVE:FilterSequence.NEGATIVE);
                dtoDetails.setReferenceName(keywordFreq.getStrKeyword());
                dtoDetails.setTweetStat(stat); // It sets tweet informations
                dtoDetails.setCnt(iMaxTwtCtr++);
                //dtoDetails.setTweetReferenceType((isPositive)?FilterSequence.POSITIVE:FilterSequence.NEGATIVE);
                dtoDetails.setTextAreaImage((isPositive)?FilterSequence.POSITIVE_IMG:FilterSequence.NEGATIVE_IMG); 
                //dtoDetails.setReferenceName(keywordFreq.getStrKeyword());//+ "\n" + keywordFreq.getStrExplainPlan());
                dtoDetails.setBoxHeaderColor((isPositive)? TwitterControllerConstants.NORMAL_BOX_HEADER_COLOR : 
                    TwitterControllerConstants.NEGATIVE_BOX_HEADER_COLOR);
                arAllDto.add(dtoDetails);
        }
        return arAllDto;
    }
    
    //For INFLUENCERS Evangalist/Engrossed
    public List<TwitterInformationDTO> getInfluencerBasedTweets(Object[] objTrendsTwts, 
             TwitterLocalSearch twtLocalSearch, List<String> lExculdeList, 
             int maxResult) throws Exception
    {
        
        String influencers[] = getParameterMgr().getInfluencers().split(",");//{"Evangalist","Engrossed"};
        
        Hashtable<String , Status> htAllTwts = (Hashtable<String, Status>)objTrendsTwts[2];
        
        int iMaxTwtCtr = 1;
        ArrayList<TwitterInformationDTO> arAllDto = new ArrayList<TwitterInformationDTO>();
        boolean bIsEclude = (lExculdeList!= null && lExculdeList.size() > 0) ? true: false;
        
        for (int i = 0; i < influencers.length; i++ )  {
            String strInfluencers[] = twtLocalSearch.searchForTweets(influencers[i].toLowerCase(), MAX_TWEET_IN_PAGE );
            for (String string : strInfluencers) 
            {
                if(bIsEclude && lExculdeList.contains(string)) continue;
                
                TwitterInformationDTO dtoDetails =  new TwitterInformationDTO();
                Status stat = htAllTwts.get(string); 
                dtoDetails.setTweetReferenceType(FilterSequence.INFLUENCER);// It sets the tweet type
                dtoDetails.setReferenceName(influencers[i]); // It sets the reference name
                dtoDetails.setTweetStat(stat); // It sets tweet informations
                dtoDetails.setCnt(iMaxTwtCtr++);
                //dtoDetails.setTweetReferenceType(FilterSequence.INFLUENCER);// It sets the tweet type
                dtoDetails.setTextAreaImage(FilterSequence.INFLUENCER_IMG); // It sets the Image Name
                //dtoDetails.setReferenceName(influencers[i]); // It sets the reference name
                dtoDetails.setBoxHeaderColor(TwitterControllerConstants.NORMAL_BOX_HEADER_COLOR);
                arAllDto.add(dtoDetails);
                if(iMaxTwtCtr > MAX_TWEET_IN_PAGE)break;
            }
            if(iMaxTwtCtr > MAX_TWEET_IN_PAGE)break;
        }
        return arAllDto;
    }
    
    public UserProfileController getUserProfileControllerInstance()    {
        return (UserProfileController)FacesContext.getCurrentInstance()
                            .getExternalContext().getRequestMap().get("userProfileController");
    }
    //For Brand
    private List<TwitterInformationDTO> getKeywordBrandProdIndBasedTweets( Object[] objTrendsTwts, 
            TwitterLocalSearch twtLocalSearch, String brandProdIndu , List<String> lExculdeList, 
            int maxResult) throws Exception
    {
        String[] objBrandProdIndTwts =null;
        int iMaxTwtCtr = 1;
        
        Hashtable<String , Status> htAllTwts = (Hashtable<String, Status>)objTrendsTwts[2];
        
        if(brandProdIndu != null && brandProdIndu.trim().equalsIgnoreCase(TwitterControllerConstants.BRAND))
            objBrandProdIndTwts  = getUserProfileControllerInstance().getUserProfile().
                                                getKeyWordIdentBrand().trim().toLowerCase().split(",");
        else if(brandProdIndu != null && brandProdIndu.trim().equalsIgnoreCase(TwitterControllerConstants.PRODUCT))
            objBrandProdIndTwts  = getUserProfileControllerInstance().getUserProfile().
                                                getKeyWordIdentProd().trim().toLowerCase().split(",");
        else
            objBrandProdIndTwts  = getUserProfileControllerInstance().getUserProfile().
                                                getKeyWordIdentIndu().trim().toLowerCase().split(",");

        ArrayList<TwitterInformationDTO> arAllDto = new ArrayList<TwitterInformationDTO>();
        boolean bIsEclude = (lExculdeList!= null && lExculdeList.size() > 0) ? true: false;
        
        for (int i = 0; i < objBrandProdIndTwts.length; i++ )  {
            String strBrandProdIndu[] = twtLocalSearch.searchForTweets("\""+objBrandProdIndTwts[i]+"\"", MAX_TWEET_IN_PAGE );
            for (String string : strBrandProdIndu) 
            {
                if(bIsEclude && lExculdeList.contains(string)) continue;
                
                TwitterInformationDTO dtoDetails =  new TwitterInformationDTO();
                Status stat = htAllTwts.get(string);
                dtoDetails.setTweetReferenceType(brandProdIndu);// It sets the tweet type
                dtoDetails.setReferenceName(objBrandProdIndTwts[i]); // It sets the reference name
                dtoDetails.setTweetStat(stat); // It sets tweet informations
                dtoDetails.setCnt(iMaxTwtCtr++);
                //dtoDetails.setTweetReferenceType(brandProdIndu);// It sets the tweet type
                String image = brandProdIndu.equalsIgnoreCase(TwitterControllerConstants.BRAND) ? FilterSequence.BRAND_IMG : 
                               brandProdIndu.equalsIgnoreCase(TwitterControllerConstants.PRODUCT) ? FilterSequence.PRODUCT_IMG : FilterSequence.INDUSTRY_IMG;  
                dtoDetails.setTextAreaImage(image); // It sets the Image Name
                //dtoDetails.setReferenceName(objBrandProdIndTwts[i]); // It sets the reference name
                dtoDetails.setBoxHeaderColor(TwitterControllerConstants.NORMAL_BOX_HEADER_COLOR);
                arAllDto.add(dtoDetails);
              if(iMaxTwtCtr > MAX_TWEET_IN_PAGE)break;
            }
            if(iMaxTwtCtr > MAX_TWEET_IN_PAGE)break;
        }
        return arAllDto;
    }


    /*private List<TwitterInformationDTO> getAllTweets1(Object[] objTrendsTwts, 
                                TwitterLocalSearch twtLocalSearch, String strScreenName) throws Exception
    {
      
        int iTwtCtr = 0;
        List<TwitterInformationDTO> lThemeTweets = getKeyWordBasedTwt(objTrendsTwts, twtLocalSearch, 
                strScreenName, false, null, MAX_TWEET_IN_PAGE);
        
        iTwtCtr = lThemeTweets.size();
        if(iTwtCtr == MAX_TWEET_IN_PAGE) return lThemeTweets; // when reaches 8 nos.
        
        //This part executes when less than 8 tweets came.
        //Adding into the all tweets list as there may be more from other channel
        List<TwitterInformationDTO> lAllTweets = new ArrayList<TwitterInformationDTO>();
        
        if(lThemeTweets.size() !=0) 
            lAllTweets.addAll(lThemeTweets);
        
        //Adding excludes from theme
        List<String> lStepExclude = new ArrayList<String>();
        for (TwitterInformationDTO twitterInformationDTO : lThemeTweets)        {
            lStepExclude.add(String.valueOf(twitterInformationDTO.getTweetID()));    
        }
         
        //Getting the hash tweet list
        //Here the exclude list contains remaining theme based tweet IDs
        
        List<TwitterInformationDTO> lHashTweets = getKeyWordBasedTwt(objTrendsTwts, twtLocalSearch, 
                strScreenName, true, lStepExclude, 200);
        
                
        if(lHashTweets.size() >= (MAX_TWEET_IN_PAGE - iTwtCtr))        {
            lAllTweets.addAll(lHashTweets.subList(0, (MAX_TWEET_IN_PAGE - iTwtCtr)));
        }
        
        iTwtCtr = lAllTweets.size();
        
        if(iTwtCtr == MAX_TWEET_IN_PAGE) return lAllTweets;

        //Adding excludes from hash
        for (TwitterInformationDTO twitterInformationDTO : lHashTweets)        {
            lStepExclude.add(String.valueOf(twitterInformationDTO.getTweetID()));    
        }
        return lAllTweets;
    }*/
}

