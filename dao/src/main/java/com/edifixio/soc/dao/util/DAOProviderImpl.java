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


public class DAOProviderImpl implements DAOProvider {
    private ChannelDAO<Channel> channelDAO;
    private CategoryDAO<Category> categoryDAO;
    private MetricsDAO<Metrics> subCategoryDAO;    
    private BenchmarkDAO<Benchmark> benchmarkDAO; 
    public BrandDAO<Brand> brandDAO;   
    public ProductDAO<Product> productDAO;    
    public IndustryDAO<Industry> industryDAO;  
    
    public StagingScoreDAO<StagingScore> stagingScoreDAO;  
    public StagingRawScoreDAO<StagingRawScore> stagingRawScoreDAO; 
    public TwitterAccountDAO<TwitterAccount> twitterAccountDAO; 
    public MetricsDAO<Metrics> metricsDAO; 
    public ProfilePreferenceDAO<ProfilePreference> profilePreferenceDAO; 
    public UserProfileDetailDAO<UserProfileDetail> userProfileDetailDAO;
    public ScoreDAO<Score> scoreDAO;
    public CompanyDAO<Company> companyDAO;
    public MetricsProcessHandlerDAO<MetricsProcessHandler> metricsProcessHandlerDAO;
    private StateProvinceDAO<StateProvince> stateProvinceDAO; 
    private ProfileInfluenceDAO<ProfileInfluence> profileInfluenceDAO;
    private ProfileInfluenceListDAO<ProfileInfluenceList> profileInfluenceListDAO;
    private ProfileListMasterDAO<ProfileListMaster> profileListMasterDAO;
    private ImprovementLevelDAO<ImprovementLevel> improvementLevelDAO;
    private RawResultDAO<RawResult> rawResultDAO;
    
    private String benchmarkId;
    
    
    // For dummy Data, needs to be removed after 9-Dec presentation
    public InboundMetricsDummyDAO<InboundMetricsDummy> inboundMetricsDummyDAO;
    public OutboundMetricsDummyDAO<OutboundMetricsDummy> outboundMetricsDummyDAO;
    public OverallPerformanceDummyDAO<OverallPerformanceDummy> overallPerformanceDummyDAO;
    public ProfileDummyDAO<ProfileDummy> profileDummyDAO;
    public SocialIntelligenceMetricsDummyDAO<SocialIntelligenceMetricsDummy> socialIntelligenceMetricsDummyDAO;

    
    
    public ProfilePreferenceDAO<ProfilePreference> getProfilePreferenceDAO() {
        updateBenchmarkId(profilePreferenceDAO);
        return profilePreferenceDAO;
    }
    public void setProfilePreferenceDAO(
            ProfilePreferenceDAO<ProfilePreference> profilePreferenceDAO) {
        this.profilePreferenceDAO = profilePreferenceDAO;
    }
    public MetricsDAO<Metrics> getMetricsDAO() {
        updateBenchmarkId(metricsDAO);
        return metricsDAO;
    }
    public void setMetricsDAO(MetricsDAO<Metrics> metricsDAO) {
        this.metricsDAO = metricsDAO;
    }
    public TwitterAccountDAO<TwitterAccount> getTwitterAccountDAO() {
        updateBenchmarkId(twitterAccountDAO);
        return twitterAccountDAO;
    }
    public void setTwitterAccountDAO(
            TwitterAccountDAO<TwitterAccount> twitterAccountDAO) {
        this.twitterAccountDAO = twitterAccountDAO;
    }
    
    public StagingRawScoreDAO<StagingRawScore> getStagingRawScoreDAO() {
        updateBenchmarkId(stagingRawScoreDAO);
        return stagingRawScoreDAO;
    }
    public void setStagingRawScoreDAO(StagingRawScoreDAO<StagingRawScore> stagingRawScoreDAO) {
        this.stagingRawScoreDAO = stagingRawScoreDAO;
    }
    public ChannelDAO<Channel> getChannelDAO() {
        updateBenchmarkId(channelDAO);
        return channelDAO;
    }


    public void setChannelDAO(ChannelDAO<Channel> channelDAO) {
        this.channelDAO = channelDAO;
    }

    public CategoryDAO<Category> getCategoryDAO() {
        updateBenchmarkId(categoryDAO);
        return categoryDAO;
    }


