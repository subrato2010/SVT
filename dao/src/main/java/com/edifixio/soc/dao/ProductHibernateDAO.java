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
import com.edifixio.soc.persist.Product;


@SuppressWarnings("unchecked")
public class ProductHibernateDAO<T extends Product> extends BaseHibernateDAO<T>
        implements ProductDAO {
    private static final Log log = LogFactory.getLog(ProductHibernateDAO.class);


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

    public Product update(Product product) throws SVTException {
        if(product == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
        log.debug("Value saved successfully");
        return product;
    }

    /**
     * {@inheritDoc}
     */
    public Product add(Product product) throws SVTException {
        Product product1 = save(product);
        return product1;
    }


    private Product save(Product product) {
        if (product == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        log.debug("Value saved successfully");
        return product;
    }


    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return Product.class;
    }


    public Product getById(String id) throws SVTException {
        T product = find().where("this.productId=?", id).get();
        return product;
    }

    public Product getByName(String name) throws SVTException {
        T product = find().where("this.productName=?", name).get();
        return product;
    }

}
