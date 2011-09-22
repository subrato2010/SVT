package com.edifixio.soc.web.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.naming.NamingException;

import org.apache.myfaces.custom.fileupload.UploadedFile;
import org.richfaces.datahelper.SessionDataHelper;

import twitter4j.TwitterException;

import com.edifixio.soc.biz.dto.GoogleAnalyticsAccountDTO;
import com.edifixio.soc.biz.dto.StateProvinceDTO;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ImprovementLevel;
import com.edifixio.soc.web.dto.TwitterRTOPNotifyDTO;
import com.edifixio.soc.web.ldap.LDAPUserMgmt;
import com.edifixio.soc.web.util.ImageScaler;

public class UserProfileController extends JSONController
{
    
    private static final int PHOTO_WIDTH = 61;
    private static final int PHOTO_HEIGHT = 61;
    
    private static final int LOGO_WIDTH = 195;
    private static final int LOGO_HEIGHT = 115;
    
    private static final String DEFAULT_PHOTO_PATH = "/images/demoPerson.png";
    private static final String RETYPE_PASSWORD = "editProfile:retypePassword";
    private static final String PASSWORD = "editProfile:password";
    
    private UserProfileDetailDTO userProfile;
    private List<TwitterAccountDTO> twitterAccount;
    private List<ImprovementLevel> improvementLevel;   
    private UploadedFile photoFile;
    private UploadedFile logoFile;
    private String completeFlag;
    private String retypePassword;
    private String password="temporary";
    private String closeProfilePopup;
    private String rtopURL;
    
    private String benchmarkStDate;
    private String benchmarkEdDate;
    
    private boolean validationRequired; // added by Neel 24-05-2011
    
    private String retypePasswordBackgroundColor="#FFFFFF";
    
    private TwitterController twitterController;
    
   public boolean getRefresh() throws SVTException{
       setUserProfileValue();
       return true;
   }
   
   
   
   public void setUserProfileValue() throws SVTException{
       String userId = getCurrentUid();
       if(userId != null){
           userProfile = getUserProfileMgr().getProfileByUserId(userId);
           if(userProfile != null && userProfile.getProfilePreference() != null){
               setTwitterAccount(getTwitterAccountMgr().getByProfilePreferenceId(userProfile.getProfilePreference().getProfilePrefrenceId()));                
           }
           setImprovementLevel(getImprovementLevelMgr().findAll());
       }
       //TODO : will remove later on.
       //setSessionAttribute("userProfileController", this); // Added By Neel, To use in the ManageTwitterOperation
       completeFlag = "no";
   }
   
   public UserProfileController() throws SVTException    {
       setUserProfileValue();
    }
   
    public UserProfileDetailDTO getUserProfile() {
        return userProfile;
    }


    public void setUserProfile(UserProfileDetailDTO userProfile) {
        this.userProfile = userProfile;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRetypePassword() {
        return retypePassword;
    }


    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }
    
    public UploadedFile getPhotoFile() {
        return photoFile;
    }


    public void setPhotoFile(UploadedFile photoFile) {
        this.photoFile = photoFile;
    }


    public UploadedFile getLogoFile() {
        return logoFile;
    }


    public void setLogoFile(UploadedFile logoFile) {
        this.logoFile = logoFile;
    }
    
    public String getCompleteFlag() {
        return completeFlag;
    }

    public void setCompleteFlag(String completeFlag) {
        this.completeFlag = completeFlag;
    }

    public boolean isClosable(){
        return (completeFlag.equalsIgnoreCase("yes"));
    }

    public BackingBean getBackingBeanInstance()    {
        return (BackingBean)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("backingBean");
    }
    public TwitterController getTwitterControllerInstance() {
        return (TwitterController)FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("twitterController");
    }
    /**
     * added by Neel 20-05-2011
     * @throws SVTException
     */
    private void persistEntryFields() throws SVTException {
        getUserProfile().setFirstTimeLogin(true);
        /**
         * SG: by some reason, we are unable to use f:selectItems in editProfile for google analytics,
         * when we are storing value, actionlistener is not firing properly, so for the timing, we doing in a very wrong way.
         * TO BE REFACTORED 
         */
        setGoogleAnalyticsTableId(userProfile);
        getUserProfileMgr().updateUserProfile(userProfile);
    }
    
