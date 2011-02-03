// $Author: subratog $
package com.edifixio.soc.web.controllers;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.edifixio.soc.biz.BenchmarkMgr;
import com.edifixio.soc.biz.ChannelMgr;
import com.edifixio.soc.biz.ImprovementLevelMgr;
import com.edifixio.soc.biz.InboundDummyMgr;
import com.edifixio.soc.biz.OutboundDummyMgr;
import com.edifixio.soc.biz.OverallDummyMgr;
import com.edifixio.soc.biz.ParameterMgr;
import com.edifixio.soc.biz.ProfilePreferenceMgr;
import com.edifixio.soc.biz.SocIntellDummyMgr;
import com.edifixio.soc.biz.StateProvinceMgr;
import com.edifixio.soc.biz.TwitLogMgr;
import com.edifixio.soc.biz.TwitterAccountMgr;
import com.edifixio.soc.biz.TwitterCalculatorMgr;
import com.edifixio.soc.biz.UserProfileMgr;
import com.edifixio.soc.biz.dto.ChannelDTO;
import com.edifixio.soc.biz.dto.StateProvinceDTO;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.util.BizControlDataMgr;
import com.edifixio.soc.biz.util.DateUtil;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ImprovementLevel;

public abstract class BaseWebObject {
    private static final String BIZ_CONTROL_DATA_MGR = "bizControlDataMgr";
    private static final String DATE_FORMAT_NOW = "MM/dd/yyyy";
    public static final String SUCCESS = "SUCCESS";
    public static final String BLANK = "";    
    public static final String ENGAGEMENT = "Engagement";
    public static final String INFLUENCE = "Influence";
    public static final String LOYALTY = "Loyalty";
    public static final String REACH = "Reach";
    public static final String RETENTION = "Retention";
    public static final String SENTIMENT = "Sentiment";
    public static final String DEMOGRAPHICS = "Demographics";
    private static final String VAR_CHANNEL = "channel";
    private static final String HOME_PAGE = "overallscore.jsp";
    protected static final String DEFAUTL_CHANNEL= "Overall Score";
    protected static final String SOCIAL_INTELLIGENCE = "Social Intelligence";
    
    private static final String CHANNEL_NAME = "channelName";
    public static final String CURRENT_BENCHMARK_ID = "currentBenchmarkId";
    public static final String CHANNEL_CONTROLLER = "channelController";
    
    private String formatDouble = "#.#"; 
    public static final double SCALINGFACTOR = 5.5; //TODO: needs to be moved to Database
    public static final double TOTALOUTBOUNDSCORE = 50000; //TODO: needs to be moved to Database
    public static final String PARAM_BENCHMARK_ID = "benchmarkId";
    
    public static final String PROFILE_ID = "profileId";
    public static final String CURRENT_PROFILE_ID = "currentProfileId";
    public static final String TARGETTYPE="targettype";
    public static final String SENTIMENTNAME="si";
    public static final String SORTBY="col";
    public static final String ORDERBYYV="orderbyyv";
    public static final String ORDERBYCV="orderbycv";
    public static final String ORDERBYYT="orderbyyt";
    public static final String ORDERBYPI="orderbypi";

    
    public static float A_POSITIVE = 4.5f;
    public static float A = 4.0f;
    public static float A_NEGATIVE = 3.5f;
    
    public static float B_POSITIVE = 3.0f;
    public static float B = 2.5f;
    public static float B_NEGATIVE = 2.0f;
    
    public static float C_POSITIVE = 1.5f;
    public static float C = 1.0f;
    public static float C_NEGATIVE = .5f;

    private List<TwitterAccountDTO> twitterAccount;
    private List<ImprovementLevel> targetList;
    
    public BaseWebObject() {
       init();
    }
    
