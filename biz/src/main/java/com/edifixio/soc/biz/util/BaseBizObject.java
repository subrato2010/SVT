// $Author: subratog $
package com.edifixio.soc.biz.util;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


import com.edifixio.soc.biz.dto.CachedChannelOptimizationGoalPctDTO;
import com.edifixio.soc.biz.dto.CachedChannelPerformanceDTO;
import com.edifixio.soc.biz.dto.CachedOutboundDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.ChannelDAO;
import com.edifixio.soc.dao.ProfilePreferenceDAO;
import com.edifixio.soc.dao.StateProvinceDAO;
import com.edifixio.soc.dao.TimeZoneDAO;
import com.edifixio.soc.dao.TwitterAccountDAO;
import com.edifixio.soc.dao.UserProfileDetailDAO;
import com.edifixio.soc.dao.util.DAOProvider;
import com.edifixio.soc.persist.Benchmark;
import com.edifixio.soc.persist.Channel;
import com.edifixio.soc.persist.OutboundMetricsDummy;
import com.edifixio.soc.persist.ProfilePreference;
import com.edifixio.soc.persist.StateProvince;
import com.edifixio.soc.persist.TimeZone;
import com.edifixio.soc.persist.TwitterAccount;
import com.edifixio.soc.persist.UserProfileDetail;
import com.edifixio.soc.web.dto.TwitterCalculatorChlPerfDTO;


public class BaseBizObject {
    private static final Log log = LogFactory.getLog("BaseBizObject");
    private DAOProvider daoProvider;
    protected static final String PIPE = "|";
    protected static final String BACKSLASH = "\\";
    private String formatDouble = "#.#";
    protected static final String DATE_FORMAT_NOW = "MM/dd/yyyy";
    DecimalFormat twoDForm = new DecimalFormat("#.##"); 
    DecimalFormat oneDForm = new DecimalFormat("#.#"); 
    DecimalFormat zeroDForm = new DecimalFormat("#"); 
    
    private String currentBenchmarkId;
    protected static final String TWITTERCHANNEL ="1"; // points to twitter channel
    protected static final String SENTIMENT = "Sentiment";
    protected static final String RETENTION = "Conversion";
    protected static final String REACH = "Reach";
    protected static final String LOYALTY = "Loyalty";
    protected static final String INFLUENCE = "Influence";
    protected static final String DEMOGRAPHICS = "Demographics";
    protected static final String ENGAGEMENT = "Engagement";
    
    protected static final String BRAND = "BRAND";
    protected static final String PRODUCT = "PRODUCT";
    protected static final String INDUSTRY = "INDUSTRY";
    boolean display =false;
    boolean display1 =true;

    StringBuffer sbLog = new StringBuffer();

    
    boolean dump = true;
    StringBuffer sbOutboundLog = new StringBuffer();
    StringBuffer sbInboundLog = new StringBuffer();
    StringBuffer sbRTOPctLog = new StringBuffer();
    
    
    
    public DAOProvider getDaoProvider() {
        daoProvider.setBenchmarkId(currentBenchmarkId);
        return daoProvider;
    }

    public String getCurrentBenchmarkId(){
        return this.currentBenchmarkId;
    }

    public Benchmark getCurrentBenchmark() throws SVTException{
        return getDaoProvider().getBenchmarkDAO().getByIdOrLatest(getCurrentBenchmarkId());
    }
    
    public void setCurrentBenchmarkId(String currentBenchmarkId){
        this.currentBenchmarkId = currentBenchmarkId;
    }
    
    public void setDaoProvider(DAOProvider daoProvider) {
        this.daoProvider = daoProvider;
    }


    public ChannelDAO<Channel> getChannelDAO() {
        log.debug("daoprovider: " + getDaoProvider());
        return getDaoProvider().getChannelDAO();
    }

    public ProfilePreferenceDAO<ProfilePreference> getProfilePreferenceDAO() {
        return getDaoProvider().getProfilePreferenceDAO();
    }
    
    public UserProfileDetailDAO<UserProfileDetail> getUserProfileDetailDAO() {
        return getDaoProvider().getUserProfileDetailDAO();
    }
    
    public TwitterAccountDAO<TwitterAccount> getTwitterAccountDAO() {
        return getDaoProvider().getTwitterAccountDAO();
    }
    
    public StateProvinceDAO<StateProvince> getStateProvinceDAO() {
        return getDaoProvider().getStateProvinceDAO();
    }
    public TimeZoneDAO<TimeZone> getTimeZoneDAO() {
        return getDaoProvider().getTimeZoneDAO();
    }
    
    /**
     * uses apache BeanUtils to copy all matching properties to the dest (arg 1)
     * from the source (arg 2)
     */
    protected void copyPropertiesQuietly(Object dest, Object source) {
        quietlyCopyProperties(dest, source);
    }


