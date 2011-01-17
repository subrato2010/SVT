package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.InboundMetricsDummy;
import com.edifixio.soc.persist.Metrics;
import com.edifixio.soc.persist.OutboundMetricsDummy;
import com.edifixio.soc.persist.OverallPerformanceDummy;
import com.edifixio.soc.persist.ProfilePreference;
import com.edifixio.soc.persist.RawResult;
import com.edifixio.soc.persist.SocialIntelligenceMetricsDummy;
import com.edifixio.soc.web.dto.TwitterCalculatorChlPerfDTO;

public class TwitterCalculatorMgrImpl extends BaseBizObject implements TwitterCalculatorMgr {

    private static Log log = LogFactory.getLog(TwitterCalculatorMgrImpl.class);

    public TwitterCalculatorChlPerfDTO getChannelPerformance(Date asOfPerformanceDate, String fromProfile, Date benchmarkStDate, Date benchmarkEdDate, String targetId) throws SVTException {
        TwitterCalculatorChlPerfDTO dto = new TwitterCalculatorChlPerfDTO();

        dto.setOutboundMetricsDummy(getOutboundMetrics(asOfPerformanceDate,fromProfile,benchmarkStDate,benchmarkEdDate,targetId));
        dto.setInboundMetricsDummy(getInboundMetrics(asOfPerformanceDate,fromProfile,benchmarkStDate,benchmarkEdDate,targetId));        
        dto.setEngagementDummy(getEngagementDummy(dto.getInboundMetricsDummy()));
        dto.setReachDummy(getReachDummy(dto.getInboundMetricsDummy()));
        dto.setLoyaltyDummy(getLoyaltyDummy(dto.getInboundMetricsDummy()));
        dto.setDemographicsDummy(getDemographicsDummy(dto.getInboundMetricsDummy()));
        dto.setRetentionDummy(getRetentionDummy(dto.getInboundMetricsDummy()));
        dto.setInfluenceDummy(getInfluenceDummy(dto.getInboundMetricsDummy()));
        dto.setSentimentDummy(getSentimentDummy(dto.getInboundMetricsDummy()));
        dto.setOverallPerformanceDummy(getOverallPerformance(fromProfile, dto.getOutboundMetricsDummy(),dto));
        return dto;
    }

    private List<OverallPerformanceDummy> getOverallPerformance(String fromProfile, List<OutboundMetricsDummy> outboundMetricsDummy, TwitterCalculatorChlPerfDTO chnlperfdto) {

        //TODO: will have to use outbound and inbound metrics data to compute overall data
        List<OverallPerformanceDummy> dtos = new ArrayList<OverallPerformanceDummy>();
        
        // first Row - Your Grade
        OverallPerformanceDummy dto = new OverallPerformanceDummy();
        dto.setCustomer(true);
        dto.setOverallGrade("C+");
        dto.setSentimentGrade("B");
        dto.setEngagementGrade("C+");
        dto.setRetentionGrade("B");        
        dto.setDemographicsGrade("C+");
        dto.setLoyaltyGrade("C");
        dto.setInfluenceGrade("C+");
        dto.setReachGrade("C+");        
        dto.setProfileId(fromProfile);
        dtos.add(dto);
        
        // 2nd Row - Competitor Grade
        dto = new OverallPerformanceDummy();
        dto.setCustomer(false);
        dto.setOverallGrade("B");
        dto.setSentimentGrade("B-");
        dto.setEngagementGrade("B-");
        dto.setRetentionGrade("B+");        
        dto.setDemographicsGrade("B+");
        dto.setLoyaltyGrade("C+");
        dto.setInfluenceGrade("B");
        dto.setReachGrade("A-");        
        dto.setProfileId(fromProfile);
        dtos.add(dto);
        return dtos;
    }

    public List<OverallPerformanceDummy> getOverallPerformance(Date asOfPerformanceDate, String fromProfile, Date benchmarkStDate, Date benchmarkEdDate, String targetId) throws SVTException {
        return getDaoProvider().getOverallPerformanceDummyDAO().getByProfileId(fromProfile);        
    }

