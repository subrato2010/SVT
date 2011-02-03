package com.edifixio.soc.web.controllers;

import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
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
    
    UserProfileDetailDTO userProfile;
    
    public BackingBean doValidateFields(UserProfileDetailDTO userProfile)
    {
        this.userProfile = userProfile;
        if(userProfile.getKeyWordIdentBrand().trim().equals("") || userProfile.getKeyWordIdentProd().trim().equals("") || 
           userProfile.getKeyWordIdentIndu().trim().equals("")|| (userProfile.getReportingEmail1().trim().equals("") && 
           userProfile.getReportingEmail2().trim().equals("") && userProfile.getReportingEmail3().trim().equals(""))||
           userProfile.getCompTwtAccounts().isEmpty() || userProfile.getSelfTwtAccounts().isEmpty() ||
           userProfile.getName().trim().equals("")|| userProfile.getTitle().trim().equals("")|| userProfile.getCompany().trim().equals("") ||
           userProfile.getWorkAddressLine1().trim().equals("") || userProfile.getZipCode().trim().equals("")||
           userProfile.getZipCode().trim().equals("") || userProfile.getUid().trim().equals("") ||
           userProfile.getCity().trim().equals(""))
             {
                 validateFields(userProfile);
                 return null;
             }
        return this;
    }
    
    public void validateFields(UserProfileDetailDTO userProfile) {
            if (userProfile.getKeyWordIdentBrand().trim().equals("")) validateBrand(userProfile.getKeyWordIdentBrand().trim());
            if (userProfile.getKeyWordIdentProd().trim().equals(""))  validateProduct(userProfile.getKeyWordIdentProd().trim());
            if (userProfile.getKeyWordIdentIndu().trim().equals(""))  validateIndustry(userProfile.getKeyWordIdentIndu().trim());
            if (userProfile.getEmailAddress().trim().equals(""))      validateEmail();
            if (userProfile.getCompTwtAccounts().isEmpty())           validateCompTwitterAccount(userProfile.getCompTwtAccounts());
            if (userProfile.getSelfTwtAccounts().isEmpty())           validateTwitterAccounts(userProfile.getSelfTwtAccounts());
            if (userProfile.getName().trim().equals(""))              validateProfileName(userProfile.getName().trim());
            if (userProfile.getTitle().trim().equals(""))             validateProfileTitle(userProfile.getTitle().trim());
            if (userProfile.getCompany().trim().equals(""))           validateUserCompany(userProfile.getCompany().trim());
            if (userProfile.getWorkAddressLine1().trim().equals(""))  validateWorkAddress(userProfile.getWorkAddressLine1().trim());
            if (userProfile.getZipCode().trim().equals(""))           validateZipCode(userProfile.getZipCode().trim());
            if (userProfile.getUid().trim().equals(""))               validateUserName(userProfile.getUid().trim());
            if (userProfile.getCity().trim().equals(""))              validateUserCity(userProfile.getCity().trim());            
    }
    public void validateUserCity(String data)
    {
        if(data.equals("")) {
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
                setColor(ERR_CODE);
                setErrMsg(ERR_MSG);
            } else {
                setColor("white");
                setErrMsg("");
            }
    }
    public void validateProduct(String data) {
        if (data.equals("")) {
                setColor1(ERR_CODE);
                setErrMsg1(ERR_MSG);
            } else {
                setColor1("white");
                setErrMsg1("");
            }
    }
    public void validateIndustry(String data) {
        if (data.equals("")) {
                setColor2(ERR_CODE);
                setErrMsg2(ERR_MSG);
            } else {
                setColor2("white");
                setErrMsg2("");
            }
    }
    public void validateVanityURL(String data) {
        if (data.equals("")) {
                  setVanityMailCol(ERR_CODE);
                  setVanityMailerr(ERR_MSG);
              } else {
                  setVanityMailCol("white");
                  setVanityMailerr("");
              }
    }    
    public void validateCompTwitterAccount(List<TwitterAccountDTO> list) {
            if (list.isEmpty()) {
                setCompTwittAccCol(ERR_CODE);
                setCompTwittAccErr(ERR_MSG);
            } else {
                setCompTwittAccCol("white");
                setCompTwittAccErr("");
            }
    }
    
    public void validateTwitterAccounts(List<TwitterAccountDTO> list) {
        if (list.isEmpty()) {
            setTwittAccCol(ERR_CODE);
            setTwittAccErr(ERR_MSG);
        } else {
            setTwittAccCol("white");
            setTwittAccErr("");
        }
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

    private void setTwitterAccountValue(TwitterAccountDTO dto) throws SVTException {
        dto.setCreatedOn(new Date());
        dto.setUpdatedBy(getCurrentProfileId());
        dto.setProfilePreference(getUserProfile().getProfilePreference());
        dto.setSelf(true);
        dto.setTwitterUsername(getTwitterAccountName());
        dto.setBrndProdInds("BRAND"); //TODO : please take care of this, will be passed from screen, else default to "BRAND"
        getTwitterAccountMgr().add(dto);        

    }
    
    public void validateTwitterAccountHandler(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on Add button1: " + getTwitterAccountName());
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setHandlerName("Customer");
        setTwitterAccountValue(dto);
    }
    
    public void validateTwitterAccountCmptHandler1(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on Add button1: " + getTwitterAccountName());
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setHandlerName("Competitor #1");
        setTwitterAccountCmptValue(dto, getTwitterCmptAccountName1());
    }
    public void validateTwitterAccountCmptHandler2(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on Add button2: " + getTwitterAccountName());
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setHandlerName("Competitor #2");
        setTwitterAccountCmptValue(dto, getTwitterCmptAccountName2());
    }
    public void validateTwitterAccountCmptHandler3(ActionEvent actionEvent) throws SVTException {
        System.out.println("Clicked on Add button3: " + getTwitterAccountName());
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setHandlerName("Competitor #3");
        setTwitterAccountCmptValue(dto, getTwitterCmptAccountName3());
    }
   
    
    public void validateEmail(ValueChangeEvent changeEvent) {
        //   Intentionally Left Blank.
    }

    public void validateGoogleAnalytics(ValueChangeEvent changeEvent) {
        //   Intentionally Left Blank.
    }
    public void validateEmail() {
            if (userProfile.getReportingEmail1().trim().equals("")
                    && userProfile.getReportingEmail2().trim().equals("") 
                    && userProfile.getReportingEmail3().trim().equals("")) {
                    setMailCol(ERR_CODE);
                    setMailErr(ERR_MSG);
            } else {
                    setMailCol("white");
                    setMailErr("");
            }
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