    public void setCategoryDAO(CategoryDAO<Category> categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
    public MetricsDAO<Metrics> getSubCategoryDAO() {
        updateBenchmarkId(subCategoryDAO);
        return subCategoryDAO;
    }


    public void setSubCategoryDAO(MetricsDAO<Metrics> subCategoryDAO) {
        this.subCategoryDAO = subCategoryDAO;
    }

    public BenchmarkDAO<Benchmark> getBenchmarkDAO() {
        updateBenchmarkId(benchmarkDAO);
        return benchmarkDAO;
    }

    public void setBenchmarkDAO(BenchmarkDAO<Benchmark> benchmarkDAO) {
        this.benchmarkDAO = benchmarkDAO;
    }
    
    public void setBenchmarkId(String benchmarkId) {
        this.benchmarkId = benchmarkId;
    }
    
    private void updateBenchmarkId(Object dao){
        ((BaseHibernateDAO)dao).setBenchmarkId(benchmarkId);
    }
    public StagingScoreDAO<StagingScore> getStagingScoreDAO() {
        updateBenchmarkId(stagingScoreDAO);
        return stagingScoreDAO;
    }
    public void setStagingScoreDAO(StagingScoreDAO<StagingScore> stagingScoreDAO) {
        this.stagingScoreDAO = stagingScoreDAO;
    }
    public ScoreDAO<Score> getScoreDAO() {
        return scoreDAO;
    }
    public void setScoreDAO(ScoreDAO<Score> scoreDAO) {
        this.scoreDAO = scoreDAO;
    }
    public CompanyDAO<Company> getCompanyDAO() {
        return companyDAO;
    }
    public void setCompanyDAO(CompanyDAO<Company> companyDAO) {
        this.companyDAO = companyDAO;
    }
    public MetricsProcessHandlerDAO<MetricsProcessHandler> getMetricsProcessHandlerDAO() {
        return metricsProcessHandlerDAO;
    }
    public void setMetricsProcessHandlerDAO(
            MetricsProcessHandlerDAO<MetricsProcessHandler> metricsProcessHandlerDAO) {
        this.metricsProcessHandlerDAO = metricsProcessHandlerDAO;
    }
    public InboundMetricsDummyDAO<InboundMetricsDummy> getInboundMetricsDummyDAO() {
        return inboundMetricsDummyDAO;
    }
    public void setInboundMetricsDummyDAO(
            InboundMetricsDummyDAO<InboundMetricsDummy> inboundMetricsDummyDAO) {
        this.inboundMetricsDummyDAO = inboundMetricsDummyDAO;
    }
    public OutboundMetricsDummyDAO<OutboundMetricsDummy> getOutboundMetricsDummyDAO() {
        return outboundMetricsDummyDAO;
    }
    public void setOutboundMetricsDummyDAO(
            OutboundMetricsDummyDAO<OutboundMetricsDummy> outboundMetricsDummyDAO) {
        this.outboundMetricsDummyDAO = outboundMetricsDummyDAO;
    }
    public OverallPerformanceDummyDAO<OverallPerformanceDummy> getOverallPerformanceDummyDAO() {
        return overallPerformanceDummyDAO;
    }
    public void setOverallPerformanceDummyDAO(
            OverallPerformanceDummyDAO<OverallPerformanceDummy> overallPerformanceDummyDAO) {
        this.overallPerformanceDummyDAO = overallPerformanceDummyDAO;
    }
    public ProfileDummyDAO<ProfileDummy> getProfileDummyDAO() {
        return profileDummyDAO;
    }
    public void setProfileDummyDAO(ProfileDummyDAO<ProfileDummy> profileDummyDAO) {
        this.profileDummyDAO = profileDummyDAO;
    }
    public SocialIntelligenceMetricsDummyDAO<SocialIntelligenceMetricsDummy> getSocialIntelligenceMetricsDummyDAO() {
        return socialIntelligenceMetricsDummyDAO;
    }
    public void setSocialIntelligenceMetricsDummyDAO(
            SocialIntelligenceMetricsDummyDAO<SocialIntelligenceMetricsDummy> socialIntelligenceMetricsDummyDAO) {
        this.socialIntelligenceMetricsDummyDAO = socialIntelligenceMetricsDummyDAO;
    }

    public StateProvinceDAO<StateProvince> getStateProvinceDAO() {
        updateBenchmarkId(stateProvinceDAO);
        return stateProvinceDAO;
    }


    public void setStateProvinceDAO(StateProvinceDAO<StateProvince> stateProvinceDAO) {
        this.stateProvinceDAO = stateProvinceDAO;
    }
    public UserProfileDetailDAO<UserProfileDetail> getUserProfileDetailDAO() {
        return userProfileDetailDAO;
    }
    public void setUserProfileDetailDAO(
            UserProfileDetailDAO<UserProfileDetail> userProfileDetailDAO) {
        this.userProfileDetailDAO = userProfileDetailDAO;
    }
    public BrandDAO<Brand> getBrandDAO() {
        return brandDAO;
    }
    public void setBrandDAO(BrandDAO<Brand> brandDAO) {
        this.brandDAO = brandDAO;
    }
    public IndustryDAO<Industry> getIndustryDAO() {
        return industryDAO;
    }
    public void setIndustryDAO(IndustryDAO<Industry> industryDAO) {
        this.industryDAO = industryDAO;
    }
    public ProductDAO<Product> getProductDAO() {
        return productDAO;
    }
    public void setProductDAO(ProductDAO<Product> productDAO) {
        this.productDAO = productDAO;
    }
    public ProfileInfluenceDAO<ProfileInfluence> getProfileInfluenceDAO() {
        return profileInfluenceDAO;
    }
    public void setProfileInfluenceDAO(
            ProfileInfluenceDAO<ProfileInfluence> profileInfluenceDAO) {
        this.profileInfluenceDAO = profileInfluenceDAO;
    }
    public ProfileInfluenceListDAO<ProfileInfluenceList> getProfileInfluenceListDAO() {
        return profileInfluenceListDAO;
    }
    public void setProfileInfluenceListDAO(
            ProfileInfluenceListDAO<ProfileInfluenceList> profileInfluenceListDAO) {
        this.profileInfluenceListDAO = profileInfluenceListDAO;
    }
    public ProfileListMasterDAO<ProfileListMaster> getProfileListMasterDAO() {
        return profileListMasterDAO;
    }
    public void setProfileListMasterDAO(
            ProfileListMasterDAO<ProfileListMaster> profileListMasterDAO) {
        this.profileListMasterDAO = profileListMasterDAO;
    }
    public ImprovementLevelDAO<ImprovementLevel> getImprovementLevelDAO() {
        return improvementLevelDAO;
    }
    public void setImprovementLevelDAO(
            ImprovementLevelDAO<ImprovementLevel> improvementLevelDAO) {
        this.improvementLevelDAO = improvementLevelDAO;
    }
    public RawResultDAO<RawResult> getRawResultDAO() {
        return rawResultDAO;
    }
    public void setRawResultDAO(RawResultDAO<RawResult> rawResultDAO) {
        this.rawResultDAO = rawResultDAO;
    }

}