    /**
     * uses apache BeanUtils to copy all matching properties to the dest (arg 1)
     * from the source (arg 2)
     */
    protected void quietlyCopyProperties(Object dest, Object source) {
        try {
            BeanUtils.copyProperties(dest, source);
        } catch (IllegalAccessException ex) {
            // nothing to worry about
        } catch (InvocationTargetException ex) {
            // nothing to worry about
        } 
    }
    
    public double getDoubleNumber(double number) {
        DecimalFormat twoDForm = new DecimalFormat(formatDouble);
        return Double.valueOf(twoDForm.format(Math.abs(number)));
    }
    
    public double getDoubleNumber2Decimal(double number){
        if(Double.isNaN(number)){
            return number;
        }
        return Double.valueOf(twoDForm.format(number));
    }
    public double getDoubleNumber0Decimal(double number){
        if(Double.isNaN(number)){
            return number;
        }
        return Math.round(number);
        //return Double.valueOf(zeroDForm.format(number));
    }
    public double getDoubleNumber1Decimal(double number){
        if(Double.isNaN(number)){
            return number;
        }        
        return Double.valueOf(oneDForm.format(number));
    }
    public double getDoubleNumberisNANZero(double number){
        if(Double.isNaN(number)){
            return 0;
        }
        return number;
    }
    public String getDoubleFormatedAsString(double number){
        int integerPart = (int) number;
        double decimalPart = number - integerPart;
        //TODO
        return (decimalPart==0)?("" + integerPart):("" +number);
    }

    public int getOnlyNumbers(String strValue) {        
        if (strValue == null) {
            return 0;
        }

        StringBuffer strBuff = new StringBuffer();
        char c;        
        for (int i = 0; i < strValue.length() ; i++) {
            c = strValue.charAt(i);
            
            if (Character.isDigit(c)) {
                strBuff.append(c);
            }
        }
        return Integer.parseInt(strBuff.toString());
    }
    
    public Date getCurrentDate() {            
        Calendar cal = Calendar.getInstance();
        //int month = cal.get(Calendar.MONTH);
        //int year = cal.get(Calendar.YEAR);
        //int day = cal.get(Calendar.DAY_OF_MONTH);
        //log.debug("Current date : " + day + "/" + (month + 1) + "/" + year);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return cal.getTime();
    }

    public void displayLog(String text){
        if(display == true){
            log.debug("CALCDEBUG: " + text.replaceAll("\n", "CALCDEBUG:"));
        }
    }
    
    public void appendLogOutbound(String text){
        if(dump == true){
            sbOutboundLog.append(text);
            sbOutboundLog.append("\n");
        }
    }
    
    public void appendLogInbound(String text){
        if(dump == true){
            sbInboundLog.append(text);
            sbInboundLog.append("\n");
        }
    }
    
    public void appendLogRTOGoal(String text){
        if(dump == true){
            sbRTOPctLog.append(text);
            sbRTOPctLog.append("\n");
        }
    }
    
    public List<String> getMetricsLogs(){
        List<String> metricsReports = new ArrayList<String>();
        metricsReports.add(sbOutboundLog.toString());
        metricsReports.add(sbInboundLog.toString());
        metricsReports.add(sbRTOPctLog.toString());
        return metricsReports;
    }
    
    
    public void appendLog2(String text){
        if(display == true){
            sbLog.append(text);
            sbLog.append("\n");
        }
    }
    public void appendLog3(String text){
        if(display == true){
            sbLog.append(text);
            sbLog.append("\n");
        }
    }
    public void appendLog4(String text){
        if(display == true){
            sbLog.append(text);
            sbLog.append("\n");
        }
    }
    
    public void viewLog(){
        System.out.println(sbLog.toString());
    }
    
    public Object[] getDateTime(Date date)
    {
        DateTime dateTime = new DateTime(date);
        DateTime datePart = new DateTime(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth() , 0, 0 ,0 ,0);
        
        DateTimeFormatter formatter = DateTimeFormat.forPattern("h:mm a");
        String timePart = formatter.print(dateTime);
        
        return new Object[]{datePart.toDate(), timePart};
    }
    
    
    public static Map<String, CachedChannelPerformanceDTO> mapTwitterCalculatorChlPerfDTO = new CacheMap<String, CachedChannelPerformanceDTO>(30); //TODO: will be refactored
    public static Map<String, CachedOutboundDTO> mapOutboundMetricsDummyDTO = new CacheMap<String, CachedOutboundDTO>(30); //TODO: will be refactored    
    public static Map<String, CachedChannelOptimizationGoalPctDTO> mapChannelOptimizationGoalPctDTO = new CacheMap<String, CachedChannelOptimizationGoalPctDTO>(30); //TODO: will be refactored
}
