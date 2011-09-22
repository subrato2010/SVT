// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.Calendar;
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
        andIfNotNull("this.actionDate = ?", actionDate).list();
        return t;
    }    
    public List findByProfileIdActionDate(String profileId, Date actionDate) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        andIfNotNull("this.actionDate = ?", actionDate).list();
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
        andIfNotNull("this.actionDate = ?", actionDate).
        and("this.twitterAccount.self=false").list();
        return t;
    }
    public List findByProfileIdActionDateSELF(String profileId, Date actionDate) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        andIfNotNull("this.actionDate = ?", actionDate).
        and("this.twitterAccount.self=true").list();
        return t;
    }
    public List findByProfileIdMetricIdActionDateNOTSELF(String profileId, String twitterAccountId, String metricId, Date actionDate) throws SVTException {
        List<T> t = find().where("this.metric.metricId=?", metricId).
        and("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        //andIfNotZero("this.twitterAccount.twitterAccountId=?", twitterAccountId).
        andIfNotNull("this.actionDate = ?", actionDate).
        and("this.twitterAccount.self=false").list();
        return t;
    }
    public List findByProfileIdMetricIdActionDateCALCNOTSELF(String profileId, String twitterAccountId, String metricId, Date benchmarkStDate, Date benchmarkEdDate) throws SVTException {
        List<T> t = find().where("this.metric.metricId=?", metricId).
        and("this.rawScore >= 0").
        and("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        //andIfNotZero("this.twitterAccount.twitterAccountId=?", twitterAccountId).
        andIfNotNull("this.actionDate >= ?", benchmarkStDate).
        andIfNotNull("this.actionDate <= ?", benchmarkEdDate).
        and("this.twitterAccount.self=false").list();
        return t;
    }
    public List findByProfileIdMetricIdActionDateCALCNOTSELF(String profileId, String twitterAccountId, String metricId, Date benchmarkEdDate) throws SVTException {
        List<T> t = find().where("this.metric.metricId=?", metricId).
        and("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        andIfNotNull("this.actionDate = ?", benchmarkEdDate).
        and("this.twitterAccount.self=false").list();
        return t;
    }
    public List findByProfileIdActionDateCALCNOTSELF(String profileId, String twitterAccountId, Date benchmarkStDate, Date benchmarkEdDate) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        //andIfNotZero("this.twitterAccount.twitterAccountId=?", twitterAccountId).
        andIfNotNull("this.actionDate >= ?", benchmarkStDate).
        andIfNotNull("this.actionDate <= ?", benchmarkEdDate).
        and("this.twitterAccount.self=false").list();
        return t;
    }

    public List findByProfileIdMetricIdActionDateSELF(String profileId, String twitterAccountId, String metricId, Date actionDate) throws SVTException {
        List<T> t = find().where("this.metric.metricId=?", metricId).
        and("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        andIfNotZero("this.twitterAccount.twitterAccountId=?", twitterAccountId).
        andIfNotNull("this.actionDate = ?", actionDate).
        and("this.twitterAccount.self=true").list();
        return t;
    }
    public List findByProfileIdMetricIdActionDateCALCSELF(String profileId, String twitterAccountId, String metricId, Date benchmarkStDate, Date benchmarkEdDate) throws SVTException {
        List<T> t = find().where("this.metric.metricId=?", metricId).
        and("this.rawScore >= 0").
        and("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        andIfNotZero("this.twitterAccount.twitterAccountId=?", twitterAccountId).
        andIfNotNull("this.actionDate >= ?", benchmarkStDate).
        andIfNotNull("this.actionDate <= ?", benchmarkEdDate).
        and("this.twitterAccount.self=true").list();
        return t;
    }
    public List findByProfileIdMetricIdActionDateCALCSELF(String profileId, String twitterAccountId, String metricId, Date benchmarkEdDate) throws SVTException {
        List<T> t = find().where("this.metric.metricId=?", metricId).
        and("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        andIfNotZero("this.twitterAccount.twitterAccountId=?", twitterAccountId).
        andIfNotNull("this.actionDate = ?", benchmarkEdDate).
        and("this.twitterAccount.self=true").list();
        return t;
    }
    public List findByProfileIdActionDateCALCSELF(String profileId, String twitterAccountId, Date benchmarkStDate, Date benchmarkEdDate) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        andIfNotZero("this.twitterAccount.twitterAccountId=?", twitterAccountId).
        andIfNotNull("this.actionDate >= ?", benchmarkStDate).
        andIfNotNull("this.actionDate <= ?", benchmarkEdDate).
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

    public List findByProfileIdMetricIdActionDateSELF1(String profileId, String twitterAccountId, String metricId, Date actionDate) throws SVTException {
        List<T> t = find().where("this.metric.metricId=?", metricId).
        and("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        and("this.metric.metricId=?", metricId).
        andIfNotZero("this.twitterAccount.twitterAccountId=?", twitterAccountId).
        andIfNotNull("this.actionDate = ?", actionDate).
        and("this.twitterAccount.self=true").list();
        return t;
    }
    
    public Date getMaxActionDate(String profileId) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        and("this.actionDate<?", getCurrentDate()).orderDescending("actionDate").list();
        if(t != null && t.size()>0){
            return t.get(0).getActionDate();
        }
        return null;
    }
    public Date getMinActionDate(String profileId) throws SVTException {
        List<T> t = find().where("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).orderAscending("actionDate").list();
        if(t != null && t.size()>0){
            return t.get(0).getActionDate();
        }
        return null;
    }
    
    /**
     * This method will return currentDate with hour, minute, sec, millisec as 0
     * @return
     */
    private Date getCurrentDate(){
        // Get Calendar object set to the date and time of the given Date object  
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(new Date());
        // Set time fields to zero  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0); 
        return cal.getTime(); 
    }
}
