// $Author: subratog $
package com.edifixio.soc.dao.util;

import com.edifixio.soc.dao.BenchmarkDAO;
import com.edifixio.soc.dao.BrandDAO;
import com.edifixio.soc.dao.CategoryDAO;
import com.edifixio.soc.dao.ChannelDAO;
import com.edifixio.soc.dao.CompanyDAO;
import com.edifixio.soc.dao.ImprovementLevelDAO;
import com.edifixio.soc.dao.InboundMetricsDummyDAO;
import com.edifixio.soc.dao.IndustryDAO;
import com.edifixio.soc.dao.MetricsDAO;
import com.edifixio.soc.dao.MetricsProcessHandlerDAO;
import com.edifixio.soc.dao.OutboundMetricsDummyDAO;
import com.edifixio.soc.dao.OverallPerformanceDummyDAO;
import com.edifixio.soc.dao.ProductDAO;
import com.edifixio.soc.dao.ProfileDummyDAO;
import com.edifixio.soc.dao.ProfileInfluenceDAO;
import com.edifixio.soc.dao.ProfileInfluenceListDAO;
import com.edifixio.soc.dao.ProfileListMasterDAO;
import com.edifixio.soc.dao.ProfilePreferenceDAO;
import com.edifixio.soc.dao.RawResultDAO;
import com.edifixio.soc.dao.ScoreDAO;
import com.edifixio.soc.dao.SocialIntelligenceMetricsDummyDAO;
import com.edifixio.soc.dao.StagingRawScoreDAO;
import com.edifixio.soc.dao.StagingScoreDAO;
import com.edifixio.soc.dao.StateProvinceDAO;
import com.edifixio.soc.dao.TwitterAccountDAO;
import com.edifixio.soc.dao.UserProfileDetailDAO;
import com.edifixio.soc.persist.Benchmark;
import com.edifixio.soc.persist.Brand;
import com.edifixio.soc.persist.Category;
import com.edifixio.soc.persist.Channel;
import com.edifixio.soc.persist.Company;
import com.edifixio.soc.persist.ImprovementLevel;
import com.edifixio.soc.persist.InboundMetricsDummy;
import com.edifixio.soc.persist.Industry;
import com.edifixio.soc.persist.Metrics;
import com.edifixio.soc.persist.MetricsProcessHandler;
import com.edifixio.soc.persist.OutboundMetricsDummy;
import com.edifixio.soc.persist.OverallPerformanceDummy;
import com.edifixio.soc.persist.Product;
import com.edifixio.soc.persist.ProfileDummy;
import com.edifixio.soc.persist.ProfileInfluence;
import com.edifixio.soc.persist.ProfileInfluenceList;
import com.edifixio.soc.persist.ProfileListMaster;
import com.edifixio.soc.persist.ProfilePreference;
import com.edifixio.soc.persist.RawResult;
import com.edifixio.soc.persist.Score;
import com.edifixio.soc.persist.SocialIntelligenceMetricsDummy;
import com.edifixio.soc.persist.StagingRawScore;
import com.edifixio.soc.persist.StagingScore;
import com.edifixio.soc.persist.StateProvince;
import com.edifixio.soc.persist.TwitterAccount;
import com.edifixio.soc.persist.UserProfileDetail;


public interface DAOProvider {
    public ChannelDAO<Channel> getChannelDAO();
    public CategoryDAO<Category> getCategoryDAO();
    public BenchmarkDAO<Benchmark> getBenchmarkDAO();   
    public MetricsDAO<Metrics> getSubCategoryDAO();        
    public BrandDAO<Brand> getBrandDAO();   
    public ProductDAO<Product> getProductDAO();    
    public IndustryDAO<Industry> getIndustryDAO();  

    // TWT
    public StagingScoreDAO<StagingScore> getStagingScoreDAO(); 
    public StagingRawScoreDAO<StagingRawScore> getStagingRawScoreDAO(); 
    public TwitterAccountDAO<TwitterAccount> getTwitterAccountDAO();
    public MetricsDAO<Metrics> getMetricsDAO();
    public ProfilePreferenceDAO<ProfilePreference> getProfilePreferenceDAO();
    public UserProfileDetailDAO<UserProfileDetail> getUserProfileDetailDAO();
    public ScoreDAO<Score> getScoreDAO();
    public CompanyDAO<Company> getCompanyDAO();
    public MetricsProcessHandlerDAO<MetricsProcessHandler> getMetricsProcessHandlerDAO();
    public StateProvinceDAO<StateProvince> getStateProvinceDAO();
    public ProfileInfluenceDAO<ProfileInfluence> getProfileInfluenceDAO();
    public ProfileInfluenceListDAO<ProfileInfluenceList> getProfileInfluenceListDAO();
    public ProfileListMasterDAO<ProfileListMaster> getProfileListMasterDAO();
    public ImprovementLevelDAO<ImprovementLevel> getImprovementLevelDAO();
    public RawResultDAO<RawResult> getRawResultDAO();
    
    public void setBenchmarkId(String benchmarkId);
    
    // For dummy Data, needs to be removed after 9-Dec presentation
    public InboundMetricsDummyDAO<InboundMetricsDummy> getInboundMetricsDummyDAO();
    public OutboundMetricsDummyDAO<OutboundMetricsDummy> getOutboundMetricsDummyDAO();
    public OverallPerformanceDummyDAO<OverallPerformanceDummy> getOverallPerformanceDummyDAO();
    public ProfileDummyDAO<ProfileDummy> getProfileDummyDAO();
    public SocialIntelligenceMetricsDummyDAO<SocialIntelligenceMetricsDummy> getSocialIntelligenceMetricsDummyDAO();
     
}
