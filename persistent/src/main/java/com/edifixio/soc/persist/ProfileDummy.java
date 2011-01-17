// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="ProfileDummy"
 */
public class ProfileDummy  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String profileId;
    private String name;
    private String description;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getProfileId() {
        return profileId;
    }
    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    
 }
