package com.edifixio.soc.web.controllers;

import java.util.List;

import javax.faces.event.ValueChangeEvent;

import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.common.SVTException;


public class BackingBean extends UserProfileController {
    public BackingBean() throws SVTException {
        setColor("white");
    }

    private String color;
    private String color1;
    private String color2;
    
    private String nameColor;
    private String titleColor;
    private String companyColor;
    private String workAddressColor;
    private String cityColor;
    private String zipColor;
    private String userNameColor;
    
    private String twitterAccountName;
    private String twitterCmptAccountName1;
    private String twitterCmptAccountName2;
    private String twitterCmptAccountName3;
    private String compTwittAccCol2;
    private String compTwittAccErr2;
    private String compTwittAccCol3;
    private String compTwittAccErr3;
    
    private String mailCol;
    private String vanityMailCol;
    private String twittAccCol;
    private String compTwittAccCol;
    private String googleAnaCol;
    private String errMsg;
    private String errMsg1;
    private String errMsg2;
    
    private String nameErrMsg;
    private String titleErrMsg;
    private String companyErrMsg;
    private String workAddressErrMsg;
    private String cityErrMsg;
    private String zipErrMsg;
    private String userNameErrMsg;
    
    private String mailErr;
    private String vanityMailerr;
    private String twittAccErr;
    private String googleAnaErr;
    private String compTwittAccErr;
    
    private final String ERR_CODE = "#FDE2D9";
    private final String ERR_MSG = "THIS IS NOT A VALID ENTRY";