    public List<OutboundMetricsDummy> getOutboundMetrics(Date asOfPerformanceDate, String fromProfile, Date benchmarkStDate, 
            Date benchmarkEdDate, String target) throws SVTException {
        ProfilePreference pdto = getProfilePreferenceDAO().getByProfileUserId(fromProfile); 
        List<OutboundMetricsDummy> dtos = new ArrayList<OutboundMetricsDummy>();
        
        // get all outbound metrics
        List<Metrics> metricsDTO = getDaoProvider().getMetricsDAO().findCategoryByChannelIdOutbound(TWITTERCHANNEL);
        for(Metrics mdto: metricsDTO){
            OutboundMetricsDummy dto = new OutboundMetricsDummy();
            dto.setMetricsName(mdto.getMetricName());
            dto.setMetricsDesc(mdto.getMetricDesc());
            dto.setActiveStatus(mdto.isActiveStatus());
            dto.setCategoryId(mdto.getCategory().getCategoryId());

            setOutboundVolume(dto,mdto,pdto, asOfPerformanceDate, fromProfile, benchmarkStDate,benchmarkEdDate, target);
            /**
             * Calculation logic required
             * dto.setCustVolume();
             * dto.setCmptVolume();
             * dto.setCustTarget(); // this can be Moderate, aggressive, vaggressive (depends on what user is passing in the variable target)
             * dto.setPercentIncrease();
             * dto.setAlertFlameCount();
             * dto.setAlertStarCount();
             * dto.setAlertMessage();
             * 
             */
            dtos.add(dto);
        }
        
        return dtos;
    }    

    public List<InboundMetricsDummy> getInboundMetrics(Date asOfPerformanceDate, String fromProfile, Date benchmarkStDate, Date benchmarkEdDate, String target) throws SVTException {
        List<InboundMetricsDummy> dtos = new ArrayList<InboundMetricsDummy>();
        ProfilePreference pdto = getProfilePreferenceDAO().getByProfileUserId(fromProfile);
        
        // get all inbound metrics
        List<Metrics> metricsDTO = getDaoProvider().getMetricsDAO().findCategoryByChannelIdInbound(TWITTERCHANNEL);
        for(Metrics mdto: metricsDTO){
            InboundMetricsDummy dto = new InboundMetricsDummy();
            dto.setMetricsName(mdto.getMetricName());
            dto.setMetricsDesc(mdto.getMetricDesc());
            //dto.setActiveStatus(mdto.isActiveStatus());
            dto.setCategoryId(mdto.getCategory().getCategoryId());
            
            setInboundVolume(dto,mdto,pdto, asOfPerformanceDate, fromProfile, benchmarkStDate,benchmarkEdDate, target);
            /**
             * Calculation logic required
             * dto.setCustVolume();
             * dto.setCmptVolume();
             * dto.setCustTarget(); // this can be Moderate, aggressive, vaggressive (depends on what user is passing in the variable target)
             * dto.setPercentIncrease();
             */
            dtos.add(dto);
        }
        
        return dtos;
    }

