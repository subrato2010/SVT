// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.InboundMetricsDummy;


@SuppressWarnings("unchecked")
public class InboundMetricsDummyHibernateDAO<T extends InboundMetricsDummy> extends BaseHibernateDAO<T>
        implements InboundMetricsDummyDAO {
    private static final Log log = LogFactory.getLog(InboundMetricsDummyHibernateDAO.class);


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
        List<T> dummyData = find().where("this.profileId=?", profileId).orderDescending("this.pctPotnModerate").list();
        return dummyData;
    }
    public List getByProfileId(String profileId, String orderByColumn, String sortOrder) throws SVTException {
        if(sortOrder != null && sortOrder.equalsIgnoreCase("A")){
            return find().where("this.profileId=?", profileId).orderAscending("this." + orderByColumn +"*10000").list();             
        }else if(sortOrder != null && sortOrder.equalsIgnoreCase("D")){
            return find().where("this.profileId=?", profileId).orderDescending("this." + orderByColumn +"*10000").list();
        }        
        return find().where("this.profileId=?", profileId).list();
    }
    
    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return InboundMetricsDummy.class;
    }
}
