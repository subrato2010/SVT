package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.dto.OverallGradeDTO;
import com.edifixio.soc.biz.dto.OverallSentimentDTO;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Benchmark;
import com.edifixio.soc.persist.GradeMaster;
import com.edifixio.soc.persist.ImprovementLevel;
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
    
    public TwitterCalculatorChlPerfDTO getChannelPerformance(Date asOfPerformanceDate, String fromProfileUserId, String fromTwitterAccountId, Date benchmarkStDate, Date benchmarkEdDate, String targetId) throws SVTException {
        TwitterCalculatorChlPerfDTO dto = new TwitterCalculatorChlPerfDTO();
        ImprovementLevel target=null;
        if(targetId != null){
            target = getDaoProvider().getImprovementLevelDAO().getById(targetId);
        }
        ProfilePreference pdto = getProfilePreferenceDAO().getByProfileUserId(fromProfileUserId);     
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
        
        Map<String, OverallSentimentDTO> maposDTOs = new HashMap<String, OverallSentimentDTO>();
        List<String> sentiments = new ArrayList<String>();
        List<OverallGradeDTO> listIn = new ArrayList<OverallGradeDTO>();
        List<OverallGradeDTO> listOut = new ArrayList<OverallGradeDTO>();
        
        dto.setOutboundMetricsDummy(getOutboundMetrics(asOfPerformanceDate,pdto, fromTwitterAccountId,benchmarkStDate,benchmarkEdDate,target, listOut));
        dto.setInboundMetricsDummy(getInboundMetrics(asOfPerformanceDate,pdto, fromTwitterAccountId,benchmarkStDate,benchmarkEdDate,target, maposDTOs,sentiments,listIn ));        
        dto.setEngagementDummy(getEngagementDummy(dto.getInboundMetricsDummy()));
        dto.setReachDummy(getReachDummy(dto.getInboundMetricsDummy()));
        dto.setLoyaltyDummy(getLoyaltyDummy(dto.getInboundMetricsDummy()));
        dto.setDemographicsDummy(getDemographicsDummy(dto.getInboundMetricsDummy()));
        dto.setRetentionDummy(getRetentionDummy(dto.getInboundMetricsDummy()));
        dto.setInfluenceDummy(getInfluenceDummy(dto.getInboundMetricsDummy()));
        dto.setSentimentDummy(getSentimentDummy(dto.getInboundMetricsDummy()));
        dto.setOverallPerformanceDummy(getOverallPerformance(fromProfileUserId, fromTwitterAccountId, dto.getOutboundMetricsDummy(),dto,maposDTOs,sentiments,listIn,listOut));
        //dto.setOverallPerformanceDummy(getOverallPerformance1(fromProfileUserId, fromTwitterAccountId, dto.getOutboundMetricsDummy(),dto));
        return dto;
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
                System.out.println(" CagetoryId: [" + categoryId + 
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
                    dtocmpt.setRetentionGrade(dto.getSiOverallGradeCMPT());
                }
             }
            dtoself.setCustomer(true);
            dtocmpt.setCustomer(false);
            
            // Rolling up Inbound Grade
            double inboundRolledUpSelfValue = 0;
            double inboundRolledUpCmptValue = 0;            
            double totalOverallCatInboundWt = getTotalCatWt(listIn);
            for(OverallGradeDTO inDTO : listIn){
                inboundRolledUpSelfValue += (inDTO.getYourVolumeScale100()*inDTO.getOverallCategoryWt())/totalOverallCatInboundWt; 
                inboundRolledUpCmptValue += (inDTO.getCmptVolumeScale100()*inDTO.getOverallCategoryWt())/totalOverallCatInboundWt;
            }            

            // Outbound Grade
            double outboundRolledUpSelfValue = 0;
            double outboundRolledUpCmptValue = 0;            
            double totalOverallCatOutboundWt = getTotalCatWt(listOut);
            for(OverallGradeDTO outDTO : listOut){
                outboundRolledUpSelfValue += (outDTO.getYourVolumeScale100()*outDTO.getOverallCategoryWt())/totalOverallCatOutboundWt; 
                outboundRolledUpCmptValue += (outDTO.getCmptVolumeScale100()*outDTO.getOverallCategoryWt())/totalOverallCatOutboundWt;
            }
            
            // grade = (inboundRolledUpSelfValue + outboundRolledUpSelfValue)/2
            // grade = (inboundRolledUpCmptValue + outboundRolledUpCmptValue)/2
            List<GradeMaster> sentimentGradeList = getDaoProvider().getGradeMasterDAO().findPerformanceFalse();
            dtoself.setOverallGrade(getOverallGrade((inboundRolledUpSelfValue + outboundRolledUpSelfValue)/2, sentimentGradeList)); // inbound 50%, outbound 50%
            dtocmpt.setOverallGrade(getOverallGrade((inboundRolledUpCmptValue + outboundRolledUpCmptValue)/2, sentimentGradeList));  // inbound 50%, outbound 50%

            dtos.add(dtoself);
            dtos.add(dtocmpt);
        }

        return dtos;
    }

    public List<OutboundMetricsDummy> getOutboundMetrics(Date asOfPerformanceDate, ProfilePreference pdto, String fromTwitterAccountId, Date benchmarkStDate, 
            Date benchmarkEdDate, ImprovementLevel target,
            List<OverallGradeDTO> listOut) throws SVTException {
        
        List<OutboundMetricsDummy> dtos = new ArrayList<OutboundMetricsDummy>();
        List<GradeMaster> performanceList = getDaoProvider().getGradeMasterDAO().findPerformanceTrue();
        
        //getDaoProvider().getImprovementLevelDAO().getById(id);
        
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

            setOutboundVolume(dto,mdto, pdto, asOfPerformanceDate, fromTwitterAccountId, benchmarkStDate,benchmarkEdDate, target,performanceList,
                    listOut);
            dtos.add(dto);
        }        
        performOutboundMetricsRollup(listOut, dtos);        
        return dtos;
    }

    public List<InboundMetricsDummy> getInboundMetrics(Date asOfPerformanceDate, ProfilePreference pdto, String fromTwitterAccountId, Date benchmarkStDate, 
            Date benchmarkEdDate, ImprovementLevel target,Map<String, OverallSentimentDTO> maposDTOs, List<String> sentiments,
            List<OverallGradeDTO> listIn) throws SVTException {
        List<InboundMetricsDummy> dtos = new ArrayList<InboundMetricsDummy>();
        
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
        performSentimentGradeCalculation(maposDTOs, sentiments, dtos,
                sentimentGradeList);
        performInboundMetricsRollup(listIn, dtos);
        return dtos;
    }

    private void setInboundVolume(InboundMetricsDummy dto, Metrics mdto,ProfilePreference pdto, Date asOfPerformanceDate, 
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
            mdto.getMetricCode().equals("79")
        ){
            List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(),fromTwitterAccountId, mdto.getMetricId(), asOfPerformanceDate);
            List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(pdto.getProfilePrefrenceId(),fromTwitterAccountId, mdto.getMetricId(), asOfPerformanceDate);
            for(RawResult rr: selfDtos){
                if(rr.getRawScore()>=0){
                    totalRawScore+=rr.getRawScore();
                    totalDataCount+=rr.getTotalDataCount();
                }
            }
            //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Customer Volume: " + (totalRawScore/totalDataCount)*100.00);
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
            //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Cmpt Volume: " + (totalRawScore/totalDataCount)*100);
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
            
            //System.out.println("For Metrics: " + mdto.getMetricId() + " Your Volume: " + calculatedYourVolume + " Cmpt Volume: " + calculatedCmptVolume);
            
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
            // Rule1: YV < CV, Moderate=(CV-YV)*moderate%+YV, Aggr=CV, VAggr=(CV-YV)*vaggressive%+YV
            // Rule2: YV > CV, Moderate=Aggr=VAggr=YV
            // Rule3: YV > CV, && VAggr > 100, then Vaggr=100
             //dto.setCustTarget(custTarget);
            if(calculatedYourVolume >= calculatedCmptVolume){
                custTarget= calculatedYourVolume;
                if(target.getName().equalsIgnoreCase("VERY AGGRESSIVE") && calculatedYourVolume>100){
                    custTarget=100;
                }
            }else{
                double value=(calculatedCmptVolume-calculatedYourVolume)* (targetPercentage*.01) + calculatedYourVolume;
                custTarget=getDoubleNumber2Decimal(value);
                if(target.getName().equalsIgnoreCase("AGGRESSIVE")){
                    custTarget=calculatedYourVolume; 
                }
            }
            dto.setCustTarget(getDoubleFormatedAsString(getDoubleNumber2Decimal(custTarget)));
            dto.setPercentIncrease(getDoubleFormatedAsString(convertNANtoblank(
                    getDoubleNumber2Decimal(nanToZero((yourVolume-calculatedYourVolume)/(custTarget-calculatedYourVolume))*100.00)                    
                    )));
            
            // normalizing the volume

            dto.setCustVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCustVolume()), dto.getLowerBound(), dto.getUpperBound()));
            dto.setCmptVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCmptVolume()), dto.getLowerBound(), dto.getUpperBound()));
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
                 //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Cmpt Volume: " + (totalRawScore/totalDataCount));
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
                 
                 //System.out.println("For Metrics: " + mdto.getMetricId() + " Your Volume: " + calculatedYourVolume + " Cmpt Volume: " + calculatedCmptVolume);
                 
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
                 // Rule1: YV < CV, Moderate=(CV-YV)*moderate%+YV, Aggr=CV, VAggr=(CV-YV)*vaggressive%+YV
                 // Rule2: YV > CV, Moderate=Aggr=VAggr=YV
                 // Rule3: YV > CV, && VAggr > 100, then Vaggr=100
                  //dto.setCustTarget(custTarget);
                 if(calculatedYourVolume >= calculatedCmptVolume){
                     custTarget= calculatedYourVolume;
                     if(target.getName().equalsIgnoreCase("VERY AGGRESSIVE") && calculatedYourVolume>100){
                         custTarget=100;
                     }
                 }else{
                     double value=(calculatedCmptVolume-calculatedYourVolume)* (targetPercentage*.01) + calculatedYourVolume;
                     custTarget=getDoubleNumber2Decimal(value);
                     if(target.getName().equalsIgnoreCase("AGGRESSIVE")){
                         custTarget=calculatedYourVolume; 
                     }
                 }
                 dto.setCustTarget(getDoubleFormatedAsString(getDoubleNumber2Decimal(custTarget)));
                 dto.setPercentIncrease(getDoubleFormatedAsString(convertNANtoblank(
                         getDoubleNumber2Decimal(nanToZero((yourVolume-calculatedYourVolume)/(custTarget-calculatedYourVolume))*100.00)                    
                         )));
                 // normalizing the volume
                 dto.setCustVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCustVolume()), dto.getLowerBound(), dto.getUpperBound()));
                 dto.setCmptVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCmptVolume()), dto.getLowerBound(), dto.getUpperBound()));                 
             }
            else if(mdto.getMetricCode().equals("xx") ||
                     mdto.getMetricCode().equals("xx")
                  ){

                  }
    }
    
    private void setOutboundVolume(OutboundMetricsDummy dto, Metrics mdto, ProfilePreference pdto, Date asOfPerformanceDate, 
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
            mdto.getMetricCode().equals("10") ||
            mdto.getMetricCode().equals("11") ||
            mdto.getMetricCode().equals("12") ||
            mdto.getMetricCode().equals("14") ||
            mdto.getMetricCode().equals("17") ||
            mdto.getMetricCode().equals("2") ||
            mdto.getMetricCode().equals("24") ||
            mdto.getMetricCode().equals("25") ||
            mdto.getMetricCode().equals("26") ||
            mdto.getMetricCode().equals("28") ||
            mdto.getMetricCode().equals("29") ||
            mdto.getMetricCode().equals("3") ||
            mdto.getMetricCode().equals("30") ||
            mdto.getMetricCode().equals("31") ||
            mdto.getMetricCode().equals("32") ||
            mdto.getMetricCode().equals("33") ||
            mdto.getMetricCode().equals("34") ||
            mdto.getMetricCode().equals("35") ||
            mdto.getMetricCode().equals("36") ||
            mdto.getMetricCode().equals("37") ||
            mdto.getMetricCode().equals("39") ||
            mdto.getMetricCode().equals("4") ||
            mdto.getMetricCode().equals("40") ||
            mdto.getMetricCode().equals("41") ||
            mdto.getMetricCode().equals("42") ||
            mdto.getMetricCode().equals("43") ||
            mdto.getMetricCode().equals("5")
        ){
            List<RawResult> selfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(pdto.getProfilePrefrenceId(), fromTwitterAccountId,mdto.getMetricId(), asOfPerformanceDate);
            List<RawResult> cmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(pdto.getProfilePrefrenceId(), fromTwitterAccountId,mdto.getMetricId(), asOfPerformanceDate);
            for(RawResult rr: selfDtos){
                if(rr.getRawScore()>=0){
                    totalRawScore+=rr.getRawScore();
                    totalDataCount+=rr.getTotalDataCount();
                }
            }
            //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Customer Volume: " + (totalRawScore/totalDataCount)*100.00);
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
            //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Cmpt Volume: " + (totalRawScore/totalDataCount)*100);
            dto.setCmptVolume("0");
            if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00))){
                cmptVolume=getDoubleNumber2Decimal((totalRawScore/totalDataCount)*100.00);
                dto.setCmptVolume(getDoubleFormatedAsString(cmptVolume));
            }
            setAlertMessage(dto);
            
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
                if(target.getName().equalsIgnoreCase("VERY AGGRESSIVE") && calculatedYourVolume>100){
                    custTarget=100;
                }
            }else{
                double value=(calculatedCmptVolume-calculatedYourVolume)* (targetPercentage*.01) + calculatedYourVolume;
                custTarget=getDoubleNumber2Decimal(value);
                if(target.getName().equalsIgnoreCase("AGGRESSIVE")){
                    custTarget=calculatedYourVolume; 
                }
            }
