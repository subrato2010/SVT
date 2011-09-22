package com.edifixio.soc.web.beans;

import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.web.controllers.BaseWebObject;
import com.edifixio.soc.web.controllers.UserProfileController;

public class ManageBitlyOperations extends BaseWebObject
{
    private UserProfileController userProfileController;
    
    public void persistBitlyAccessToken(String bitlyUserName, String bitlyAccessToken, String bitlyApiKey) throws SVTException
    {
        
        UserProfileDetailDTO dto = getUserProfile();
        
        dto.setBitlyAccessToken(bitlyAccessToken);
        dto.setBitlyAPIKey(bitlyApiKey);
        dto.setBitlyUsername(bitlyUserName);
        getProfilePreferenceMgr().updateBitlyToken(dto);        
        
    }
    
    /**
     * @return the userProfileController
     */
    public UserProfileController getUserProfileController() {
        return userProfileController;
    }

    /**
     * @param userProfileController the userProfileController to set
     */
    public void setUserProfileController(UserProfileController userProfileController) {
        this.userProfileController = userProfileController;
    }
    
    public UserProfileDetailDTO getUserProfile()
    {
        return getUserProfileController().getUserProfile();
    }
}
