// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.ProfileDummy;


@SuppressWarnings("unchecked")
public class ProfileDummyHibernateDAO<T extends ProfileDummy> extends BaseHibernateDAO<T>
        implements ProfileDummyDAO {
    private static final Log log = LogFactory.getLog(ProfileDummyHibernateDAO.class);


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
    
    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return ProfileDummy.class;
    }
}
