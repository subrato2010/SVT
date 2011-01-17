// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;
import com.edifixio.soc.biz.dto.ProfileInfluenceDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfileInfluence;

public interface ProfileInfluenceMgr extends BaseMgr{
    public List<ProfileInfluenceDTO> findall()  throws SVTException;
    public List<ProfileInfluenceDTO> getByProfilePreferenceId(String id) throws SVTException;
    public ProfileInfluenceDTO getByProfileInfluenceId(String userId) throws SVTException;
    public ProfileInfluence save(ProfileInfluenceDTO profileInfluence)  throws SVTException;
}
