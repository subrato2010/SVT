// $Author: subratog $
package com.edifixio.soc.biz.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.faces.model.SelectItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.dto.MetricsDTO;
import com.edifixio.soc.biz.util.BizTestCase;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.RawResult;


public class RawResultMgrTest extends BizTestCase {
    private final static Log log = LogFactory.getLog(RawResultMgrTest.class);
    protected static final String TWITTERCHANNEL ="1"; // points to twitter channel

    public void xtestRawResult() throws SVTException {
        //      get all outbound metrics
        List<MetricsDTO> metricsDTO = getMetricsMgr().findCategoryByChannelIdOutbound(TWITTERCHANNEL);
        
        log.debug("Total metrics: " + metricsDTO.size());
        for(MetricsDTO mdto: metricsDTO){
            if(mdto.getMetricCode().equals("10")){// Percentage of Completed Bio(s)
                List<RawResult> selfDtos = getRawResultMgr().findByProfileIdMetricIdActionDateSELF("1",mdto.getMetricId(), new Date());
                List<RawResult> cmptDtos = getRawResultMgr().findByProfileIdMetricIdActionDateNOTSELF("1",mdto.getMetricId(), new Date());

                log.debug("Metrics Name: " + mdto.getMetricName());
                log.debug("Total SELF Records: " + selfDtos.size());
                log.debug("Total CMPT Records: " + cmptDtos.size());
                double totalDataCount=0;
                double totalRawScore=0;
                for(RawResult rr: selfDtos){
                    if(rr.getRawScore()>=0){
                        totalRawScore+=rr.getRawScore();
                        totalDataCount+=rr.getTotalDataCount();
                    }
                    //log.debug(rr.getTwitterAccount().getTwitterAccountId() + " SELF: completed bio: " + rr.getRawScore() + " TotalDataCount: " + rr.getTotalDataCount());
                }
                log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Customer Volume: " + getDoubleNumber2Decimal(totalRawScore/totalDataCount)*100.00);
                totalDataCount=0;
                totalRawScore=0;
                for(RawResult rr: cmptDtos){
                    if(rr.getRawScore()>=0){
                        totalRawScore+=rr.getRawScore();
                        totalDataCount+=rr.getTotalDataCount();
                    }
                    //log.debug(rr.getTwitterAccount().getTwitterAccountId() + " CMPT: completed bio: " + rr.getRawScore() + " TotalDataCount: " + rr.getTotalDataCount());
                }
                log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Cmpt Volume: " + getDoubleNumber2Decimal(totalRawScore/totalDataCount)*100);
            }  
        }

    }

