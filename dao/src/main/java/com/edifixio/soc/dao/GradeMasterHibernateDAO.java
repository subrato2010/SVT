// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.GradeMaster;


@SuppressWarnings("unchecked")
public class GradeMasterHibernateDAO<T extends GradeMaster> extends BaseHibernateDAO<T>
        implements GradeMasterDAO {
    private static final Log log = LogFactory.getLog(GradeMasterHibernateDAO.class);


    public List findall() {
        List<T> t = find().list();
        return t;
    }

    public List findPerformanceTrue() {
        List<T> gradeMasters = find().where("this.performance=true").orderDescending("this.percentValue").list();
        return gradeMasters;
    }

    public List findPerformanceFalse() {
        List<T> gradeMasters = find().where("this.performance=false").orderDescending("this.percentValue").list();
        return gradeMasters;
    }

    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return GradeMaster.class;
    }
}
