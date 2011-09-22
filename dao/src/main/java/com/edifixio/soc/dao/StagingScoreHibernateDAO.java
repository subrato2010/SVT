// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.StagingScore;


@SuppressWarnings("unchecked")
public class StagingScoreHibernateDAO<T extends StagingScore> extends BaseHibernateDAO<T>
        implements StagingScoreDAO {
    private static final Log log = LogFactory.getLog(StagingScoreHibernateDAO.class);


    /**
     * Returns all the StagingScores
     * <p>
     * 
     * @return List of StagingScores
     */
    public List findall() {
        log.debug("StagingScoreHibernateDAO.findall");
        List<T> t = find().list();
        return t;
    }

    public StagingScore update(StagingScore stagingScore) throws SVTException {
        if(stagingScore == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(stagingScore);
        transaction.commit();
        log.debug("Value saved successfully");
        return stagingScore;
    }

    /**
     * {@inheritDoc}
     */
    public StagingScore add(StagingScore stagingScore) throws SVTException {
        log.debug("StagingScoreHibernateDAO.add");
        StagingScore stagingScore1 = save(stagingScore);
        return stagingScore1;
    }

    private StagingScore save(StagingScore stagingScore) {
        if (stagingScore == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(stagingScore);
        transaction.commit();
        log.debug("Value saved successfully");
        return stagingScore;
    }


    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return StagingScore.class;
    }
}
