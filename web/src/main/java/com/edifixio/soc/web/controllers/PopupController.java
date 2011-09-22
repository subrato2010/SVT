
/**
 * 
 * This Controller is used to handle various actions for the 
 * Outbound Metrics Optimization popups
 * @author SandipanM
 * 
 * */

package com.edifixio.soc.web.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.UserList;

import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.web.beans.RTOPHandler;
import com.edifixio.soc.web.dto.ListItemDTO;
import com.edifixio.soc.web.dto.TwitterActionsAjaxDTO;
import com.edifixio.soc.web.dto.TwitterActionsFavouritesDTO;
import com.edifixio.soc.web.dto.TwitterActionsInfluencersDTO;
import com.edifixio.soc.web.dto.TwitterActionsInfluencersListDTO;
import com.edifixio.soc.web.dto.TwitterActionsRTThanksDTO;
import com.edifixio.soc.web.dto.TwitterInformationTopDTO;
import com.edifixio.soc.web.util.ImageScaler;

public class PopupController extends JSONController
{
    
    private UploadedFile userProfileImage;
    private UploadedFile userProfileBackgroundImage;
    
    private static final String PROFILE_IMAGE_PREFIX = "TWTProImg";
    private static final String BKG_IMAGE_PREFIX = "TWTBkgImg";
    
    private static final int PHOTO_WIDTH = 80;
    private static final int PHOTO_HEIGHT = 85;
    
    private static final int BKG_WIDTH = 400;
    private static final int BKG_HEIGHT = 400;
    
    private static final String PHOTO_UPDATE = "ProfileImage";
    private static final String BKG_UPDATE = "BackgroundImage";
    
    private TwitterController twitterController;
    
    private boolean backgroundUpdate;
    private String profileImageURL = "../images/demoPerson.png";
    
    private boolean followSuccessFlag;
    private List<ListItemDTO> customerHandlerList;
    
    private static final String DEFAULT_BIOTEXT = "Tell something about yourself in less than 160 characters.";
    private String firstTwitterAccount;
    
