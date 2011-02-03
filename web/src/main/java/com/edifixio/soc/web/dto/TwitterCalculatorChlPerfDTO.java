package com.edifixio.soc.web.dto;

import java.util.Date;
import java.util.List;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.persist.InboundMetricsDummy;
import com.edifixio.soc.persist.OutboundMetricsDummy;
import com.edifixio.soc.persist.OverallPerformanceDummy;
import com.edifixio.soc.persist.SocialIntelligenceMetricsDummy;

public class TwitterCalculatorChlPerfDTO {

    private List<OverallPerformanceDummy> overallPerformanceDummy;
    private List<OutboundMetricsDummy> outboundMetricsDummy;
    private List<InboundMetricsDummy> inboundMetricsDummy;
    private List<SocialIntelligenceMetricsDummy> engagementDummy; 
    private List<SocialIntelligenceMetricsDummy> reachDummy;
    private List<SocialIntelligenceMetricsDummy> loyaltyDummy;
    private List<SocialIntelligenceMetricsDummy> demographicsDummy;
    private List<SocialIntelligenceMetricsDummy> retentionDummy;
    private List<SocialIntelligenceMetricsDummy> influenceDummy;
    private List<SocialIntelligenceMetricsDummy> sentimentDummy;
    private List<TwitterAccountDTO> twitterAccount;
    private Date benchmarkDateFrom;
    private Date benchmarkDateTo;
    
    public List<SocialIntelligenceMetricsDummy> getDemographicsDummy() {
        return demographicsDummy;
    }
    public void setDemographicsDummy(
            List<SocialIntelligenceMetricsDummy> demographicsDummy) {
        this.demographicsDummy = demographicsDummy;
    }
    public List<SocialIntelligenceMetricsDummy> getEngagementDummy() {
        return engagementDummy;
    }
    public void setEngagementDummy(
            List<SocialIntelligenceMetricsDummy> engagementDummy) {
        this.engagementDummy = engagementDummy;
    }
    public List<InboundMetricsDummy> getInboundMetricsDummy() {
        return inboundMetricsDummy;
    }
    public void setInboundMetricsDummy(List<InboundMetricsDummy> inboundMetricsDummy) {
        this.inboundMetricsDummy = inboundMetricsDummy;
    }
    public List<SocialIntelligenceMetricsDummy> getInfluenceDummy() {
        return influenceDummy;
    }
    public void setInfluenceDummy(
            List<SocialIntelligenceMetricsDummy> influenceDummy) {
        this.influenceDummy = influenceDummy;
    }
    public List<SocialIntelligenceMetricsDummy> getLoyaltyDummy() {
        return loyaltyDummy;
    }
    public void setLoyaltyDummy(List<SocialIntelligenceMetricsDummy> loyaltyDummy) {
        this.loyaltyDummy = loyaltyDummy;
    }
    public List<OutboundMetricsDummy> getOutboundMetricsDummy() {
        return outboundMetricsDummy;
    }
    public void setOutboundMetricsDummy(
            List<OutboundMetricsDummy> outboundMetricsDummy) {
        this.outboundMetricsDummy = outboundMetricsDummy;
    }
    public List<OverallPerformanceDummy> getOverallPerformanceDummy() {
        return overallPerformanceDummy;
    }
    public void setOverallPerformanceDummy(
            List<OverallPerformanceDummy> overallPerformanceDummy) {
        this.overallPerformanceDummy = overallPerformanceDummy;
    }
    public List<SocialIntelligenceMetricsDummy> getReachDummy() {
        return reachDummy;
    }
    public void setReachDummy(List<SocialIntelligenceMetricsDummy> reachDummy) {
        this.reachDummy = reachDummy;
    }
    public List<SocialIntelligenceMetricsDummy> getRetentionDummy() {
        return retentionDummy;
    }
    public void setRetentionDummy(
            List<SocialIntelligenceMetricsDummy> retentionDummy) {
        this.retentionDummy = retentionDummy;
    }
    public List<SocialIntelligenceMetricsDummy> getSentimentDummy() {
        return sentimentDummy;
    }
    public void setSentimentDummy(
            List<SocialIntelligenceMetricsDummy> sentimentDummy) {
        this.sentimentDummy = sentimentDummy;
    }
    public List<TwitterAccountDTO> getTwitterAccount() {
        return twitterAccount;
    }
    public void setTwitterAccount(List<TwitterAccountDTO> twitterAccount) {
        this.twitterAccount = twitterAccount;
    }
    public Date getBenchmarkDateFrom() {
        return benchmarkDateFrom;
    }
    public void setBenchmarkDateFrom(Date benchmarkDateFrom) {
        this.benchmarkDateFrom = benchmarkDateFrom;
    }
    public Date getBenchmarkDateTo() {
        return benchmarkDateTo;
    }
    public void setBenchmarkDateTo(Date benchmarkDateTo) {
        this.benchmarkDateTo = benchmarkDateTo;
    }

}