    private void init(){
        try {
            // Listbox population of Profile
            setTwitterAccount(getTwitterAccountMgr().getByProfileUserIdSELF(getCurrentUid()));
        } catch (SVTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        if(getParameter(PROFILE_ID) != null){            
            setCurrentProfileId(getParameter(PROFILE_ID));
        }
    }
    protected void reInit() throws SVTException  {
        init();
    }
    
    protected BizControlDataMgr getBizSvcFactory() {
            BizControlDataMgr mgr = (BizControlDataMgr) getFactoryObject(BIZ_CONTROL_DATA_MGR);
            mgr.setCurrentBenchmarkId(getCurrentBenchmarkId());
            return mgr;
        }
       
        private Object getFactoryObject(String springId) {
        // this uses the "standard" Spring root web ApplicationContext
        return getWebApplicationContext().getBean(springId);
        }
       
        protected WebApplicationContext getWebApplicationContext() {
        return WebApplicationContextUtils
        .getRequiredWebApplicationContext(getServletContext());
        }
       
        protected ServletContext getServletContext() {
            return (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();         
        }
             
        public double getDoubleNumber(double number) {
            DecimalFormat twoDForm = new DecimalFormat(formatDouble);
            return Double.valueOf(twoDForm.format(Math.abs(number)));
        }
        

        public SelectItem[] getTimeZoneOptions()
        {
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
                    String label = "(GMT " + hour +":" + org.apache.commons.lang.StringUtils.leftPad(min,2,"0") + ")(" + longName + ")(" + tz.getID() +")";
                    timezones[i].setLabel(label);
                    timezones[i].setValue(label);
                }  
                return timezones;
            }else{
                return null;
            }
        }
        
