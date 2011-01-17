// $Author: neelamadhabm $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="ImprovementLevel"
 */
public class ImprovementLevel  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String improvementLevelId;
    private String code;
    private String name;
    private String description;
    private String pctValue;
    private String starCount;
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
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getImprovementLevelId() {
        return improvementLevelId;
    }
    public void setImprovementLevelId(String improvementLevelId) {
        this.improvementLevelId = improvementLevelId;
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
    public String getPctValue() {
        return pctValue;
    }
    public void setPctValue(String pctValue) {
        this.pctValue = pctValue;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getStarCount() {
        return starCount;
    }
    public void setStarCount(String starCount) {
        this.starCount = starCount;
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
 }
