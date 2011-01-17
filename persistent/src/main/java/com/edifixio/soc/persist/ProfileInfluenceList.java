// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="ProfileInfluenceList"
 */
public class ProfileInfluenceList  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String profileInfluenceListId;
    private ProfileInfluence profileInfluence;
    private ProfileListMaster profileListMaster;
    
    /**
     * @return Returns the ProfileInfluences.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="profileInfluenceId" not-null="true"
     */
    public ProfileInfluence getProfileInfluence() {
        return profileInfluence;
    }
    public void setProfileInfluence(ProfileInfluence profileInfluence) {
        this.profileInfluence = profileInfluence;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getProfileInfluenceListId() {
        return profileInfluenceListId;
    }
    public void setProfileInfluenceListId(String profileInfluenceListId) {
        this.profileInfluenceListId = profileInfluenceListId;
    }
    /**
     * @return Returns the ProfileInfluences.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="profileListMasterId" not-null="true"
     */
    public ProfileListMaster getProfileListMaster() {
        return profileListMaster;
    }
    public void setProfileListMaster(ProfileListMaster profileListMaster) {
        this.profileListMaster = profileListMaster;
    }

}
