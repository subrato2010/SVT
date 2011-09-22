// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.TimeZone;


@SuppressWarnings("unchecked")
public class TimeZoneHibernateDAO<T extends TimeZone> extends
        BaseHibernateDAO<T> implements TimeZoneDAO {
    private static final Log log = LogFactory
            .getLog(TimeZoneHibernateDAO.class);


    public List findall() {
        log.debug("TimeZoneHibernateDAO.findall");
        List<T> t = find().list();
        return t;
    }
 
    public TimeZone getById(String id) throws SVTException {
        T timeZone = find().where("this.id=?", id).get();
        return timeZone;
    }

    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return TimeZone.class;
    }
}
