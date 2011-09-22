// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="GoogleAnalyticsAccount"
 */
public class GoogleAnalyticsAccount  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String googleAnalyticsAccountId;
    private ProfilePreference profilePreference;
    private String name;
    private String googleAnalyticsTableId;
    private String description;
    private boolean activeStatus;
    private int displayOrder;

    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getGoogleAnalyticsAccountId() {
        return googleAnalyticsAccountId;
    }
    public void setGoogleAnalyticsAccountId(String googleAnalyticsAccountId) {
        this.googleAnalyticsAccountId = googleAnalyticsAccountId;
    }
    /**
     * @return Returns the pp.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="profilePreferenceId" not-null="true"
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public int getDisplayOrder() {
        return displayOrder;
    }
    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
    public String getGoogleAnalyticsTableId() {
        return googleAnalyticsTableId;
    }
    public void setGoogleAnalyticsTableId(String googleAnalyticsTableId) {
        this.googleAnalyticsTableId = googleAnalyticsTableId;
    }
}