    public PopupController()
    {
        System.out.println("PopupController Called !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        
    }

    /**
     * 
     * This method is used to scale an image according to specified WIDTH, HEIGHT
     * @param action
     * @return byte[]
     * @throws IOException
     * 
     **/
    
    private byte[] getScaledImageBeforeSetting(String action) throws IOException
    {
        if(action.equalsIgnoreCase(BKG_UPDATE))
        {
            return ImageScaler.getScalledImge(getUserProfileBackgroundImage().getBytes(), BKG_WIDTH, BKG_HEIGHT);
        }
        else
        {
            return ImageScaler.getScalledImge(getUserProfileImage().getBytes(), PHOTO_WIDTH, PHOTO_HEIGHT);
        }
    }
    
    /**
     * 
     * This method is used to create a file in the temp location of the server. This file path is provided to twitter for image upload.
     * The temp file is deleted after its path is sent to twitter.
     * 
     * @param imageFileName
     * @param action
     * @return File
     * @throws IOException
     * 
     **/
    
    private File createTempFIle(String imageFileName, String action) throws IOException
    {
        
        if(action.equalsIgnoreCase(BKG_UPDATE))
        {
            return File.createTempFile(BKG_IMAGE_PREFIX, imageFileName);
        }
        else
        {
            return File.createTempFile(PROFILE_IMAGE_PREFIX, imageFileName);
        }
        
    }
    /**
     * 
     * This method is used for updating the background image of the twitter user profile
     * @param ae
     * @throws IOException 
     * @exception Exception
     * 
     * **/
    public void uploadUserProfileBackgroundImage(ActionEvent ae) throws Exception
    {
        //getRTOPHandler().setActionId(getParameter("actionId"));
        
        String selectedProfileForBkg = getParameter("selectedProfileForBkg");
        
        if(getUserProfileBackgroundImage() != null && getUserProfileBackgroundImage().getName().trim().length() > 0)
        {
            if (isFileContentImage(getUserProfileBackgroundImage()) && (isFileExtensionImage(getUserProfileBackgroundImage().getName())))
            {
                String imageFileName = getUserProfileBackgroundImage().getName();
                File userBackgroundImage = createTempFIle(imageFileName, BKG_UPDATE);
                
                byte[] photoContent = getScaledImageBeforeSetting(BKG_UPDATE);
                
                FileOutputStream objFileOutputStream = new FileOutputStream(userBackgroundImage);
                objFileOutputStream.write(photoContent);
                
                if(selectedProfileForBkg != null && selectedProfileForBkg.trim().length() > 0)
                {
                    Twitter twitter = getTwitterController().validateTwitterObject(selectedProfileForBkg);
                
                    if (twitter != null) 
                    {
                        twitter.updateProfileBackgroundImage(userBackgroundImage, true);
                        
                        System.out.println("*************** User Profile Background updated successfully ************** "+selectedProfileForBkg);
                        setValueForSuccess(true);
                        setProfileImage(twitter, BKG_UPDATE);
                    } 
                    else 
                    {
                        System.out.println("*************** User Profile Background image updation failed ************** ");
                        setValueForSuccess(false);
                    }
                    objFileOutputStream.close();
                    userBackgroundImage.delete();
                }
            }
            else 
            {
                System.out.println(" ********* Background image type or size doesnot match the requirement ********** "+getUserProfileBackgroundImage().getContentType()+" "+(getUserProfileBackgroundImage().getSize()/1024) + "k");
                setValueForSuccess(false);
            }
        } 
        else
        {
            System.out.println(" ********* No file selected for background image upload ********** ");
        }
    }
    
    private void setProfileImage(Twitter twitter, String action) throws IllegalStateException, TwitterException
    {
        if(action.equalsIgnoreCase(BKG_UPDATE))
        {
            String imageURL = twitter.showUser(twitter.getScreenName()).getProfileBackgroundImageUrl();
            setProfileImageURL(imageURL);
            System.out.println("Background image url is : "+getProfileImageURL());
        }
        else
        {
            String imageURL = twitter.showUser(twitter.getScreenName()).getProfileImageURL().toString();
            setProfileImageURL(imageURL);
            System.out.println("Profile image url is : "+getProfileImageURL());
        }
        
        
    }
    
    private void setValueForSuccess(boolean isUpdate)
    {
        setBackgroundUpdate(isUpdate);
    }
    
    /***
     * 
     * This method is used for updating the profile picture of the twitter user profile
     * @param ae
     * @exception Exception
     ***/
    
    public void uploadUserProfileImage(ActionEvent ae) throws Exception
    {
        String selectedProfileForImg = getParameter("selectedProfileForImg");
        
        if(getUserProfileImage()!= null && getUserProfileImage().getName().trim().length() > 0)
        {
            if (isFileContentImage(getUserProfileImage()) && (isFileExtensionImage(getUserProfileImage().getName())))
            {
                String imageFileName = getUserProfileImage().getName();
                File userProfileImage = createTempFIle(imageFileName, PHOTO_UPDATE);
                
                byte[] photoContent = getScaledImageBeforeSetting(PHOTO_UPDATE);
                
                FileOutputStream objFileOutputStream = new FileOutputStream(userProfileImage);
                objFileOutputStream.write(photoContent);
                
                if(selectedProfileForImg != null && selectedProfileForImg.trim().length() > 0)
                {
                    Twitter twitter = getTwitterController().validateTwitterObject(selectedProfileForImg);
                
                    if (twitter != null)
                    {
                        twitter.updateProfileImage(userProfileImage);
                        setValueForSuccess(true);
                        setProfileImage(twitter, PHOTO_UPDATE);
                        
                        System.out.println("*************** User Profile Image updated successfully ************** "+selectedProfileForImg);
                    } 
                    else
                    {
                        setValueForSuccess(false);
                        System.out.println("*************** User Profile Image updation failed ************** "); 
                    }
                    
                    objFileOutputStream.close();
                    userProfileImage.delete();
                }
            }
            else
            {
                setValueForSuccess(false);
                System.out.println(" ********* Profile image type or size doesnot match the requirement ********** "+getUserProfileImage().getContentType()+" "+(getUserProfileImage().getSize()/1024) + "k");
            }
        }
        else
        {
            System.out.println(" ********* No file selected for profile pic upload ********** ");
        }
    }
    
    /**
     * This method is used for checking the content of a file
     * It returns true only if the file is an image (jpg, bmp or png)  
     * @param imageUpload @return fileContentFlag
    **/
    
    private boolean isFileContentImage(UploadedFile imageUpload)
    {
        boolean fileContentFlag = false;
        
        if ((imageUpload.getContentType().equalsIgnoreCase("image/jpeg") 
                || imageUpload.getContentType().equalsIgnoreCase("image/bmp") 
                || imageUpload.getContentType().equalsIgnoreCase("image/png")))  
         {
            fileContentFlag = true;
         }
        else
        {
            fileContentFlag = false;
        }
        
        return fileContentFlag;
    }
    
    
    /**
     * This method is used for checking the extension of a file
     * It returns true only if the file extension is either jpg, bmp or png  
     * @param fileName @return fileExtensionFlag
    **/
    
    private boolean isFileExtensionImage(String fileName)
    {
        boolean fileExtensionFlag = false;
        String extension = "";
        int dotPosition = fileName.trim().lastIndexOf(".");
        extension = fileName.substring(dotPosition+1);
        
        if(extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("jpeg") || 
                    extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("bmp"))
        {
            fileExtensionFlag = true;
        }
        else
        {
            fileExtensionFlag = false;
        }
        return fileExtensionFlag;
    }
    
    
    
    /**
     * 
     * This method is used to reply to the user who has mentioned the handler's name in a tweet
     * @param ae
     * @throws Exception
     * 
     **/
    @Deprecated
    public void tweetToReply(ActionEvent ae) throws Exception, TwitterException
    {
        
        String replyBy = getParameter("replyBy");    //this param will be present in the 'RTThanks.jsp'. this is the screen name of the user who wants to reply
        String replyTo = getParameter("replyTo");    //this param will be present in the 'RTThanks.jsp'. this is the screen name of the user whom to reply
        String tweetId = getParameter("tweetId");    //this param will be present in the 'RTThanks.jsp'. this is the id of the tweet to reply
        String replyTweetMsg = getParameter("individualTweet");    //this param will be present in the 'RTThanks.jsp'. this is the message to be sent as reply
        
        //System.out.println("---------- replyBy ::: "+replyBy);
        //System.out.println("---------- replyTo ::: "+replyTo);
        
        if(replyBy != null && replyBy.trim().length() > 0 && replyTo != null && replyTo.trim().length() > 0 && replyTweetMsg != null && replyTweetMsg.trim().length() > 0)
        {
            Twitter twitter = getTwitterController().validateTwitterObject(replyBy);
            
            if(twitter != null)
            {
                twitter.updateStatus(replyTweetMsg);
                System.out.println("******** Message sent as reply.");

                sendResponseToRTOP(tweetId, "thanked", "retweets" ,replyBy);
                System.out.println("************* Thank : Response sent to RTOP ****************");
                
            }
            else
            {
                System.out.println("********* Could not validate user *********");
            }
        }
        else
        {
            System.out.println("********** Reply message null or empty ********");
        }
    }
    
    
    /**
     * 
     * This method is used to reply to the user who has mentioned the handler's name in a tweet
     * @param ae
     * @throws Exception
     * @deprecated
     **/
    
    public void doNotThankRetweet(ActionEvent ae) throws Exception, TwitterException
    {
        String notThankedBy = getParameter("notThankedBy");    //this param will be present in the 'RTThanks.jsp'. this is the screen name of the user who does not want to thank
        String tweetId = getParameter("tweetId");             //this param will be present in the 'RTThanks.jsp'. this is the id of the tweet to not to thank
        
        if(notThankedBy != null && notThankedBy.trim().length() > 0 && tweetId != null && tweetId.trim().length() > 0)
        {
            Twitter twitter = getTwitterController().validateTwitterObject(notThankedBy);
            
            if(twitter != null)
            {
                //TODO twitter operation to be performed here
                
                sendResponseToRTOP(tweetId, "delete", "retweets" ,notThankedBy);
                System.out.println("************* UnThank : Response sent to RTOP ****************");
            }
            else
            {
                System.out.println("********* Could not validate user *********");
            }
        }
        else
        {
            System.out.println("********** Not Thanked tweet id null or empty ********");
        }
    }       
    
    /**
     * 
     * This method is used to get the names of list of the selected customer handler from Twitter
     * @param ae
     * @throws Exception 
     * 
     **/
    public void retrieveCustomerHandlerLists(ActionEvent ae) throws Exception
    {
        String handlerName = getParameter("handlerName");
        
        System.out.println("********** getCustomerHandlerLists : "+handlerName);
        List<ListItemDTO> listByUser = new ArrayList<ListItemDTO>(); 
        
        if(handlerName != null & handlerName.trim().length() > 0)
        {
            Twitter twitter = getTwitterController().validateTwitterObject(handlerName);
            
            if(twitter != null)
            {
                for(UserList list : twitter.getUserLists(handlerName,-1))
                {
                    ListItemDTO dto = new ListItemDTO();
                    dto.setId(""+list.getId());
                    dto.setName(list.getName());
                    listByUser.add(dto);
                    
                    System.out.println("list----------------------> "+list.getName());
                }
                
                if(listByUser != null && listByUser.size() > 0 )
                {
                    setCustomerHandlerList(listByUser);
                }                
                    
            }
            else
            {
                System.out.println("********* Could not validate user *********");
            }
        }
        else
        {
            System.out.println("********** Customer Handler Name null or empty ********");
        }
    } 
    
    /**
     * 
     * This method is used for updating the bio(description) of the twitter user profile if bio does not exist
     * @param ae
     * @throws IOException 
     * @exception Exception
     * 
     ***/
    public void updateUserProfileBio(ActionEvent ae) throws Exception
    {
        String userName = "";
        String userURL = "";
        String userLocation = "";
        String userDescription = "";
        String bioText = getParameter("bioText");
        
        String selectedProfileForBio = getParameter("selectedProfileForBio");
        
        if(bioText != null && bioText.trim().length() > 0 && !bioText.equalsIgnoreCase(DEFAULT_BIOTEXT))
        {
            if(selectedProfileForBio != null && selectedProfileForBio.trim().length() > 0)
            {
                Twitter twitter = getTwitterController().validateTwitterObject(selectedProfileForBio);
                        
                if(twitter != null)
                {
                    User user = twitter.showUser(selectedProfileForBio);
                    
                    if(user != null)
                    {
                        userName = user.getName();
                        
                        if(user.getURL()!=null)
                        {
                            userURL = user.getURL().toString();
                        }
                        
                        userLocation = user.getLocation();
                        userDescription = user.getDescription();
                        
                    }
                    
                    if(userDescription == null || userDescription.trim().length() == 0)
                    {
                        twitter.updateProfile(userName, "", userURL, userLocation, bioText);
                        System.out.println("******************* Profile Bio updated successfully *********************");
                    }
                    else
                    {
                        System.out.println("**************** Bio for the selected user already exists **************");
                    }
                }
            }
        }
        else
        {
            System.out.println("******************** Bio Text is empty ************************");
        }
    }
    
    /***
     * 
     * This method is used to populate the drop-down list in for 'Optimize Action' popups
     * @throws Exception
     * @return accList
     * 
     ***/
    
    public SelectItem[] getTwitterAccounts() throws SVTException
    {
        List<TwitterAccountDTO> twtAccList = getTwitterAccount();
        if(twtAccList !=null && twtAccList.size()>0)
        {
            SelectItem[] acc = new SelectItem[twtAccList.size()];
            
            for (int i = 0; i <twtAccList.size(); i++)
            {
                acc[i] = new SelectItem();
                acc[i].setLabel("@"+twtAccList.get(i).getTwitterUsername().replace(" ","").replace("#", ""));
                acc[i].setValue(twtAccList.get(i).getTwitterUsername().replace(" ","").replace("#", ""));
            }
            
            if(acc != null && acc.length>0)
            {
                setFirstTwitterAccount(acc[0].getValue().toString());
            }
            
            return acc;
            
        }
        return null;
    }

    public SelectItem[] getAccountsMissingBio() throws SVTException{
        return getTwitterAccountsSelf("alertTHMissingbio");
    }
    public SelectItem[] getAccountsMissingBkg() throws SVTException{
        return getTwitterAccountsSelf("alertTHmissingbkg");
    }
    public SelectItem[] getAccountsMissingGeo() throws SVTException{
        return getTwitterAccountsSelf("alertTHmissinggeo");
    }
    public SelectItem[] getAccountsMissingProfPics() throws SVTException{
        return getTwitterAccountsSelf("alertTHmissingPics");
    }
    
    private SelectItem[] getTwitterAccountsSelf(String seesionAttribute) throws SVTException
    {
        List<String> twitterAccountHandles = new ArrayList<String>();        
        twitterAccountHandles = (List<String>) getObjSessionAttribute(seesionAttribute);
        //System.out.println("session variable.....: " + getObjSessionAttribute("alertTwitterHandler"));
        if(twitterAccountHandles != null && twitterAccountHandles.size()>0){
            SelectItem[] acc = new SelectItem[twitterAccountHandles.size()];
            for (int i = 0; i <twitterAccountHandles.size(); i++)
            {
                acc[i] = new SelectItem();
                acc[i].setLabel("@"+twitterAccountHandles.get(i).replace(" ","").replace("#", ""));
                acc[i].setValue(twitterAccountHandles.get(i).replace(" ","").replace("#", ""));
            }
            
            if(acc != null && acc.length>0)
            {
                setFirstTwitterAccount(acc[0].getValue().toString());
            }
            return acc;
        }else{
            return getTwitterAccounts(); 
        }
    }

    public void setTwitterController(TwitterController twitterController)
    {
        this.twitterController = twitterController;
    }
    public TwitterController getTwitterController()   
    {
        return twitterController;
    }
    public UploadedFile getUserProfileImage()  
    {
            return userProfileImage;
    }
    public void setUserProfileImage(UploadedFile userProfileImage)  
    {
        this.userProfileImage = userProfileImage;
    }
    public UploadedFile getUserProfileBackgroundImage()  
    {
        return userProfileBackgroundImage;
    }
    public void setUserProfileBackgroundImage(UploadedFile userProfileBackgroundImage) 
    {
        this.userProfileBackgroundImage = userProfileBackgroundImage;
    }

    public boolean isBackgroundUpdate()
    {
        return backgroundUpdate;
    }

    public void setBackgroundUpdate(boolean backgroundUpdate)
    {
        this.backgroundUpdate = backgroundUpdate;
    }
    public String getProfileImageURL()
    {
        return profileImageURL;
    }
    public void setProfileImageURL(String profileImageURL)
    {
        this.profileImageURL = profileImageURL;
    }
    
    public boolean isFollowSuccessFlag() 
    {
        return followSuccessFlag;
    }

    public void setFollowSuccessFlag(boolean followSuccessFlag) 
    {
        this.followSuccessFlag = followSuccessFlag;
    }
    
    public List<ListItemDTO> getCustomerHandlerList()
    {
        return customerHandlerList;
    }

    public void setCustomerHandlerList(List<ListItemDTO> customerHandlerList)
    {
        this.customerHandlerList = customerHandlerList;
    }

    public String getFirstTwitterAccount()
    {
        return firstTwitterAccount;
    }

    public void setFirstTwitterAccount(String firstTwitterAccount)
    {
        this.firstTwitterAccount = firstTwitterAccount;
    }

    /**
     * This method is used to get the names of list of the selected customer
     * handler from Twitter
     * 
     * @param ae
     * @throws Exception
     * @author tapasb
     **/
    public void generateCustomerHandlerUserList(ActionEvent ae) throws Exception {
        Twitter twitter = getTwitterController().validateTwitterObject(getRTOPHandler().getFirstActionInfluencerTwitterAccount());
        List<UserList> userLists = twitter.getUserLists(twitter.getScreenName(), -1);
        List<ListItemDTO> listByUser = new ArrayList<ListItemDTO>();        
        String[] checkBoxes = new String[userLists.size()];        
        String[] listIds = new String[userLists.size()];
        
        int idx = 0;
        for (UserList list : userLists) {
            ListItemDTO dto = new ListItemDTO();
            dto.setId("" + list.getId());
            dto.setName(list.getName());
            listByUser.add(dto);            
            checkBoxes[idx] = "false";    
            listIds[idx] = null;
            idx++;
        }
        
        RTOPHandler rtopHandler = getRTOPHandler();
        rtopHandler.setUserList(listByUser);        
        rtopHandler.setCheckBoxes(checkBoxes);
        rtopHandler.setiIndex(Integer.parseInt(getParameter("index")));
        rtopHandler.setActionsInfluencersId(getParameter("actionsInfluencersId"));
        rtopHandler.setActionId(getParameter("actionId"));               
        rtopHandler.setListIds(listIds);
    }

    /**
     * this method toggle the addition-deletion of a user to twitter user-list 
     * @deprecated
     * @param event
     * @throws Exception
     * @author tapasb
     */
    public void updateUserListMember(ActionEvent event) throws Exception {
        String actionsInfluencersId = getParameter("actionsInfluencersId");
        String listId = getParameter("listId");
        Integer index = Integer.parseInt(getParameter("index"));
        Boolean isChecked = Boolean.parseBoolean(getParameter("isChecked"));
        Twitter twitter = getTwitterController().validateTwitterObject(getRTOPHandler().getFirstActionInfluencerTwitterAccount());
        if (isChecked) {
            twitter.deleteUserListMember(Integer.parseInt(listId), Integer.parseInt(actionsInfluencersId));
        } else {
            twitter.addUserListMember(Integer.parseInt(listId), Integer.parseInt(actionsInfluencersId));
        }        
    }    
    
    /**
     * This method send tweet as reply to a retweet
     * 
     * @author tapasb 
     * @param event
     * @throws Exception 
     * @throws IllegalStateException 
     */
    public void replyOnRetweet(ActionEvent event) throws IllegalStateException, Exception {
        String replyBy = getParameter("replyBy");
        String replyTo = getParameter("replyTo");
        String tweetId = getParameter("tweetId");
        String replyTweetMsg = getParameter("individualTweet");
        
        if(StringUtils.isNotBlank(replyBy) && StringUtils.isNotBlank(replyTo) && StringUtils.isNotBlank(replyTweetMsg)) {
            Twitter twitter = getTwitterController().validateTwitterObject(replyBy);            
            if(twitter != null) {
                twitter.updateStatus(replyTweetMsg);
                sendResponseToRTOP(tweetId, "thanked", "retweets" ,replyBy);    
                
                TwitterActionsRTThanksDTO twitterActionsRTThanksDTO = (TwitterActionsRTThanksDTO) getRTOPHandler().getActionDetails(getRTOPHandler().getFirstActionInfluencerTwitterAccount(),"actionsretweets");                
                if(twitterActionsRTThanksDTO != null) {
                    getRTOPHandler().setTwitterActionsRTThanksDto(twitterActionsRTThanksDTO);
                    
                    if(twitterActionsRTThanksDTO.getRetweets() == null) {
                        getRTOPHandler().setCloseIt(true);
                    } else {
                        if(twitterActionsRTThanksDTO.getRetweets().size() == 0) {
                            getRTOPHandler().setCloseIt(true);                            
                        }
                    }
                }
                
                if(getRTOPHandler().getFirstActionInfluencerTwitterAccount().equalsIgnoreCase(getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME))) {
                    getRTOPHandler().setOptimizeActionDTOs(null);
                }
            }
        } 
    }
    
