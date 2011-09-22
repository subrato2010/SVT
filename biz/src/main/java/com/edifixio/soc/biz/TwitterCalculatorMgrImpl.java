package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;

import com.edifixio.soc.biz.dto.AlertPopupDTO;
import com.edifixio.soc.biz.dto.CachedChannelOptimizationGoalPctDTO;
import com.edifixio.soc.biz.dto.CachedChannelPerformanceDTO;
import com.edifixio.soc.biz.dto.CachedOutboundDTO;
import com.edifixio.soc.biz.dto.ChannelOptGoalPctMetricsDTO;
import com.edifixio.soc.biz.dto.OverallGradeDTO;
import com.edifixio.soc.biz.dto.OverallSentimentDTO;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.biz.util.DateUtil;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Benchmark;
import com.edifixio.soc.persist.GradeMaster;
import com.edifixio.soc.persist.ImprovementLevel;
import com.edifixio.soc.persist.InboundMetricsDummy;
import com.edifixio.soc.persist.Metrics;
import com.edifixio.soc.persist.OutboundMetricsDummy;
import com.edifixio.soc.persist.OverallPerformanceDummy;
import com.edifixio.soc.persist.ProfilePreference;
import com.edifixio.soc.persist.RTOPSchedule;
import com.edifixio.soc.persist.RawResult;
import com.edifixio.soc.persist.SocialIntelligenceMetricsDummy;
import com.edifixio.soc.persist.TrendingGrade;
import com.edifixio.soc.web.dto.ChannelOptimizationGoalPctDTO;
import com.edifixio.soc.web.dto.TrendingGraphDTO;
import com.edifixio.soc.web.dto.TrendingGraphDetailDTO;
import com.edifixio.soc.web.dto.TwitterCalculatorChannelPerformanceProfileActionDTO;
import com.edifixio.soc.web.dto.TwitterCalculatorChlPerfDTO;
import com.edifixio.soc.web.dto.TwitterCalculatorProfileActionDTO;

public class TwitterCalculatorMgrImpl extends BaseBizObject implements TwitterCalculatorMgr {

    private static final String AGGRESSIVE = "AGGRESSIVE";
    private static final String VERY_AGGRESSIVE = "VERY AGGRESSIVE";
    private static final String MODERATE = "MODERATE";
    private static Log log = LogFactory.getLog(TwitterCalculatorMgrImpl.class);
//    // Create file 
//    FileWriter fstream;
//    FileWriter fstream1;
//    FileWriter fstream2;
//    FileWriter fstream3;
//    BufferedWriter out;
//    BufferedWriter out1;
//    BufferedWriter out2;
//    BufferedWriter out3;
    
    /**
     * Mode: Daily/Weekly/Monthly (1/2/3)
     */
    public List<TrendingGraphDTO> getTrendingGraph(String categoryId, String mode, Date asOfPerformanceDate, String fromProfileUserId, 
            String fromTwitterAccountId, Date benchmarkStDate, Date benchmarkEdDate, String targetId) throws SVTException {
        
        List<TrendingGraphDTO> trendingGraphDtos = new ArrayList<TrendingGraphDTO>();
        
//        System.out.println("CategoryId              : " + categoryId);
//        System.out.println("Model                   : " + mode);
//        System.out.println("asOfPerformanceDate     : " + asOfPerformanceDate);
//        System.out.println("fromProfileUserId       : " + fromProfileUserId);
//        System.out.println("fromTwitterAccountId    : " + fromTwitterAccountId);
//        System.out.println("benchmarkStDate         : " + benchmarkStDate);
//        System.out.println("benchmarkEdDate         : " + benchmarkEdDate);
//        System.out.println("targetId                : " + targetId);
        
        TwitterCalculatorChlPerfDTO dto = new TwitterCalculatorChlPerfDTO();
        ImprovementLevel target=null;
        if(targetId != null){
            target = getDaoProvider().getImprovementLevelDAO().getById(targetId);
        }
        ProfilePreference pdto = getProfilePreferenceDAO().getByProfileUserId(fromProfileUserId);     
        int totalHandler = getHandlerCount(fromTwitterAccountId, pdto); 
        dto.setBenchmarkDateFrom(pdto.getBenchmark().getBenchmarkStDate());
        dto.setBenchmarkDateTo(pdto.getBenchmark().getBenchmarkEdDate());

        Map<String, OverallSentimentDTO> maposDTOs = new HashMap<String, OverallSentimentDTO>();
        List<String> sentiments = new ArrayList<String>();
        List<OverallGradeDTO> listIn = new ArrayList<OverallGradeDTO>();
        List<OverallGradeDTO> listOut = new ArrayList<OverallGradeDTO>();

        System.out.println("Graph Before DB call Start : " + getCurrentDate());
          
        // Fetching the data of last 4 days ( one by one ), needs to be displayed on the UI (Graph)
        for(int x=0; x < 4; x++){
            Date asOfPerformanceDate1 = getDate(asOfPerformanceDate,x, mode);
            dto.setOutboundMetricsDummy(getOutboundMetrics(asOfPerformanceDate1,pdto, fromTwitterAccountId,benchmarkStDate,benchmarkEdDate,target, listOut, totalHandler));
            dto.setInboundMetricsDummy(getInboundMetrics(asOfPerformanceDate1,pdto, fromTwitterAccountId,benchmarkStDate,benchmarkEdDate,target, maposDTOs,sentiments,listIn, totalHandler ));        
            dto.setOverallPerformanceDummy(getOverallPerformance(fromProfileUserId, fromTwitterAccountId, dto.getOutboundMetricsDummy(),dto,maposDTOs,sentiments,listIn,listOut));
            
            //System.out.println("AS OF DATE: " + asOfPerformanceDate1);
            for(OverallPerformanceDummy d : dto.getOverallPerformanceDummy()){
                TrendingGraphDTO trendingGraphDto = new TrendingGraphDTO();
                trendingGraphDto.setMode(mode);
                trendingGraphDto.setAsOfPerformanceDate(asOfPerformanceDate1);
                trendingGraphDto.setSelf(d.isCustomer());
                
                TrendingGraphDetailDTO detailDto = new TrendingGraphDetailDTO();
                detailDto.setCustomer(d.isCustomer());
                detailDto.setOverallGrade(d.getOverallGrade());
                detailDto.setSentimentGrade(d.getSentimentGrade());
                detailDto.setEngagementGrade(d.getEngagementGrade());
                detailDto.setRetentionGrade(d.getRetentionGrade());
                detailDto.setDemographicsGrade(d.getDemographicsGrade());
                detailDto.setLoyaltyGrade(d.getLoyaltyGrade());
                detailDto.setInfluenceGrade(d.getInfluenceGrade());
                detailDto.setReachGrade(d.getReachGrade());

                trendingGraphDto.setGradeDetail(detailDto);
                trendingGraphDtos.add(trendingGraphDto);
            }            
        }
        
        System.out.println("Graph Before DB call End : " + getCurrentDate());
        return trendingGraphDtos;
    }
    
 
    /**
     * This method will give the list of all outbound profile alerts( used in TwitterOptimizer Screen)
     */
    public TwitterCalculatorProfileActionDTO getProfileActionList(Date asOfPerformanceDate, String fromProfileUserId, String fromTwitterAccountId, 
                                                            Date benchmarkStDate, Date benchmarkEdDate, String targetId) throws SVTException {

//        System.out.println("getPerformanceAsOfDate: [" + asOfPerformanceDate +"]");
//        System.out.println("getCurrentUid:          [" + fromProfileUserId + "]");
//        System.out.println("getBenchmarkDateFrom:   [" + benchmarkStDate + "]");
//        System.out.println("getBenchmarkDateTo:     [" + benchmarkEdDate + "]");

        TwitterCalculatorProfileActionDTO dto = new TwitterCalculatorProfileActionDTO();
        if(fromProfileUserId == null){
            System.out.println("LoginUserId is not passed...");
            return dto;
        }
        
        ImprovementLevel target=null;
        if(targetId != null){
            target = getDaoProvider().getImprovementLevelDAO().getById(targetId);
        }
        ProfilePreference pdto = getProfilePreferenceDAO().getByProfileUserId(fromProfileUserId);
        if(pdto == null){
            System.out.println("Invalid profile passed...");
            return dto;
        }
        int totalHandler = getHandlerCount(fromTwitterAccountId, pdto); 
        dto.setBenchmarkDateFrom(pdto.getBenchmark().getBenchmarkStDate());
        dto.setBenchmarkDateTo(pdto.getBenchmark().getBenchmarkEdDate());

        List<OverallGradeDTO> listOut = new ArrayList<OverallGradeDTO>();
        
        // taking care of npe
        if(asOfPerformanceDate == null){
            asOfPerformanceDate = getMaxActionDate(pdto.getProfilePrefrenceId());
        }
        if(benchmarkStDate == null){
            benchmarkStDate = pdto.getBenchmark().getBenchmarkStDate();  
        }
        if(benchmarkEdDate == null){
            benchmarkEdDate = pdto.getBenchmark().getBenchmarkEdDate();
        }
        
        System.out.println("Before DB call ProfileAction Alert Start : " + getCurrentDate());
        dto.setOutboundMetricsDummy(getOutboundMetricsCached(asOfPerformanceDate,pdto, fromTwitterAccountId,benchmarkStDate,benchmarkEdDate,target, listOut, totalHandler));
        System.out.println("Before DB call ProfileAction Alert   End : " + getCurrentDate());

        List<OutboundMetricsDummy> outdto = new ArrayList<OutboundMetricsDummy>();
        for(OutboundMetricsDummy d : dto.getOutboundMetricsDummy()){
            if(d.getAlertMessage() != null && d.getAlertMessage().length() > 0){
                outdto.add(d);
            }
        }
        dto.setOutboundMetricsDummy(outdto);
        return dto;
    }

    public ChannelOptimizationGoalPctDTO getChannelOptimizationGoalPercentage(
            Date asOfPerformanceDate, 
            String fromProfileUserId, 
            String fromTwitterAccountId, 
            Date benchmarkStDate, 
            Date benchmarkEdDate, 
            String targetId) throws SVTException {
        
        ChannelOptimizationGoalPctDTO dto = new ChannelOptimizationGoalPctDTO();
        log.debug("Before DB call Goal Percentage Start : " + getCurrentDate());
        ProfilePreference pdto = getProfilePreferenceDAO().getByProfileUserId(fromProfileUserId); //TODO 
        dto = getGoalPctMetricsCached(asOfPerformanceDate, pdto, fromTwitterAccountId, benchmarkStDate, benchmarkEdDate, targetId);
        log.debug("Before DB call Goal Percentage End : " + getCurrentDate());
        return dto;
    }    
    
    private ChannelOptimizationGoalPctDTO getGoalPctMetricsCached(Date asOfPerformanceDate,
            ProfilePreference pdto, String fromTwitterAccountId,
            Date benchmarkStDate, Date benchmarkEdDate, String targetId) throws SVTException {
        
        long delayinSeconds = getDaoProvider().getParameterDAO().getDelayInSeconds();
        
        String fromProfileUserId = null;
        if(pdto != null){
            fromProfileUserId = pdto.getProfileUserId(); 
        }
        
        String mapKey = getMapKey(asOfPerformanceDate,
                fromProfileUserId, fromTwitterAccountId,
                benchmarkStDate, benchmarkEdDate, targetId);
        
        CachedChannelOptimizationGoalPctDTO dto = mapChannelOptimizationGoalPctDTO.get(mapKey);
        if(dto != null && ((System.currentTimeMillis() - dto.getDelayPeriod()) < (delayinSeconds *1000) )){
            log.debug("Goal Percentage Cached data........[" + (System.currentTimeMillis() + "-" +  dto.getDelayPeriod()) + "]......................Key["+ mapKey + "]");  
            return dto.getDto();
        }
        
        // getting latest data(delayPeriod expired)
        dto = new CachedChannelOptimizationGoalPctDTO();
        dto.setDelayPeriod(System.currentTimeMillis());
        dto.setDto(getChannelOptimizationGoalPct(asOfPerformanceDate, pdto, fromTwitterAccountId, benchmarkStDate, benchmarkEdDate, targetId));
        
        mapChannelOptimizationGoalPctDTO.put(mapKey, dto);
        return dto.getDto();
    }


    private ChannelOptimizationGoalPctDTO getChannelOptimizationGoalPct(
            Date asOfPerformanceDate, ProfilePreference pdto,
            String fromTwitterAccountId, Date benchmarkStDate,
            Date benchmarkEdDate, String targetId) throws SVTException {
        
        double totalEngagement = 0;
        ChannelOptimizationGoalPctDTO dto = new ChannelOptimizationGoalPctDTO();
        List<ChannelOptGoalPctMetricsDTO> dtos = new ArrayList<ChannelOptGoalPctMetricsDTO>();
        
        // getting only the metrics required for Channel Optimization Goal Percentage        
        List<Metrics> metricsDTO = getDaoProvider().getMetricsDAO().findByGoalPct(TWITTERCHANNEL);
        List<GradeMaster> sentimentGradeList = getDaoProvider().getGradeMasterDAO().findPerformanceFalse();
        
        appendLogRTOGoal("MetricId|MetricName|Day1|Day14|Stage1|Stage2|Stage3|lowerbound|upperbound|goalpctweight|Score0_100");
        for(Metrics mdto: metricsDTO){
            ChannelOptGoalPctMetricsDTO cdto = new ChannelOptGoalPctMetricsDTO();
            cdto.setCalcLogic(mdto.getCalcLogic());
            cdto.setGoalPctCalcLogic(mdto.getGoalPctCalcLogic());
            cdto.setCategoryId(mdto.getCategory().getCategoryId());
            cdto.setGoalMetricWeight(mdto.getGoalMetricWeight());
            cdto.setLowerBound(mdto.getLowerBound());
            cdto.setUpperBound(mdto.getUpperBound());
            cdto.setMetricId(mdto.getMetricId());
            cdto.setMetricName(mdto.getMetricName());
            cdto.setMetricDesc(mdto.getMetricDesc());
            cdto.setDisplayOrder(mdto.getGoalPctDisplayOrder());
            cdto.setOverallCategoryId(mdto.getOverallCategory().getOverallCategoryId());       
            setGoalPctVolume(cdto, asOfPerformanceDate, pdto, fromTwitterAccountId);
            cdto.setScoreUI(""+getDoubleNumber1Decimal(cdto.getScoreScale100()));
            dtos.add(cdto);
            totalEngagement += (cdto.getGoalMetricWeight()*cdto.getScoreScale100());
            log.debug(cdto.getScoreUI());
        }
        
        // UI manages this metrics, so will have to take the values from different way
        ChannelOptGoalPctMetricsDTO cdto = new ChannelOptGoalPctMetricsDTO();
        dtos.add(getScheduleTweetDto(cdto, pdto, asOfPerformanceDate)); //AverageTweet Grade
        totalEngagement += (cdto.getGoalMetricWeight()*cdto.getScoreScale100());
        
        totalEngagement = 100*getNormalizedValueinPCT(totalEngagement, 0, 100, cdto.getMetricId());
        
        dto.setTotalEngagement(totalEngagement);
        dto.setTotalEngagementGrade(getOverallGrade(totalEngagement, sentimentGradeList));
        dto.setGoalPctMetrics(dtos);
        
        appendLogRTOGoal("Total Engagement      : " + totalEngagement);
        appendLogRTOGoal("Total Engagement Grade: " + dto.getTotalEngagementGrade());
        return dto;
    }

    private ChannelOptGoalPctMetricsDTO getScheduleTweetDto(ChannelOptGoalPctMetricsDTO cdto,
            ProfilePreference pdto,Date asOfPerformanceDate) throws SVTException {
        Date day14 = getDateBefore(asOfPerformanceDate, asOfPerformanceDate, -14);
        List<RTOPSchedule> sentTweetDtos = getDaoProvider().getRtopScheduleDAO().getSentTweetsByProfilePrefIdFromDate(pdto.getProfilePrefrenceId(), day14);
        List<TrendingGrade> tgs = getDaoProvider().getTrendingGradeDAO().findall();
        double gradeValue=0;
        int count=0;
        for(RTOPSchedule rs: sentTweetDtos){
            gradeValue += getTrendingGradeValue(rs.getGrade(),tgs);
            count++;
        }
        
        cdto.setMetricName("Average Tweet Grade" + count);
        cdto.setMetricDesc("The average Terametric grade of your tweets.");
        cdto.setDisplayOrder(1);
        cdto.setGoalMetricWeight(0.30);
        count = (count>0)?(count):(1);
        cdto.setScoreScale100(gradeValue/count); 
        cdto.setScoreUI(getTrendingGradeValue((gradeValue/count), tgs));
        appendLogRTOGoal("NA" + "|" + cdto.getMetricName() + "|" + "NA" + "|" + "NA" + "|" + "NA" + "|" + "NA" + "|" + "NA" +  "|" + "0" + "|" + "100" + "|" +  cdto.getGoalMetricWeight() + "|" + cdto.getScoreScale100() );
        return cdto;
    }

    private double getTrendingGradeValue(String grade, List<TrendingGrade> tgs) {
        for(TrendingGrade tg:tgs){
            if(grade.equalsIgnoreCase(tg.getGradeValue())){
                return tg.getFromPctValue();
            }
        }
        return 0;
    }

    private String getTrendingGradeValue(double gradeValue, List<TrendingGrade> tgs) {
        for(TrendingGrade tg:tgs){
            if(gradeValue >= tg.getFromPctValue()){
                return tg.getGradeValue();
            }            
        }
        return "";
    }

    private void setGoalPctVolume(
            ChannelOptGoalPctMetricsDTO cdto,
            Date asOfPerformanceDate,
            ProfilePreference pdto,
            String fromTwitterAccountId) throws SVTException {
        double totalRawScoreSelfDay1=0;
        double totalRawScoreSelfDay14=0;
        double stage1=0;
        double stage2=0;
        double stage3=0;
        double stage4=0;
        
        // Get current Volume (Day 1)
        List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(), fromTwitterAccountId,cdto.getMetricId(), asOfPerformanceDate);
        totalRawScoreSelfDay1= getTotalRawScoreSelf(cdto, selfDtos);
        