    private void setOutboundVolume(OutboundMetricsDummy dto, Metrics mdto,ProfilePreference pdto, Date asOfPerformanceDate, 
            String fromProfile, Date benchmarkStDate,Date benchmarkEdDate, String target) throws SVTException {
//        System.out.println("ProfileId: " + pdto.getProfilePrefrenceId());
//        System.out.println("AsOfDate : " + asOfPerformanceDate);
//        System.out.println("metricId : " + mdto.getMetricId());
//        System.out.println("MetricCode: " + mdto.getMetricCode());

        dto.setCustVolume("");
        dto.setCmptVolume("");
        if(mdto.getMetricCode().equals("1") ||
           mdto.getMetricCode().equals("2") ||
           mdto.getMetricCode().equals("3") ||
           mdto.getMetricCode().equals("4") ||
           mdto.getMetricCode().equals("5") ||
           mdto.getMetricCode().equals("10") ||
           mdto.getMetricCode().equals("11") ||
           mdto.getMetricCode().equals("12") ||
           mdto.getMetricCode().equals("14") ||
            mdto.getMetricCode().equals("15") ||
            mdto.getMetricCode().equals("17") ||
            mdto.getMetricCode().equals("24") ||
            mdto.getMetricCode().equals("25") ||
            mdto.getMetricCode().equals("26") ||
            mdto.getMetricCode().equals("27") ||
            mdto.getMetricCode().equals("28") ||
            mdto.getMetricCode().equals("29") ||
            mdto.getMetricCode().equals("30") ||
            mdto.getMetricCode().equals("31") ||
            mdto.getMetricCode().equals("32") ||
            mdto.getMetricCode().equals("33") ||
            mdto.getMetricCode().equals("34") ||
            mdto.getMetricCode().equals("35") ||
            mdto.getMetricCode().equals("36") ||
            mdto.getMetricCode().equals("37") ||
            mdto.getMetricCode().equals("39") ||
            mdto.getMetricCode().equals("40") ||
            mdto.getMetricCode().equals("41") ||
            mdto.getMetricCode().equals("42") ||
            mdto.getMetricCode().equals("43")
        ){
          
            double totalDataCount=0;
            double totalRawScore=0;

            List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(),mdto.getMetricId(), asOfPerformanceDate);
            List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(pdto.getProfilePrefrenceId(),mdto.getMetricId(), asOfPerformanceDate);
            for(RawResult rr: selfDtos){
                if(rr.getRawScore()>=0){
                    totalRawScore+=rr.getRawScore();
                    totalDataCount+=rr.getTotalDataCount();
                }
            }
            //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Customer Volume: " + (totalRawScore/totalDataCount)*100.00);
            dto.setCustVolume("0");
            if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00))){
                dto.setCustVolume(getDoubleFormatedAsString(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00)));
            }
            totalDataCount=0;
            totalRawScore=0;
            for(RawResult rr: cmptDtos){
                if(rr.getRawScore()>=0){
                    totalRawScore+=rr.getRawScore();
                    totalDataCount+=rr.getTotalDataCount();
                }
            }
            //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Cmpt Volume: " + (totalRawScore/totalDataCount)*100);
            dto.setCmptVolume("0");
            if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00))){
                dto.setCmptVolume(getDoubleFormatedAsString(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00)));
            }
        }
        else if(mdto.getMetricCode().equals("6") ||
                mdto.getMetricCode().equals("7") ||
                mdto.getMetricCode().equals("8") ||
                mdto.getMetricCode().equals("4") ||
                mdto.getMetricCode().equals("13") ||
                mdto.getMetricCode().equals("18") ||
                mdto.getMetricCode().equals("19") ||
                mdto.getMetricCode().equals("23") ||
                mdto.getMetricCode().equals("38")
             ){
               
                 double totalDataCount=0;
                 double totalRawScore=0;

                 List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(),mdto.getMetricId(), asOfPerformanceDate);
                 List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(pdto.getProfilePrefrenceId(),mdto.getMetricId(), asOfPerformanceDate);
                 for(RawResult rr: selfDtos){
                     if(rr.getRawScore()>=0){
                         totalRawScore+=rr.getRawScore();
                         totalDataCount+=rr.getTotalDataCount();
                     }
                 }
                 //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Customer Volume: " + (totalRawScore/totalDataCount));
                 dto.setCustVolume("0");
                 if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)))){
                     dto.setCustVolume(getDoubleFormatedAsString(getDoubleNumber2Decimal((totalRawScore/totalDataCount))));
                 }
                 totalDataCount=0;
                 totalRawScore=0;
                 for(RawResult rr: cmptDtos){
                     if(rr.getRawScore()>=0){
                         totalRawScore+=rr.getRawScore();
                         totalDataCount+=rr.getTotalDataCount();
                     }
                 }
                 //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Cmpt Volume: " + (totalRawScore/totalDataCount));
                 dto.setCmptVolume("0");
                 if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)))){
                     dto.setCmptVolume(getDoubleFormatedAsString(getDoubleNumber2Decimal((totalRawScore/totalDataCount))));
                 }
             }
            else if(mdto.getMetricCode().equals("20") ||
                     mdto.getMetricCode().equals("21")
                  ){

                  }
    }  
    private void setInboundVolume(InboundMetricsDummy dto, Metrics mdto,ProfilePreference pdto, Date asOfPerformanceDate, 
            String fromProfile, Date benchmarkStDate,Date benchmarkEdDate, String target) throws SVTException {
//        System.out.println("ProfileId: " + pdto.getProfilePrefrenceId());
//        System.out.println("AsOfDate : " + asOfPerformanceDate);
//        System.out.println("metricId : " + mdto.getMetricId());
//        System.out.println("MetricCode: " + mdto.getMetricCode());

        dto.setCustVolume("");
        dto.setCmptVolume("");
        if(mdto.getMetricCode().equals("44") ||
           mdto.getMetricCode().equals("49") ||
           mdto.getMetricCode().equals("54") ||
           mdto.getMetricCode().equals("55") ||
           mdto.getMetricCode().equals("56") ||
           mdto.getMetricCode().equals("57") ||
           mdto.getMetricCode().equals("58") ||
           mdto.getMetricCode().equals("60") ||
           mdto.getMetricCode().equals("62") ||
            mdto.getMetricCode().equals("66")||
            mdto.getMetricCode().equals("74")
        ){
          
            double totalDataCount=0;
            double totalRawScore=0;

            List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(),mdto.getMetricId(), asOfPerformanceDate);
            List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(pdto.getProfilePrefrenceId(),mdto.getMetricId(), asOfPerformanceDate);
            for(RawResult rr: selfDtos){
                if(rr.getRawScore()>=0){
                    totalRawScore+=rr.getRawScore();
                    totalDataCount+=rr.getTotalDataCount();
                }
            }
            //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Customer Volume: " + (totalRawScore/totalDataCount)*100.00);
            dto.setCustVolume("0");
            if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00))){
                dto.setCustVolume(getDoubleFormatedAsString(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00)));
            }
            totalDataCount=0;
            totalRawScore=0;
            for(RawResult rr: cmptDtos){
                if(rr.getRawScore()>=0){
                    totalRawScore+=rr.getRawScore();
                    totalDataCount+=rr.getTotalDataCount();
                }
            }
            //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Cmpt Volume: " + (totalRawScore/totalDataCount)*100);
            dto.setCmptVolume("0");
            if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00))){
                dto.setCmptVolume(getDoubleFormatedAsString(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00)));
            }
        }
        else if(mdto.getMetricCode().equals("64") // Average
             ){
               
                 double totalDataCount=0;
                 double totalRawScore=0;

                 List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(),mdto.getMetricId(), asOfPerformanceDate);
                 List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(pdto.getProfilePrefrenceId(),mdto.getMetricId(), asOfPerformanceDate);
                 for(RawResult rr: selfDtos){
                     if(rr.getRawScore()>=0){
                         totalRawScore+=rr.getRawScore();
                         totalDataCount+=rr.getTotalDataCount();
                     }
                 }
                 //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Customer Volume: " + (totalRawScore/totalDataCount));
                 dto.setCustVolume("0");
                 if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)))){
                     dto.setCustVolume(getDoubleFormatedAsString(getDoubleNumber2Decimal((totalRawScore/totalDataCount))));
                 }
                 totalDataCount=0;
                 totalRawScore=0;
                 for(RawResult rr: cmptDtos){
                     if(rr.getRawScore()>=0){
                         totalRawScore+=rr.getRawScore();
                         totalDataCount+=rr.getTotalDataCount();
                     }
                 }
                 //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Cmpt Volume: " + (totalRawScore/totalDataCount));
                 dto.setCmptVolume("0");
                 if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)))){
                     dto.setCmptVolume(getDoubleFormatedAsString(getDoubleNumber2Decimal((totalRawScore/totalDataCount))));
                 }
             }
            else if(mdto.getMetricCode().equals("xx") ||
                     mdto.getMetricCode().equals("xx")
                  ){

                  }
    }
    public List<SocialIntelligenceMetricsDummy> getDemographicsDummy(List<InboundMetricsDummy> inboundMetrics)  throws SVTException{
        
        return getSocialIntelligenceMetricsList(inboundMetrics, getCategoryId(DEMOGRAPHICS, TWITTERCHANNEL));
    }

    public List<SocialIntelligenceMetricsDummy> getEngagementDummy(List<InboundMetricsDummy> inboundMetrics)  throws SVTException{
        return getSocialIntelligenceMetricsList(inboundMetrics, getCategoryId(ENGAGEMENT, TWITTERCHANNEL));
    }


    public List<SocialIntelligenceMetricsDummy> getInfluenceDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException {
        return getSocialIntelligenceMetricsList(inboundMetrics, getCategoryId(INFLUENCE, TWITTERCHANNEL));
    }

    public List<SocialIntelligenceMetricsDummy> getLoyaltyDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException {
        return getSocialIntelligenceMetricsList(inboundMetrics, getCategoryId(LOYALTY, TWITTERCHANNEL));
    }

    public List<SocialIntelligenceMetricsDummy> getReachDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException {
        return getSocialIntelligenceMetricsList(inboundMetrics, getCategoryId(REACH, TWITTERCHANNEL));
    }

    public List<SocialIntelligenceMetricsDummy> getRetentionDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException {
        return getSocialIntelligenceMetricsList(inboundMetrics, getCategoryId(RETENTION, TWITTERCHANNEL));
    }

    public List<SocialIntelligenceMetricsDummy> getSentimentDummy(List<InboundMetricsDummy> inboundMetrics) throws SVTException {
        return getSocialIntelligenceMetricsList(inboundMetrics, getCategoryId(SENTIMENT, TWITTERCHANNEL));
    }

    public List<TwitterAccountDTO> getTwitterAccount(String asOfPerformanceDate, String fromProfile, String benchmarkStDate, String benchmarkEdDate, String target) throws SVTException {
        // TODO Auto-generated method stub
        return null;
    }

    private List<SocialIntelligenceMetricsDummy> getSocialIntelligenceMetricsList(List<InboundMetricsDummy> inboundMetrics, String categoryId) {
        List<SocialIntelligenceMetricsDummy> dtos = new ArrayList<SocialIntelligenceMetricsDummy>();
        for(InboundMetricsDummy inDto: inboundMetrics){
            if(inDto.getCategoryId().equalsIgnoreCase(categoryId)){
                SocialIntelligenceMetricsDummy dto = new SocialIntelligenceMetricsDummy();
                quietlyCopyProperties(dto, inDto);
                dtos.add(dto);
            }
        }
        return dtos;
    }
    private String getCategoryId(String categoryName, String channelId) throws SVTException {
        return getDaoProvider().getCategoryDAO().getByNameChannelId(categoryName, channelId).getCategoryId();
    }


}
