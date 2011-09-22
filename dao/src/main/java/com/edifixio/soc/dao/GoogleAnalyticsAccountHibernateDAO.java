// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.GoogleAnalyticsAccount;


@SuppressWarnings("unchecked")
public class GoogleAnalyticsAccountHibernateDAO<T extends GoogleAnalyticsAccount> extends BaseHibernateDAO<T>
        implements GoogleAnalyticsAccountDAO {
    private static final Log log = LogFactory.getLog(GoogleAnalyticsAccountHibernateDAO.class);

    public GoogleAnalyticsAccount getByGoogleAnalyticsAccountId(String id) throws SVTException {
        T GoogleAnalyticsAccount = find().where("this.googleAnalyticsAccountId=?", id).get();
        return GoogleAnalyticsAccount;
    }

    public List getByProfilePreferenceId(String profilePreferenceId) throws SVTException {
        List<T> t = find().where("this.activeStatus=true").and("this.profilePreference.profilePrefrenceId=?",profilePreferenceId).order("this.displayOrder").list();
        return t;
    }

    public List findall() {
        List<T> t = find().list();
        return t;
    }
    
    public GoogleAnalyticsAccount update(GoogleAnalyticsAccount googleAnalyticsAccount) throws SVTException {
        if(googleAnalyticsAccount == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(googleAnalyticsAccount);
        transaction.commit();
        log.debug("Value saved successfully");
        return googleAnalyticsAccount;
    }

    /**
     * {@inheritDoc}
     */
    public GoogleAnalyticsAccount add(GoogleAnalyticsAccount googleAnalyticsAccount) throws SVTException {
        GoogleAnalyticsAccount googleAnalyticsAccount1 = save(googleAnalyticsAccount);
        return googleAnalyticsAccount1;
    }


    private GoogleAnalyticsAccount save(GoogleAnalyticsAccount googleAnalyticsAccount) {
        if (googleAnalyticsAccount == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(googleAnalyticsAccount);
        transaction.commit();
        log.debug("Value saved successfully");
        return googleAnalyticsAccount;
    }
    
    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return GoogleAnalyticsAccount.class;
    }
}