    public void saveProfile(ActionEvent ae)
    {
        try{
            //System.out.println("UserProfileController saveProfile called ........."+getTwitterController());
            if(getTwitterController() != null)
                getTwitterController().setValidCredentials(true);

            if(getParameter("chk")!=null)
                getSelectedType(getParameter("chk"));
//                     
            if(getBackingBeanInstance().doValidateFields(userProfile) ==  null) // for validate the fields
             {
                 System.out.println("Not a valid Entry!!!!!!!!!!!!!!!!!!");
                 if(getParameter("screenName")!=null && 
                    getParameter("screenName").equalsIgnoreCase("createprofile")){ // need to do for createprofile only
                     persistEntryFields(); // added by Neel 20-05-2011    
                 }
                 
                 if(getParameter("validationRequired") != null && getParameter("validationRequired").equalsIgnoreCase("false")){
                     setCompleteFlag(getProfilePopupClose());
                     setValidationRequired(false);// added by Neel 24-05-2011
                 }                 
                 return;
             }
//                
            //Added By Neel, Ended Here
            if(logoFile != null){
                //scale image
                byte[] logoContent = ImageScaler.getScalledImge(logoFile.getBytes(), LOGO_WIDTH, LOGO_HEIGHT);
                userProfile.setLogo( logoContent);
            }
            
            if(photoFile != null){
                //scale image
                byte[] photoContent = ImageScaler.getScalledImge(photoFile.getBytes(), PHOTO_WIDTH, PHOTO_HEIGHT);                
                userProfile.setPhoto( photoContent);
            }
            if(password != null && !password.equals("") && retypePassword != null && password.equals(retypePassword))
                userProfile.setPassword(password);

            //displayUserProfile(userProfile);
            
            setAllSelectedBrandProdIndu(); // Using parameter, I know this is not good practice, needs to be changed
            
            getUserProfile().setFirstTimeLogin(false); // added by Neel 20-05-2011
            
            /**
             * SG: by some reason, we are unable to use f:selectItems in editProfile for google analytics,
             * when we are storing value, actionlistener is not firing properly, so for the timing, we doing in a very wrong way.
             * TO BE REFACTORED 
             */
            setGoogleAnalyticsTableId(userProfile);
            
            
            getUserProfileMgr().updateUserProfile(userProfile);
            if(getTwitterController() != null)  {
                getTwitterController().setOpenEditProfile("");
            }
            setValidationRequired(true); // Used for createProfile.jsp, added by Neel 24-05-2011
            setSessionAttribute("actionTakenOnPopup", null); // used inside TwitterController constructor.
            setSessionAttribute("validCredentials", null); // used inside TwitterController constructor.
            
            System.out.println("Needs to close..... popup: " + getProfilePopupClose());
            setCompleteFlag(getProfilePopupClose());
            

            // Send response to RTOP
            sendResponseToRTOP("update");
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
    private void setGoogleAnalyticsTableId(UserProfileDetailDTO updto) {        
        if(updto.getGoogleAnalyticsAccount() != null){
            List<GoogleAnalyticsAccountDTO> dtos =  (List<GoogleAnalyticsAccountDTO>) getObjSessionAttribute("gadto"); 
            if(dtos == null){
                return;
            }
            for(GoogleAnalyticsAccountDTO dto: dtos){
                if(updto.getGoogleAnalyticsAccount().equalsIgnoreCase(dto.getName())){
                    if(dto.getGoogleAnalyticsTableId() != null && dto.getGoogleAnalyticsTableId().trim().length() > 0){
                        updto.setGoogleAnalyticsTableId(dto.getGoogleAnalyticsTableId());
                        return;                        
                    }
                }
            }
        }        
    }



    public void validatePassword(FacesContext context, UIComponent component, Object value) throws ValidatorException { 
        
        String retypePassword =  (String)context.getExternalContext().getRequestParameterMap().get(RETYPE_PASSWORD);
        String password =  (String)context.getExternalContext().getRequestParameterMap().get(PASSWORD);
          
        
        if(password.equals("temporary") && (retypePassword ==null || retypePassword.trim().equals(""))) {
            this.password = getUserProfile().getPassword();
            setPassword(this.password);
        }
        else if(retypePassword !=null || !retypePassword.trim().equals(""))
        {
            System.out.println(2);
            if(!password.equals(retypePassword))
            {
                setRetypePasswordBackgroundColor("#FDE2D9");
                throw new ValidatorException(new FacesMessage("THIS IS NOT A VALID ENTRY"));
            }
        }
        else if(retypePassword == null || retypePassword.length() == 0)  {
            System.out.println(3);
            throw new ValidatorException(new FacesMessage("THIS IS NOT A VALID ENTRY"));
        }
     }
     public void validateRetypePassword(FacesContext context, UIComponent component, Object value) throws ValidatorException { 
         String retypePassword = (String) value;
         String password =  (String)context.getExternalContext().getRequestParameterMap().get(PASSWORD);

         if(password == null || password.length() == 0){
             throw new ValidatorException(new FacesMessage("THIS IS NOT A VALID ENTRY"));
         }
         else if(password.equals("temporary"))
         {
             System.out.println("Inside else if !!!!!!!!!!!!!!!!!! ");
             password = getUserProfile().getPassword();
             setPassword(password);
             return;
         }
         else if(!password.equals(retypePassword)){
             throw new ValidatorException(new FacesMessage("THIS IS NOT A VALID ENTRY"));
         }
      }
     
    private void setAllSelectedBrandProdIndu() {

        //Self twitter accounts handler
        int objPosition =0;
        for(TwitterAccountDTO dto: userProfile.getSelfTwtAccounts()){
            String bpi = getParameter("vkb" + objPosition);
            if(bpi != null){
                dto.setBrndProdInds(bpi);                
            }
            objPosition++;
        }

        //Cmpt1 twitter accounts handler
        objPosition =0;
        for(TwitterAccountDTO dto: userProfile.getCompTwtAccountsHandle1()){
            String bpi = getParameter("vkb1" + objPosition);
            if(bpi != null){
                dto.setBrndProdInds(bpi);                
            }
            objPosition++;
        }
        //Cmpt2 twitter accounts handler
        objPosition =0;
        for(TwitterAccountDTO dto: userProfile.getCompTwtAccountsHandle2()){            
            String bpi = getParameter("vkb2" + objPosition);
            if(bpi != null){
                dto.setBrndProdInds(bpi);                
            }
            objPosition++;
        }
        //Cmpt3 twitter accounts handler
        objPosition =0;
        for(TwitterAccountDTO dto: userProfile.getCompTwtAccountsHandle3()){
            String bpi = getParameter("vkb3" + objPosition);
            if(bpi != null){
                dto.setBrndProdInds(bpi);                
            }
            objPosition++;
        }
        
    }

    public void displayUserProfile(UserProfileDetailDTO userProfile){
        
        System.out.println("getName: " + userProfile.getName());
        System.out.println("getCompany: " + userProfile.getCompany());
        System.out.println("getTitle:" + userProfile.getTitle());
        System.out.println("getEmailAddress: " + userProfile.getEmailAddress());
        System.out.println("getReportingEmail1:" + userProfile.getReportingEmail1());
        System.out.println("getReportingEmail2: " + userProfile.getReportingEmail2());
        System.out.println("getReportingEmail3: " + userProfile.getReportingEmail3());
        System.out.println("getTimezone: " + userProfile.getTimezone());
        System.out.println("getTwitterAccountNameSelf: " + userProfile.getTwitterAccountNameSelf());
        System.out.println("getTwitterCmptAccountName1: " + userProfile.getTwitterCmptAccountName1());
        System.out.println("getTwitterCmptAccountName2: " + userProfile.getTwitterCmptAccountName2());
        System.out.println("getTwitterCmptAccountName3: " + userProfile.getTwitterCmptAccountName3());
        System.out.println("getImprovementLevelId: " + userProfile.getImprovementLevelId());
        
    }
    
    
    
    
    public String cancel(){
        setCompleteFlag("yes");
        return null;
    }
    
    public void paint(OutputStream out, Object key) throws IOException{

       /* if(key != null)
        {
            byte[] data = (byte[])SessionDataHelper.getDataByKey(key);
            if(out != null && data != null){
                out.write(data);
                out.flush();
            }
        }*/
    }
    
    @Deprecated //use paintProfilePhotoOrDefault instead
    public void paintPhotoOrDefault(OutputStream out, Object key) throws IOException{

        if(key != null)
        {
            byte[] data = (byte[])SessionDataHelper.getDataByKey(key);
            if(out != null && data != null){
                out.write(data);
                out.flush();
            }else{
                InputStream is = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(DEFAULT_PHOTO_PATH);
                if(is != null && out != null){
                    int i=0;
                    while(i != -1){
                        i = is.read();
                        out.write(i);
                    }
                    out.flush();
                }else{
                    System.out.println("resource not found.");
                }
            }
        }
    }   

    public void paintProfilePhotoOrDefault(OutputStream out, Object key) throws IOException{

        if(userProfile.getPhoto() != null){
           out.write(userProfile.getPhoto()) ;
        }else{
            InputStream is = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream(DEFAULT_PHOTO_PATH);
            if(is != null && out != null){
                int i=0;
                while(i != -1){
                    i = is.read();
                    out.write(i);
                }
                out.flush();
            }else{
                System.out.println("resource not found.");
            }
        }
    }   

    
    public void validatePhone(FacesContext context, UIComponent component, Object value) throws ValidatorException { 
        String phone = (String)value;
        phone = phone.replaceAll("-", "");
        try{
            long l = Long.parseLong(phone);
        }catch(NumberFormatException ne){
            throw new ValidatorException(new FacesMessage("Please provide 0-9,-."));
        }
        
        if(phone.length() < 10){
            throw new ValidatorException(new FacesMessage("THIS IS NOT A VALID ENTRY"));
        }
    }
    /** 
     * Added By Neel, dated 26-11-2010
     * @param userProfileDTO
     * @return
     * @throws SVTException
     * @throws NamingException
     */
    public boolean createLDAPUser(UserProfileDetailDTO userProfileDTO) throws SVTException, NamingException
    {
         getTwitterAccountMgr().collectLDAPTwitterData(userProfileDTO); 
           if(new LDAPUserMgmt().createUser(userProfileDTO)) 
           {
               /**
                * if this condition will be satisfied, it means that, the data is been successfully inserted inside the 
                * ldap server. Now the time is to insert the data inside the persistence layer throw our biz layer.
                */
               getTwitterAccountMgr().collectLDAPTwitterData(userProfileDTO); 
               return true;
           }
           return false;
    }
    /**
     * Added By Neel, dated 26-11-2010
     * @param userProfileDTO
     * @return
     * @throws SVTException
     * @throws NamingException
     */
    public boolean updateLDAPUser(UserProfileDetailDTO userProfileDTO, String userID) throws SVTException, NamingException
    {
        if(new LDAPUserMgmt().editUser(userProfileDTO,userID))
        {
            /**
             * if this condition will be satisfied, it means that, the data is been successfully inserted inside the 
             * ldap server. Now the time is to insert the data inside the persistence layer throw our biz layer.
             */
            getTwitterAccountMgr().collectLDAPTwitterData(userProfileDTO); 
           return true;
        }
        return false;
    }
    
    public boolean searchLDAPUser(UserProfileDetailDTO userProfileDTO,String userID) throws NamingException, SVTException
    {
        if(new LDAPUserMgmt().searchForLDAPUser(userProfileDTO, userID))
            return true;
        return false;
    }
    public SelectItem[] getStateOptions()
    {
        List<StateProvinceDTO> statesList = null;
        try {
            statesList = getStateProvinceMgr().findAll();
        } catch (SVTException e) {
            e.printStackTrace();
        }
        if(statesList != null && statesList.size() > 0){
            
            SelectItem[] states = new SelectItem[statesList.size()];
            for (int i = 0; i <statesList.size(); i++) {
                states[i] = new SelectItem();
                states[i].setLabel(statesList.get(i).getName());
                states[i].setValue(statesList.get(i).getAbbrev());
            }
            return states;
        }
        else
            return null;
    }
//--------- Added By Neel, Started Here ------------------------------ 
    public SelectItem[] getAllTwitterAccounts()
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
//--------- Added By Neel, Ended Here ------------------------------    
//    public SelectItem[] getAllCompanyHandlers()
//    {
//        List<TwitterAccountDTO> twtAccList = userProfile.getCompanyHandler();
//        Set<String> companySet = new HashSet<String>();
//        for(TwitterAccountDTO dto : twtAccList){
//            companySet.add(dto.getCompany().getCompanyName());
//        }
//        
//        SelectItem[] acc;
//        if(companySet.size() > 0){
//            acc = new SelectItem[companySet.size()];
//            int i = 0;
//            for(String s : companySet){
//                if(i==0){
//                    setFirstItemCompanyList(s);
//                }
//                acc[i] = new SelectItem(); 
//                acc[i].setLabel(s);
//                acc[i].setValue(s);    
//                i++;
//            }
//        }else{
//            acc = new SelectItem[1];
//            acc[0]=new SelectItem(); 
//            acc[0].setLabel("");
//            acc[0].setValue(""); 
//        }
//        return acc;
//    }
       
    public List<TwitterAccountDTO> getTwitterAccount() {
        return twitterAccount;
    }

    public void setTwitterAccount(List<TwitterAccountDTO> twitterAccount) {
        this.twitterAccount = twitterAccount;
    }
    
    public void getSelectedType(String selectedValue)    {
        userProfile.setImprovementLevelId(selectedValue);
    }

    public List<ImprovementLevel> getImprovementLevel() {
        return improvementLevel;
    }

    public void setImprovementLevel(List<ImprovementLevel> improvementLevel) {
        this.improvementLevel = improvementLevel;
    }

    public String getCloseProfilePopup() {
        return closeProfilePopup;
    }

    public void setCloseProfilePopup(String closeProfilePopup) {
        this.closeProfilePopup = closeProfilePopup;
    }



    public String getBenchmarkStDate() {
        return getDateMMDDYYYY(getUserProfile().getProfilePreference().getBenchmark().getBenchmarkStDate());
    }

    public String getBenchmarkEdDate() {
        return getDateMMDDYYYY(getUserProfile().getProfilePreference().getBenchmark().getBenchmarkEdDate()); 
    }
    
    @Deprecated
    public String getActualDateFormat(String date)    {
        date = date.replace("00", "").replace(":","").replace(".0", "").replace("-", "/");
        String []dateFormat = date.split("/");
        return dateFormat[2]+"/"+dateFormat[1]+"/"+dateFormat[0];
    }


    public TwitterController getTwitterController() {
        return twitterController;
    }



    public void setTwitterController(TwitterController twitterController) {
        this.twitterController = twitterController;
    }



    public String getRetypePasswordBackgroundColor() {
        return retypePasswordBackgroundColor;
    }



    public void setRetypePasswordBackgroundColor(
            String retypePasswordBackgroundColor) {
        this.retypePasswordBackgroundColor = retypePasswordBackgroundColor;
    }



    public boolean isValidationRequired() {
        return validationRequired;
    }



    public void setValidationRequired(boolean validationRequired) {
        this.validationRequired = validationRequired;
    }



    public String getRtopURL() throws SVTException {
        if(getSessionAttribute("rtopurl") == null){
           setSessionAttribute("rtopurl", getParameterMgr().getDatashiftAppURL());
        }
        return getSessionAttribute("rtopurl");
    }
    
    public String getPostToRTOP() throws TwitterException, SVTException {
        sendResponseToRTOP("login");        
        return "";
    }
}
