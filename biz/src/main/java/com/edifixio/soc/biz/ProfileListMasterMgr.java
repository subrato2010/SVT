// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;
import com.edifixio.soc.biz.dto.ProfileListMasterDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfileListMaster;

public interface ProfileListMasterMgr extends BaseMgr{
    public List<ProfileListMasterDTO> findall()  throws SVTException;
    public List<ProfileListMasterDTO> getByProfilePreferenceId(String id) throws SVTException;
    public ProfileListMasterDTO getByProfileListMasterId(String id) throws SVTException;
    public List<ProfileListMasterDTO> saveAndList(ProfileListMasterDTO dto) throws SVTException;
    public ProfileListMaster save(ProfileListMasterDTO dto) throws SVTException;
}
