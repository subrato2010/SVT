// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;

import com.edifixio.soc.biz.dto.ProfileInfluenceListDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfileInfluenceList;

public interface ProfileInfluenceListMgr extends BaseMgr{
    public List<ProfileInfluenceListDTO> findall()  throws SVTException;
    public ProfileInfluenceListDTO getByProfileInfluenceId(String userId) throws SVTException;
    public List<ProfileInfluenceListDTO> getByProfileListMasterId(String id) throws SVTException;
    public ProfileInfluenceList save(ProfileInfluenceListDTO dto) throws SVTException;
}
