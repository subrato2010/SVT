// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.Channel;
import com.edifixio.soc.persist.Industry;
import com.edifixio.soc.persist.Product;


@SuppressWarnings("unchecked")
public class IndustryHibernateDAO<T extends Industry> extends BaseHibernateDAO<T>
        implements IndustryDAO {
    private static final Log log = LogFactory.getLog(IndustryHibernateDAO.class);


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

    public Industry update(Industry industry) throws SVTException {
        if(industry == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(industry);
        transaction.commit();
        log.debug("Value saved successfully");
        return industry;
    }

    /**
     * {@inheritDoc}
     */
    public Industry add(Industry industry) throws SVTException {
        Industry industry1 = save(industry);
        return industry1;
    }


    private Industry save(Industry industry) {
        if (industry == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(industry);
        transaction.commit();
        log.debug("Value saved successfully");
        return industry;
    }


    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return Industry.class;
    }


    public Industry getById(String id) throws SVTException {
        T industry = find().where("this.industryId=?", id).get();
        return industry;
    }

    public Industry getByName(String name) throws SVTException {
        T industry = find().where("this.industryName=?", name).get();
        return industry;
    }
}
