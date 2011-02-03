package com.edifixio.soc.web.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.InboundMetricsDummy;
import com.edifixio.soc.persist.OutboundMetricsDummy;
import com.edifixio.soc.persist.OverallPerformanceDummy;
import com.edifixio.soc.persist.SocialIntelligenceMetricsDummy;
import com.edifixio.soc.web.dto.TwitterCalculatorChlPerfDTO;

public class ChannelPerformanceController extends BaseWebObject 
{
   private static final String MAIN_SCREEN_JSP = "mainScreen.jsp";
   private String si;
   private String col;
   
   private String selectedTwitterUsername;
   
   private List<OverallPerformanceDummy> overallPerformanceDummy;
   private List<OutboundMetricsDummy> outboundMetricsDummy;
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
   
    public ChannelPerformanceController() throws SVTException
    {
        // Place it in the right place please: not the right place to keep this code
        //setPerformanceValue();
        //setValue();
        setDefaultParameter();
    }

    public void populateWithDefault(ActionEvent ae) throws SVTException{

        setPerformanceValue();
    }
    
    public String getChannelOptimizationOutbound() throws SVTException {
        setPerformanceValue();
        return channelOptimizationOutbound;
    }

    private void setPerformanceValue() throws SVTException{

        setChannelPerformanceValue(); //will use this call, instead of setValue()
    }
    
    public void setChannelOptimizationOutbound(String channelOptimizationOutbound) {
        this.channelOptimizationOutbound = channelOptimizationOutbound;
    }
 
    public String getChannelPerformanceTabClick() throws SVTException{
        setPerformanceValue();
        return channelPerformanceTabClick;
    }

//    public void setChannelPerformanceTabClick(String channelPerformanceTabClick) throws SVTException{
//        this.channelPerformanceTabClick = channelPerformanceTabClick;
//    }

    /**
     * User clicks on ChannelPerformanceTab
     * @throws SVTException
     * @throws IOException 
     */
//    public void channelPerformanceTabClick(ActionEvent ae) throws SVTException, IOException {        
//        System.out.println("channelPerformanceTabClick().......");
//        setDefaultParameter();
//        setChannelPerformanceValue();
//        FacesContext.getCurrentInstance().getExternalContext().redirect(MAIN_SCREEN_JSP);
//    }
    
    /**
     * First time, user login and data comes with all default values
     * @throws SVTException
     */
    public List<OverallPerformanceDummy> getOverallPerformanceDummy() throws SVTException {        
        return overallPerformanceDummy;
    }

