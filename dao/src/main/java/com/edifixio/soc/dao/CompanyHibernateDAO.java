// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.Company;


@SuppressWarnings("unchecked")
public class CompanyHibernateDAO<T extends Company> extends BaseHibernateDAO<T>
        implements CompanyDAO {
    private static final Log log = LogFactory.getLog(CompanyHibernateDAO.class);

    public Company getByName(String handlerName) throws SVTException {
        T company = find().where("this.companyName=?", handlerName).get();
        return company;
    }
    public Company getById(String companyId) throws SVTException {
        T company = find().where("this.companyId=?", companyId).get();
        return company;
    }
     public List findall() {
        log.debug("CompanyHibernateDAO.findall");
        List<T> t = find().list();
        return t;
    }

    public Company add(Company company) throws SVTException {
        Company company1 = save(company);
        return company1;
    }

    private Company save(Company company) {
        if (company == null) {
            log.debug("Null value passed to save");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.save(company);
        transaction.commit();
        log.debug("Value saved successfully");
        return company;
    }

    public Company update(Company company) throws SVTException {
        if(company == null){
            log.debug("Null value passed to update");
            return null;
        }
        Session session = getCurrentSession("subrato");
        Transaction transaction = session.beginTransaction();
        session.update(company);
        session.flush();
        transaction.commit();
        log.debug("Value saved successfully");
        return company;
    }
    
    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return Company.class;
    }
}
