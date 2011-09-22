package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.dto.BenchmarkDTO;
import com.edifixio.soc.biz.dto.GoogleAnalyticsAccountDTO;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.biz.util.UserProfileUtil;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Benchmark;
import com.edifixio.soc.persist.Brand;
import com.edifixio.soc.persist.Company;
import com.edifixio.soc.persist.GoogleAnalyticsAccount;
import com.edifixio.soc.persist.ImprovementLevel;
import com.edifixio.soc.persist.Industry;
import com.edifixio.soc.persist.Menu;
import com.edifixio.soc.persist.Product;
import com.edifixio.soc.persist.ProfilePreference;
import com.edifixio.soc.persist.Role;
import com.edifixio.soc.persist.TwitterAccount;
import com.edifixio.soc.persist.UserProfileDetail;

public class UserProfileMgrImpl extends BaseBizObject implements UserProfileMgr {
    private static Log log = LogFactory.getLog(UserProfileMgrImpl.class);
    private UserProfileUtil util;
    
    public UserProfileMgrImpl(){
        util = new UserProfileUtil();
    }
     
    public void updateUserProfile(UserProfileDetailDTO userProfileDTO)
            throws SVTException 
    { 
        util.modifyLDAPProfile(userProfileDTO);
        saveProfile(userProfileDTO); // create or update in the persist layer
    }

    public void createUserProfile(List<UserProfileDetailDTO> userProfiles) throws SVTException{
        for(UserProfileDetailDTO dto : userProfiles){
            util.createLDAPProfile(dto);
        }
    }
    
    public List<UserProfileDetailDTO> createProfile(List<UserProfileDetailDTO> userProfiles) throws SVTException{
        for(UserProfileDetailDTO dto : userProfiles){
            String searchUid = "(" + UserProfileDetailDTO.USER_ID + "="+ dto.getUid() +")";
//            System.out.println("Result: " + util.searchUser(searchUid));
//            System.out.println("Size: " + util.searchUser(searchUid).size());
            if(util.searchUser(searchUid).size() == 0){
                util.createLDAPProfile(dto);
                if(util.searchUser(searchUid).size() == 1){
                    System.out.println("inserted successfully........");
                    dto.setImprovementLevelId("001"); // make this as default
                    saveProfile(dto);
                 }
            }else{
                dto.setMessageWS("User already exist.");
                updateUserProfileFromWS(dto);
            }            
        }
        return userProfiles;
    }

    private void updateUserProfileFromWS(UserProfileDetailDTO userProfileDTO) throws SVTException {
        ProfilePreference pp = getProfilePreferenceDAO().getByProfileUserId(userProfileDTO.getUid());
        if(pp != null && pp.getUserProfileDetail() != null){
            UserProfileDetail upd = pp.getUserProfileDetail();
            if(isGoodString(userProfileDTO.getSubscriptionId())){
                upd.setSubscriptionId(userProfileDTO.getSubscriptionId());
            }            
            if(isGoodString(userProfileDTO.getSubscriptionName())){
                upd.setSubscriptionName(userProfileDTO.getSubscriptionName());
            }
            if(isGoodString(userProfileDTO.getSubscriptionDesc())){
                upd.setSubscriptionDesc(userProfileDTO.getSubscriptionDesc());
            }
            if(isGoodString(userProfileDTO.getSubscriptionCompany())){
                upd.setSubscriptionCompany(userProfileDTO.getSubscriptionCompany());
            }
            if(userProfileDTO.getSubscriptionDateFrom() != null){
                upd.setSubscriptionDateFrom(userProfileDTO.getSubscriptionDateFrom());
            }
            if(userProfileDTO.getSubscriptionDateTo() != null){
                upd.setSubscriptionDateTo(userProfileDTO.getSubscriptionDateTo());
            }
            
            upd.setUpdatedBy(userProfileDTO.getUpdatedBy());
            upd.setUpdatedOn(new Date());
            getUserProfileDetailDAO().update(upd);
        }
    }
    
