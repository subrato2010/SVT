package com.edifixio.soc.biz.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.model.SelectItem;

import com.edifixio.soc.biz.util.DateUtil;
import com.edifixio.soc.biz.util.DateUtil.Ago;
import com.edifixio.soc.persist.ImprovementLevel;
import com.edifixio.soc.persist.ProfilePreference;

public class UserProfileDetailDTO extends UserProfileDTO{

    private List<TwitterAccountDTO> selfTwtAccounts; ////// max 5
    private List<TwitterAccountDTO> compTwtAccounts; /////  max 5

    private List<TwitterAccountDTO> compTwtAccountsHandle1; /////  max 5
    private List<TwitterAccountDTO> compTwtAccountsHandle2; /////  max 5
    private List<TwitterAccountDTO> compTwtAccountsHandle3; /////  max 5
    private List<TwitterAccountDTO> companyHandler;
    private String firstItemCompanyList;
    
    private String twitterAccountNameSelf;
    private String twitterCmptAccountName1;
    private String twitterCmptAccountName2;
    private String twitterCmptAccountName3;
    private String keyWordCompanyHandleName;
    
    private String timezone;
    private String keyWordProfileName;
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
    private String subscriptionId;
    private String subscriptionCompany;    
    private String subscriptionName;
    private String subscriptionDesc;
    private Date subscriptionDateFrom;
    private Date subscriptionDateTo;
    
    private String industryName;
    private String brandName;
    private String productName;
    

    private boolean activeStatus;
    private boolean firstTimeLogin;
    private boolean warningAlert;
    private ProfilePreference profilePreference;
    
    //Added By Neel, Started Here
    
        private String emailAddress;
        private String googleAnalyticsUsername;
        private String googleAnalyticsPassword;
        private String googleAnalyticsAccount; // selected from list
        private String googleAnalyticsTableId; // selected from list
        private List<GoogleAnalyticsAccountDTO> googleAnalyticAccounts; 
        private String messageWS;
 
        private String keyWordIdentBrandCmpt1; //TODO: needs to be refactored
        private String keyWordIdentProdCmpt1; //TODO: needs to be refactored
        private String keyWordIdentInduCmpt1; //TODO: needs to be refactored
        private String keyWordIdentBrandCmpt2; //TODO: needs to be refactored
        private String keyWordIdentProdCmpt2; //TODO: needs to be refactored
        private String keyWordIdentInduCmpt2; //TODO: needs to be refactored
        private String keyWordIdentBrandCmpt3; //TODO: needs to be refactored
        private String keyWordIdentProdCmpt3; //TODO: needs to be refactored
        private String keyWordIdentInduCmpt3; //TODO: needs to be refactored
        
