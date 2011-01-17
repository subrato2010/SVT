// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="ProfileListMaster"
 */
public class ProfileListMaster  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String profileListMasterId;
    private String listName;
    private String description;
    private String privacy; // "public" or "private"
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getListName() {
        return listName;
    }
    public void setListName(String listName) {
        this.listName = listName;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getPrivacy() {
        return privacy;
    }
    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getProfileListMasterId() {
        return profileListMasterId;
    }
    public void setProfileListMasterId(String profileListMasterId) {
        this.profileListMasterId = profileListMasterId;
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
    

}
