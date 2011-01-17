// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;
import com.edifixio.soc.biz.dto.ProfilePreferenceDTO;
import com.edifixio.soc.common.SVTException;

public interface ProfilePreferenceMgr extends BaseMgr{
    public List<ProfilePreferenceDTO> findAll() throws SVTException;
    public ProfilePreferenceDTO getByProfilePreferenceId(String id) throws SVTException;
    public ProfilePreferenceDTO getByProfileUserId(String profileUserId) throws SVTException;
    public ProfilePreferenceDTO add(ProfilePreferenceDTO dto) throws SVTException;
}
