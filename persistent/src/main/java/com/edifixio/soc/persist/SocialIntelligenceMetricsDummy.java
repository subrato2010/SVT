// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @hibernate.class table="SocialIntelligenceMetricsDummy"
 */
public class SocialIntelligenceMetricsDummy  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String Id;
    private String metricsName;
    private String metricsDesc;
    private String custVolume;
    private int custVolumeTrend; // 0=nochange, -1=down, 1=up
    private String cmptVolume;
    private int cmptVolumeTrend; // 0=nochange, -1=down, 1=up
    private String custTarget;
    private String percentIncrease;
    private String type;
    
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
    private boolean dataProcessed; // flag to check if backendprocess is complete
    private boolean dataProcessedCmpt; // nonstandard request from wendy
    private String custTargetRaw;
    private double custTargetActual;  
    private double baselineTargetRaw;
    private double currentTargetRaw;
    private String currentTargetRawString;
    private String percentIncreaseRaw;
    private String percentIncreaseRawScale100;
    private String calculatedYourVolume;
    
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
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return null;
    }
    public String getTargetAggressiveFormatted() {
        if(metricsName != null){
            return (metricsName.toLowerCase().indexOf("percentage")>=0)?(targetAggressive + "%"):(targetAggressive);
        }
        return null;
    }
    public String getTargetVAggressiveFormatted() {
        if(metricsName != null){
            return (metricsName.toLowerCase().indexOf("percentage")>=0)?(targetVAggressive + "%"):(targetVAggressive);
        }
        return null;
    }

    public int getCustVolumeTrend() {
        return custVolumeTrend;
    }

    public void setCustVolumeTrend(int custVolumeTrend) {
        this.custVolumeTrend = custVolumeTrend;
    }

    public int getCmptVolumeTrend() {
        return cmptVolumeTrend;
    }

    public void setCmptVolumeTrend(int cmptVolumeTrend) {
        this.cmptVolumeTrend = cmptVolumeTrend;
    }

    public boolean isDataProcessed() {
        return dataProcessed;
    }

    public void setDataProcessed(boolean dataProcessed) {
        this.dataProcessed = dataProcessed;
    }

    public String getCustTargetRaw() {
        return custTargetRaw;
    }

    public void setCustTargetRaw(String custTargetRaw) {
        this.custTargetRaw = custTargetRaw;
    }

    public String getPercentIncreaseRaw() {
        return percentIncreaseRaw;
    }

    public void setPercentIncreaseRaw(String percentIncreaseRaw) {
        this.percentIncreaseRaw = percentIncreaseRaw;
    }

    public boolean isDataProcessedCmpt() {
        return dataProcessedCmpt;
    }

    public void setDataProcessedCmpt(boolean dataProcessedCmpt) {
        this.dataProcessedCmpt = dataProcessedCmpt;
    }
    public String getCustVolumeRoundUp() {        
        if(getCustVolume() != null){
            Double value = Double.parseDouble(getCustVolume());
            DecimalFormat zeroDForm = new DecimalFormat("#");
            return "" + Double.valueOf(zeroDForm.format(value)).intValue();
        }
        return getCustVolume();
   }


    public String getCmptVolumeRoundUp() {
        if(getCmptVolume() != null){
            Double value = Double.parseDouble(getCmptVolume());
            DecimalFormat zeroDForm = new DecimalFormat("#");
            return "" + Double.valueOf(zeroDForm.format(value)).intValue();
        }
        return getCmptVolume();
    }

    public String getCalculatedYourVolumeRoundUp() {
        if(getCalculatedYourVolume() != null){
            Double value = Double.parseDouble(getCalculatedYourVolume());
            DecimalFormat zeroDForm = new DecimalFormat("#");
            return "" + Double.valueOf(zeroDForm.format(value)).intValue();
        }
        return getCalculatedYourVolume();
    }
    
    public double getCustTargetActual() {
        return custTargetActual;
    }

    public void setCustTargetActual(double custTargetActual) {
        this.custTargetActual = custTargetActual;
    }

    public String getPercentIncreaseRawScale100() {
        return percentIncreaseRawScale100;
    }

    public void setPercentIncreaseRawScale100(String percentIncreaseRawScale100) {
        this.percentIncreaseRawScale100 = percentIncreaseRawScale100;
    }

    public String getCalculatedYourVolume() {
        return calculatedYourVolume;
    }

    public void setCalculatedYourVolume(String calculatedYourVolume) {
        this.calculatedYourVolume = calculatedYourVolume;
    }

    public double getBaselineTargetRaw() {
        return baselineTargetRaw;
    }

    public void setBaselineTargetRaw(double baselineTargetRaw) {
        this.baselineTargetRaw = baselineTargetRaw;
    }

    public double getCurrentTargetRaw() {
        return currentTargetRaw;
    }

    public void setCurrentTargetRaw(double currentTargetRaw) {
        this.currentTargetRaw = currentTargetRaw;
    }

    public String getCurrentTargetRawString() {
        return currentTargetRawString;
    }

    public void setCurrentTargetRawString(String currentTargetRawString) {
        this.currentTargetRawString = currentTargetRawString;
    }


 }
