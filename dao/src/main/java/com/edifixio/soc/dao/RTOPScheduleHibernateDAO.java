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
import com.edifixio.soc.persist.RTOPSchedule;


@SuppressWarnings("unchecked")
public class RTOPScheduleHibernateDAO<T extends RTOPSchedule> extends
        BaseHibernateDAO<T> implements RTOPScheduleDAO {
    private static final Log log = LogFactory
            .getLog(RTOPScheduleHibernateDAO.class);


    public List findall() {
        List<T> t = find().list();
        return t;
    }

    public RTOPSchedule getById(String id) throws SVTException {
        T rtopSchedule = find().where("this.rtopScheduleId=?", id).get();
        return rtopSchedule;
    }
   
    public List<T> getByStatus(int status) throws SVTException{
        List<T> t = find().where("this.status=?", status).list();
        return t; 
    }

    public List getByTwitterAccountScheduledTweet(String twitterAccountId)
            throws SVTException {
        List<T> t = find().where("this.status=0").and("this.twitterAccount.twitterAccountId=?", twitterAccountId).orderDescending("this.scheduleDateTime").list(); // yet to be processed
        return t;
    }

    public List<T> getByScheduledTweet() throws SVTException{
        List<T> t = find().where("this.status=0").or("this.status=3").list(); // yet to be processed
        return t;  
    }
   
    public List<T> getSentTweetsByProfilePrefIdFromDate(String profileId, Date fromDate) throws SVTException{
        List<T> t = find().where("this.status=1").
        and("this.twitterAccount.profilePreference.profilePrefrenceId=?", profileId).
        andIfNotNull("this.updatedOn >= ?", fromDate).list();
        return t; 
    }
    
    public RTOPSchedule add(RTOPSchedule rtopSchedule)
            throws SVTException {
        RTOPSchedule rtopSchedule1 = save(rtopSchedule);
        return rtopSchedule1;
    }

    public RTOPSchedule saveOrUpdate(RTOPSchedule rtopSchedule)
            throws SVTException {
        RTOPSchedule rtopSchedule1 = update(rtopSchedule);
        return rtopSchedule1;
    }
 
    private RTOPSchedule update(RTOPSchedule rtopSchedule) {
        if (rtopSchedule == null) {
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(rtopSchedule);
        transaction.commit();
        return rtopSchedule;
    }

    private RTOPSchedule save(RTOPSchedule rtopSchedule) {
        if (rtopSchedule == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(rtopSchedule);
        transaction.commit();
        return rtopSchedule;
    }


    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return RTOPSchedule.class;
    }
}
