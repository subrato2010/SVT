// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.OverallPerformanceDummy;


@SuppressWarnings("unchecked")
public class OverallPerformanceDummyHibernateDAO<T extends OverallPerformanceDummy> extends BaseHibernateDAO<T>
        implements OverallPerformanceDummyDAO {
    private static final Log log = LogFactory.getLog(OverallPerformanceDummyHibernateDAO.class);


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

    public List getByProfileIdTarget(String profileId, String target) throws SVTException {
        List<T> dummyData = find().where("this.profileId=?", profileId).and("this.target=?", target).list();
        return dummyData;
    }

    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return OverallPerformanceDummy.class;
    }
}
