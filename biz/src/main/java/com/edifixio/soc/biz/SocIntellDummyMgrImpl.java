// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.SocialIntelligenceMetricsDummy;

public class SocIntellDummyMgrImpl extends BaseBizObject implements SocIntellDummyMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(SocIntellDummyMgrImpl.class);

    public List<SocialIntelligenceMetricsDummy> findAll() throws SVTException {
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().findall();
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileId(String profileId) throws SVTException {
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileId(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdDemographics(String profileId) throws SVTException {
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdDemographics(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdEngagement(String profileId) throws SVTException {
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdEngagement(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdInfluence(String profileId) throws SVTException {
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdInfluence(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdLoyalty(String profileId) throws SVTException {
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdLoyalty(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdReach(String profileId) throws SVTException {
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdReach(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdRetention(String profileId) throws SVTException {
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdRetention(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdSentiment(String profileId) throws SVTException {
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdSentiment(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdDemographics(String profileId, String sortBy, String orderBy) throws SVTException {
        if(sortBy != null && sortBy.equalsIgnoreCase("cv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdDemographics(profileId,"cmptVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdDemographics(profileId,"custVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yt")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdDemographics(profileId,"custTarget", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("pi")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdDemographics(profileId,"percentIncrease", orderBy);
        }
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdDemographics(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdEngagement(String profileId, String sortBy, String orderBy) throws SVTException {
        if(sortBy != null && sortBy.equalsIgnoreCase("cv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdEngagement(profileId,"cmptVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdEngagement(profileId,"custVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yt")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdEngagement(profileId,"custTarget", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("pi")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdEngagement(profileId,"percentIncrease", orderBy);
        }
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdEngagement(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdInfluence(String profileId, String sortBy, String orderBy) throws SVTException {
        if(sortBy != null && sortBy.equalsIgnoreCase("cv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdInfluence(profileId,"cmptVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdInfluence(profileId,"custVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yt")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdInfluence(profileId,"custTarget", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("pi")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdInfluence(profileId,"percentIncrease", orderBy);
        }
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdInfluence(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdLoyalty(String profileId, String sortBy, String orderBy) throws SVTException {
        if(sortBy != null && sortBy.equalsIgnoreCase("cv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdLoyalty(profileId,"cmptVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdLoyalty(profileId,"custVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yt")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdLoyalty(profileId,"custTarget", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("pi")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdLoyalty(profileId,"percentIncrease", orderBy);
        }
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdLoyalty(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdReach(String profileId, String sortBy, String orderBy) throws SVTException {
        if(sortBy != null && sortBy.equalsIgnoreCase("cv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdReach(profileId,"cmptVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdReach(profileId,"custVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yt")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdReach(profileId,"custTarget", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("pi")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdReach(profileId,"percentIncrease", orderBy);
        }
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdReach(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdRetention(String profileId, String sortBy, String orderBy) throws SVTException {
        if(sortBy != null && sortBy.equalsIgnoreCase("cv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdRetention(profileId,"cmptVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdRetention(profileId,"custVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yt")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdRetention(profileId,"custTarget", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("pi")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdRetention(profileId,"percentIncrease", orderBy);
        }
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdRetention(profileId);
    }

    public List<SocialIntelligenceMetricsDummy> getByProfileIdSentiment(String profileId, String sortBy, String orderBy) throws SVTException {
        if(sortBy != null && sortBy.equalsIgnoreCase("cv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdSentiment(profileId,"cmptVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yv")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdSentiment(profileId,"custVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yt")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdSentiment(profileId,"custTarget", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("pi")){
            return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdSentiment(profileId,"percentIncrease", orderBy);
        }
        return getDaoProvider().getSocialIntelligenceMetricsDummyDAO().getByProfileIdSentiment(profileId);
    }
}
