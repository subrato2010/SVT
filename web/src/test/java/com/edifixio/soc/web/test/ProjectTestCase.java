package com.edifixio.soc.web.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.ChannelMgr;
import com.edifixio.soc.biz.util.BizControlDataMgr;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.DAOProvider;
import com.edifixio.soc.persist.util.PersistTestCase;

/**
 * 
 * @author SubratoG  Use this as the superclass of all Tests in this project
 *
 */
public class ProjectTestCase extends PersistTestCase{
    public static final String TEST_USER_ID = "WebProjectTestUser";
    public static final String SUPER_USER_ID = "admin";
    
    private final static Log log = LogFactory.getLog(ProjectTestCase.class);
 
    @Override
    public Object getFactoryObject(String id) throws SVTException
    {
       return SpringObjectFactory.getInstance().getObject(id);
    }

   /* protected WebServiceFactory getWebServiceFactory() throws SVTException
    {
       return (WebServiceFactory) getFactoryObject("webServiceFactory");
    }*/

    protected BizControlDataMgr getBizSvcFactory() throws SVTException
    {
       return (BizControlDataMgr) getFactoryObject(com.edifixio.soc.biz.util.BizControlDataMgr.BIZ_SVC_FACTORY_SPRING_ID);
    }

    
    protected DAOProvider getDaoProvider() throws SVTException
    {
       DAOProvider p = (DAOProvider) getFactoryObject("daoProvider");
       assertNotNull(p);
       return p;
    }

    protected ChannelMgr getChannelMgr() throws SVTException
    {
       return getBizSvcFactory().getChannelMgr();
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
}
