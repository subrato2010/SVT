// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.ProfileListMaster;


@SuppressWarnings("unchecked")
public class ProfileListMasterHibernateDAO<T extends ProfileListMaster> extends BaseHibernateDAO<T>
        implements ProfileListMasterDAO {
    private static final Log log = LogFactory.getLog(ProfileListMasterHibernateDAO.class);

    public List findall() {
        log.debug("ProfileListMasterHibernateDAO.findall");
        List<T> t = find().list();
        
        return t;
    }

    public List getByProfilePreferenceId(String id) throws SVTException {
        List<T> profileListMaster = find().where("this.profilePreference.profilePrefrenceId=?", id).list();
        return profileListMaster;
    }

    public T getByProfilePreferenceIdName(String id, String listName) throws SVTException {
        T profileListMaster = find().where("this.listName=?",listName).and("this.profilePreference.profilePrefrenceId=?", id).get();
        return profileListMaster;
    }

    public ProfileListMaster getByProfileListMasterId(String id) throws SVTException {
        T profileListMaster = find().where("this.profileListMasterId=?", id).get();
        return profileListMaster;
    }
    
    public ProfileListMaster update(ProfileListMaster profileListMaster) throws SVTException {
        if(profileListMaster == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(profileListMaster);
        transaction.commit();
        log.debug("Value saved successfully");
        return profileListMaster;
    }

    /**
     * {@inheritDoc}
     */
    public ProfileListMaster add(ProfileListMaster profileListMaster) throws SVTException {
        ProfileListMaster profileListMaster1 = save(profileListMaster);
        return profileListMaster1;
    }


    private ProfileListMaster save(ProfileListMaster profileListMaster) {
        if (profileListMaster == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(profileListMaster);
        transaction.commit();
        log.debug("Value saved successfully");
        return profileListMaster;
    }
    
    
    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return ProfileListMaster.class;
    }
}
