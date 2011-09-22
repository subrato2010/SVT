// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.dto.ProfileListMasterDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfileListMaster;

public class ProfileListMasterMgrImpl extends BaseBizObject implements ProfileListMasterMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(ProfileListMasterMgrImpl.class);

    public List<ProfileListMasterDTO> findall() throws SVTException {
        
        return getDTOs(getDaoProvider().getProfileListMasterDAO().findall());
    }
    
    public ProfileListMasterDTO getByProfileListMasterId(String id) throws SVTException {
        return getDTO(getDaoProvider().getProfileListMasterDAO().getByProfileListMasterId(id));
    }
    public List<ProfileListMasterDTO> getByProfilePreferenceId(String id) throws SVTException {
        return getDTOs(getDaoProvider().getProfileListMasterDAO().getByProfilePreferenceId(id));
    }
    public List<ProfileListMasterDTO> saveAndList(ProfileListMasterDTO dto) throws SVTException {
        save(dto);
        return getByProfilePreferenceId(dto.getProfilePreference().getProfilePrefrenceId());
    }

    public ProfileListMaster save(ProfileListMasterDTO dto) throws SVTException {
        
        if(dto.getProfilePreference() == null){
            log.debug("Profile Preference is missing...");
            return null;
        }
        
        // check if listName already exist for the profile
        ProfileListMaster plm1 = getDaoProvider().getProfileListMasterDAO().getByProfilePreferenceIdName(dto.getProfilePreference().getProfilePrefrenceId(), dto.getListName());
        if(plm1 != null){
            // already exist, so update
            plm1.setListName(dto.getListName());
            plm1.setDescription(dto.getDescription());
            return getDaoProvider().getProfileListMasterDAO().update(plm1);
            
        }else{
           // doesnot exist, so add
            ProfileListMaster plm = new ProfileListMaster();
            quietlyCopyProperties(plm, dto);
            plm.setProfilePreference(dto.getProfilePreference());
            return getDaoProvider().getProfileListMasterDAO().add(plm);
        }
    }

    private List<ProfileListMasterDTO> getDTOs(List<ProfileListMaster> plms) {
        List<ProfileListMasterDTO> dtos = new ArrayList<ProfileListMasterDTO>();
        for(ProfileListMaster plm: plms){
            dtos.add(getDTO(plm));
        }        
        return dtos;
    }
    
    private ProfileListMasterDTO getDTO(ProfileListMaster plm) {
        ProfileListMasterDTO dto = new ProfileListMasterDTO();
        quietlyCopyProperties(dto, plm);
        return dto;
    }

}
