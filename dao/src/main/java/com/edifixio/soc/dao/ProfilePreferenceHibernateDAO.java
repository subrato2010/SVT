// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.ProfilePreference;


@SuppressWarnings("unchecked")
public class ProfilePreferenceHibernateDAO<T extends ProfilePreference> extends BaseHibernateDAO<T>
        implements ProfilePreferenceDAO {
    private static final Log log = LogFactory.getLog(ProfilePreferenceHibernateDAO.class);

    /**
     * Returns all the ProfilePreference
     * <p>
     * 
     * @return List of ProfilePreferences
     */
    public List findall() {
        log.debug("ProfilePreferenceHibernateDAO.findall");
        List<T> t = find().list();
        
        return t;
    }

    public ProfilePreference getByProfilePreferenceId(String id) throws SVTException {
        T ProfilePreference = find().where("this.profilePrefrenceId=?", id).get();
        return ProfilePreference;
    }

    public ProfilePreference getByProfileUserId(String userId) throws SVTException {
        T ProfilePreference = find().where("this.profileUserId=?", userId).get();
        return ProfilePreference;
    }
    
    public ProfilePreference update(ProfilePreference profilePreference) throws SVTException {
        if(profilePreference == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(profilePreference.getUserProfileDetail());
        session.update(profilePreference);
        transaction.commit();
        log.debug("Value saved successfully");
        return profilePreference;
    }

    /**
     * {@inheritDoc}
     */
    public ProfilePreference add(ProfilePreference profilePreference) throws SVTException {
        ProfilePreference profilePreference1 = save(profilePreference);
        return profilePreference1;
    }


    private ProfilePreference save(ProfilePreference profilePreference) {
        if (profilePreference == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(profilePreference);
        transaction.commit();
        log.debug("Value saved successfully");
        return profilePreference;
    }
    
    
    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return ProfilePreference.class;
    }


}