//            System.out.println("For Metrics: " + mdto.getMetricId() + "Your Volume: " + yourVolume + 
//                    " Calculated Your Volume: " + calculatedYourVolume + " Cmpt Volume: " + calculatedCmptVolume +
//                    "Target: " + custTarget + "::::::::" + 
//                    ((yourVolume-calculatedYourVolume)/(custTarget-calculatedYourVolume))*100.00);

            dto.setCustTarget(getDoubleFormatedAsString(getDoubleNumber2Decimal(custTarget)));
            double piValue = convertNANtoblank(
                    getDoubleNumber2Decimal(nanToZero((yourVolume-calculatedYourVolume)/(custTarget-calculatedYourVolume))*100.00)                    
            );
            dto.setPercentIncrease(getDoubleFormatedAsString(piValue));
            setAlertFlameStarCount(dto, piValue, performanceList);
            
            // normalizing the volume
            dto.setCustVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCustVolume()), dto.getLowerBound(), dto.getUpperBound()));
            dto.setCmptVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCmptVolume()), dto.getLowerBound(), dto.getUpperBound()));

         
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
                 //log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Cmpt Volume: " + (totalRawScore/totalDataCount));
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
                 
                 //System.out.println("For Metrics: " + mdto.getMetricId() + " Your Volume: " + calculatedYourVolume + " Cmpt Volume: " + calculatedCmptVolume);

                 
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
                 // Rule1: YV < CV, Moderate=(CV-YV)*moderate%+YV, Aggr=CV, VAggr=(CV-YV)*vaggressive%+YV
                 // Rule2: YV > CV, Moderate=Aggr=VAggr=YV
                 // Rule3: YV > CV, && VAggr > 100, then Vaggr=100
                  //dto.setCustTarget(custTarget);
                 if(calculatedYourVolume >= calculatedCmptVolume){
                     custTarget= calculatedYourVolume;
                     if(target.getName().equalsIgnoreCase("VERY AGGRESSIVE") && calculatedYourVolume>100){
                         custTarget=100;
                     }
                 }else{
                     double value=(calculatedCmptVolume-calculatedYourVolume)* (targetPercentage*.01) + calculatedYourVolume;
                     custTarget=getDoubleNumber2Decimal(value);
                     if(target.getName().equalsIgnoreCase("AGGRESSIVE")){
                         custTarget=calculatedYourVolume; 
                     }
                 }
                 dto.setCustTarget(getDoubleFormatedAsString(getDoubleNumber2Decimal(custTarget)));
                 double piValue = convertNANtoblank(
                         getDoubleNumber2Decimal(nanToZero((yourVolume-calculatedYourVolume)/(custTarget-calculatedYourVolume))*100.00)                    
                 );
                 dto.setPercentIncrease(getDoubleFormatedAsString(piValue));
                 setAlertFlameStarCount(dto, piValue, performanceList);                 
                 // normalizing the volume
                 dto.setCustVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCustVolume()), dto.getLowerBound(), dto.getUpperBound()));
                 dto.setCmptVolumeScale100(getNormalizedValue(Double.parseDouble(dto.getCmptVolume()), dto.getLowerBound(), dto.getUpperBound()));
                 
                 }
            else if(mdto.getMetricCode().equals("20") ||
                     mdto.getMetricCode().equals("21")
                  ){

                  }
    }

    private void setAlertMessage(OutboundMetricsDummy dto) {
        // TODO Auto-generated method stub
        String metricsId = dto.getMetricId();
        //System.out.println("MetricsName: [" + metricsName +"]");
        Double custVolume = (dto.getCustVolume() != null)?(Double.parseDouble(dto.getCustVolume())):(0);
        Double cmptVolume = (dto.getCmptVolume() != null)?(Double.parseDouble(dto.getCmptVolume())):(0);
        String x = "" + getDoubleNumber2Decimal((cmptVolume-custVolume));
        if(metricsId.equalsIgnoreCase("2")){ //2
            if( custVolume < 100){
                dto.setAlertMessage("Your @twitterhandle is missing a background image.");
            }
        }else if(metricsId.equalsIgnoreCase("1")){ //1
            if( custVolume < 100){
                dto.setAlertMessage("Your @twitterhandle is missing a bio.");
            } 
        }else if(metricsId.equalsIgnoreCase("5")){ //5
            if( custVolume < 100){
                dto.setAlertMessage("Your @twitterhandle is missing a picture.");
            } 
        }else if(metricsId.equalsIgnoreCase("3")){ //3
            if( custVolume < 100){
                dto.setAlertMessage("Geo-location has not been set for @twitterhandle. If you do not require geo-location functionality, you may turn it off.");
            }
        }else if(metricsId.equalsIgnoreCase("17")){ //17
            if( custVolume < 100){
                dto.setAlertMessage("Your @twitterhandl has X friends that have not been listed."); // x needs to be calculated
            } 
        }else if(metricsId.equalsIgnoreCase("6")){ //6
            if( custVolume < 100){
                dto.setAlertMessage("Your @twitterhandle needs to add X lists."); // x needs to be calculated
            }
        }else if(metricsId.equalsIgnoreCase("7")){ //7
            if( custVolume < 100){
                dto.setAlertMessage("Your @twitterhandle has X tweets to favorite."); // x needs to be calculated
            }
        }else if(metricsId.equalsIgnoreCase("18")){ //18
            if( custVolume < 100){
                dto.setAlertMessage("");
            }
        }else if(metricsId.equalsIgnoreCase("19")){ //19
            if( custVolume < 100){
                dto.setAlertMessage("Your @twitterhandle has the following direct messages (DMs) to return.");
            }
        }else if(metricsId.equalsIgnoreCase("4")){ //4
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to increase the number of hashtags it references by " + x + "."); // x needs to be calculated
            }
        }else if(metricsId.equalsIgnoreCase("8")){ //8
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to increase its weekly twitter activity by " + x + "."); // x needs to be calculated
            }
        }else if(metricsId.equalsIgnoreCase("20")){ //20
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to increase its daily twitter activity by " + x + "."); //
            }
        }else if(metricsId.equalsIgnoreCase("73")){ //73
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to increase retweeting activity by " + x + "."); //
            }
        }else if(metricsId.equalsIgnoreCase("11")){ //11
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to increase the number of bit.ly reference activity by " + x + "."); //
            }
        }else if(metricsId.equalsIgnoreCase("12")){ //12
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to increase the number of @ reference activity by " + x + "."); //
            }
        }else if(metricsId.equalsIgnoreCase("21")){ //21
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to increase the number of hashtag reference activity by " + x + ".");//
            }
        }else if(metricsId.equalsIgnoreCase("19")){ //19
            if( custVolume < 100){ 
                dto.setAlertMessage("Your @twitterhandl needs to increase the number of DMs to friends by X."); //
            }
        }else if(metricsId.equalsIgnoreCase("23")){ //23
            if( custVolume < 100){
                dto.setAlertMessage("Your @twitterhandle needs to increase the number of Saved Searches by X."); //
            }
        }else if(metricsId.equalsIgnoreCase("24")){ //24
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to increase the number of brand keyword mentions by " + x + "."); //
            }
        }else if(metricsId.equalsIgnoreCase("25")){ //25
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to increase the number of product keyword mentions by " + x + ".");
            }
        }else if(metricsId.equalsIgnoreCase("26")){ //26
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to increase the number of industry keyword mentions by " + x + ".");
            }
        }else if(metricsId.equalsIgnoreCase("13")){ //13
            if( custVolume < 100){
                dto.setAlertMessage("Your @twitterhandle has X influencers to follow.");
            }
        
        }else if(metricsId.equalsIgnoreCase("27")){ //27
            if( custVolume < 100){
                dto.setAlertMessage("");
            }
        }else if(metricsId.equalsIgnoreCase("36")){ //36
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to increase the number of tweets made to influencers by " + x + ".");
            }
        }else if(metricsId.equalsIgnoreCase("37")){ //37
            if( custVolume < 100){
                dto.setAlertMessage("Your @twitterhandle has X influencers to follow.");
            }
        }else if(metricsId.equalsIgnoreCase("38")){ //38
            if( custVolume < 100){
                dto.setAlertMessage("Your @twitterhandle has X influencers to follow.");
            }
        }else if(metricsId.equalsIgnoreCase("39")){ //39
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to increase the number of neutral or positive tweets by " + x + ".");
            }
        }else if(metricsId.equalsIgnoreCase("40")){ //40
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to lower the number of positive tweets by " + x + ".");
            }
        }else if(metricsId.equalsIgnoreCase("41")){ //41
            if( custVolume < cmptVolume){
                dto.setAlertMessage("Your @twitterhandle needs to increase the number of positive tweets by " + x + ".");
            }
        }else if(metricsId.equalsIgnoreCase("42")){ //42
            if( custVolume < 100){
                dto.setAlertMessage("Your @twitterhandle has X influencers to follow.");
            }
        }else if(metricsId.equalsIgnoreCase("43")){ //43
            if( custVolume < 100){
                dto.setAlertMessage("Your @twitterhandle has X influencers to follow.");
            }
        }
    }

    private double calculateYourVolumeCMPTAvg(Metrics mdto,
            ProfilePreference pdto, String fromTwitterAccountId,
            Date benchmarkStDate, Date benchmarkEdDate,
            double calculatedCmptVolume, InboundMetricsDummy dto) throws SVTException {
        double totalDataCount;
        double totalRawScore;
        // get all the CMPT values between benchmarkFromDate and benchmarkToDate
         List<RawResult> calcCmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateCALCNOTSELF(
                 pdto.getProfilePrefrenceId(), 
                 fromTwitterAccountId,
                 mdto.getMetricId(),
                 benchmarkStDate,benchmarkEdDate);

         if(calcCmptDtos != null && calcCmptDtos.size() >0)
         {
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

                   if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)))){
                       volume=getDoubleNumber2Decimal((totalRawScore/totalDataCount));
                       gtotal += volume;
                       
                   }
                   totalDates += 1;
               }
