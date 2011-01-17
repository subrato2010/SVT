// $Author: subratog $
package com.edifixio.soc.biz;


import java.util.Date;
import java.util.List;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.InboundMetricsDummy;
import com.edifixio.soc.persist.OutboundMetricsDummy;
import com.edifixio.soc.persist.OverallPerformanceDummy;
import com.edifixio.soc.persist.SocialIntelligenceMetricsDummy;
import com.edifixio.soc.web.dto.TwitterCalculatorChlPerfDTO;

public interface TwitterCalculatorMgr extends BaseMgr{

    TwitterCalculatorChlPerfDTO getChannelPerformance(Date asOfPerformanceDate, String fromProfile, Date benchmarkStDate, Date benchmarkEdDate, String target)  throws SVTException ;
    
    List<OverallPerformanceDummy> getOverallPerformance(Date asOfPerformanceDate, String fromProfile, Date benchmarkStDate, Date benchmarkEdDate, String target) throws SVTException;
    List<OutboundMetricsDummy> getOutboundMetrics(Date asOfPerformanceDate, String fromProfile, Date benchmarkStDate, Date benchmarkEdDate, String target) throws SVTException ;
    List<InboundMetricsDummy> getInboundMetrics(Date asOfPerformanceDate, String fromProfile, Date benchmarkStDate, Date benchmarkEdDate, String target) throws SVTException;
    
    List<SocialIntelligenceMetricsDummy> getEngagementDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getReachDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getLoyaltyDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getDemographicsDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getRetentionDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getInfluenceDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getSentimentDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;

    List<TwitterAccountDTO> getTwitterAccount(String asOfPerformanceDate, String fromProfile, String benchmarkStDate, String benchmarkEdDate, String target) throws SVTException;
        
}
