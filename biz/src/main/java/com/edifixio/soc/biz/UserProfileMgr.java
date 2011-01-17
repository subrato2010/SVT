package com.edifixio.soc.biz;

import java.util.List;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.common.SVTException;

public interface UserProfileMgr extends BaseMgr{
    public UserProfileDetailDTO getProfileByUserId(String userId)throws SVTException;
    public UserProfileDetailDTO getProfileByUserMailId(String mailId) throws SVTException;
    public void updateUserProfile(UserProfileDetailDTO userProfileDTO)throws SVTException;
    public void createUserProfile(UserProfileDetailDTO userProfileDTO) throws SVTException;
    public List<UserProfileDetailDTO> getAll()throws SVTException;  
}
