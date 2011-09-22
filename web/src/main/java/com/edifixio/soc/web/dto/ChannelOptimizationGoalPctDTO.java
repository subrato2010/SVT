package com.edifixio.soc.web.dto;

import java.util.List;

import com.edifixio.soc.biz.dto.ChannelOptGoalPctMetricsDTO;

public class ChannelOptimizationGoalPctDTO {

    private String totalEngagementGrade;
    private double totalEngagement;
    private List<ChannelOptGoalPctMetricsDTO> goalPctMetrics;
    public String getTotalEngagementGrade() {
        return totalEngagementGrade;
    }
    public void setTotalEngagementGrade(String totalEngagementGrade) {
        this.totalEngagementGrade = totalEngagementGrade;
    }
    public double getTotalEngagement() {
        return totalEngagement;
    }
    public void setTotalEngagement(double totalEngagement) {
        this.totalEngagement = totalEngagement;
    }
    public List<ChannelOptGoalPctMetricsDTO> getGoalPctMetrics() {
        return goalPctMetrics;
    }
    public void setGoalPctMetrics(List<ChannelOptGoalPctMetricsDTO> goalPctMetrics) {
        this.goalPctMetrics = goalPctMetrics;
    }

}