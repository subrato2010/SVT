package com.edifixio.soc.biz;

import java.util.List;

import com.edifixio.soc.biz.dto.ProfilePreferenceDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.common.SVTException;

public interface ProfilePreferenceMgr extends BaseMgr{
    public List<ProfilePreferenceDTO> findAll() throws SVTException;
    public ProfilePreferenceDTO getByProfilePreferenceId(String id) throws SVTException;
    public ProfilePreferenceDTO getByProfileUserId(String profileUserId) throws SVTException;
    public ProfilePreferenceDTO add(ProfilePreferenceDTO dto) throws SVTException;
    public UserProfileDetailDTO update(UserProfileDetailDTO dto) throws SVTException;
    public UserProfileDetailDTO updateGoogleAnalytics(UserProfileDetailDTO dto) throws SVTException;
    public UserProfileDetailDTO updateVanityURL(UserProfileDetailDTO dto) throws SVTException;
    public UserProfileDetailDTO updateBitlyToken(UserProfileDetailDTO dto) throws SVTException;
    
    public UserProfileDetailDTO updateAlwaysAskWarningAlert(UserProfileDetailDTO dto) throws SVTException; //Added by Neel
    public UserProfileDetailDTO updateKeyword(UserProfileDetailDTO dto) throws SVTException;
}
