package com.edifixio.soc.biz.dto;

import com.edifixio.soc.persist.ProfilePreference;

public class ProfileInfluenceDTO {
    private String profileInfluenceId;
    private String profileImgName;
    private String userId;
    private String firstName;
    private String lastName;
    private String title;
    private boolean activeStatus;
    private ProfilePreference profilePreference;
    public boolean isActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getProfileImgName() {
        return profileImgName;
    }
    public void setProfileImgName(String profileImgName) {
        this.profileImgName = profileImgName;
    }
    public String getProfileInfluenceId() {
        return profileInfluenceId;
    }
    public void setProfileInfluenceId(String profileInfluenceId) {
        this.profileInfluenceId = profileInfluenceId;
    }
    public ProfilePreference getProfilePreference() {
        return profilePreference;
    }
    public void setProfilePreference(ProfilePreference profilePreference) {
        this.profilePreference = profilePreference;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
