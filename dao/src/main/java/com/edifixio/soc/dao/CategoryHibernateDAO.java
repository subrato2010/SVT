// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.Category;


@SuppressWarnings("unchecked")
public class CategoryHibernateDAO<T extends Category> extends
        BaseHibernateDAO<T> implements CategoryDAO {
    private static final Log log = LogFactory
            .getLog(CategoryHibernateDAO.class);


    /**
     * Returns all the si
     * <p>
     * 
     * @return List of sids
     */
    public List findall() {
        log.debug("CategoryHibernateDAO.findall");
        List<T> t = find().list();
        return t;
    }

    public Category getByName(String name) throws SVTException {
        T category = find().where("this.categoryName=?", name).get();
        return category;
    }

    public List findByName(String name) throws SVTException {
        List<T> categories = find().where("this.categoryName=?", name).list();
        return categories;
    }

    public Category getById(String id) throws SVTException {
        T category = find().where("this.categoryId=?", id).get();
        return category;
    }

    public Category getByNameChannelId(String name, String channelId) throws SVTException {
        T category = find().where("this.categoryName=?", name).and(
                "this.channel.channelId=?", channelId).get();
        return category;
    }

    public Category saveOrUpdate(Category category) throws SVTException {
        log.debug("CategoryHibernateDAO.saveOrUpdate");
        Category category1 = update(category);
        return category1;
    }

    private Category update(Category category) {
        if (category == null) {
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(category);
        transaction.commit();

        log.debug("Value saved successfully");
        return category;
    }

    /**
     * {@inheritDoc}
     */
    public Category addCategory(Category category) throws SVTException {
        log.debug("CategoryHibernateDAO.addCategory");
        Category category1 = save(category);
        return category1;
    }


    private Category save(Category category) {
        if (category == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(category);
        transaction.commit();
        log.debug("Value saved successfully");
        return category;
    }


    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return Category.class;
    }
}
