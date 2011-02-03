package com.edifixio.soc.biz.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edifixio.soc.persist.ImprovementLevel;
import com.edifixio.soc.persist.ProfilePreference;

public class UserProfileDetailDTO extends UserProfileDTO{

    private List<TwitterAccountDTO> selfTwtAccounts; ////// max 5
    private List<TwitterAccountDTO> compTwtAccounts; /////  max 5

    private List<TwitterAccountDTO> compTwtAccountsHandle1; /////  max 5
    private List<TwitterAccountDTO> compTwtAccountsHandle2; /////  max 5
    private List<TwitterAccountDTO> compTwtAccountsHandle3; /////  max 5
    
    
    private String keyWordIdentBrand;
    private String keyWordIdentProd;
    private String keyWordIdentIndu;
    private ImprovementLevel improvementLevel;
    private String improvementLevelId;
    private String improvementLevelName;
    private String reportingEmail1;
    private String reportingEmail2;
    private String reportingEmail3;
    private String vanityUrl;
    private String subscriptionName;
    private String subscriptionDesc;
    private Date subscriptionDateFrom;
    private Date subscriptionDateTo;
    
    private String industryName;
    private String brandName;
    private String productName;
    

    private boolean activeStatus;
    private boolean firstTimeLogin;
    private ProfilePreference profilePreference;
    
    //Added By Neel, Started Here
    
        private String emailAddress;
        private String googleAnalyticsAccount;
        
        public String getGoogleAnalyticsAccount() {
            return googleAnalyticsAccount;
        }

        public void setGoogleAnalyticsAccount(String googleAnalyticsAccount) {
            this.googleAnalyticsAccount = googleAnalyticsAccount;
        }
        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }
    //Added By Neel, Ended Here

        public ProfilePreference getProfilePreference() {
            return profilePreference;
        }

        public void setProfilePreference(ProfilePreference profilePreference) {
            this.profilePreference = profilePreference;
        }
       
    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }


   public String getImprovementLevelId() {
        return improvementLevelId;
    }

public String getKeyWordIdentBrand() {
        return keyWordIdentBrand;
    }

    public void setKeyWordIdentBrand(String keyWordIdentBrand) {
        this.keyWordIdentBrand = keyWordIdentBrand;
    }

    public String getKeyWordIdentIndu() {
        return keyWordIdentIndu;
    }

    public void setKeyWordIdentIndu(String keyWordIdentIndu) {
        this.keyWordIdentIndu = keyWordIdentIndu;
    }

    public String getKeyWordIdentProd() {
        return keyWordIdentProd;
    }

    public void setKeyWordIdentProd(String keyWordIdentProd) {
        this.keyWordIdentProd = keyWordIdentProd;
    }

    public Date getSubscriptionDateFrom() {
        return subscriptionDateFrom;
    }

    public void setSubscriptionDateFrom(Date subscriptionDateFrom) {
        this.subscriptionDateFrom = subscriptionDateFrom;
    }

    public Date getSubscriptionDateTo() {
        return subscriptionDateTo;
    }

    public void setSubscriptionDateTo(Date subscriptionDateTo) {
        this.subscriptionDateTo = subscriptionDateTo;
    }

    public String getSubscriptionDesc() {
        return subscriptionDesc;
    }

    public void setSubscriptionDesc(String subscriptionDesc) {
        this.subscriptionDesc = subscriptionDesc;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public String getVanityUrl() {
        return vanityUrl;
    }

    public void setVanityUrl(String vanityUrl) {
        this.vanityUrl = vanityUrl;
    }

    public String getReportingEmail1() {
        return reportingEmail1;
    }

    public void setReportingEmail1(String reportingEmail1) {
        this.reportingEmail1 = reportingEmail1;
    }

    public String getReportingEmail2() {
        return reportingEmail2;
    }

    public void setReportingEmail2(String reportingEmail2) {
        this.reportingEmail2 = reportingEmail2;
    }

    public String getReportingEmail3() {
        return reportingEmail3;
    }

    public void setReportingEmail3(String reportingEmail3) {
        this.reportingEmail3 = reportingEmail3;
    }

    public List<TwitterAccountDTO> getCompTwtAccounts() {
        return compTwtAccounts;
    }

    public void setCompTwtAccounts(List<TwitterAccountDTO> compTwtAccounts) {
        this.compTwtAccounts = compTwtAccounts;
    }

    public List<TwitterAccountDTO> getSelfTwtAccounts() {
        return selfTwtAccounts;
    }

    public void setSelfTwtAccounts(List<TwitterAccountDTO> selfTwtAccounts) {
        this.selfTwtAccounts = selfTwtAccounts;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(boolean firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    public String getImprovementLevelName() {
        return improvementLevelName;
    }

    public void setImprovementLevelName(String improvementLevelName) {
        this.improvementLevelName = improvementLevelName;
    }

    public void setImprovementLevelId(String improvementLevelId) {
        this.improvementLevelId = improvementLevelId;
    }

    public ImprovementLevel getImprovementLevel() {
        return improvementLevel;
    }

    public void setImprovementLevel(ImprovementLevel improvementLevel) {
        this.improvementLevel = improvementLevel;
    }
  //---------------------By Neel, Started Here------------------------------- 
    private ArrayList<String> generateStar = new ArrayList<String>();
    public ArrayList<String> getGenerateStar() {
        generateStar = new ArrayList<String>();
        for(int i=0;i<Integer.parseInt(getImprovementLevel().getStarCount());i++)
            generateStar.add("*");
        return generateStar;
    }
    //-------------------By Neel, Ended Here---------------------------------    

    public List<TwitterAccountDTO> getCompTwtAccountsHandle1() {
        return compTwtAccountsHandle1;
    }

    public void setCompTwtAccountsHandle1(
            List<TwitterAccountDTO> compTwtAccountsHandle1) {
        this.compTwtAccountsHandle1 = compTwtAccountsHandle1;
    }

    public List<TwitterAccountDTO> getCompTwtAccountsHandle2() {
        return compTwtAccountsHandle2;
    }

    public void setCompTwtAccountsHandle2(
            List<TwitterAccountDTO> compTwtAccountsHandle2) {
        this.compTwtAccountsHandle2 = compTwtAccountsHandle2;
    }

    public List<TwitterAccountDTO> getCompTwtAccountsHandle3() {
        return compTwtAccountsHandle3;
    }

    public void setCompTwtAccountsHandle3(
            List<TwitterAccountDTO> compTwtAccountsHandle3) {
        this.compTwtAccountsHandle3 = compTwtAccountsHandle3;
    }
}