    public String getCompTwittAccCol()                      {   return compTwittAccCol;                     }
    public void setCompTwittAccCol(String compTwittAccCol)  {   this.compTwittAccCol = compTwittAccCol;     }
    public String getCompTwittAccErr()                      {   return compTwittAccErr;                     }
    public void setCompTwittAccErr(String compTwittAccErr)  {   this.compTwittAccErr = compTwittAccErr;     }
    public String getGoogleAnaCol()                         {   return googleAnaCol;                        }
    public void setGoogleAnaCol(String googleAnaCol)        {   this.googleAnaCol = googleAnaCol;           }
    public String getGoogleAnaErr()                         {   return googleAnaErr;                        }
    public void setGoogleAnaErr(String googleAnaErr)        {   this.googleAnaErr = googleAnaErr;           }
    public String getTwittAccCol()                          {   return twittAccCol;                         }
    public void setTwittAccCol(String twittAccCol)          {   this.twittAccCol = twittAccCol;             }
    public String getTwittAccErr()                          {   return twittAccErr;                         }
    public void setTwittAccErr(String twittAccErr)          {   this.twittAccErr = twittAccErr;             }
    public String getVanityMailCol()                        {   return vanityMailCol;                       }
    public void setVanityMailCol(String vanityMailCol)      {   this.vanityMailCol = vanityMailCol;         }
    public String getVanityMailerr()                        {   return vanityMailerr;                       }
    public void setVanityMailerr(String vanityMailerr)      {   this.vanityMailerr = vanityMailerr;         }
    public String getMailCol()                              {   return mailCol;                             }
    public void setMailCol(String mailCol)                  {   this.mailCol = mailCol;                     }
    public String getMailErr()                              {   return mailErr;                             }
    public void setMailErr(String mailErr)                  {   this.mailErr = mailErr;                     }
    public String getColor2()                               {   return color2;                              }
    public void setColor2(String color2)                    {   this.color2 = color2;                       }
    public String getColor1()                               {   return color1;                              }
    public void setColor1(String color1)                    {   this.color1 = color1;                       }
    public String getErrMsg2()                              {   return errMsg2;                             }
    public void setErrMsg2(String errMsg2)                  {   this.errMsg2 = errMsg2;                     }
    public String getErrMsg1()                              {   return errMsg1;                             }
    public void setErrMsg1(String errMsg1)                  {   this.errMsg1 = errMsg1;                     }
    public String getErrMsg()                               {   return errMsg;                              }
    public void setErrMsg(String errMsg)                    {   this.errMsg = errMsg;                       }
    public void setColor(String color)                      {   this.color = color;                         }
    public String getColor()                                {   return color;                               }
    public String getNameColor()                            {   return nameColor;                           }
    public void setNameColor(String nameColor)              {   this.nameColor = nameColor;                 }
    public String getNameErrMsg()                           {   return nameErrMsg;                          }
    public void setNameErrMsg(String nameErrMsg)            {   this.nameErrMsg = nameErrMsg;               }
    public String getTitleColor()                           {   return titleColor;                          }
    public void setTitleColor(String titleColor)            {   this.titleColor = titleColor;               }
    public String getCompanyColor()                         {   return companyColor;                        }
    public void setCompanyColor(String companyColor)        {   this.companyColor = companyColor;           }
    public String getWorkAddressColor()                     {   return workAddressColor;                    }
    public void setWorkAddressColor(String workAddressColor){   this.workAddressColor = workAddressColor;   }
    public String getCityColor()                            {   return cityColor;                           }
    public void setCityColor(String cityColor)              {   this.cityColor = cityColor;                 }
    public String getZipColor()                             {   return zipColor;                            }
    public void setZipColor(String zipColor)                {   this.zipColor = zipColor;                   }
    public String getUserNameColor()                        {   return userNameColor;                       }
    public void setUserNameColor(String userNameColor)      {   this.userNameColor = userNameColor;         }
    public String getTitleErrMsg()                          {   return titleErrMsg;                         }
    public void setTitleErrMsg(String titleErrMsg)          {   this.titleErrMsg = titleErrMsg;             }
    public String getCompanyErrMsg()                        {   return companyErrMsg;                       }
    public void setCompanyErrMsg(String companyErrMsg)      {   this.companyErrMsg = companyErrMsg;         }
    public String getWorkAddressErrMsg()                    {   return workAddressErrMsg;                   }
    public void setWorkAddressErrMsg(String workAddressErrMsg) {    this.workAddressErrMsg = workAddressErrMsg;}
    public String getCityErrMsg()                           {   return cityErrMsg;                          }
    public void setCityErrMsg(String cityErrMsg)            {   this.cityErrMsg = cityErrMsg;               }
    public String getZipErrMsg()                            {   return zipErrMsg;                           }
    public void setZipErrMsg(String zipErrMsg)              {   this.zipErrMsg = zipErrMsg;                 }
    public String getUserNameErrMsg()                       {   return userNameErrMsg;                      }
    public void setUserNameErrMsg(String userNameErrMsg)    {   this.userNameErrMsg = userNameErrMsg;       }
    
   //UserProfileDetailDTO userProfile;
    