    private void setChannelPerformanceValue() throws SVTException{
//         System.out.println("Calling setChannelPerformanceValue(): " + getPerformanceAsOfDate());
//        System.out.println("getFromProfileId(): " + getFromProfileId());
//        System.out.println("getBenchmarkDateFrom(): " + getBenchmarkDateFrom());
//        System.out.println("getBenchmarkDateTo(): " + getBenchmarkDateTo());
        //System.out.println("getTargetId(): " + getTargetId());

   if(getSentimentName() == null){ //1234
        TwitterCalculatorChlPerfDTO dto = getTwitterCalculatorMgr().getChannelPerformance(getPerformanceAsOfDate(), getCurrentUid(), getTwitterAccountId(), getBenchmarkDateFrom(), getBenchmarkDateTo(), getTargetId());
       setOverallPerformanceDummy(dto.getOverallPerformanceDummy());
       setOutboundMetricsDummy(dto.getOutboundMetricsDummy());
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
//        System.out.println("SortByColumn: " +  getSortByColumn("1"));
//        System.out.println("Order: " + getOrd("1"));
//        System.out.println("**getPerformanceAsOfDate(): " + getPerformanceAsOfDate());
//        System.out.println("currentProfile: " + getCurrentUid());
//        System.out.println("getFromProfileId(): " + getFromProfileId());
//        System.out.println("getBenchmarkDateFrom(): " + getBenchmarkDateFrom());
//        System.out.println("getBenchmarkDateTo(): " + getBenchmarkDateTo());
//        System.out.println("getTargetId(): " + getTargetId());
//        System.out.println("Column Clicked: " + getSentimentName());
//        System.out.println("Order by: " + getSortBy());
        
        TwitterCalculatorChlPerfDTO dto = getTwitterCalculatorMgr().getChannelPerformance(getPerformanceAsOfDate(), getCurrentUid(), getTwitterAccountId(), getBenchmarkDateFrom(), getBenchmarkDateTo(), getTargetId());
        setOverallPerformanceDummy(dto.getOverallPerformanceDummy());
        setOutboundMetricsDummy(dto.getOutboundMetricsDummy());
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

        //Sorting logic here based on user clicks
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

   
    /**
     * User clicks on the Change Target Listbox
     * @param ae
     * @throws SVTException 
     */
    public void changeTarget(ValueChangeEvent ae) throws SVTException
    {
        System.out.println("Change target clicked.....");
        TwitterCalculatorChlPerfDTO dto = getTwitterCalculatorMgr().getChannelPerformance(getPerformanceAsOfDate(), getCurrentUid(), getTwitterAccountId(), getBenchmarkDateFrom(), getBenchmarkDateTo(), getTargetId());
        setOutboundMetricsDummy(dto.getOutboundMetricsDummy());
        setInboundMetricsDummy(dto.getInboundMetricsDummy());
        setEngagementDummy(dto.getEngagementDummy());
        setReachDummy(dto.getReachDummy());
        setLoyaltyDummy(dto.getLoyaltyDummy());
        setDemographicsDummy(dto.getDemographicsDummy());
        setRetentionDummy(dto.getRetentionDummy());
        setInfluenceDummy(dto.getInfluenceDummy());
        setSentimentDummy(dto.getSentimentDummy());
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
                    return getCompareResultAsc(outbound1.getCustVolume(), outbound2.getCustVolume()); 
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
            if(value1== null || value2== null || value1 == "" || value2 == ""){
                return 99;
            }            
            int value1a = (int) (Double.parseDouble(value1)*10000);
            int value2a = (int) (Double.parseDouble(value2)*10000);
            return value1a - value2a;
        }
        private int getCompareResultDesc(String value1, String value2) {
            if(value1== null || value2== null || value1 == "" || value2 == ""){
                return -2;
            }
            int value1a = (int) (Double.parseDouble(value1)*10000);
            int value2a = (int) (Double.parseDouble(value2)*10000);
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
            if(value1== null || value2== null || value1 == "" || value2 == ""){
                return 99;
            }            
            int value1a = (int) (Double.parseDouble(value1)*10000);
            int value2a = (int) (Double.parseDouble(value2)*10000);
            return value1a - value2a;
        }
        private int getCompareResultDesc(String value1, String value2) {
            if(value1== null || value2== null || value1 == "" || value2 == ""){
                return -2;
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
            if(value1== null || value2== null || value1 == "" || value2 == ""){
                return 99;
            }            
            int value1a = (int) (Double.parseDouble(value1)*10000);
            int value2a = (int) (Double.parseDouble(value2)*10000);
            return value1a - value2a;
        }
        private int getCompareResultDesc(String value1, String value2) {
            if(value1== null || value2== null || value1 == "" || value2 == ""){
                return -2;
            }
            int value1a = (int) (Double.parseDouble(value1)*10000);
            int value2a = (int) (Double.parseDouble(value2)*10000);
            return value2a - value1a;
        }
    } 
    
    /**
     * This method is going to be Deprecated
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
       setOutboundMetricsDummy(getOutboundDummyMgr().getByProfileId(getProfileId(), getSortByColumn("1"), getOrd("1")));       
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

//    private void setParameterValues() {
//        setCurrentProfileId(getParameter(PROFILE_ID));
//        String profileIdFromContext = getCurrentProfileId();
//        if(profileIdFromContext == null){
//            setProfileId("0");
//        }else{
//            setProfileId(profileIdFromContext);
//        }
//        if(getParameter(TARGETTYPE) == null){
//            setTarget("M");
//        }else{
//        setTarget(getParameter(TARGETTYPE));
//        }
//        setSentimentName(getParameter(SENTIMENTNAME));
//        setSortBy(getParameter(SORTBY));
//    }

    private void setDefaultParameter() throws SVTException {
        performanceAsOfDate = getCurrentDate();
        profileId = getCurrentUid();
        fromProfileId=profileId;
        twitterAccountId="0";
//        benchmarkDateFrom=getCurrentDate();
//        benchmarkDateTo=getCurrentDate();
        targetName=getProfileTargetName(getCurrentUid());
        targetId=getProfileTargetId(getCurrentUid());
    }

    private void setParameterValues() {
        if(getParameter(TARGETTYPE) == null){
            setTarget("M");
        }else{
        setTarget(getParameter(TARGETTYPE));
        }
        //setSentimentName(getParameter(SENTIMENTNAME));
        //setSortBy(getParameter(SORTBY));
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
    public List<OutboundMetricsDummy> getOutboundMetricsDummy() {
        return outboundMetricsDummy;
    }

    public void setOutboundMetricsDummy(
            List<OutboundMetricsDummy> outboundMetricsDummy) {
        this.outboundMetricsDummy = outboundMetricsDummy;
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
}
