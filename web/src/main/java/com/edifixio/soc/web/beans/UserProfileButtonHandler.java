package com.edifixio.soc.web.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.apache.commons.lang.StringUtils;

import twitter4j.TwitterException;

import com.edifixio.soc.biz.dto.CompanyDTO;
import com.edifixio.soc.biz.dto.GoogleAnalyticsAccountDTO;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfilePreference;
import com.edifixio.soc.web.controllers.BaseWebObject;
import com.edifixio.soc.web.controllers.JSONController;
import com.edifixio.soc.web.controllers.UserProfileController;
import com.edifixio.soc.web.dto.TwitterRTOPNotifyDTO;
import com.edifixio.soc.web.util.GDataFeedRetrieve;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;


public class UserProfileButtonHandler extends JSONController {
    UserProfileController userProfileController;

    private String twitterAccountName;
    private String twitterCmptAccountName1;
    private String twitterCmptAccountName2;
    private String twitterCmptAccountName3;
    
    /******************* tapasb ********************/
    
    private String scrollValue;


    public String getScrollValue() {
        return scrollValue;
    }


    public void setScrollValue(String scrollValue) {
        this.scrollValue = scrollValue;
    }


    public String getScrollScript() {
        if (StringUtils.isEmpty(scrollValue)) {
            return "";
        }
        String[] coordinates = scrollValue.split(":");
        StringBuilder script = new StringBuilder("")
                .append("var frames = window.parent.frames;")
                .append("var iframe = frames['frameR'];")
                .append("iframe.document.body.scrollTop = '" + coordinates[1]
                        + "'");
        return script.toString();
    }


    /******************* tapasb ********************/
   
    /**
     * On click of add button ( Twitter Accounts Add button )
     * @param actionEvent
     * @throws SVTException
     * @throws TwitterException 
     */
    public void addTwitterAccountHandler(ActionEvent actionEvent) throws SVTException, TwitterException {
        System.out.println("Clicked on Self Add button: " + getUserProfile().getTwitterAccountNameSelf());
        
        if(getUserProfile().getTwitterAccountNameSelf().trim().length() <=0 || getUserProfile().getTwitterAccountNameSelf().trim().contains(" ")) //updated on 25-05-2011 by NEEL
            return;
        
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setTwitterUsername(getUserProfile().getTwitterAccountNameSelf());
        dto.setHandlerName("Customer");
        
        // Cannot add more than 5
        if(getUserProfile().getSelfTwtAccounts().size() > 4){
            System.out.println("Limit exceeded...");
            return;
        }
        setTwitterAccountValue(dto);
    }

    private void setTwitterAccountValue(TwitterAccountDTO dto) throws SVTException, TwitterException {
        dto.setCreatedOn(new Date());
        dto.setUpdatedBy(getCurrentProfileId());
        dto.setProfilePreference(getUserProfile().getProfilePreference());
        dto.setSelf(false);
        if(dto.getHandlerName().equalsIgnoreCase("Customer")){
            dto.setSelf(true);    
        }
        
        //dto.setTwitterUsername(getTwitterAccountName());
        dto.setBrndProdInds("BRAND"); //TODO : please take care of this, will be passed from screen, else default to "BRAND"
        getTwitterAccountMgr().add(dto);   


        // This will refresh the value with above addition
        getUserProfile().setSelfTwtAccounts(getTwitterAccountMgr().getByProfilePreferenceIdSELF(getUserProfile().getProfilePreference().getProfilePrefrenceId())); 
        getUserProfile().setCompTwtAccountsHandle1(getTwitterAccountMgr().getByProfilePreferenceIdCompNameNOTSELF(getUserProfile().getProfilePreference().getProfilePrefrenceId(), "Competitor #1"));
        getUserProfile().setCompTwtAccountsHandle2(getTwitterAccountMgr().getByProfilePreferenceIdCompNameNOTSELF(getUserProfile().getProfilePreference().getProfilePrefrenceId(), "Competitor #2"));
        getUserProfile().setCompTwtAccountsHandle3(getTwitterAccountMgr().getByProfilePreferenceIdCompNameNOTSELF(getUserProfile().getProfilePreference().getProfilePrefrenceId(), "Competitor #3"));
        getUserProfile().setCompanyHandler(getTwitterAccountMgr().getByProfilePreferenceId(getUserProfile().getProfilePreference().getProfilePrefrenceId()));

        setUserProfile(getUserProfile());       
        
        // Send response to RTOP
        sendResponseToRTOP("update");
    }    

