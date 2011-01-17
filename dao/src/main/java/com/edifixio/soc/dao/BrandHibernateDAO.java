// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.Brand;


@SuppressWarnings("unchecked")
public class BrandHibernateDAO<T extends Brand> extends
        BaseHibernateDAO<T> implements BrandDAO {
    private static final Log log = LogFactory
            .getLog(BrandHibernateDAO.class);


    /**
     * Returns all the brand
     * <p>
     * 
     * @return List of brands
     */
    public List findall() {
        log.debug("BrandHibernateDAO.findall");
        List<T> t = find().list();
        return t;
    }

    /**
     * {@inheritDoc}
     */
    public Brand addBrand(Brand brand) throws SVTException {
        Brand brand1 = save(brand);
        return brand1;
    }


    private Brand save(Brand brand) {
        if (brand == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(brand);
        transaction.commit();
        log.debug("Value saved successfully");
        return brand;
    }


    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return Brand.class;
    }

}
