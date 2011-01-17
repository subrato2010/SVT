// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.UserProfileDetail;


@SuppressWarnings("unchecked")
public class UserProfileDetailHibernateDAO<T extends UserProfileDetail> extends BaseHibernateDAO<T>
        implements UserProfileDetailDAO {
    private static final Log log = LogFactory.getLog(UserProfileDetailHibernateDAO.class);

    public List findall() {
        List<T> t = find().list();        
        return t;
    }

    public List getByProfilePreferenceId(String id) throws SVTException {
        List<T> userProfileDetail = find().where("this.profilePreference.profilePrefrenceId=?", id).list();
        return userProfileDetail;
    }
    
    public UserProfileDetail getByProfileDetailId(String id) throws SVTException {
        T userProfileDetail = find().where("this.profileDetailId=?", id).get();
        return userProfileDetail;
    }

    public UserProfileDetail update(UserProfileDetail userProfileDetail) throws SVTException {
        if(userProfileDetail == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(userProfileDetail);
        transaction.commit();
        log.debug("Value saved successfully");
        return userProfileDetail;
    }

    /**
     * {@inheritDoc}
     */
    public UserProfileDetail add(UserProfileDetail userProfileDetail) throws SVTException {
        UserProfileDetail userProfileDetail1 = save(userProfileDetail);
        return userProfileDetail1;
    }


    private UserProfileDetail save(UserProfileDetail userProfileDetail) {
        if (userProfileDetail == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(userProfileDetail);
        transaction.commit();
        log.debug("Value saved successfully");
        return userProfileDetail;
    }
    
    @Override
    protected Class getConcreteClass() {
        return UserProfileDetail.class;
    }
    
}
