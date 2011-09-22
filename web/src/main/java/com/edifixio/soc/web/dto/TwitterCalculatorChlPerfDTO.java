package com.edifixio.soc.web.dto;

import java.util.Date;
import java.util.List;

import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.persist.InboundMetricsDummy;
import com.edifixio.soc.persist.OutboundMetricsDummy;
import com.edifixio.soc.persist.OverallPerformanceDummy;
import com.edifixio.soc.persist.SocialIntelligenceMetricsDummy;

public class TwitterCalculatorChlPerfDTO {

    private Date resetDate;
    private Date minDate;
    private Date maxdate;
 
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
    private int minPerformanceAsofDiffFromCurrentDate;
    private int maxPerformanceAsofDiffFromCurrentDate;
    private int minBenchmarkAsofDiffFromCurrentDate;   
    private String rtoGoalPercentage;
    private int rtoStarCount;
    private int rtoFlameCount;
    
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
    public int getMinPerformanceAsofDiffFromCurrentDate() {
        return minPerformanceAsofDiffFromCurrentDate;
    }
    public void setMinPerformanceAsofDiffFromCurrentDate(
            int minPerformanceAsofDiffFromCurrentDate) {
        this.minPerformanceAsofDiffFromCurrentDate = minPerformanceAsofDiffFromCurrentDate;
    }
    public int getMaxPerformanceAsofDiffFromCurrentDate() {
        return maxPerformanceAsofDiffFromCurrentDate;
    }
    public void setMaxPerformanceAsofDiffFromCurrentDate(
            int maxPerformanceAsofDiffFromCurrentDate) {
        this.maxPerformanceAsofDiffFromCurrentDate = maxPerformanceAsofDiffFromCurrentDate;
    }
    public int getMinBenchmarkAsofDiffFromCurrentDate() {
        return minBenchmarkAsofDiffFromCurrentDate;
    }
    public void setMinBenchmarkAsofDiffFromCurrentDate(
            int minBenchmarkAsofDiffFromCurrentDate) {
        this.minBenchmarkAsofDiffFromCurrentDate = minBenchmarkAsofDiffFromCurrentDate;
    }
    public int getRtoStarCount() {
        return rtoStarCount;
    }
    public void setRtoStarCount(int rtoStarCount) {
        this.rtoStarCount = rtoStarCount;
    }
    public String getRtoGoalPercentage() {
        return rtoGoalPercentage;
    }
    public void setRtoGoalPercentage(String rtoGoalPercentage) {
        this.rtoGoalPercentage = rtoGoalPercentage;
    }
    public int getRtoFlameCount() {
        return rtoFlameCount;
    }
    public void setRtoFlameCount(int rtoFlameCount) {
        this.rtoFlameCount = rtoFlameCount;
    }

    public Date getResetDate() {
        return resetDate;
    }
    
    public void setResetDate(Date resetDate) {
        this.resetDate = resetDate;
    }    
    
    public Date getMinDate() {
        return minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public Date getMaxdate() {
        return maxdate;
    }

    public void setMaxdate(Date maxdate) {
        this.maxdate = maxdate;
    }
}