    boolean flag = false;
    public BackingBean doValidateFields(UserProfileDetailDTO userProfile)
    {
        flag = false;
        
        System.out.println("Inside Backing Bean : !!!!!!!!!!!   :   "+userProfile.getKeyWordCompanyHandleName());
        if(                
            (userProfile.getKeyWordCompanyHandleName() != null && 
             (userProfile.getKeyWordCompanyHandleName().equalsIgnoreCase("Customer") &&
              (userProfile.getKeyWordIdentBrand().trim().equals("") || 
              userProfile.getKeyWordIdentProd().trim().equals("") || 
              userProfile.getKeyWordIdentIndu().trim().equals("")
             )))|| 
               userProfile.getSelfTwtAccounts().isEmpty() ||
               userProfile.getName().trim().equals("")|| 
               //userProfile.getEmailAddress().trim().equals("") ||
               userProfile.getTitle().trim().equals("")|| 
               userProfile.getUid().trim().equals("") ||
               ( userProfile.getCity() == null ||userProfile.getCity().trim().equals(""))|| // I think this line is not required, NEEL (Is it mandatory field ?)
               (userProfile.getReportingEmail1().trim().equals("") && 
                userProfile.getReportingEmail2().trim().equals("") && 
                userProfile.getReportingEmail3().trim().equals("")) ||
               (userProfile.getCompTwtAccountsHandle1().isEmpty() &&
               userProfile.getCompTwtAccountsHandle2().isEmpty() &&
               userProfile.getCompTwtAccountsHandle3().isEmpty()))
           {
             validateFields(userProfile);
             if(flag==true) // TODO : This code need to be refactored 
                 return null;
             else
                 return this;
           }
           return this;
    }
    
    
    public void validateFields(UserProfileDetailDTO userProfile) {
            if (userProfile.getKeyWordIdentBrand().trim().equals("")) validateBrand(userProfile.getKeyWordIdentBrand().trim());
            if (userProfile.getKeyWordIdentProd().trim().equals(""))  validateProduct(userProfile.getKeyWordIdentProd().trim());
            if (userProfile.getKeyWordIdentIndu().trim().equals(""))  validateIndustry(userProfile.getKeyWordIdentIndu().trim());
            if (userProfile.getEmailAddress().trim().equals(""))      validateEmail(userProfile);
            
            if (userProfile.getCompTwtAccountsHandle1().isEmpty())    
                    validateCompTwitterAccount1(userProfile.getCompTwtAccountsHandle1(),
                                        userProfile.getCompTwtAccountsHandle2(),userProfile.getCompTwtAccountsHandle3());
            
            if (userProfile.getSelfTwtAccounts().isEmpty())           validateTwitterAccounts(userProfile.getSelfTwtAccounts());
            if (userProfile.getName().trim().equals(""))              validateProfileName(userProfile.getName().trim());
            if (userProfile.getTitle().trim().equals(""))             validateProfileTitle(userProfile.getTitle().trim());
            //if (userProfile.getCompany().trim().equals(""))           validateUserCompany(userProfile.getCompany().trim());
            //if (userProfile.getWorkAddressLine1().trim().equals(""))  validateWorkAddress(userProfile.getWorkAddressLine1().trim());
            //if (userProfile.getZipCode().trim().equals(""))           validateZipCode(userProfile.getZipCode().trim());
            if (userProfile.getUid().trim().equals(""))               validateUserName(userProfile.getUid().trim());
            //if (userProfile.getCity().trim().equals(""))              validateUserCity(userProfile.getCity().trim());            
    }
    public void validateUserCity(String data)
    {
        if(data.equals("")) {
            flag = true;
            setCityColor(ERR_CODE);
            setCityErrMsg(ERR_MSG);
        }
        else{
            setCityColor("white");
            setCityErrMsg("");
        }
    }
    public void validateUserName(String data)
    {
        if(data.equals("")) {
            flag = true;
            setUserNameColor(ERR_CODE);
            setUserNameErrMsg(ERR_MSG);
        }
        else{
            setUserNameColor("white");
            setUserNameErrMsg("");
        }
    }
    public void validateZipCode(String data)
    {
        if(data.equals("")) {
            flag = true;
            setZipColor(ERR_CODE);
            //setZipErrMsg(ERR_MSG);
            setZipErrMsg("");
        }
        else{
            setZipColor("white");
            setZipErrMsg("");
        }
    }
    public void validateWorkAddress(String data)
    {
        if(data.equals("")) {
            flag = true;
            setWorkAddressColor(ERR_CODE);
            setWorkAddressErrMsg(ERR_MSG);
        }
        else{
            setWorkAddressColor("white");
            setWorkAddressErrMsg("");
        }
    }
    public void validateUserCompany(String data)
    {
        if(data.equals("")) {
            flag = true;
            setCompanyColor(ERR_CODE);
            setCompanyErrMsg(ERR_MSG);
        }
        else{
            setCompanyColor("white");
            setCompanyErrMsg("");
        }
    }
    public void validateProfileTitle(String data)
    {
        if(data.equals("")) {
            flag = true;
            setTitleColor(ERR_CODE);
            setTitleErrMsg(ERR_MSG);
        }
        else{
            setTitleColor("white");
            setTitleErrMsg("");
        }
    }
    public void validateProfileName(String data)    {
        if(data.equals("")) {
            flag = true;
            setNameColor(ERR_CODE);
            setNameErrMsg(ERR_MSG);
        }
        else{
            setNameColor("white");
            setNameErrMsg("");
        }
    }
    public void validateBrand(String data) {
            if (data.equals("")) {
                flag = true;
                setColor(ERR_CODE);
                setErrMsg(ERR_MSG);
            } else {
                setColor("white");
                setErrMsg("");
            }
    }
    public void validateProduct(String data) {
        if (data.equals("")) {
            flag = true;
                setColor1(ERR_CODE);
                setErrMsg1(ERR_MSG);
            } else {
                setColor1("white");
                setErrMsg1("");
            }
    }
    public void validateIndustry(String data) {
        if (data.equals("")) {
            flag = true;
                setColor2(ERR_CODE);
                setErrMsg2(ERR_MSG);
            } else {
                setColor2("white");
                setErrMsg2("");
            }
    }
    public void validateVanityURL(String data) {
        if (data.equals("")) {
            flag = true;
                  setVanityMailCol(ERR_CODE);
                  setVanityMailerr(ERR_MSG);
              } else {
                  setVanityMailCol("white");
                  setVanityMailerr("");
              }
    }    
    public void validateCompTwitterAccount1(List<TwitterAccountDTO> handle1,
                                        List<TwitterAccountDTO> handle2,List<TwitterAccountDTO> handle3) {
            if (handle1.isEmpty() && handle2.isEmpty() && handle2.isEmpty()) {
                flag = true;
                setCompTwittAccCol(ERR_CODE);
                setCompTwittAccErr(ERR_MSG);
            } else {
                setCompTwittAccCol("white");
                setCompTwittAccErr("");
            }
    }
    public void validateEmail(UserProfileDetailDTO userProfile) {
        
        if (userProfile.getReportingEmail1().trim().equals("")
                && userProfile.getReportingEmail2().trim().equals("") 
                && userProfile.getReportingEmail3().trim().equals("")) {
                flag=true;
                setMailCol(ERR_CODE);
                setMailErr(ERR_MSG);
        } else {
                setMailCol("white");
                setMailErr("");
        }
}
   /* public void validateCompTwitterAccount2(List<TwitterAccountDTO> handle1,
                                        List<TwitterAccountDTO> handle2,List<TwitterAccountDTO> handle3)  {
        if(handle1.isEmpty() && handle2.isEmpty() && handle2.isEmpty())  {
            System.out.println(13);
            flag = true;
            setCompTwittAccCol2(ERR_CODE);
            setCompTwittAccErr2(ERR_MSG);
        } else {
            setCompTwittAccCol2("white");
            setCompTwittAccErr2("");
        }
    }*/
    
