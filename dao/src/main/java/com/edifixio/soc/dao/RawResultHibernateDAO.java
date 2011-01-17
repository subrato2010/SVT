// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.RawResult;


@SuppressWarnings("unchecked")
public class RawResultHibernateDAO<T extends RawResult> extends BaseHibernateDAO<T>
        implements RawResultDAO {
    private static final Log log = LogFactory.getLog(RawResultHibernateDAO.class);

    public List findall() {
        List<T> t = find().list();
        return t;
    }
    public List findByMetricId(String metricId) throws SVTException {
        List<T> t = find().where("this.metric.metricId=?", metricId).list();
        return t;
    }  
    public List findByProfileIdMetricId(String profileId, String metricId) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        and("this.metric.metricId=?", metricId).list();
        return t;
    }
    public List findByProfileIdMetricIdActionDate(String profileId, String metricId, Date actionDate) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        and("this.metric.metricId=?", metricId).
        andIfNotNull("this.actionDate <= ?", actionDate).list();
        return t;
    }    
    public List findByProfileIdActionDate(String profileId, Date actionDate) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        andIfNotNull("this.actionDate <= ?", actionDate).list();
        return t;
    }
    public List findByMetricIdNOTSELF(String metricId) throws SVTException {
        List<T> t = find().where("this.metric.metricId=?", metricId).
        and("this.twitterAccount.self=false").list();
        return t;
    }
    public List findByMetricIdSELF(String metricId) throws SVTException {
        List<T> t = find().where("this.metric.metricId=?", metricId).
        and("this.twitterAccount.self=true").list();
        return t;
    }
    public List findByProfileIdActionDateNOTSELF(String profileId, Date actionDate) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        andIfNotNull("this.actionDate <= ?", actionDate).
        and("this.twitterAccount.self=false").list();
        return t;
    }
    public List findByProfileIdActionDateSELF(String profileId, Date actionDate) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        andIfNotNull("this.actionDate <= ?", actionDate).
        and("this.twitterAccount.self=true").list();
        return t;
    }
    public List findByProfileIdMetricIdActionDateNOTSELF(String profileId, String metricId, Date actionDate) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        and("this.metric.metricId=?", metricId).
        andIfNotNull("this.actionDate <= ?", actionDate).
        and("this.twitterAccount.self=false").list();
        return t;
    }
    public List findByProfileIdMetricIdActionDateSELF(String profileId, String metricId, Date actionDate) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        and("this.metric.metricId=?", metricId).
        andIfNotNull("this.actionDate <= ?", actionDate).
        and("this.twitterAccount.self=true").list();
        return t;
    }
    public List findByProfileIdMetricIdNOTSELF(String profileId, String metricId) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        and("this.metric.metricId=?", metricId).
        and("this.twitterAccount.self=false").list();
        return t;
    }
    public List findByProfileIdMetricIdSELF(String profileId, String metricId) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        and("this.metric.metricId=?", metricId).
        and("this.twitterAccount.self=true").list();
        return t;
    }

    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return RawResult.class;
    }
}