    /**
     * This method delete the entry from retweets
     * 
     * @author tapasb
     * @param event
     * @throws Exception
     * @throws IllegalStateException
     */
    public void deleteTweet(ActionEvent event) throws IllegalStateException, Exception {
        String replyBy = getParameter("replyBy");
        String replyTo = getParameter("replyTo");
        String tweetId = getParameter("tweetId");

        if (StringUtils.isNotBlank(replyBy) && StringUtils.isNotBlank(replyTo)) {
            if (getTwitterController().validateTwitterObject(replyBy) != null) {
                sendResponseToRTOP(tweetId, "delete", "retweets", replyBy);
                
                TwitterActionsRTThanksDTO twitterActionsRTThanksDTO = (TwitterActionsRTThanksDTO) getRTOPHandler().getActionDetails(getRTOPHandler().getFirstActionInfluencerTwitterAccount(),"actionsretweets");                
                if(twitterActionsRTThanksDTO != null) {
                    getRTOPHandler().setTwitterActionsRTThanksDto(twitterActionsRTThanksDTO);

                    if(twitterActionsRTThanksDTO.getRetweets() == null) {
                        getRTOPHandler().setCloseIt(true);
                    } else {
                        if(twitterActionsRTThanksDTO.getRetweets().size() == 0) {
                            getRTOPHandler().setCloseIt(true);                            
                        }
                    }
                }    
                
                if(getRTOPHandler().getFirstActionInfluencerTwitterAccount().equalsIgnoreCase(getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME))) {
                    getRTOPHandler().setOptimizeActionDTOs(null);
                }
            } 
        }               
    }
    
    /**
     * this method add a user to twiiter user-list and remove a row from the popup of 
     * add-to-list alert also re-render the parent optimize action panel
     * @param event
     * @throws IllegalStateException
     * @throws Exception
     * @author tapasb
     */
    public void addInfulencerToList(ActionEvent event) throws IllegalStateException, Exception {
        boolean isChecked = false;
        for(String checkValue : getRTOPHandler().getCheckBoxes()) {
            if(checkValue.equals("true")) {
                isChecked = true;
                break;
            }
        }
        
        if(isChecked) {
            String actionsInfluencersId = getParameter("actionsInfluencersId");
            Twitter twitter = getTwitterController().validateTwitterObject(getRTOPHandler().getFirstActionInfluencerTwitterAccount());
            for(String id : getRTOPHandler().getListIds()) {
                if(StringUtils.isNotBlank(id)) {                    
                    twitter.addUserListMember(Integer.parseInt(id), Integer.parseInt(actionsInfluencersId));
                }
            }
                        
            sendResponseToRTOP(actionsInfluencersId, "followed", "influencers_to_list", getRTOPHandler().getFirstActionInfluencerTwitterAccount());
            
            TwitterActionsInfluencersListDTO twitterActionsInfluencersListDTO = (TwitterActionsInfluencersListDTO) getRTOPHandler().getActionDetails(getRTOPHandler().getFirstActionInfluencerTwitterAccount(),"actionsinfluencerstolist");
            
            if(twitterActionsInfluencersListDTO != null) {                
                getRTOPHandler().setTwitterActionsInfluencersListDTO(twitterActionsInfluencersListDTO);
                
                if (twitterActionsInfluencersListDTO.getInfluencers_to_list() == null) {
                    getRTOPHandler().setCloseIt(true);
                } else {
                    if(twitterActionsInfluencersListDTO.getInfluencers_to_list().size() == 0) {
                        getRTOPHandler().setCloseIt(true);
                    }
                }
            }
            
            if(getRTOPHandler().getFirstActionInfluencerTwitterAccount().equalsIgnoreCase(getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME))) {
                getRTOPHandler().setOptimizeActionDTOs(null);
            }
        }      
        
        for(int i = 0; i < getRTOPHandler().getCheckBoxes().length; i++) {
            getRTOPHandler().getCheckBoxes()[i] = "false";
        }
    }
    
    /**
     * this method remove a row from the popup of add-to-list alert also re-render the parent optimize action panel
     * @param event
     * @throws IllegalStateException
     * @throws Exception
     * @author tapasb
     */
    public void deleteInfulencerToList(ActionEvent event) throws IllegalStateException, Exception {
        if(StringUtils.isNotBlank(getParameter("user"))) {
            if(getTwitterController().validateTwitterObject(getRTOPHandler().getFirstActionInfluencerTwitterAccount()) != null) {
                sendResponseToRTOP(getParameter("user"), "delete", "influencers_to_list", getRTOPHandler().getFirstActionInfluencerTwitterAccount());
                
                TwitterActionsInfluencersListDTO twitterActionsInfluencersListDTO = (TwitterActionsInfluencersListDTO) getRTOPHandler().getActionDetails(getRTOPHandler().getFirstActionInfluencerTwitterAccount(),"actionsinfluencerstolist");
                
                if(twitterActionsInfluencersListDTO != null) {                    
                    getRTOPHandler().setTwitterActionsInfluencersListDTO(twitterActionsInfluencersListDTO);
                    
                    if (twitterActionsInfluencersListDTO.getInfluencers_to_list() == null) {
                        getRTOPHandler().setCloseIt(true);
                    } else {
                        if(twitterActionsInfluencersListDTO.getInfluencers_to_list().size() == 0) {
                            getRTOPHandler().setCloseIt(true);
                        }
                    }
                }
                
                if(getRTOPHandler().getFirstActionInfluencerTwitterAccount().equalsIgnoreCase(getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME))) {
                    getRTOPHandler().setOptimizeActionDTOs(null);
                }
            }
        }
    }        
    
    /**
     * 
     * This method is used to start following a given user in Twitter
     * @param ae
     * @throws Exception, TwitterException
     * 
     */
    
    public void followSelectedUser(ActionEvent ae) throws Exception, TwitterException
    {        
        String userToFollow = getParameter("userToFollow"); 
        String userToFollowName = getParameter("userToFollowName"); 
        String followedBy = getParameter("followedBy");
                
        if(userToFollow != null && userToFollow.trim().length() > 0 && followedBy != null && followedBy.trim().length() > 0) {
            Twitter twitter = getTwitterController().validateTwitterObject(followedBy);
            
            if(twitter != null) {
                if(!twitter.existsFriendship(twitter.getScreenName(), userToFollowName)) {
                  twitter.createFriendship(userToFollowName);
                  setFollowSuccessFlag(true);
                  
                  sendResponseToRTOP(userToFollow, "followed", "influencers" ,followedBy);                  
                } else {                    
                    sendResponseToRTOP(userToFollow, "followed", "influencers" ,followedBy);                    
                    setFollowSuccessFlag(false);
                }
                
                TwitterActionsInfluencersDTO twitterActionsInfluencersDTO = (TwitterActionsInfluencersDTO) getRTOPHandler().getActionDetails(getRTOPHandler().getFirstActionInfluencerTwitterAccount(),"actionsinfluencers" );
                
                if(twitterActionsInfluencersDTO != null) {
                    getRTOPHandler().setTwitterActionsInfluencerDto(twitterActionsInfluencersDTO); 
                    
                    if(twitterActionsInfluencersDTO.getInfluencers() == null) {
                        getRTOPHandler().setCloseIt(true);
                    } else {
                        if(twitterActionsInfluencersDTO.getInfluencers().size() == 0) {
                            getRTOPHandler().setCloseIt(true);
                        }
                    }
                }  
                
                if(getRTOPHandler().getFirstActionInfluencerTwitterAccount().equalsIgnoreCase(getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME))) {
                    getRTOPHandler().setOptimizeActionDTOs(null);
                }
            } else {                
                setFollowSuccessFlag(false);
            }
        } else {
            setFollowSuccessFlag(false);
        }
    }
    
    /**
     * 
     * This method is used to start unfollowing a given user in Twitter
     * @param ae
     * @throws Exception, TwitterException
     * 
     * **/
    
    public void unFollowSelectedUser(ActionEvent ae) throws Exception, TwitterException {
        String userToUnFollow = getParameter("userToUnFollow"); 
        String unFollowedBy = getParameter("unFollowedBy");    
        
        if(userToUnFollow != null && userToUnFollow.trim().length() > 0 && unFollowedBy != null && unFollowedBy.trim().length() > 0) {
            sendResponseToRTOP(userToUnFollow, "delete", "influencers" ,unFollowedBy);            
            TwitterActionsInfluencersDTO twitterActionsInfluencersDTO = (TwitterActionsInfluencersDTO) getRTOPHandler().getActionDetails(getRTOPHandler().getFirstActionInfluencerTwitterAccount(),"actionsinfluencers" );
            
            if(twitterActionsInfluencersDTO != null) {
                getRTOPHandler().setTwitterActionsInfluencerDto(twitterActionsInfluencersDTO); 
                
                if(twitterActionsInfluencersDTO.getInfluencers() == null) {
                    getRTOPHandler().setCloseIt(true);
                } else {
                    if(twitterActionsInfluencersDTO.getInfluencers().size() == 0) {
                        getRTOPHandler().setCloseIt(true);
                    }                    
                }
            }  
            
            if(getRTOPHandler().getFirstActionInfluencerTwitterAccount().equalsIgnoreCase(getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME))) {
                getRTOPHandler().setOptimizeActionDTOs(null);
            }
        }
    }
    
    /**
     * 
     * This method is used to set a tweet as favorite
     * @param ae
     * @throws Exception
     * 
     **/
    
    public void tweetToFavorite(ActionEvent ae) throws Exception, TwitterException {        
        String strTweetId = getParameter("tweetToFavorite"); 
        String favoriteBy = getParameter("favoriteBy");    
        String forIndex = getParameter("forIndex");   
        boolean isFromPoup = false;
        
        if(strTweetId == null || strTweetId.trim().length() < 0) {
            strTweetId = getParameter("tweetToFavorite_"+forIndex); 
        } else {
            isFromPoup = true;
        }
        
        if(StringUtils.isNotBlank(getParameter("fromTweetFeed"))) {
            // Coming from tweet feed, let set the twitterInfoList
            @SuppressWarnings("unchecked")
            List<TwitterInformationTopDTO> twitterInfoList = (List<TwitterInformationTopDTO>) getObjSessionAttribute(TwitterControllerConstants.GET_TWITTER_INFO_LIST);
            getTwitterController().setTwitterInfoList(twitterInfoList);
        }
        
        if(strTweetId != null && strTweetId.trim().length() > 0 && favoriteBy != null && favoriteBy.trim().length() > 0) {
            long tweetId = Long.parseLong(strTweetId);
            Twitter twitter = getTwitterController().validateTwitterObject(favoriteBy);
            
            if(twitter != null) {
                twitter.createFavorite(tweetId);                                
                sendResponseToRTOP(strTweetId, "favorited", "favourites" ,favoriteBy);
                
                if(isFromPoup) {
                    TwitterActionsFavouritesDTO twitterActionsFavouritesDTO = (TwitterActionsFavouritesDTO) getRTOPHandler().getActionDetails(getRTOPHandler().getFirstActionInfluencerTwitterAccount(), "actionsfavourites");
                    
                    if(twitterActionsFavouritesDTO != null) {
                        getRTOPHandler().setTwitterActionsFavouritesDto(twitterActionsFavouritesDTO);
                        
                        if(twitterActionsFavouritesDTO.getFavourites() == null) {
                            getRTOPHandler().setCloseIt(true);
                        } else {
                            if(twitterActionsFavouritesDTO.getFavourites().size() == 0) {
                                getRTOPHandler().setCloseIt(true);
                            }
                        }
                    }  
                    
                    if(getRTOPHandler().getFirstActionInfluencerTwitterAccount().equalsIgnoreCase(getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME))) {
                        getRTOPHandler().setOptimizeActionDTOs(null);
                    }
                }                 
            }
        }         
    }
    
    /**
     * 
     * This method is used to set a tweet as un-favorite
     * @param ae
     * @throws Exception
     * 
     **/
    
    public void tweetToUnFavorite(ActionEvent ae) throws Exception, TwitterException {
        String strTweetId = getParameter("tweetToUnFavorite"); 
        String unFavoriteBy = getParameter("unFavoriteBy");  
        
        if(strTweetId != null && strTweetId.trim().length() > 0 && unFavoriteBy != null && unFavoriteBy.trim().length() > 0) {
            long tweetId = Long.parseLong(strTweetId);
            Twitter twitter = getTwitterController().validateTwitterObject(unFavoriteBy);
            
            if(twitter != null) {
                twitter.destroyFavorite(tweetId);
                sendResponseToRTOP(strTweetId, "delete", "favourites" ,unFavoriteBy);
                
                TwitterActionsFavouritesDTO twitterActionsFavouritesDTO = (TwitterActionsFavouritesDTO) getRTOPHandler().getActionDetails(getRTOPHandler().getFirstActionInfluencerTwitterAccount(), "actionsfavourites");
                
                if(twitterActionsFavouritesDTO != null){
                    getRTOPHandler().setTwitterActionsFavouritesDto(twitterActionsFavouritesDTO);
                    
                    if(twitterActionsFavouritesDTO.getFavourites() == null) {
                        getRTOPHandler().setCloseIt(true);
                    } else {
                        if(twitterActionsFavouritesDTO.getFavourites().size() == 0) {
                            getRTOPHandler().setCloseIt(true);
                        }
                    }
                }  
                
                if(getRTOPHandler().getFirstActionInfluencerTwitterAccount().equalsIgnoreCase(getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME))) {
                    getRTOPHandler().setOptimizeActionDTOs(null);
                }                
            }
        }
    }
    
    /**
     * 
     * This method is used to send direct message to a particular user
     * @param ae
     * @throws Exception
     * 
     **/
    
    //TODO render logic - rtop api is not reday
    public void directMessageToReturn(ActionEvent ae) throws Exception, TwitterException {        
        String directMessageBy = getParameter("directMessageBy");    
        String directMessageTo = getParameter("directMessageTo");    
        String directMsg = getParameter("individualTweet");    
        
        if(directMessageBy != null && directMessageBy.trim().length() > 0 && directMessageTo != null && directMessageTo.trim().length() > 0 && directMsg != null && directMsg.trim().length() > 0) {
            Twitter twitter = getTwitterController().validateTwitterObject(directMessageBy);            
            if(twitter != null) {
                twitter.sendDirectMessage(directMessageTo, directMsg);
                
                
                //TODO JSON Post for Direct Message
                
                //sendResponseToRTOP(tweetId, "delete", "retweets" ,directMessageBy); // parameters needs to be modified accordingly
                //System.out.println("************* Direct Message : Response sent to RTOP ****************");                                   
            } 
        }
    }
    
    public void setCloseIt(ActionEvent event) {
        System.out.println("=========================== setting auto close condition ===========================");
        getRTOPHandler().setCloseIt(false);
    }
}