//                       System.out.println("For Metrics: " + mdto.getMetricId() + " GTotal: " + gtotal + " Calculated Value: " + gtotal/totalDates);
               calculatedCmptVolume=gtotal/totalDates;
               if(dto != null){
                   // normalizing the volume
                   dto.setCmptCalcVolumeScale100(getNormalizedValue(calculatedCmptVolume, dto.getLowerBound(), dto.getUpperBound()));
               }
           }
         }
        return calculatedCmptVolume;
    }

    private double calculateYourVolumeSELFAvg(Metrics mdto,
            ProfilePreference pdto, String fromTwitterAccountId,
            Date benchmarkStDate, Date benchmarkEdDate,
            double calculatedYourVolume,InboundMetricsDummy dto) throws SVTException {
        double totalDataCount;
        double totalRawScore;
        // get all the SELF values between benchmarkFromDate and benchmarkToDate
         List<RawResult> calcSelfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateCALCSELF(
                 pdto.getProfilePrefrenceId(), 
                 fromTwitterAccountId,
                 mdto.getMetricId(),
                 benchmarkStDate,benchmarkEdDate);

         if(calcSelfDtos != null && calcSelfDtos.size() >0)
         {
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

                   if(!Double.isNaN(getDoubleNumber2Decimal((totalRawScore/totalDataCount)))){
                       volume=getDoubleNumber2Decimal((totalRawScore/totalDataCount));
                       gtotal += volume;
                       
                   }
                   //System.out.println("Group Date........................>>>>>>>: " + actDate + " Volume: " + volume);                      
                   totalDates += 1;
               }
               //System.out.println("For Metrics: " + mdto.getMetricId() + " GTotal: " + gtotal + " Calculated Value: " + gtotal/totalDates);
               calculatedYourVolume=gtotal/totalDates;
               if(dto != null){
                   // normalizing the volume
                   dto.setCustCalcVolumeScale100(getNormalizedValue(calculatedYourVolume, dto.getLowerBound(), dto.getUpperBound()));
               }
           }
         }
        return calculatedYourVolume;
    }

    private double calculateYourVolumeCMPTPct(Metrics mdto,
            ProfilePreference pdto, String fromTwitterAccountId,
            Date benchmarkStDate, Date benchmarkEdDate,
            double calculatedCmptVolume, InboundMetricsDummy dto) throws SVTException {
        double totalDataCount;
        double totalRawScore;
        // get all the CMPT values between benchmarkFromDate and benchmarkToDate
        List<RawResult> calcCmptDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateCALCNOTSELF(
                pdto.getProfilePrefrenceId(), 
                fromTwitterAccountId,
                mdto.getMetricId(),
                benchmarkStDate,benchmarkEdDate);

        if(calcCmptDtos != null && calcCmptDtos.size() >0)
        {
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
//                      System.out.println("Group Date........................>>>>>>>: " + actDate + " Volume: " + volume);                      
                  totalDates += 1;
              }
//                  System.out.println("For Metrics: " + mdto.getMetricId() + " GTotal: " + gtotal + " Calculated Value: " + gtotal/totalDates);
              calculatedCmptVolume=gtotal/totalDates;
              if(dto != null){
              // normalizing the volume
              dto.setCmptCalcVolumeScale100(getNormalizedValue(calculatedCmptVolume, dto.getLowerBound(), dto.getUpperBound()));
              }
          }
        }
        return calculatedCmptVolume;
    }

    private double calculateYourVolumeSELFPct(Metrics mdto,
            ProfilePreference pdto, String fromTwitterAccountId,
            Date benchmarkStDate, Date benchmarkEdDate,
            double calculatedYourVolume, InboundMetricsDummy dto) throws SVTException {
        double totalDataCount;
        double totalRawScore;
        // get all the SELF values between benchmarkFromDate and benchmarkToDate
        List<RawResult> calcSelfDtos = getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateCALCSELF(
                pdto.getProfilePrefrenceId(), 
                fromTwitterAccountId,
                mdto.getMetricId(),
                benchmarkStDate,benchmarkEdDate);

        if(calcSelfDtos != null && calcSelfDtos.size() >0)
        {
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
                  //System.out.println("Group Date........................>>>>>>>: " + actDate + " Volume: " + volume);                      
                  totalDates += 1;
              }
              //System.out.println("For Metrics: " + mdto.getMetricId() + " GTotal: " + gtotal + " Calculated Value: " + gtotal/totalDates);
              calculatedYourVolume=gtotal/totalDates;
              // normalizing the volume
              if(dto != null){
                  dto.setCustCalcVolumeScale100(getNormalizedValue(calculatedYourVolume, dto.getLowerBound(), dto.getUpperBound()));                  
              }

          }
        }
        return calculatedYourVolume;
    } 
    
