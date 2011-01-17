package com.edifixio.soc.web.dto;

public class SocialIntellignceMetricsDTO {
    
    private String Id;
    private String metricsName;
    private String metricsDesc;
    private String custVolume;
    private String cmptVolume;
    private String custTarget;
    private String percentIncrease;
    private String type;
    
    private String profileId;

    public String getCmptVolume() {
        return cmptVolume;
    }

    public void setCmptVolume(String cmptVolume) {
        this.cmptVolume = cmptVolume;
    }

    public String getCustTarget() {
        return custTarget;
    }

    public void setCustTarget(String custTarget) {
        this.custTarget = custTarget;
    }

    public String getCustVolume() {
        return custVolume;
    }

    public void setCustVolume(String custVolume) {
        this.custVolume = custVolume;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getMetricsDesc() {
        return metricsDesc;
    }

    public void setMetricsDesc(String metricsDesc) {
        this.metricsDesc = metricsDesc;
    }

    public String getMetricsName() {
        return metricsName;
    }

    public void setMetricsName(String metricsName) {
        this.metricsName = metricsName;
    }

    public String getPercentIncrease() {
        return percentIncrease;
    }

    public void setPercentIncrease(String percentIncrease) {
        this.percentIncrease = percentIncrease;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
