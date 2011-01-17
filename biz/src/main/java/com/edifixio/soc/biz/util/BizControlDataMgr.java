// $Author: subratog $
package com.edifixio.soc.biz.util;

import com.edifixio.soc.batch.TwitterMgr;
import com.edifixio.soc.biz.BenchmarkMgr;
import com.edifixio.soc.biz.CategoryMgr;
import com.edifixio.soc.biz.ChannelMgr;
import com.edifixio.soc.biz.ImprovementLevelMgr;
import com.edifixio.soc.biz.InboundDummyMgr;
import com.edifixio.soc.biz.MetricsMgr;
import com.edifixio.soc.biz.OutboundDummyMgr;
import com.edifixio.soc.biz.OverallDummyMgr;
import com.edifixio.soc.biz.ProfileDummyMgr;
import com.edifixio.soc.biz.ProfileInfluenceListMgr;
import com.edifixio.soc.biz.ProfileInfluenceMgr;
import com.edifixio.soc.biz.ProfileListMasterMgr;
import com.edifixio.soc.biz.ProfilePreferenceMgr;
import com.edifixio.soc.biz.RawResultMgr;
import com.edifixio.soc.biz.SocIntellDummyMgr;
import com.edifixio.soc.biz.StagingRawScoreMgr;
import com.edifixio.soc.biz.StateProvinceMgr;
import com.edifixio.soc.biz.TwitterAccountMgr;
import com.edifixio.soc.biz.TwitterCalculatorMgr;
import com.edifixio.soc.biz.UserProfileMgr;


public interface BizControlDataMgr {
    public static final String BIZ_SVC_FACTORY_SPRING_ID = "bizControlDataMgr";
    public ChannelMgr getChannelMgr();
    public CategoryMgr getCategoryMgr();
    
    public UserProfileMgr getUserProfileMgr();
    public StagingRawScoreMgr getStagingRawScoreMgr();
    public TwitterAccountMgr getTwitterAccountMgr();
    public MetricsMgr getMetricsMgr();
    public ProfilePreferenceMgr getProfilePreferenceMgr();
    public TwitterMgr getTwitterMgr();
    
    public BenchmarkMgr getBenchmarkMgr();
    public void setCurrentBenchmarkId(String currentBenchmarkId);
    public StateProvinceMgr getStateProvinceMgr();
    public ProfileInfluenceMgr getProfileInfluenceMgr();
    public ProfileInfluenceListMgr getProfileInfluenceListMgr();
    public ProfileListMasterMgr getProfileListMasterMgr();
    public ImprovementLevelMgr getImprovementLevelMgr();
    public TwitterCalculatorMgr getTwitterCalculatorMgr();
    public RawResultMgr getRawResultMgr();
    
    // all dummy needs to be removed after 9-Dec presentation
    
    public InboundDummyMgr getInboundDummyMgr();
    public OutboundDummyMgr getOutboundDummyMgr();
    public OverallDummyMgr getOverallDummyMgr();
    public ProfileDummyMgr getProfileDummyMgr();
    public SocIntellDummyMgr getSocIntellDummyMgr();
    
}
