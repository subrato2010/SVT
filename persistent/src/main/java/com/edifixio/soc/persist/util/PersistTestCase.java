package com.edifixio.soc.persist.util;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.edifixio.soc.common.SVTException;

public class PersistTestCase extends TestCase{
    /**
     * 
     * 
     */
    SessionFactory sessionFactory = null;

    public void setUp() throws Exception
    {
       // if you want lazy loading to work, you must do these things
       // also, this package does NOT define its own sessionFactory, persist does
       // that for us
       // but you might want something different...
       sessionFactory = (SessionFactory) getFactoryObject("sessionFactory");
       Session s = sessionFactory.openSession();
       TransactionSynchronizationManager.bindResource(sessionFactory,new SessionHolder(s));
    }

    public void tearDown() throws Exception
    {

       SessionHolder holder = (SessionHolder) TransactionSynchronizationManager
             .getResource(sessionFactory);
       if (holder != null) {
          Session s = holder.getSession();
          if (s != null) {
             s.flush();
             TransactionSynchronizationManager.unbindResource(sessionFactory);
             SessionFactoryUtils.releaseSession(s, sessionFactory);
          }
       }
    }

    /**
     * returns a Spring-supplied object with the given handle
     * 
     * @return
     * @param springId
     * @throws OMSException
     */
    public Object getFactoryObject(String springId) throws SVTException
    {
       return SpringObjectFactory.getInstance().getObject(springId);
    }

}