  /*  public void validateCompTwitterAccount3(List<TwitterAccountDTO> list) {
        if (list.isEmpty()) {
            System.out.println(14);
            flag = true;
            setCompTwittAccCol3(ERR_CODE);
            setCompTwittAccErr3(ERR_MSG);
        } else {
            setCompTwittAccCol3("white");
            setCompTwittAccErr3("");
        }
    }*/
    
    public void validateTwitterAccounts(List<TwitterAccountDTO> list) {
        if (list.isEmpty()) {
            flag = true;
            setTwittAccCol(ERR_CODE);
            setTwittAccErr(ERR_MSG);
        } else {
            setTwittAccCol("white");
            setTwittAccErr("");
        }
    }

    /*private void setTwitterAccountCmptValue(TwitterAccountDTO dto, String twitterAccountCmptName) throws SVTException {
        dto.setCreatedOn(new Date());
        dto.setUpdatedBy(getCurrentProfileId());
        dto.setProfilePreference(getUserProfile().getProfilePreference());
        dto.setSelf(false);
        dto.setTwitterUsername(twitterAccountCmptName);
        dto.setBrndProdInds("BRAND"); //TODO : please take care of this, will be passed from screen, else default to "BRAND"
        getTwitterAccountMgr().add(dto);

    }*/