    public void addTwitterAccountCmptHandler1(ActionEvent actionEvent) throws SVTException, TwitterException {
        
        System.out.println("Clicked on Cmpt1 Add button: " + getUserProfile().getTwitterCmptAccountName1());
        
        if(getUserProfile().getTwitterCmptAccountName1().trim().length() <=0 || getUserProfile().getTwitterCmptAccountName1().trim().contains(" ")) //updated on 25-05-2011 by NEEL
            return;
        
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setTwitterUsername(getUserProfile().getTwitterCmptAccountName1());
        dto.setHandlerName("Competitor #1");
        // Cannot add more than 5
        if(getUserProfile().getCompTwtAccountsHandle1().size() > 5){
            System.out.println("Limit exceeded...");
            return;
        }
        setTwitterAccountValue(dto);
    }

    public void addTwitterAccountCmptHandler2(ActionEvent actionEvent) throws SVTException, TwitterException {
        System.out.println("Clicked on Cmpt2 Add button: " + getUserProfile().getTwitterCmptAccountName2());
        
        if(getUserProfile().getTwitterCmptAccountName2().trim().length() <=0 || getUserProfile().getTwitterCmptAccountName2().trim().contains(" ")) //updated on 25-05-2011 by NEEL
            return;
        
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setTwitterUsername(getUserProfile().getTwitterCmptAccountName2());
        dto.setHandlerName("Competitor #2");
        if(getUserProfile().getCompTwtAccountsHandle2().size() > 5){
            System.out.println("Limit exceeded...");
            return;
        }
        setTwitterAccountValue(dto);
    }

    public void addTwitterAccountCmptHandler3(ActionEvent actionEvent) throws SVTException, TwitterException {
        System.out.println("Clicked on Cmpt3 Add button: " + getUserProfile().getTwitterCmptAccountName3());
        
        if(getUserProfile().getTwitterCmptAccountName3().trim().length() <=0 || getUserProfile().getTwitterCmptAccountName3().trim().contains(" ")) //updated on 25-05-2011 by NEEL
            return;
        
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setTwitterUsername(getUserProfile().getTwitterCmptAccountName3());
        dto.setHandlerName("Competitor #3");
        if(getUserProfile().getCompTwtAccountsHandle3().size() > 5){
            System.out.println("Limit exceeded...");
            return;
        }
        setTwitterAccountValue(dto);
    }
    
