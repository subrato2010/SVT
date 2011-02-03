// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @hibernate.class table="OutboundMetricsDummy"
 */
public class OutboundMetricsDummy  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String Id;
    private boolean activeStatus;
    private String metricsName;
    private String metricsDesc;
    private String custVolume;
    private String cmptVolume;
    private String custTarget;
    private String percentIncrease;
    private int alertFlameCount;
    private int alertStarCount;
    private String alertMessage;
    private ArrayList<String> counter;
    private ArrayList<String> starCounter;
    private String targetModerate;
    private String targetAggressive;
    private String targetVAggressive;
    private String pctModerate;
    private String pctAggressive;
    private String pctVAggressive;   
    //private boolean channelOptActionDisplay;
    private String pctPotnModerate;
    private String pctPotnAggressive;
    private String pctPotnVAggressive; 
    private String categoryId;
    private String metricId;
    private String overallCategoryId;
    private double overallCategoryWt;    
    private double weight;    
    private int lowerBound;
    private int upperBound;
    private double custVolumeScale100;
    private double cmptVolumeScale100;
    
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
        return getPctText(pctAggressive);
    }


    public void setPctAggressive(String pctAggressive) {
        this.pctAggressive = pctAggressive;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getPctModerate() {
        return getPctText(pctModerate);
    }

    public void setPctModerate(String pctModerate) {
        this.pctModerate = pctModerate;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getPctVAggressive() {
        return getPctText(pctVAggressive);
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
    private String profileId;
    /**
     * @hibernate.property
     * 
     */
    
    public int getAlertFlameCount() {
        return alertFlameCount;
    }

    public void setAlertFlameCount(int alertFlameCount) {
        this.alertFlameCount = alertFlameCount;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
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
    /**
     * @hibernate.property
     * 
     */
    public int getAlertStarCount() {
        return alertStarCount;
    }

    public void setAlertStarCount(int alertStarCount) {
        this.alertStarCount = alertStarCount;
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
    
    public ArrayList<String> getCounter() {
        counter=new ArrayList<String>();
        for(int i=0; i <  getAlertFlameCount(); i++){
           counter.add("*"); 
        }
        return counter;
    }
    

    public ArrayList<String> getStarCounter() {
        starCounter=new ArrayList<String>();
        for(int i=0; i <  getAlertStarCount(); i++){
            starCounter.add("*"); 
        }
        return starCounter;
    }
    
    private String getPctText(String pctText) {
        if(pctText != null){
            return (pctText.toLowerCase().indexOf("infinite")>=0)?("NA"):(pctText + "%");
        }
        return null;
    }

    public boolean isChannelOptActionDisplay() {
        if (getAlertMessage()==null){
            return false;
        }
        return getAlertMessage().toLowerCase().indexOf("influence") >=0 ;
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
    
    // --- may be not required below this -----//
    
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

    public String getOverallCategoryId() {
        return overallCategoryId;
    }

    public void setOverallCategoryId(String overallCategoryId) {
        this.overallCategoryId = overallCategoryId;
    }

    public double getOverallCategoryWt() {
        return overallCategoryWt;
    }

    public void setOverallCategoryWt(double overallCategoryWt) {
        this.overallCategoryWt = overallCategoryWt;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    public double getCustVolumeScale100() {
        return custVolumeScale100;
    }

    public void setCustVolumeScale100(double custVolumeScale100) {
        this.custVolumeScale100 = custVolumeScale100;
    }

    public double getCmptVolumeScale100() {
        return cmptVolumeScale100;
    }

    public void setCmptVolumeScale100(double cmptVolumeScale100) {
        this.cmptVolumeScale100 = cmptVolumeScale100;
    }

    public String getMetricId() {
        return metricId;
    }

    public void setMetricId(String metricId) {
        this.metricId = metricId;
    }
 }