   /* private void setTwitterAccountValue(TwitterAccountDTO dto) throws SVTException {
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
        //if(dto.getHandlerName().equalsIgnoreCase("Customer")){
            getUserProfile().setSelfTwtAccounts(getTwitterAccountMgr().getByProfilePreferenceIdSELF(getUserProfile().getProfilePreference().getProfilePrefrenceId())); 
        //}else{                                                                
            getUserProfile().setCompTwtAccountsHandle1(getTwitterAccountMgr().getByProfilePreferenceIdCompNameNOTSELF(getUserProfile().getProfilePreference().getProfilePrefrenceId(), "Competitor #1"));
            getUserProfile().setCompTwtAccountsHandle2(getTwitterAccountMgr().getByProfilePreferenceIdCompNameNOTSELF(getUserProfile().getProfilePreference().getProfilePrefrenceId(), "Competitor #2"));
            getUserProfile().setCompTwtAccountsHandle3(getTwitterAccountMgr().getByProfilePreferenceIdCompNameNOTSELF(getUserProfile().getProfilePreference().getProfilePrefrenceId(), "Competitor #3"));
        //}
            getUserProfile().setCompanyHandler(getTwitterAccountMgr().getByProfilePreferenceId(getUserProfile().getProfilePreference().getProfilePrefrenceId()));
    }*/

    /*public void removeTwitterAccount(ActionEvent actionEvent) throws SVTException {
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
    }*/

    /*public void removeReportingEmailAddress(ActionEvent actionEvent) throws SVTException {
        String email = actionEvent.getComponent().getAttributes().get( "reportingEmail" ).toString();
        if(email != null){
            UserProfileDetailDTO dto = getUserProfile();
            if(email.equalsIgnoreCase("1")){
                dto.setReportingEmail1(""); 
            }else if(email.equalsIgnoreCase("2")){
                dto.setReportingEmail2(""); 
            }else if(email.equalsIgnoreCase("3")){
                dto.setReportingEmail3(""); 
            }
            dto.setUpdatedBy(getCurrentUid());
            getUserProfileMgr().updateUserProfileLight(dto);     
        }
    }*/

   /* public void addReportingEmailAddress(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on Reporting Add button " +  getUserProfile().getProfilePreference());

        if((getUserProfile().getReportingEmail1() != null && getUserProfile().getReportingEmail1().trim().equals("")) || 
           getUserProfile().getReportingEmail1() == null){
            getUserProfile().setReportingEmail1(getUserProfile().getEmailAddress());
        }else if((getUserProfile().getReportingEmail2() != null && getUserProfile().getReportingEmail2().trim().equals("")) || 
                getUserProfile().getReportingEmail2() == null){
            getUserProfile().setReportingEmail2(getUserProfile().getEmailAddress());
        }else if((getUserProfile().getReportingEmail3() != null && getUserProfile().getReportingEmail3().trim().equals("")) || 
                getUserProfile().getReportingEmail3() == null){
            getUserProfile().setReportingEmail3(getUserProfile().getEmailAddress());
        }

        
        UserProfileDetailDTO dto = new UserProfileDetailDTO();
        dto.setProfilePreference(getUserProfile().getProfilePreference());
        dto.setReportingEmail1(getUserProfile().getReportingEmail1());
        dto.setReportingEmail2(getUserProfile().getReportingEmail2());
        dto.setReportingEmail3(getUserProfile().getReportingEmail3());

        getProfilePreferenceMgr().update(dto);
        
    }*/

   /* public void addTwitterAccountHandler(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on Self Add button: " + getUserProfile().getTwitterAccountNameSelf());
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setTwitterUsername(getUserProfile().getTwitterAccountNameSelf());
        dto.setHandlerName("Customer");
        
        // Cannot add more than 5
        if(getUserProfile().getSelfTwtAccounts().size() > 4){
            System.out.println("Limit exceeded...");
            return;
        }
        setTwitterAccountValue(dto);
    }*/

