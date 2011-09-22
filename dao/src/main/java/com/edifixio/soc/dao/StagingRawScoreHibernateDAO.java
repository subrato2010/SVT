// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.StagingRawScore;


@SuppressWarnings("unchecked")
public class StagingRawScoreHibernateDAO<T extends StagingRawScore> extends BaseHibernateDAO<T>
        implements StagingRawScoreDAO {
    private static final Log log = LogFactory.getLog(StagingRawScoreHibernateDAO.class);


    /**
     * Returns all the StagingRawScores
     * <p>
     * 
     * @return List of StagingRawScores
     */
    public List findall() {
        log.debug("StagingRawScoreHibernateDAO.findall");
        List<T> t = find().list();
        return t;
    }

    /**
     * {@inheritDoc}
     */
    public StagingRawScore add(StagingRawScore stagingRawScore) throws SVTException {
        log.debug("StagingRawScoreHibernateDAO.add");
        StagingRawScore stagingRawScore1 = save(stagingRawScore);
        return stagingRawScore1;
    }

    private StagingRawScore save(StagingRawScore stagingRawScore) {
        if (stagingRawScore == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(stagingRawScore);
        transaction.commit();
        log.debug("Value saved successfully");
        return stagingRawScore;
    }


    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return StagingRawScore.class;
    }

}
