// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.Score;


@SuppressWarnings("unchecked")
public class ScoreHibernateDAO<T extends Score> extends BaseHibernateDAO<T>
        implements ScoreDAO {
    private static final Log log = LogFactory.getLog(ScoreHibernateDAO.class);


    /**
     * Returns all the si
     * <p>
     * 
     * @return List of sids
     */
    public List findall() {
        log.debug("ScoreHibernateDAO.findall");
        List<T> t = find().list();
        return t;
    }

    public Score update(Score score) throws SVTException {
        if(score == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(score);
        transaction.commit();
        log.debug("Value saved successfully");
        return score;
    }

    /**
     * {@inheritDoc}
     */
    public Score add(Score score) throws SVTException {
        Score score1 = save(score);
        return score1;
    }


    private Score save(Score score) {
        if (score == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(score);
        transaction.commit();
        log.debug("Value saved successfully");
        return score;
    }


    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return Score.class;
    }
}
