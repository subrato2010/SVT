// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="Industry"
 */
public class Industry  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String industryId;
    private String industryCode;
    private String industryName;   
    private boolean activeStatus;
    
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
    public String getIndustryCode() {
        return industryCode;
    }
    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getIndustryId() {
        return industryId;
    }
    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getIndustryName() {
        return industryName;
    }
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }
 }