    public void updateUserProfileLight(UserProfileDetailDTO userProfileDTO)
    throws SVTException 
    { 
        
        ProfilePreference pp = getProfilePreferenceDAO().getByProfileUserId(userProfileDTO.getUid());
        System.out.println("getReportingEmail1: " + userProfileDTO.getReportingEmail1());
        System.out.println("getReportingEmail2: " + userProfileDTO.getReportingEmail2());
        System.out.println("getReportingEmail3: " + userProfileDTO.getReportingEmail3());
        System.out.println("ProfilePref: " + pp);
        if(pp != null && pp.getUserProfileDetail() != null){
            UserProfileDetail upd = pp.getUserProfileDetail();
            upd.setReportingEmail1(userProfileDTO.getReportingEmail1());
            upd.setReportingEmail2(userProfileDTO.getReportingEmail2());
            upd.setReportingEmail3(userProfileDTO.getReportingEmail3());
            upd.setUpdatedBy(userProfileDTO.getUpdatedBy());
            upd.setUpdatedOn(new Date());
            upd = getUserProfileDetailDAO().update(upd);
            updateUserProfileDetailObject(userProfileDTO, upd);            
        }
     }
    
    private void updateUserProfileDetailObject(UserProfileDetailDTO dto,
            UserProfileDetail upd) {
        if(dto.getProfilePreference() != null){
            dto.getProfilePreference().setUserProfileDetail(upd);
        }
    }

    /**
     * By Neel
     * This method responsible for create a LDAP user
     * Information will get from web services and push to the LDAP, using this method.
     */
    public void createUserProfile(UserProfileDetailDTO userProfile)throws SVTException
    {
        util.createLDAPProfile(userProfile);
    }

    public List<UserProfileDetailDTO> getAll() throws SVTException {
        String query = "(uid=*)";
        return util.searchUser(query);
    }

    public UserProfileDetailDTO getProfileByUserId(String userId) throws SVTException {
        UserProfileDetailDTO dto = null;
        String query = "(" + UserProfileDetailDTO.USER_ID + "="+ userId +")";
        List<UserProfileDetailDTO> list = util.searchUser(query);
        if(list == null || list.size() == 0){
           return null;
        }
        return getUserDetail(list);
    }
    public UserProfileDetailDTO getProfileByUserMailId(String mailId) throws SVTException {
        UserProfileDetailDTO dto = null;
        String query = "(" + UserProfileDetailDTO.EMAIL + "="+ mailId +")";
        List<UserProfileDetailDTO> list = util.searchUser(query);
        if(list == null || list.size() == 0){
           return null;
        }
        return list.get(0);
    }
    
