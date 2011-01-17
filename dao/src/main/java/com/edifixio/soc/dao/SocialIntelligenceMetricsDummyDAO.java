package com.edifixio.soc.dao;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.SocialIntelligenceMetricsDummy;

public interface SocialIntelligenceMetricsDummyDAO<T extends SocialIntelligenceMetricsDummy> {
    public List<T> findall()  throws SVTException;
    public List<T> getByProfileId(String profileId) throws SVTException;
    public List<T> getByProfileIdDemographics(String profileId) throws SVTException;
    public List<T> getByProfileIdEngagement(String profileId) throws SVTException;
    public List<T> getByProfileIdReach(String profileId) throws SVTException;
    public List<T> getByProfileIdLoyalty(String profileId) throws SVTException;
    public List<T> getByProfileIdRetention(String profileId) throws SVTException;
    public List<T> getByProfileIdInfluence(String profileId) throws SVTException;
    public List<T> getByProfileIdSentiment(String profileId) throws SVTException;
    
    public List<T> getByProfileIdDemographics(String profileId, String orderByColumn, String sortOrder) throws SVTException;
    public List<T> getByProfileIdEngagement(String profileId, String orderByColumn, String sortOrder) throws SVTException;
    public List<T> getByProfileIdReach(String profileId, String orderByColumn, String sortOrder) throws SVTException;
    public List<T> getByProfileIdLoyalty(String profileId, String orderByColumn, String sortOrder) throws SVTException;
    public List<T> getByProfileIdRetention(String profileId, String orderByColumn, String sortOrder) throws SVTException;
    public List<T> getByProfileIdInfluence(String profileId, String orderByColumn, String sortOrder) throws SVTException;
    public List<T> getByProfileIdSentiment(String profileId, String orderByColumn, String sortOrder) throws SVTException;
}







