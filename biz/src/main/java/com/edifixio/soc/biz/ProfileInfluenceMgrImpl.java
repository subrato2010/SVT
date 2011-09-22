// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.dto.ProfileInfluenceDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfileInfluence;

public class ProfileInfluenceMgrImpl extends BaseBizObject implements ProfileInfluenceMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(ProfileInfluenceMgrImpl.class);

    public List<ProfileInfluenceDTO> getByProfilePreferenceId(String id) throws SVTException {
        return getDTOs(getDaoProvider().getProfileInfluenceDAO().getByProfilePreferenceId(id));
    }
    public ProfileInfluenceDTO getByProfileInfluenceId(String userId) throws SVTException {
        
        return getDTO(getDaoProvider().getProfileInfluenceDAO().getByProfileInfluenceId(userId));
    }
    public ProfileInfluence save(ProfileInfluenceDTO profileInfluence) throws SVTException {
        // TODO Auto-generated method stub
        return null;
    }  
    
    public List<ProfileInfluenceDTO> findall() throws SVTException {
        
        return getDTOs(getDaoProvider().getProfileInfluenceDAO().findall());
    }
    
   
    private List<ProfileInfluenceDTO> getDTOs(List<ProfileInfluence> piList) {
        List<ProfileInfluenceDTO> dtos = new ArrayList<ProfileInfluenceDTO>();
        for(ProfileInfluence pi: piList){
            dtos.add(getDTO(pi));
        }        
        return dtos;
    }
    
    private ProfileInfluenceDTO getDTO(ProfileInfluence pi) {
        ProfileInfluenceDTO dto = new ProfileInfluenceDTO();
        quietlyCopyProperties(dto, pi);
        return dto;
    }

}
