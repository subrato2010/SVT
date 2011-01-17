// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.StateProvince;


@SuppressWarnings("unchecked")
public class StateProvinceHibernateDAO<T extends StateProvince> extends BaseHibernateDAO<T>
        implements StateProvinceDAO {
    private static final Log log = LogFactory.getLog(StateProvinceHibernateDAO.class);


    /**
     * Returns all the si
     * <p>
     * 
     * @return List of sids
     */
    public List findall() {
        log.debug("StateProvinceHibernateDAO.findall");
        List<T> t = find().where("this.activStatus=true").list();
        return t;
    }


    /**
     * {@inheritDoc}
     */
    public StateProvince add(StateProvince stateProvince) throws SVTException {
        log.debug("StateProvinceHibernateDAO.add");
        StateProvince stateProvince1 = save(stateProvince);
        return stateProvince1;
    }


    private StateProvince save(StateProvince stateProvince) {
        if (stateProvince == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(stateProvince);
        transaction.commit();
        log.debug("Value saved successfully");
        return stateProvince;
    }


    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return StateProvince.class;
    }
}
