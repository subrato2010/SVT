package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.biz.util.UserProfileUtil;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Brand;
import com.edifixio.soc.persist.Company;
import com.edifixio.soc.persist.ImprovementLevel;
import com.edifixio.soc.persist.Industry;
import com.edifixio.soc.persist.Product;
import com.edifixio.soc.persist.ProfilePreference;
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
             if(pp.getUserProfileDetail() != null){
                 copyPropertiesQuietly(dto, list.get(0));
                copyPropertiesQuietly(dto, pp.getUserProfileDetail());
               
                dto.setImprovementLevel(pp.getUserProfileDetail().getImprovementLevel()); //TODO : change it to dto instead to direct use of persist in web layer
                
                dto.setImprovementLevelId(pp.getUserProfileDetail().getImprovementLevel().getImprovementLevelId());
                dto.setImprovementLevelName(pp.getUserProfileDetail().getImprovementLevel().getName());
            }
            ArrayList<TwitterAccountDTO> selfDtos = new ArrayList<TwitterAccountDTO>();
            ArrayList<TwitterAccountDTO> cmptDtos = new ArrayList<TwitterAccountDTO>();
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
            dto.setSelfTwtAccounts(selfDtos);
            dto.setCompTwtAccounts(cmptDtos);
        }
        return dto;
    }
    
    /**
     * This method will check if user is already exist or not, if yes: then it will update the profile else add
     * @param userProfileDTO
     * @throws SVTException 
     */
    private void saveProfile(UserProfileDetailDTO userProfileDTO) throws SVTException {
        
        ProfilePreference pp = getProfilePreferenceDAO().getByProfileUserId(userProfileDTO.getUid());

        if(pp == null){
            
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
                profilePreference.setActiveStatus(true);
                profilePreference.setActiveStatus(true);
                profilePreference.setUserProfileDetail(upd);
                getProfilePreferenceDAO().add(profilePreference); // call dao to save
            }else{
                log.debug("missing mandatory fields....");
            }
        }else{
            // Hey! I know you, need to update
            log.debug("already exist....");
            pp.setUpdatedBy("subrato1");
            //Added By Neel, Started Here

                if(userProfileDTO.getReportingEmail1().trim().equals("") || userProfileDTO.getReportingEmail1() == null)
                    userProfileDTO.setReportingEmail1(userProfileDTO.getEmailAddress());
                else
                    if(userProfileDTO.getReportingEmail2().trim().equals("") || userProfileDTO.getReportingEmail2() == null)
                        userProfileDTO.setReportingEmail2(userProfileDTO.getEmailAddress());
                    else
                       if(userProfileDTO.getReportingEmail3().trim().equals("") || userProfileDTO.getReportingEmail3() == null)
                           userProfileDTO.setReportingEmail3(userProfileDTO.getEmailAddress());
            //Added by Neel, Ended Here
            userProfileDTO.setFirstTimeLogin(false);
            UserProfileDetail upd = pp.getUserProfileDetail();
            quietlyCopyProperties(upd, userProfileDTO);
            upd.setImprovementLevel(getImprovementLevel(userProfileDTO.getImprovementLevelId()));
            getUserProfileDetailDAO().update(upd);
            getProfilePreferenceDAO().update(pp);
        }
    }

    private ImprovementLevel getImprovementLevel(String improvementLevelId) throws SVTException {
        return getDaoProvider().getImprovementLevelDAO().getById(improvementLevelId);
    }

    private boolean isMandatoryFieldsValueExist(UserProfileDetailDTO userProfileDTO) {
        if(!isGoodString(userProfileDTO.getBrandName()) ||
           !isGoodString(userProfileDTO.getProductName()) ||
           !isGoodString(userProfileDTO.getIndustryName()) ||
           !isGoodString(userProfileDTO.getCompany()) ||
           !isGoodString(userProfileDTO.getUid())
            ){
           return false;
        }
        return true;
    }

    private boolean isGoodString(String brandName) {
        return brandName != null && brandName.length() > 0;
    }

    private Industry getIndustry(String industryName) throws SVTException {
        return getDaoProvider().getIndustryDAO().getByName(industryName);
    }

    private Product getProduct(String productName) throws SVTException {
        return getDaoProvider().getProductDAO().getByName(productName);
    }

    private Brand getBrand(String brandName) throws SVTException {
        //return getDaoProvider().getBrandDAO().getByName(brandName);        
        return getDaoProvider().getBrandDAO().findall().iterator().next();
    }

    private Company getCompany(String companyName) throws SVTException {
        //return getDaoProvider().getCompanyDAO().getByName(companyName);
        return getDaoProvider().getCompanyDAO().findall().iterator().next();
    }

}
