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

import com.edifixio.soc.biz.dto.StateProvinceDTO;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ImprovementLevel;
import com.edifixio.soc.web.ldap.LDAPUserMgmt;
import com.edifixio.soc.web.util.ImageScaler;

public class UserProfileController extends BaseWebObject
{
    
    private static final int PHOTO_WIDTH = 61;
    private static final int PHOTO_HEIGHT = 61;
    
    private static final int LOGO_WIDTH = 195;
    private static final int LOGO_HEIGHT = 115;
    
    private static final String DEFAULT_PHOTO_PATH = "/images/logo.jpg";
    private static final String RETYPE_PASSWORD = "editProfile:retypePassword";
    private static final String PASSWORD = "editProfile:password";
    
    private UserProfileDetailDTO userProfile;
    private List<TwitterAccountDTO> twitterAccount;
    private List<ImprovementLevel> improvementLevel;   
    private UploadedFile photoFile;
    private UploadedFile logoFile;
    private String completeFlag;
    private String retypePassword;
    private String password;
    
   
   public UserProfileController() throws SVTException
    {
      String userId = getCurrentUid();
        if(userId != null){
            userProfile = getUserProfileMgr().getProfileByUserId(userId);
            setTwitterAccount(getTwitterAccountMgr().getByProfilePreferenceId("1"));
            setImprovementLevel(getImprovementLevelMgr().findAll());
        }
       /* System.out.println("parameter is !!! "+getParameter("Level"));
        if(getParameter("Level")== null ||getParameter("Level").equals(""));
        else
        if(getParameter("Level").equalsIgnoreCase("Level"))
            getSelectedType();*/
        completeFlag = "no";
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
    public void saveProfile(ActionEvent ae)
    {
        try{
            //Added By Neel, Started Here
            if(getParameter("chk")!=null)
                getSelectedType(getParameter("chk"));
                     
             if(getBackingBeanInstance().doValidateFields(userProfile) ==  null) // for validate the fields
                 return;
                
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

            getUserProfileMgr().updateUserProfile(userProfile);
            setCompleteFlag("yes");
        }catch(Exception e){
            e.printStackTrace();
        } 
        //return null;
    }
    
    public String cancel(){
        setCompleteFlag("yes");
        return null;
    }
    
    public void paint(OutputStream out, Object key) throws IOException{

        if(key != null)
        {
            byte[] data = (byte[])SessionDataHelper.getDataByKey(key);
            if(out != null && data != null){
                out.write(data);
                out.flush();
            }
        }
    }
    
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
    
    public void validatePassword(FacesContext context, UIComponent component, Object value) throws ValidatorException { 
        
       String retypePassword =  (String)context.getExternalContext().getRequestParameterMap().get(RETYPE_PASSWORD);
       if(retypePassword == null || retypePassword.length() == 0){
           throw new ValidatorException(new FacesMessage("please retype password."));
       }
    }
    public void validateRetypePassword(FacesContext context, UIComponent component, Object value) throws ValidatorException { 

        String retypePassword = (String) value;
        String password =  (String)context.getExternalContext().getRequestParameterMap().get(PASSWORD);

        if(password == null || password.length() == 0){
            throw new ValidatorException(new FacesMessage("Please type password."));
        }
        else if( !password.equals(retypePassword)){
            throw new ValidatorException(new FacesMessage("Password mismatch."));
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
            throw new ValidatorException(new FacesMessage("Please provide valid phone number."));
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
}
