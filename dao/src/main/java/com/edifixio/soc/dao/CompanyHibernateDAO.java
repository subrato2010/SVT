// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.Company;


@SuppressWarnings("unchecked")
public class CompanyHibernateDAO<T extends Company> extends BaseHibernateDAO<T>
        implements CompanyDAO {
    private static final Log log = LogFactory.getLog(CompanyHibernateDAO.class);


    /**
     * Returns all the si
     * <p>
     * 
     * @return List of sids
     */
    public List findall() {
        log.debug("CompanyHibernateDAO.findall");
        List<T> t = find().list();
        return t;
    }

    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return Company.class;
    }
}
