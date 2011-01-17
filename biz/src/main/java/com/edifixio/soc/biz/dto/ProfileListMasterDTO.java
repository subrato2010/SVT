package com.edifixio.soc.biz.dto;

import com.edifixio.soc.persist.ProfilePreference;

public class ProfileListMasterDTO {
    private String profileListMasterId;
    private String listName;
    private String description;
    private String privacy; // "public" or "private"
    private boolean activeStatus;
    private ProfilePreference profilePreference;
    public boolean isActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getListName() {
        return listName;
    }
    public void setListName(String listName) {
        this.listName = listName;
    }
    public String getPrivacy() {
        return privacy;
    }
    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }
    public String getProfileListMasterId() {
        return profileListMasterId;
    }
    public void setProfileListMasterId(String profileListMasterId) {
        this.profileListMasterId = profileListMasterId;
    }
    public ProfilePreference getProfilePreference() {
        return profilePreference;
    }
    public void setProfilePreference(ProfilePreference profilePreference) {
        this.profilePreference = profilePreference;
    }

}
