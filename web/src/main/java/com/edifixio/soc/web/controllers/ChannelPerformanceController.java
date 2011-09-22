package com.edifixio.soc.web.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;

import com.edifixio.soc.biz.dto.AlertPopupDTO;
import com.edifixio.soc.biz.dto.ProfilePreferenceDTO;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.InboundMetricsDummy;
import com.edifixio.soc.persist.OutboundMetricsDummy;
import com.edifixio.soc.persist.OverallPerformanceDummy;
import com.edifixio.soc.persist.SocialIntelligenceMetricsDummy;
import com.edifixio.soc.web.dto.TwitterCalculatorChlPerfDTO;

public class ChannelPerformanceController extends BaseWebObject 
{
    private String resetDate;
    private long minDate;
    private long maxDate;

    public String getResetDate() {        
        return resetDate;
    }


    public void setResetDate(Date resetDate) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        this.resetDate = format.format(resetDate);
    }

    public long getMinDate() {
        return minDate;
    }


    public void setMinDate(long minDate) {
        this.minDate = minDate;
    }


    public long getMaxDate() {
        return maxDate;
    }


    public void setMaxDate(long maxDate) {
        this.maxDate = maxDate;
    }

    private static final String MAIN_SCREEN_JSP = "mainScreen.jsp";
   private String si;
   private String col;
   
   private String selectedTwitterUsername;
   
   private List<OverallPerformanceDummy> overallPerformanceDummy;
   
   private List<InboundMetricsDummy> inboundMetricsDummy;
   private List<SocialIntelligenceMetricsDummy> engagementDummy; 
   private List<SocialIntelligenceMetricsDummy> reachDummy;
   private List<SocialIntelligenceMetricsDummy> loyaltyDummy;
   private List<SocialIntelligenceMetricsDummy> demographicsDummy;
   private List<SocialIntelligenceMetricsDummy> retentionDummy;
   private List<SocialIntelligenceMetricsDummy> influenceDummy;
   private List<SocialIntelligenceMetricsDummy> sentimentDummy;
   private Date performanceAsOfDate;
   private String profileId;
   private String fromProfileId;
   private String twitterAccountId;
   private String twitterAccountName;
   private Date benchmarkDateFrom;
   private Date benchmarkDateTo;
   private String target;
   private String targetId;
   private String targetName;
   private String clickedSentiment;

   private String trendingCategorySelected;
   private String trendingModeDWMSelected; // Daily/Weekly/Monthly
   private String trendingSelfSelected;
   private String rtoGoalPercentage;
   private int rtoStarCount;
   private int rtoFlameCount;
   
   // Added By Neel, Started Here
   private String color;
   private String overallColor;
   private int flg = 0;
   private int cnt=0;
   private int methodCount=0;
  
   private String yourGrade;
   private String compititors;
   private ArrayList<String> al = new ArrayList<String>();
   private int i=0;
   // Added By Neel, Ended Here
   
   //SG: this is tempo solution, because we dont know how to do achive this
   private String channelOptimizationOutbound;
   private String channelPerformanceTabClick;
   
   private int minPerformanceAsofDiffFromCurrentDate;
   private int maxPerformanceAsofDiffFromCurrentDate;
   private int minBenchmarkAsofDiffFromCurrentDate;
   
    public ChannelPerformanceController() throws SVTException
    {
        // Place it in the right place please: not the right place to keep this code
        //setPerformanceValue();
        //setValue();
        
        System.out.println("Channel Performance Controller Called !!!!!!!");
        
        if(getParameter("targetSelected") != null && getParameter("targetSelected").equalsIgnoreCase("changedtarget")){
            changeTarget(); // this is required, when user clicks on changetarget list box
        }else{        
            setDefaultParameter();
        }                        
    }

    public void populateWithDefault(ActionEvent ae) throws SVTException{

        setPerformanceValue();
    }
    
    public String getChannelOptimizationOutbound() throws SVTException {
        //setPerformanceValue();
//        System.out.println("getPerformanceAsOfDate: " + getPerformanceAsOfDate());
//        System.out.println("getCurrentUid:          " + getCurrentUid());
//        System.out.println("getTwitterAccountId:    " + getTwitterAccountId());
//        System.out.println("getBenchmarkDateFrom:   " + getBenchmarkDateFrom());
//        System.out.println("getBenchmarkDateTo:     " + getBenchmarkDateTo());
//        System.out.println("getTargetId:            " + getTargetId());
                
        //TwitterCalculatorChlPerfDTO dto = getTwitterCalculatorMgr().getChannelPerformanceOutbound(getPerformanceAsOfDate(), getCurrentUid(), getTwitterAccountId(), getBenchmarkDateFrom(), getBenchmarkDateTo(), getTargetId());
        //setSessionAttribute("tccppaDTOCounter", Integer.valueOf(2).toString());        
        
        TwitterCalculatorChlPerfDTO dto = getRTOPHandler().getTwitterCalculatorChannelPerformanceProfileActionDTO().getTwitterCalculatorChlPerfDTO();
        getRTOPHandler().setOutboundMetricsDummy(dto.getOutboundMetricsDummy());
        setRtoGoalPercentage(dto.getRtoGoalPercentage());
        setRtoStarCount(dto.getRtoStarCount());
        setRtoFlameCount(dto.getRtoFlameCount());
        Collections.sort(dto.getOutboundMetricsDummy(), new MetricsOutboundComparator("yv", "A"));
        setSessionValueForProfileAlert(getPerformanceAsOfDate(), getBenchmarkDateFrom(), getBenchmarkDateTo());
        
        /*if(Integer.parseInt(getSessionAttribute("tccppaDTOCounter")) == 2) {
            getRTOPHandler().setTwitterCalculatorChannelPerformanceProfileActionDTO(null);
        }*/
        
        return channelOptimizationOutbound;
    }
    
    /**
     * Setting the following values to session, these values will be required at the time of getting profileAlert by calling method from biz layer
     * @param performanceAsOfDate2
     * @param benchmarkDateFrom2
     * @param benchmarkDateTo2
     */
    private void setSessionValueForProfileAlert(Date paperformanceAsOfDate,
            Date pabenchmarkDateFrom, Date pabenchmarkDateTo) {
        System.out.println("Setting values for profileAlert...");
        setSessionAttribute("paperformanceasofdate", paperformanceAsOfDate);
        setSessionAttribute("pabenchmarkDateFrom", pabenchmarkDateFrom);
        setSessionAttribute("pabenchmarkDateTo", pabenchmarkDateTo);
    }

    private void setPerformanceValue() throws SVTException{

        setChannelPerformanceValue(); //will use this call, instead of setValue()
    }
    
    public void setChannelOptimizationOutbound(String channelOptimizationOutbound) {
        this.channelOptimizationOutbound = channelOptimizationOutbound;
    }
 
    public String getChannelPerformanceTabClick() throws SVTException{
        setPerformanceValue();

        // This is very bad pcs of coding, please move it to right place
        setSessionAttribute("actionTakenOnPopup", null); // used inside TwitterController constructor.
        setSessionAttribute("validCredentials", null); // used inside TwitterController constructor.
        ////////////////////////////////////////////////
        return channelPerformanceTabClick;
    }
    
    /**
     * First time, user login and data comes with all default values
     * @throws SVTException
     */
    public List<OverallPerformanceDummy> getOverallPerformanceDummy() throws SVTException {        
        return overallPerformanceDummy;
    }

    private void setChannelPerformanceValue() throws SVTException{
//         System.out.println("TAB: Calling setChannelPerformanceValue(): " + getPerformanceAsOfDate());
//        System.out.println("TAB: getFromProfileId(): " + getFromProfileId());
//        System.out.println("TAB: getBenchmarkDateFrom(): " + getBenchmarkDateFrom());
//        System.out.println("TAB: getBenchmarkDateTo(): " + getBenchmarkDateTo());
//        System.out.println("TAB: getTargetId(): " + getTargetId());
//        System.out.println("TAB: getTwitterAccountId(): " + getTwitterAccountId());    
//        System.out.println("TAB: getCurrentUid(): " + getCurrentUid());  

   if(getSentimentName() == null){ //1234
        TwitterCalculatorChlPerfDTO dto = getTwitterCalculatorMgr().getChannelPerformance(getPerformanceAsOfDate(), getCurrentUid(), getTwitterAccountId(), getBenchmarkDateFrom(), getBenchmarkDateTo(), getTargetId());
       setOverallPerformanceDummy(dto.getOverallPerformanceDummy());
       getRTOPHandler().setOutboundMetricsDummy(dto.getOutboundMetricsDummy());
       setInboundMetricsDummy(dto.getInboundMetricsDummy());
       setEngagementDummy(dto.getEngagementDummy());
       setReachDummy(dto.getReachDummy());
       setLoyaltyDummy(dto.getLoyaltyDummy());
       setDemographicsDummy(dto.getDemographicsDummy());
       setRetentionDummy(dto.getRetentionDummy());
       setInfluenceDummy(dto.getInfluenceDummy());
       setSentimentDummy(dto.getSentimentDummy());
       setTwitterAccount(getTwitterAccountMgr().getByProfileUserIdSELF(getCurrentUid())); // populate profile listbox
       setTargetList(getImprovementLevelMgr().findAll()); // populate profile listbox
       setBenchmarkDateFrom(dto.getBenchmarkDateFrom());
       setBenchmarkDateTo(dto.getBenchmarkDateTo());
       
       setMinPerformanceAsofDiffFromCurrentDate(dto.getMinPerformanceAsofDiffFromCurrentDate());
       setMaxPerformanceAsofDiffFromCurrentDate(dto.getMaxPerformanceAsofDiffFromCurrentDate());
       setMinBenchmarkAsofDiffFromCurrentDate(dto.getMinBenchmarkAsofDiffFromCurrentDate());
       
       System.out.println("Reset date: " + dto.getResetDate());
       setResetDate(dto.getResetDate());
       setMinDate(dto.getMinDate().getTime());
       setMaxDate(dto.getMaxdate().getTime());
       
       sortCollection(dto);
       
//       //Sorting logic here based on user clicks
//       Collections.sort(dto.getOutboundMetricsDummy(), new MetricsOutboundComparator(getSortByColumn("1"), getOrd("1")));
//       Collections.sort(dto.getInboundMetricsDummy(), new MetricsInboundComparator(getSortByColumn("2"), getOrd("2")));
//       Collections.sort(dto.getEngagementDummy(), new MetricsSIComparator(getSortByColumn("3"), getOrd("3")));
//       Collections.sort(dto.getReachDummy(), new MetricsSIComparator(getSortByColumn("4"), getOrd("4")));
//       Collections.sort(dto.getLoyaltyDummy(), new MetricsSIComparator(getSortByColumn("5"), getOrd("5")));
//       Collections.sort(dto.getDemographicsDummy(), new MetricsSIComparator(getSortByColumn("6"), getOrd("6")));
//       Collections.sort(dto.getRetentionDummy(), new MetricsSIComparator(getSortByColumn("7"), getOrd("7")));
//       Collections.sort(dto.getInfluenceDummy(), new MetricsSIComparator(getSortByColumn("8"), getOrd("8")));
//       Collections.sort(dto.getSentimentDummy(), new MetricsSIComparator(getSortByColumn("9"), getOrd("9")));
       
   }

    }

    /**
     * User clicks on the submit button
     * @param ae
     * @throws SVTException 
     */
    public void submitQuery(ActionEvent ae) throws SVTException
    {
        System.out.println("Executing ChannelPerformanceController#submitQuery()");
        
        TwitterCalculatorChlPerfDTO dto = getTwitterCalculatorMgr().getChannelPerformance(getPerformanceAsOfDate(), getCurrentUid(), getTwitterAccountId(), getBenchmarkDateFrom(), getBenchmarkDateTo(), getTargetId());
        setOverallPerformanceDummy(dto.getOverallPerformanceDummy());
        getRTOPHandler().setOutboundMetricsDummy(dto.getOutboundMetricsDummy());
        setInboundMetricsDummy(dto.getInboundMetricsDummy());
        setEngagementDummy(dto.getEngagementDummy());
        setReachDummy(dto.getReachDummy());
        setLoyaltyDummy(dto.getLoyaltyDummy());
        setDemographicsDummy(dto.getDemographicsDummy());
        setRetentionDummy(dto.getRetentionDummy());
        setInfluenceDummy(dto.getInfluenceDummy());
        setSentimentDummy(dto.getSentimentDummy());
        setTwitterAccount(getTwitterAccountMgr().getByProfileUserIdSELF(getCurrentUid())); // populate profile listbox
        setTargetList(getImprovementLevelMgr().findAll()); // populate profile listbox
        setBenchmarkDateFrom(dto.getBenchmarkDateFrom());
        setBenchmarkDateTo(dto.getBenchmarkDateTo());
        setMinPerformanceAsofDiffFromCurrentDate(dto.getMinPerformanceAsofDiffFromCurrentDate());
        setMaxPerformanceAsofDiffFromCurrentDate(dto.getMaxPerformanceAsofDiffFromCurrentDate());
        setMinBenchmarkAsofDiffFromCurrentDate(dto.getMinBenchmarkAsofDiffFromCurrentDate());

        //Sorting logic here based on user clicks
        sortCollection(dto);
        
        setMinDate(Long.parseLong(getParameter("minDate")));
        setMaxDate(Long.parseLong(getParameter("maxDate")));
    }


    private void sortCollection(TwitterCalculatorChlPerfDTO dto) {
        if(isDefaultSorting()){
            System.out.println("Default sorting..............................");
            Collections.sort(dto.getOutboundMetricsDummy(), new MetricsOutboundComparator("yv", "A"));
            Collections.sort(dto.getInboundMetricsDummy(), new MetricsInboundComparator("yv", "A"));
            Collections.sort(dto.getEngagementDummy(), new MetricsSIComparator("yv", "A"));
            Collections.sort(dto.getReachDummy(), new MetricsSIComparator("yv", "A"));
            Collections.sort(dto.getLoyaltyDummy(), new MetricsSIComparator("yv", "A"));
            Collections.sort(dto.getDemographicsDummy(), new MetricsSIComparator("yv", "A"));
            Collections.sort(dto.getRetentionDummy(), new MetricsSIComparator("yv", "A"));
            Collections.sort(dto.getInfluenceDummy(), new MetricsSIComparator("yv", "A"));
            Collections.sort(dto.getSentimentDummy(), new MetricsSIComparator("yv", "A"));            
         }else{
             Collections.sort(dto.getOutboundMetricsDummy(), new MetricsOutboundComparator(getSortByColumn("1"), getOrd("1")));
             Collections.sort(dto.getInboundMetricsDummy(), new MetricsInboundComparator(getSortByColumn("2"), getOrd("2")));
             Collections.sort(dto.getEngagementDummy(), new MetricsSIComparator(getSortByColumn("3"), getOrd("3")));
             Collections.sort(dto.getReachDummy(), new MetricsSIComparator(getSortByColumn("4"), getOrd("4")));
             Collections.sort(dto.getLoyaltyDummy(), new MetricsSIComparator(getSortByColumn("5"), getOrd("5")));
             Collections.sort(dto.getDemographicsDummy(), new MetricsSIComparator(getSortByColumn("6"), getOrd("6")));
             Collections.sort(dto.getRetentionDummy(), new MetricsSIComparator(getSortByColumn("7"), getOrd("7")));
             Collections.sort(dto.getInfluenceDummy(), new MetricsSIComparator(getSortByColumn("8"), getOrd("8")));
             Collections.sort(dto.getSentimentDummy(), new MetricsSIComparator(getSortByColumn("9"), getOrd("9")));           
         }

        
    }

    class MetricsOutboundComparator implements Comparator<OutboundMetricsDummy> {
        String sortByColumn="";
        String sortOrder="";
        public MetricsOutboundComparator(String sortByColumn, String sortOrder) {
            this.sortByColumn=(sortByColumn==null)?(""):(sortByColumn);
            this.sortOrder=(sortOrder==null)?(""):(sortOrder);
        }

        public int compare(OutboundMetricsDummy outbound1, OutboundMetricsDummy outbound2) {
            if(sortByColumn.equalsIgnoreCase("yv")){
                if(sortOrder.equalsIgnoreCase("A")){
                    String custVolume1 = outbound1.getCustVolume(); 
                    String custVolume2 = outbound2.getCustVolume();
                    if(outbound1.getMetricId().equals("29")){ // Total Volume of US Profile Reference should come last
                        custVolume1= "20000";
                    }
                    if(outbound2.getMetricId().equals("29")){ // Total Volume of US Profile Reference should come last
                       custVolume2= "20000";
                    }
                    return getCompareResultAsc(custVolume1, custVolume2); 
                }else{
                    return getCompareResultDesc(outbound1.getCustVolume(), outbound2.getCustVolume());  
                }               
            }
            if(sortByColumn.equalsIgnoreCase("cv")){
                if(sortOrder.equalsIgnoreCase("A")){
                    return getCompareResultAsc(outbound1.getCmptVolume(), outbound2.getCmptVolume()); 
                }else{
                    return getCompareResultDesc(outbound1.getCmptVolume(), outbound2.getCmptVolume());  
                }               
            }
            if(sortByColumn.equalsIgnoreCase("yt")){
                if(sortOrder.equalsIgnoreCase("A")){
                    return getCompareResultAsc(outbound1.getCustTarget(), outbound2.getCustTarget()); 
                }else{
                    return getCompareResultDesc(outbound1.getCustTarget(), outbound2.getCustTarget());  
                }               
            }
            if(sortByColumn.equalsIgnoreCase("pi")){
                if(sortOrder.equalsIgnoreCase("A")){
                    return getCompareResultAsc(outbound1.getPercentIncrease(), outbound2.getPercentIncrease()); 
                }else{
                    return getCompareResultDesc(outbound1.getPercentIncrease(), outbound2.getPercentIncrease());  
                }               
            }
            
            // Default sortOrder and column (CustVolume, Ascending)
            return getCompareResultAsc(outbound1.getCustVolume(), outbound2.getCustVolume());
        }
        
        private int getCompareResultAsc(String value1, String value2) {
            if(value1== null || value1 == ""){
                value1= "10000";
            }
            if(value2== null || value2 == ""){
                value2= "10000";
            }
            int value1a = (int) (Double.parseDouble(value1.trim())*1000);
            int value2a = (int) (Double.parseDouble(value2.trim())*1000);
            return (value1a - value2a);
        }
        private int getCompareResultDesc(String value1, String value2) {
            if(value1== null || value1 == ""){
                value1= "-2";
            }
            if(value2== null || value2 == ""){
                value2= "-2";
            }
            int value1a = (int) (Double.parseDouble(value1)*10000000);
            int value2a = (int) (Double.parseDouble(value2)*10000000);
            return value2a - value1a;
        }
    }

    class MetricsInboundComparator implements Comparator<InboundMetricsDummy> {
        String sortByColumn="";
        String sortOrder="";
        public MetricsInboundComparator(String sortByColumn, String sortOrder) {
            this.sortByColumn=(sortByColumn==null)?(""):(sortByColumn);
            this.sortOrder=(sortOrder==null)?(""):(sortOrder);
        }
        
        public int compare(InboundMetricsDummy inbound1, InboundMetricsDummy inbound2) {
            if(sortByColumn.equalsIgnoreCase("yv")){
                if(sortOrder.equalsIgnoreCase("A")){
                    return getCompareResultAsc(inbound1.getCustVolume(), inbound2.getCustVolume()); 
                }else{
                    return getCompareResultDesc(inbound1.getCustVolume(), inbound2.getCustVolume());  
                }               
            }
            if(sortByColumn.equalsIgnoreCase("cv")){
                if(sortOrder.equalsIgnoreCase("A")){
                    return getCompareResultAsc(inbound1.getCmptVolume(), inbound2.getCmptVolume()); 
                }else{
                    return getCompareResultDesc(inbound1.getCmptVolume(), inbound2.getCmptVolume());  
                }               
            }
            if(sortByColumn.equalsIgnoreCase("yt")){
                if(sortOrder.equalsIgnoreCase("A")){
                    return getCompareResultAsc(inbound1.getCustTarget(), inbound2.getCustTarget()); 
                }else{
                    return getCompareResultDesc(inbound1.getCustTarget(), inbound2.getCustTarget());  
                }               
            }
            if(sortByColumn.equalsIgnoreCase("pi")){
                if(sortOrder.equalsIgnoreCase("A")){
                    return getCompareResultAsc(inbound1.getPercentIncrease(), inbound2.getPercentIncrease()); 
                }else{
                    return getCompareResultDesc(inbound1.getPercentIncrease(), inbound2.getPercentIncrease());  
                }               
            }
            
            // Default sortOrder and column (CustVolume, Ascending)
            return getCompareResultAsc(inbound1.getCustVolume(), inbound2.getCustVolume());
        }
        
        private int getCompareResultAsc(String value1, String value2) {
            if(value1== null || value1 == ""){
                value1= "10000";
            }
            if(value2== null || value2 == ""){
                value2= "10000";
            }            
            int value1a = (int) (Double.parseDouble(value1)*10000);
            int value2a = (int) (Double.parseDouble(value2)*10000);
            return value1a - value2a;
        }
        private int getCompareResultDesc(String value1, String value2) {
            if(value1== null || value1 == ""){
                value1= "-2";
            }
            if(value2== null || value2 == ""){
                value2= "-2";
            }
            int value1a = (int) (Double.parseDouble(value1)*10000);
            int value2a = (int) (Double.parseDouble(value2)*10000);
            return value2a - value1a;
        }
    }

    class MetricsSIComparator implements Comparator<SocialIntelligenceMetricsDummy> {
        String sortByColumn="";
        String sortOrder="";
        public MetricsSIComparator(String sortByColumn, String sortOrder) {
            this.sortByColumn=(sortByColumn==null)?(""):(sortByColumn);
            this.sortOrder=(sortOrder==null)?(""):(sortOrder);
        }

        public int compare(SocialIntelligenceMetricsDummy si1, SocialIntelligenceMetricsDummy si2) {
            if(sortByColumn.equalsIgnoreCase("yv")){
                if(sortOrder.equalsIgnoreCase("A")){
                    return getCompareResultAsc(si1.getCustVolume(), si2.getCustVolume()); 
                }else{
                    return getCompareResultDesc(si1.getCustVolume(), si2.getCustVolume());  
                }               
            }
            if(sortByColumn.equalsIgnoreCase("cv")){
                if(sortOrder.equalsIgnoreCase("A")){
                    return getCompareResultAsc(si1.getCmptVolume(), si2.getCmptVolume()); 
                }else{
                    return getCompareResultDesc(si1.getCmptVolume(), si2.getCmptVolume());  
                }               
            }
            if(sortByColumn.equalsIgnoreCase("yt")){
                if(sortOrder.equalsIgnoreCase("A")){
                    return getCompareResultAsc(si1.getCustTarget(), si2.getCustTarget()); 
                }else{
                    return getCompareResultDesc(si1.getCustTarget(), si2.getCustTarget());  
                }               
            }
            if(sortByColumn.equalsIgnoreCase("pi")){
                if(sortOrder.equalsIgnoreCase("A")){
                    return getCompareResultAsc(si1.getPercentIncrease(), si2.getPercentIncrease()); 
                }else{
                    return getCompareResultDesc(si1.getPercentIncrease(), si2.getPercentIncrease());  
                }               
            }
            
            // Default sortOrder and column (CustVolume, Ascending)
            return getCompareResultAsc(si1.getCustVolume(), si2.getCustVolume());
        }
        
        private int getCompareResultAsc(String value1, String value2) {
            if(value1== null || value1 == ""){
                value1= "10000";
            }
            if(value2== null || value2 == ""){
                value2= "10000";
            }            
            int value1a = (int) (Double.parseDouble(value1)*10000);
            int value2a = (int) (Double.parseDouble(value2)*10000);
            return value1a - value2a;
        }
        private int getCompareResultDesc(String value1, String value2) {
            if(value1== null || value1 == ""){
                value1= "-2";
            }
            if(value2== null || value2 == ""){
                value2= "-2";
            }
            int value1a = (int) (Double.parseDouble(value1)*10000);
            int value2a = (int) (Double.parseDouble(value2)*10000);
            return value2a - value1a;
        }
    } 
    
    /**
     * @deprecated
     * This method is going to be deprecated
     * @throws SVTException
     */
    private void setValue() throws SVTException{

        setCurrentProfileId(getParameter(PROFILE_ID));
        String profileIdFromContext = getCurrentProfileId();
        if(profileIdFromContext == null){
            setProfileId("0");
        }else{
            setProfileId(profileIdFromContext);
        }
        
        setParameterValues();
       setOverallPerformanceDummy(getOverallDummyMgr().getByProfileId(getProfileId()));
       getRTOPHandler().setOutboundMetricsDummy(getOutboundDummyMgr().getByProfileId(getProfileId(), getSortByColumn("1"), getOrd("1")));       
       setInboundMetricsDummy(getInboundDummyMgr().getByProfileId(getProfileId(), getSortByColumn("2"), getOrd("2")));
       setEngagementDummy(getSocIntellDummyMgr().getByProfileIdEngagement(getProfileId(), getSortByColumn("3"), getOrd("3")));
       setReachDummy(getSocIntellDummyMgr().getByProfileIdReach(getProfileId(), getSortByColumn("4"), getOrd("4")));
       setLoyaltyDummy(getSocIntellDummyMgr().getByProfileIdLoyalty(getProfileId(), getSortByColumn("5"), getOrd("5")));
       setDemographicsDummy(getSocIntellDummyMgr().getByProfileIdDemographics(getProfileId(), getSortByColumn("6"), getOrd("6")));
       setRetentionDummy(getSocIntellDummyMgr().getByProfileIdRetention(getProfileId(), getSortByColumn("7"), getOrd("7")));
       setInfluenceDummy(getSocIntellDummyMgr().getByProfileIdInfluence(getProfileId(), getSortByColumn("8"), getOrd("8")));
       setSentimentDummy(getSocIntellDummyMgr().getByProfileIdSentiment(getProfileId(), getSortByColumn("9"), getOrd("9")));
       setTwitterAccount(getTwitterAccountMgr().getByProfilePreferenceIdSELF("1"));
       setTargetList(getImprovementLevelMgr().findAll()); // populate profile listbox
    }

    
    private String getSortByColumn(String sentimentPosition) {
        String sentimentPos = getSentimentName();
        if(sentimentPos == null){
            return null;
        }
        if(sentimentPos.equalsIgnoreCase(sentimentPosition)){
            
            return getSortBy();
        }
        return null;
    }

    private String getOrd(String sentimentPosition) {
        String sentimentPos = getSentimentName();
        if(sentimentPos == null){
            return null;
        }
        if(sentimentPos.equalsIgnoreCase(sentimentPosition)){
            String sortByColumn = getSortBy(); 
            
            if(sortByColumn != null && sortByColumn.equalsIgnoreCase("cv")){
                // Customer Volume - Toggle control
                if(getOrdCV() == null){
                    setOrdCV("A");
                }else if(getOrdCV().equals("A")){
                    setOrdCV("D");
                }else if(getOrdCV().equals("D")){
                    setOrdCV("A"); 
                }
                return getOrdCV();
            }else if(sortByColumn != null && sortByColumn.equalsIgnoreCase("yv")){
                // Your Volume - Toggle control
                if(getOrdYV() == null){
                    setOrdYV("A");
                }else if(getOrdYV().equals("A")){
                    setOrdYV("D");
                }else if(getOrdYV().equals("D")){
                    setOrdYV("A"); 
                }
                return getOrdYV();
            }else if(sortByColumn != null && sortByColumn.equalsIgnoreCase("yt")){
                // Your Volume - Toggle control
                if(getOrdYT() == null){
                    setOrdYT("A");
                }else if(getOrdYT().equals("A")){
                    setOrdYT("D");
                }else if(getOrdYT().equals("D")){
                    setOrdYT("A"); 
                }
                return getOrdYT();
            }else if(sortByColumn != null && sortByColumn.equalsIgnoreCase("pi")){
                // Your Volume - Toggle control
                if(getOrdPI() == null){
                    setOrdPI("A");
                }else if(getOrdPI().equals("A")){
                    setOrdPI("D");
                }else if(getOrdPI().equals("D")){
                    setOrdPI("A"); 
                }
                return getOrdPI();
            }
        }
        return null;
    }

    private void setDefaultParameter() throws SVTException {
        performanceAsOfDate = getCurrentDate();
        profileId = getCurrentUid();
        fromProfileId=profileId;
        twitterAccountId="0";
        benchmarkDateFrom=getCurrentDate();
        benchmarkDateTo=getCurrentDate();
        ProfilePreferenceDTO pdto = getProfilePreferenceMgr().getByProfileUserId(profileId);
        if(pdto != null){
            //performanceAsOfDate = getBizSvcFactory().getMsgDataCreationLogMgr().getMaxActionDate(pdto.getProfilePrefrenceId());
            performanceAsOfDate = getBizSvcFactory().getMetricCreationTrackerMgr().getMaxActionDateProfilePrefId(pdto.getProfilePrefrenceId());
            if(pdto.getBenchmark() != null){
                benchmarkDateFrom=pdto.getBenchmark().getBenchmarkStDate();
                benchmarkDateTo=pdto.getBenchmark().getBenchmarkEdDate();    
            }
        }
        targetName=getProfileTargetName(getCurrentUid());
        targetId=getProfileTargetId(getCurrentUid());
    }

    private void setParameterValues() {
        if(getParameter(TARGETTYPE) == null){
            setTarget("M");
        }else{
        setTarget(getParameter(TARGETTYPE));
        }
    }
    
    public String getColor() {
        if(flg==0)
        {
            this.color = "#ededed";
            flg=1;
        }
        else
        {
            this.color = "white";
            flg=0;
        }
        return color;
    }
   
    /**
     * As per wendys' request only overallcolor needs to be displayed and it should be orange, dated 16-May-2011
     * @return
     * @throws SVTException
     */
    public String getOverallColor() throws SVTException {
        if(cnt<8)
        {
            OverallPerformanceDummy yourDto= getOverallPerformance().get(0);
            OverallPerformanceDummy cmptDto= getOverallPerformance().get(1);
            
           if(methodCount == 0)
            {
                yourGrade = yourDto.getOverallGrade();
                compititors = cmptDto.getOverallGrade();
                methodCount ++;
            }
            else if(methodCount == 1)
            {
                yourGrade = yourDto.getSentimentGrade();
                compititors = cmptDto.getSentimentGrade();
                methodCount ++;
            }
            else if(methodCount == 2)
            {
                yourGrade = yourDto.getEngagementGrade();
                compititors = cmptDto.getEngagementGrade();
                methodCount ++;
            }
            else if(methodCount == 3)
            {
                yourGrade = yourDto.getRetentionGrade();
                compititors = cmptDto.getRetentionGrade();
                methodCount ++;
            }
            else if(methodCount == 4)
            {
                yourGrade = yourDto.getDemographicsGrade();
                compititors = cmptDto.getDemographicsGrade();
                methodCount ++;
            }
            else if(methodCount == 5)
            {
                yourGrade = yourDto.getLoyaltyGrade();
                compititors = cmptDto.getLoyaltyGrade();
                methodCount ++;
            }
            else if(methodCount == 6)
            {
                yourGrade = yourDto.getInfluenceGrade();
                compititors = cmptDto.getInfluenceGrade();
                methodCount ++;
            }
            else if(methodCount == 7)
            {
                yourGrade = yourDto.getReachGrade();
                compititors = cmptDto.getReachGrade();
                methodCount ++;
            }
            cnt++;
            String colCode = new GradeList().calculateColor(yourGrade,compititors); 
            al.add(colCode);
            return colCode; 
        }
        else
        {
            cnt++;
            if( i > 7) i=0;
            return al.get(i++);
        }
        
    }