        // Get Current - 14Days volume(Day 14)
        Date day14 = getDateBefore(asOfPerformanceDate, asOfPerformanceDate, -14);
        int daysBetween = DateUtil.getTimeAgoDays(day14, asOfPerformanceDate);
        log.debug("MetricName[" + cdto.getMetricName()+ "]Day 1[" + asOfPerformanceDate + "]Day 14[" + day14 + "]Days Between[" + daysBetween+ "]");
        selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(), fromTwitterAccountId,cdto.getMetricId(), day14);        
        totalRawScoreSelfDay14= getTotalRawScoreSelf(cdto, selfDtos);
        
        if(cdto.getGoalPctCalcLogic() == 0){ // no special logic
            cdto.setScoreScale100(getNormalizedValueinPCT(totalRawScoreSelfDay1, cdto.getLowerBound(), cdto.getUpperBound(), cdto.getMetricId()));
            
        }else if(cdto.getGoalPctCalcLogic() == 1){ // 
            stage1 = getDoubleNumberisNANZero((1+ (totalRawScoreSelfDay14-totalRawScoreSelfDay1 )/(totalRawScoreSelfDay1))); //1+(NF14 - NF1) / NF1
            stage2 =  Math.pow(getDoubleNumberisNANZero(stage1), (7/(daysBetween))); //X^(7/num days)
            stage3 = getDoubleNumberisNANZero((100-(getDoubleNumberisNANZero(stage2)-1))); // (100-(L9-1))
            stage4 =  100*getNormalizedValueinPCT(stage3, cdto.getLowerBound(), cdto.getUpperBound(), cdto.getMetricId()); //=100*(MIN(1,MAX(0,(M9-$N9)/($O9-$N9))))
            cdto.setScoreScale100(getDoubleNumberisNANZero(stage4));
            
        }else if(cdto.getGoalPctCalcLogic() == 2){ // 
            stage1 = getDoubleNumberisNANZero(totalRawScoreSelfDay1/totalRawScoreSelfDay14); //day1/day14
            stage4 =  100*getNormalizedValueinPCT(stage1, cdto.getLowerBound(), cdto.getUpperBound(), cdto.getMetricId()); //=100*(MIN(1,MAX(0,(M9-$N9)/($O9-$N9))))
            cdto.setScoreScale100(getDoubleNumberisNANZero(stage4));
        }
        appendLogRTOGoal(cdto.getMetricId() + "|" + cdto.getMetricName() + "|" + totalRawScoreSelfDay1 + "|" + totalRawScoreSelfDay14 + "|" + stage1 + "|" + stage2 + "|" + stage3 +  "|" + cdto.getLowerBound() + "|" + cdto.getUpperBound() + "|" +  cdto.getGoalMetricWeight() + "|" + cdto.getScoreScale100() );
    }

    private double getTotalRawScoreSelf(
            ChannelOptGoalPctMetricsDTO cdto,
            List<RawResult> selfDtos) {
        
        double totalRawScoreSelf=0;
        double totalDataCount=0;
        double totalRawScoreDCSelf=0;        
        for(RawResult rr: selfDtos){
            if(rr.getRawScore()>=0 || rr.getTotalDataCount()>0){
                totalRawScoreSelf+=rr.getRawScore();
                totalDataCount+=rr.getTotalDataCount();
                totalRawScoreDCSelf+=rr.getRawScore()*rr.getTotalDataCount();
            }
        } 

        // This is as per mail dated 7/18 requested by Wendy and nimish subject: Changes
       if(cdto.getCalcLogic() == 1){ // percentage
           if(totalDataCount == 0){
               totalRawScoreSelf =0;
           }else{
               totalRawScoreSelf = (totalRawScoreSelf / totalDataCount)*100;    
           }  
       }else if(cdto.getCalcLogic() == 2){ // (rs*DC)/sum(dc)
           if(totalDataCount == 0){
               totalRawScoreSelf =0;
           }else{
               totalRawScoreSelf = (totalRawScoreDCSelf / totalDataCount);    
           }  
       }
       return totalRawScoreSelf;
    }


    /**
     * please use getChannelOptimizationGoalPercentage instead.
     * @deprecated
     */
    public TwitterCalculatorChlPerfDTO getChannelPerformanceOutbound(Date asOfPerformanceDate, String fromProfileUserId, String fromTwitterAccountId, Date benchmarkStDate, Date benchmarkEdDate, String targetId) throws SVTException {
        TwitterCalculatorChlPerfDTO dto = new TwitterCalculatorChlPerfDTO();
        ImprovementLevel target=null;
        if(targetId != null){
            target = getDaoProvider().getImprovementLevelDAO().getById(targetId);
        }
        ProfilePreference pdto = getProfilePreferenceDAO().getByProfileUserId(fromProfileUserId);     
        int totalHandler = getHandlerCount(fromTwitterAccountId, pdto); 
        dto.setBenchmarkDateFrom(pdto.getBenchmark().getBenchmarkStDate());
        dto.setBenchmarkDateTo(pdto.getBenchmark().getBenchmarkEdDate());

        if(pdto.getBenchmark() != null && benchmarkStDate != null && benchmarkEdDate != null){
            Benchmark bm = pdto.getBenchmark();
            // Check if user changed benchmark Date or not?
            // if changed then needs to persist this info
            if(!(getDateWithZeroTimePart(bm.getBenchmarkStDate()).compareTo(getDateWithZeroTimePart(benchmarkStDate)) == 0) ||
               !(getDateWithZeroTimePart(bm.getBenchmarkEdDate()).compareTo(getDateWithZeroTimePart(benchmarkEdDate)) ==0)){
                System.out.println("User has changed the date so please update the new benchmark...");
                bm.setBenchmarkStDate(benchmarkStDate);
                bm.setBenchmarkEdDate(benchmarkEdDate);
                getDaoProvider().getBenchmarkDAO().update(bm);
                dto.setBenchmarkDateFrom(benchmarkStDate);
                dto.setBenchmarkDateTo(benchmarkEdDate);
            }
        }

        List<OverallGradeDTO> listOut = new ArrayList<OverallGradeDTO>();
        
        System.out.println("Before DB call Outbound Start : " + getCurrentDate());
        dto.setOutboundMetricsDummy(getOutboundMetricsCached(asOfPerformanceDate,pdto, fromTwitterAccountId,benchmarkStDate,benchmarkEdDate,target, listOut, totalHandler));
        System.out.println("Before DB call Outbound End : " + getCurrentDate());

        
        int targetPercentage=0;
        if(target == null){
            target = pdto.getUserProfileDetail().getImprovementLevel();
        }
        targetPercentage=getOnlyNumbers(target.getPctValue());
        
        // Rolling up Overall Outbound Grade ( For RTO Tab )
        System.out.println("Rolling Starts: " + getCurrentDate());
        
        double currentVolumeRolledUp = 0;
        double benchmarkVolumeRolledUp = 0;
        double targetRolledUp = 0;
        
        appendLogRTOGoal("As of PerformanceDate: " + asOfPerformanceDate + "\nBenchmarkStDate:" + benchmarkStDate + "\nBenchmarkEdDate:" + benchmarkEdDate + "\nProfile Handle:" + fromTwitterAccountId);        
        appendLogRTOGoal("MetricId|MetricName|OverallCategoryId|OverallCatModelWt|MetricWt|MetricModelWt(OverallCatModelWt * MetricWt)|userBmk(Scale100)|compBmk(Scale100)|userCurr(Scale100)|compCurr(Scale100)|Current Target|ModelModelWt * userCurr(Scale100)|ModelModelWt * compBmk(Scale100)|ModelModelWt * Current Target|Goal%");

        for(OutboundMetricsDummy d : dto.getOutboundMetricsDummy()){
            double metricModelWt = d.getWeight()*d.getOverallCategoryWt();            
//            double customerTargetScale100 =getCustomerTargetByImprovementLevel(target.getName(),
//                    d.getCmptVolumeScale100(), d.getCalculatedYourVolumeScale100(),
//                    targetPercentage,d.getLowerBound(), d.getUpperBound());
//
//            //System.out.println(d.getMetricId() + " | "+ d.getMetricsName() + " | "+ d.getOverallCategoryWt() + " | " + d.getWeight() + "|" + d.getCustVolumeScale100() + " | " + d.getCalculatedYourVolumeScale100() + " | " + d.getCalculatedCmptVolumeScale100() + " | " + d.getCustTargetActual() + " | " + d.getCustTarget() + "|" + customerTargetScale100);
//            
//            currentVolumeRolledUp +=  d.getCustVolumeScale100() * metricModelWt; // ModelWt=MetricWt*OverallCatWt
//            benchmarkVolumeRolledUp += d.getCalculatedCmptVolumeScale100() * metricModelWt;
//            
//            targetRolledUp += customerTargetScale100 * metricModelWt;
        
            currentVolumeRolledUp +=  d.getYourVolumePCT() * metricModelWt; // ModelWt=MetricWt*OverallCatWt
            benchmarkVolumeRolledUp += d.getCalculatedCmptVolumePCT() * metricModelWt;
            targetRolledUp += d.getCurrentTargetRaw() * metricModelWt;
            
            appendLogRTOGoal(d.getMetricId() + "|"+ d.getMetricsName() + "|"+ d.getOverallCategoryId() + "|" + d.getOverallCategoryWt() + "|" + d.getWeight() + "|" + metricModelWt + "|" + d.getCalculatedYourVolumePCT() + "|" + d.getCalculatedCmptVolumePCT() + "|" + d.getYourVolumePCT() + "|" + d.getCmptVolumePCT() + "|" +  d.getCurrentTargetRaw() + "|" + (d.getYourVolumePCT() * metricModelWt) + "|" + (d.getCalculatedCmptVolumePCT() * metricModelWt) + "|" + (d.getCurrentTargetRaw() * metricModelWt) + "|"+ targetPercentage);
        }

//        System.out.println(" currentVolumeRolledUp: " + currentVolumeRolledUp + " benchmarkVolumeRolledUp: " + benchmarkVolumeRolledUp +
//                " targetRolledUp: " + targetRolledUp);
        
        double rtoRolledUpValue=((currentVolumeRolledUp-benchmarkVolumeRolledUp)/(targetRolledUp-benchmarkVolumeRolledUp))*100;
        if((targetRolledUp-benchmarkVolumeRolledUp) == 0){
            rtoRolledUpValue=0; 
        }


        dto.setRtoGoalPercentage(getInRange(getDoubleNumberisNANZero(getDoubleNumber0Decimal(rtoRolledUpValue))) + "%"); // as per bug list dated 8/30 "WT: Checked with Faiz. Yes, follow the same calculation that provides you with negative and positive with corresponding stars and flames but convert to 0-100 scale."
        
        double tempRtoGoalPercentage = ((currentVolumeRolledUp-benchmarkVolumeRolledUp)/(targetRolledUp-benchmarkVolumeRolledUp));        
        setRtoFlameStarCount(dto, getDoubleNumber0Decimal(tempRtoGoalPercentage));
        System.out.println("GOAL %: " + currentVolumeRolledUp + " : " +  benchmarkVolumeRolledUp + " : " + targetRolledUp + " >> " + dto.getRtoGoalPercentage());
        System.out.println("Rolling Ends: " + getCurrentDate());

        appendLogRTOGoal("|||||||||||" + currentVolumeRolledUp + "|" + benchmarkVolumeRolledUp + "|" + targetRolledUp);
        appendLogRTOGoal("||||||||||Goal%[(currvol-bmkvol)/(target-bmk)]*100|" +  rtoRolledUpValue + "|" + dto.getRtoGoalPercentage() + "|");
        
        return dto;
    }
    
    private void setRtoFlameStarCount(TwitterCalculatorChlPerfDTO dto,
            double value) throws SVTException {
        dto.setRtoStarCount(5); // max value
        dto.setRtoFlameCount(5); // max value
        List<GradeMaster> performanceList = getDaoProvider().getGradeMasterDAO().findPerformanceTrue();
        for(GradeMaster gmdto: performanceList){
            if(value >= gmdto.getPercentValue()){
                dto.setRtoFlameCount(gmdto.getFlameCount());
                dto.setRtoStarCount(gmdto.getStarCount());
                return;
            }
        }        
    }
    
    /**
     * This method is just to check the rollup calculation without UI ( for Customer )
     */
    public List<String> getMetricCalculationReport(Date asOfPerformanceDate, 
            String fromProfileUserId, 
            String fromTwitterAccountId, 
            Date benchmarkStDate, 
            Date benchmarkEdDate, 
            String targetName,
            int reportId)  throws SVTException{
        
        String targetId = "001";
        if(targetName.equalsIgnoreCase(MODERATE)){
            targetId = "001";  
        }else if(targetName.equalsIgnoreCase(AGGRESSIVE)){
            targetId = "002";  
        }if(targetName.equalsIgnoreCase(VERY_AGGRESSIVE)){
            targetId = "003";  
        }
        if(reportId == 0){
            getChannelPerformance(asOfPerformanceDate, 
                    fromProfileUserId, 
                    fromTwitterAccountId, 
                    benchmarkStDate, 
                    benchmarkEdDate, 
                    targetId);            
        }else if(reportId == 1){
//            getChannelPerformanceOutbound(asOfPerformanceDate, 
//                    fromProfileUserId, 
//                    fromTwitterAccountId, 
//                    benchmarkStDate, 
//                    benchmarkEdDate, 
//                    targetId); 
            getChannelOptimizationGoalPercentage(
                    asOfPerformanceDate, 
                    fromProfileUserId, 
                    fromTwitterAccountId, 
                    benchmarkStDate, 
                    benchmarkEdDate, 
                    targetId); 
        
        }
        return getMetricsLogs();
        
    }
    
    
    public TwitterCalculatorChlPerfDTO getChannelPerformance(Date asOfPerformanceDate, String fromProfileUserId, String fromTwitterAccountId, Date benchmarkStDate, Date benchmarkEdDate, String targetId) throws SVTException {
        TwitterCalculatorChlPerfDTO dto = new TwitterCalculatorChlPerfDTO();
        ImprovementLevel target=null;
        if(targetId != null){
            target = getDaoProvider().getImprovementLevelDAO().getById(targetId);
        }
        ProfilePreference pdto = getProfilePreferenceDAO().getByProfileUserId(fromProfileUserId); 
        int totalHandler = getHandlerCount(fromTwitterAccountId, pdto); 
        dto.setBenchmarkDateFrom(pdto.getBenchmark().getBenchmarkStDate());
        dto.setBenchmarkDateTo(pdto.getBenchmark().getBenchmarkEdDate());

        if(pdto.getBenchmark() != null && benchmarkStDate != null && benchmarkEdDate != null){
            Benchmark bm = pdto.getBenchmark();
            // Check if user changed benchmark Date or not?
            // if changed then needs to persist this info
            if(!(getDateWithZeroTimePart(bm.getBenchmarkStDate()).compareTo(getDateWithZeroTimePart(benchmarkStDate)) == 0) ||
               !(getDateWithZeroTimePart(bm.getBenchmarkEdDate()).compareTo(getDateWithZeroTimePart(benchmarkEdDate)) ==0)){
                System.out.println("User has changed the date so please update the new benchmark...");
                bm.setBenchmarkStDate(getDateBefore(benchmarkStDate, benchmarkEdDate, -14)); // startDate = endDate - 14
                bm.setBenchmarkEdDate(benchmarkEdDate);
                getDaoProvider().getBenchmarkDAO().update(bm);
                dto.setBenchmarkDateFrom(benchmarkStDate);
                dto.setBenchmarkDateTo(benchmarkEdDate);
            }
        }

        Map<String, OverallSentimentDTO> maposDTOs = new HashMap<String, OverallSentimentDTO>();
        
        List<String> sentiments = new ArrayList<String>();
        List<OverallGradeDTO> listIn = new ArrayList<OverallGradeDTO>();
        List<OverallGradeDTO> listOut = new ArrayList<OverallGradeDTO>();
        
        // check if available in cache
        long delayinSeconds = getDaoProvider().getParameterDAO().getDelayInSeconds();
        String key = getMapKey(asOfPerformanceDate, fromProfileUserId, fromTwitterAccountId, benchmarkStDate, benchmarkEdDate,targetId);
        CachedChannelPerformanceDTO chdto = mapTwitterCalculatorChlPerfDTO.get(key);
        if(chdto != null && ((System.currentTimeMillis() - chdto.getDelayPeriod()) < (delayinSeconds *1000) )){
            System.out.println("Getting from cached data..................................................................:" + key);
            return chdto.getDto();
        }
        
        System.out.println("Before DB call Start : " + getCurrentDate());
        dto.setOutboundMetricsDummy(getOutboundMetrics(asOfPerformanceDate,pdto, fromTwitterAccountId,benchmarkStDate,benchmarkEdDate,target, listOut, totalHandler));
        dto.setInboundMetricsDummy(getInboundMetrics(asOfPerformanceDate,pdto, fromTwitterAccountId,benchmarkStDate,benchmarkEdDate,target, maposDTOs,sentiments,listIn, totalHandler ));        
        dto.setEngagementDummy(getEngagementDummy(dto.getInboundMetricsDummy()));
        dto.setReachDummy(getReachDummy(dto.getInboundMetricsDummy()));
        dto.setLoyaltyDummy(getLoyaltyDummy(dto.getInboundMetricsDummy()));
        dto.setDemographicsDummy(getDemographicsDummy(dto.getInboundMetricsDummy()));
        dto.setRetentionDummy(getRetentionDummy(dto.getInboundMetricsDummy()));
        dto.setInfluenceDummy(getInfluenceDummy(dto.getInboundMetricsDummy()));
        dto.setSentimentDummy(getSentimentDummy(dto.getInboundMetricsDummy()));
        displayLog("=================== 4 OverallPerformance Start ========================");
        dto.setOverallPerformanceDummy(getOverallPerformance(fromProfileUserId, fromTwitterAccountId, dto.getOutboundMetricsDummy(),dto,maposDTOs,sentiments,listIn,listOut));
        displayLog("=================== 4 OverallPerformance End ========================");
        Date minActionDate = getMinActionDate(pdto.getProfilePrefrenceId()); //TODO
        Date maxActionDate = getMaxActionDate(pdto.getProfilePrefrenceId()); //TODO

        System.out.println("Min Action Date: " + minActionDate);
        System.out.println("Max Action Date: " + maxActionDate);
        System.out.println("After DB call End : " + getCurrentDate());
        int minDays = daysbetweenCurrentDateMin(minActionDate);
        int maxDays = daysbetweenCurrentDateMax(maxActionDate);
        System.out.println("Min Days: " + minDays);
        System.out.println("Max Days: " + maxDays);
        //closeLogToFile();
        dto.setMinPerformanceAsofDiffFromCurrentDate(minDays);
        dto.setMaxPerformanceAsofDiffFromCurrentDate(maxDays);
        
        dto.setResetDate(getResetDate(minActionDate, maxActionDate));
        dto.setMinDate(minActionDate);
        dto.setMaxdate(maxActionDate);
        
        ///////////////////// Caching ///////////////////////////////////////
        chdto = new CachedChannelPerformanceDTO();
        chdto.setDelayPeriod(System.currentTimeMillis());
        chdto.setDto(dto);
        System.out.println("Key generated[" + key + "]");
        mapTwitterCalculatorChlPerfDTO.put(key, chdto); // caching into memory 
        ///////////////////// Caching ///////////////////////////////////////
        
        
        
        
        
        return dto;
    }
    
    private Date getResetDate(Date minDate, Date maxDate) {        
        if(getFormattedDateTime(minDate).plusDays(14).isAfter(getFormattedDateTime(maxDate))) {
            return getFormattedDateTime(maxDate).toDate();
        } else {
            return getFormattedDateTime(minDate).plusDays(14).toDate();
        }
    }
        
    private DateTime getFormattedDateTime(Date _date) {
        DateTime date = new DateTime(_date);
        return new DateTime(date.getYear(), date.getMonthOfYear(), date.getDayOfMonth(), 0, 0, 0, 0);
    }

    private int getHandlerCount(String fromTwitterAccountId,
            ProfilePreference pdto) throws SVTException {
        if(pdto != null && fromTwitterAccountId != null && !fromTwitterAccountId.equalsIgnoreCase("0")){
            return getTwitterAccountDAO().getCountByProfilePreferenceId(pdto.getProfilePrefrenceId());
        }
        return 0;
    }

    public List<OverallPerformanceDummy> getOverallPerformance(String fromProfileUserId,String fromTwitterAccountId, 
            List<OutboundMetricsDummy> outboundMetricsDummy, TwitterCalculatorChlPerfDTO chnlperfdto
            ,Map<String, OverallSentimentDTO> maposDTOs, List<String> sentiments,
            List<OverallGradeDTO> listIn, List<OverallGradeDTO> listOut) throws SVTException {

        List<OverallPerformanceDummy> dtos = new ArrayList<OverallPerformanceDummy>();
        OverallPerformanceDummy dtoself = new OverallPerformanceDummy(); // first Row - Your Grade
        OverallPerformanceDummy dtocmpt = new OverallPerformanceDummy(); // 2nd Row - Competitor Grade
        
        if(sentiments != null && sentiments.size() >0)
        {
            for (String categoryId : sentiments) {
                OverallSentimentDTO dto = maposDTOs.get(categoryId);
                displayLog(" CagetoryId: [" + categoryId + 
                                   "] Self Grade:[" + dto.getSiOverallGradeSELF() +
                                   "] Cmpt Grade:[" + dto.getSiOverallGradeSELF() + "]");

                if(categoryId.equalsIgnoreCase("1")){
                    
                }else if(categoryId.equalsIgnoreCase("2")){
                    
                }else if(categoryId.equalsIgnoreCase("3")){
                    dtoself.setDemographicsGrade(dto.getSiOverallGradeSELF());
                    dtocmpt.setDemographicsGrade(dto.getSiOverallGradeCMPT());
                }else if(categoryId.equalsIgnoreCase("4")){
                    dtoself.setSentimentGrade(dto.getSiOverallGradeSELF());
                    dtocmpt.setSentimentGrade(dto.getSiOverallGradeCMPT());
                }else if(categoryId.equalsIgnoreCase("5")){
                    dtoself.setEngagementGrade(dto.getSiOverallGradeSELF());
                    dtocmpt.setEngagementGrade(dto.getSiOverallGradeCMPT());
                }else if(categoryId.equalsIgnoreCase("6")){
                    dtoself.setInfluenceGrade(dto.getSiOverallGradeSELF());
                    dtocmpt.setInfluenceGrade(dto.getSiOverallGradeCMPT());
                }else if(categoryId.equalsIgnoreCase("7")){
                    dtoself.setLoyaltyGrade(dto.getSiOverallGradeSELF());
                    dtocmpt.setLoyaltyGrade(dto.getSiOverallGradeCMPT());
                }else if(categoryId.equalsIgnoreCase("8")){
                    dtoself.setReachGrade(dto.getSiOverallGradeSELF());
                    dtocmpt.setReachGrade(dto.getSiOverallGradeCMPT());
                }else if(categoryId.equalsIgnoreCase("9")){
                    dtoself.setRetentionGrade(dto.getSiOverallGradeSELF());                    
                    //dtocmpt.setRetentionGrade(dto.getSiOverallGradeCMPT());
                    dtocmpt.setRetentionGrade("NA"); // This is as per mail dated 8/5 request by Wendy subject: Re: QA deployment is done!  
                }
             }
            dtoself.setCustomer(true);
            dtocmpt.setCustomer(false);
            
            // Rolling up Inbound Grade
            displayLog(">>>>>>>>>>Rolling up Inbound Grade<<<<<<<<<<<<");
            double inboundRolledUpSelfValue = 0;
            double inboundRolledUpCmptValue = 0;            
            double totalOverallCatInboundWt = getTotalCatWt(listIn);
            displayLog(" TotalOverallCatInboundWt: " + totalOverallCatInboundWt);
            for(OverallGradeDTO inDTO : listIn){
                inboundRolledUpSelfValue += (inDTO.getYourVolumeScale100()*inDTO.getOverallCategoryWt())/totalOverallCatInboundWt; 
                inboundRolledUpCmptValue += (inDTO.getCmptVolumeScale100()*inDTO.getOverallCategoryWt())/totalOverallCatInboundWt;
                displayLog(" SELF CategoryId: " + inDTO.getOverallCategoryId() + " YourVolumeScale100: " + inDTO.getYourVolumeScale100() +
                        " OverallCatWt: " + inDTO.getOverallCategoryWt());
                displayLog(" CMPT CategoryId: " + inDTO.getOverallCategoryId() + " YourVolumeScale100: " + inDTO.getCmptVolumeScale100() +
                        " OverallCatWt: " + inDTO.getOverallCategoryWt());
            }            

            // Rolling up Outbound Grade
            displayLog(">>>>>>>>>>Rolling up Outbound Grade<<<<<<<<<<<<");
            double outboundRolledUpSelfValue = 0;
            double outboundRolledUpCmptValue = 0;            
            double totalOverallCatOutboundWt = getTotalCatWt(listOut);
            displayLog(" TotalOverallCatOUTboundWt: " + totalOverallCatOutboundWt);
            for(OverallGradeDTO outDTO : listOut){
                outboundRolledUpSelfValue += (outDTO.getYourVolumeScale100()*outDTO.getOverallCategoryWt())/totalOverallCatOutboundWt; 
                outboundRolledUpCmptValue += (outDTO.getCmptVolumeScale100()*outDTO.getOverallCategoryWt())/totalOverallCatOutboundWt;
                displayLog(" SELF CategoryId: " + outDTO.getOverallCategoryId() + " YourVolumeScale100: " + outDTO.getYourVolumeScale100() +
                        " OverallCatWt: " + outDTO.getOverallCategoryWt());
                displayLog(" CMPT CategoryId: " + outDTO.getOverallCategoryId() + " YourVolumeScale100: " + outDTO.getCmptVolumeScale100() +
                        " OverallCatWt: " + outDTO.getOverallCategoryWt());                
            }            
            List<GradeMaster> sentimentGradeList = getDaoProvider().getGradeMasterDAO().findPerformanceFalse();
            dtoself.setOverallGrade(getOverallGrade((inboundRolledUpSelfValue + outboundRolledUpSelfValue)/2, sentimentGradeList)); // inbound 50%, outbound 50%
            dtocmpt.setOverallGrade(getOverallGrade((inboundRolledUpCmptValue + outboundRolledUpCmptValue)/2, sentimentGradeList));  // inbound 50%, outbound 50%
            displayLog(" inboundRolledUpSelfValue: " + inboundRolledUpSelfValue + " outboundRolledUpSelfValue:" + outboundRolledUpSelfValue);
            displayLog(" OverallGradeSELF((inboundRolledUpSelfValue + outboundRolledUpSelfValue)/2): " + dtoself.getOverallGrade());
            displayLog(" OverallGradeCMPT((inboundRolledUpCmptValue + outboundRolledUpCmptValue)/2: " + dtocmpt.getOverallGrade());
            dtos.add(dtoself);
            dtos.add(dtocmpt);
        }
        return dtos;
    }

    public List<OutboundMetricsDummy> getOutboundMetrics(Date asOfPerformanceDate, ProfilePreference pdto, String fromTwitterAccountId, Date benchmarkStDate, 
            Date benchmarkEdDate, ImprovementLevel target,
            List<OverallGradeDTO> listOut, int totalHandler) throws SVTException {
        
        //logToFileNullCheck();
        
        List<OutboundMetricsDummy> dtos = new ArrayList<OutboundMetricsDummy>();
        List<GradeMaster> performanceList = getDaoProvider().getGradeMasterDAO().findPerformanceTrue();
        displayLog("Master Data GradeMaster >>");
        displayLogFile("Master Data GradeMaster >>");
        for(GradeMaster p: performanceList){
            displayLog("PercentageValue: " + p.getPercentValue() + " FlameCount: " + p.getFlameCount() + " StarCount: " + p.getStarCount() );
            displayLogFile("PercentageValue: " + p.getPercentValue() + " FlameCount: " + p.getFlameCount() + " StarCount: " + p.getStarCount() );
        }
        
        //appendLog1("Outbound Metrics Data Loop Start-> BenchmarkStDate:" + benchmarkStDate + " BenchmarkEdDate: " +benchmarkEdDate + " twitterAccountId: " + fromTwitterAccountId);
        appendLogOutbound("As of PerformanceDate: " + asOfPerformanceDate + "\nBenchmarkStDate:" + benchmarkStDate + "\nBenchmarkEdDate:" + benchmarkEdDate + "\nProfile Handle:" + fromTwitterAccountId);        
        appendLogOutbound("MetricId|MetricName|CustomerVolume|CmptVolume|YourBenchmarkVolume|CmptBenchmarkVolume|LowerBound|UpperBound|CustVolScale100|CmptVolScale100|YourBenchmarkVolScale100|BenchmarkCmptVolScale100|CustTarget|CustomerTargetActual|CustomerTargetRaw|CustomerTargetRawZeroDecimal|PercentIncreaseRaw|PercentageIncreaseRawRange0_100|PercentIncrease");
        System.out.println("MetricId|MetricName|LowerBound|UpperBound|CurrentUser|CurrentComp|BmkUser|BmkComp|CurrentUserPCT|CurrentCompPCT|BmkCurrentUserPCT|BmkCurrentCompPCT|CurrentTarget|BmkTarget|CurrentPctToTarget|BmkPctToTarget|TargetDiff|CampaignProgressValue|TargetPercentage");
        // get all outbound metrics
        List<Metrics> metricsDTO = getDaoProvider().getMetricsDAO().findCategoryByChannelIdOutbound(TWITTERCHANNEL);
        for(Metrics mdto: metricsDTO){
            OutboundMetricsDummy dto = new OutboundMetricsDummy();
            dto.setMetricsName(mdto.getMetricName());
            dto.setMetricsDesc(mdto.getMetricDesc());
            dto.setActiveStatus(mdto.isActiveStatus());
            dto.setCategoryId(mdto.getCategory().getCategoryId());
            dto.setOverallCategoryId(mdto.getOverallCategory().getOverallCategoryId());
            dto.setOverallCategoryWt(mdto.getOverallCategory().getOutboundWt());
            dto.setLowerBound(mdto.getLowerBound());
            dto.setUpperBound(mdto.getUpperBound());
            dto.setWeight(mdto.getWeight());
            dto.setMetricId(mdto.getMetricId());
            dto.setCalcLogic(mdto.getCalcLogic());
            AlertPopupDTO adto = new AlertPopupDTO();
            adto.setJspPageToDisplay(mdto.getJspAlertToDisplay());
            adto.setPageHeight(mdto.getJspAlertHeight());
            adto.setPageWidth(mdto.getJspAlertWidth());
            adto.setTitleBarText(mdto.getJspAlertTitleBarText());
            dto.setAlertMessageDTO(adto);
            setOutboundVolume(dto,mdto, pdto, asOfPerformanceDate, fromTwitterAccountId, benchmarkStDate,benchmarkEdDate, target,performanceList,
                    listOut);
            dtos.add(dto);
        }
        //appendLog1("Outbound Metrics Data Loop End->");
        //viewLog();
        displayLog("=================== 1 OutboundMetricsRollup Start ========================");
        System.out.println("OutboundMetricsRollup Start: " + getCurrentDate());
        performOutboundMetricsRollup(listOut, dtos, totalHandler); 
        System.out.println("OutboundMetricsRollup End: " + getCurrentDate());
        displayLog("=================== 1 OutboundMetricsRollup End ========================");

        
        return dtos;
    }


    public List<InboundMetricsDummy> getInboundMetrics(Date asOfPerformanceDate, ProfilePreference pdto, String fromTwitterAccountId, Date benchmarkStDate, 
            Date benchmarkEdDate, ImprovementLevel target,Map<String, OverallSentimentDTO> maposDTOs, List<String> sentiments,
            List<OverallGradeDTO> listIn, int totalHandler) throws SVTException {
        List<InboundMetricsDummy> dtos = new ArrayList<InboundMetricsDummy>();
        
        
        appendLogInbound("As of PerformanceDate: " + asOfPerformanceDate + "\nBenchmarkStDate:" + benchmarkStDate + "\nBenchmarkEdDate:" + benchmarkEdDate + "\nProfile Handle:" + fromTwitterAccountId);        
        appendLogInbound("MetricId|MetricName|CustomerVolume|CmptVolume|YourBenchmarkVolume|CmptBenchmarkVolume|LowerBound|UpperBound|CustVolScale100|CmptVolScale100|YourBenchmarkVolScale100|BenchmarkCmptVolScale100|CustTarget|CustomerTargetActual|CustomerTargetRaw|CustomerTargetRawZeroDecimal|PercentIncreaseRaw|PercentageIncreaseRawRange0_100|PercentIncrease");
        System.out.println("MetricId|MetricName|LowerBound|UpperBound|CurrentUser|CurrentComp|BmkUser|BmkComp|CurrentUserPCT|CurrentCompPCT|BmkCurrentUserPCT|BmkCurrentCompPCT|CurrentTarget|BmkTarget|CurrentPctToTarget|BmkPctToTarget|TargetDiff|CampaignProgressValue|TargetPercentage");
        // get all inbound metrics
        List<Metrics> metricsDTO = getDaoProvider().getMetricsDAO().findCategoryByChannelIdInbound(TWITTERCHANNEL);
        List<GradeMaster> sentimentGradeList = getDaoProvider().getGradeMasterDAO().findPerformanceFalse();
        for(Metrics mdto: metricsDTO){
            InboundMetricsDummy dto = new InboundMetricsDummy();
            dto.setMetricsName(mdto.getMetricName());
            dto.setMetricsDesc(mdto.getMetricDesc());
            //dto.setActiveStatus(mdto.isActiveStatus());
            dto.setCategoryId(mdto.getCategory().getCategoryId());
            dto.setOverallCategoryId(mdto.getOverallCategory().getOverallCategoryId());
            dto.setOverallCategoryWt(mdto.getOverallCategory().getInboundWt());
            dto.setLowerBound(mdto.getLowerBound());
            dto.setUpperBound(mdto.getUpperBound());
            dto.setSiWt(mdto.getSiWt());
            dto.setWeight(mdto.getWeight());
            dto.setMetricId(mdto.getMetricId());
            
            setInboundVolume(dto,mdto,pdto, asOfPerformanceDate, fromTwitterAccountId, benchmarkStDate,benchmarkEdDate, target);
            dtos.add(dto);
        }
        //viewLog();
        displayLog("=================== 2 SentimentGradeCalculation Start ========================");
        performSentimentGradeCalculation(maposDTOs, sentiments, dtos,
                sentimentGradeList, totalHandler);
        displayLog("=================== 2 SentimentGradeCalculation End ========================");
        displayLog("=================== 3 InboundMetricsRollup End ========================");
        performInboundMetricsRollup(listIn, dtos, totalHandler);
        displayLog("=================== 3 InboundMetricsRollup End ========================");
        return dtos;
    }

    private void setInboundVolume(InboundMetricsDummy dto, Metrics mdto,ProfilePreference pdto, Date asOfPerformanceDate, 
            String fromTwitterAccountId, Date benchmarkStDate,Date benchmarkEdDate, ImprovementLevel target) throws SVTException {
//        System.out.println("ProfileId: " + pdto.getProfilePrefrenceId());
//        System.out.println("AsOfDate : " + asOfPerformanceDate);
//        System.out.println("metricId : " + mdto.getMetricId());
//        System.out.println("MetricCode: " + mdto.getMetricCode());
        double totalDataCount=0;
        double totalRawScoreSelf=0;
        double totalRawScoreCmpt=0;
        double totalRawScoreDCSelf=0;
        double totalRawScoreDCCmpt=0;

        double yourVolume=0;
        double cmptVolume=0;
        double custTarget=0;
        double custTargetRaw=0;
        double calculatedYourVolume=0;
        double calculatedCmptVolume=0;
        double baselineTargetRaw=0;
        double currentTargetRaw=0;
        double campaignProgressValue=0;
        double benchmarkPctofTarget=0;
        double currentPctofTarget=0;
        double targetDiff=0;


        int targetPercentage=0;
        if(target == null){
            target = pdto.getUserProfileDetail().getImprovementLevel();
        }
        targetPercentage=getOnlyNumbers(target.getPctValue());

        dto.setCustVolume("");
        dto.setCmptVolume("");
        dto.setDataProcessed(true);
        dto.setDataProcessedCmpt(true);
                 List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(),fromTwitterAccountId, mdto.getMetricId(), asOfPerformanceDate);
                 List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(pdto.getProfilePrefrenceId(),fromTwitterAccountId, mdto.getMetricId(), asOfPerformanceDate);                 
                 for(RawResult rr: selfDtos){
                     if(rr.getRawScore() < 0 && rr.getTotalDataCount()==0){
                         dto.setDataProcessed(false); // not yet complete in processing data (by backend process)
                     }
                     if(rr.getRawScore()>=0 || rr.getTotalDataCount()>0){
                         totalRawScoreSelf+=rr.getRawScore();
                         totalDataCount+=rr.getTotalDataCount();
                         totalRawScoreDCSelf+=rr.getRawScore()*rr.getTotalDataCount();
                     }
                 }
                 if(selfDtos.size() == 0 && cmptDtos.size() == 0){
                     dto.setDataProcessed(false);  
                 }
                 displayLog(">>>>>>>>>>>>>>MetricId: " + mdto.getMetricId() + " MetricsName: " + mdto.getMetricName() + " rawscore:"+ 
                         totalRawScoreSelf + " datacount:"+ 
                         totalDataCount + " Customer Volume: " + (totalRawScoreSelf));
                 //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Customer Volume: " + (totalRawScore/totalDataCount));
                 
                 // This is as per mail dated 7/18 requested by Wendy and nimish subject: Changes
                 if(mdto.getCalcLogic() == 1){ // percentage
                     if(totalDataCount == 0){
                         totalRawScoreSelf =0;
                     }else{
                         totalRawScoreSelf = (totalRawScoreSelf / totalDataCount)*100;    
                     }  
                 }else if(mdto.getCalcLogic() == 2){ // (rs*DC)/sum(dc)
                     if(totalDataCount == 0){
                         totalRawScoreSelf =0;
                     }else{
                         totalRawScoreSelf = (totalRawScoreDCSelf / totalDataCount);    
                     }  
                 }
                 
                 // This is as per mail dated 8/5 request by Wendy subject: Re: QA deployment is done!                 
                 if(mdto.getCategory().getCategoryId().equalsIgnoreCase("9")){ // For conversion Metrics
                     dto.setDataProcessedCmpt(false);
                 }else{
                     dto.setDataProcessedCmpt(dto.isDataProcessed()); 
                 }
                 
                 dto.setCustVolume("0");
                 if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScoreSelf)))){
                     yourVolume=getDoubleNumber2Decimal((totalRawScoreSelf));
                     dto.setCustVolume(getDoubleFormatedAsString(yourVolume));
                 }
                 totalDataCount=0;
                 totalRawScoreCmpt=0;
                 totalRawScoreDCCmpt=0;
                 for(RawResult rr: cmptDtos){
                     if(rr.getRawScore()>=0 || rr.getTotalDataCount() > 0){
                         totalRawScoreCmpt+=rr.getRawScore();
                         totalDataCount+=rr.getTotalDataCount();
                         totalRawScoreDCCmpt+=rr.getRawScore()*rr.getTotalDataCount();
                     }
                 }
                 displayLog("MetricId: " + mdto.getMetricId() + " MetricsName: " + mdto.getMetricName() + " rawscore:"+ totalRawScoreCmpt + 
                         " datacount:"+ totalDataCount + " Cmpt Volume: " + (totalRawScoreCmpt));
                 
                 // This is as per mail dated 7/18 requested by Wendy and nimish subject: Changes
                 if(mdto.getCalcLogic() == 1){ // percentage
                     if(totalDataCount == 0){
                         totalRawScoreCmpt =0;
                     }else{
                         totalRawScoreCmpt = (totalRawScoreCmpt / totalDataCount)*100;    
                     }  
                 }else if(mdto.getCalcLogic() == 2){ // (rs*DC)/sum(dc)
                     if(totalDataCount == 0){
                         totalRawScoreCmpt =0;
                     }else{
                         totalRawScoreCmpt = (totalRawScoreDCCmpt / totalDataCount);    
                     }  
                 }
                 
                 dto.setCmptVolume("0");
                 if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScoreCmpt)))){
                     cmptVolume=getDoubleNumber2Decimal((totalRawScoreCmpt));
                     dto.setCmptVolume(getDoubleFormatedAsString(cmptVolume));
                 }
                 if(dto.isDataProcessed()){
                    setVolumeTrendInbound(dto, totalRawScoreSelf, totalRawScoreCmpt, pdto.getProfilePrefrenceId(), fromTwitterAccountId, mdto.getMetricId(), mdto.getMetricDesc(), mdto.getCalcLogic(), asOfPerformanceDate); //Customer and Competitor    
                 }                 
                 calculatedYourVolume = calculateYourVolumeSELFAvg(mdto, pdto,
                        fromTwitterAccountId, benchmarkStDate, benchmarkEdDate,
                        calculatedYourVolume, dto);
                 calculatedCmptVolume = calculateYourVolumeCMPTAvg(mdto, pdto,
                        fromTwitterAccountId, benchmarkStDate, benchmarkEdDate,
                        calculatedCmptVolume, dto);
 
              // as per mail dated 8-Sept from wendy, subject: Tomorrow's Standup
                 if(!Double.isNaN(getDoubleNumber2Decimal((calculatedYourVolume)))){
                     double calculatedYourVolumeTemp=getDoubleNumber2Decimal((calculatedYourVolume));
                     dto.setCalculatedYourVolume(getDoubleFormatedAsString(calculatedYourVolumeTemp));
                 }
                 // normalizing the volume
                 dto.setCustVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCustVolume()), dto.getLowerBound(), dto.getUpperBound())); // as per faiz mail dated 9-May-2011
                 dto.setCmptVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCmptVolume()), dto.getLowerBound(), dto.getUpperBound())); // as per faiz mail dated 9-May-2011
                 double calculatedYourVolumeScale100 = getNormalizedValue(calculatedYourVolume, dto.getLowerBound(), dto.getUpperBound()); // as per faiz mail dated 9-May-2011
                 double calculatedCmptVolumeScale100 = getNormalizedValue(calculatedCmptVolume, dto.getLowerBound(), dto.getUpperBound()); // as per faiz mail dated 9-May-2011
                 
                 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
                 // Rule1: YV < CV, Moderate=(CV-YV)*moderate%+YV, Aggr=CV, VAggr=(CV-YV)*vaggressive%+YV
                 // Rule2: YV > CV, Moderate=Aggr=VAggr=YV
                 // Rule3: YV > CV, && VAggr > 100, then Vaggr=100
                  //dto.setCustTarget(custTarget);
                 //if(calculatedYourVolumeScale100 >= calculatedCmptVolumeScale100){
                 //    custTarget= calculatedYourVolumeScale100;
                 //    if(target.getName().equalsIgnoreCase(VERY_AGGRESSIVE) && calculatedYourVolumeScale100>100){
                 //        custTarget=100;
                 //    }
                 //}else{
                 //    double value=(calculatedCmptVolumeScale100-calculatedYourVolumeScale100)* (targetPercentage*.01) + calculatedYourVolumeScale100;
                 //    custTarget=getDoubleNumber2Decimal(value);
                 //    if(target.getName().equalsIgnoreCase(AGGRESSIVE)){
                 //        custTarget=calculatedYourVolumeScale100; 
                 //    }
                 //}
                 
                 double calculatedYourVolumePCT = getNormalizedValueinPCT(calculatedYourVolume, dto.getLowerBound(), dto.getUpperBound(), dto.getMetricId());
                 double calculatedCmptVolumePCT = getNormalizedValueinPCT(calculatedCmptVolume, dto.getLowerBound(), dto.getUpperBound(), dto.getMetricId());
                 double yourVolumePCT = getNormalizedValueinPCT(yourVolume, dto.getLowerBound(), dto.getUpperBound(), dto.getMetricId());
                 double cmptVolumePCT = getNormalizedValueinPCT(cmptVolume, dto.getLowerBound(), dto.getUpperBound(), dto.getMetricId());
                 
                 baselineTargetRaw = getBaselineTargetRaw(calculatedYourVolume, calculatedCmptVolume, dto.getLowerBound(), dto.getUpperBound(),targetPercentage, dto.getMetricId());
                 currentTargetRaw =  getCurrentTargetRaw(yourVolume, cmptVolume, dto.getLowerBound(), dto.getUpperBound(), targetPercentage, dto.getMetricId());
                 benchmarkPctofTarget = getBenchmarkPctofTarget(calculatedYourVolume, calculatedCmptVolume, dto.getLowerBound(), dto.getUpperBound(), dto.getMetricId());
                 currentPctofTarget = getCurrentPctofTarget(yourVolume, cmptVolume, dto.getLowerBound(), dto.getUpperBound(),targetPercentage, dto.getMetricId());
                 targetDiff = (currentPctofTarget-benchmarkPctofTarget);

                 campaignProgressValue = getCampaignProgressValue(targetDiff);
                 dto.setCurrentTargetRawString(getDoubleFormatedAsString(getDoubleNumber0Decimal(currentTargetRaw)));
                 //setAlertFlameStarCount(dto, campaignProgressValue, performanceList); 
                 
                 System.out.println(dto.getMetricId() + "|" + dto.getMetricsName()+ "|" + dto.getLowerBound() + "|" + dto.getUpperBound() + "|" + yourVolume + "|" + cmptVolume + "|" + calculatedYourVolume + "|" + calculatedCmptVolume + "|" + yourVolumePCT + "|" + cmptVolumePCT + "|" + calculatedYourVolumePCT + "|" + calculatedCmptVolumePCT + "|" + currentTargetRaw + "|" + baselineTargetRaw + "|" + currentPctofTarget + "|" + benchmarkPctofTarget + "|" + targetDiff + "|" + campaignProgressValue +"|" + targetPercentage);
                 
                 
                 custTarget = getCustomerTargetByImprovementLevel(target.getName(),
                        cmptVolume, calculatedYourVolume,
                        targetPercentage,dto.getLowerBound(), dto.getUpperBound());
                 
                 // Calculating rawTarget as per faiz/wendy mail request dated 5/22/2011 9:46PM
                 // Again Change: Calculating rawTarget as per faiz/wendy goto meeting request dated 9/08/2011 3:30PM IST
                 custTargetRaw = getCustomerTargetRaw(dto.getLowerBound(), dto.getUpperBound(), getDoubleNumberisNANZero(custTarget));
                 dto.setCustTargetRaw(getDoubleFormatedAsString(getDoubleNumber0Decimal(custTargetRaw)));
                 double piValueRaw = convertNANtoblank(
                         getDoubleNumber0Decimal(nanToZero(
                                 (yourVolume-calculatedYourVolume)/(custTargetRaw-calculatedYourVolume))*100.00)                    
                 );
                 dto.setPercentIncreaseRaw(getDoubleFormatedAsString(piValueRaw));
                 dto.setPercentIncreaseRawScale100(getInRange(piValueRaw)); // request by faiz/wendy meeting dated 8/18/2011 at 3:30PM IST

                 dto.setCustTarget(getDoubleFormatedAsString(getDoubleNumber0Decimal(custTarget)));
                 dto.setCustTargetActual(custTarget);
                 double piValue = convertNANtoblank(
                         getDoubleNumber0Decimal(nanToZero((dto.getCustVolumeScale100()-calculatedYourVolumeScale100)/(custTarget-calculatedYourVolumeScale100))*100.00)                    
                 );                 
                 dto.setPercentIncrease(getDoubleFormatedAsString(piValue));
                 
                 appendLogInbound(dto.getMetricId()    + "|" + 
                         dto.getMetricsName() + "|" + 
                         dto.getCustVolume()  + "|" + 
                         dto.getCmptVolume()  + "|" + 
                         calculatedYourVolume + "|" +
                         calculatedCmptVolume + "|" +
                         dto.getLowerBound()  + "|" +
                         dto.getUpperBound()  + "|" +
                         dto.getCustVolumeScale100() + "|" +                 
                         dto.getCmptVolumeScale100() + "|" +
                         calculatedYourVolumeScale100 + "|" +
                         calculatedCmptVolumeScale100 + "|" +
                         dto.getCustTarget() + "|" +
                         dto.getCustTargetActual() + "|" +
                         custTargetRaw + "|" +
                         dto.getCustTargetRaw() + "|" +
                         dto.getPercentIncreaseRaw() + "|" +
                         dto.getPercentIncreaseRawScale100() + "|" +
                         dto.getPercentIncrease() + "|"
                        );

                 displayLog("Target Selected: " + target.getName() + 
                            " For Metrics: " + mdto.getMetricId() + 
                            " Your Volume: " + yourVolume + 
                            " Calculated Your VolumeScale100: " + calculatedYourVolumeScale100 + 
                            " Calc Cmpt VolumeScale100: " + calculatedCmptVolumeScale100 +
                            " Cust Target: " + dto.getCustTarget() + 
                            " Percent Increase((YV-CYV)/CustTrgt-CYV)*100: " + dto.getPercentIncrease());

                 // normalizing the volume
                 displayLog("Normalizing Your volume: " + dto.getCustVolume() + " lowerBound: " + dto.getLowerBound() + 
                         " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCustVolumeScale100());
                 displayLog("Normalizing Cmpt Your volume: " + dto.getCmptVolume() + " lowerBound: " + dto.getLowerBound() + 
                         " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCmptVolumeScale100());
                 if(selfDtos.size() ==0 && cmptDtos.size() ==0){
                     setDtoBlank(dto);
                 }
    }


    private double getCustomerTargetByImprovementLevel(String target,
            double cmptVolume, double calculatedYourVolume,
            int targetPercentage,int lowerBound, int upperBound) {
        // Logic changed as per faiz mail dated 8/23 subject "2011-08-22 22:12 Calculating Targets"
        //Notes:
        //1 – everything is based on raw values, NOT on the 0-100 scaled values
        //2 – targets can be higher than the upper bounds 
        //3 – targets change as time goes on and the competitors’ average changes
        //For scaled values (e.g., 1 to 5):
        //Target should never be higher than the upper bound (or less than the lower bound for reverse cases).

        double custTarget=0;
        if(lowerBound < upperBound){
            if(target.equalsIgnoreCase(MODERATE)){
                custTarget = getMaxValue(calculatedYourVolume,getAvgValue(calculatedYourVolume, cmptVolume)); 
            }else if(target.equalsIgnoreCase(AGGRESSIVE)){
                custTarget = getMaxValue(calculatedYourVolume, cmptVolume); 
            }else if(target.equalsIgnoreCase(VERY_AGGRESSIVE)){
                custTarget = getMaxValue(calculatedYourVolume, ((targetPercentage*.01)*cmptVolume));  
            } 
        }else{
            if(target.equalsIgnoreCase(MODERATE)){
                custTarget = getMinValue(calculatedYourVolume,getAvgValue(calculatedYourVolume, cmptVolume)); 
            }else if(target.equalsIgnoreCase(AGGRESSIVE)){
                custTarget = getMinValue(calculatedYourVolume, cmptVolume); 
            }else if(target.equalsIgnoreCase(VERY_AGGRESSIVE)){
                custTarget = getMaxValue(calculatedYourVolume, ((targetPercentage*.01)*cmptVolume)-getAvgValue(lowerBound,upperBound));  
            }
        }
        
        return custTarget;
    }    
    
    private double getMaxValue(double calculatedYourVolume, double avgValue) {
        return Math.max(calculatedYourVolume, avgValue);
    }
    private double getMinValue(double calculatedYourVolume, double avgValue) {
        return Math.min(calculatedYourVolume, avgValue);
    }


    private double getAvgValue(double calculatedYourVolume, double cmptVolume) {
        return ((calculatedYourVolume+cmptVolume)/2.0);
    }


    /**
     * Comparing selected date volume with previous date volume
     * @param dto
     * @param currentRawScoreSelf
     * @param currentRawScoreCmpt
     * @param profilePrefrenceId
     * @param fromTwitterAccountId
     * @param metricId
     * @param asOfPerformanceDate
     * @throws SVTException
     */
    private void setVolumeTrendInbound(InboundMetricsDummy dto, double currentRawScoreSelf, double currentRawScoreCmpt, String profilePrefrenceId, String fromTwitterAccountId,
            String metricId, String metricDesc, int calcLogic, Date asOfPerformanceDate) throws SVTException {
        double totalDataCount=0;
        // getting previous day volume
        asOfPerformanceDate = getPreviousDay(asOfPerformanceDate);
        List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(profilePrefrenceId,fromTwitterAccountId, metricId, asOfPerformanceDate);
        List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(profilePrefrenceId,fromTwitterAccountId, metricId, asOfPerformanceDate);
        double previousRawScore=0;
        double previousRawScoreDC=0;
        for(RawResult rr: selfDtos){
            if(rr.getRawScore()>=0 || rr.getTotalDataCount() > 0){
                previousRawScore+=rr.getRawScore();  
                totalDataCount+=rr.getTotalDataCount();
                previousRawScoreDC+=rr.getRawScore()*rr.getTotalDataCount();
            }
        }
        //This is as per mail dated 7/18 requested by Wendy and nimish subject: Changes
        if(calcLogic == 1){ // percentage
            if(totalDataCount == 0){
                previousRawScore =0;
            }else{
                previousRawScore = (previousRawScore / totalDataCount)*100;    
            }  
        }else if(calcLogic == 2){ // (rs*DC)/sum(dc)
            if(totalDataCount == 0){
                previousRawScore =0;
            }else{
                previousRawScore = (previousRawScoreDC / totalDataCount);    
            }  
        }        
        
        if(currentRawScoreSelf < previousRawScore){
           dto.setCustVolumeTrend(-1); 
        }else if(currentRawScoreSelf > previousRawScore){
            dto.setCustVolumeTrend(1);
        }else{
            dto.setCustVolumeTrend(0);
        }
        
        previousRawScore=0;
        previousRawScoreDC=0;
        totalDataCount=0;
        for(RawResult rr: cmptDtos){
            if(rr.getRawScore()>=0 || rr.getTotalDataCount()>0){
                previousRawScore+=rr.getRawScore();  
                totalDataCount+=rr.getTotalDataCount();
                previousRawScoreDC+=rr.getRawScore()*rr.getTotalDataCount();                
            }
        }
        //This is as per mail dated 7/18 requested by Wendy and nimish subject: Changes
        if(calcLogic == 1){ // percentage
            if(totalDataCount == 0){
                previousRawScore =0;
            }else{
                previousRawScore = (previousRawScore / totalDataCount)*100;    
            }  
        }else if(calcLogic == 2){ // (rs*DC)/sum(dc)
            if(totalDataCount == 0){
                previousRawScore =0;
            }else{
                previousRawScore = (previousRawScoreDC / totalDataCount);    
            }  
        }
        
        if(currentRawScoreCmpt < previousRawScore){
           dto.setCmptVolumeTrend(-1); 
        }else if(currentRawScoreCmpt > previousRawScore){
            dto.setCmptVolumeTrend(1);
        }else{
            dto.setCmptVolumeTrend(0);
        }        
    }

    /**
     * Comparing selected date volume with previous date volume
     * @param dto
     * @param currentRawScoreSelf
     * @param currentRawScoreCmpt
     * @param profilePrefrenceId
     * @param fromTwitterAccountId
     * @param metricId
     * @param asOfPerformanceDate
     * @throws SVTException
     */
    private void setVolumeTrendOutbound(OutboundMetricsDummy dto, double currentRawScoreSelf, double currentRawScoreCmpt, String profilePrefrenceId, String fromTwitterAccountId,
            String metricId, String metricDesc, int calcMethod, Date asOfPerformanceDate) throws SVTException {
        double totalDataCount=0;
        
        // getting previous day volume
        asOfPerformanceDate = getPreviousDay(asOfPerformanceDate);
        List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(profilePrefrenceId,fromTwitterAccountId, metricId, asOfPerformanceDate);
        List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(profilePrefrenceId,fromTwitterAccountId, metricId, asOfPerformanceDate);
        
        double previousRawScore=0;
        for(RawResult rr: selfDtos){
            if(rr.getRawScore()>=0 || rr.getTotalDataCount()>0){
                previousRawScore+=rr.getRawScore();   
                totalDataCount+=rr.getTotalDataCount();
            }
        }
        
        //This is as per mail dated 7/18 requested by Wendy and nimish subject: Changes
        if(calcMethod == 1){ // percentage
            if(totalDataCount == 0){
                previousRawScore =0;
            }else{
                previousRawScore = (previousRawScore / totalDataCount)*100;    
            }  
        }
        
        if(currentRawScoreSelf < previousRawScore){
           dto.setCustVolumeTrend(-1); 
        }else if(currentRawScoreSelf > previousRawScore){
            dto.setCustVolumeTrend(1);
        }else{
            dto.setCustVolumeTrend(0);
        }
        
        previousRawScore=0;
        totalDataCount=0;
        for(RawResult rr: cmptDtos){
            if(rr.getRawScore()>=0 || rr.getTotalDataCount()>0){
                previousRawScore+=rr.getRawScore(); 
                totalDataCount+=rr.getTotalDataCount();
            }
        }
        //This is as per mail dated 7/18 requested by Wendy and nimish subject: Changes
        if(calcMethod == 1){ // percentage
            if(totalDataCount == 0){
                previousRawScore =0;
            }else{
                previousRawScore = (previousRawScore / totalDataCount)*100;    
            }  
        }
        if(currentRawScoreCmpt < previousRawScore){
           dto.setCmptVolumeTrend(-1); 
        }else if(currentRawScoreCmpt > previousRawScore){
            dto.setCmptVolumeTrend(1);
        }else{
            dto.setCmptVolumeTrend(0);
        }        
    }
    
    private void setOutboundVolume(OutboundMetricsDummy dto, Metrics mdto, ProfilePreference pdto, Date asOfPerformanceDate, 
            String fromTwitterAccountId, Date benchmarkStDate,Date benchmarkEdDate, ImprovementLevel target,
            List<GradeMaster> performanceList,List<OverallGradeDTO> listOut) throws SVTException {
        double totalDataCount=0;
        double totalRawScoreSelf=0;
        double totalRawScoreCmpt=0;
        double totalRawScoreDCSelf=0;
        double totalRawScoreDCCmpt=0;        
        double yourVolume=0;
        double cmptVolume=0;
        double custTarget=0;
        double custTargetRaw=0;
        double baselineTargetRaw=0;
        double currentTargetRaw=0;
        double benchmarkPctofTarget=0;
        double currentPctofTarget=0;
        double targetDiff=0;
        double campaignProgressValue=0;
        
        double calculatedYourVolume=0;
        double calculatedCmptVolume=0;        
        
        int targetPercentage=0;
        if(target == null){
            target = pdto.getUserProfileDetail().getImprovementLevel();
        }
        targetPercentage=getOnlyNumbers(target.getPctValue());
        
        dto.setCustVolume("");
        dto.setCmptVolume("");
        dto.setDataProcessed(true);
                 List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(), fromTwitterAccountId,mdto.getMetricId(), asOfPerformanceDate);
                 List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(pdto.getProfilePrefrenceId(),fromTwitterAccountId,mdto.getMetricId(), asOfPerformanceDate);
                 
                 for(RawResult rr: selfDtos){
                     if(rr.getRawScore() < 0 && rr.getTotalDataCount() == 0){
                         dto.setDataProcessed(false); // not yet complete in processing data (by backend process)
                     }
                     if(rr.getRawScore()>=0 || rr.getTotalDataCount()>0){
                         totalRawScoreSelf+=rr.getRawScore();
                         totalDataCount+=rr.getTotalDataCount();
                         totalRawScoreDCSelf+=rr.getRawScore()*rr.getTotalDataCount();
                     }
                 }
                 if(selfDtos.size() == 0 && cmptDtos.size() == 0){
                     dto.setDataProcessed(false);  
                 }
                 displayLog(">>>>>>>>>>>>>>MetricId: " + mdto.getMetricId() + " MetricsName: " + mdto.getMetricName() + " rawscore:"+ totalRawScoreSelf + " datacount:"+ 
                         totalDataCount + "Customer Volume: " + (totalRawScoreSelf));
displayLogFile1("Self |" + mdto.getMetricId() + " | " + mdto.getMetricName() + "|" + totalRawScoreSelf);
                 
                // This is as per mail dated 7/18 requested by Wendy and nimish subject: Changes
                if(mdto.getCalcLogic() == 1){ // percentage
                    if(totalDataCount == 0){
                        totalRawScoreSelf =0;
                    }else{
                        totalRawScoreSelf = (totalRawScoreSelf / totalDataCount)*100;    
                    }  
                }else if(mdto.getCalcLogic() == 2){ // (rs*DC)/sum(dc)
                    if(totalDataCount == 0){
                        totalRawScoreSelf =0;
                    }else{
                        totalRawScoreSelf = (totalRawScoreDCSelf / totalDataCount);    
                    }  
                }

                 dto.setCustVolume("0");
                 if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScoreSelf)))){
                     yourVolume=getDoubleNumber2Decimal((totalRawScoreSelf));
                     dto.setCustVolume(getDoubleFormatedAsString(yourVolume));
                 }
                 totalDataCount=0;
                 totalRawScoreCmpt=0;
                 for(RawResult rr: cmptDtos){
                     if(rr.getRawScore()>=0 || rr.getTotalDataCount()>0){
                         totalRawScoreCmpt+=rr.getRawScore();
                         totalDataCount+=rr.getTotalDataCount();
                         totalRawScoreDCCmpt+=rr.getRawScore()*rr.getTotalDataCount();
                     }
                 }
                 displayLog("MetricId: " + mdto.getMetricId() + " MetricsName: " + mdto.getMetricName() + " rawscore:"+ totalRawScoreCmpt + 
                         " datacount:"+ totalDataCount + " Cmpt Volume: " + (totalRawScoreCmpt));