   /* public void addTwitterAccountCmptHandler1(ActionEvent actionEvent) throws SVTException {
        
        System.out.println("Clicked on Cmpt1 Add button: " + getUserProfile().getTwitterCmptAccountName1());
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

    public void addTwitterAccountCmptHandler2(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on Cmpt2 Add button: " + getUserProfile().getTwitterCmptAccountName2());
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setTwitterUsername(getUserProfile().getTwitterCmptAccountName2());
        dto.setHandlerName("Competitor #2");
        if(getUserProfile().getCompTwtAccountsHandle2().size() > 5){
            System.out.println("Limit exceeded...");
            return;
        }
        setTwitterAccountValue(dto);
    }

    public void addTwitterAccountCmptHandler3(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on Cmpt3 Add button: " + getUserProfile().getTwitterCmptAccountName3());
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setTwitterUsername(getUserProfile().getTwitterCmptAccountName3());
        dto.setHandlerName("Competitor #3");
        if(getUserProfile().getCompTwtAccountsHandle3().size() > 5){
            System.out.println("Limit exceeded...");
            return;
        }
        setTwitterAccountValue(dto);
    }*/

    /*public void addKeyWordBrandHandler(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on BrandKeyword Add button: " + getUserProfile().getKeyWordIdentBrand() + " for handler: " + getUserProfile().getKeyWordCompanyHandleName());
        if(getUserProfile().getKeyWordCompanyHandleName() != null && getUserProfile().getKeyWordCompanyHandleName().trim().length() > 0){
        CompanyDTO dto = new CompanyDTO();
        dto.setCompanyName(getUserProfile().getKeyWordCompanyHandleName());
        dto.setKeyWordIdentBrand(getUserProfile().getKeyWordIdentBrand());
        updateKeyWordIdentBrand(getUserProfile().getCompanyHandler(),dto.getCompanyName(),dto.getKeyWordIdentBrand());
        }
    }
    public void addKeyWordProductHandler(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on ProductKeyword Add button: " + getUserProfile().getKeyWordIdentProd() + " for handler: " + getUserProfile().getKeyWordCompanyHandleName());
        if(getUserProfile().getKeyWordCompanyHandleName() != null && getUserProfile().getKeyWordCompanyHandleName().trim().length() > 0){
            CompanyDTO dto = new CompanyDTO();
            dto.setCompanyName(getUserProfile().getKeyWordCompanyHandleName());
            dto.setKeyWordIdentProd(getUserProfile().getKeyWordIdentProd());
            updateKeyWordIdentProd(getUserProfile().getCompanyHandler(),dto.getCompanyName(),dto.getKeyWordIdentProd());            
        }
    }
    public void addKeyWordIndustryHandler(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on IndustryKeyword Add button: " + getUserProfile().getKeyWordIdentIndu() + " for handler: " + getUserProfile().getKeyWordCompanyHandleName());
        if(getUserProfile().getKeyWordCompanyHandleName() != null && getUserProfile().getKeyWordCompanyHandleName().trim().length() > 0){
        CompanyDTO dto = new CompanyDTO();
        dto.setCompanyName(getUserProfile().getKeyWordCompanyHandleName());
        dto.setKeyWordIdentIndu(getUserProfile().getKeyWordIdentIndu());
        updateKeyWordIdentIndu(getUserProfile().getCompanyHandler(),dto.getCompanyName(),dto.getKeyWordIdentIndu());
        }
        
    }
    
    private void updateKeyWordIdentIndu(List<TwitterAccountDTO> companyHandler, String companyName, String keyword) throws SVTException {
        for(TwitterAccountDTO dto: companyHandler){
            if(dto.getCompany() != null && dto.getCompany().getCompanyName().equalsIgnoreCase(companyName)){
                dto.getCompany().setKeyWordIdentIndu(keyword);
                getCompanyMgr().update(dto);
                return;
             }
        } 
    }
    private void updateKeyWordIdentBrand(List<TwitterAccountDTO> companyHandler, String companyName, String keyword) throws SVTException {
        for(TwitterAccountDTO dto: companyHandler){
            if(dto.getCompany() != null && dto.getCompany().getCompanyName().equalsIgnoreCase(companyName)){
                dto.getCompany().setKeyWordIdentBrand(keyword);
                getCompanyMgr().update(dto);
                return;
             }
        } 
    }
    private void updateKeyWordIdentProd(List<TwitterAccountDTO> companyHandler, String companyName, String keyword) throws SVTException {
        for(TwitterAccountDTO dto: companyHandler){
            if(dto.getCompany() != null && dto.getCompany().getCompanyName().equalsIgnoreCase(companyName)){
                dto.getCompany().setKeyWordIdentProd(keyword);
                getCompanyMgr().update(dto);
                return;
             }
        } 
    }
        
    public void authenticateGoogleAccount(ActionEvent actionEvent) throws SVTException {
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
            System.out.println("Google Auth passed...: [" + getUserProfile().getGoogleAnalyticsAccount() + "]");
            getUserProfile().setGoogleAnalyticsAccount( gadto.get(0).getName());
            if(getUserProfile().getGoogleAnalyticsAccount() == null){
                getUserProfile().setGoogleAnalyticsAccount( gadto.get(0).getName());
            }
            getUserProfile().setGoogleAnalyticAccounts(gadto);
            
            ProfilePreference pp = getUserProfile().getProfilePreference();
            if(pp != null && getUserProfile().getGoogleAnalyticsUsername() != null){
               pp.setGoogleAnalyticsUsername(getUserProfile().getGoogleAnalyticsUsername());
               getProfilePreferenceMgr().updateGoogleAnalytics(getUserProfile());
            }
        }
    }*/


