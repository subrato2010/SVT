package com.edifixio.soc.web.dto;

import java.util.List;

public class ChannelPerformanceDTO {
    
    private List<ListItemDTO> profile;
    private OverallPerformanceDTO overallPerfCustomer;
    private OverallPerformanceDTO overallPerfCmpt;
    
    private List<OutboundMetricsDTO> outboundMetrics;
    private List<InboundMetricsDTO> inboundMetrics;
    
    private List<SocialIntellignceMetricsDTO> engagement;
    private List<SocialIntellignceMetricsDTO> reach;
    private List<SocialIntellignceMetricsDTO> loyalty;
    private List<SocialIntellignceMetricsDTO> demographics;
    private List<SocialIntellignceMetricsDTO> retention;
    private List<SocialIntellignceMetricsDTO> influence;
    private List<SocialIntellignceMetricsDTO> sentiment;
    
    public List<SocialIntellignceMetricsDTO> getDemographics() {
        return demographics;
    }
    public void setDemographics(List<SocialIntellignceMetricsDTO> demographics) {
        this.demographics = demographics;
    }
    public List<SocialIntellignceMetricsDTO> getEngagement() {
        return engagement;
    }
    public void setEngagement(List<SocialIntellignceMetricsDTO> engagement) {
        this.engagement = engagement;
    }
    public List<InboundMetricsDTO> getInboundMetrics() {
        return inboundMetrics;
    }
    public void setInboundMetrics(List<InboundMetricsDTO> inboundMetrics) {
        this.inboundMetrics = inboundMetrics;
    }
    public List<SocialIntellignceMetricsDTO> getInfluence() {
        return influence;
    }
    public void setInfluence(List<SocialIntellignceMetricsDTO> influence) {
        this.influence = influence;
    }
    public List<SocialIntellignceMetricsDTO> getLoyalty() {
        return loyalty;
    }
    public void setLoyalty(List<SocialIntellignceMetricsDTO> loyalty) {
        this.loyalty = loyalty;
    }
    public List<OutboundMetricsDTO> getOutboundMetrics() {
        return outboundMetrics;
    }
    public void setOutboundMetrics(List<OutboundMetricsDTO> outboundMetrics) {
        this.outboundMetrics = outboundMetrics;
    }
    public OverallPerformanceDTO getOverallPerfCmpt() {
        return overallPerfCmpt;
    }
    public void setOverallPerfCmpt(OverallPerformanceDTO overallPerfCmpt) {
        this.overallPerfCmpt = overallPerfCmpt;
    }
    public OverallPerformanceDTO getOverallPerfCustomer() {
        return overallPerfCustomer;
    }
    public void setOverallPerfCustomer(OverallPerformanceDTO overallPerfCustomer) {
        this.overallPerfCustomer = overallPerfCustomer;
    }
    public List<ListItemDTO> getProfile() {
        return profile;
    }
    public void setProfile(List<ListItemDTO> profile) {
        this.profile = profile;
    }
    public List<SocialIntellignceMetricsDTO> getReach() {
        return reach;
    }
    public void setReach(List<SocialIntellignceMetricsDTO> reach) {
        this.reach = reach;
    }
    public List<SocialIntellignceMetricsDTO> getRetention() {
        return retention;
    }
    public void setRetention(List<SocialIntellignceMetricsDTO> retention) {
        this.retention = retention;
    }
    public List<SocialIntellignceMetricsDTO> getSentiment() {
        return sentiment;
    }
    public void setSentiment(List<SocialIntellignceMetricsDTO> sentiment) {
        this.sentiment = sentiment;
    }
    
    
}