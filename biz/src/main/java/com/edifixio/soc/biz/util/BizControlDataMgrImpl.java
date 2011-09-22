// $Author: subratog $
package com.edifixio.soc.biz.util;

import com.edifixio.soc.batch.TwitterMgr;
import com.edifixio.soc.biz.BaseMgr;
import com.edifixio.soc.biz.BenchmarkMgr;
import com.edifixio.soc.biz.CategoryMgr;
import com.edifixio.soc.biz.ChannelMgr;
import com.edifixio.soc.biz.CompanyMgr;
import com.edifixio.soc.biz.ImprovementLevelMgr;
import com.edifixio.soc.biz.InboundDummyMgr;
import com.edifixio.soc.biz.MetricCreationTrackerMgr;
import com.edifixio.soc.biz.MetricsMgr;
import com.edifixio.soc.biz.MsgDataCreationLogMgr;
import com.edifixio.soc.biz.OutboundDummyMgr;
import com.edifixio.soc.biz.OverallDummyMgr;
import com.edifixio.soc.biz.ParameterMgr;
import com.edifixio.soc.biz.ProfileDummyMgr;
import com.edifixio.soc.biz.ProfileInfluenceListMgr;
import com.edifixio.soc.biz.ProfileInfluenceMgr;
import com.edifixio.soc.biz.ProfileListMasterMgr;
import com.edifixio.soc.biz.ProfilePreferenceMgr;
import com.edifixio.soc.biz.RTOPScheduleMgr;
import com.edifixio.soc.biz.RawResultMgr;
import com.edifixio.soc.biz.SocIntellDummyMgr;
import com.edifixio.soc.biz.StagingRawScoreMgr;
import com.edifixio.soc.biz.StateProvinceMgr;
import com.edifixio.soc.biz.TimeZoneMgr;
import com.edifixio.soc.biz.TrendingGradeMgr;
import com.edifixio.soc.biz.TwitLogMgr;
import com.edifixio.soc.biz.TwitterAccountMgr;
import com.edifixio.soc.biz.TwitterCalculatorMgr;
import com.edifixio.soc.biz.UserProfileMgr;


