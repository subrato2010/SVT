// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.ArrayList;
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
    
    public TwitterAccountDTO add(TwitterAccountDTO dto) throws SVTException {
        
        if(dto.getTwitterUsername() != null){
            // check if exist, then dont allow to add
            TwitterAccount ta = getByTwitterUsername(dto.getProfilePreference().getProfilePrefrenceId(), dto.getTwitterUsername());
            if(ta != null){
                System.out.println("Already exist...., you can only update");
                ta.setBrndProdInds(dto.getBrndProdInds());
                getTwitterAccountDAO().update(ta);
            }else{
                // add the twitter account
                ta = new TwitterAccount();
                ta.setBrndProdInds(dto.getBrndProdInds());
                ta.setTwitterUsername(dto.getTwitterUsername());
                
                ta.setBrand(getDaoProvider().getBrandDAO().getByName(BRAND)); // TODO: can be deprecated
                ta.setIndustry(getDaoProvider().getIndustryDAO().getByName(INDUSTRY));// TODO: can be deprecated
                ta.setProduct(getDaoProvider().getProductDAO().getByName(PRODUCT));// TODO: can be deprecated

                ta.setCompany(getCompany(dto.getHandlerName()));
                ta.setProfilePreference(dto.getProfilePreference());
                ta.setSelf(dto.isSelf());
                ta.setUpdatedOn(dto.getCreatedOn());
                getDaoProvider().getTwitterAccountDAO().add(ta);                
            }            
        }
        
        
        return dto;
    }

    private TwitterAccount getByTwitterUsername(String profilePrefId, String twitterUsername) throws SVTException {
        return getTwitterAccountDAO().getByProfilePrefIdTwitterAccName(profilePrefId, twitterUsername);
    }

    private Company getCompany(String handlerName) throws SVTException {
        return getDaoProvider().getCompanyDAO().getByName(handlerName);
    }

    private List<TwitterAccountDTO> getTwitterAccountDTOList(List<TwitterAccount> tadtos) {
        
        List<TwitterAccountDTO> dtos = new ArrayList<TwitterAccountDTO>();
        
        for(TwitterAccount tadto: tadtos){
            TwitterAccountDTO dto = new TwitterAccountDTO();
            dto.setTwitterUsername(tadto.getTwitterUsername());
            dto.setTwitterAccount(tadto);
            dto.setTwitterAccountId(tadto.getTwitterAccountId());
            dtos.add(dto);
        }
        return dtos;
    }

    public void collectLDAPTwitterData(UserProfileDetailDTO userProfileDTO) {
        /*
         * TODO rest of the things to insert data to the database.
         */
    }
}
