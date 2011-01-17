// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="OverallPerformanceDummy"
 */
public class OverallPerformanceDummy  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String id;
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
    private String profileId;
    
    private String target;
    /**
     * @hibernate.property
     * 
     */
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * @hibernate.property
     * 
     */
    public String getDemographicsGrade() {
        return demographicsGrade;
    }

    public void setDemographicsGrade(String demographicsGrade) {
        this.demographicsGrade = demographicsGrade;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getEngagementGrade() {
        return engagementGrade;
    }

    public void setEngagementGrade(String engagementGrade) {
        this.engagementGrade = engagementGrade;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getInfluenceGrade() {
        return influenceGrade;
    }

    public void setInfluenceGrade(String influenceGrade) {
        this.influenceGrade = influenceGrade;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getLoyaltyGrade() {
        return loyaltyGrade;
    }

    public void setLoyaltyGrade(String loyaltyGrade) {
        this.loyaltyGrade = loyaltyGrade;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getOverallGrade() {
        return overallGrade;
    }

    public void setOverallGrade(String overallGrade) {
        this.overallGrade = overallGrade;
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
    public String getReachGrade() {
        return reachGrade;
    }

    public void setReachGrade(String reachGrade) {
        this.reachGrade = reachGrade;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getRetentionGrade() {
        return retentionGrade;
    }

    public void setRetentionGrade(String retentionGrade) {
        this.retentionGrade = retentionGrade;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getSentimentGrade() {
        return sentimentGrade;
    }

    public void setSentimentGrade(String sentimentGrade) {
        this.sentimentGrade = sentimentGrade;
    }
    /**
     * @hibernate.property
     * 
     */
    public boolean isCustomer() {
        return customer;
    }

    public void setCustomer(boolean customer) {
        this.customer = customer;
    }
    /**
     * @hibernate.property
     * 
     */
    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
 }
