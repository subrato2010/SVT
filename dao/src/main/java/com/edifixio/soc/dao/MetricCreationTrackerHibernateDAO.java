// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.MetricCreationTracker;


@SuppressWarnings("unchecked")
public class MetricCreationTrackerHibernateDAO<T extends MetricCreationTracker> extends BaseHibernateDAO<T>
        implements MetricCreationTrackerDAO {
    private static final Log log = LogFactory.getLog(MetricCreationTrackerHibernateDAO.class);

    public List findall() {
        List<T> t = find().list();
        return t;
    }
    public Date getMaxActionDate(List twitterUsername) throws SVTException {
        List<T> t = find().where("this.twitterUsername in (" + getUserString(twitterUsername) +")").
        orderDescending("actionDate").list();
        if(t != null && t.size()>0){
            return t.get(0).getActionDate();
        }
        return null;
    }

    public Date getMaxActionDateByUser(String twitterUsername)
        throws SVTException {
        // TODO Auto-generated method stub
        return null;
    }
    
    public Date getMinActionDate(List twitterUsername) throws SVTException {
        // TODO Auto-generated method stub
        return null;
    }

    public Date getMinActionDateByUser(String twitterUsername)
            throws SVTException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return MetricCreationTracker.class;
    }
    
    private String getUserString(List<String> twitterUsername) {
        String users="''";
        for(String user : twitterUsername){
            users += ",'" + user + "'";
        }
        return users;
    }
}
