package com.edifixio.soc.web.dto;

import java.util.Date;
import java.util.List;

import com.edifixio.soc.persist.OutboundMetricsDummy;

public class TwitterCalculatorProfileActionDTO {

    private List<OutboundMetricsDummy> outboundMetricsDummy;
    private Date benchmarkDateFrom;
    private Date benchmarkDateTo;
    public List<OutboundMetricsDummy> getOutboundMetricsDummy() {
        return outboundMetricsDummy;
    }
    public void setOutboundMetricsDummy(
            List<OutboundMetricsDummy> outboundMetricsDummy) {
        this.outboundMetricsDummy = outboundMetricsDummy;
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