    private UserProfileDetailDTO getUserDetail(List<UserProfileDetailDTO> list) throws SVTException {
        // list should always return max 1 row, if not then there must be some data issue, 
        // please check the ldap
        UserProfileDetailDTO dto = new UserProfileDetailDTO();
        if(list != null && list.size() == 1){
            
            ProfilePreference pp = getProfilePreferenceDAO().getByProfileUserId(list.get(0).getUid());
            if(pp == null){
                log.debug("Invalid user...");
                return null;
            }

            List<TwitterAccount> twaSelf = getTwitterAccountDAO().getByProfilePreferenceIdSELF(pp.getProfilePrefrenceId());
            List<TwitterAccount> twaCmpt = getTwitterAccountDAO().getByProfilePreferenceIdNOTSELF(pp.getProfilePrefrenceId());
                        
            List<TwitterAccount> twaCmpt1 = getTwitterAccountDAO().getByProfilePreferenceIdCompNameNOTSELF(pp.getProfilePrefrenceId(), "Competitor #1");
            List<TwitterAccount> twaCmpt2 = getTwitterAccountDAO().getByProfilePreferenceIdCompNameNOTSELF(pp.getProfilePrefrenceId(), "Competitor #2");
            List<TwitterAccount> twaCmpt3 = getTwitterAccountDAO().getByProfilePreferenceIdCompNameNOTSELF(pp.getProfilePrefrenceId(), "Competitor #3");
            
             if(pp.getUserProfileDetail() != null){
                 copyPropertiesQuietly(dto, list.get(0));
                copyPropertiesQuietly(dto, pp.getUserProfileDetail());

                dto.setImprovementLevel(pp.getUserProfileDetail().getImprovementLevel()); //TODO : change it to dto instead to direct use of persist in web layer
                
                dto.setImprovementLevelId(pp.getUserProfileDetail().getImprovementLevel().getImprovementLevelId());
                dto.setImprovementLevelName(pp.getUserProfileDetail().getImprovementLevel().getName());
                dto.setTimezone(pp.getUserProfileDetail().getTimeZone());
                dto.setAccountOptions(getRoleBasedMenuItems(pp.getRole())); // Sets the Account Options Menu Items based on logged in user role
            }
            ArrayList<TwitterAccountDTO> selfDtos = new ArrayList<TwitterAccountDTO>();
            ArrayList<TwitterAccountDTO> cmptDtos = new ArrayList<TwitterAccountDTO>();
            ArrayList<TwitterAccountDTO> cmptDtos1 = new ArrayList<TwitterAccountDTO>();
            ArrayList<TwitterAccountDTO> cmptDtos2 = new ArrayList<TwitterAccountDTO>();
            ArrayList<TwitterAccountDTO> cmptDtos3 = new ArrayList<TwitterAccountDTO>();
            for(TwitterAccount ta: twaSelf){
                TwitterAccountDTO dto1 = new TwitterAccountDTO();
                copyPropertiesQuietly(dto1, ta);
                selfDtos.add(dto1);                
            }
            for(TwitterAccount ta: twaCmpt){
                TwitterAccountDTO dto1 = new TwitterAccountDTO();
                copyPropertiesQuietly(dto1, ta);
                cmptDtos.add(dto1);                
            }
            for(TwitterAccount ta: twaCmpt1){
                TwitterAccountDTO dto1 = new TwitterAccountDTO();
                copyPropertiesQuietly(dto1, ta);
                cmptDtos1.add(dto1);                
            }
            for(TwitterAccount ta: twaCmpt2){
                TwitterAccountDTO dto1 = new TwitterAccountDTO();
                copyPropertiesQuietly(dto1, ta);
                cmptDtos2.add(dto1);                
            }
            for(TwitterAccount ta: twaCmpt3){
                TwitterAccountDTO dto1 = new TwitterAccountDTO();
                copyPropertiesQuietly(dto1, ta);
                cmptDtos3.add(dto1);                
            }
            dto.setSelfTwtAccounts(selfDtos);
            dto.setCompTwtAccounts(cmptDtos);
            dto.setCompTwtAccountsHandle1(cmptDtos1);
            dto.setCompTwtAccountsHandle2(cmptDtos2);
            dto.setCompTwtAccountsHandle3(cmptDtos3);
            populateCompanyHandler(dto,pp);
            populateGoogleAnalyticAccount(dto,pp);
            dto.setGoogleAnalyticsUsername(pp.getGoogleAnalyticsUsername());
            //dto.setGoogleAnalyticsPassword(pp.getGoogleAnalyticsPassword());
            
            dto.setBitlyUsername(pp.getBitlyUsername());
            dto.setGoogleAnalyticsPassword("dummy");
            
            dto.setProfilePreference(pp);
            dto.setUpdatedOn(pp.getUpdatedOn());
        }
        return dto;
    }
    
    private void populateCompanyHandler(UserProfileDetailDTO dto, ProfilePreference pp) throws SVTException{
         List<TwitterAccountDTO> dtos = new ArrayList<TwitterAccountDTO>();
         for(TwitterAccount ta: getTwitterAccountDAO().getByProfilePreferenceId(pp.getProfilePrefrenceId())){
             TwitterAccountDTO dto1 = new TwitterAccountDTO();
             copyPropertiesQuietly(dto1, ta);
             dto1.setCompany(ta.getCompany());
             dtos.add(dto1);  
            // System.out.println("From (UserProfileMgr)Controller:........Brand[" + ta.getCompany().getKeyWordIdentBrand() + "][" + ta.getCompany().getKeyWordIdentProd() + "][" + ta.getCompany().getKeyWordIdentIndu() + "]");
         }
         dto.setCompanyHandler(dtos);      
    }

    private void populateGoogleAnalyticAccount(UserProfileDetailDTO dto, ProfilePreference pp) throws SVTException{
        List<GoogleAnalyticsAccountDTO> dtos = new ArrayList<GoogleAnalyticsAccountDTO>();
        // This will always return 1 row, just for the flexibility, I made this one to many
        for(GoogleAnalyticsAccount gaa : getDaoProvider().getGoogleAnalyticsAccountDAO().getByProfilePreferenceId(pp.getProfilePrefrenceId())){
            GoogleAnalyticsAccountDTO dto1 = new GoogleAnalyticsAccountDTO();
            copyPropertiesQuietly(dto1, gaa);
            if(dto.getGoogleAnalyticsAccount() == null){
                dto.setGoogleAnalyticsAccount(gaa.getName()); 
            }            
            dtos.add(dto1);                
            //break;
        }
        dto.setGoogleAnalyticAccounts(dtos);      
   }

