// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;

import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.common.SVTException;

public interface TwitterAccountMgr extends BaseMgr{
    public List<TwitterAccountDTO> findAll() throws SVTException;
    public TwitterAccountDTO getByTwitterProfIdUsername(String profilePrefId, String twitterUsername) throws SVTException;
    public List<TwitterAccountDTO> getByProfilePreferenceId(String id) throws SVTException;
    public List<TwitterAccountDTO> getByProfilePreferenceIdSELF(String id) throws SVTException;
    public List<TwitterAccountDTO> getByProfilePreferenceIdNOTSELF(String id) throws SVTException;
    public List<TwitterAccountDTO> getByProfilePreferenceIdCompIdNOTSELF(String id, String companyId) throws SVTException;
    public List<TwitterAccountDTO> getByProfilePreferenceIdCompNameNOTSELF(String profileUserId, String companyName) throws SVTException;
    
    public List<TwitterAccountDTO> getByProfileUserIdSELF(String profileUserId) throws SVTException;
    public List<TwitterAccountDTO> getByProfileUserIdNOTSELF(String profileUserId) throws SVTException;
    public List<TwitterAccountDTO> getByProfileUserIdCompIdNOTSELF(String profileUserId, String companyId) throws SVTException;

    
    public TwitterAccountDTO add(TwitterAccountDTO dto) throws SVTException;
    public TwitterAccountDTO delete(TwitterAccountDTO dto) throws SVTException;
    
    //Added By Neel Dated 29-11-2010
    public void collectLDAPTwitterData(UserProfileDetailDTO userProfileDTO);
}
