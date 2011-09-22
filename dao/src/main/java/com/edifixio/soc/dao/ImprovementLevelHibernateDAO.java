// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.ImprovementLevel;


@SuppressWarnings("unchecked")
public class ImprovementLevelHibernateDAO<T extends ImprovementLevel> extends BaseHibernateDAO<T>
        implements ImprovementLevelDAO {
    private static final Log log = LogFactory.getLog(ImprovementLevelHibernateDAO.class);


    /**
     * 
     * <p>
     * 
     * @return List 
     */
    public List findall() {
         List<T> t = find().list();
        return t;
    }

    public ImprovementLevel update(ImprovementLevel improvementLevel) throws SVTException {
        if(improvementLevel == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(improvementLevel);
        transaction.commit();
        log.debug("Value saved successfully");
        return improvementLevel;
    }

    /**
     * {@inheritDoc}
     */
    public ImprovementLevel add(ImprovementLevel improvementLevel) throws SVTException {
        ImprovementLevel improvementLevel1 = save(improvementLevel);
        return improvementLevel1;
    }


    private ImprovementLevel save(ImprovementLevel improvementLevel) {
        if (improvementLevel == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(improvementLevel);
        transaction.commit();
        log.debug("Value saved successfully");
        return improvementLevel;
    }


    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return ImprovementLevel.class;
    }


    public ImprovementLevel getById(String id) throws SVTException {
        T product = find().where("this.improvementLevelId=?", id).get();
        return product;
    }

    public ImprovementLevel getByName(String name) throws SVTException {
        T improvementLevel = find().where("this.name=?", name).get();
        return improvementLevel;
    }
}
