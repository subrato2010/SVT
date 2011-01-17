// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.ProfileInfluence;


@SuppressWarnings("unchecked")
public class ProfileInfluenceHibernateDAO<T extends ProfileInfluence> extends BaseHibernateDAO<T>
        implements ProfileInfluenceDAO {
    private static final Log log = LogFactory.getLog(ProfileInfluenceHibernateDAO.class);

    public List findall() {
        log.debug("ProfileInfluenceHibernateDAO.findall");
        List<T> t = find().list();
        
        return t;
    }

    public List getByProfilePreferenceId(String id) throws SVTException {
        List<T> profileInfluence = find().where("this.profilePreference.profilePrefrenceId=?", id).list();
        return profileInfluence;
    }

    public ProfileInfluence getByProfileInfluenceId(String id) throws SVTException {
        T profileInfluence = find().where("this.profileInfluenceId=?", id).get();
        return profileInfluence;
    }
    
    public ProfileInfluence update(ProfileInfluence profilePreference) throws SVTException {
        if(profilePreference == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(profilePreference);
        transaction.commit();
        log.debug("Value saved successfully");
        return profilePreference;
    }

    /**
     * {@inheritDoc}
     */
    public ProfileInfluence add(ProfileInfluence profileInfluence) throws SVTException {
        ProfileInfluence profileInfluence1 = save(profileInfluence);
        return profileInfluence1;
    }


    private ProfileInfluence save(ProfileInfluence profileInfluence) {
        if (profileInfluence == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(profileInfluence);
        transaction.commit();
        log.debug("Value saved successfully");
        return profileInfluence;
    }
    
    
    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return ProfileInfluence.class;
    }


}