/*    public void setOverallPerformanceGridColor(String overallPerformanceGridColor) {
        this.overallPerformanceGridColor = overallPerformanceGridColor;
    }
*/    
    
// Added By Neel, Ended Here

    public List<OverallPerformanceDummy> getOverallPerformance() throws SVTException {
        return overallPerformanceDummy;
    }


 
    
    public void setOverallPerformanceDummy(
            List<OverallPerformanceDummy> overallPerformanceDummy) {
        this.overallPerformanceDummy = overallPerformanceDummy;
    }
    public String getProfileId() {
        return profileId;
    }


    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
   
    public List<OutboundMetricsDummy> getBottom10OutboundMetricsDummy() {
        // need to display first 10 rows, so checking if at least 10 rows exist or not, 
        // data is storted by most under performing value desc 
        if(getRTOPHandler().getOutboundMetricsDummy() != null && getRTOPHandler().getOutboundMetricsDummy().size() >= 10){
            return getRTOPHandler().getOutboundMetricsDummy().subList(0, 10);
        }
        return getRTOPHandler().getOutboundMetricsDummy();
    }
   

    public List<SocialIntelligenceMetricsDummy> getDemographicsDummy() {
        return demographicsDummy;
    }

    public void setDemographicsDummy(
            List<SocialIntelligenceMetricsDummy> demographicsDummy) {
        this.demographicsDummy = demographicsDummy;
    }

    public List<SocialIntelligenceMetricsDummy> getEngagementDummy() {
        return engagementDummy;
    }

    public void setEngagementDummy(
            List<SocialIntelligenceMetricsDummy> engagementDummy) {
        this.engagementDummy = engagementDummy;
    }

    public List<InboundMetricsDummy> getInboundMetricsDummy() {
        return inboundMetricsDummy;
    }

    public void setInboundMetricsDummy(List<InboundMetricsDummy> inboundMetricsDummy) {
        this.inboundMetricsDummy = inboundMetricsDummy;
    }

    public List<SocialIntelligenceMetricsDummy> getInfluenceDummy() {
        return influenceDummy;
    }

    public void setInfluenceDummy(
            List<SocialIntelligenceMetricsDummy> influenceDummy) {
        this.influenceDummy = influenceDummy;
    }

    public List<SocialIntelligenceMetricsDummy> getLoyaltyDummy() {
        return loyaltyDummy;
    }

    public void setLoyaltyDummy(List<SocialIntelligenceMetricsDummy> loyaltyDummy) {
        this.loyaltyDummy = loyaltyDummy;
    }

    public List<SocialIntelligenceMetricsDummy> getReachDummy() {
        return reachDummy;
    }

    public void setReachDummy(List<SocialIntelligenceMetricsDummy> reachDummy) {
        this.reachDummy = reachDummy;
    }

    public List<SocialIntelligenceMetricsDummy> getRetentionDummy() {
        return retentionDummy;
    }

    public void setRetentionDummy(
            List<SocialIntelligenceMetricsDummy> retentionDummy) {
        this.retentionDummy = retentionDummy;
    }

    public List<SocialIntelligenceMetricsDummy> getSentimentDummy() {
        return sentimentDummy;
    }

    public void setSentimentDummy(
            List<SocialIntelligenceMetricsDummy> sentimentDummy) {
        this.sentimentDummy = sentimentDummy;
    }
    public String getSelectedTwitterUsername() {
        return getUserFromTwitterProfile(getParameter(PROFILE_ID));
    }

    private String getUserFromTwitterProfile(String profileId1) {
        if(profileId1 == null){
            profileId1="0";
        }
        for(TwitterAccountDTO dto : getTwitterAccount()){
            if(dto.getTwitterAccountId().equalsIgnoreCase(profileId1)){
                return dto.getTwitterUsername();
            }
        }
        return "All";  
    }

    public void setSelectedTwitterUsername(String selectedTwitterUsername) {
        this.selectedTwitterUsername = selectedTwitterUsername;
    }
    public String getOrdYV() {
        return getSessionAttribute(ORDERBYYV);
    }

    public void setOrdYV(String ord) {
        setSessionAttribute(ORDERBYYV, ord);
    }
    public String getOrdCV() {
        return getSessionAttribute(ORDERBYCV);
    }

    public void setOrdCV(String ord) {
        setSessionAttribute(ORDERBYCV, ord);
    }

    public String getOrdYT() {
        return getSessionAttribute(ORDERBYYT);
    }

    public void setOrdYT(String ord) {
        setSessionAttribute(ORDERBYYT, ord);
    }
    public String getOrdPI() {
        return getSessionAttribute(ORDERBYPI);
    }

    public void setOrdPI(String ord) {
        setSessionAttribute(ORDERBYPI, ord);
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
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

    public Date getPerformanceAsOfDate() {
        return performanceAsOfDate;
    }

    public void setPerformanceAsOfDate(Date performanceAsOfDate) {
        this.performanceAsOfDate = performanceAsOfDate;
    }

    public String getFromProfileId() {
        return fromProfileId;
    }

    public void setFromProfileId(String fromProfileId) {
        this.fromProfileId = fromProfileId;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getTwitterAccountId() {
        return twitterAccountId;
    }

    public void setTwitterAccountId(String twitterAccountId) {
        this.twitterAccountId = twitterAccountId;
    }

    public String getTwitterAccountName() {
        return twitterAccountName;
    }

    public void setTwitterAccountName(String twitterAccountName) {
        this.twitterAccountName = twitterAccountName;
    }

    public int getMinPerformanceAsofDiffFromCurrentDate() {
        return minPerformanceAsofDiffFromCurrentDate;
    }

    public void setMinPerformanceAsofDiffFromCurrentDate(
            int minPerformanceAsofDiffFromCurrentDate) {
        this.minPerformanceAsofDiffFromCurrentDate = minPerformanceAsofDiffFromCurrentDate;
    }

    public int getMaxPerformanceAsofDiffFromCurrentDate() {
        return maxPerformanceAsofDiffFromCurrentDate;
    }

    public void setMaxPerformanceAsofDiffFromCurrentDate(
            int maxPerformanceAsofDiffFromCurrentDate) {
        this.maxPerformanceAsofDiffFromCurrentDate = maxPerformanceAsofDiffFromCurrentDate;
    }

    public int getMinBenchmarkAsofDiffFromCurrentDate() {
        return minBenchmarkAsofDiffFromCurrentDate;
    }

    public void setMinBenchmarkAsofDiffFromCurrentDate(
            int minBenchmarkAsofDiffFromCurrentDate) {
        this.minBenchmarkAsofDiffFromCurrentDate = minBenchmarkAsofDiffFromCurrentDate;
    }
    
  //--------- Added By Neel, Started Here ------------------------------ 
    public SelectItem[] getSelfTwitterAccounts()    {
        
        List<TwitterAccountDTO> twtAccList = getTwitterAccount();
        if(twtAccList !=null && twtAccList.size()>0) {
            SelectItem[] acc = new SelectItem[twtAccList.size()];
            
            for (int i = 0; i <twtAccList.size(); i++) {
                acc[i] = new SelectItem();
                acc[i].setLabel("@"+twtAccList.get(i).getTwitterUsername().replace(" ","").replace("#", ""));
                acc[i].setValue("@"+twtAccList.get(i).getTwitterUsername().replace(" ","").replace("#", ""));
            }
            return acc;
        }
        return null;
    }
    public String getFirstSelfTwitterAccounts(){
        if(getTwitterAccount() != null && getTwitterAccount().size() > 0){
            return "@" + getTwitterAccount().get(0).getTwitterUsername();
        }
        return "";
    }
    private boolean isDefaultSorting() {
        if(getSortByColumn("1") == null &&
           getSortByColumn("2") == null &&
           getSortByColumn("3") == null &&
           getSortByColumn("4") == null &&
           getSortByColumn("5") == null &&
           getSortByColumn("6") == null &&
           getSortByColumn("7") == null &&
           getSortByColumn("8") == null &&
           getSortByColumn("9") == null){
            return true;
        }           
        return false;
    }

//--------- Added By Neel, Ended Here ------------------------------    

    public String getClickedSentiment() {
        return clickedSentiment;
    }

    public void setClickedSentiment(String clickedSentiment) {
        this.clickedSentiment = clickedSentiment;
    }
    
    @Deprecated
    public void changeTarget() throws SVTException
    {
        System.out.println("Change target clicked.....");
    }

    public String getTrendingCategorySelected() {
        return trendingCategorySelected;
    }

    public void setTrendingCategorySelected(String trendingCategorySelected) {
        this.trendingCategorySelected = trendingCategorySelected;
    }

    public String getTrendingModeDWMSelected() {
        return trendingModeDWMSelected;
    }

    public void setTrendingModeDWMSelected(String trendingModeDWMSelected) {
        this.trendingModeDWMSelected = trendingModeDWMSelected;
    }

    public String getTrendingSelfSelected() {
        return trendingSelfSelected;
    }

    public void setTrendingSelfSelected(String trendingSelfSelected) {
        this.trendingSelfSelected = trendingSelfSelected;
    }

    public String getRtoGoalPercentage() {
        return rtoGoalPercentage;
    }

    public void setRtoGoalPercentage(String rtoGoalPercentage) {
        this.rtoGoalPercentage = rtoGoalPercentage;
    }

    public int getRtoStarCount() {
        return rtoStarCount;
    }

    public void setRtoStarCount(int rtoStarCount) {
        this.rtoStarCount = rtoStarCount;
    }

    public int getRtoFlameCount() {
        return rtoFlameCount;
    }

    public void setRtoFlameCount(int rtoFlameCount) {
        this.rtoFlameCount = rtoFlameCount;
    }      
    
    public void optimizeButtonClick(ActionEvent event) {
        System.out.println("================= Optimize Button Clicked From Channel Performance =================");        
        String optimizeAction = getParameter("optimizeAction");
        System.out.println("Optimize Action: " + optimizeAction);
        if(StringUtils.isNotBlank(optimizeAction)) {
            if(optimizeAction.endsWith(".jsp")) {
                getRTOPHandler().setPopupDTO(getPopupDTO(optimizeAction));
                getRTOPHandler().setRenderPopupPanel(true);                
            } else {
                getRTOPHandler().setFilterId(getFilter(optimizeAction));
                getRTOPHandler().setRenderFilterPanel(true);
            }
            getRTOPHandler().setOptimizeActionDTOs(null);
            getRTOPHandler().setRenderChannelPerformanceActionsPanel(true);
            if(!getRTOPHandler().getSelectedHandler().equals("All")) {
                setSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME, getRTOPHandler().getSelectedHandler());
            }            
        }                
    }
    
    private String getFilter(String optimizeAction) {
        String filterId = "";
        if (optimizeAction.equals(TwitterControllerConstants.OFF)) {
            filterId = TwitterControllerConstants.OFF;
        } else if(optimizeAction.equals("Brand Mentions")) {
            filterId = TwitterControllerConstants.BRAND;
        } else if(optimizeAction.equals("Hashtag")) {
            filterId = TwitterControllerConstants.HASHTAG;
        } else if(optimizeAction.equals("Industry Mentions")) {
            filterId = TwitterControllerConstants.INDUSTRY;
        } else if(optimizeAction.equals("Influencer")) {
            filterId = TwitterControllerConstants.INFLUENCER;
        } else if (optimizeAction.equals("Mention")) {
            filterId = TwitterControllerConstants.MENTION;
        } else if(optimizeAction.equals("Negative Sentiment")) {
            filterId = TwitterControllerConstants.NEGATIVE;
        } else if(optimizeAction.equals("Positive Sentiment")) {
            filterId = TwitterControllerConstants.POSITIVE;
        } else if(optimizeAction.equals("Product Mentions")) {
            filterId = TwitterControllerConstants.PRODUCT;
        } else if(optimizeAction.equals("Shortened Urls")) {
            filterId = TwitterControllerConstants.BITLY;
        } else if(optimizeAction.equals("Theme")) {
            filterId = TwitterControllerConstants.THEME;
        }
        
        return "filter:" + filterId;
    }
    
    private AlertPopupDTO getPopupDTO(String optimizeAction) {
        AlertPopupDTO popupDTO = null;
        if(optimizeAction.equals("influFollowAlert.jsp")) {
            popupDTO = new AlertPopupDTO("Influencers to Follow", "influFollowAlert.jsp", 355, 690, 220, 324, "1");
        } else if(optimizeAction.equals("tweetsFavoriteAlert.jsp")){
            popupDTO = new AlertPopupDTO("Tweets to favorite", "tweetsFavoriteAlert.jsp", 320, 820, 220, 240, "2");
        } else if(optimizeAction.equals("addToListAlert.jsp")) {
            popupDTO = new AlertPopupDTO("Add to List", "addToListAlert.jsp", 320, 820, 220, 180, "3");
        } else if(optimizeAction.equals("RTThanks.jsp")) {
            popupDTO = new AlertPopupDTO("RT (Retweets) to Thank", "RTThanks.jsp", 320, 830, 220, 150, "4");
        } else if(optimizeAction.equals("missingProfileBio.jsp")) {
            popupDTO = new AlertPopupDTO("Missing Profile Bio", "missingProfileBio.jsp", 310, 430, 220, 454, "5");
        } else if (optimizeAction.equals("missingCustomBkg.jsp")) {
            popupDTO = new AlertPopupDTO("Missing Custom Bkg", "missingCustomBkg.jsp", 300, 430, 220, 454, "6");
        } else if (optimizeAction.equals("missingProfilePicture.jsp")) {
            popupDTO = new AlertPopupDTO("Missing Profile Picture", "missingProfilePicture.jsp", 300, 430, 220, 454, "7");
        } else if (optimizeAction.equals("geoLocationSetting.jsp")) {
            popupDTO = new AlertPopupDTO("Missing Profile Picture", "geoLocationSetting.jsp", 310, 430, 220, 454, "8");
        }else if(optimizeAction.equals("DMToReturn.jsp")) {
            popupDTO = new AlertPopupDTO("Return DM", "DMToReturn.jsp", 320, 820, 220, 240, "9");
        }
        
        return popupDTO;
    }
}