    /*@Deprecated //use addTwitterAccountHandler
    public void validateTwitterAccountHandler(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on Add button1: " + getTwitterAccountName());
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setHandlerName("Customer");        
        dto.setTwitterUsername(getTwitterAccountName());
        setTwitterAccountValue(dto);
    }*/
    
    /*@Deprecated //use addTwitterAccountCmptHandler1
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
    }*/
   
    
    public void validateEmail(ValueChangeEvent changeEvent) {
        //   Intentionally Left Blank.
    }

    public void validateGoogleAnalytics(ValueChangeEvent changeEvent) {
        //   Intentionally Left Blank.
    }
   
    
    //------------------------------------------------------
    /*private List<GoogleAnalyticsAccountDTO> getResponseString(String userName, String password){
        List<GoogleAnalyticsAccountDTO> dtos = new ArrayList<GoogleAnalyticsAccountDTO>();
        if(userName.length()>0 && password.length()>0){            
            try {                
                GDataFeedRetrieve gData = new GDataFeedRetrieve(userName,password);
                String accountName[] = gData.getAccountFeedByProperty("ga:accountName");
                
                if(accountName!=null){
                    for(int i=0;i<accountName.length;i++){
                        GoogleAnalyticsAccountDTO dto = new GoogleAnalyticsAccountDTO();
                        dto.setName(accountName[i]);
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
                } catch (IOException e) {
                    //Network error trying to retrieve feed
                    GoogleAnalyticsAccountDTO dto = new GoogleAnalyticsAccountDTO();
                    dto.setName("Network error trying to retrieve feed");
                    dto.setActiveStatus(false);
                    dtos.add(dto);  
                } catch (ServiceException e) {
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
    }*/
    
    //-------------------------------------------------------
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
    public String getCompTwittAccCol2() {
        return compTwittAccCol2;
    }
    public void setCompTwittAccCol2(String compTwittAccCol2) {
        this.compTwittAccCol2 = compTwittAccCol2;
    }
    public String getCompTwittAccErr2() {
        return compTwittAccErr2;
    }
    public void setCompTwittAccErr2(String compTwittAccErr2) {
        this.compTwittAccErr2 = compTwittAccErr2;
    }
    public String getCompTwittAccCol3() {
        return compTwittAccCol3;
    }
    public void setCompTwittAccCol3(String compTwittAccCol3) {
        this.compTwittAccCol3 = compTwittAccCol3;
    }
    public String getCompTwittAccErr3() {
        return compTwittAccErr3;
    }
    public void setCompTwittAccErr3(String compTwittAccErr3) {
        this.compTwittAccErr3 = compTwittAccErr3;
    }
}