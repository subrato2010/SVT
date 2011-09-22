// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.TwitLog;


@SuppressWarnings("unchecked")
public class TwitLogHibernateDAO<T extends TwitLog> extends BaseHibernateDAO<T>
        implements TwitLogDAO {
    private static final Log log = LogFactory.getLog(TwitLogHibernateDAO.class);


    public List findall() {
        List<T> t = find().list();
        return t;
    }
    
    public TwitLog add(TwitLog twitLog) throws SVTException {
        TwitLog twitLog1 = save(twitLog);
        return twitLog1;
    }

    private TwitLog save(TwitLog twitLog) {
        if (twitLog == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(twitLog);
        transaction.commit();
        log.debug("Value saved successfully");
        return twitLog;
    }

    public TwitLog update(TwitLog twitLog) throws SVTException {
        if(twitLog == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(twitLog);
        transaction.commit();
        log.debug("Value saved successfully");
        return twitLog;
    }
    
    public List findByFrom(String accountId) throws SVTException {
        List<T> t = find().where("this.fromWhom=?", accountId).list();
        return t;
    }

    public TwitLog findByTwitterStatusId(long twittStatusId) throws SVTException {
        T twitLog = find().where("this.twittStatusId=?", twittStatusId).get();
        return twitLog;
    }
    
    public List findByToWhom(String accountId) throws SVTException {
        List<T> t = find().where("this.toWhom=?", accountId).list();
        return t;
    }

    public List findByTwitterUsername(String twitterUsername) throws SVTException {
        List<T> t = find().where("this.twitterAccount.twitterUsername=?", twitterUsername).list();
        return t;
    }
    public List findByTwitterUsername(String twitterUsername, Date date) throws SVTException {
        List<T> t = find().where("this.twitterAccount.twitterUsername=?", twitterUsername).
        andIfNotNull("this.actionTakenOn = ?", date).list();
        return t;
    }
    
    public TwitLog getById(String id) throws SVTException {
        T twitLog = find().where("this.twitLogId=?", id).get();
        return twitLog;
    }


    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return TwitLog.class;
    }
}
