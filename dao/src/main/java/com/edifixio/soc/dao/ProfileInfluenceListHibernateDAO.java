// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.ProfileInfluenceList;


@SuppressWarnings("unchecked")
public class ProfileInfluenceListHibernateDAO<T extends ProfileInfluenceList> extends BaseHibernateDAO<T>
        implements ProfileInfluenceListDAO {
    private static final Log log = LogFactory.getLog(ProfileInfluenceListHibernateDAO.class);

    public List findall() {
        log.debug("ProfileInfluenceListHibernateDAO.findall");
        List<T> t = find().list();        
        return t;
    }

    public List getByProfileListMasterId(String id) throws SVTException {
        List<T> profileInfluenceList = find().where("this.profileListMaster.profileListMasterId=?", id).list();
        return profileInfluenceList;
    }

    public ProfileInfluenceList getByProfileInfluenceId(String id) throws SVTException {
        T profileInfluenceList = find().where("this.profileInfluence.profileInfluenceId=?", id).get();
        return profileInfluenceList;
    }

    public ProfileInfluenceList getByProfInfluIdProfListMastId(String profileInfluenceId, String profileListMasterId) throws SVTException {
        T profileInfluenceList = find().where("this.profileInfluence.profileInfluenceId=?", profileInfluenceId).and("this.profileListMaster.profileListMasterId=?", profileListMasterId).get();
        return profileInfluenceList;
    }

    public ProfileInfluenceList update(ProfileInfluenceList profileInfluenceList) throws SVTException {
        if(profileInfluenceList == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(profileInfluenceList);
        transaction.commit();
        log.debug("Value saved successfully");
        return profileInfluenceList;
    }

    /**
     * {@inheritDoc}
     */
    public ProfileInfluenceList add(ProfileInfluenceList profileInfluenceList) throws SVTException {
        ProfileInfluenceList profileInfluenceList1 = save(profileInfluenceList);
        return profileInfluenceList1;
    }


    private ProfileInfluenceList save(ProfileInfluenceList profileInfluenceList) {
        if (profileInfluenceList == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(profileInfluenceList);
        transaction.commit();
        log.debug("Value saved successfully");
        return profileInfluenceList;
    }
    
    
    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return ProfileInfluenceList.class;
    }
}
