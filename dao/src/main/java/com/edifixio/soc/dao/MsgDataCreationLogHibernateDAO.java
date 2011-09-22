// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.MsgDataCreationLog;


@SuppressWarnings("unchecked")
public class MsgDataCreationLogHibernateDAO<T extends MsgDataCreationLog> extends BaseHibernateDAO<T>
        implements MsgDataCreationLogDAO {
    private static final Log log = LogFactory.getLog(MsgDataCreationLogHibernateDAO.class);

    public List findall() {
        List<T> t = find().list();
        return t;
    }

    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return MsgDataCreationLog.class;
    }

    public Date getMaxActionDate(String profileId) throws SVTException {
        List<T> t = find().orderDescending("actionDate").list();
        if(t != null && t.size()>0){
            return t.get(0).getActionDate();
        }
        return null;
    }
    
    public Date getMinActionDate(String profileId) throws SVTException {
        List<T> t = find().orderAscending("actionDate").list();
        if(t != null && t.size()>0){
            return t.get(0).getActionDate();
        }
        return null;
    }
    
    /**
     * This method will return currentDate with hour, minute, sec, millisec as 0
     * @return
     */
    private Date getCurrentDate(){
        // Get Calendar object set to the date and time of the given Date object  
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(new Date());
        // Set time fields to zero  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0); 
        return cal.getTime(); 
    }
}