    private void setTwitterAccountCmptValue(TwitterAccountDTO dto, String twitterAccountCmptName) throws SVTException {
        dto.setCreatedOn(new Date());
        dto.setUpdatedBy(getCurrentProfileId());
        dto.setProfilePreference(getUserProfile().getProfilePreference());
        dto.setSelf(false);
        dto.setTwitterUsername(twitterAccountCmptName);
        dto.setBrndProdInds("BRAND"); //TODO : please take care of this, will be passed from screen, else default to "BRAND"
        getTwitterAccountMgr().add(dto);

    }
    
    
    public void addReportingEmailAddress(ActionEvent actionEvent) throws SVTException, TwitterException {
        System.out.println("Clicked on Reporting Add button " + getUserProfile().getEmailAddress());
        // System.out.println("Email Address 1:  " + getUserProfile().getReportingEmail1());
        // System.out.println("Email Address 2:  " + getUserProfile().getReportingEmail2());
        // System.out.println("Email Address 3:  " + getUserProfile().getReportingEmail3());
        if ((getUserProfile().getReportingEmail1() != null && getUserProfile() .getReportingEmail1().trim().equals("")) || getUserProfile().getReportingEmail1() == null) {
            // System.out.println("Inside1......");
            getUserProfile().setReportingEmail1(getUserProfile().getEmailAddress());
        } else if ((getUserProfile().getReportingEmail2() != null && getUserProfile().getReportingEmail2().trim().equals("")) || getUserProfile().getReportingEmail2() == null) {
            // System.out.println("Inside1......");
            getUserProfile().setReportingEmail2(getUserProfile().getEmailAddress());
        } else if ((getUserProfile().getReportingEmail3() != null && getUserProfile().getReportingEmail3().trim().equals("")) || getUserProfile().getReportingEmail3() == null) {
            // System.out.println("Inside1......");
            getUserProfile().setReportingEmail3(getUserProfile().getEmailAddress());
        }
        
        UserProfileDetailDTO dto = new UserProfileDetailDTO();
        dto.setProfilePreference(getUserProfile().getProfilePreference());
        dto.setReportingEmail1(getUserProfile().getReportingEmail1());
        dto.setReportingEmail2(getUserProfile().getReportingEmail2());
        dto.setReportingEmail3(getUserProfile().getReportingEmail3());
        getProfilePreferenceMgr().update(dto);
        

        // Send response to RTOP
        sendResponseToRTOP("update");
    }

    /**
     * Add vanity usr by pressing on ADD button
     * @throws SVTException 
     */
    
    public void addVanityURL(ActionEvent actionEvent) throws SVTException {
        System.out.println("Inside Vanity URL...");
       UserProfileDetailDTO dto = new UserProfileDetailDTO();
       dto.setProfilePreference(getUserProfile().getProfilePreference());
       dto.setVanityUrl(getUserProfile().getVanityUrl());
       getProfilePreferenceMgr().updateVanityURL(dto);
    }
    
    
    
    public void addKeyWordBrandHandler(ActionEvent actionEvent) throws SVTException, TwitterException {
        // System.out.println("Clicked on BrandKeyword Add button: " + getUserProfile().getKeyWordIdentBrand() + " for handler: " + getUserProfile().getKeyWordCompanyHandleName());
        if (getUserProfile().getKeyWordCompanyHandleName() != null && getUserProfile().getKeyWordCompanyHandleName().trim().length() > 0) {
            CompanyDTO dto = new CompanyDTO();
            dto.setCompanyName(getUserProfile().getKeyWordCompanyHandleName());
            dto.setKeyWordIdentBrand(getUserProfile().getKeyWordIdentBrand());
            updateKeyWordIdentBrand(getUserProfile().getCompanyHandler(), dto.getCompanyName(), dto.getKeyWordIdentBrand());
            // getUserProfile().setCompanyHandler(getTwitterAccountMgr().getByProfilePreferenceId(getUserProfile().getProfilePreference().getProfilePrefrenceId()));
            
            // Send response to RTOP
            sendResponseToRTOP("update");
        }
    }
    

    public void addKeyWordProductHandler(ActionEvent actionEvent) throws SVTException, TwitterException {
        // System.out.println("Clicked on ProductKeyword Add button: " + getUserProfile().getKeyWordIdentProd() + " for handler: " + getUserProfile().getKeyWordCompanyHandleName());
        if (getUserProfile().getKeyWordCompanyHandleName() != null && getUserProfile().getKeyWordCompanyHandleName().trim().length() > 0) {
            CompanyDTO dto = new CompanyDTO();
            dto.setCompanyName(getUserProfile().getKeyWordCompanyHandleName());
            dto.setKeyWordIdentProd(getUserProfile().getKeyWordIdentProd());
            updateKeyWordIdentProd(getUserProfile().getCompanyHandler(), dto.getCompanyName(), dto.getKeyWordIdentProd());
            // getUserProfile().setCompanyHandler(getTwitterAccountMgr().getByProfilePreferenceId(getUserProfile().getProfilePreference().getProfilePrefrenceId()));
            
            // Send response to RTOP
            sendResponseToRTOP("update");
        }
    }
    

