package com.edifixio.soc.web.dto;

public class OverallPerformanceDTO {
    private String overallGrade;
    private String sentimentGrade;
    private String engagementGrade;
    private String retentionGrade;
    private String demographicsGrade;
    private String loyaltyGrade;
    private String influenceGrade;
    private String reachGrade;

    private String profileId;
    
    public String getProfileId() {
        return profileId;
    }
    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }
    public String getDemographicsGrade() {
        return demographicsGrade;
    }
    public void setDemographicsGrade(String demographicsGrade) {
        this.demographicsGrade = demographicsGrade;
    }
    public String getEngagementGrade() {
        return engagementGrade;
    }
    public void setEngagementGrade(String engagementGrade) {
        this.engagementGrade = engagementGrade;
    }
    public String getInfluenceGrade() {
        return influenceGrade;
    }
    public void setInfluenceGrade(String influenceGrade) {
        this.influenceGrade = influenceGrade;
    }
    public String getLoyaltyGrade() {
        return loyaltyGrade;
    }
    public void setLoyaltyGrade(String loyaltyGrade) {
        this.loyaltyGrade = loyaltyGrade;
    }
    public String getOverallGrade() {
        return overallGrade;
    }
    public void setOverallGrade(String overallGrade) {
        this.overallGrade = overallGrade;
    }
    public String getReachGrade() {
        return reachGrade;
    }
    public void setReachGrade(String reachGrade) {
        this.reachGrade = reachGrade;
    }
    public String getRetentionGrade() {
        return retentionGrade;
    }
    public void setRetentionGrade(String retentionGrade) {
        this.retentionGrade = retentionGrade;
    }
    public String getSentimentGrade() {
        return sentimentGrade;
    }
    public void setSentimentGrade(String sentimentGrade) {
        this.sentimentGrade = sentimentGrade;
    }
    
    
}
