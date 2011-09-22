// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.TrendingGrade;


@SuppressWarnings("unchecked")
public class TrendingGradeHibernateDAO<T extends TrendingGrade> extends BaseHibernateDAO<T>
        implements TrendingGradeDAO {
    private static final Log log = LogFactory.getLog(TrendingGradeHibernateDAO.class);


    public List findall() {
        List<T> t = find().list();
        return t;
    }

    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return TrendingGrade.class;
    }

    public TrendingGrade getGradeBetweenFromTo(float value)
            throws SVTException {
        List<T> t = find().where("this.toPctValue > ?", value).orderAscending("this.toPctValue").list();
        if(t != null && t.size() > 0){
            return t.get(0);
        }
        return null;
    }
}
