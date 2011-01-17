// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="ProfileInfluence"
 */
public class ProfileInfluence  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String profileInfluenceId;
    private String profileImgName;
    private String userId;
    private String firstName;
    private String lastName;
    private String title;
    private boolean activeStatus;
    private ProfilePreference profilePreference;
    /**
     * @hibernate.property
     * 
     */
    public boolean isActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getProfileInfluenceId() {
        return profileInfluenceId;
    }
    public void setProfileInfluenceId(String profileInfluenceId) {
        this.profileInfluenceId = profileInfluenceId;
    }
    /**
     * @return Returns the ProfilePreferences.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="profilePrefrenceId" not-null="true"
     */
    public ProfilePreference getProfilePreference() {
        return profilePreference;
    }
    public void setProfilePreference(ProfilePreference profilePreference) {
        this.profilePreference = profilePreference;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getProfileImgName() {
        return profileImgName;
    }
    public void setProfileImgName(String profileImgName) {
        this.profileImgName = profileImgName;
    }
    

}