    public void addKeyWordIndustryHandler(ActionEvent actionEvent) throws SVTException, TwitterException {
        // System.out.println("Clicked on IndustryKeyword Add button: " + getUserProfile().getKeyWordIdentIndu() + " for handler: " + getUserProfile().getKeyWordCompanyHandleName());
        if (getUserProfile().getKeyWordCompanyHandleName() != null && getUserProfile().getKeyWordCompanyHandleName().trim().length() > 0) {
            CompanyDTO dto = new CompanyDTO();
            dto.setCompanyName(getUserProfile().getKeyWordCompanyHandleName());
            dto.setKeyWordIdentIndu(getUserProfile().getKeyWordIdentIndu());
            updateKeyWordIdentIndu(getUserProfile().getCompanyHandler(), dto.getCompanyName(), dto.getKeyWordIdentIndu());
            // getUserProfile().setCompanyHandler(getTwitterAccountMgr().getByProfilePreferenceId(getUserProfile().getProfilePreference().getProfilePrefrenceId()));
            
            // Send response to RTOP
            sendResponseToRTOP("update");
        }
    }
    
    private void updateKeyWordIdentIndu(List<TwitterAccountDTO> companyHandler, String companyName, String keyword) throws SVTException {
        for(TwitterAccountDTO dto: companyHandler){
            if(dto.getCompany() != null && dto.getCompany().getCompanyName().equalsIgnoreCase(companyName)){
                dto.getCompany().setKeyWordIdentIndu(keyword);
                getCompanyMgr().update(dto, "INDUSTRY");
                getUserProfile().setKeyWordIdentIndu(keyword);
                //System.out.println("Updated.....Industry: [" + keyword + "]");
                //getProfilePreferenceMgr().updateKeyword(getUserProfile());
                //getUserProfileMgr().updateUserProfile(getUserProfile());   
                //System.out.println(" From Handler: Brand[" + dto.getCompany().getKeyWordIdentBrand() + "] Product[" + dto.getCompany().getKeyWordIdentProd() + "] Industry[" + dto.getCompany().getKeyWordIdentIndu() + "]");                
                return;
             }
        } 
    }
    private void updateKeyWordIdentBrand(List<TwitterAccountDTO> companyHandler, String companyName, String keyword) throws SVTException {
        for(TwitterAccountDTO dto: companyHandler){
            if(dto.getCompany() != null && dto.getCompany().getCompanyName().equalsIgnoreCase(companyName)){
                dto.getCompany().setKeyWordIdentBrand(keyword);
                getCompanyMgr().update(dto,"BRAND");
                getUserProfile().setKeyWordIdentBrand(keyword);
                //System.out.println("Updated.....Brand: [" + keyword + "]");
                //getProfilePreferenceMgr().updateKeyword(getUserProfile());
                //getUserProfileMgr().updateUserProfile(getUserProfile());
                //System.out.println(" From Handler: Brand[" + dto.getCompany().getKeyWordIdentBrand() + "] Product[" + dto.getCompany().getKeyWordIdentProd() + "] Industry[" + dto.getCompany().getKeyWordIdentIndu() + "]");                
                return;
             }
        } 
    }
    private void updateKeyWordIdentProd(List<TwitterAccountDTO> companyHandler, String companyName, String keyword) throws SVTException {
        for(TwitterAccountDTO dto: companyHandler){
            if(dto.getCompany() != null && dto.getCompany().getCompanyName().equalsIgnoreCase(companyName)){
                dto.getCompany().setKeyWordIdentProd(keyword);
                getCompanyMgr().update(dto,"PRODUCT");
                getUserProfile().setKeyWordIdentProd(keyword);
                //System.out.println("Updated.....Product: [" + keyword + "]");
                //getProfilePreferenceMgr().updateKeyword(getUserProfile());
               // getUserProfileMgr().updateUserProfile(getUserProfile());
                //System.out.println(" From Handler: Brand[" + dto.getCompany().getKeyWordIdentBrand() + "] Product[" + dto.getCompany().getKeyWordIdentProd() + "] Industry[" + dto.getCompany().getKeyWordIdentIndu() + "]");                

                return;
             }
        } 
    }
    
