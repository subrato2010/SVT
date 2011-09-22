// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.dto.ProfileInfluenceListDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfileInfluenceList;

public class ProfileInfluenceListMgrImpl extends BaseBizObject implements ProfileInfluenceListMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(ProfileInfluenceListMgrImpl.class);

    public List<ProfileInfluenceListDTO> findall() throws SVTException {
        
        return getDTOs(getDaoProvider().getProfileInfluenceListDAO().findall());
    }
    public ProfileInfluenceListDTO getByProfileInfluenceId(String userId) throws SVTException {
        
        return getDTO(getDaoProvider().getProfileInfluenceListDAO().getByProfileInfluenceId(userId));
    }
    public List<ProfileInfluenceListDTO> getByProfileListMasterId(String id) throws SVTException {
        return getDTOs(getDaoProvider().getProfileInfluenceListDAO().getByProfileListMasterId(id));
    }
    public ProfileInfluenceList save(ProfileInfluenceListDTO dto) throws SVTException {
        if(dto.getProfileInfluence() == null || dto.getProfileListMaster() == null){
            log.debug("Missing mandatory fields...");
            return null;
        }
        
        // check if combination already exist
        ProfileInfluenceList pil1 = getDaoProvider().getProfileInfluenceListDAO().getByProfInfluIdProfListMastId(dto.getProfileInfluence().getProfileInfluenceId(),
                dto.getProfileListMaster().getProfileListMasterId());
        if(pil1 != null){
            // already exist, so update
            return pil1;
            
        }else{
           // doesnot exist, so add
            ProfileInfluenceList pil = new ProfileInfluenceList();
            pil.setProfileInfluence(dto.getProfileInfluence());
            pil.setProfileListMaster(dto.getProfileListMaster());
            return getDaoProvider().getProfileInfluenceListDAO().add(pil);
        }
    }
    
    private List<ProfileInfluenceListDTO> getDTOs(List<ProfileInfluenceList> piList) {
        List<ProfileInfluenceListDTO> dtos = new ArrayList<ProfileInfluenceListDTO>();
        for(ProfileInfluenceList pi: piList){
            dtos.add(getDTO(pi));
        }        
        return dtos;
    }
    
    private ProfileInfluenceListDTO getDTO(ProfileInfluenceList pi) {
        ProfileInfluenceListDTO dto = new ProfileInfluenceListDTO();
        quietlyCopyProperties(dto, pi);
        return dto;
    }
}
