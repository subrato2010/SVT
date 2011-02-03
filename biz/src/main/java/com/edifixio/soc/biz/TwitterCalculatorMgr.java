// $Author: subratog $
package com.edifixio.soc.biz;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.edifixio.soc.biz.dto.OverallGradeDTO;
import com.edifixio.soc.biz.dto.OverallSentimentDTO;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.OutboundMetricsDummy;
import com.edifixio.soc.persist.OverallPerformanceDummy;
import com.edifixio.soc.web.dto.TwitterCalculatorChlPerfDTO;

public interface TwitterCalculatorMgr extends BaseMgr{

    TwitterCalculatorChlPerfDTO getChannelPerformance(Date asOfPerformanceDate, String fromProfileUserId, String fromTwitterAccountId, Date benchmarkStDate, Date benchmarkEdDate, String targetId)  throws SVTException ;
    List<OverallPerformanceDummy> getOverallPerformance(String fromProfileUserId,String fromTwitterAccountId, 
            List<OutboundMetricsDummy> outboundMetricsDummy, TwitterCalculatorChlPerfDTO chnlperfdto
            ,Map<String, OverallSentimentDTO> maposDTOs, List<String> sentiments,
            List<OverallGradeDTO> listIn, List<OverallGradeDTO> listOut) throws SVTException;
//    List<OverallPerformanceDummy> getOverallPerformance1(Date asOfPerformanceDate, String fromProfile, Date benchmarkStDate, Date benchmarkEdDate, String target) throws SVTException;
//    List<OutboundMetricsDummy> getOutboundMetrics(Date asOfPerformanceDate, ProfilePreference pdto, String fromTwitterAccountId, Date benchmarkStDate,Date benchmarkEdDate, ImprovementLevel target) throws SVTException ;
//    List<InboundMetricsDummy> getInboundMetrics(Date asOfPerformanceDate, ProfilePreference pdto, String fromTwitterAccountId, Date benchmarkStDate,Date benchmarkEdDate, ImprovementLevel target) throws SVTException;
//    
//    List<SocialIntelligenceMetricsDummy> getEngagementDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;
//    List<SocialIntelligenceMetricsDummy> getReachDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;
//    List<SocialIntelligenceMetricsDummy> getLoyaltyDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;
//    List<SocialIntelligenceMetricsDummy> getDemographicsDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;
//    List<SocialIntelligenceMetricsDummy> getRetentionDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;
//    List<SocialIntelligenceMetricsDummy> getInfluenceDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;
//    List<SocialIntelligenceMetricsDummy> getSentimentDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException;

    List<TwitterAccountDTO> getTwitterAccount(String asOfPerformanceDate, String fromProfile, String benchmarkStDate, String benchmarkEdDate, String target) throws SVTException;
        
}
