// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.SocialIntelligenceMetricsDummy;


@SuppressWarnings("unchecked")
public class SocialIntelligenceMetricsDummyHibernateDAO<T extends SocialIntelligenceMetricsDummy> extends BaseHibernateDAO<T>
        implements SocialIntelligenceMetricsDummyDAO {
    private static final Log log = LogFactory.getLog(SocialIntelligenceMetricsDummyHibernateDAO.class);


    /**
     * Returns all the si
     * <p>
     * 
     * @return List of sids
     */
    public List findall() {
        List<T> t = find().list();
        return t;
    }

    public List getByProfileId(String profileId) throws SVTException {
        List<T> dummyData = find().where("this.profileId=?", profileId).list();
        return dummyData;
    }

    public List getByProfileIdDemographics(String profileId) throws SVTException {
        List<T> dummyData = find().where("this.profileId=?", profileId).and("this.type='Demographics'").orderDescending("this.pctPotnModerate").list();
        return dummyData;
    }

    public List getByProfileIdEngagement(String profileId) throws SVTException {
        List<T> dummyData = find().where("this.profileId=?", profileId).and("this.type='Engagement'").orderDescending("this.pctPotnModerate").list();
        return dummyData;
    }

    public List getByProfileIdInfluence(String profileId) throws SVTException {
        List<T> dummyData = find().where("this.profileId=?", profileId).and("this.type='Influence'").orderDescending("this.pctPotnModerate").list();
        return dummyData;
    }

    public List getByProfileIdLoyalty(String profileId) throws SVTException {
        List<T> dummyData = find().where("this.profileId=?", profileId).and("this.type='Loyalty'").orderDescending("this.pctPotnModerate").list();
        return dummyData;
    }

    public List getByProfileIdReach(String profileId) throws SVTException {
        List<T> dummyData = find().where("this.profileId=?", profileId).and("this.type='Reach'").orderDescending("this.pctPotnModerate").list();
        return dummyData;
    }

    public List getByProfileIdRetention(String profileId) throws SVTException {
        List<T> dummyData = find().where("this.profileId=?", profileId).and("this.type='Retention'").orderDescending("this.pctPotnModerate").list();
        return dummyData;

    }

    public List getByProfileIdSentiment(String profileId) throws SVTException {
        List<T> dummyData = find().where("this.profileId=?", profileId).and("this.type='Sentiment'").orderDescending("this.pctPotnModerate").list();
        return dummyData;
    }
//--------------------
    public List getByProfileIdDemographics(String profileId, String orderByColumn, String sortOrder) throws SVTException {
        if(sortOrder != null && sortOrder.equalsIgnoreCase("A")){
            return find().where("this.profileId=?", profileId).and("this.type='Demographics'").orderAscending("this." + orderByColumn+"*10000").list();             
        }else if(sortOrder != null && sortOrder.equalsIgnoreCase("D")){
            return find().where("this.profileId=?", profileId).and("this.type='Demographics'").orderDescending("this." + orderByColumn+"*10000").list();
        }        
        return find().where("this.profileId=?", profileId).and("this.type='Demographics'").list();
    }

    public List getByProfileIdEngagement(String profileId, String orderByColumn, String sortOrder) throws SVTException {
        if(sortOrder != null && sortOrder.equalsIgnoreCase("A")){
            return find().where("this.profileId=?", profileId).and("this.type='Engagement'").orderAscending("this." + orderByColumn+"*10000").list();             
        }else if(sortOrder != null && sortOrder.equalsIgnoreCase("D")){
            return find().where("this.profileId=?", profileId).and("this.type='Engagement'").orderDescending("this." + orderByColumn+"*10000").list();
        }        
        return find().where("this.profileId=?", profileId).and("this.type='Engagement'").list();
    }

    public List getByProfileIdInfluence(String profileId, String orderByColumn, String sortOrder) throws SVTException {
        if(sortOrder != null && sortOrder.equalsIgnoreCase("A")){
            return find().where("this.profileId=?", profileId).and("this.type='Influence'").orderAscending("this." + orderByColumn+"*10000").list();             
        }else if(sortOrder != null && sortOrder.equalsIgnoreCase("D")){
            return find().where("this.profileId=?", profileId).and("this.type='Influence'").orderDescending("this." + orderByColumn+"*10000").list();
        }        
        return find().where("this.profileId=?", profileId).and("this.type='Influence'").list();
    }

    public List getByProfileIdLoyalty(String profileId, String orderByColumn, String sortOrder) throws SVTException {
        if(sortOrder != null && sortOrder.equalsIgnoreCase("A")){
            return find().where("this.profileId=?", profileId).and("this.type='Loyalty'").orderAscending("this." + orderByColumn+"*10000").list();             
        }else if(sortOrder != null && sortOrder.equalsIgnoreCase("D")){
            return find().where("this.profileId=?", profileId).and("this.type='Loyalty'").orderDescending("this." + orderByColumn+"*10000").list();
        }        
        return find().where("this.profileId=?", profileId).and("this.type='Loyalty'").list();
    }

    public List getByProfileIdReach(String profileId, String orderByColumn, String sortOrder) throws SVTException {
        if(sortOrder != null && sortOrder.equalsIgnoreCase("A")){
            return find().where("this.profileId=?", profileId).and("this.type='Reach'").orderAscending("this." + orderByColumn+"*10000").list();             
        }else if(sortOrder != null && sortOrder.equalsIgnoreCase("D")){
            return find().where("this.profileId=?", profileId).and("this.type='Reach'").orderDescending("this." + orderByColumn+"*10000").list();
        }        
        return find().where("this.profileId=?", profileId).and("this.type='Reach'").list();
    }

    public List getByProfileIdRetention(String profileId, String orderByColumn, String sortOrder) throws SVTException {
        if(sortOrder != null && sortOrder.equalsIgnoreCase("A")){
            return find().where("this.profileId=?", profileId).and("this.type='Retention'").orderAscending("this." + orderByColumn+"*10000").list();             
        }else if(sortOrder != null && sortOrder.equalsIgnoreCase("D")){
            return find().where("this.profileId=?", profileId).and("this.type='Retention'").orderDescending("this." + orderByColumn+"*10000").list();
        }        
        return find().where("this.profileId=?", profileId).and("this.type='Retention'").list();
    }

    public List getByProfileIdSentiment(String profileId, String orderByColumn, String sortOrder) throws SVTException {
        if(sortOrder != null && sortOrder.equalsIgnoreCase("A")){
            return find().where("this.profileId=?", profileId).and("this.type='Sentiment'").orderAscending("this." + orderByColumn+"*10000").list();             
        }else if(sortOrder != null && sortOrder.equalsIgnoreCase("D")){
            return find().where("this.profileId=?", profileId).and("this.type='Sentiment'").orderDescending("this." + orderByColumn+"*10000").list();
        }        
        return find().where("this.profileId=?", profileId).and("this.type='Sentiment'").list();
    }
    
    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return SocialIntelligenceMetricsDummy.class;
    }


}