        public String getCurrentDateMMDDYYYY() {            
            Calendar cal = Calendar.getInstance();
            //int month = cal.get(Calendar.MONTH);
            //int year = cal.get(Calendar.YEAR);
            //int day = cal.get(Calendar.DAY_OF_MONTH);
            //log.debug("Current date : " + day + "/" + (month + 1) + "/" + year);
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
            return sdf.format(cal.getTime());
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


        //---------------- All biz manager
        protected ParameterMgr getParameterMgr() {
            return getBizSvcFactory().getParameterMgr();
        }
        protected ImprovementLevelMgr getImprovementLevelMgr() {
            return getBizSvcFactory().getImprovementLevelMgr();
        }
        protected ProfilePreferenceMgr getProfilePreferenceMgr() {
            return getBizSvcFactory().getProfilePreferenceMgr();
        }
        protected TwitterAccountMgr getTwitterAccountMgr() {
            return getBizSvcFactory().getTwitterAccountMgr();
        }
        
        protected ChannelMgr getChannelMgr() {
            return getBizSvcFactory().getChannelMgr();
        }
        
        protected UserProfileMgr getUserProfileMgr() {
            return getBizSvcFactory().getUserProfileMgr();
        }


        protected BenchmarkMgr getBenchmarkMgr() {
            return getBizSvcFactory().getBenchmarkMgr();
        }
        protected StateProvinceMgr getStateProvinceMgr() {
            return getBizSvcFactory().getStateProvinceMgr();
        }
        protected TwitterCalculatorMgr getTwitterCalculatorMgr() {
            return getBizSvcFactory().getTwitterCalculatorMgr();
        }
        protected TwitLogMgr getTwitLogMgr() {
            return getBizSvcFactory().getTwitLogMgr();
        }
        
        public void goHome()
        {
            FacesContext facesCtx = FacesContext.getCurrentInstance();
            ExternalContext extCtx = facesCtx.getExternalContext();
            
            if (extCtx != null) 
            {
               try{
                    extCtx.redirect(HOME_PAGE);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        
        public boolean escapeMenuCheck(){
            return false;
        }
        
        public String getFormattedDate(Date date){
            return DateUtil.getROIDate(date); 
        }
        
        //===============================================
        public String getParameter(String param){
            return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(param);
        }
        public String getParameter1(String param){
            return (String)FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(param);
        }
        
        public void setSessionAttribute(String key, Object value){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
        }
        
        public String getSessionAttribute(String attributeName){
            return (String)getObjSessionAttribute(attributeName);
        }
        
        public Object getObjSessionAttribute(Object attributeName){
           return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(attributeName);
        }
      
        public String getCurrentUid(){
            if(FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() == null)
                return null;
            else
                return FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        }
        
        public String getQueryString(){
            HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
            return request.getQueryString();
        }

        public List<TwitterAccountDTO> getTwitterAccount() {
            return twitterAccount;
        }

        public void setTwitterAccount(List<TwitterAccountDTO> twitterAccount) {
            this.twitterAccount = twitterAccount;
        }

        public ChannelDTO getChannelDTOFromRequest() throws SVTException
        {
            ChannelDTO channelDTO = null;
            String channelNameFromFlash = getParameter(CHANNEL_NAME);
            
            if(channelNameFromFlash != null){
                channelDTO = getChannelByName(channelNameFromFlash);
            }
            return channelDTO;
        }
        
        public String getProfileTargetName(String currentUid) throws SVTException {
            return getProfilePreferenceMgr().getByProfileUserId(getCurrentUid()).getProfilePreference().getUserProfileDetail().getImprovementLevel().getName();
        }
        public String getProfileTargetId(String currentUid) throws SVTException {
            return getProfilePreferenceMgr().getByProfileUserId(getCurrentUid()).getProfilePreference().getUserProfileDetail().getImprovementLevel().getImprovementLevelId();
        }
        
        public ChannelDTO getChannelByName(String channelName) throws SVTException{
            return getBizSvcFactory().getChannelMgr().getChannelByName(channelName);
        }
        
        protected String getCurrentBenchmarkId(){
            return getSessionAttribute(CURRENT_BENCHMARK_ID);
        }
        
        public void setCurrentBenchmarkId(String benchmarkId){
            setSessionAttribute(CURRENT_BENCHMARK_ID, benchmarkId);
        }
        protected boolean isBenchmarkIdChanged(){
            boolean changed = false;
            if(getParameter(PARAM_BENCHMARK_ID)!= null )
            {
                changed = true;
            }
            return changed;
        }
        protected String getCurrentProfileId(){
            return getSessionAttribute(CURRENT_PROFILE_ID);
        }
        protected void getTargetType(){
            getSessionAttribute(TARGETTYPE);
        }
        
        public void setCurrentProfileId(String profileId){
            setSessionAttribute(CURRENT_PROFILE_ID, profileId);
        }
        public void setTargetType(String taregetType){
            setSessionAttribute(TARGETTYPE, taregetType);
        }
        
//        protected String getSentimentName(){
//            return getSessionAttribute(SENTIMENTNAME);
//        }
//        public void setSentimentName(String sentimentName){
//            setSessionAttribute(SENTIMENTNAME, sentimentName);
//        }
        protected String getSentimentName(){
            return getParameter(SENTIMENTNAME);
        }

//        protected String getSortBy(){
//            return getSessionAttribute(SORTBY);
//        }
//        public void setSortBy(String sortBy){
//            setSessionAttribute(SORTBY, sortBy);
//        }  
        protected String getSortBy(){
            return getParameter(SORTBY);
        }
//        public void setSortBy(String sortBy){
//            setSessionAttribute(SORTBY, sortBy);
//        }
        protected boolean isProfileIdChanged(){
            boolean changed = false;
            if(getParameter(PROFILE_ID)!= null )
            {
                changed = true;
            }
            return changed;
        }       
        
        public SelectItem[] getTargetOptions()
        {
            if(getTargetList() != null && getTargetList().size() > 0){
                
                SelectItem[] options = new SelectItem[getTargetList().size()];
                for (int i = 0; i <getTargetList().size(); i++) {
                    options[i] = new SelectItem();
                    options[i].setLabel(getTargetList().get(i).getName());
                    options[i].setValue(getTargetList().get(i).getImprovementLevelId());
                }
                return options;
            }
            else
                return null;
        }
        
        //-------- needs to be deleted after 9-Dec
        protected OverallDummyMgr getOverallDummyMgr() {
            return getBizSvcFactory().getOverallDummyMgr();
        }
        protected OutboundDummyMgr getOutboundDummyMgr() {
            return getBizSvcFactory().getOutboundDummyMgr();
        }
        protected InboundDummyMgr getInboundDummyMgr() {
            return getBizSvcFactory().getInboundDummyMgr();
        }
        
        protected SocIntellDummyMgr getSocIntellDummyMgr() {
            return getBizSvcFactory().getSocIntellDummyMgr();
        }

        public List<ImprovementLevel> getTargetList() {
            return targetList;
        }

        public void setTargetList(List<ImprovementLevel> targetList) {
            this.targetList = targetList;
        }

}
