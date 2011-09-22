package com.edifixio.soc.web.dto;

public class TrendingGraphDetailDTO {
    private String overallGrade;
    private String sentimentGrade;
    private String engagementGrade;
    private String retentionGrade;
    private String demographicsGrade;
    private String loyaltyGrade;
    private String influenceGrade;
    private String reachGrade;
    private int displayOrder;
    private boolean customer;
    
    private String selectedCategoryGrade;
    
    public String getOverallGrade() {
        return overallGrade;
    }
    public void setOverallGrade(String overallGrade) {
        this.overallGrade = overallGrade;
    }
    public String getSentimentGrade() {
        return sentimentGrade;
    }
    public void setSentimentGrade(String sentimentGrade) {
        this.sentimentGrade = sentimentGrade;
    }
    public String getEngagementGrade() {
        return engagementGrade;
    }
    public void setEngagementGrade(String engagementGrade) {
        this.engagementGrade = engagementGrade;
    }
    public String getRetentionGrade() {
        return retentionGrade;
    }
    public void setRetentionGrade(String retentionGrade) {
        this.retentionGrade = retentionGrade;
    }
    public String getDemographicsGrade() {
        return demographicsGrade;
    }
    public void setDemographicsGrade(String demographicsGrade) {
        this.demographicsGrade = demographicsGrade;
    }
    public String getLoyaltyGrade() {
        return loyaltyGrade;
    }
    public void setLoyaltyGrade(String loyaltyGrade) {
        this.loyaltyGrade = loyaltyGrade;
    }
    public String getInfluenceGrade() {
        return influenceGrade;
    }
    public void setInfluenceGrade(String influenceGrade) {
        this.influenceGrade = influenceGrade;
    }
    public String getReachGrade() {
        return reachGrade;
    }
    public void setReachGrade(String reachGrade) {
        this.reachGrade = reachGrade;
    }
    public int getDisplayOrder() {
        return displayOrder;
    }
    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
    public boolean isCustomer() {
        return customer;
    }
    public void setCustomer(boolean customer) {
        this.customer = customer;
    }
    
    public String getSelectedCategoryGrade() {
        return selectedCategoryGrade;
    }
    public void setSelectedCategoryGrade(String selectedCategoryGrade) {
        this.selectedCategoryGrade = selectedCategoryGrade;
    } 

}