    @SuppressWarnings("unused")
    private int getNumberOfKeyWord(String keyword) {
        if(StringUtils.isNotBlank(keyword)) {
            return keyword.split(",").length;
        }
        return 0;
    }
    
    public void authenticateGoogleAccount(ActionEvent actionEvent) throws SVTException, TwitterException {
        System.out.println("Clicked on Authenticate Google Account button: " + getUserProfile().getProfilePreference().getProfilePrefrenceId());
        getUserProfile().setTestbool(true);
        List<GoogleAnalyticsAccountDTO> gadto = getResponseString(getUserProfile().getGoogleAnalyticsUsername(), getUserProfile().getGoogleAnalyticsPassword());
        // getResponseString will always return at least one row
        
        if(gadto.get(0) != null && gadto.get(0).isActiveStatus() == false){
            System.out.println(gadto.get(0).getName()); // failed to authenticate
            getUserProfile().setGoogleAnalyticsAccount(null); 
            gadto.get(0).setName(""); // resetting the error message with blank
            getUserProfile().setGoogleAnalyticAccounts(gadto);

        }else{
            //getUserProfile().setGoogleAnalyticsAccount( gadto.get(0).getName());
            if(getUserProfile().getGoogleAnalyticsAccount() == null || getUserProfile().getGoogleAnalyticsAccount() == ""){
                getUserProfile().setGoogleAnalyticsAccount( gadto.get(0).getName());
            }
            System.out.println("Google Auth passed...: [" + getUserProfile().getGoogleAnalyticsAccount() + "]");
            System.out.println("Setting to seesion attribute:[gadto]");
            
            /////////////////////////////////////////////// NEEDS TO BE REFACTORED, selectItems not working that is why //////////////////////
            setSessionAttribute("gadto", gadto);
            ///////////////////////////////////////////// NEEDS TO BE REFACTORED, selectItems not working that is why ////////////////////////

            getUserProfile().setGoogleAnalyticAccounts(gadto);
                    
            ProfilePreference pp = getUserProfile().getProfilePreference();
            if(pp != null && getUserProfile().getGoogleAnalyticsUsername() != null){
               pp.setGoogleAnalyticsUsername(getUserProfile().getGoogleAnalyticsUsername());
               pp.setGoogleAnalyticsAuth(true);
               getProfilePreferenceMgr().updateGoogleAnalytics(getUserProfile());
            }
            

            // Send response to RTOP
            sendResponseToRTOP("update");
        }
    }   

    public void authenticateGoogleAccount1(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on Authenticate Google Account button: " + getUserProfile().getProfilePreference().getProfilePrefrenceId());
        getUserProfile().setTestbool(true);
        List<GoogleAnalyticsAccountDTO> gadto = getResponseString(getUserProfile().getGoogleAnalyticsUsername(), getUserProfile().getGoogleAnalyticsPassword());
        // getResponseString will always return at least one row
        
        if(gadto.get(0) != null && gadto.get(0).isActiveStatus() == false){
            System.out.println(gadto.get(0).getName()); // failed to authenticate
            getUserProfile().setGoogleAnalyticsAccount(null); 
            gadto.get(0).setName(""); // resetting the error message with blank
            getUserProfile().setGoogleAnalyticAccounts(gadto);

        }else{
            //getUserProfile().setGoogleAnalyticsAccount( gadto.get(0).getName());
            if(getUserProfile().getGoogleAnalyticsAccount() == null || getUserProfile().getGoogleAnalyticsAccount() == ""){
                getUserProfile().setGoogleAnalyticsAccount( gadto.get(0).getName());
            }
            System.out.println("Google Auth passed...: [" + getUserProfile().getGoogleAnalyticsAccount() + "]");
            
            System.out.println("Setting to seesion attribute:[gadto]");
            
            /////////////////////////////////////////////// NEEDS TO BE REFACTORED, selectItems not working that is why //////////////////////
            setSessionAttribute("gadto", gadto);
            ///////////////////////////////////////////// NEEDS TO BE REFACTORED, selectItems not working that is why ////////////////////////
            
            getUserProfile().setGoogleAnalyticAccounts(gadto);
                    
            ProfilePreference pp = getUserProfile().getProfilePreference();
            if(pp != null && getUserProfile().getGoogleAnalyticsUsername() != null){
               pp.setGoogleAnalyticsUsername(getUserProfile().getGoogleAnalyticsUsername());
               pp.setGoogleAnalyticsAuth(true);
               getProfilePreferenceMgr().updateGoogleAnalytics(getUserProfile());
            }           
        }
    }   

