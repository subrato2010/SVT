package com.edifixio.soc.biz.dto;

import com.edifixio.soc.persist.ProfileInfluence;
import com.edifixio.soc.persist.ProfileListMaster;

public class ProfileInfluenceListDTO {
    private String profileInfluenceListId;
    private ProfileInfluence profileInfluence;
    private ProfileListMaster profileListMaster;
    public ProfileInfluence getProfileInfluence() {
        return profileInfluence;
    }
    public void setProfileInfluence(ProfileInfluence profileInfluence) {
        this.profileInfluence = profileInfluence;
    }
    public String getProfileInfluenceListId() {
        return profileInfluenceListId;
    }
    public void setProfileInfluenceListId(String profileInfluenceListId) {
        this.profileInfluenceListId = profileInfluenceListId;
    }
    public ProfileListMaster getProfileListMaster() {
        return profileListMaster;
    }
    public void setProfileListMaster(ProfileListMaster profileListMaster) {
        this.profileListMaster = profileListMaster;
    }

}