    /**
     * This method will check if user is already exist or not, if yes: then it will update the profile else add
     * @param userProfileDTO
     * @throws SVTException 
     */
    private void saveProfile(UserProfileDetailDTO userProfileDTO) throws SVTException {
        
        ProfilePreference pp = getProfilePreferenceDAO().getByProfileUserId(userProfileDTO.getUid());

        if(pp == null){
            System.out.println("creating new profile....");
            // profile doesn't exist, so let's create it            
            // check for mandatory fields
            boolean checkMandatory = isMandatoryFieldsValueExist(userProfileDTO); // TODO: need to create validator and move this pcs
            if(checkMandatory == true){
                // create persist object
                UserProfileDetail upd = new UserProfileDetail(); // this is child of profilepreference
                userProfileDTO.setFirstTimeLogin(true);
                quietlyCopyProperties(upd, userProfileDTO);            
                upd.setImprovementLevel(getImprovementLevel(userProfileDTO.getImprovementLevelId()));
                upd.setUpdatedOn(new Date());
                upd.setUpdatedBy("subrato");
                upd = getUserProfileDetailDAO().add(upd); // call dao to save
                
                
                
                ProfilePreference profilePreference = new ProfilePreference();
                profilePreference.setProfileUserId(userProfileDTO.getUid());
                profilePreference.setCompany(getCompany(userProfileDTO.getCompany()));
                profilePreference.setBrand(getBrand(userProfileDTO.getBrandName()));
                profilePreference.setProduct(getProduct(userProfileDTO.getProductName()));
                profilePreference.setIndustry(getIndustry(userProfileDTO.getIndustryName()));
                profilePreference.setRole(getRole("USER"));
                profilePreference.setActiveStatus(true);
                profilePreference.setActiveStatus(true);
                profilePreference.setWarningAlert(true);
                profilePreference.setBenchmark(getBenchmark(null)); // you are creating 1st time
                profilePreference.setUserProfileDetail(upd);
                profilePreference.setUpdatedOn(new Date());
                profilePreference.setUpdatedBy(userProfileDTO.getUid());
                getProfilePreferenceDAO().add(profilePreference); // call dao to save
            }else{
                log.debug("missing mandatory fields....");
            }
        }else{
            // Hey! I know you, need to update
            log.debug("already exist....");
            pp.setUpdatedBy("subrato1");
            
            System.out.println("Already exist......... update: " + userProfileDTO.getName());
            //userProfileDTO.setFirstTimeLogin(false);  //Comment by Neel 20-05-2011
            userProfileDTO.setFirstTimeLogin(userProfileDTO.isFirstTimeLogin()); // added by Neel 20-05-2011

            UserProfileDetail upd = pp.getUserProfileDetail();
            setUserProfileDetailPersist(upd, userProfileDTO); //quietlyCopyProperties(upd, userProfileDTO);
            upd.setTimeZone(userProfileDTO.getTimezone());
            upd.setImprovementLevel(getImprovementLevel(userProfileDTO.getImprovementLevelId()));
            System.out.println(">>>>>>>>>>>>>>>>>>> ImprovementLevel: " + upd.getImprovementLevel().getName());
            updateGoogleAccount(userProfileDTO);
            updateBrandProdIndustry(userProfileDTO);
            getUserProfileDetailDAO().update(upd);
            getProfilePreferenceDAO().update(pp);
            
            
//            //Added By Neel, Started Here
//
//                if(userProfileDTO.getReportingEmail1() != null && userProfileDTO.getReportingEmail1().trim().equals("") || userProfileDTO.getReportingEmail1() == null)
//                    userProfileDTO.setReportingEmail1(userProfileDTO.getEmailAddress());
//                else
//                    if(userProfileDTO.getReportingEmail2() != null && userProfileDTO.getReportingEmail2().trim().equals("") || userProfileDTO.getReportingEmail2() == null)
//                        userProfileDTO.setReportingEmail2(userProfileDTO.getEmailAddress());
//                    else
//                       if(userProfileDTO.getReportingEmail2() != null && userProfileDTO.getReportingEmail3().trim().equals("") || userProfileDTO.getReportingEmail3() == null)
//                           userProfileDTO.setReportingEmail3(userProfileDTO.getEmailAddress());
//            //Added by Neel, Ended Here
//            userProfileDTO.setFirstTimeLogin(false);
//            UserProfileDetail upd = pp.getUserProfileDetail();
//            quietlyCopyProperties(upd, userProfileDTO);
//            upd.setImprovementLevel(getImprovementLevel(userProfileDTO.getImprovementLevelId()));
//            getUserProfileDetailDAO().update(upd);
//            getProfilePreferenceDAO().update(pp);
        }
    }


