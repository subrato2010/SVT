// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.OutboundMetricsDummy;


@SuppressWarnings("unchecked")
public class OutboundMetricsDummyHibernateDAO<T extends OutboundMetricsDummy> extends BaseHibernateDAO<T>
        implements OutboundMetricsDummyDAO {
    private static final Log log = LogFactory.getLog(OutboundMetricsDummyHibernateDAO.class);


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
        List<T> dummyData = find().where("this.profileId=?", profileId).and("this.activeStatus=true").orderDescending("this.pctPotnModerate").list();
        return dummyData;
    }

    public List getByProfileId(String profileId, String orderByColumn, String sortOrder) throws SVTException {
        if(sortOrder != null && sortOrder.equalsIgnoreCase("A")){
            return find().where("this.profileId=?", profileId).and("this.activeStatus=true").orderAscending("this." + orderByColumn+"*10000").list();             
        }else if(sortOrder != null && sortOrder.equalsIgnoreCase("D")){
            return find().where("this.profileId=?", profileId).and("this.activeStatus=true").orderDescending("this." + orderByColumn+"*10000").list();
        }        
        return find().where("this.profileId=?", profileId).and("this.activeStatus=true").list();
    }

    
    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return OutboundMetricsDummy.class;
    }
}
