// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.Metrics;


@SuppressWarnings("unchecked")
public class MetricsHibernateDAO<T extends Metrics> extends
        BaseHibernateDAO<T> implements MetricsDAO {
    private static final Log log = LogFactory
            .getLog(MetricsHibernateDAO.class);


    /**
     * Returns all the si
     * <p>
     * 
     * @return List of sids
     */
    public List findall() {
        log.debug("SubCategoryHibernateDAO.findall");
        List<T> t = find().list();
        return t;
    }

    public List<T> findCategoryByChannelIdInbound(String channelId) throws SVTException{
        List<T> t = find().where("this.category.channel.channelId=?", channelId).and("this.metricsType='INBOUND'").and("this.activeStatus=true").order("this.displayOrder").list();
        return t;
        
    }
    public List<T> findCategoryByChannelIdOutbound(String channelId) throws SVTException{
        List<T> t = find().where("this.category.channel.channelId=?", channelId).and("this.metricsType='OUTBOUND'").and("this.activeStatus=true").order("this.displayOrder").list();
        return t;
        //return sort(t);        
    }


    private List<T> sort(List<Metrics> t) {
        Set set = new HashSet(t);
        List<T> tt = new ArrayList(set);
        return tt;
    }

    public Metrics getById(String id) throws SVTException {
        T metrics = find().where("this.metricId=?", id).get();
        return metrics;
    }

    public Metrics getByName(String name) throws SVTException {
        T subCategory = find().where("this.metricName=?", name).get();
        return subCategory;
    }


    public List findByNameCategoryIdChannelId(String name,String categoryId, String channelId) throws SVTException {
        List<T> subCategories = find().where("this.metricName=?", name).and(
                "this.category.categoryId=?", categoryId).list();
        return subCategories;
    }

    public List findByCategoryId(String categoryId) throws SVTException {
        List<T> subCategories = find().where("this.category.categoryId=?", categoryId).list();
        return subCategories;
    }

    
    /**
     * {@inheritDoc}
     */
    public Metrics addMetrics(Metrics metrics)
            throws SVTException {
        log.debug("SubCategoryHibernateDAO.addMetrics");
        Metrics metrics1 = save(metrics);
        return metrics1;
    }

    /**
     * {@inheritDoc}
     */
    public Metrics saveOrUpdate(Metrics metrics)
            throws SVTException {
        log.debug("SubCategoryHibernateDAO.saveOrUpdate");
        Metrics metrics1 = update(metrics);
        return metrics1;
    }

    private Metrics update(Metrics metrics) {
        if (metrics == null) {
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(metrics);
        transaction.commit();
        log.debug("Value saved successfully");
        return metrics;
    }

    private Metrics save(Metrics metrics) {
        if (metrics == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(metrics);
        transaction.commit();
        log.debug("Value saved successfully");
        return metrics;
    }


    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return Metrics.class;
    }

}
