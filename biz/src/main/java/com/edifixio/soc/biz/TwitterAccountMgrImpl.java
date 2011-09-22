// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Company;
import com.edifixio.soc.persist.TwitterAccount;

public class TwitterAccountMgrImpl extends BaseBizObject implements TwitterAccountMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(TwitterAccountMgrImpl.class);

    public List<TwitterAccountDTO> findAll() throws SVTException {
        // Using spring to get the dao mgr
        log.debug("Successful in connecting to Biz layer");
        return getTwitterAccountDTOList(getDaoProvider().getTwitterAccountDAO().findall());
    }
    
    public List<TwitterAccountDTO> getByProfilePreferenceId(String id) throws SVTException {
        return getTwitterAccountDTOList(getDaoProvider().getTwitterAccountDAO().getByProfilePreferenceId(id));
    }

    public List<TwitterAccountDTO> getByProfilePreferenceIdNOTSELF(String id) throws SVTException {
        return getTwitterAccountDTOList(getDaoProvider().getTwitterAccountDAO().getByProfilePreferenceIdNOTSELF(id));
    }

    public List<TwitterAccountDTO> getByProfilePreferenceIdCompIdNOTSELF(String id, String companyId) throws SVTException {
        return getTwitterAccountDTOList(getDaoProvider().getTwitterAccountDAO().getByProfilePreferenceIdCompIdNOTSELF(id, companyId));
    }
    public List<TwitterAccountDTO> getByProfilePreferenceIdCompNameNOTSELF(String id, String companyName) throws SVTException {
        return getTwitterAccountDTOList(getDaoProvider().getTwitterAccountDAO().getByProfilePreferenceIdCompNameNOTSELF(id, companyName));
    }

    public List<TwitterAccountDTO> getByProfilePreferenceIdSELF(String id) throws SVTException {
        return getTwitterAccountDTOList(getDaoProvider().getTwitterAccountDAO().getByProfilePreferenceIdSELF(id));
    }

    public List<TwitterAccountDTO> getByProfileUserIdNOTSELF(String profileUserId) throws SVTException {
        return getTwitterAccountDTOList(getDaoProvider().getTwitterAccountDAO().getByProfileUserIdNOTSELF(profileUserId));
    }

    public List<TwitterAccountDTO> getByProfileUserIdSELF(String profileUserId) throws SVTException {
        return getTwitterAccountDTOList(getDaoProvider().getTwitterAccountDAO().getByProfileUserIdSELF(profileUserId));
    }

    public List<TwitterAccountDTO> getByProfileUserIdCompIdNOTSELF(String profileUserId, String companyId) throws SVTException {
        return getTwitterAccountDTOList(getDaoProvider().getTwitterAccountDAO().getByProfileUserIdCompIdNOTSELF(profileUserId, companyId));
    }
    
    public TwitterAccountDTO delete(TwitterAccountDTO dto) throws SVTException {
        
        if(dto.getTwitterAccountId() != null && dto.getTwitterAccountId().length() > 0){
            TwitterAccount ta = getTwitterAccountDAO().getTwitterAccountById(dto.getTwitterAccountId());
            if(ta != null){
                getTwitterAccountDAO().delete(ta); 
            }
        }else{
            System.out.println("Cannot proceed... missing twitteraccountid to delete...");
        }
        
        return dto;
    }
    
    public TwitterAccountDTO add(TwitterAccountDTO dto) throws SVTException {
        
        if(dto.getTwitterUsername() != null){
            if(dto.getProfilePreference() == null && dto.getProfilePreferenceId() != null){
                dto.setProfilePreference(getProfilePreferenceDAO().getByProfilePreferenceId(dto.getProfilePreferenceId()));
            }
            if(dto.getProfilePreference() == null){
                System.out.println("Profile preference required...");
                return dto;
            }
            
            
            // check if exist, then dont allow to add
            TwitterAccount ta = getByTwitterUsername(dto.getProfilePreference().getProfilePrefrenceId(), dto.getTwitterUsername());
            if(ta != null){
                System.out.println("Already exist...., you can only update");
                if(dto.getBrndProdInds() != null && dto.getBrndProdInds().length() > 0){
                    ta.setBrndProdInds(dto.getBrndProdInds());    
                }
                if(dto.getAccessToken() != null && dto.getAccessTokenSecret() != null){
                    ta.setAccessToken(dto.getAccessToken());
                    ta.setAccessTokenSecret(dto.getAccessTokenSecret());
                }
                getTwitterAccountDAO().update(ta);
             }else{
                // add the twitter account
                ta = new TwitterAccount();
                ta.setBrndProdInds(dto.getBrndProdInds());
                ta.setTwitterUsername(dto.getTwitterUsername());
                ta.setAccessToken(dto.getAccessToken());
                ta.setAccessTokenSecret(dto.getAccessTokenSecret());
                
                ta.setBrand(getDaoProvider().getBrandDAO().getByName(BRAND)); // TODO: can be deprecated
                ta.setIndustry(getDaoProvider().getIndustryDAO().getByName(INDUSTRY));// TODO: can be deprecated
                ta.setProduct(getDaoProvider().getProductDAO().getByName(PRODUCT));// TODO: can be deprecated

                ta.setCompany(getCompany(dto.getHandlerName(),dto.getProfilePreference().getProfilePrefrenceId()));
                ta.setProfilePreference(dto.getProfilePreference());
                ta.setSelf(dto.isSelf());
                ta.setUpdatedOn(dto.getCreatedOn());
                getDaoProvider().getTwitterAccountDAO().add(ta).getCompany(); 
            }            
        }
        return dto;
    }
    
    private Company getCompany(String handlerName, String profilePrefrenceId) throws SVTException {
        List<TwitterAccount> ta = getDaoProvider().getTwitterAccountDAO().findByProfilePrefIdCompanyName(profilePrefrenceId, handlerName);
        if(ta != null && ta.size() > 0 ){
            return ta.get(0).getCompany();
        }
        Company comp = new Company();
        comp.setActiveStatus(true);
        comp.setCompanyName(handlerName);
        comp.setDisplayOrder(getHandleDisplayOrder(handlerName));
        
        comp.setKeyWordIdentBrand("");
        comp.setKeyWordIdentProd("");
        comp.setKeyWordIdentIndu("");
        comp.setUpdatedOn(new Date());
        return getDaoProvider().getCompanyDAO().add(comp);
    }

    private TwitterAccount getByTwitterUsername(String profilePrefId, String twitterUsername) throws SVTException {
        return getTwitterAccountDAO().getByProfilePrefIdTwitterAccName(profilePrefId, twitterUsername);
    }

    public TwitterAccountDTO getByTwitterProfIdUsername(String profilePrefId, String twitterUsername) throws SVTException {
        return getTwitterAccountDTO(getTwitterAccountDAO().getByProfilePrefIdTwitterAccName(profilePrefId, twitterUsername));
    }

    private List<TwitterAccountDTO> getTwitterAccountDTOList(List<TwitterAccount> tadtos) {
        
        List<TwitterAccountDTO> dtos = new ArrayList<TwitterAccountDTO>();
        
        for(TwitterAccount tadto: tadtos){
            TwitterAccountDTO dto = getTwitterAccountDTO(tadto);
            dtos.add(dto);
        }
        return dtos;
    }

    private TwitterAccountDTO getTwitterAccountDTO(TwitterAccount tadto) {
        if(tadto == null){
            return null;
        }
        TwitterAccountDTO dto = new TwitterAccountDTO();
        dto.setTwitterUsername(tadto.getTwitterUsername());
        dto.setTwitterAccount(tadto);
        dto.setTwitterAccountId(tadto.getTwitterAccountId());
        dto.setCompany(tadto.getCompany());
        dto.setBrndProdInds(tadto.getBrndProdInds());
        dto.setAccessToken(tadto.getAccessToken());
        dto.setAccessTokenSecret(tadto.getAccessTokenSecret());
        return dto;
    }

    
    private int getHandleDisplayOrder(String handlerName) {
        if(handlerName != null){
            if(handlerName.equalsIgnoreCase("Customer")){
                return 0;
            }else if(handlerName.equalsIgnoreCase("Competitor #1")){
                return 1;
            }else if(handlerName.equalsIgnoreCase("Competitor #2")){
                return 2;
            }else if(handlerName.equalsIgnoreCase("Competitor #3")){
                return 3;
            }
        }        
        return 4;
    }

    public void collectLDAPTwitterData(UserProfileDetailDTO userProfileDTO) {
        /*
         * TODO rest of the things to insert data to the database.
         */
    }
}
