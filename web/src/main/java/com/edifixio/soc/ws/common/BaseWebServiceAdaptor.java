package com.edifixio.soc.ws.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.util.BizControlDataMgr;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.common.ThreadLocalData;
import com.edifixio.soc.dao.util.DAOProvider;
import com.edifixio.soc.ws.BaseWebServiceOut;

/**
* super class for all web service adaptors
* 
* @author $Author: subratog $
* 
*/
public class BaseWebServiceAdaptor{
    private static Log log = LogFactory.getLog(BaseWebServiceAdaptor.class);
    
    private BizControlDataMgr bizSvcFactory;
    private DAOProvider daoprovider;
    
    // getUserProfileMgr().createUserProfile(userProfileDTO); TODO: for data persist in LDAP server
    public DAOProvider getDaoprovider() {
        return daoprovider;
    }
    public void setDaoprovider(DAOProvider daoprovider) {
        this.daoprovider = daoprovider;
    }
    public BaseWebServiceAdaptor()
    {
       ThreadLocalData.setLoginId("BaseWebServiceAdaptor"); // just as a default
    }
    protected String getLoginId()
    {
       return ThreadLocalData.getLoginId();
    }
    public BizControlDataMgr getBizSvcFactory() {
        return bizSvcFactory;
    }
    public void setBizSvcFactory(BizControlDataMgr bizSvcFactory) {
        this.bizSvcFactory = bizSvcFactory;
    }
    
    /** handles TWTExceptions thrown from the biz layer */
    protected void handleBizErrors(SVTException ex, BaseWebServiceOut serviceOut)
    {
       log.error(ex);
       log.error(ex.getStackTrace());
       serviceOut.setMainErrorMessage(ex.getMessage()); // TODO: incomplete
    }
    
    public Calendar getCalendarFromDate(Date date)
    {
       if (date != null) {
          SimpleDateFormat fSDateFormat = new SimpleDateFormat();
          fSDateFormat.format(date);
          return fSDateFormat.getCalendar();
       }
       return null;
    }

    public Date getDateFromCalendar(Calendar date)
    {
       if (date != null) {
          return date.getTime();
       }
       return null;
    }

    @SuppressWarnings("unchecked")
    protected boolean isGoodCollection(Collection c)
    {
       return c != null && c.size() > 0;
    }

    @SuppressWarnings("unchecked")
    protected boolean isGoodCollection(Map m)
    {
       return m != null && m.size() > 0;
    }

    protected boolean isGoodString(String s)
    {
       if (s == null) {
          return false;
       }
       return s.trim().length() > 0;
    }

}
