// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.dto.ProfilePreferenceDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfilePreference;

public class ProfilePreferenceMgrImpl extends BaseBizObject implements ProfilePreferenceMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(ProfilePreferenceMgrImpl.class);

    public List<ProfilePreferenceDTO> findAll() throws SVTException {
        // Using spring to get the dao mgr
        log.debug("Successful in connecting to Biz layer");
        return getProfilePreferenceDTOList(getDaoProvider().getProfilePreferenceDAO().findall());
    }
    public ProfilePreferenceDTO getByProfilePreferenceId(String id) throws SVTException {
        // TODO Auto-generated method stub
        return getProfilePreferenceDTO(getDaoProvider().getProfilePreferenceDAO().getByProfilePreferenceId(id));
    }
    public ProfilePreferenceDTO getByProfileUserId(String profileUserId) throws SVTException {
        // TODO Auto-generated method stub
        return getProfilePreferenceDTO(getDaoProvider().getProfilePreferenceDAO().getByProfileUserId(profileUserId));
    }

    public ProfilePreferenceDTO add(ProfilePreferenceDTO dto) throws SVTException {
        // TODO Auto-generated method stub
        return null;
    }

    private List<ProfilePreferenceDTO> getProfilePreferenceDTOList(List<ProfilePreference> ppdtos) {
        List<ProfilePreferenceDTO> dtos = new ArrayList<ProfilePreferenceDTO>();
        for(ProfilePreference ppdto: ppdtos){
            dtos.add(getProfilePreferenceDTO(ppdto));
        }
        return dtos;
    }
    private ProfilePreferenceDTO getProfilePreferenceDTO(ProfilePreference ppdto) {
        ProfilePreferenceDTO dto = new ProfilePreferenceDTO();
        dto.setProfilePrefrenceId(ppdto.getProfilePrefrenceId());
        dto.setCompany(ppdto.getCompany());
        dto.setProfilePreference(ppdto);
        return dto;
    }

}