    public void removeReportingEmailAddress(ActionEvent actionEvent) throws SVTException, TwitterException {
        String email = actionEvent.getComponent().getAttributes().get("reportingEmail").toString();
        // System.out.println("[" + email + "]");
        if (email != null) {
            UserProfileDetailDTO dto = getUserProfile();
            if (email.equalsIgnoreCase("1")) {
                dto.setReportingEmail1("");
            } else if (email.equalsIgnoreCase("2")) {
                dto.setReportingEmail2("");
            } else if (email.equalsIgnoreCase("3")) {
                dto.setReportingEmail3("");
            }
            dto.setUpdatedBy(getCurrentUid());
            getUserProfileMgr().updateUserProfileLight(dto);
            

            // Send response to RTOP
            sendResponseToRTOP("update");
        }
    }
    
    public void removeTwitterAccount(ActionEvent actionEvent) throws SVTException, TwitterException {
        //System.out.println("Clicked on removeTwitterAccount " +  getUserProfile().getProfilePreference());
        String tid = actionEvent.getComponent().getAttributes().get( "twitterId" ).toString();

        //System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> " + tid);

        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setTwitterAccountId(tid);
        getTwitterAccountMgr().delete(dto);

        // This will refresh the value with above addition
        getUserProfile().setSelfTwtAccounts(getTwitterAccountMgr().getByProfilePreferenceIdSELF(getUserProfile().getProfilePreference().getProfilePrefrenceId())); 
        getUserProfile().setCompTwtAccountsHandle1(getTwitterAccountMgr().getByProfilePreferenceIdCompNameNOTSELF(getUserProfile().getProfilePreference().getProfilePrefrenceId(), "Competitor #1"));
        getUserProfile().setCompTwtAccountsHandle2(getTwitterAccountMgr().getByProfilePreferenceIdCompNameNOTSELF(getUserProfile().getProfilePreference().getProfilePrefrenceId(), "Competitor #2"));
        getUserProfile().setCompTwtAccountsHandle3(getTwitterAccountMgr().getByProfilePreferenceIdCompNameNOTSELF(getUserProfile().getProfilePreference().getProfilePrefrenceId(), "Competitor #3"));
        //getUserProfile().setCompanyHandler(getTwitterAccountMgr().getByProfilePreferenceId(getUserProfile().getProfilePreference().getProfilePrefrenceId()));
        
        // Send response to RTOP
        sendResponseToRTOP("update");
    }
    
