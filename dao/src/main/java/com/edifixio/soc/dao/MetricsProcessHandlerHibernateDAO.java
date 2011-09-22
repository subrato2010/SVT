// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.MetricsProcessHandler;


@SuppressWarnings("unchecked")
public class MetricsProcessHandlerHibernateDAO<T extends MetricsProcessHandler> extends BaseHibernateDAO<T>
        implements MetricsProcessHandlerDAO {
    private static final Log log = LogFactory.getLog(MetricsProcessHandlerHibernateDAO.class);


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

    public MetricsProcessHandler getByMetricsId(String metricId) throws SVTException {
        T metricsProcessHandler = find().where("this.metrics.metricId=?", metricId).get();
        return metricsProcessHandler;
    }
    
    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return MetricsProcessHandler.class;
    }
}