public class BizControlDataMgrImpl extends BaseBizObject implements
        BizControlDataMgr {
    private ChannelMgr channelMgr;
    private CategoryMgr categoryMgr;
    
    private UserProfileMgr userProfileMgr;
    private BenchmarkMgr benchmarkMgr; 
    private StagingRawScoreMgr stagingRawScoreMgr; 
    private TwitterAccountMgr twitterAccountMgr; 
    private MetricsMgr metricsMgr; 
    private ProfilePreferenceMgr profilePreferenceMgr; 
    private TwitterMgr twitterMgr;
    private StateProvinceMgr stateProvinceMgr;
    public ProfileInfluenceMgr profileInfluenceMgr;
    public ProfileInfluenceListMgr profileInfluenceListMgr;
    public ProfileListMasterMgr profileListMasterMgr;
    public ImprovementLevelMgr improvementLevelMgr;
    public TwitterCalculatorMgr twitterCalculatorMgr;
    public RawResultMgr rawResultMgr;
    public TwitLogMgr twitLogMgr;
    public ParameterMgr parameterMgr;
    public CompanyMgr companyMgr;
    public TimeZoneMgr timeZoneMgr;
    public RTOPScheduleMgr rtopScheduleMgr;
    public TrendingGradeMgr trendingGradeMgr;
    public MsgDataCreationLogMgr msgDataCreationLogMgr;
    public MetricCreationTrackerMgr metricCreationTrackerMgr;
    
    // all dummy needs to be removed after 9-Dec presentation
    
    private InboundDummyMgr inboundDummyMgr;
    private OutboundDummyMgr outboundDummyMgr;
    private OverallDummyMgr overallDummyMgr;
    private ProfileDummyMgr profileDummyMgr;
    private SocIntellDummyMgr socIntellDummyMgr;
    
    
    
    public InboundDummyMgr getInboundDummyMgr() {
        return inboundDummyMgr;
    }

    public void setInboundDummyMgr(InboundDummyMgr inboundDummyMgr) {
        this.inboundDummyMgr = inboundDummyMgr;
    }

    public OutboundDummyMgr getOutboundDummyMgr() {
        return outboundDummyMgr;
    }

    public void setOutboundDummyMgr(OutboundDummyMgr outboundDummyMgr) {
        this.outboundDummyMgr = outboundDummyMgr;
    }

    public OverallDummyMgr getOverallDummyMgr() {
        return overallDummyMgr;
    }

    public void setOverallDummyMgr(OverallDummyMgr overallDummyMgr) {
        this.overallDummyMgr = overallDummyMgr;
    }

    public ProfileDummyMgr getProfileDummyMgr() {
        return profileDummyMgr;
    }

    public void setProfileDummyMgr(ProfileDummyMgr profileDummyMgr) {
        this.profileDummyMgr = profileDummyMgr;
    }

    public SocIntellDummyMgr getSocIntellDummyMgr() {
        return socIntellDummyMgr;
    }

    public void setSocIntellDummyMgr(SocIntellDummyMgr socIntellDummyMgr) {
        this.socIntellDummyMgr = socIntellDummyMgr;
    }

    public ProfilePreferenceMgr getProfilePreferenceMgr() {
        updateBenchmarkId(profilePreferenceMgr);
        return profilePreferenceMgr;
    }

    public void setProfilePreferenceMgr(ProfilePreferenceMgr profilePreferenceMgr) {
        this.profilePreferenceMgr = profilePreferenceMgr;
    }

    public MetricsMgr getMetricsMgr() {
        updateBenchmarkId(metricsMgr);
        return metricsMgr;
    }

    public void setMetricsMgr(MetricsMgr metricsMgr) {
        this.metricsMgr = metricsMgr;
    }

    public TwitterAccountMgr getTwitterAccountMgr() {
        updateBenchmarkId(twitterAccountMgr);
        return twitterAccountMgr;
    }

    public void setTwitterAccountMgr(TwitterAccountMgr twitterAccountMgr) {
        this.twitterAccountMgr = twitterAccountMgr;
    }

    public StagingRawScoreMgr getStagingRawScoreMgr() {
        updateBenchmarkId(stagingRawScoreMgr);
        return stagingRawScoreMgr;
    }

    public void setStagingRawScoreMgr(StagingRawScoreMgr stagingRawScoreMgr) {
        this.stagingRawScoreMgr = stagingRawScoreMgr;
    }

    public UserProfileMgr getUserProfileMgr() {
        updateBenchmarkId(userProfileMgr);
        return userProfileMgr;
    }

    public void setUserProfileMgr(UserProfileMgr userProfileMgr) {
        this.userProfileMgr = userProfileMgr;
    }
    public void setChannelMgr(ChannelMgr channelMgr) {
        this.channelMgr = channelMgr;
    }
    public ChannelMgr getChannelMgr() {
        updateBenchmarkId(channelMgr);
        return channelMgr;
    }
    public CategoryMgr getCategoryMgr() {
        updateBenchmarkId(categoryMgr);
        return categoryMgr;
    }
    public void setCategoryMgr(CategoryMgr categoryMgr) {
        this.categoryMgr = categoryMgr;
    }

    public BenchmarkMgr getBenchmarkMgr() {
        updateBenchmarkId(benchmarkMgr);
        return benchmarkMgr;
    }
    public void setBenchmarkMgr(BenchmarkMgr benchmarkMgr) {
        this.benchmarkMgr = benchmarkMgr;
    }
    private void updateBenchmarkId(BaseMgr mgr){
        mgr.setCurrentBenchmarkId(getCurrentBenchmarkId());
    }

    public TwitterMgr getTwitterMgr() {
        return twitterMgr;
    }

    public void setTwitterMgr(TwitterMgr twitterMgr) {
        this.twitterMgr = twitterMgr;
    }

    public StateProvinceMgr getStateProvinceMgr() {
        return stateProvinceMgr;
    }

    public void setStateProvinceMgr(StateProvinceMgr stateProvinceMgr) {
        this.stateProvinceMgr = stateProvinceMgr;
    }

    public ProfileInfluenceListMgr getProfileInfluenceListMgr() {
        return profileInfluenceListMgr;
    }

    public void setProfileInfluenceListMgr(
            ProfileInfluenceListMgr profileInfluenceListMgr) {
        this.profileInfluenceListMgr = profileInfluenceListMgr;
    }

    public ProfileInfluenceMgr getProfileInfluenceMgr() {
        return profileInfluenceMgr;
    }

    public void setProfileInfluenceMgr(ProfileInfluenceMgr profileInfluenceMgr) {
        this.profileInfluenceMgr = profileInfluenceMgr;
    }

    public ProfileListMasterMgr getProfileListMasterMgr() {
        return profileListMasterMgr;
    }

    public void setProfileListMasterMgr(ProfileListMasterMgr profileListMasterMgr) {
        this.profileListMasterMgr = profileListMasterMgr;
    }

    public ImprovementLevelMgr getImprovementLevelMgr() {
        return improvementLevelMgr;
    }

    public void setImprovementLevelMgr(ImprovementLevelMgr improvementLevelMgr) {
        this.improvementLevelMgr = improvementLevelMgr;
    }

    public TwitterCalculatorMgr getTwitterCalculatorMgr() {
        return twitterCalculatorMgr;
    }

    public void setTwitterCalculatorMgr(TwitterCalculatorMgr twitterCalculatorMgr) {
        this.twitterCalculatorMgr = twitterCalculatorMgr;
    }

    public RawResultMgr getRawResultMgr() {
        return rawResultMgr;
    }

    public void setRawResultMgr(RawResultMgr rawResultMgr) {
        this.rawResultMgr = rawResultMgr;
    }

    public TwitLogMgr getTwitLogMgr() {
        return twitLogMgr;
    }

    public void setTwitLogMgr(TwitLogMgr twitLogMgr) {
        this.twitLogMgr = twitLogMgr;
    }

    public ParameterMgr getParameterMgr() {
        return parameterMgr;
    }

    public void setParameterMgr(ParameterMgr parameterMgr) {
        this.parameterMgr = parameterMgr;
    }

    public CompanyMgr getCompanyMgr() {
        return companyMgr;
    }

    public void setCompanyMgr(CompanyMgr companyMgr) {
        this.companyMgr = companyMgr;
    }

    public TimeZoneMgr getTimeZoneMgr() {
        return timeZoneMgr;
    }

    public void setTimeZoneMgr(TimeZoneMgr timeZoneMgr) {
        this.timeZoneMgr = timeZoneMgr;
    }

    public RTOPScheduleMgr getRtopScheduleMgr() {
        return rtopScheduleMgr;
    }

    public void setRtopScheduleMgr(RTOPScheduleMgr rtopScheduleMgr) {
        this.rtopScheduleMgr = rtopScheduleMgr;
    }

    public TrendingGradeMgr getTrendingGradeMgr() {
        return trendingGradeMgr;
    }

    public void setTrendingGradeMgr(TrendingGradeMgr trendingGradeMgr) {
        this.trendingGradeMgr = trendingGradeMgr;
    }

    public MsgDataCreationLogMgr getMsgDataCreationLogMgr() {
        return msgDataCreationLogMgr;
    }

    public void setMsgDataCreationLogMgr(MsgDataCreationLogMgr msgDataCreationLogMgr) {
        this.msgDataCreationLogMgr = msgDataCreationLogMgr;
    }

    public MetricCreationTrackerMgr getMetricCreationTrackerMgr() {
        return metricCreationTrackerMgr;
    }

    public void setMetricCreationTrackerMgr(
            MetricCreationTrackerMgr metricCreationTrackerMgr) {
        this.metricCreationTrackerMgr = metricCreationTrackerMgr;
    }
}
