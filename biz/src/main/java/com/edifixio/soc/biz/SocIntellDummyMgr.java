package com.edifixio.soc.biz;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.SocialIntelligenceMetricsDummy;

public interface SocIntellDummyMgr {
    List<SocialIntelligenceMetricsDummy> findAll() throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileId(String profileId) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileIdDemographics(String profileId) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileIdEngagement(String profileId) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileIdReach(String profileId) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileIdLoyalty(String profileId) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileIdRetention(String profileId) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileIdInfluence(String profileId) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileIdSentiment(String profileId) throws SVTException;

    List<SocialIntelligenceMetricsDummy> getByProfileIdDemographics(String profileId, String sortBy, String orderBy) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileIdEngagement(String profileId, String sortBy, String orderBy) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileIdReach(String profileId, String sortBy, String orderBy) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileIdLoyalty(String profileId, String sortBy, String orderBy) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileIdRetention(String profileId, String sortBy, String orderBy) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileIdInfluence(String profileId, String sortBy, String orderBy) throws SVTException;
    List<SocialIntelligenceMetricsDummy> getByProfileIdSentiment(String profileId, String sortBy, String orderBy) throws SVTException;

}