private void setAlertFlameStarCount(OutboundMetricsDummy dto, double piValue, List<GradeMaster> performanceList) throws SVTException {
        dto.setAlertFlameCount(5);
        dto.setAlertStarCount(5);
        for(GradeMaster gmdto: performanceList){
            if(piValue >= gmdto.getPercentValue()){
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
            returnValue=(value/(upperBound - lowerBound))*100;
            return (returnValue>100)?(100):(returnValue);
        }else{
            value=(value<=upperBound)?(upperBound):(value);
            value=(value>=lowerBound)?(lowerBound):(value);
            returnValue=(value/(lowerBound - upperBound))*100;
            return (returnValue>100)?(100):(returnValue);
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
            List<OutboundMetricsDummy> dtos) {
        // Overall calculation of Outbound metrics
        //group the data by overallCategory outbound
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
                }
                osDTO.setYourVolumeScale100(gtotalYourVol/total);
                osDTO.setCmptVolumeScale100(gtotalCmptVol/total);
                osDTO.setCalYourVolumeScale100(gtotalCalcYourVol/total);
                osDTO.setCalCmptVolumeScale100(gtotalCalcCmptVol/total);
                listOut.add(osDTO);               
            }
        }
    }     
 
    private void performInboundMetricsRollup(List<OverallGradeDTO> listIn,
            List<InboundMetricsDummy> dtos) {
        // Overall calculation of Inbound metrics
        //group the data by overallCategory inbound
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
                }
                osDTO.setYourVolumeScale100(gtotalYourVol/total);
                osDTO.setCmptVolumeScale100(gtotalCmptVol/total);
                osDTO.setCalYourVolumeScale100(gtotalCalcYourVol/total);
                osDTO.setCalCmptVolumeScale100(gtotalCalcCmptVol/total);
                listIn.add(osDTO);               
            }
        }
    }
    
    private void performSentimentGradeCalculation(
            Map<String, OverallSentimentDTO> maposDTOs,
            List<String> sentiments, List<InboundMetricsDummy> dtos,
            List<GradeMaster> sentimentGradeList) throws SVTException {
        // Sentiment calculation
////////////////////////////////////////////////////////
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
                int total = 0; // total number of metrics
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
                }
                osDTO.setSiYourVolumeScale100(gtotalSiYourVol/total);
                osDTO.setSiCmptVolumeScale100(gtotalSiCmptVol/total);
                osDTO.setSiCalYourVolumeScale100(gtotalSiCalcYourVol/total);
                osDTO.setSiCalCmptVolumeScale100(gtotalSiCalcCmptVol/total);
                
                osDTO.setSiOverallGradeSELF(getOverallGrade(osDTO.getSiYourVolumeScale100(), sentimentGradeList));
                osDTO.setSiOverallGradeCMPT(getOverallGrade(osDTO.getSiCmptVolumeScale100(), sentimentGradeList));
                
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
        }
        return totalSIWt;
    }

    private double getTotalWeightIn(ArrayList<InboundMetricsDummy> inboundMetrics) {
        double totalWt =0;
        for(InboundMetricsDummy imd : inboundMetrics){
            totalWt += imd.getWeight();
        }
        return totalWt;
    }

    private double getTotalWeightOut(ArrayList<OutboundMetricsDummy> outboundMetrics) {
        double totalWt =0;
        for(OutboundMetricsDummy imd : outboundMetrics){
            totalWt += imd.getWeight();
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
    
    
    
    
    
///////////////////////////////////////////////// xxxx ////////////////////////////////////////////   
     */

}
