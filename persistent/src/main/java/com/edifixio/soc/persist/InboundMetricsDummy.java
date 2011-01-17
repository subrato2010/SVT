// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="InboundMetricsDummy"
 */
public class InboundMetricsDummy  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String Id;
    private String metricsName;
    private String metricsDesc;
    private String custVolume;
    private String cmptVolume;
    private String custVolumeInt;
    private String custTarget;
    private String percentIncrease;
    
    private String profileId;
    private String targetModerate;
    private String targetAggressive;
    private String targetVAggressive;
    private String pctModerate;
    private String pctAggressive;
    private String pctVAggressive;
    private String pctPotnModerate;
    private String pctPotnAggressive;
    private String pctPotnVAggressive; 
    private String categoryId;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @hibernate.property
     * 
     */
    public String getPctPotnAggressive() {
        return pctPotnAggressive;
    }

    public void setPctPotnAggressive(String pctPotnAggressive) {
        this.pctPotnAggressive = pctPotnAggressive;
    }

    /**
     * @hibernate.property
     * 
     */
    public String getPctPotnModerate() {
        return pctPotnModerate;
    }

    public void setPctPotnModerate(String pctPotnModerate) {
        this.pctPotnModerate = pctPotnModerate;
    }

    /**
     * @hibernate.property
     * 
     */
    public String getPctPotnVAggressive() {
        return pctPotnVAggressive;
    }

    public void setPctPotnVAggressive(String pctPotnVAggressive) {
        this.pctPotnVAggressive = pctPotnVAggressive;
    }    
    /**
     * @hibernate.property
     * 
     */
    public String getPctAggressive() {
        return pctAggressive;
    }

    public void setPctAggressive(String pctAggressive) {
        this.pctAggressive = pctAggressive;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getPctModerate() {
        return pctModerate;
    }

    public void setPctModerate(String pctModerate) {
        this.pctModerate = pctModerate;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getPctVAggressive() {
        return pctVAggressive;
    }

    public void setPctVAggressive(String pctVAggressive) {
        this.pctVAggressive = pctVAggressive;
    }

    /**
     * @hibernate.property
     * 
     */
    public String getTargetAggressive() {
        return targetAggressive;
    }

    public void setTargetAggressive(String targetAggressive) {
        this.targetAggressive = targetAggressive;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getTargetModerate() {
        return targetModerate;
    }

    public void setTargetModerate(String targetModerate) {
        this.targetModerate = targetModerate;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getTargetVAggressive() {
        return targetVAggressive;
    }

    public void setTargetVAggressive(String targetVAggressive) {
        this.targetVAggressive = targetVAggressive;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getCmptVolume() {
        return cmptVolume;
    }

    public void setCmptVolume(String cmptVolume) {
        this.cmptVolume = cmptVolume;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getCustTarget() {
        return custTarget;
    }

    public void setCustTarget(String custTarget) {
        this.custTarget = custTarget;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getCustVolume() {
        return custVolume;
    }
    public int getCustVolumeInt() {
        return Integer.parseInt(custVolume);
    }
    public void setCustVolume(String custVolume) {
        this.custVolume = custVolume;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getMetricsDesc() {
        return metricsDesc;
    }

    public void setMetricsDesc(String metricsDesc) {
        this.metricsDesc = metricsDesc;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getMetricsName() {
        return metricsName;
    }

    public void setMetricsName(String metricsName) {
        this.metricsName = metricsName;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getPercentIncrease() {
        return percentIncrease;
    }

    public void setPercentIncrease(String percentIncrease) {
        this.percentIncrease = percentIncrease;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getCustVolumeFormatted() {
        if(metricsName != null){
            String value = (custVolume == null)?(""):(custVolume);            
            return (metricsName.toLowerCase().indexOf("percentage")>=0 &&(value != ""))?(custVolume + "%"):(custVolume);
        }
        return "";
    }
    public String getCmptVolumeFormatted() {
        if(metricsName != null){
            String value = (cmptVolume == null)?(""):(cmptVolume);
            return (metricsName.toLowerCase().indexOf("percentage")>=0 &&(value != ""))?(cmptVolume + "%"):(cmptVolume);
        }
        return "";
    }
    public String getCustTargetFormatted() {
        if(metricsName != null){
            String value = (custTarget == null)?(""):(custTarget);            
            return (metricsName.toLowerCase().indexOf("percentage")>=0 &&(value != ""))?(custTarget + "%"):(custTarget);
        }
        return "";
    }
    public String getTargetModerateFormatted() {
        if(metricsName != null){
            return (metricsName.toLowerCase().indexOf("percentage")>=0)?(targetModerate + "%"):(targetModerate);
        }
        return "";
    }
    public String getTargetAggressiveFormatted() {
        if(metricsName != null){
            return (metricsName.toLowerCase().indexOf("percentage")>=0)?(targetAggressive + "%"):(targetAggressive);
        }
        return "";
    }
    public String getTargetVAggressiveFormatted() {
        if(metricsName != null){
            return (metricsName.toLowerCase().indexOf("percentage")>=0)?(targetVAggressive + "%"):(targetVAggressive);
        }
        return "";
    }

 }