    private void setUserProfileDetailPersist(UserProfileDetail upd,
            UserProfileDetailDTO userProfileDTO) {
//        setUserProfileDetailId(userProfileDTO.getuserpro);
//        setKeyWordIdentBrand();
//        setKeyWordIdentProd();
//        setKeyWordIdentIndu();
//        setReportingEmail1();
//        setReportingEmail2();
//        setReportingEmail3();
        upd.setVanityUrl(userProfileDTO.getVanityUrl());
        upd.setSubscriptionCompany(userProfileDTO.getSubscriptionCompany()); // jackson need this info
        upd.setSubscriptionId(userProfileDTO.getSubscriptionId());
        upd.setSubscriptionName(userProfileDTO.getSubscriptionName());
        upd.setSubscriptionDesc(userProfileDTO.getSubscriptionDesc());
        upd.setSubscriptionDateFrom(userProfileDTO.getSubscriptionDateFrom());
        upd.setSubscriptionDateTo(userProfileDTO.getSubscriptionDateTo());
        upd.setFirstTimeLogin(userProfileDTO.isFirstTimeLogin());
        upd.setActiveStatus(userProfileDTO.isActiveStatus());
        //upd.setTimeZone(userProfileDTO.getTimezone());
    }

    private void updateGoogleAccount(UserProfileDetailDTO userProfileDTO) throws SVTException {
        System.out.println("userProfileDTO.getGoogleAnalyticsAccount()[" + userProfileDTO.getGoogleAnalyticsAccount() + "] TableId[" + userProfileDTO.getGoogleAnalyticsTableId() + "]");
        if(userProfileDTO.getGoogleAnalyticsAccount() != null && 
           userProfileDTO.getGoogleAnalyticsAccount().length() <=0){
            return;
        }
        if(userProfileDTO.getGoogleAnalyticsTableId() != null &&
           userProfileDTO.getGoogleAnalyticsTableId().trim().length() <=0){
            return;
        }
        // This will always return 1 row
        List<GoogleAnalyticsAccount> gaas = getDaoProvider().getGoogleAnalyticsAccountDAO().getByProfilePreferenceId(
                userProfileDTO.getProfilePreference().getProfilePrefrenceId());
        if(gaas != null && gaas.size() ==1){
            for(GoogleAnalyticsAccount gaa : gaas){
                gaa.setName(userProfileDTO.getGoogleAnalyticsAccount());
                gaa.setGoogleAnalyticsTableId(userProfileDTO.getGoogleAnalyticsTableId());
                getDaoProvider().getGoogleAnalyticsAccountDAO().update(gaa);
                return;
            }  
        }else{
            // 1st time creating new one
            GoogleAnalyticsAccount gaa = new GoogleAnalyticsAccount();
            gaa.setActiveStatus(true);
            gaa.setDescription("not required");
            gaa.setDisplayOrder(0);
            gaa.setName(userProfileDTO.getGoogleAnalyticsAccount());
            gaa.setGoogleAnalyticsTableId(userProfileDTO.getGoogleAnalyticsTableId());
            gaa.setProfilePreference(userProfileDTO.getProfilePreference());
            getDaoProvider().getGoogleAnalyticsAccountDAO().add(gaa);
        }
    }