        private String accountProcessing; // view profile
        private String daysOptimized; // view profile
        private List<String> accountOptions; // based on role, it will be populated
        private String bitlyUsername;
        private String bitlyAccessToken;
        private String bitlyAPIKey;

        
        private boolean testbool;
        
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
        return (keyWordIdentBrand == null)?(""):(keyWordIdentBrand);
    }

    public void setKeyWordIdentBrand(String keyWordIdentBrand) {
        this.keyWordIdentBrand = keyWordIdentBrand;
    }

    public String getKeyWordIdentIndu() {
        return (keyWordIdentIndu==null)?(""):(keyWordIdentIndu);
    }

    public void setKeyWordIdentIndu(String keyWordIdentIndu) {
        this.keyWordIdentIndu = keyWordIdentIndu;
    }

    public String getKeyWordIdentProd() {
        return (keyWordIdentProd==null)?(""):(keyWordIdentProd);
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
        reportingEmail1 = (reportingEmail1 == null)?(""):(reportingEmail1);
        return reportingEmail1;
    }

    public void setReportingEmail1(String reportingEmail1) {
        this.reportingEmail1 = reportingEmail1;
    }

    public String getReportingEmail2() {
        reportingEmail2 = (reportingEmail2 == null)?(""):(reportingEmail2);
        return reportingEmail2;
    }

    public void setReportingEmail2(String reportingEmail2) {
        this.reportingEmail2 = reportingEmail2;
    }

    public String getReportingEmail3() {
        reportingEmail3 = (reportingEmail3 == null)?(""):(reportingEmail3);
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
    @Deprecated
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

    public String getMessageWS() {
        return messageWS;
    }

    public void setMessageWS(String messageWS) {
        this.messageWS = messageWS;
    }

    public String getKeyWordProfileName() {
        return keyWordProfileName;
    }

    public void setKeyWordProfileName(String keyWordProfileName) {
        this.keyWordProfileName = keyWordProfileName;
    }
    
    public String getTimezoneSelected(){
        if(getTimezone() != null){
            return getTimezone();
        }
        return "Select a timezone";
    }
    
    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTwitterAccountNameSelf() {
        return twitterAccountNameSelf;
    }

    public void setTwitterAccountNameSelf(String twitterAccountNameSelf) {
        this.twitterAccountNameSelf = twitterAccountNameSelf;
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

    public String getKeyWordCompanyHandleName() {
        return keyWordCompanyHandleName;
    }

    public void setKeyWordCompanyHandleName(String keyWordCompanyHandleName) {
        this.keyWordCompanyHandleName = keyWordCompanyHandleName;
    }

    public List<TwitterAccountDTO> getCompanyHandler() {
        return companyHandler;
    }

    public void setCompanyHandler(List<TwitterAccountDTO> companyHandler) {
        this.companyHandler = companyHandler;
    }
    
    public SelectItem[] getAllCompanyHandlers()
    {
        List<TwitterAccountDTO> twtAccList = getCompanyHandler();
        //Set<String> companySet = new HashSet<String>();
        Map<Integer,String> companyMap = new TreeMap<Integer, String>();
        for(TwitterAccountDTO dto : twtAccList){
            //companySet.add(dto.getCompany().getCompanyName());
            companyMap.put(dto.getCompany().getDisplayOrder(), dto.getCompany().getCompanyName());
            if(dto.getCompany().getCompanyName() != null){
                if( dto.getCompany().getCompanyName().equalsIgnoreCase("Customer")){
                setFirstItemCompanyList(dto.getCompany().getCompanyName());
                if(getKeyWordCompanyHandleName() == null){
                    setKeyWordCompanyHandleName(dto.getCompany().getCompanyName());
                }
                setKeyWordIdentBrand(dto.getCompany().getKeyWordIdentBrand());
                setKeyWordIdentProd(dto.getCompany().getKeyWordIdentProd());
                setKeyWordIdentIndu(dto.getCompany().getKeyWordIdentIndu());
                //System.out.println("Keyword>Brand: " + getKeyWordIdentBrand() + " Product:" + getKeyWordIdentProd() + " Industry: " + getKeyWordIdentIndu());
                }
                else if( dto.getCompany().getCompanyName().equalsIgnoreCase("Competitor #1")){
                    setKeyWordIdentBrandCmpt1(dto.getCompany().getKeyWordIdentBrand());
                    setKeyWordIdentProdCmpt1(dto.getCompany().getKeyWordIdentProd());
                    setKeyWordIdentInduCmpt1(dto.getCompany().getKeyWordIdentIndu());
                    }
                else if( dto.getCompany().getCompanyName().equalsIgnoreCase("Competitor #2")){
                    setKeyWordIdentBrandCmpt2(dto.getCompany().getKeyWordIdentBrand());
                    setKeyWordIdentProdCmpt2(dto.getCompany().getKeyWordIdentProd());
                    setKeyWordIdentInduCmpt2(dto.getCompany().getKeyWordIdentIndu());
                    }
                else if( dto.getCompany().getCompanyName().equalsIgnoreCase("Competitor #3")){
                    setKeyWordIdentBrandCmpt3(dto.getCompany().getKeyWordIdentBrand());
                    setKeyWordIdentProdCmpt3(dto.getCompany().getKeyWordIdentProd());
                    setKeyWordIdentInduCmpt3(dto.getCompany().getKeyWordIdentIndu());
                    }
            }
        }
        
        SelectItem[] acc;
            if(companyMap.size() > 0){
                acc = new SelectItem[companyMap.size()];
                int i = 0;
                for(String s : companyMap.values()){
                    
                    acc[i] = new SelectItem(); 
                    acc[i].setLabel(s);
                    acc[i].setValue(s);    
                    i++;

                }
        }else{
            acc = new SelectItem[1];
            acc[0]=new SelectItem(); 
            acc[0].setLabel("");
            acc[0].setValue(""); 
        }
        return acc;
    }
    
    public String getFirstItemCompanyList() {
        return firstItemCompanyList;
    }

    public void setFirstItemCompanyList(String firstItemCompanyList) {
        this.firstItemCompanyList = firstItemCompanyList;
    }

    public String getKeyWordIdentBrandCmpt1() {
        return (keyWordIdentBrandCmpt1==null)?(""):(keyWordIdentBrandCmpt1);
    }

    public void setKeyWordIdentBrandCmpt1(String keyWordIdentBrandCmpt1) {
        this.keyWordIdentBrandCmpt1 = keyWordIdentBrandCmpt1;
    }

    public String getKeyWordIdentProdCmpt1() {
        return (keyWordIdentProdCmpt1==null)?(""):(keyWordIdentProdCmpt1);
    }

    public void setKeyWordIdentProdCmpt1(String keyWordIdentProdCmpt1) {
        this.keyWordIdentProdCmpt1 = keyWordIdentProdCmpt1;
    }

    public String getKeyWordIdentInduCmpt1() {
        return (keyWordIdentInduCmpt1==null)?(""):(keyWordIdentInduCmpt1);
    }

    public void setKeyWordIdentInduCmpt1(String keyWordIdentInduCmpt1) {
        this.keyWordIdentInduCmpt1 = keyWordIdentInduCmpt1;
    }

    public String getKeyWordIdentBrandCmpt2() {
        return (keyWordIdentBrandCmpt2==null)?(""):(keyWordIdentBrandCmpt2);
    }

    public void setKeyWordIdentBrandCmpt2(String keyWordIdentBrandCmpt2) {
        this.keyWordIdentBrandCmpt2 = keyWordIdentBrandCmpt2;
    }

    public String getKeyWordIdentProdCmpt2() {
        return (keyWordIdentProdCmpt2==null)?(""):(keyWordIdentProdCmpt2);
    }

    public void setKeyWordIdentProdCmpt2(String keyWordIdentProdCmpt2) {
        this.keyWordIdentProdCmpt2 = keyWordIdentProdCmpt2;
    }

    public String getKeyWordIdentInduCmpt2() {
        return (keyWordIdentInduCmpt2==null)?(""):(keyWordIdentInduCmpt2);
    }

    public void setKeyWordIdentInduCmpt2(String keyWordIdentInduCmpt2) {
        this.keyWordIdentInduCmpt2 = keyWordIdentInduCmpt2;
    }

    public String getKeyWordIdentBrandCmpt3() {
        return (keyWordIdentBrandCmpt3==null)?(""):(keyWordIdentBrandCmpt3);
    }

    public void setKeyWordIdentBrandCmpt3(String keyWordIdentBrandCmpt3) {
        this.keyWordIdentBrandCmpt3 = keyWordIdentBrandCmpt3;
    }

    public String getKeyWordIdentProdCmpt3() {
        return (keyWordIdentProdCmpt3==null)?(""):(keyWordIdentProdCmpt3);
    }

    public void setKeyWordIdentProdCmpt3(String keyWordIdentProdCmpt3) {
        this.keyWordIdentProdCmpt3 = keyWordIdentProdCmpt3;
    }

    public String getKeyWordIdentInduCmpt3() {
        return (keyWordIdentInduCmpt3==null)?(""):(keyWordIdentInduCmpt3);
    }

    public void setKeyWordIdentInduCmpt3(String keyWordIdentInduCmpt3) {
        this.keyWordIdentInduCmpt3 = keyWordIdentInduCmpt3;
    }

    public String getGoogleAnalyticsAccount() {
        return googleAnalyticsAccount;
    }

    public void setGoogleAnalyticsAccount(String googleAnalyticsAccount) {
        this.googleAnalyticsAccount = googleAnalyticsAccount;
    }
    public String getGoogleAccountSelected(){
        if(getGoogleAnalyticsAccount() != null){
            return getGoogleAnalyticsAccount();
        }
        return "Choose an Account";
    }
    public SelectItem[] getAllGoogleAccounts()
    {
        SelectItem[] acc;
        if(getGoogleAnalyticAccounts().size() > 0){
            acc = new SelectItem[getGoogleAnalyticAccounts().size()];
            int i = 0;
            for(GoogleAnalyticsAccountDTO dto : getGoogleAnalyticAccounts()){
                
                acc[i] = new SelectItem(); 
                acc[i].setLabel(dto.getName());
                acc[i].setValue(dto.getGoogleAnalyticsTableId());  //dto.getName()  
                i++;
            }
        }else{
            acc = new SelectItem[1];
            acc[0]=new SelectItem(); 
            acc[0].setLabel("");
            acc[0].setValue(""); 
        }
        return acc;
        
    }
 
    public List<SelectItem> getAllGoogleAccounts1()
    {
        List<SelectItem> acc = new ArrayList<SelectItem>();
        if(getGoogleAnalyticAccounts().size() > 0){
            for(GoogleAnalyticsAccountDTO dto : getGoogleAnalyticAccounts()){
                acc.add(new SelectItem(dto.getName(),dto.getName()));
            }
        }else{
            acc.add(new SelectItem("",""));
        }

        return acc;
    }
    
    public String getJSObject(){
        List<TwitterAccountDTO> twtAccList = getCompanyHandler();
        for(TwitterAccountDTO dto : twtAccList){
            if(dto.getCompany().getCompanyName() != null){
                if( dto.getCompany().getCompanyName().equalsIgnoreCase("Customer")){
                setFirstItemCompanyList(dto.getCompany().getCompanyName());
                //setKeyWordCompanyHandleName(dto.getCompany().getCompanyName());
                setKeyWordIdentBrand(dto.getCompany().getKeyWordIdentBrand());
                setKeyWordIdentProd(dto.getCompany().getKeyWordIdentProd());
                setKeyWordIdentIndu(dto.getCompany().getKeyWordIdentIndu());
                }
                else if( dto.getCompany().getCompanyName().equalsIgnoreCase("Competitor #1")){
                    setKeyWordIdentBrandCmpt1(dto.getCompany().getKeyWordIdentBrand());
                    setKeyWordIdentProdCmpt1(dto.getCompany().getKeyWordIdentProd());
                    setKeyWordIdentInduCmpt1(dto.getCompany().getKeyWordIdentIndu());
                    }
                else if( dto.getCompany().getCompanyName().equalsIgnoreCase("Competitor #2")){
                    setKeyWordIdentBrandCmpt2(dto.getCompany().getKeyWordIdentBrand());
                    setKeyWordIdentProdCmpt2(dto.getCompany().getKeyWordIdentProd());
                    setKeyWordIdentInduCmpt2(dto.getCompany().getKeyWordIdentIndu());
                    }
                else if( dto.getCompany().getCompanyName().equalsIgnoreCase("Competitor #3")){
                    setKeyWordIdentBrandCmpt3(dto.getCompany().getKeyWordIdentBrand());
                    setKeyWordIdentProdCmpt3(dto.getCompany().getKeyWordIdentProd());
                    setKeyWordIdentInduCmpt3(dto.getCompany().getKeyWordIdentIndu());
                    }
            }
        }        
        String customerObj = "customerObj={brandkeyword:\"" + getKeyWordIdentBrand() + "\",productkeyword:\"" + getKeyWordIdentProd() + "\",industrykeyword:\""+ getKeyWordIdentIndu() + "\"};"; 
        String comp1Obj = "comp1Obj={brandkeyword:\"" + getKeyWordIdentBrandCmpt1() + "\",productkeyword:\"" + getKeyWordIdentProdCmpt1() + "\",industrykeyword:\""+ getKeyWordIdentInduCmpt1() + "\"};";
        String comp2Obj = "comp2Obj={brandkeyword:\"" + getKeyWordIdentBrandCmpt2() + "\",productkeyword:\"" + getKeyWordIdentProdCmpt2() + "\",industrykeyword:\""+ getKeyWordIdentInduCmpt2() + "\"};";
        String comp3Obj = "comp3Obj={brandkeyword:\"" + getKeyWordIdentBrandCmpt3() + "\",productkeyword:\"" + getKeyWordIdentProdCmpt3() + "\",industrykeyword:\""+ getKeyWordIdentInduCmpt3() + "\"};";
        
        return customerObj + comp1Obj + comp2Obj + comp3Obj;
    }

    public String getAccountProcessing() {
        if(getUpdatedOn() == null){
            return "0 Hours";
        }
        Ago a = DateUtil.getTimeAgo(getUpdatedOn());
        String apvalue = "";
        if(a.getMonths() > 0){
            apvalue += a.getMonths() + " Months ";
        }
        if(a.getDays() > 0){
            apvalue += a.getDays() + " Day(s) ";
        }
        if(a.getHours() > 0){
            apvalue += a.getHours() + " Hours ";
        }
        return apvalue;
    }

    public void setAccountProcessing(String accountProcessing) {
        this.accountProcessing = accountProcessing;
    }

    public String getDaysOptimized() {
        
        if(getUpdatedOn() == null){
            return "0 Days";
        }
        if((DateUtil.getTimeAgoDays(getUpdatedOn()) + 1) == 1)
            return "" + (DateUtil.getTimeAgoDays(getUpdatedOn()) + 1) +  " Day";
        else
            return "" + (DateUtil.getTimeAgoDays(getUpdatedOn()) + 1) +  " Days";
    }

    public void setDaysOptimized(String daysOptimized) {
        this.daysOptimized = daysOptimized;
    }

    public List<GoogleAnalyticsAccountDTO> getGoogleAnalyticAccounts() {
        return googleAnalyticAccounts;
    }

    public void setGoogleAnalyticAccounts(
            List<GoogleAnalyticsAccountDTO> googleAnalyticAccounts) {
        this.googleAnalyticAccounts = googleAnalyticAccounts;
    }

    public String getGoogleAnalyticsPassword() {
        return googleAnalyticsPassword;
    }

    public void setGoogleAnalyticsPassword(String googleAnalyticsPassword) {
        this.googleAnalyticsPassword = googleAnalyticsPassword;
    }

    public String getGoogleAnalyticsUsername() {
        return googleAnalyticsUsername;
    }

    public void setGoogleAnalyticsUsername(String googleAnalyticsUsername) {
        this.googleAnalyticsUsername = googleAnalyticsUsername;
    }

    public boolean isTestbool() {
        return testbool;
    }

    public void setTestbool(boolean testbool) {
        this.testbool = testbool;
    }

    /*public List<String> getAccountOptions() {
        List<String> st = new ArrayList<String>();
        st.add("View My Profile");
        st.add("Manage Users");
        st.add("Administration");
        return st;
    }

    public void setAccountOptions(List<String> accountOptions) {
        this.accountOptions = accountOptions;
    }*/
    
    public List<String> getAccountOptions() {
        return accountOptions;
    }

    public void setAccountOptions(List<String> accountOptions) {
        this.accountOptions = accountOptions;
    }

    public String getGoogleAnalyticsTableId() {
        return googleAnalyticsTableId;
    }

    public void setGoogleAnalyticsTableId(String googleAnalyticsTableId) {
        this.googleAnalyticsTableId = googleAnalyticsTableId;
    }

    public boolean isWarningAlert() {
        return warningAlert;
    }

    public void setWarningAlert(boolean warningAlert) {
        this.warningAlert = warningAlert;
    }

    public String getBitlyUsername() {
        return bitlyUsername;
    }

    public void setBitlyUsername(String bitlyUsername) {
        this.bitlyUsername = bitlyUsername;
    }

    public String getBitlyAccessToken() {
        return bitlyAccessToken;
    }

    public void setBitlyAccessToken(String bitlyAccessToken) {
        this.bitlyAccessToken = bitlyAccessToken;
    }

    public String getBitlyAPIKey() {
        return bitlyAPIKey;
    }

    public void setBitlyAPIKey(String bitlyAPIKey) {
        this.bitlyAPIKey = bitlyAPIKey;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriptionCompany() {
        return subscriptionCompany;
    }

    public void setSubscriptionCompany(String subscriptionCompany) {
        this.subscriptionCompany = subscriptionCompany;
    }
    
}