displayLogFile1("Cmpt |" + mdto.getMetricId() + " | " + mdto.getMetricName() + "|" + totalRawScoreCmpt);
                
                //This is as per mail dated 7/18 requested by Wendy and nimish subject: Changes
                    if(mdto.getCalcLogic() == 1){ // percentage
                        if(totalDataCount == 0){
                            totalRawScoreCmpt =0;
                        }else{
                            totalRawScoreCmpt = (totalRawScoreCmpt / totalDataCount)*100;    
                        }  
                    }else if(mdto.getCalcLogic() == 2){ // (rs*DC)/sum(dc)
                        if(totalDataCount == 0){
                            totalRawScoreCmpt =0;
                        }else{
                            totalRawScoreCmpt = (totalRawScoreDCCmpt / totalDataCount);    
                        }  
                    }               

                dto.setCmptVolume("0");
                 if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScoreCmpt)))){
                     cmptVolume=getDoubleNumber2Decimal((totalRawScoreCmpt));
                     dto.setCmptVolume(getDoubleFormatedAsString(cmptVolume));
                 }
                 
                 if(dto.isDataProcessed()){
                     setVolumeTrendOutbound(dto, totalRawScoreSelf, totalRawScoreCmpt, pdto.getProfilePrefrenceId(), fromTwitterAccountId, mdto.getMetricId(), mdto.getMetricDesc(), mdto.getCalcLogic(), asOfPerformanceDate); //Customer and Competitor    
                 }
                 
                 calculatedYourVolume = calculateYourVolumeSELFAvg(mdto, pdto,
                        fromTwitterAccountId, benchmarkStDate, benchmarkEdDate,
                        calculatedYourVolume,null);
                 calculatedCmptVolume = calculateYourVolumeCMPTAvg(mdto, pdto,
                        fromTwitterAccountId, benchmarkStDate, benchmarkEdDate,
                        calculatedCmptVolume,null);

                 // as per mail dated 8-Sept from wendy, subject: Tomorrow's Standup
                 if(!Double.isNaN(getDoubleNumber2Decimal((calculatedYourVolume)))){
                     double calculatedYourVolumeTemp=getDoubleNumber2Decimal((calculatedYourVolume));
                     dto.setCalculatedYourVolume(getDoubleFormatedAsString(calculatedYourVolumeTemp));
                 }
                 
                 
                 // normalizing the volume
                 dto.setCustVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCustVolume()), dto.getLowerBound(), dto.getUpperBound())); // as per faiz mail dated 9-May-2011
                 dto.setCmptVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCmptVolume()), dto.getLowerBound(), dto.getUpperBound())); // as per faiz mail dated 9-May-2011
                 double calculatedYourVolumeScale100 = getNormalizedValue(calculatedYourVolume, dto.getLowerBound(), dto.getUpperBound()); // as per faiz mail dated 9-May-2011
                 double calculatedCmptVolumeScale100 = getNormalizedValue(calculatedCmptVolume, dto.getLowerBound(), dto.getUpperBound()); // as per faiz mail dated 9-May-2011
                 dto.setCalculatedYourVolumeScale100(calculatedYourVolumeScale100);
                 dto.setCalculatedCmptVolumeScale100(calculatedCmptVolumeScale100);
                 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
                 // Rule1: YV < CV, Moderate=(CV-YV)*moderate%+YV, Aggr=CV, VAggr=(CV-YV)*vaggressive%+YV
                 // Rule2: YV > CV, Moderate=Aggr=VAggr=YV
                 // Rule3: YV > CV, && VAggr > 100, then Vaggr=100
                  //dto.setCustTarget(custTarget);
                 //if(calculatedYourVolumeScale100 >= calculatedCmptVolumeScale100){
                 //    custTarget= calculatedYourVolumeScale100;
                 //    if(target.getName().equalsIgnoreCase(VERY_AGGRESSIVE) && calculatedYourVolumeScale100>100){
                 //        custTarget=100;
                 //    }
                 //}else{
                 //    double value=(calculatedCmptVolumeScale100-calculatedYourVolumeScale100)* (targetPercentage*.01) + calculatedYourVolumeScale100;
                 //    custTarget=getDoubleNumber2Decimal(value);
                 //    if(target.getName().equalsIgnoreCase(AGGRESSIVE)){
                 //        custTarget=calculatedYourVolumeScale100; 
                 //    }
                 //}
                 
                 double calculatedYourVolumePCT = getNormalizedValueinPCT(calculatedYourVolume, dto.getLowerBound(), dto.getUpperBound(), dto.getMetricId());
                 double calculatedCmptVolumePCT = getNormalizedValueinPCT(calculatedCmptVolume, dto.getLowerBound(), dto.getUpperBound(), dto.getMetricId());
                 double yourVolumePCT = getNormalizedValueinPCT(yourVolume, dto.getLowerBound(), dto.getUpperBound(), dto.getMetricId());
                 double cmptVolumePCT = getNormalizedValueinPCT(cmptVolume, dto.getLowerBound(), dto.getUpperBound(), dto.getMetricId());
                 
                 
                 
                 
                 baselineTargetRaw = getBaselineTargetRaw(calculatedYourVolume, calculatedCmptVolume, dto.getLowerBound(), dto.getUpperBound(),targetPercentage, dto.getMetricId());
                 currentTargetRaw =  getCurrentTargetRaw(yourVolume, cmptVolume, dto.getLowerBound(), dto.getUpperBound(), targetPercentage, dto.getMetricId());
                 benchmarkPctofTarget = getBenchmarkPctofTarget(calculatedYourVolume, calculatedCmptVolume, dto.getLowerBound(), dto.getUpperBound(), dto.getMetricId());
                 currentPctofTarget = getCurrentPctofTarget(yourVolume, cmptVolume, dto.getLowerBound(), dto.getUpperBound(),targetPercentage, dto.getMetricId());
                 targetDiff = (currentPctofTarget-benchmarkPctofTarget);
                 
                 campaignProgressValue = getCampaignProgressValue(targetDiff);
                 dto.setCurrentTargetRawString(getDoubleFormatedAsString(getDoubleNumber0Decimal(currentTargetRaw)));
                 dto.setBaselineTargetRaw(baselineTargetRaw);
                 dto.setCurrentTargetRaw(currentTargetRaw);
                 dto.setBenchmarkPctofTarget(benchmarkPctofTarget);
                 dto.setCurrentPctofTarget(currentPctofTarget);
                 dto.setCalculatedYourVolumePCT(calculatedYourVolumePCT);
                 dto.setCalculatedCmptVolumePCT(calculatedCmptVolumePCT);
                 dto.setYourVolumePCT(yourVolumePCT);
                 dto.setCmptVolumePCT(cmptVolumePCT);
                 
                 setAlertFlameStarCount(dto, campaignProgressValue, performanceList); 
                 
                 System.out.println(dto.getMetricId() + "|" + dto.getMetricsName()+ "|" + dto.getLowerBound() + "|" + dto.getUpperBound() + "|" + yourVolume + "|" + cmptVolume + "|" + calculatedYourVolume + "|" + calculatedCmptVolume + "|" + yourVolumePCT + "|" + cmptVolumePCT + "|" + calculatedYourVolumePCT + "|" + calculatedCmptVolumePCT + "|" + currentTargetRaw + "|" + baselineTargetRaw + "|" + currentPctofTarget + "|" + benchmarkPctofTarget + "|" + targetDiff + "|" + campaignProgressValue + "|" + targetPercentage);
                 
                 custTarget = getCustomerTargetByImprovementLevel(target.getName(),
                         cmptVolume, calculatedYourVolume,
                         targetPercentage,dto.getLowerBound(), dto.getUpperBound());
                 
                 dto.setCustTarget(getDoubleFormatedAsString(getDoubleNumber0Decimal(custTarget)));
                 dto.setCustTargetActual(custTarget);
                 
                 // Calculating rawTarget as per faiz/wendy mail request dated 5/22/2011 9:46PM
                 // Again Change: Calculating rawTarget as per faiz/wendy goto meeting request dated 9/08/2011 3:30PM IST
                 custTargetRaw = getCustomerTargetRaw(dto.getLowerBound(), dto.getUpperBound(), getDoubleNumberisNANZero(custTarget));
                 dto.setCustTargetRaw(getDoubleFormatedAsString(getDoubleNumber0Decimal(custTargetRaw)));
                 double piValueRaw = convertNANtoblank(
                         getDoubleNumber0Decimal(nanToZero(
                                 (yourVolume-calculatedYourVolume)/(custTargetRaw-calculatedYourVolume))*100.00)                    
                 );
                 dto.setPercentIncreaseRaw(getDoubleFormatedAsString(piValueRaw));
                 dto.setPercentIncreaseRawScale100(getInRange(piValueRaw)); // request by faiz/wendy meeting dated 8/18/2011 at 3:30PM IST
                 
                 double piValue = convertNANtoblank(
                         getDoubleNumber0Decimal(nanToZero((dto.getCustVolumeScale100()-calculatedYourVolumeScale100)/(custTarget-calculatedYourVolumeScale100))*100.00)                    
                 );
                 dto.setPercentIncrease(getDoubleFormatedAsString(piValue));
                 
                 appendLogOutbound(dto.getMetricId()    + "|" + 
                            dto.getMetricsName() + "|" + 
                            dto.getCustVolume()  + "|" + 
                            dto.getCmptVolume()  + "|" + 
                            calculatedYourVolume + "|" +
                            calculatedCmptVolume + "|" +
                            dto.getLowerBound()  + "|" +
                            dto.getUpperBound()  + "|" +
                            dto.getCustVolumeScale100() + "|" +                 
                            dto.getCmptVolumeScale100() + "|" +
                            dto.getCalculatedYourVolumeScale100() + "|" +
                            dto.getCalculatedCmptVolumeScale100() + "|" +
                            dto.getCustTarget() + "|" +
                            dto.getCustTargetActual() + "|" +
                            custTargetRaw + "|" +
                            dto.getCustTargetRaw() + "|" +
                            dto.getPercentIncreaseRaw() + "|" +
                            dto.getPercentIncreaseRawScale100() + "|" +
                            dto.getPercentIncrease() + "|"
                           );
                 
                 
                /*System.out.println("|" + dto.getMetricsName() + "|" + dto.getCustTarget() + "|" + dto.getPercentIncrease() +
                        "|" + dto.getCustTargetRaw() + "|" + dto.getPercentIncreaseRaw() + "|");*/
                 
                 
                 displayLog("Target Selected: " + target.getName() + 
                            " For Metrics: " + mdto.getMetricId() + 
                            " Your Volume: " + yourVolume + 
                            " Calculated Your VolumeScale100: " + calculatedYourVolumeScale100 + 
                            " Calc Cmpt VolumeScale100: " + calculatedCmptVolumeScale100 +
                            " Cust Target: " + dto.getCustTarget() + 
                            " Percent Increase((YV-CYV)/CustTrgt-CYV)*100: " + dto.getPercentIncrease());
                 
                 //setAlertFlameStarCount(dto, piValueRaw, performanceList);  
                 
                 displayLog("PercentIncrease: " + dto.getPercentIncrease() + 
                            " starCount: " + dto.getAlertStarCount() + 
                            " flameCount: " + dto.getAlertFlameCount());
                 
                 setAlertMessage(dto,selfDtos);
                 
                 displayLogFile("| " + target.getName() + 
                                " | " + mdto.getMetricId() + 
                                "|" + yourVolume + 
                                " | " + calculatedYourVolume + 
                                " | " + cmptVolume + 
                                " | " + calculatedCmptVolume + 
                                " | " + dto.getCustTarget() + 
                                " | " + dto.getPercentIncrease());
                 
                 displayLog("Normalizing Your volume: " + dto.getCustVolume() + " lowerBound: " + dto.getLowerBound() + 
                         " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCustVolumeScale100());
                 displayLog("Normalizing Cmpt Your volume: " + dto.getCmptVolume() + " lowerBound: " + dto.getLowerBound() + 
                         " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCmptVolumeScale100());
                 if(selfDtos.size() ==0 && cmptDtos.size() ==0){
                     setDtoBlank(dto);
                 }
    }

    //----------- All these logics is based on mail from faiz dated 9/14 8:14 AM, subject: "Re: 2011-09-13 22:35 New calculations for targets and campaign progress (flames and stars)"

    private double getCampaignProgressValue(double progressPCT) {        
        double returnValue=getDoubleNumber0Decimal(10*getMinValue(getMaxValue(progressPCT,-0.5),0.5));        
        return returnValue;
    }

    private double getNormalizedValueinPCT(double rawVolume,
            int lowerBound, int upperBound, String metricId) {
        // Exception: as per mail from Faiz dated 9/15 3:29PM, "Influence is left foe another discussion." 
        if(metricId != null && (metricId.trim().equalsIgnoreCase("38") || metricId.trim().equalsIgnoreCase("46"))){
           return  rawVolume;
        }
        
        //Min(1,Max(0,(rawScore – lowerBound)/(upperbound-lowerbound)))
        double returnValue = getMinValue(1, getMaxValue(0,(rawVolume-lowerBound)/(upperBound-lowerBound)));
        return returnValue;
    }

    private double getCurrentPctofTarget(double custCurrentVolume, double cmptCurrentVolume, int lowerBound, int upperBound, int targetPercentage
            , String metricId) {        
        double goalPercentage = (1 + targetPercentage/100.0);
        double returnValue = (getValueFromTargetRawFormula2(custCurrentVolume, lowerBound, upperBound, metricId)-
                getMinValue(1,(getValueFromTargetRawFormula2(cmptCurrentVolume, lowerBound, upperBound, metricId)*goalPercentage)));
        return returnValue;
    }

    private double getBenchmarkPctofTarget(double custBenchmarkVolume, double cmptBenhmarkVolume, int lowerBound, int upperBound, String metricId) {
        double returnValue = (getValueFromTargetRawFormula2(custBenchmarkVolume, lowerBound, upperBound, metricId)-
                              getValueFromTargetRawFormula2(cmptBenhmarkVolume, lowerBound, upperBound, metricId));
        return returnValue;
    }

    private double getCurrentTargetRaw(double custVolume, double cmptVolume,
            int lowerBound, int upperBound, int targetPercentage, String metricId) {
        // Formula 0: (Z11 * (upper - lower) + lower) 
        double currentTargetRaw= (getValueFromTargetRawFormula1(custVolume, cmptVolume, lowerBound, upperBound, targetPercentage, metricId) * 
                                    (upperBound-lowerBound) + lowerBound);
        return currentTargetRaw;
    }

    private double getBaselineTargetRaw(double custBenchmarkVolume,
            double cmptBenhmarkVolume, int lowerBound, int upperBound, int targetPercentage, String metricId) {         
        // Formula 0: (S11 * (upper - lower) + lower) 
        double baselineTargetRaw= (getValueFromTargetRawFormula1(custBenchmarkVolume, cmptBenhmarkVolume, lowerBound, upperBound, targetPercentage, metricId) * 
                                    (upperBound-lowerBound) + lowerBound);
        return baselineTargetRaw;
    }

    private double getValueFromTargetRawFormula1(double custValue,
            double cmptValue, int lowerBound, int upperBound, int targetPercentage, String metricId) {
        // Formula 1: MIN(1,MAX(R11*goalpercent,P11) : for BenchmarkTarget 
        // Formula 1: MIN(1,MAX(Y11*goalpercent,P11) : for CurrentTarget
        
        double goalPercentage = (1 + targetPercentage/100.0);
        double returnValue = getMinValue(1, getMaxValue((getValueFromTargetRawFormula2(cmptValue, lowerBound, upperBound, metricId) * goalPercentage), 
                                                         getValueFromTargetRawFormula2(custValue, lowerBound, upperBound, metricId)));
        return returnValue;
    }

    private double getValueFromTargetRawFormula2(double value, int lowerBound,
            int upperBound, String metricId) {
        // Formula 2: MIN(1,MAX(0,(bmk-lower)/(upper-lower))) : for BenchmarkTarget  
        // Formula 2: MIN(1,MAX(0,(curr-lower)/(upper-lower))) : for CurrentTarget 
        // Exception: as per mail from Faiz dated 9/15 3:29PM, "Influence is left foe another discussion." 
        if(metricId != null && (metricId.trim().equalsIgnoreCase("38") || metricId.trim().equalsIgnoreCase("46"))){
           return  value;
        }
        double returnValue = getMinValue(1, getMaxValue(0,(value-lowerBound)/(upperBound-lowerBound)));
        return returnValue;
    }
   //----------------------------------------------------------------------------------------------------------------//

    private String getInRange(double piValueRaw) {
        if(piValueRaw < 0){
            return "0";
        }else if(piValueRaw > 100){
            return "100";
        }else{
          return getDoubleFormatedAsString(piValueRaw);
        }
    }


    /**
     * Formula for getting rawTarget
     * @param lowerBound
     * @param upperBound
     * @param doubleNumber0Decimal
     * @return
     */
    private double getCustomerTargetRaw(int lowerBound, int upperBound,
            double customerTargetValue) {
        
        if(Double.isNaN(customerTargetValue)){
            customerTargetValue=0; 
        }

        if(upperBound > lowerBound){
            // Formula: LOW+((HIGH-LOW)*(TARGET/100))
            // return lowerBound + ((upperBound-lowerBound) * (customerTargetValue/100));
            // Formula: MIN(HIGH,MAX(LOW,TARGET))
            return getMinValue(upperBound, getMaxValue(lowerBound, customerTargetValue)); 
        }else{
            // Formula: LOW - (HIGH +((LOW-HIGH)*(TARGET/100))
            //return lowerBound - (upperBound + ((lowerBound-upperBound) * (customerTargetValue/100)));
            // Formula: MIN(LOW,MAX(HIGH,TARGET))
            return getMinValue(lowerBound, getMaxValue(upperBound, customerTargetValue));  
        }
    }

    private double calculateYourVolumeCMPTAvg(Metrics mdto,
            ProfilePreference pdto, String fromTwitterAccountId,
            Date benchmarkStDate, Date benchmarkEdDate,
            double calculatedCmptVolume, InboundMetricsDummy dto) throws SVTException {
        double totalDataCount;
        double totalRawScore;
        double totalRawScoreDC;
        displayLog("get all the CMPT values between benchmarkFromDate and benchmarkToDate: " + benchmarkStDate + ":" + benchmarkEdDate +
                "metricId: " + mdto.getMetricId() + " ProfilePrefId: " + pdto.getProfilePrefrenceId() + " FromTwitterAccountId: " + 
                fromTwitterAccountId);
        // get all the CMPT values between benchmarkFromDate and benchmarkToDate
         List<RawResult> calcCmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateCALCNOTSELF(
                 pdto.getProfilePrefrenceId(), 
                 fromTwitterAccountId,
                 mdto.getMetricId(),
                 benchmarkEdDate);

         if(calcCmptDtos != null && calcCmptDtos.size() >0)
         {
             // as per mail dated 8/17 requested by faiz, subject: Metric - Geolocation Setting - Observation
             double gtotal = 0;
             totalDataCount = 0;
             totalRawScore=0;
             totalRawScoreDC=0;
             for (RawResult rrDTO : calcCmptDtos) {
                 if(rrDTO.getRawScore()>=0 || rrDTO.getTotalDataCount()>0){
                     totalRawScore+=rrDTO.getRawScore();
                     totalDataCount+=rrDTO.getTotalDataCount();
                     totalRawScoreDC+=rrDTO.getRawScore()*rrDTO.getTotalDataCount();
                 }                 
             }
             
             // This is as per mail dated 7/18 requested by Wendy and nimish subject: Changes
             if(mdto.getCalcLogic() == 1){ // percentage
                 if(totalDataCount == 0){
                     gtotal =0;
                 }else{
                     gtotal = (totalRawScore / totalDataCount)*100;    
                 }  
             }else if(mdto.getCalcLogic() == 2){ // (rs*DC)/sum(dc)
                 if(totalDataCount == 0){
                     gtotal =0;
                 }else{
                     gtotal = (totalRawScoreDC / totalDataCount);    
                 }  
             }else{
                 gtotal = (totalRawScore); // / totalDataCount)*100;  
             }
             
             if(!Double.isNaN(getDoubleNumber2Decimal((gtotal)))){
                 gtotal=getDoubleNumber2Decimal((gtotal));
             }
             
             calculatedCmptVolume=gtotal;
             displayLog("Metrics: " + mdto.getMetricId() + " TotalRawScore: " + totalRawScore + " TotalDataCount: " + totalDataCount + " Calculated Value(TotalRawScore/totalDataCount): " + gtotal);
             displayLogFile3("Cmpt | " +mdto.getMetricId() + " | " + totalRawScore + " | " + calculatedCmptVolume);
             if(dto != null){
                 // normalizing the volume
                 dto.setCustCalcVolumeScale100(getNormalizedValue(calculatedCmptVolume, dto.getLowerBound(), dto.getUpperBound()));
                 displayLog("Cmpt Normalizing the volume: " + calculatedCmptVolume + " lowerBound: " + dto.getLowerBound() + 
                         " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCustCalcVolumeScale100());
             }
             
             
             
                //           displayLog("=============Group the data by actionDate============");
                //           //group the data by actionDate
                //           Map<Date, ArrayList<RawResult>> map = new HashMap<Date, ArrayList<RawResult>>();
                //           List<Date> actionDates = new ArrayList<Date>();
                //           for (RawResult rrDTO : calcCmptDtos) {
                //               Date actionDate = rrDTO.getActionDate();
                //               
                //               ArrayList<RawResult> set = null;
                //               if(map.containsKey(actionDate)){
                //                   set = map.get(actionDate);
                //                   set.add(rrDTO);
                //               } else{
                //                   set = new ArrayList<RawResult>();
                //                   set.add(rrDTO);
                //                   map.put(actionDate, set);
                //                   actionDates.add(actionDate);
                //               }   
                //           }  
                //           // Looping through the Date Group
                //           if(actionDates != null && actionDates.size() >0)
                //           {
                //               int totalDates = 0; // total number of unique date
                //               double gtotal = 0;
                //
                //               for (Date actDate : actionDates) {
                //                   
                //                   ArrayList<RawResult> rrs = map.get(actDate);
                //                   
                //                   totalDataCount=0;
                //                   totalRawScore=0;
                //                   double volume = 0;
                //                   for(RawResult rr: rrs){
                //                       if(rr.getRawScore()>=0 || rr.getTotalDataCount()>0){
                //                           totalRawScore+=rr.getRawScore();
                //                           totalDataCount+=rr.getTotalDataCount();
                //                       }
                //                   }
                //
                //                   // This is as per mail dated 7/18 requested by Wendy and nimish subject: Changes
                //                   if(mdto.getMetricDesc().toLowerCase().contains("percentage")){
                //                       if(totalDataCount == 0){
                //                           totalRawScore =0;
                //                       }else{
                //                           totalRawScore = (totalRawScore / totalDataCount)*100;    
                //                       } 
                //                   }
                //                   
                //                   if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore)))){
                //                       volume=getDoubleNumber2Decimal((totalRawScore));
                //                       gtotal += volume;
                //                       
                //                   }
                //                   displayLog(">>>actionDate: " + actDate + " CMPT Volume: " + volume);
                //                   displayLogFile2("Cmpt | " + mdto.getMetricId() + " | " + actDate + " | " + volume);
                //                   totalDates += 1;
                //               }
                //               calculatedCmptVolume=gtotal/totalDates;
                //               displayLog("Metrics: " + mdto.getMetricId() + " TotalVolume: " + gtotal + " CMPT Calculated Value(totvol/totaldates): " + calculatedCmptVolume);
                //               displayLogFile3("Cmpt | " +mdto.getMetricId() + " | " + gtotal + " | " + calculatedCmptVolume);
                //               if(dto != null){
                //                   // normalizing the volume
                //                   dto.setCmptCalcVolumeScale100(getNormalizedValue(calculatedCmptVolume, dto.getLowerBound(), dto.getUpperBound()));
                //                   displayLog("CMPT Normalizing the volume: " + calculatedCmptVolume + " lowerBound: " + dto.getLowerBound() + 
                //                           " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCmptCalcVolumeScale100());
                //
                //               }
                //           }
         }
        return calculatedCmptVolume;
    }

    private double calculateYourVolumeSELFAvg(Metrics mdto,
            ProfilePreference pdto, String fromTwitterAccountId,
            Date benchmarkStDate, Date benchmarkEdDate,
            double calculatedYourVolume,InboundMetricsDummy dto) throws SVTException {
        double totalDataCount;
        double totalRawScore;
        double totalRawScoreDC;
        displayLog("get all the SELF values between benchmarkFromDate and benchmarkToDate: " + benchmarkStDate + ":" + benchmarkEdDate +
                "metricId: " + mdto.getMetricId() + "ProfilePrefId: " + pdto.getProfilePrefrenceId() + "FromTwitterAccountId: " + 
                fromTwitterAccountId);
        // get all the SELF values between benchmarkFromDate and benchmarkToDate
         List<RawResult> calcSelfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateCALCSELF(
                 pdto.getProfilePrefrenceId(), 
                 fromTwitterAccountId,
                 mdto.getMetricId(),
                 benchmarkEdDate);

         if(calcSelfDtos != null && calcSelfDtos.size() >0)
         {
             // as per mail dated 8/17 requested by faiz, subject: Metric - Geolocation Setting - Observation
             double gtotal = 0;
             totalDataCount = 0;
             totalRawScore=0;
             totalRawScoreDC=0;
             for (RawResult rrDTO : calcSelfDtos) {
                 if(rrDTO.getRawScore()>=0 || rrDTO.getTotalDataCount()>0){
                     totalRawScore+=rrDTO.getRawScore();
                     totalDataCount+=rrDTO.getTotalDataCount();
                     totalRawScoreDC+=rrDTO.getRawScore()*rrDTO.getTotalDataCount();
                 }                 
             }
             
             // This is as per mail dated 7/18 requested by Wendy and nimish subject: Changes
             if(mdto.getCalcLogic() == 1){ // percentage
                 if(totalDataCount == 0){
                     gtotal =0;
                 }else{
                     gtotal = (totalRawScore / totalDataCount)*100;    
                 }  
             }else if(mdto.getCalcLogic() == 2){ // (rs*DC)/sum(dc)
                 if(totalDataCount == 0){
                     gtotal =0;
                 }else{
                     gtotal = (totalRawScoreDC / totalDataCount);    
                 }  
             }else{
                 gtotal = (totalRawScore); // / totalDataCount)*100;  
             }
             
             if(!Double.isNaN(getDoubleNumber2Decimal((gtotal)))){
                 gtotal=getDoubleNumber2Decimal((gtotal));
             }
             
             calculatedYourVolume=gtotal;
             displayLog("Metrics: " + mdto.getMetricId() + " TotalRawScore: " + totalRawScore + " TotalDataCount: " + totalDataCount + " Calculated Value(TotalRawScore/totalDataCount): " + gtotal);
             displayLogFile3("Self | " +mdto.getMetricId() + " | " + totalRawScore + " | " + calculatedYourVolume);
             if(dto != null){
                 // normalizing the volume
                 dto.setCustCalcVolumeScale100(getNormalizedValue(calculatedYourVolume, dto.getLowerBound(), dto.getUpperBound()));
                 displayLog("Normalizing the volume: " + calculatedYourVolume + " lowerBound: " + dto.getLowerBound() + 
                         " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCustCalcVolumeScale100());
             }
             
                    //             
                    //             
                    //             
                    //             
                    //             displayLog("=============Group the data by actionDate============");
                    //           //group the data by actionDate
                    //           Map<Date, ArrayList<RawResult>> map = new HashMap<Date, ArrayList<RawResult>>();
                    //           List<Date> actionDates = new ArrayList<Date>();
                    //           for (RawResult rrDTO : calcSelfDtos) {
                    //               Date actionDate = rrDTO.getActionDate();
                    //               
                    //               ArrayList<RawResult> set = null;
                    //               if(map.containsKey(actionDate)){
                    //                   set = map.get(actionDate);
                    //                   set.add(rrDTO);
                    //               } else{
                    //                   set = new ArrayList<RawResult>();
                    //                   set.add(rrDTO);
                    //                   map.put(actionDate, set);
                    //                   actionDates.add(actionDate);
                    //               }   
                    //           }  
                    //           // Looping through the Date Group
                    //           if(actionDates != null && actionDates.size() >0)
                    //           {
                    //               int totalDates = 0; // total number of unique date
                    //               double gtotal = 0;
                    //
                    //               for (Date actDate : actionDates) {
                    //                   
                    //                   ArrayList<RawResult> rrs = map.get(actDate);
                    //                   
                    //                   totalDataCount=0;
                    //                   totalRawScore=0;
                    //                   double volume = 0;
                    //                   for(RawResult rr: rrs){
                    //                       if(rr.getRawScore()>=0 || rr.getTotalDataCount()>0){
                    //                           totalRawScore+=rr.getRawScore();
                    //                           totalDataCount+=rr.getTotalDataCount();
                    //                       }
                    //                   }
                    //                   
                    //                   // This is as per mail dated 7/18 requested by Wendy and nimish subject: Changes
                    //                   if(mdto.getMetricDesc().toLowerCase().contains("percentage")){
                    //                       if(totalDataCount == 0){
                    //                           totalRawScore =0;
                    //                       }else{
                    //                           totalRawScore = (totalRawScore / totalDataCount)*100;    
                    //                       } 
                    //                   }
                    //
                    //                   
                    //                   if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore)))){
                    //                       volume=getDoubleNumber2Decimal((totalRawScore));
                    //                       gtotal += volume;
                    //                       
                    //                   }
                    //                   displayLog(">>>actionDate: " + actDate + " Volume: " + volume);
                    //                   displayLogFile2("Self | " + mdto.getMetricId() + " | " + actDate + " | " + volume);
                    //                   //System.out.println("Group Date........................>>>>>>>: " + actDate + " Volume: " + volume);                      
                    //                   totalDates += 1;
                    //               }
                    //               //System.out.println("For Metrics: " + mdto.getMetricId() + " GTotal: " + gtotal + " Calculated Value: " + gtotal/totalDates);               
                    //               calculatedYourVolume=gtotal/totalDates;
                    //               displayLog("Metrics: " + mdto.getMetricId() + " TotalVolume: " + gtotal + " Calculated Value(totvol/totaldates): " + calculatedYourVolume);
                    //               displayLogFile3("Self | " +mdto.getMetricId() + " | " + gtotal + " | " + calculatedYourVolume);
                    //               if(dto != null){
                    //                   // normalizing the volume
                    //                   dto.setCustCalcVolumeScale100(getNormalizedValue(calculatedYourVolume, dto.getLowerBound(), dto.getUpperBound()));
                    //                   displayLog("Normalizing the volume: " + calculatedYourVolume + " lowerBound: " + dto.getLowerBound() + 
                    //                           " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCustCalcVolumeScale100());
                    //               }
                    //           }
         }
        return calculatedYourVolume;
    }


    
private void setAlertFlameStarCount(OutboundMetricsDummy dto, double value, List<GradeMaster> performanceList) throws SVTException {
        dto.setAlertFlameCount(0);
        dto.setAlertStarCount(0);
        for(GradeMaster gmdto: performanceList){
            if(value >= gmdto.getPercentValue()){
                dto.setAlertFlameCount(gmdto.getFlameCount());
                dto.setAlertStarCount(gmdto.getStarCount());
                return;
            }
        }
        
    }

    private double nanToZero(double d) {
        if(Double.isNaN(d) || Double.isInfinite(d)){
            return 0;
        }
        return d;
    }
    
    private Double convertNANtoblank(Double doubleFormatedAsString) {
        if(Double.isNaN(doubleFormatedAsString)){
            return 0.0; 
        }
        return getDoubleNumber2Decimal(doubleFormatedAsString);
    }


    
    private double getNormalizedValue(double value, int lowerBound,
            int upperBound) {
        double returnValue=0;
        if(upperBound > lowerBound){
            value=(value>=upperBound)?(upperBound):(value);
            value=(value<=lowerBound)?(lowerBound):(value);
            returnValue=((value-lowerBound)/(upperBound - lowerBound))*100;
            return (returnValue>100)?(100):(returnValue);
        }else{
            value=(value<=upperBound)?(upperBound):(value);
            value=(value>=lowerBound)?(lowerBound):(value);
            returnValue=((value-upperBound)/(lowerBound - upperBound))*100;
            return (returnValue>100)?(100):(100-returnValue); // taking care of flip
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

    private double getTotalCatWt(List<OverallGradeDTO> listValue) {
        double value =0;
        for(OverallGradeDTO dto:listValue){
            value += dto.getOverallCategoryWt();
            displayLog(" >>>Inbound/Outbound overallCatWt: " + dto.getOverallCategoryWt());
        }
        return value;
    }

    private Date getDateWithZeroTimePart(Date date) {
        // Get Calendar object set to the date and time of the given Date object  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date); 
           
        // Set time fields to zero  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);  
          
        // Put it back in the Date object  
        return cal.getTime();
    }

    private void performOutboundMetricsRollup(List<OverallGradeDTO> listOut,
            List<OutboundMetricsDummy> dtos, int totalHandler) {
        // Overall calculation of Outbound metrics
        //group the data by overallCategory outbound
        displayLog("===============Overall calculation of Outbound metrics==================");
        Map<String, ArrayList<OutboundMetricsDummy>> mapOut = new HashMap<String, ArrayList<OutboundMetricsDummy>>();
        List<String> overallCats = new ArrayList<String>();
        
        for (OutboundMetricsDummy imDTO : dtos) {
            String catId = imDTO.getOverallCategoryId();
            ArrayList<OutboundMetricsDummy> set = null;
            if(mapOut.containsKey(catId)){
                set = mapOut.get(catId);
                set.add(imDTO);
            } else{
                set = new ArrayList<OutboundMetricsDummy>();
                set.add(imDTO);
                mapOut.put(catId, set);
                overallCats.add(catId);
             }   
        }

        // Looping through the overallCategory Outbound Group
        if(overallCats != null && overallCats.size() >0)
        {
            for (String categoryId : overallCats) {
                ArrayList<OutboundMetricsDummy> outboundMetrics = mapOut.get(categoryId);
                OverallGradeDTO osDTO = new OverallGradeDTO();
                osDTO.setOverallCategoryWt(getTotalOverallCatOutboundWt(outboundMetrics));
                
                osDTO.setOverallCategoryId(categoryId);
                osDTO.setTotalWt(getTotalWeightOut(outboundMetrics));
                displayLog(" Outbound OverallCategory Id: " + categoryId + 
                           " Total number of outboundMetrics: " +  outboundMetrics.size() +
                           " TotalOverallCatOutboundWt: " + osDTO.getOverallCategoryWt() +
                           " Total Weight Outbound: " + osDTO.getTotalWt()
                           );
                
                int total = 0; // total number of metrics
                double gtotalYourVol = 0;
                double gtotalCmptVol = 0;
                double gtotalCalcYourVol = 0;
                double gtotalCalcCmptVol = 0;

                for(OutboundMetricsDummy imd : outboundMetrics){
                    // Overall Category Volume on the scale of 100
                    gtotalYourVol += (imd.getCustVolumeScale100()*imd.getWeight())/osDTO.getTotalWt();
                    gtotalCmptVol += (imd.getCmptVolumeScale100()*imd.getWeight())/osDTO.getTotalWt();
                    total += 1;
                    
                    displayLog(" Your Volume on the scale of 100 Outbound MetricId [" + imd.getMetricId()+ "]CustVolumeScale100["+ imd.getCustVolumeScale100() + " [(CustVolScale100*weight)/TotalWt]: "  +(imd.getCustVolumeScale100()*imd.getWeight())/osDTO.getTotalWt() );
                    displayLog(" Cmpt Volume on the scale of 100 Outbound MetricId [" + imd.getMetricId()+ "] [(CmptVolScale100*weight)/TotalWt]: " + (imd.getCmptVolumeScale100()*imd.getWeight())/osDTO.getTotalWt() );
                }
                osDTO.setYourVolumeScale100(gtotalYourVol); // osDTO.setYourVolumeScale100(gtotalYourVol/total); // mail dated 4/26 from faiz
                osDTO.setCmptVolumeScale100(gtotalCmptVol); // osDTO.setCmptVolumeScale100(gtotalCmptVol/total); // mail dated 4/26 from faiz
                osDTO.setCalYourVolumeScale100(gtotalCalcYourVol); // osDTO.setCalYourVolumeScale100(gtotalCalcYourVol/total); // mail dated 4/26 from faiz
                osDTO.setCalCmptVolumeScale100(gtotalCalcCmptVol); // osDTO.setCalCmptVolumeScale100(gtotalCalcCmptVol/total); // mail dated 4/26 from faiz

                displayLog(" Outbound CategoryId " + categoryId +
                           " Total Metrics count(total): " + total +
                           " YourVolumeScale100 (gtotalYourVol/total): " + osDTO.getYourVolumeScale100() +
                           " CmptVolumeScale100 (gtotalCmptVol/total): " + osDTO.getCmptVolumeScale100() +
                           " CalcYourVolumeScale100(NA): " + osDTO.getCalYourVolumeScale100() +
                           " CalcCmptVolumeScale100(NA): " + osDTO.getCalCmptVolumeScale100());
                           
                listOut.add(osDTO);               
            }
        }
    }     
 
    private void performInboundMetricsRollup(List<OverallGradeDTO> listIn,
            List<InboundMetricsDummy> dtos, int totalHandler) {
        // Overall calculation of Inbound metrics
        //group the data by overallCategory inbound
        displayLog("===============Overall calculation of Inbound metrics==================");
        Map<String, ArrayList<InboundMetricsDummy>> mapIn = new HashMap<String, ArrayList<InboundMetricsDummy>>();
        List<String> overallCats = new ArrayList<String>();
        
        for (InboundMetricsDummy imDTO : dtos) {
            String catId = imDTO.getOverallCategoryId();
            ArrayList<InboundMetricsDummy> set = null;
            if(mapIn.containsKey(catId)){
                set = mapIn.get(catId);
                set.add(imDTO);
            } else{
                set = new ArrayList<InboundMetricsDummy>();
                set.add(imDTO);
                mapIn.put(catId, set);
                overallCats.add(catId);
             }   
        }

        // Looping through the overallCategory Inbound Group
        if(overallCats != null && overallCats.size() >0)
        {
            for (String categoryId : overallCats) {
                ArrayList<InboundMetricsDummy> inboundMetrics = mapIn.get(categoryId);
                OverallGradeDTO osDTO = new OverallGradeDTO();
                osDTO.setOverallCategoryWt(getTotalOverallCatInboundWt(inboundMetrics));
               
                
                osDTO.setOverallCategoryId(categoryId);
                osDTO.setTotalWt(getTotalWeightIn(inboundMetrics));
                
                displayLog(" Inbound OverallCategory Id: " + categoryId + 
                        " Total number of inboundMetrics: " +  inboundMetrics.size() +
                        " TotalOverallCatInboundWt: " + osDTO.getOverallCategoryWt() +
                        " Total Weight Inbound: " + osDTO.getTotalWt()
                        );
                
                int total = 0; // total number of metrics
                double gtotalYourVol = 0;
                double gtotalCmptVol = 0;
                double gtotalCalcYourVol = 0;
                double gtotalCalcCmptVol = 0;

                for(InboundMetricsDummy imd : inboundMetrics){
                    // Overall Category Volume on the scale of 100
                    gtotalYourVol += (imd.getCustVolumeScale100()*imd.getWeight())/osDTO.getTotalWt();
                    gtotalCmptVol += (imd.getCmptVolumeScale100()*imd.getWeight())/osDTO.getTotalWt();
                    gtotalCalcYourVol += (imd.getCustCalcVolumeScale100()*imd.getWeight())/osDTO.getTotalWt();
                    gtotalCalcCmptVol += (imd.getCmptCalcVolumeScale100()*imd.getWeight())/osDTO.getTotalWt();
                    total += 1;
                    displayLog(" Your Volume on the scale of 100 Inbound MetricId [" + imd.getMetricId()+ "][CustVolumeScale100: " + imd.getCustVolumeScale100() + " [(CustVolScale100*weight)/TotalWt]: "  +(imd.getCustVolumeScale100()*imd.getWeight())/osDTO.getTotalWt() );
                    displayLog(" Cmpt Volume on the scale of 100 Inbound MetricId [" + imd.getMetricId()+ "][CustVolumeScale100: " + imd.getCmptVolumeScale100() + " [(CmptVolScale100*weight)/TotalWt]: " + (imd.getCmptVolumeScale100()*imd.getWeight())/osDTO.getTotalWt() );
                }

              osDTO.setYourVolumeScale100(gtotalYourVol); // osDTO.setYourVolumeScale100(gtotalYourVol/total); // mail dated 4/26 from faiz
              osDTO.setCmptVolumeScale100(gtotalCmptVol); // osDTO.setCmptVolumeScale100(gtotalCmptVol/total); // mail dated 4/26 from faiz
              osDTO.setCalYourVolumeScale100(gtotalCalcYourVol); // osDTO.setCalYourVolumeScale100(gtotalCalcYourVol/total); // mail dated 4/26 from faiz
              osDTO.setCalCmptVolumeScale100(gtotalCalcCmptVol); // osDTO.setCalCmptVolumeScale100(gtotalCalcCmptVol/total); // mail dated 4/26 from faiz

                displayLog(" Inbound CategoryId " + categoryId +
                        " Total Metrics count(total): " + total +
                        " YourVolumeScale100 (gtotalYourVol/total): " + osDTO.getYourVolumeScale100() +
                        " CmptVolumeScale100 (gtotalCmptVol/total): " + osDTO.getCmptVolumeScale100() +
                        " CalcYourVolumeScale100(gtotalCalcYourVol/total): " + osDTO.getCalYourVolumeScale100() +
                        " CalcCmptVolumeScale100(gtotalCalcCmptVol/total): " + osDTO.getCalCmptVolumeScale100());

                listIn.add(osDTO);               
            }
        }
    }
    
    private void performSentimentGradeCalculation(
            Map<String, OverallSentimentDTO> maposDTOs,
            List<String> sentiments, List<InboundMetricsDummy> dtos,
            List<GradeMaster> sentimentGradeList, int totalHandler) throws SVTException {
        // Sentiment calculation
////////////////////////////////////////////////////////
        displayLog("Master Data GradeMaster(Sentiment) >>");
        for(GradeMaster p: sentimentGradeList){
            displayLog("PercentageValue: " + p.getPercentValue() + " GradeValue: " + p.getGradeValue());
        }
        
        displayLog("===============Overall calculation of Inbound metrics (Group by Sentiment) ==================");
        //group the data by sentiment
        Map<String, ArrayList<InboundMetricsDummy>> map = new HashMap<String, ArrayList<InboundMetricsDummy>>();
        for (InboundMetricsDummy imDTO : dtos) {
            String catId = imDTO.getCategoryId();
            ArrayList<InboundMetricsDummy> set = null;
            if(map.containsKey(catId)){
                set = map.get(catId);
                set.add(imDTO);
            } else{
                set = new ArrayList<InboundMetricsDummy>();
                set.add(imDTO);
                map.put(catId, set);
                sentiments.add(catId);
             }   
        }
        // Looping through the sentiment Group
        if(sentiments != null && sentiments.size() >0)
        {
            for (String categoryId : sentiments) {
                ArrayList<InboundMetricsDummy> inboundMetrics = map.get(categoryId);
                
                OverallSentimentDTO osDTO = new OverallSentimentDTO();
                osDTO.setSentimentId(categoryId);
                osDTO.setTotalSIWt(getTotalSIWt(inboundMetrics));

                displayLog(" Category Id: " + categoryId + 
                        " Total number of inboundMetrics: " +  inboundMetrics.size() +
                        " Total Weight Inbound: " + osDTO.getTotalSIWt()
                        );
                if(categoryId.equalsIgnoreCase("5")){
                    System.out.println( "Total number of inboundMetrics(Engagement):"  + inboundMetrics.size() + 
                                        " Total Weight Inbound: "+ osDTO.getTotalSIWt());
                }
                if(categoryId.equalsIgnoreCase("9")){
                    System.out.println( "Total number of inboundMetrics(Conversion):"  + inboundMetrics.size() + 
                                        " Total Weight Inbound: "+ osDTO.getTotalSIWt());
                }
                
                int total = 0; // total number of metrics
                double totalSIWt = osDTO.getTotalSIWt(); // sum of SI Weight for a category
                double gtotalSiYourVolScale5 = 0;
                double gtotalSiCmptVolScale5 = 0;
                double gtotalSiYourVol = 0;
                double gtotalSiCmptVol = 0;
                double gtotalSiCalcYourVol = 0;
                double gtotalSiCalcCmptVol = 0;

                for(InboundMetricsDummy imd : inboundMetrics){
                    // SI Volume on the scale of 100
                    gtotalSiYourVol += (imd.getCustVolumeScale100()*imd.getSiWt())/osDTO.getTotalSIWt();
                    gtotalSiCmptVol += (imd.getCmptVolumeScale100()*imd.getSiWt())/osDTO.getTotalSIWt();
                    gtotalSiCalcYourVol += (imd.getCustCalcVolumeScale100()*imd.getSiWt())/osDTO.getTotalSIWt();
                    gtotalSiCalcCmptVol += (imd.getCmptCalcVolumeScale100()*imd.getSiWt())/osDTO.getTotalSIWt();
                    total += 1;
                    gtotalSiYourVolScale5 += ((imd.getCustVolumeScale100()*5)/100)*imd.getSiWt();
                    gtotalSiCmptVolScale5 += ((imd.getCmptVolumeScale100()*5)/100)*imd.getSiWt();
                    
                    displayLog(" SI Your Volume on the scale of 100 MetricId [" + imd.getMetricId()+ "] CustVolScale100[" + imd.getCustVolumeScale100() + "][(CustVolScale100*SiWt)/TotalWt]: "  +(imd.getCustVolumeScale100()*imd.getSiWt())/osDTO.getTotalSIWt() );
                    displayLog(" SI Cmpt Volume on the scale of 100 MetricId [" + imd.getMetricId()+ "] CmptVolScale100[" + imd.getCmptVolumeScale100() + "][(CmptVolScale100*SiWt)/TotalWt]: " + (imd.getCmptVolumeScale100()*imd.getSiWt())/osDTO.getTotalSIWt() );
                    displayLog(" SI Calc Your Volume on the scale of 100 MetricId [" + imd.getMetricId()+ "] CustCalcVolScale100[" + imd.getCustCalcVolumeScale100() + "][(CustCalcVolScale100*SiWt)/TotalWt]: "  +(imd.getCustCalcVolumeScale100()*imd.getSiWt())/osDTO.getTotalSIWt() );
                    displayLog(" SI Calc Cmpt Volume on the scale of 100 MetricId [" + imd.getMetricId()+ "] CmptCalcVolScale100[" + imd.getCmptCalcVolumeScale100() + "][(CmptCalcVolScale100*SiWt)/TotalWt]: " + (imd.getCmptCalcVolumeScale100()*imd.getSiWt())/osDTO.getTotalSIWt() );

                    if(categoryId.equalsIgnoreCase("5")){
                        System.out.println("|Engagement|" + imd.getMetricId() + "|" + imd.getSiWt() + "|" + imd.getLowerBound() + "|" + imd.getUpperBound() + "|" + imd.getCustVolume() + "|" + imd.getCustVolumeScale100());
                    }
                    if(categoryId.equalsIgnoreCase("9")){
                        System.out.println("|Conversion|" + imd.getMetricId() + "|" + imd.getSiWt() + "|" + imd.getLowerBound() + "|" + imd.getUpperBound() + "|" + imd.getCustVolume() + "|" + imd.getCustVolumeScale100());
                    }
                
                }
//                osDTO.setSiYourVolumeScale100(gtotalSiYourVol/total);
//                osDTO.setSiCmptVolumeScale100(gtotalSiCmptVol/total);
                osDTO.setSiYourVolumeScale100((gtotalSiYourVolScale5/totalSIWt)*20);
                osDTO.setSiCmptVolumeScale100((gtotalSiCmptVolScale5/totalSIWt)*20);
                
                osDTO.setSiCalYourVolumeScale100(gtotalSiCalcYourVol/total);
                osDTO.setSiCalCmptVolumeScale100(gtotalSiCalcCmptVol/total);
                
                if(categoryId.equalsIgnoreCase("5")){
                    System.out.println("Engagement Grade: " + gtotalSiYourVolScale5 + " TotalSIWt:" + totalSIWt + " >>" + (gtotalSiYourVolScale5/totalSIWt)*20);
                }
                if(categoryId.equalsIgnoreCase("9")){
                    System.out.println("Conversion Grade: " + gtotalSiYourVolScale5 + " TotalSIWt:" + totalSIWt + " >>" + (gtotalSiYourVolScale5/totalSIWt)*20);
                }
                /**
                 * Before sending the volume to get the grade, needs to multiple by "total number of handler", if you are calculating for 
                 * specific twitterhandler
                 * As Per Faiz request date July 14th 2011
                 * 
                 * When displaying overall grades at the handle level, they are not intuitive and consistent with the client level.  
                    For example, five handles had overall grades of

                    D, C-, C, C+, B-

                    Yet the client level score was B, which is higher than any of the underlying handle grades.  The user would 
                    expect the overall to be somewhere in the middle of all the handles.  This disconnect occurs because the client 
                    level (correctly) sums the data of all the handles.
                    
                    To continue the example, suppose a volume of 34 rates a client level B above, and is composed of five handles 
                    with the volumes of 0, 3, 5, 11 and 15, respectively.  Currently, each of the handles would get a grade much less than B. 
                    
                    Solution:  Keep the client level calculation the way it is and adjust the calculations for the handles.  
                    This can be done by multiplying each of the values by the number of handles, in this case 5.  
                    So the volumes in this example would be 0, 15, 25, 55 and 75.  The grades associated with this 
                    data would the correctly span a range below and above the client level B.
                 * 
                 */                
                if(totalHandler > 0){
                    osDTO.setSiOverallGradeSELF(getOverallGrade((osDTO.getSiYourVolumeScale100() * totalHandler), sentimentGradeList));
                    osDTO.setSiOverallGradeCMPT(getOverallGrade(osDTO.getSiCmptVolumeScale100(), sentimentGradeList));                    
                }else{
                    osDTO.setSiOverallGradeSELF(getOverallGrade(osDTO.getSiYourVolumeScale100(), sentimentGradeList));
                    osDTO.setSiOverallGradeCMPT(getOverallGrade(osDTO.getSiCmptVolumeScale100(), sentimentGradeList));                    
                }
                
                displayLog(" Subrato Inbound > CategoryId " + categoryId +
                        " Total Metrics count(total): " + total +
                        " SIYourVolumeScale100 (gtotalSiCalcYourVol/total)(Imp): " + osDTO.getSiYourVolumeScale100() +
                        " SICmptVolumeScale100 (gtotalSiCmptVol/total)(Imp): " + osDTO.getSiCmptVolumeScale100() +
                        " CalcSIYourVolumeScale100(gtotalSiCalcYourVol/total): " + osDTO.getSiCalYourVolumeScale100() +
                        " CalcSICmptVolumeScale100(gtotalSiCalcCmptVol/total): " + osDTO.getSiCalCmptVolumeScale100() +
                        " SI OverallGradeSELF: " + osDTO.getSiOverallGradeSELF() +
                        " SI OverallGradeCMPT: " + osDTO.getSiOverallGradeCMPT()) ;

                maposDTOs.put(categoryId, osDTO);               
            }
        }
    }
    
    private String getOverallGrade(double piValue, List<GradeMaster> performanceList) throws SVTException {
        for(GradeMaster gmdto: performanceList){
            if(piValue >= gmdto.getPercentValue()){
                return gmdto.getGradeValue();
            }
        }
       return ""; 
    }
    
    
    private double getTotalSIWt(ArrayList<InboundMetricsDummy> inboundMetrics) {
        double totalSIWt =0;
        for(InboundMetricsDummy imd : inboundMetrics){
            totalSIWt += imd.getSiWt();
            displayLog(" >>>SI Inbound metricsId: " + imd.getMetricId() + " SIWt: " + imd.getSiWt());
        }
        return totalSIWt;
    }

    private double getTotalWeightIn(ArrayList<InboundMetricsDummy> inboundMetrics) {
        double totalWt =0;
        for(InboundMetricsDummy imd : inboundMetrics){
            totalWt += imd.getWeight();
            displayLog(" >>>Inbound metricsId: " + imd.getMetricId() + " Weight: " + imd.getWeight());
        }
        return totalWt;
    }

    private double getTotalWeightOut(ArrayList<OutboundMetricsDummy> outboundMetrics) {
        double totalWt =0;
        for(OutboundMetricsDummy imd : outboundMetrics){
            totalWt += imd.getWeight();
            displayLog(" >>>Outbound metricsId: " + imd.getMetricId() + " Weight: " + imd.getWeight());
        }
        return totalWt;
    }

    private double getTotalOverallCatInboundWt(ArrayList<InboundMetricsDummy> inboundMetrics) {
        // Since all the inbound points to same category, and wt is stored in category level, so it will be same for everyone, lets take the 1st one.
        double totalWt =0;
        if(inboundMetrics != null && inboundMetrics.size() > 0){
            return inboundMetrics.iterator().next().getOverallCategoryWt();
        }
            return totalWt;
    }

    private double getTotalOverallCatOutboundWt(ArrayList<OutboundMetricsDummy> outboundMetrics) {
        // Since all the outbound points to same category, and wt is stored in category level, so it will be same for everyone, lets take the 1st one.
        double totalWt =0;
        if(outboundMetrics != null && outboundMetrics.size() > 0){
            return outboundMetrics.iterator().next().getOverallCategoryWt();
        }
            return totalWt;
    }    
 

    private int daysbetweenCurrentDateMin(Date minActionDate) {
        if(minActionDate == null){
            return 0;
        }
        return DateUtil.getTimeAgoDays(minActionDate) + 2;
    }

    private int daysbetweenCurrentDateMax(Date maxActionDate) {
        if(maxActionDate == null){
            return 0;
        }
        int rvalue = DateUtil.getTimeAgoDays(maxActionDate);
        //int rvalue = DateUtil.getTimeAgoDays(maxActionDate) + 1;
        if(maxActionDate.getTime() < System.currentTimeMillis()){
           return -1 * rvalue; 
        }
        return rvalue;        
    }
    

    private Date getPreviousDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        // Set time fields to zero  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);
        //SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return cal.getTime();        
    }
    
    private Date getDateBefore(Date date1, Date date, int days) {
        if(date == null){
            return date1;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        // Set time fields to zero  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);
        //SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return cal.getTime();        
    }
    
    public Date getMaxActionDate(String profileId) throws SVTException {
        Date maxDate= getDaoProvider().getMsgDataCreationLogDAO().getMaxActionDate(profileId);
        if(maxDate != null){
            return maxDate;
        }
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        // Set time fields to zero  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);
        //SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return cal.getTime();        
        //return new Date(); getDaoProvider().getRawResultDAO().getMaxActionDate(profileId);
    }

    public Date getMinActionDate(String profileId) throws SVTException {
        Date minDate= getDaoProvider().getMsgDataCreationLogDAO().getMinActionDate(profileId);
        if(minDate != null){
            return minDate;
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
        //return getDaoProvider().getRawResultDAO().getMinActionDate(profileId);





    }

    private void setDtoBlank(OutboundMetricsDummy dto) {
        dto.setCustVolume("0");
        dto.setCmptVolume("0");
        dto.setDataProcessed(false);
        dto.setCustVolumeScale100(0);
        dto.setCmptVolumeScale100(0);
        dto.setCustTargetRaw("0");
        dto.setCustTarget("0");
    }

    private void setDtoBlank(InboundMetricsDummy dto) {
        dto.setCustVolume("0");
        dto.setCmptVolume("0");
        dto.setDataProcessed(false);
        dto.setCustVolumeScale100(0);
        dto.setCmptVolumeScale100(0);
        dto.setCustTargetRaw("0");
        dto.setCustTarget("0");
    }

    private List<OutboundMetricsDummy> getOutboundMetricsCached(
            Date asOfPerformanceDate, ProfilePreference pdto,
            String fromTwitterAccountId, Date benchmarkStDate,
            Date benchmarkEdDate, ImprovementLevel target,
            List<OverallGradeDTO> listOut, int totalHandler) throws SVTException {
            
       long delayinSeconds = getDaoProvider().getParameterDAO().getDelayInSeconds();
        
        
            String fromProfileUserId = null;
            String targetId = null;
            if(pdto != null){
                fromProfileUserId = pdto.getProfileUserId(); 
            }
            if(target != null){
                targetId = target.getImprovementLevelId();
            }
        
        String mapKey = getMapKey(asOfPerformanceDate,
                fromProfileUserId, fromTwitterAccountId,
                benchmarkStDate, benchmarkEdDate, targetId);
        
        CachedOutboundDTO dto = mapOutboundMetricsDummyDTO.get(mapKey);
        if(dto != null && ((System.currentTimeMillis() - dto.getDelayPeriod()) < (delayinSeconds *1000) )){
            System.out.println("Outbound Cached data........[" + (System.currentTimeMillis() + "-" +  dto.getDelayPeriod()) + "]......................Key["+ mapKey + "]");
            return dto.getDtos();
        }
        dto = new CachedOutboundDTO();
        dto.setDelayPeriod(System.currentTimeMillis());
        dto.setDtos(getOutboundMetrics(asOfPerformanceDate,pdto, fromTwitterAccountId,benchmarkStDate,benchmarkEdDate,target, listOut, totalHandler));
        mapOutboundMetricsDummyDTO.put(mapKey, dto);
        return dto.getDtos();
    }

    private String getMapKey(Date asOfPerformanceDate,
            String fromProfileUserId, String fromTwitterAccountId,
            Date benchmarkStDate, Date benchmarkEdDate, String targetId) {
        String keyValue = "";
        if(asOfPerformanceDate != null){
            keyValue = getYYYYMMDD(asOfPerformanceDate);
        }
        if(fromProfileUserId != null){
            keyValue += fromProfileUserId;
        }
        if(fromTwitterAccountId != null){
            keyValue += fromTwitterAccountId;  
        }
//        if(benchmarkStDate != null){
//            keyValue += getYYYYMMDD(benchmarkStDate);  
//        }
        if(benchmarkEdDate != null){
            keyValue += getYYYYMMDD(benchmarkEdDate);  
        }
        if(targetId != null){
            keyValue += targetId;  
        }
        return keyValue;
    }


    private String getYYYYMMDD(Date date) {       
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR) + "" + (cal.get(Calendar.MONTH) + 1) + "" + cal.get(Calendar.DATE);
    }

//  private void closeLogToFile() {
//      try {
//          out.close();
//          out1.close();
//          out2.close();
//          out3.close();
//      } catch (IOException e) {
//          // TODO Auto-generated catch block
//          e.printStackTrace();
//      }
//  }

//  private void logToFile() {
//      try {
//          fstream = new FileWriter("D:\\workspace\\Soais\\log.txt");
//          fstream1 = new FileWriter("D:\\workspace\\Soais\\log1.txt");
//          fstream2 = new FileWriter("D:\\workspace\\Soais\\log2.txt");
//          fstream3 = new FileWriter("D:\\workspace\\Soais\\log3.txt");
//          
//          out = new BufferedWriter(fstream);
//          out1 = new BufferedWriter(fstream1);
//          out2 = new BufferedWriter(fstream2);
//          out3 = new BufferedWriter(fstream3);            
//      } catch (IOException e) {
//          // TODO Auto-generated catch block
//          e.printStackTrace();
//      }
//  }

//  private void logToFileNullCheck() {
//  try {
//      if(out == null){
//          fstream = new FileWriter("D:\\workspace\\Soais\\log.txt");
//          fstream1 = new FileWriter("D:\\workspace\\Soais\\log1.txt");
//          fstream2 = new FileWriter("D:\\workspace\\Soais\\log2.txt");
//          fstream3 = new FileWriter("D:\\workspace\\Soais\\log3.txt");
//          
//          out = new BufferedWriter(fstream);
//          out1 = new BufferedWriter(fstream1);
//          out2 = new BufferedWriter(fstream2);
//          out3 = new BufferedWriter(fstream3);            
//
//      }
//  } catch (IOException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//  }
//}

  private void displayLogFile(String string) {
//  try {
//      //out.write(string + "\n");
//  } catch (IOException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//  }
  
}

private void displayLogFile1(String string) {
//  try {
//      out1.write(string + "\n");
//  } catch (IOException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//  }
  
}

private void displayLogFile2(String string) {
//  try {
//      out2.write(string + "\n");
//  } catch (IOException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//  }
//  
}

private void displayLogFile3(String string) {
//  try {
//      out3.write(string + "\n");
//  } catch (IOException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//  }
//  
}

    public Date getDate(Date date, int days, String mode){
        if(date == null){
            date = getCurrentDate();
        }
        if(mode.equalsIgnoreCase("2")){ // weekly
            days = days * 7;
        }else if(mode.equalsIgnoreCase("3")){ // monthly
            days = days * 30;
        }
        long backDateMS = date.getTime() - ((long)days) *24*60*60*1000;  
        Date backDate = new Date();  
        backDate.setTime(backDateMS);
        return backDate;
    }

    /**
     * Since alertMessage is not finalized so this is Temporary solution
     * @param dto
     * @param selfDtos
     */
    private void setAlertMessage(OutboundMetricsDummy dto, List<RawResult> selfDtos) {

        // Logic implemented as per mail dated 9/7 from Faiz, subject: "Alerts calcs"
        // For counts (e.g., number of tweets ...) it would be the difference between the target and the current
        // For  For percentages (e.g., percent of tweets that ...) it would also be the simple difference in percents, not a change in percents.
        // = max(0, target% - current%)        
        
        AlertPopupDTO adto = new AlertPopupDTO();
        
        String metricsId = dto.getMetricId();
        //System.out.println("MetricsName: [" + metricsName +"]");
        Double custTarget = (dto.getCustTargetRaw() != null)?(Double.parseDouble(dto.getCustTargetRaw())):(0);
        Double cmptVolume = (dto.getCmptVolume() != null)?(Double.parseDouble(dto.getCmptVolume())):(0);
        Double custVolume = (dto.getCustVolume() != null)?(Double.parseDouble(dto.getCustVolume())):(0);
        
        if(custVolume < custTarget){
            int intCounts = Double.valueOf(getDoubleNumber0Decimal((custTarget-custVolume))).intValue();
            int intPctCounts = Double.valueOf(getMaxValue(0, (custTarget - custVolume))).intValue();
            String counts = "" + intCounts;
            String pctCounts = "" + intPctCounts;
            
            String twitterhandler="";
            List<String> twitterHandlers = new ArrayList<String>();  // required for popup window
            int totalfriend=0;
            for(RawResult rr: selfDtos){
                if(rr.getRawScore()>=0 && (rr.getRawScore() < rr.getTotalDataCount())){
                    twitterhandler += "@" + rr.getTwitterAccount().getTwitterUsername() + ",";
                    totalfriend += rr.getTotalDataCount() - rr.getRawScore();
                    twitterHandlers.add(rr.getTwitterAccount().getTwitterUsername());
                }
            }
            if(twitterhandler.length() > 1 && twitterhandler.endsWith(",")){
                twitterhandler = twitterhandler.substring(0, twitterhandler.length() - 1); 
            }
            if(twitterhandler.length()==0){
                return; // this alert message depends on custTarget and custTarget depends on benchmarkDate, so somehow it is not matching the logic
            }
            
            if(dto.getCalcLogic() == 0){// count metrics
                if(metricsId.equalsIgnoreCase("4")){ //Hashtags per Tweet
                    dto.setAlertMessage("You need to increase the number of times you include a hashtag in your tweets by " + counts + ".");
                }else if(metricsId.equalsIgnoreCase("6")){ //Lists
                    dto.setAlertMessage("You need to increase the number of lists you have to segment your followers by " + counts + ".");
                }else if(metricsId.equalsIgnoreCase("7")){ //Favorites
                    dto.setAlertMessage("You need to increase the number tweets you favorite by " + counts + ".");
                }else if(metricsId.equalsIgnoreCase("8")){ //Tweets per Week
                    dto.setAlertMessage("You need to increase the average tweets you make per week by " + counts + ".");
                }else if(metricsId.equalsIgnoreCase("13")){ //Following
                    dto.setAlertMessage("You need to increase the number of Twitter profiles you follow by " + counts + ".");
                }else if(metricsId.equalsIgnoreCase("20")){ //Tweets
                    dto.setAlertMessage("You need to increase the number of tweets you make per day by " + counts + ".");
                }else if(metricsId.equalsIgnoreCase("23")){ //Saved Searches
                    dto.setAlertMessage("You need to increase the number of saved searches in your profile(s) by " + counts + "."); 
                }else if(metricsId.equalsIgnoreCase("24")){ //Brand Mentions
                    dto.setAlertMessage("You need to increase the number of times you mention your targeted brand keywords in your tweets by " + counts + ".");
                }else if(metricsId.equalsIgnoreCase("25")){ //Product Mentions
                    dto.setAlertMessage("You need to increase the number of times you mention your targeted product keywords in your tweets by " + counts + ".");
                }else if(metricsId.equalsIgnoreCase("26")){ //Industry Mentions
                    dto.setAlertMessage("You need to increase the number of times you mention your targeted industry keywords in your tweets by " + counts + ".");
                }else if(metricsId.equalsIgnoreCase("36")){ //Influencer Outreaches
                    dto.setAlertMessage("You need to increase the number of tweets that reference influencers by " + counts + ".");
                }
            }else if(dto.getCalcLogic() == 1){// percentage
                 if(metricsId.equalsIgnoreCase("1")){ //Completed Bio(s)
                     dto.setAlertMessage("You need to complete a bio for " + twitterHandlers.size()  + " Twitter profiles.");
                     dto.setAlertMessageHandlers(twitterHandlers);
                }else if(metricsId.equalsIgnoreCase("2")){ //Custom Background Image(s)
                    dto.setAlertMessage("You need to add a custom background image to " + twitterHandlers.size()  + " of your Twitter profiles.");
                    dto.setAlertMessageHandlers(twitterHandlers);
                }else if(metricsId.equalsIgnoreCase("3")){ //Geolocation Setting
                    dto.setAlertMessage("You need to increase the percentage of tweets that use a geolocation setting by " + pctCounts + "%.");
                    dto.setAlertMessageHandlers(twitterHandlers);
                }else if(metricsId.equalsIgnoreCase("5")){ //Profile Image(s)
                    dto.setAlertMessage("You need to add a profile image to " + twitterHandlers.size()  + " handle(s).");
                    dto.setAlertMessageHandlers(twitterHandlers);
                }else if(metricsId.equalsIgnoreCase("10")){ //RT (Retweets)
                    dto.setAlertMessage("You need to increase the percentage of times you RT (Retweet) tweets by " + pctCounts + "%.");
                }else if(metricsId.equalsIgnoreCase("11")){ //Shortened URLs per tweet
                    dto.setAlertMessage("You need to increase the percentage of times you include a shortened url in your tweets by " + pctCounts + "%.");
                }else if(metricsId.equalsIgnoreCase("12")){ //@References
                    dto.setAlertMessage("You need to increase the percentage of tweets that you reply to by " + pctCounts + "%.");
                }else if(metricsId.equalsIgnoreCase("17")){ //Following Listed
                    dto.setAlertMessage("You need to increase the percentage of followers you list in your profile(s) by " + pctCounts + "%.");
                }else if(metricsId.equalsIgnoreCase("29")){ //US Profile References
                    dto.setAlertMessage("You need to increase the percentage of foreign Twitter profiles you reference in your tweets by " + pctCounts + "%.");  
                }else if(metricsId.equalsIgnoreCase("30")){ //Foreign Profile References
                    dto.setAlertMessage("You need to increase the percentage of foreign Twitter profiles you reference in your tweets by " + pctCounts + "%.");  
                }else if(metricsId.equalsIgnoreCase("37")){ //Evangelist Engagement
                    dto.setAlertMessage("You need to increase the percentage of evangelist followers by " + pctCounts + "%."); 
                }else if(metricsId.equalsIgnoreCase("39")){ //Neutral or Positive Sentiment Generation
                    dto.setAlertMessage("You need to increase the percentage your tweets that are positive or neutral in sentiment by " + pctCounts + "%.");  
                }else if(metricsId.equalsIgnoreCase("40")){ //Negative Sentiment Generation
                    dto.setAlertMessage("You need to decrease the percentage your tweets that are negative in sentiment by " + pctCounts + "%.");
                }else if(metricsId.equalsIgnoreCase("41")){ //Positive Sentiment Generation
                    dto.setAlertMessage("You need to increase the percentage your tweets that are positive in sentiment by " + pctCounts + "%.");
                }else if(metricsId.equalsIgnoreCase("42")){ //Operative Engagement
                    dto.setAlertMessage("You need to increase the percentage of operative followers by " + pctCounts + "%.");
                }else if(metricsId.equalsIgnoreCase("43")){ //Engrossed Engagement
                    dto.setAlertMessage("You need to increase the percentage of engrossed followers by " + pctCounts + "%."); 
                }else if(metricsId.equalsIgnoreCase("91")){ //Top Trending Themes
                    dto.setAlertMessage("You need to increase the number of followers with operative engagement by " + pctCounts + "."); 
                }
            }else if(dto.getCalcLogic() == 2){// (rs*DC)/sum(dc).... not clear???????
                if(metricsId.equalsIgnoreCase("38")){ //Influence
                    dto.setAlertMessage("You need to increase the number of followers with operative engagement by " + counts + ".");  
                }
            }
        }
        
//        String x = "" + getDoubleNumber2Decimal((cmptVolume-custTarget));
//
//        if( custTarget < cmptVolume){
//            String twitterhandler="";
//            List<String> twitterHandlers = new ArrayList<String>();  // required for popup window
//            int totalfriend=0;
//            for(RawResult rr: selfDtos){
//                if(rr.getRawScore()>=0 && (rr.getRawScore() < rr.getTotalDataCount())){
//                    twitterhandler += "@" + rr.getTwitterAccount().getTwitterUsername() + ",";
//                    totalfriend += rr.getTotalDataCount() - rr.getRawScore();
//                    twitterHandlers.add(rr.getTwitterAccount().getTwitterUsername());
//                }
//            }
//            if(twitterhandler.length() > 1 && twitterhandler.endsWith(",")){
//                twitterhandler = twitterhandler.substring(0, twitterhandler.length() - 1); 
//            }
//            if(twitterhandler.length()==0){
//                return; // this alert message depends on custTarget and custTarget depends on benchmarkDate, so somehow it is not matching the logic
//            }
//            if(metricsId.equalsIgnoreCase("2")){ //2
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Your " + twitterhandler + " is missing a background image.");
//                    dto.setAlertMessage("Your @twitterhandle is missing a background image.");
//                    dto.setAlertMessageHandlers(twitterHandlers);
//                }
//            }else if(metricsId.equalsIgnoreCase("1")){ //1
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Your " + twitterhandler + " is missing a bio.");
//                    dto.setAlertMessage("Your @twitterhandle is missing a bio.");
//                    dto.setAlertMessageHandlers(twitterHandlers);
//                    //dto.getAlertMessageDTO().setTitleBarText("Missing Profile Bio");
//                    //dto.getAlertMessageDTO().setJspPageToDisplay("alertMissingBio.jsp");
//                 } 
//            }else if(metricsId.equalsIgnoreCase("5")){ //5
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Your " + twitterhandler + " is missing a picture.");
//                    dto.setAlertMessage("Your @twitterhandle is missing a picture.");
//                    dto.setAlertMessageHandlers(twitterHandlers);
//                    //dto.getAlertMessageDTO().setTitleBarText("Missing Profile Picture");
//                    //dto.getAlertMessageDTO().setJspPageToDisplay("alertMissingProfilePics.jsp");
//                } 
//            }else if(metricsId.equalsIgnoreCase("3")){ //3
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Geo-location has not been set for " + twitterhandler + ". If you do not require geo-location functionality, you may turn it off.");
//                    dto.setAlertMessage("Geo-location has not been set for @twitterhandle. If you do not require geo-location functionality, you may turn it off.");
//                    dto.setAlertMessageHandlers(twitterHandlers);
//                }
//            }else if(metricsId.equalsIgnoreCase("17")){ //17
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Your " + twitterhandler + " has " + totalfriend + " friends that have not been listed."); // x needs to be calculated
//                    dto.setAlertMessage("Your @twitterhandle has " + totalfriend + " friends that have not been listed."); // x needs to be calculated
//                } 
//            }else if(metricsId.equalsIgnoreCase("6")){ //6
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to add " + totalfriend + " lists."); // x needs to be calculated
//                    dto.setAlertMessage("Your @twitterhandle needs to add " + totalfriend + " lists."); // x needs to be calculated
//                }
//            }else if(metricsId.equalsIgnoreCase("7")){ //7
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Your " + twitterhandler + " has " + totalfriend + " tweets to favorite."); // x needs to be calculated
//                    dto.setAlertMessage("Your @twitterhandle has " + totalfriend + " tweets to favorite."); // x needs to be calculated
//                }
//            }else if(metricsId.equalsIgnoreCase("18")){ //18
//                if( custTarget < 100){
//                    dto.setAlertMessage("");
//                }
//            }else if(metricsId.equalsIgnoreCase("19")){ //19
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Your " + twitterhandler + " has the following direct messages (DMs) to return.");
//                    dto.setAlertMessage("Your @twitterhandle has the following direct messages (DMs) to return.");
//                }
//            }else if(metricsId.equalsIgnoreCase("4")){ //4
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase the number of hashtags it references by " + x + "."); // x needs to be calculated
//                    dto.setAlertMessage("Your @twitterhandle needs to increase the number of hashtags it references by " + x + "."); // x needs to be calculated
//                }
//            }else if(metricsId.equalsIgnoreCase("8")){ //8
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase its weekly twitter activity by " + x + "."); // x needs to be calculated
//                    dto.setAlertMessage("Your @twitterhandle needs to increase its weekly twitter activity by " + x + "."); // x needs to be calculated
//                }
//            }else if(metricsId.equalsIgnoreCase("20")){ //20
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase its daily twitter activity by " + x + "."); //
//                    dto.setAlertMessage("Your @twitterhandle needs to increase its daily twitter activity by " + x + "."); //
//                }
//            }else if(metricsId.equalsIgnoreCase("73")){ //73
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase retweeting activity by " + x + "."); //
//                    dto.setAlertMessage("Your @twitterhandle needs to increase retweeting activity by " + x + "."); //
//                }
//            }else if(metricsId.equalsIgnoreCase("11")){ //11
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase the number of bit.ly reference activity by " + x + "."); //
//                    dto.setAlertMessage("Your @twitterhandle needs to increase the number of bit.ly reference activity by " + x + "."); //
//                }
//            }else if(metricsId.equalsIgnoreCase("12")){ //12
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase the number of @ reference activity by " + x + "."); //
//                    dto.setAlertMessage("Your @twitterhandle needs to increase the number of @ reference activity by " + x + "."); //
//                }
//            }else if(metricsId.equalsIgnoreCase("21")){ //21
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase the number of hashtag reference activity by " + x + ".");//
//                    dto.setAlertMessage("Your @twitterhandle needs to increase the number of hashtag reference activity by " + x + ".");//
//                }
//            }else if(metricsId.equalsIgnoreCase("19")){ //19
//                if( custTarget < 100){ 
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase the number of DMs to friends by  " + totalfriend + " ."); //
//                    dto.setAlertMessage("Your @twitterhandle needs to increase the number of DMs to friends by  " + totalfriend + " ."); //
//                }
//            }else if(metricsId.equalsIgnoreCase("23")){ //23
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase the number of Saved Searches by  " + totalfriend + " ."); //
//                    dto.setAlertMessage("Your @twitterhandle needs to increase the number of Saved Searches by  " + totalfriend + " ."); //
//                }
//            }else if(metricsId.equalsIgnoreCase("24")){ //24
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase the number of brand keyword mentions by " + x + "."); //
//                    dto.setAlertMessage("Your @twitterhandle needs to increase the number of brand keyword mentions by " + x + "."); //
//                }
//            }else if(metricsId.equalsIgnoreCase("25")){ //25
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase the number of product keyword mentions by " + x + ".");
//                    dto.setAlertMessage("Your @twitterhandle needs to increase the number of product keyword mentions by " + x + ".");
//                }
//            }else if(metricsId.equalsIgnoreCase("26")){ //26
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase the number of industry keyword mentions by " + x + ".");
//                    dto.setAlertMessage("Your @twitterhandle needs to increase the number of industry keyword mentions by " + x + ".");
//                }
//            }else if(metricsId.equalsIgnoreCase("13")){ //13
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Your " + twitterhandler + " has X influencers to follow.");
//                    dto.setAlertMessage("Your @twitterhandle has X influencers to follow.");
//                }
//            
//            }else if(metricsId.equalsIgnoreCase("27")){ //27
//                if( custTarget < 100){
//                    dto.setAlertMessage("");
//                }
//            }else if(metricsId.equalsIgnoreCase("36")){ //36
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase the number of tweets made to influencers by " + x + ".");
//                    dto.setAlertMessage("Your @twitterhandle needs to increase the number of tweets made to influencers by " + x + ".");
//                }
//            }else if(metricsId.equalsIgnoreCase("37")){ //37
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Your " + twitterhandler + " has X influencers to follow.");
//                    dto.setAlertMessage("Your @twitterhandle has X influencers to follow.");
//                }
//            }else if(metricsId.equalsIgnoreCase("38")){ //38
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Your " + twitterhandler + " has X influencers to follow.");
//                    dto.setAlertMessage("Your @twitterhandle has X influencers to follow.");
//                }
//            }else if(metricsId.equalsIgnoreCase("39")){ //39
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase the number of neutral or positive tweets by " + x + ".");
//                    dto.setAlertMessage("Your @twitterhandle needs to increase the number of neutral or positive tweets by " + x + ".");
//                }
//            }else if(metricsId.equalsIgnoreCase("40")){ //40
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to lower the number of positive tweets by " + x + ".");
//                    dto.setAlertMessage("Your @twitterhandle needs to lower the number of positive tweets by " + x + ".");
//                }
//            }else if(metricsId.equalsIgnoreCase("41")){ //41
//                if( custTarget < cmptVolume){
//                    //dto.setAlertMessage("Your " + twitterhandler + " needs to increase the number of positive tweets by " + x + ".");
//                    dto.setAlertMessage("Your @twitterhandle needs to increase the number of positive tweets by " + x + ".");
//                }
//            }else if(metricsId.equalsIgnoreCase("42")){ //42
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Your " + twitterhandler + " has  " + totalfriend + "  influencers to follow.");
//                    dto.setAlertMessage("Your @twitterhandle has  " + totalfriend + "  influencers to follow.");
//                }
//            }else if(metricsId.equalsIgnoreCase("43")){ //43
//                if( custTarget < 100){
//                    //dto.setAlertMessage("Your " + twitterhandler + " has  " + totalfriend + "  influencers to follow.");
//                    dto.setAlertMessage("Your @twitterhandle has  " + totalfriend + "  influencers to follow.");
//                }
//            }
//        }
    }
    
    
    /**
     * @deprecated
     * @param asOfPerformanceDate
     * @param fromProfile
     * @param benchmarkStDate
     * @param benchmarkEdDate
     * @param targetId
     * @return
     * @throws SVTException
     */
    public List<OverallPerformanceDummy> getOverallPerformance1(Date asOfPerformanceDate, String fromProfile, Date benchmarkStDate, Date benchmarkEdDate, String targetId) throws SVTException {
        return getDaoProvider().getOverallPerformanceDummyDAO().getByProfileId(fromProfile);        
    }

    public TwitterCalculatorChannelPerformanceProfileActionDTO getTwitterCalculatorChannelPerformanceProfileActionDTO(Date asOfPerformanceDate, String fromProfileUserId, String fromTwitterAccountId, Date benchmarkStDate, Date benchmarkEdDate, String targetId) throws SVTException {
        TwitterCalculatorChannelPerformanceProfileActionDTO twitterCalculatorChannelPerformanceProfileActionDTO = new TwitterCalculatorChannelPerformanceProfileActionDTO();
        TwitterCalculatorChlPerfDTO twitterCalculatorChlPerfDTO = new TwitterCalculatorChlPerfDTO();
        TwitterCalculatorProfileActionDTO twitterCalculatorProfileActionDTO = new TwitterCalculatorProfileActionDTO(); 
        
        if(fromProfileUserId == null) {            
            return twitterCalculatorChannelPerformanceProfileActionDTO;
        }
        
        ProfilePreference profilePreference = getProfilePreferenceDAO().getByProfileUserId(fromProfileUserId);
        
        if(profilePreference == null) {            
            return twitterCalculatorChannelPerformanceProfileActionDTO;
        }                
        
        ImprovementLevel target = null;
        if(targetId != null){
            target = getDaoProvider().getImprovementLevelDAO().getById(targetId);
        }
        
        if(asOfPerformanceDate == null) {
            asOfPerformanceDate = getMaxActionDate(profilePreference.getProfilePrefrenceId());
        }
        if(benchmarkStDate == null) {
            benchmarkStDate = profilePreference.getBenchmark().getBenchmarkStDate();  
        }
        if(benchmarkEdDate == null) {
            benchmarkEdDate = profilePreference.getBenchmark().getBenchmarkEdDate();
        }
                    
        int totalHandler = getHandlerCount(fromTwitterAccountId, profilePreference); 
        
        twitterCalculatorChlPerfDTO.setBenchmarkDateFrom(benchmarkStDate);
        twitterCalculatorChlPerfDTO.setBenchmarkDateTo(benchmarkEdDate);
        
        twitterCalculatorProfileActionDTO.setBenchmarkDateFrom(benchmarkStDate);
        twitterCalculatorProfileActionDTO.setBenchmarkDateTo(benchmarkEdDate);

        if(profilePreference.getBenchmark() != null && benchmarkStDate != null && benchmarkEdDate != null){
            Benchmark benchmark = profilePreference.getBenchmark();
            if(!(getDateWithZeroTimePart(benchmark.getBenchmarkStDate()).compareTo(getDateWithZeroTimePart(benchmarkStDate)) == 0) || !(getDateWithZeroTimePart(benchmark.getBenchmarkEdDate()).compareTo(getDateWithZeroTimePart(benchmarkEdDate)) == 0)){                
                benchmark.setBenchmarkStDate(benchmarkStDate);
                benchmark.setBenchmarkEdDate(benchmarkEdDate);
                getDaoProvider().getBenchmarkDAO().update(benchmark);
                twitterCalculatorChlPerfDTO.setBenchmarkDateFrom(benchmarkStDate);
                twitterCalculatorChlPerfDTO.setBenchmarkDateTo(benchmarkEdDate);
            }
        }
        List<OverallGradeDTO> listOut = new ArrayList<OverallGradeDTO>();
                
        //System.out.println("Before DB call Outbound Start : " + getCurrentDate());
        List<OutboundMetricsDummy> outboundMetricsDummies = getOutboundMetricsCached(asOfPerformanceDate,profilePreference, fromTwitterAccountId,benchmarkStDate,benchmarkEdDate,target, listOut, totalHandler);        
        //System.out.println("Before DB call Outbound End : " + getCurrentDate());

        twitterCalculatorChlPerfDTO.setOutboundMetricsDummy(outboundMetricsDummies);
        twitterCalculatorProfileActionDTO.setOutboundMetricsDummy(new ArrayList<OutboundMetricsDummy>());
        
        int targetPercentage = getOnlyNumbers(target.getPctValue());        
        
        //System.out.println("Rolling Starts: " + getCurrentDate());
        
        double currentVolumeRolledUp = 0;
        double benchmarkVolumeRolledUp = 0;
        double targetRolledUp = 0;

        //////
        appendLogRTOGoal("MetricId|MetricName|OverallCategoryId|OverallCatModelWt|MetricWt|MetricModelWt(OverallCatModelWt * MetricWt)|userBmk(Scale100)|compBmk(Scale100)|userCurr(Scale100)|compCurr(Scale100)|Current Target|ModelModelWt * userCurr(Scale100)|ModelModelWt * compBmk(Scale100)|ModelModelWt * Current Target|Goal%");

        for(OutboundMetricsDummy d : outboundMetricsDummies){
            double metricModelWt = d.getWeight()*d.getOverallCategoryWt();            
//            double customerTargetScale100 =getCustomerTargetByImprovementLevel(target.getName(),
//                    d.getCmptVolumeScale100(), d.getCalculatedYourVolumeScale100(),
//                    targetPercentage,d.getLowerBound(), d.getUpperBound());
//
//            //System.out.println(d.getMetricId() + " | "+ d.getMetricsName() + " | "+ d.getOverallCategoryWt() + " | " + d.getWeight() + "|" + d.getCustVolumeScale100() + " | " + d.getCalculatedYourVolumeScale100() + " | " + d.getCalculatedCmptVolumeScale100() + " | " + d.getCustTargetActual() + " | " + d.getCustTarget() + "|" + customerTargetScale100);
//            
//            currentVolumeRolledUp +=  d.getCustVolumeScale100() * metricModelWt; // ModelWt=MetricWt*OverallCatWt
//            benchmarkVolumeRolledUp += d.getCalculatedCmptVolumeScale100() * metricModelWt;
//            
//            targetRolledUp += customerTargetScale100 * metricModelWt;
        
            currentVolumeRolledUp +=  d.getYourVolumePCT() * metricModelWt; // ModelWt=MetricWt*OverallCatWt
            benchmarkVolumeRolledUp += d.getCalculatedCmptVolumePCT() * metricModelWt;
            targetRolledUp += d.getCurrentTargetRaw() * metricModelWt;
            
            appendLogRTOGoal(d.getMetricId() + "|"+ d.getMetricsName() + "|"+ d.getOverallCategoryId() + "|" + d.getOverallCategoryWt() + "|" + d.getWeight() + "|" + metricModelWt + "|" + d.getCalculatedYourVolumePCT() + "|" + d.getCalculatedCmptVolumePCT() + "|" + d.getYourVolumePCT() + "|" + d.getCmptVolumePCT() + "|" +  d.getCurrentTargetRaw() + "|" + (d.getYourVolumePCT() * metricModelWt) + "|" + (d.getCalculatedCmptVolumePCT() * metricModelWt) + "|" + (d.getCurrentTargetRaw() * metricModelWt) + "|"+ targetPercentage);
              if(d.getAlertMessage() != null && d.getAlertMessage().length() > 0){
                  twitterCalculatorProfileActionDTO.getOutboundMetricsDummy().add(d);
              }
        }

//        System.out.println(" currentVolumeRolledUp: " + currentVolumeRolledUp + " benchmarkVolumeRolledUp: " + benchmarkVolumeRolledUp +
//                " targetRolledUp: " + targetRolledUp);
        
        double rtoRolledUpValue=((currentVolumeRolledUp-benchmarkVolumeRolledUp)/(targetRolledUp-benchmarkVolumeRolledUp))*100;
        if((targetRolledUp-benchmarkVolumeRolledUp) == 0){
            rtoRolledUpValue=0; 
        }


        twitterCalculatorChlPerfDTO.setRtoGoalPercentage(getInRange(getDoubleNumberisNANZero(getDoubleNumber0Decimal(rtoRolledUpValue))) + "%"); // as per bug list dated 8/30 "WT: Checked with Faiz. Yes, follow the same calculation that provides you with negative and positive with corresponding stars and flames but convert to 0-100 scale."
        
        double tempRtoGoalPercentage = ((currentVolumeRolledUp-benchmarkVolumeRolledUp)/(targetRolledUp-benchmarkVolumeRolledUp));        
        setRtoFlameStarCount(twitterCalculatorChlPerfDTO, getDoubleNumber0Decimal(tempRtoGoalPercentage));

        System.out.println("Star/Flame Count: " + twitterCalculatorChlPerfDTO.getRtoFlameCount() + ":" + twitterCalculatorChlPerfDTO.getRtoStarCount());
        System.out.println("GOAL %: " + currentVolumeRolledUp + " : " +  benchmarkVolumeRolledUp + " : " + targetRolledUp + " >> " + twitterCalculatorChlPerfDTO.getRtoGoalPercentage());

        //System.out.println("GOAL %: " + currentVolumeRolledUp + " : " + benchmarkVolumeRolledUp + " : " + targetRolledUp + " >> " + twitterCalculatorChlPerfDTO.getRtoGoalPercentage());
        //System.out.println("Rolling Ends: " + getCurrentDate());                
                                                                  
        twitterCalculatorChannelPerformanceProfileActionDTO.setTwitterCalculatorChlPerfDTO(twitterCalculatorChlPerfDTO);
        twitterCalculatorChannelPerformanceProfileActionDTO.setTwitterCalculatorProfileActionDTO(twitterCalculatorProfileActionDTO);
        
        return twitterCalculatorChannelPerformanceProfileActionDTO;
    }


    /*
     * 
     * ////////////////////////////////////////////////// xxxx /////////////////////////////////////////////
    private double calculateYourVolumeSELFPctSentiment(
            ProfilePreference pdto, String fromTwitterAccountId,
            Date benchmarkStDate, Date benchmarkEdDate,
            double calculatedYourVolume,
            Map<String, OverallSentimentDTO> maposDTOs) throws SVTException {
        double totalDataCount;
        double totalRawScore;
        // get all the list of SELF values between benchmarkFromDate and benchmarkToDate
        
        // group by sentiment
        
        
        
        
        
        
        List<RawResult> calcSelfDtos = getDaoProvider().getRawResultDAO().findByProfileIdActionDateCALCSELF(
                pdto.getProfilePrefrenceId(), 
                fromTwitterAccountId,
                benchmarkStDate,benchmarkEdDate);

        
        
        
        
        if(calcSelfDtos != null && calcSelfDtos.size() >0){

            //group the data by sentiment
            Map<String, ArrayList<RawResult>> map = new HashMap<String, ArrayList<RawResult>>();
            List<String> sentiments = new ArrayList<String>();
            for (RawResult rr : calcSelfDtos) {
                String catId = rr.getMetric().getCategory().getCategoryId();
                
                ArrayList<RawResult> set = null;
                if(map.containsKey(catId)){
                    set = map.get(catId);
                    set.add(rr);
                } else{
                    set = new ArrayList<RawResult>();
                    set.add(rr);
                    map.put(catId, set);
                    sentiments.add(catId);
                }   
            }
            // Sentiment -> ActionDate
            if(sentiments != null && sentiments.size() >0)
            {
                for (String categoryId : sentiments) {
                    ArrayList<RawResult> rrs = map.get(categoryId);

                    //group the data by actionDate
                    Map<Date, ArrayList<RawResult>> map1 = new HashMap<Date, ArrayList<RawResult>>();
                    List<Date> actionDates = new ArrayList<Date>();
                    for (RawResult rrDTO : rrs) {
                        Date actionDate = rrDTO.getActionDate();
                        
                        ArrayList<RawResult> set = null;
                        if(map1.containsKey(actionDate)){
                            set = map1.get(actionDate);
                            set.add(rrDTO);
                        } else{
                            set = new ArrayList<RawResult>();
                            set.add(rrDTO);
                            map1.put(actionDate, set);
                            actionDates.add(actionDate);
                        }   
                    }
                    
                    // Looping through the Date Group
                    if(actionDates != null && actionDates.size() >0)
                    {
                        int totalDates = 0; // total number of unique date
                        double gtotal = 0;

                        for (Date actDate : actionDates) {
                            
                            ArrayList<RawResult> rrs1 = map.get(actDate);
                            
                            totalDataCount=0;
                            totalRawScore=0;
                            double volume = 0;
                            for(RawResult rr: rrs1){
                                if(rr.getRawScore()>=0){
                                    totalRawScore+=rr.getRawScore();
                                    totalDataCount+=rr.getTotalDataCount();
                                }
                            }

                            if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00))){
                                volume=getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00); // this volume is not normalized
                                
                                
                                
                                gtotal += volume;
                                
                            }
                            totalDates += 1;
                        }
                        
                        mm
                        calculatedYourVolume=gtotal/totalDates; // This is the calculatedYourVolume for the selected sentiment in loop
                    }
                    OverallSentimentDTO sdto = maposDTOs.get(categoryId);
                    sdto.setCalYourVolumeScale100(calculatedYourVolume);mm
                }
            } // Sentiment -> ActionDate (end of if)

        }
        return calculatedYourVolume;
    }     
    
    
        @Deprecated
    private void setInboundVolume1(InboundMetricsDummy dto, Metrics mdto,ProfilePreference pdto, Date asOfPerformanceDate, 
            String fromTwitterAccountId, Date benchmarkStDate,Date benchmarkEdDate, ImprovementLevel target) throws SVTException {
//        System.out.println("ProfileId: " + pdto.getProfilePrefrenceId());
//        System.out.println("AsOfDate : " + asOfPerformanceDate);
//        System.out.println("metricId : " + mdto.getMetricId());
//        System.out.println("MetricCode: " + mdto.getMetricCode());
        double totalDataCount=0;
        double totalRawScore=0;
        double yourVolume=0;
        double cmptVolume=0;
        double custTarget=0;
        
        double calculatedYourVolume=0;
        double calculatedCmptVolume=0;

        int targetPercentage=0;
        if(target == null){
            target = pdto.getUserProfileDetail().getImprovementLevel();
        }
        targetPercentage=getOnlyNumbers(target.getPctValue());

        dto.setCustVolume("");
        dto.setCmptVolume("");
        if(mdto.getMetricCode().equals("44") ||
            mdto.getMetricCode().equals("45") ||
            mdto.getMetricCode().equals("47") ||
            mdto.getMetricCode().equals("49") ||
            mdto.getMetricCode().equals("50") ||
            mdto.getMetricCode().equals("51") ||
            mdto.getMetricCode().equals("52") ||
            mdto.getMetricCode().equals("53") ||
            mdto.getMetricCode().equals("54") ||
            mdto.getMetricCode().equals("55") ||
            mdto.getMetricCode().equals("56") ||
            mdto.getMetricCode().equals("57") ||
            mdto.getMetricCode().equals("58") ||
            mdto.getMetricCode().equals("59") ||
            mdto.getMetricCode().equals("60") ||
            mdto.getMetricCode().equals("62") ||
            mdto.getMetricCode().equals("63") ||
            mdto.getMetricCode().equals("66") ||
            mdto.getMetricCode().equals("71") ||
            mdto.getMetricCode().equals("72") ||
            mdto.getMetricCode().equals("73") ||
            mdto.getMetricCode().equals("74") ||
            mdto.getMetricCode().equals("79") ||            
            mdto.getMetricCode().equals("85") ||
            mdto.getMetricCode().equals("86") ||
            mdto.getMetricCode().equals("87") ||
            mdto.getMetricCode().equals("88")
        ){
            List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(),fromTwitterAccountId, mdto.getMetricId(), asOfPerformanceDate);
            List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(pdto.getProfilePrefrenceId(),fromTwitterAccountId, mdto.getMetricId(), asOfPerformanceDate);
            for(RawResult rr: selfDtos){
                if(rr.getRawScore()>=0){
                    totalRawScore+=rr.getRawScore();
                    totalDataCount+=rr.getTotalDataCount();
                }
            }
            displayLog(">>>>>>>>>>>>>>MetricId: " + mdto.getMetricId() + " MetricsName: " + mdto.getMetricName() + " rawscore:"+ totalRawScore + " datacount:"+ 
                    totalDataCount + "Customer Volume: " + (totalRawScore/totalDataCount)*100.00);
            dto.setCustVolume("0");
            if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00))){
                yourVolume=getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00);
                dto.setCustVolume(getDoubleFormatedAsString(yourVolume));
            }
            totalDataCount=0;
            totalRawScore=0;
            for(RawResult rr: cmptDtos){
                if(rr.getRawScore()>=0){
                    totalRawScore+=rr.getRawScore();
                    totalDataCount+=rr.getTotalDataCount();
                }
            }
            displayLog("MetricId: " + mdto.getMetricId() + " MetricsName: " + mdto.getMetricName() + " rawscore:"+ totalRawScore + 
                    "datacount:"+ totalDataCount + "Cmpt Volume: " + (totalRawScore/totalDataCount)*100.00);
            dto.setCmptVolume("0");
            if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00))){
                cmptVolume=getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00);
                dto.setCmptVolume(getDoubleFormatedAsString(cmptVolume));
            }
            
            calculatedYourVolume = calculateYourVolumeSELFPct(mdto, pdto,
                    fromTwitterAccountId, benchmarkStDate, benchmarkEdDate,
                    calculatedYourVolume, dto);
            calculatedCmptVolume = calculateYourVolumeCMPTPct(mdto, pdto,
                    fromTwitterAccountId, benchmarkStDate, benchmarkEdDate,
                    calculatedCmptVolume, dto);

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
            // Rule1: YV < CV, Moderate=(CV-YV)*moderate%+YV, Aggr=CV, VAggr=(CV-YV)*vaggressive%+YV
            // Rule2: YV > CV, Moderate=Aggr=VAggr=YV
            // Rule3: YV > CV, && VAggr > 100, then Vaggr=100
             //dto.setCustTarget(custTarget);
            if(calculatedYourVolume >= calculatedCmptVolume){
                custTarget= calculatedYourVolume;
                if(target.getName().equalsIgnoreCase(VERY_AGGRESSIVE) && calculatedYourVolume>100){
                    custTarget=100;
                }
            }else{
                double value=(calculatedCmptVolume-calculatedYourVolume)* (targetPercentage*.01) + calculatedYourVolume;
                custTarget=getDoubleNumber2Decimal(value);
                if(target.getName().equalsIgnoreCase(AGGRESSIVE)){
                    custTarget=calculatedYourVolume; 
                }
            }
            dto.setCustTarget(getDoubleFormatedAsString(getDoubleNumber2Decimal(custTarget)));
            dto.setPercentIncrease(getDoubleFormatedAsString(convertNANtoblank(
                    getDoubleNumber2Decimal(nanToZero((yourVolume-calculatedYourVolume)/(custTarget-calculatedYourVolume))*100.00)                    
                    )));
            displayLog("Target Selected: " + target.getName() + " For Metrics: " + mdto.getMetricId() + " Your Volume: " + yourVolume + 
                    " Calculated Your Volume: " + calculatedYourVolume + " Cmpt Volume: " + calculatedCmptVolume +
                    "Cust Target: " + dto.getCustTarget() + " Percent Increase((YV-CYV)/CustTrgt-CYV): " + dto.getPercentIncrease());

            // normalizing the volume
            dto.setCustVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCustVolume()), dto.getLowerBound(), dto.getUpperBound()));
            dto.setCmptVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCmptVolume()), dto.getLowerBound(), dto.getUpperBound()));
            displayLog("Normalizing Your volume: " + dto.getCustVolume() + " lowerBound: " + dto.getLowerBound() + 
                    " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCustVolumeScale100());
            displayLog("Normalizing Cmpt Your volume: " + dto.getCmptVolume() + " lowerBound: " + dto.getLowerBound() + 
                    " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCmptVolumeScale100());
        }
        else if(mdto.getMetricCode().equals("46") || // Average
                mdto.getMetricCode().equals("76") ||
                mdto.getMetricCode().equals("77") ||
                mdto.getMetricCode().equals("69") ||
                mdto.getMetricCode().equals("70") ||
                mdto.getMetricCode().equals("75") ||
                mdto.getMetricCode().equals("78")
             ){
                 List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(),fromTwitterAccountId, mdto.getMetricId(), asOfPerformanceDate);
                 List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(pdto.getProfilePrefrenceId(),fromTwitterAccountId, mdto.getMetricId(), asOfPerformanceDate);
                 for(RawResult rr: selfDtos){
                     if(rr.getRawScore()>=0){
                         totalRawScore+=rr.getRawScore();
                         totalDataCount+=rr.getTotalDataCount();
                     }
                 }
                 displayLog(">>>>>>>>>>>>>>MetricId: " + mdto.getMetricId() + " MetricsName: " + mdto.getMetricName() + " rawscore:"+ 
                         totalRawScore + " datacount:"+ 
                         totalDataCount + " Customer Volume: " + (totalRawScore/totalDataCount));
                 //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Customer Volume: " + (totalRawScore/totalDataCount));
                 dto.setCustVolume("0");
                 if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)))){
                     yourVolume=getDoubleNumber2Decimal((totalRawScore/totalDataCount));
                     dto.setCustVolume(getDoubleFormatedAsString(yourVolume));
                 }
                 totalDataCount=0;
                 totalRawScore=0;
                 for(RawResult rr: cmptDtos){
                     if(rr.getRawScore()>=0){
                         totalRawScore+=rr.getRawScore();
                         totalDataCount+=rr.getTotalDataCount();
                     }
                 }
                 displayLog("MetricId: " + mdto.getMetricId() + " MetricsName: " + mdto.getMetricName() + " rawscore:"+ totalRawScore + 
                         " datacount:"+ totalDataCount + " Cmpt Volume: " + (totalRawScore/totalDataCount));
                 dto.setCmptVolume("0");
                 if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)))){
                     cmptVolume=getDoubleNumber2Decimal((totalRawScore/totalDataCount));
                     dto.setCmptVolume(getDoubleFormatedAsString(cmptVolume));
                 }

                 calculatedYourVolume = calculateYourVolumeSELFAvg(mdto, pdto,
                        fromTwitterAccountId, benchmarkStDate, benchmarkEdDate,
                        calculatedYourVolume, dto);
                 calculatedCmptVolume = calculateYourVolumeCMPTAvg(mdto, pdto,
                        fromTwitterAccountId, benchmarkStDate, benchmarkEdDate,
                        calculatedCmptVolume, dto);
 
                 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
                 // Rule1: YV < CV, Moderate=(CV-YV)*moderate%+YV, Aggr=CV, VAggr=(CV-YV)*vaggressive%+YV
                 // Rule2: YV > CV, Moderate=Aggr=VAggr=YV
                 // Rule3: YV > CV, && VAggr > 100, then Vaggr=100
                  //dto.setCustTarget(custTarget);
                 if(calculatedYourVolume >= calculatedCmptVolume){
                     custTarget= calculatedYourVolume;
                     if(target.getName().equalsIgnoreCase(VERY_AGGRESSIVE) && calculatedYourVolume>100){
                         custTarget=100;
                     }
                 }else{
                     double value=(calculatedCmptVolume-calculatedYourVolume)* (targetPercentage*.01) + calculatedYourVolume;
                     custTarget=getDoubleNumber2Decimal(value);
                     if(target.getName().equalsIgnoreCase(AGGRESSIVE)){
                         custTarget=calculatedYourVolume; 
                     }
                 }
                 dto.setCustTarget(getDoubleFormatedAsString(getDoubleNumber2Decimal(custTarget)));
                 dto.setPercentIncrease(getDoubleFormatedAsString(convertNANtoblank(
                         getDoubleNumber2Decimal(nanToZero((yourVolume-calculatedYourVolume)/(custTarget-calculatedYourVolume))*100.00)                    
                         )));
                 displayLog("Target Selected: " + target.getName() + " For Metrics: " + mdto.getMetricId() + " Your Volume: " + yourVolume + 
                         " Calculated Your Volume: " + calculatedYourVolume + " Cmpt Volume: " + calculatedCmptVolume +
                         " Cust Target: " + dto.getCustTarget() + " Percent Increase((YV-CYV)/CustTrgt-CYV)*100: " + dto.getPercentIncrease());
                 
                 // normalizing the volume
                 dto.setCustVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCustVolume()), dto.getLowerBound(), dto.getUpperBound()));
                 dto.setCmptVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCmptVolume()), dto.getLowerBound(), dto.getUpperBound()));
                 displayLog("Normalizing Your volume: " + dto.getCustVolume() + " lowerBound: " + dto.getLowerBound() + 
                         " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCustVolumeScale100());
                 displayLog("Normalizing Cmpt Your volume: " + dto.getCmptVolume() + " lowerBound: " + dto.getLowerBound() + 
                         " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCmptVolumeScale100());
             }
            else if(mdto.getMetricCode().equals("xx") ||
                     mdto.getMetricCode().equals("xx")
                  ){

                  }
    }


        @Deprecated
    private void setOutboundVolume1(OutboundMetricsDummy dto, Metrics mdto, ProfilePreference pdto, Date asOfPerformanceDate, 
            String fromTwitterAccountId, Date benchmarkStDate,Date benchmarkEdDate, ImprovementLevel target,
            List<GradeMaster> performanceList,List<OverallGradeDTO> listOut) throws SVTException {
        double totalDataCount=0;
        double totalRawScore=0;
        double yourVolume=0;
        double cmptVolume=0;
        double custTarget=0;
        
        double calculatedYourVolume=0;
        double calculatedCmptVolume=0;        
        
        int targetPercentage=0;
        if(target == null){
            target = pdto.getUserProfileDetail().getImprovementLevel();
        }
        targetPercentage=getOnlyNumbers(target.getPctValue());
        
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
            mdto.getMetricCode().equals("17") ||
            mdto.getMetricCode().equals("24") ||
            mdto.getMetricCode().equals("25") ||
            mdto.getMetricCode().equals("26") ||
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
            mdto.getMetricCode().equals("43") ||
            mdto.getMetricCode().equals("81") ||
            mdto.getMetricCode().equals("82") ||
            mdto.getMetricCode().equals("83") ||
            mdto.getMetricCode().equals("84")

        ){
            List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(), fromTwitterAccountId,mdto.getMetricId(), asOfPerformanceDate);
            List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(pdto.getProfilePrefrenceId(), fromTwitterAccountId,mdto.getMetricId(), asOfPerformanceDate);
            for(RawResult rr: selfDtos){
                if(rr.getRawScore()>=0){
                    totalRawScore+=rr.getRawScore();
                    totalDataCount+=rr.getTotalDataCount();
                }
            }
            displayLog(">>>>>>>>>>>>>>MetricId: " + mdto.getMetricId() + " MetricsName: " + mdto.getMetricName() + " rawscore:"+ totalRawScore + " datacount:"+ 
                    totalDataCount + "Customer Volume: " + (totalRawScore/totalDataCount)*100.00);
            dto.setCustVolume("0");
            if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00))){
                yourVolume=getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00);
                dto.setCustVolume(getDoubleFormatedAsString(yourVolume));
            }
            totalDataCount=0;
            totalRawScore=0;
            for(RawResult rr: cmptDtos){
                if(rr.getRawScore()>=0){
                    totalRawScore+=rr.getRawScore();
                    totalDataCount+=rr.getTotalDataCount();
                }
            }
            displayLog("MetricId: " + mdto.getMetricId() + " MetricsName: " + mdto.getMetricName() + " rawscore:"+ totalRawScore + 
                    " datacount:"+ totalDataCount + " Cmpt Volume: " + (totalRawScore/totalDataCount)*100.00);            
            dto.setCmptVolume("0");
            if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00))){
                cmptVolume=getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00);
                dto.setCmptVolume(getDoubleFormatedAsString(cmptVolume));
            }
            
            calculatedYourVolume = calculateYourVolumeSELFPct(mdto, pdto,
                    fromTwitterAccountId, benchmarkStDate, benchmarkEdDate,
                    calculatedYourVolume, null);
            calculatedCmptVolume = calculateYourVolumeCMPTPct(mdto, pdto,
                    fromTwitterAccountId, benchmarkStDate, benchmarkEdDate,
                    calculatedCmptVolume, null);

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
            // Rule1: YV < CV, Moderate=(CV-YV)*moderate%+YV, Aggr=CV, VAggr=(CV-YV)*vaggressive%+YV
            // Rule2: YV > CV, Moderate=Aggr=VAggr=YV
            // Rule3: YV > CV, && VAggr > 100, then Vaggr=100
             //dto.setCustTarget(custTarget);
            if(calculatedYourVolume >= calculatedCmptVolume){
                custTarget= calculatedYourVolume;
                if(target.getName().equalsIgnoreCase(VERY_AGGRESSIVE) && calculatedYourVolume>100){
                    custTarget=100;
                }
            }else{
                double value=(calculatedCmptVolume-calculatedYourVolume)* (targetPercentage*.01) + calculatedYourVolume;
                custTarget=getDoubleNumber2Decimal(value);
                if(target.getName().equalsIgnoreCase(AGGRESSIVE)){
                    custTarget=calculatedYourVolume; 
                }
            }
            dto.setCustTarget(getDoubleFormatedAsString(getDoubleNumber2Decimal(custTarget)));
            double piValue = convertNANtoblank(
                    getDoubleNumber2Decimal(nanToZero((yourVolume-calculatedYourVolume)/(custTarget-calculatedYourVolume))*100.00)                    
            );
            dto.setPercentIncrease(getDoubleFormatedAsString(piValue));
            displayLog("Target Selected: " + target.getName() + " For Metrics: " + mdto.getMetricId() + " Your Volume: " + yourVolume + 
                    " Calculated Your Volume: " + calculatedYourVolume + " Cmpt Volume: " + calculatedCmptVolume +
                    " Cust Target: " + dto.getCustTarget() + " Percent Increase((YV-CYV)/CustTrgt-CYV): " + dto.getPercentIncrease());

            setAlertFlameStarCount(dto, piValue, performanceList);
            displayLog("PercentIncrease: " + dto.getPercentIncrease() + " starCount: " + dto.getAlertStarCount() + " flameCount: " + 
                    dto.getAlertFlameCount());
            setAlertMessage(dto,selfDtos);
            
            // normalizing the volume
            dto.setCustVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCustVolume()), dto.getLowerBound(), dto.getUpperBound()));
            dto.setCmptVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCmptVolume()), dto.getLowerBound(), dto.getUpperBound()));
            displayLog("Normalizing Your volume: " + dto.getCustVolume() + " lowerBound: " + dto.getLowerBound() + 
                    " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCustVolumeScale100());
            displayLog("Normalizing Cmpt Your volume: " + dto.getCmptVolume() + " lowerBound: " + dto.getLowerBound() + 
                    " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCmptVolumeScale100());
         
        }
        else if(mdto.getMetricCode().equals("13") ||
                mdto.getMetricCode().equals("20") ||
                mdto.getMetricCode().equals("38") ||
                mdto.getMetricCode().equals("6") ||
                mdto.getMetricCode().equals("7") ||
                mdto.getMetricCode().equals("8")
             ){
                 List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(), fromTwitterAccountId,mdto.getMetricId(), asOfPerformanceDate);
                 List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(pdto.getProfilePrefrenceId(),fromTwitterAccountId,mdto.getMetricId(), asOfPerformanceDate);
                 for(RawResult rr: selfDtos){
                     if(rr.getRawScore()>=0){
                         totalRawScore+=rr.getRawScore();
                         totalDataCount+=rr.getTotalDataCount();
                     }
                 }
                 displayLog(">>>>>>>>>>>>>>MetricId: " + mdto.getMetricId() + " MetricsName: " + mdto.getMetricName() + " rawscore:"+ totalRawScore + " datacount:"+ 
                         totalDataCount + "Customer Volume: " + (totalRawScore/totalDataCount));
                 dto.setCustVolume("0");
                 if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)))){
                     yourVolume=getDoubleNumber2Decimal((totalRawScore/totalDataCount));
                     dto.setCustVolume(getDoubleFormatedAsString(yourVolume));
                 }
                 totalDataCount=0;
                 totalRawScore=0;
                 for(RawResult rr: cmptDtos){
                     if(rr.getRawScore()>=0){
                         totalRawScore+=rr.getRawScore();
                         totalDataCount+=rr.getTotalDataCount();
                     }
                 }
                 displayLog("MetricId: " + mdto.getMetricId() + " MetricsName: " + mdto.getMetricName() + " rawscore:"+ totalRawScore + 
                         " datacount:"+ totalDataCount + " Cmpt Volume: " + (totalRawScore/totalDataCount));
                 dto.setCmptVolume("0");
                 if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)))){
                     cmptVolume=getDoubleNumber2Decimal((totalRawScore/totalDataCount));
                     dto.setCmptVolume(getDoubleFormatedAsString(cmptVolume));
                 }
                 
                 calculatedYourVolume = calculateYourVolumeSELFAvg(mdto, pdto,
                        fromTwitterAccountId, benchmarkStDate, benchmarkEdDate,
                        calculatedYourVolume,null);
                 calculatedCmptVolume = calculateYourVolumeCMPTAvg(mdto, pdto,
                        fromTwitterAccountId, benchmarkStDate, benchmarkEdDate,
                        calculatedCmptVolume,null);

                 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
                 // Rule1: YV < CV, Moderate=(CV-YV)*moderate%+YV, Aggr=CV, VAggr=(CV-YV)*vaggressive%+YV
                 // Rule2: YV > CV, Moderate=Aggr=VAggr=YV
                 // Rule3: YV > CV, && VAggr > 100, then Vaggr=100
                  //dto.setCustTarget(custTarget);
                 if(calculatedYourVolume >= calculatedCmptVolume){
                     custTarget= calculatedYourVolume;
                     if(target.getName().equalsIgnoreCase(VERY_AGGRESSIVE) && calculatedYourVolume>100){
                         custTarget=100;
                     }
                 }else{
                     double value=(calculatedCmptVolume-calculatedYourVolume)* (targetPercentage*.01) + calculatedYourVolume;
                     custTarget=getDoubleNumber2Decimal(value);
                     if(target.getName().equalsIgnoreCase(AGGRESSIVE)){
                         custTarget=calculatedYourVolume; 
                     }
                 }
                 dto.setCustTarget(getDoubleFormatedAsString(getDoubleNumber2Decimal(custTarget)));
                 double piValue = convertNANtoblank(
                         getDoubleNumber2Decimal(nanToZero((yourVolume-calculatedYourVolume)/(custTarget-calculatedYourVolume))*100.00)                    
                 );
                 dto.setPercentIncrease(getDoubleFormatedAsString(piValue));
                 displayLog("Target Selected: " + target.getName() + " For Metrics: " + mdto.getMetricId() + " Your Volume: " + yourVolume + 
                         " Calculated Your Volume: " + calculatedYourVolume + " Cmpt Volume: " + calculatedCmptVolume +
                         " Cust Target: " + dto.getCustTarget() + " Percent Increase((YV-CYV)/CustTrgt-CYV)*100: " + dto.getPercentIncrease());
                 
                 setAlertFlameStarCount(dto, piValue, performanceList);  
                 displayLog("PercentIncrease: " + dto.getPercentIncrease() + " starCount: " + dto.getAlertStarCount() + " flameCount: " + 
                         dto.getAlertFlameCount());
                 setAlertMessage(dto,selfDtos);
                 
                 // normalizing the volume
                 dto.setCustVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCustVolume()), dto.getLowerBound(), dto.getUpperBound()));
                 dto.setCmptVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCmptVolume()), dto.getLowerBound(), dto.getUpperBound()));
                 displayLog("Normalizing Your volume: " + dto.getCustVolume() + " lowerBound: " + dto.getLowerBound() + 
                         " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCustVolumeScale100());
                 displayLog("Normalizing Cmpt Your volume: " + dto.getCmptVolume() + " lowerBound: " + dto.getLowerBound() + 
                         " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCmptVolumeScale100());
                 }
            else if(mdto.getMetricCode().equals("20") ||
                     mdto.getMetricCode().equals("21")
                  ){

                  }
    }
    
        @Deprecated
    private double calculateYourVolumeCMPTPct(Metrics mdto,
            ProfilePreference pdto, String fromTwitterAccountId,
            Date benchmarkStDate, Date benchmarkEdDate,
            double calculatedCmptVolume, InboundMetricsDummy dto) throws SVTException {
        double totalDataCount;
        double totalRawScore;
        displayLog("get all the CMPT values between benchmarkFromDate and benchmarkToDate: " + benchmarkStDate + ":" + benchmarkEdDate +
                "metricId: " + mdto.getMetricId() + " ProfilePrefId: " + pdto.getProfilePrefrenceId() + " FromTwitterAccountId: " + 
                fromTwitterAccountId);

        // get all the CMPT values between benchmarkFromDate and benchmarkToDate
        List<RawResult> calcCmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateCALCNOTSELF(
                pdto.getProfilePrefrenceId(), 
                fromTwitterAccountId,
                mdto.getMetricId(),
                benchmarkStDate,benchmarkEdDate);

        if(calcCmptDtos != null && calcCmptDtos.size() >0)
        {
          displayLog("=============Group the data by actionDate============");
          //group the data by actionDate
          Map<Date, ArrayList<RawResult>> map = new HashMap<Date, ArrayList<RawResult>>();
          List<Date> actionDates = new ArrayList<Date>();
          for (RawResult rrDTO : calcCmptDtos) {
              Date actionDate = rrDTO.getActionDate();
              
              ArrayList<RawResult> set = null;
              if(map.containsKey(actionDate)){
                  set = map.get(actionDate);
                  set.add(rrDTO);
              } else{
                  set = new ArrayList<RawResult>();
                  set.add(rrDTO);
                  map.put(actionDate, set);
                  actionDates.add(actionDate);
              }   
          }  
          // Looping through the Date Group
          if(actionDates != null && actionDates.size() >0)
          {
              
              int totalDates = 0; // total number of unique date
              double gtotal = 0;

              for (Date actDate : actionDates) {
                  
                  ArrayList<RawResult> rrs = map.get(actDate);
                  
                  totalDataCount=0;
                  totalRawScore=0;
                  double volume = 0;
                  for(RawResult rr: rrs){
                      if(rr.getRawScore()>=0){
                          totalRawScore+=rr.getRawScore();
                          totalDataCount+=rr.getTotalDataCount();
                      }
                  }

                  if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00))){
                      volume=getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00);
                      gtotal += volume;
                      
                  }
                  displayLog(">>>actionDate: " + actDate + " CMPT Volume: " + volume);
//                      System.out.println("Group Date........................>>>>>>>: " + actDate + " Volume: " + volume);                      
                  totalDates += 1;
              }
//                  System.out.println("For Metrics: " + mdto.getMetricId() + " GTotal: " + gtotal + " Calculated Value: " + gtotal/totalDates);
              calculatedCmptVolume=gtotal/totalDates;
              displayLog("Metrics: " + mdto.getMetricId() + " TotalVolume: " + gtotal + " CMPT Calculated Value(totvol/totaldates): " + calculatedCmptVolume);
              if(dto != null){
              // normalizing the volume
              dto.setCmptCalcVolumeScale100(getNormalizedValue(calculatedCmptVolume, dto.getLowerBound(), dto.getUpperBound()));
              displayLog("CMPT Normalizing the volume: " + calculatedCmptVolume + " lowerBound: " + dto.getLowerBound() + 
                      " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCmptCalcVolumeScale100());
              }
          }
        }
        return calculatedCmptVolume;
    }
    @Deprecated
    private double calculateYourVolumeSELFPct(Metrics mdto,
            ProfilePreference pdto, String fromTwitterAccountId,
            Date benchmarkStDate, Date benchmarkEdDate,
            double calculatedYourVolume, InboundMetricsDummy dto) throws SVTException {
        double totalDataCount;
        double totalRawScore;
        displayLog("get all the SELF values between benchmarkFromDate and benchmarkToDate: " + benchmarkStDate + ":" + benchmarkEdDate +
                "metricId: " + mdto.getMetricId() + " ProfilePrefId: " + pdto.getProfilePrefrenceId() + " FromTwitterAccountId: " + 
                fromTwitterAccountId);
        // get all the SELF values between benchmarkFromDate and benchmarkToDate
        List<RawResult> calcSelfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateCALCSELF(
                pdto.getProfilePrefrenceId(), 
                fromTwitterAccountId,
                mdto.getMetricId(),
                benchmarkStDate,benchmarkEdDate);

        if(calcSelfDtos != null && calcSelfDtos.size() >0)
        {
          displayLog("=============Group the data by actionDate============");
          //group the data by actionDate
          Map<Date, ArrayList<RawResult>> map = new HashMap<Date, ArrayList<RawResult>>();
          List<Date> actionDates = new ArrayList<Date>();
          for (RawResult rrDTO : calcSelfDtos) {
              Date actionDate = rrDTO.getActionDate();
              
              ArrayList<RawResult> set = null;
              if(map.containsKey(actionDate)){
                  set = map.get(actionDate);
                  set.add(rrDTO);
              } else{
                  set = new ArrayList<RawResult>();
                  set.add(rrDTO);
                  map.put(actionDate, set);
                  actionDates.add(actionDate);
              }   
          }  
          // Looping through the Date Group
          if(actionDates != null && actionDates.size() >0)
          {
              int totalDates = 0; // total number of unique date
              double gtotal = 0;

              for (Date actDate : actionDates) {
                  
                  ArrayList<RawResult> rrs = map.get(actDate);
                  
                  totalDataCount=0;
                  totalRawScore=0;
                  double volume = 0;
                  for(RawResult rr: rrs){
                      if(rr.getRawScore()>=0){
                          totalRawScore+=rr.getRawScore();
                          totalDataCount+=rr.getTotalDataCount();
                      }
                  }

                  if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00))){
                      volume=getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00);
                      gtotal += volume;
                      
                  }
                  displayLog(">>>actionDate: " + actDate + " Volume: " + volume);
                  totalDates += 1;
              }
              calculatedYourVolume=gtotal/totalDates;
              displayLog("Metrics: " + mdto.getMetricId() + " TotalVolume: " + gtotal + " Calculated Value(totvol/totaldates): " + calculatedYourVolume);
              // normalizing the volume
              if(dto != null){
                  dto.setCustCalcVolumeScale100(getNormalizedValue(calculatedYourVolume, dto.getLowerBound(), dto.getUpperBound()));
                  displayLog("Normalizing the volume: " + calculatedYourVolume + " lowerBound: " + dto.getLowerBound() + 
                          " upperbound: " + dto.getUpperBound() + " TO : " + dto.getCustCalcVolumeScale100());
              }

          }
        }
        return calculatedYourVolume;
    } 
///////////////////////////////////////////////// xxxx ////////////////////////////////////////////   
     */

}