    private void updateBrandProdIndustry(UserProfileDetailDTO userProfileDTO)
            throws SVTException {
        // Update twitteraccount handlers BRAND,PRODUCT,INDUSTRY
        for(TwitterAccountDTO d : userProfileDTO.getSelfTwtAccounts()){
            if(d.getTwitterAccountId() != null){
                TwitterAccount ta = getTwitterAccountDAO().getTwitterAccountById(d.getTwitterAccountId());
                ta.setBrndProdInds(d.getBrndProdInds());
                getTwitterAccountDAO().update(ta);
            }
        }
        // Update twitteraccount cmp1 handlers BRAND,PRODUCT,INDUSTRY
        for(TwitterAccountDTO d : userProfileDTO.getCompTwtAccountsHandle1()){
            if(d.getTwitterAccountId() != null){
                TwitterAccount ta = getTwitterAccountDAO().getTwitterAccountById(d.getTwitterAccountId());
                ta.setBrndProdInds(d.getBrndProdInds());
                getTwitterAccountDAO().update(ta);
            }
        }
        // Update twitteraccount cmp2 handlers BRAND,PRODUCT,INDUSTRY
        for(TwitterAccountDTO d : userProfileDTO.getCompTwtAccountsHandle2()){
            if(d.getTwitterAccountId() != null){
                TwitterAccount ta = getTwitterAccountDAO().getTwitterAccountById(d.getTwitterAccountId());
                ta.setBrndProdInds(d.getBrndProdInds());
                getTwitterAccountDAO().update(ta);
            }
        }
        // Update twitteraccount cmp3 handlers BRAND,PRODUCT,INDUSTRY
        for(TwitterAccountDTO d : userProfileDTO.getCompTwtAccountsHandle3()){
            if(d.getTwitterAccountId() != null){
                TwitterAccount ta = getTwitterAccountDAO().getTwitterAccountById(d.getTwitterAccountId());
                ta.setBrndProdInds(d.getBrndProdInds());
                getTwitterAccountDAO().update(ta);
            }
        }
    }

    private Benchmark getBenchmark(BenchmarkDTO dto) throws SVTException{
        Benchmark benchmark = null;
        if(dto == null){
            //return getDaoProvider().getBenchmarkDAO().findall().iterator().next();
            // creating first time
           benchmark = new Benchmark();
           benchmark.setActiveStatus(true);
           //benchmark.setBenchmarkCode();
           benchmark.setBenchmarkName("Name not defined");
           benchmark.setBenchmarkStDate(new Date());
           benchmark.setBenchmarkEdDate(new Date());
           benchmark.setUpdatedOn(new Date());
           return getDaoProvider().getBenchmarkDAO().addBenchMark(benchmark);            
        }
        return benchmark;
    }
    private ImprovementLevel getImprovementLevel(String improvementLevelId) throws SVTException {
        return getDaoProvider().getImprovementLevelDAO().getById(improvementLevelId);
    }

    /**
     * @author SandipanM
     * @return the strMenuList
     * @Purpose Retrieves the menu item list based on the role of logged in user
     * @param userRole
     * @throws SVTException 
     * 
     * */
    private List<String> getRoleBasedMenuItems(Role userRole) throws SVTException
    {
        List<String> strMenuList = new ArrayList<String>();
        
        if(userRole == null)
        {
            return null;
        }
        
        List<Menu> tempMenuList = getDaoProvider().getMenuDAO().findByRoleIdAccountOption(userRole.getRoleId());
      
        for(int i=0;i<tempMenuList.size();i++)
        {
            strMenuList.add(tempMenuList.get(i).getMenuItem());
        }
        return strMenuList;       
    }
    
    private boolean isMandatoryFieldsValueExist(UserProfileDetailDTO userProfileDTO) {
        if(
//           !isGoodString(userProfileDTO.getBrandName()) ||
//           !isGoodString(userProfileDTO.getProductName()) ||
//           !isGoodString(userProfileDTO.getIndustryName()) ||
//           !isGoodString(userProfileDTO.getCompany()) ||
           !isGoodString(userProfileDTO.getUid())
            ){
           return false;
        }
        return true;
    }

    private boolean isGoodString(String brandName) {
        return brandName != null && brandName.trim().length() > 0;
    }

    private Industry getIndustry(String industryName) throws SVTException {
        return getDaoProvider().getIndustryDAO().findall().iterator().next();
//        return getDaoProvider().getIndustryDAO().getByName(industryName);
    }

    private Product getProduct(String productName) throws SVTException {
        return getDaoProvider().getProductDAO().findall().iterator().next();
        //return getDaoProvider().getProductDAO().getByName(productName);
    }

    private Brand getBrand(String brandName) throws SVTException {
        //return getDaoProvider().getBrandDAO().getByName(brandName);        
        return getDaoProvider().getBrandDAO().findall().iterator().next();
    }

    private Company getCompany(String companyName) throws SVTException {
        //return getDaoProvider().getCompanyDAO().getByName(companyName);
        return getDaoProvider().getCompanyDAO().findall().iterator().next();
    }

    private Role getRole(String string) throws SVTException {
        return getDaoProvider().getRoleDAO().getUserRole();
    }
}