    private List<GoogleAnalyticsAccountDTO> getResponseString(String userName, String password){
        List<GoogleAnalyticsAccountDTO> dtos = new ArrayList<GoogleAnalyticsAccountDTO>();
        
        if(userName.length()>0 && password.length()>0){            
            try {                
                GDataFeedRetrieve gData = new GDataFeedRetrieve(userName,password);
                //String accountName[] = gData.getAccountFeedByProperty("ga:accountName");
                String accountName1[][] = gData.getAccountFeedByPropertyWithTableId("ga:accountName");
                //                
                if(accountName1!=null){
                    /*for(int i=0;i<accountName.length;i++){
                        GoogleAnalyticsAccountDTO dto = new GoogleAnalyticsAccountDTO();
                        dto.setName(accountName[i]);
                        dto.setActiveStatus(true);
                        dtos.add(dto);
                    }*/
                    for(int i=0;i<accountName1.length;i++){
                        GoogleAnalyticsAccountDTO dto = new GoogleAnalyticsAccountDTO();
                        dto.setName(accountName1[i][0]);
                        dto.setGoogleAnalyticsTableId(accountName1[i][1]); //TODO: dont know why it is not working on adding this value: (accountName1[i][1]);
                        dto.setActiveStatus(true);
                        dtos.add(dto);
                    }
                }else{
                    // No account found
                    GoogleAnalyticsAccountDTO dto = new GoogleAnalyticsAccountDTO();
                    dto.setName("No account found");
                    dto.setActiveStatus(false);
                    dtos.add(dto);
                }
                } catch (AuthenticationException e) {
                    // Authentication failed
                    GoogleAnalyticsAccountDTO dto = new GoogleAnalyticsAccountDTO();
                    dto.setName("Authentication failed");
                    dto.setActiveStatus(false);
                    dtos.add(dto);                    
                }catch (IOException e) {
                    //Network error trying to retrieve feed
                    GoogleAnalyticsAccountDTO dto = new GoogleAnalyticsAccountDTO();
                    dto.setName("Network error trying to retrieve feed");
                    dto.setActiveStatus(false);
                    dtos.add(dto);  
                }catch (ServiceException e) {
                    // Analytics API responded with an error message
                    GoogleAnalyticsAccountDTO dto = new GoogleAnalyticsAccountDTO();
                    dto.setName("Network error trying to retrieve feed");
                    dto.setActiveStatus(false);
                    dtos.add(dto);
                }
                
        }else{
            GoogleAnalyticsAccountDTO dto = new GoogleAnalyticsAccountDTO();
            dto.setName("User name or password empty");
            dtos.add(dto);
        }        
        return dtos;
    }
    
    @Deprecated //use addTwitterAccountCmptHandler1
    public void validateTwitterAccountCmptHandler1(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on cmpt Add button: " + getTwitterAccountName());
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setHandlerName("Competitor #1");
        setTwitterAccountCmptValue(dto, getTwitterCmptAccountName1());
    }
    
    @Deprecated //use addTwitterAccountCmptHandler2
    public void validateTwitterAccountCmptHandler2(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on Add button2: " + getTwitterAccountName());
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setHandlerName("Competitor #2");
        setTwitterAccountCmptValue(dto, getTwitterCmptAccountName2());
    }
    
    @Deprecated //use addTwitterAccountCmptHandler3
    public void validateTwitterAccountCmptHandler3(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on Add button3: " + getTwitterAccountName());
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setHandlerName("Competitor #3");
        setTwitterAccountCmptValue(dto, getTwitterCmptAccountName3());
    }
    
    public UserProfileDetailDTO getUserProfile() {
        return getUserProfileController().getUserProfile();
    }

    public void setUserProfile(UserProfileDetailDTO userProfile) {
        getUserProfileController().setUserProfile(userProfile);
    }
    
    public UserProfileController getUserProfileController() {
        return userProfileController;
    }

    public void setUserProfileController(UserProfileController userProfileController) {
        this.userProfileController = userProfileController;
    }

    public String getTwitterAccountName() {
        return twitterAccountName;
    }

    public void setTwitterAccountName(String twitterAccountName) {
        this.twitterAccountName = twitterAccountName;
    }

    public String getTwitterCmptAccountName1() {
        return twitterCmptAccountName1;
    }

    public void setTwitterCmptAccountName1(String twitterCmptAccountName1) {
        this.twitterCmptAccountName1 = twitterCmptAccountName1;
    }

    public String getTwitterCmptAccountName2() {
        return twitterCmptAccountName2;
    }

    public void setTwitterCmptAccountName2(String twitterCmptAccountName2) {
        this.twitterCmptAccountName2 = twitterCmptAccountName2;
    }

    public String getTwitterCmptAccountName3() {
        return twitterCmptAccountName3;
    }

    public void setTwitterCmptAccountName3(String twitterCmptAccountName3) {
        this.twitterCmptAccountName3 = twitterCmptAccountName3;
    }    
}