    public void testRawResult() throws SVTException {
        //      get all outbound metrics
        List<MetricsDTO> metricsDTO = getMetricsMgr().findCategoryByChannelIdOutbound(TWITTERCHANNEL);
        
        log.debug("Total metrics: " + metricsDTO.size());
        for(MetricsDTO mdto: metricsDTO){
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

                List<RawResult> selfDtos = getRawResultMgr().findByProfileIdMetricIdActionDateSELF("1",mdto.getMetricId(), new Date());
                List<RawResult> cmptDtos = getRawResultMgr().findByProfileIdMetricIdActionDateNOTSELF("1",mdto.getMetricId(), new Date());
                for(RawResult rr: selfDtos){
                    if(rr.getRawScore()>=0){
                        totalRawScore+=rr.getRawScore();
                        totalDataCount+=rr.getTotalDataCount();
                    }
                }
                int totalDataCount1=0;
                int totalRawScore1=0;
                for(RawResult rr: cmptDtos){
                    if(rr.getRawScore()>=0){
                        totalRawScore1+=rr.getRawScore();
                        totalDataCount1+=rr.getTotalDataCount();
                    }
                }
                System.out.println("|" + mdto.getMetricName() + "|"+ 99*100.00 + "|"+ totalRawScore + "|" + totalDataCount + 
                          "|"+ 98*100.00 + "|"+ totalRawScore1 + "|" + totalDataCount1 + "|");
                
            }else if(mdto.getMetricCode().equals("6") ||
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

                List<RawResult> selfDtos = getRawResultMgr().findByProfileIdMetricIdActionDateSELF("1",mdto.getMetricId(), new Date());
                List<RawResult> cmptDtos = getRawResultMgr().findByProfileIdMetricIdActionDateNOTSELF("1",mdto.getMetricId(), new Date());
                for(RawResult rr: selfDtos){
                    if(rr.getRawScore()>=0){
                        totalRawScore+=rr.getRawScore();
                        totalDataCount+=rr.getTotalDataCount();
                    }
                }
                int totalDataCount1=0;
                int totalRawScore1=0;
                for(RawResult rr: cmptDtos){
                    if(rr.getRawScore()>=0){
                        totalRawScore1+=rr.getRawScore();
                        totalDataCount1+=rr.getTotalDataCount();
                    }
                }
                System.out.println("|" + mdto.getMetricName() + "|"+ 99 + "|"+ totalRawScore + "|" + totalDataCount + 
                          "|"+ 98 + "|"+ totalRawScore1 + "|" + totalDataCount1 + "|");
                
            }else if(mdto.getMetricCode().equals("20") ||
                    mdto.getMetricCode().equals("21")
            ){

            }
            
            
            //////
            if(mdto.getMetricCode().equals("10")){// Percentage of Completed Bio(s)
                List<RawResult> selfDtos = getRawResultMgr().findByProfileIdMetricIdActionDateSELF("1",mdto.getMetricId(), new Date());
                List<RawResult> cmptDtos = getRawResultMgr().findByProfileIdMetricIdActionDateNOTSELF("1",mdto.getMetricId(), new Date());

                log.debug("Metrics Name: " + mdto.getMetricName());
                log.debug("Total SELF Records: " + selfDtos.size());
                log.debug("Total CMPT Records: " + cmptDtos.size());
                double totalDataCount=0;
                double totalRawScore=0;
                for(RawResult rr: selfDtos){
                    if(rr.getRawScore()>=0){
                        totalRawScore+=rr.getRawScore();
                        totalDataCount+=rr.getTotalDataCount();
                    }
                    //log.debug(rr.getTwitterAccount().getTwitterAccountId() + " SELF: completed bio: " + rr.getRawScore() + " TotalDataCount: " + rr.getTotalDataCount());
                }
                log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Customer Volume: " + (totalRawScore/totalDataCount)*100.00);
                totalDataCount=0;
                totalRawScore=0;
                for(RawResult rr: cmptDtos){
                    if(rr.getRawScore()>=0){
                        totalRawScore+=rr.getRawScore();
                        totalDataCount+=rr.getTotalDataCount();
                    }
                    //log.debug(rr.getTwitterAccount().getTwitterAccountId() + " CMPT: completed bio: " + rr.getRawScore() + " TotalDataCount: " + rr.getTotalDataCount());
                }
                log.debug("rawscore:"+ totalRawScore + "datacount:"+ totalDataCount + "Cmpt Volume: " + (totalRawScore/totalDataCount)*100);
            }  
        }

    }    
    
    
    public void xtestDate(){
        String DATE_FORMAT_NOW = "MM/dd/yyyy";
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        log.debug("Today: " + (month + 1) + "/" + (day) + "/" + year);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        log.debug("Today: " +sdf.format(cal.getTime()));
    }
     public void xtestTime(){
        Date today = new Date(); 
        
        //Get all time zone ids String[] zoneIds = TimeZone.getAvailableIDs();
        String[] zoneIds = TimeZone.getAvailableIDs(); 
        if(zoneIds != null && zoneIds.length > 0){
            SelectItem[] timezones = new SelectItem[zoneIds.length];
            for (int i=0; i<zoneIds.length; i++) { 
                //Get time zone by time zone id 
                TimeZone tz = TimeZone.getTimeZone(zoneIds[i]); 
                
                //Get the display name 
                String shortName = tz.getDisplayName(tz.inDaylightTime(today), TimeZone.SHORT); 
                String longName = tz.getDisplayName(tz.inDaylightTime(today), TimeZone.LONG); 
                
                //Get the number of hours from GMT
                int rawOffset = tz.getRawOffset(); 
                int hour = rawOffset / (60*60*1000); 
                String min = "" + Math.abs(rawOffset / (60*1000)) % 60; 
                
                //Does the time zone have a daylight savings time period? 
                boolean hasDST = tz.useDaylightTime(); 
                
                //Is the time zone currently in a daylight savings time? 
                boolean inDST = tz.inDaylightTime(today); 
                
                timezones[i] = new SelectItem();
                String label = "(GMT" + hour + ":" + min + ")" + longName;
                timezones[i].setLabel(label);
                timezones[i].setValue(label);


                log.debug("(GMT " + hour +":" + org.apache.commons.lang.StringUtils.leftPad(min,2,"0") + ")(" + longName + ")(" + tz.getID() +")");
            }  

        }
    }
 }
