package com.edifixio.soc.web.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.edifixio.soc.common.SVTException;

/**
 * 
 * @author SubratoG
 * This class is now ONLY FOR TESTING as we are now using the spring web application context instead via the FacesContext
 *
 */
public class SpringObjectFactory {
    
    private final static String WEB_APP_BEAN_FILE = "spring-web-main-app.xml";
    private final static String WEB_SVC_BEAN_FILE = "spring-web-services.xml";
    private final static String[] beanDefFiles = { WEB_APP_BEAN_FILE,  WEB_SVC_BEAN_FILE};

    private static ApplicationContext ctx = null;
    private final static Log log = LogFactory.getLog(SpringObjectFactory.class);

 
    private static final class SingletonHolder
    {
       static SpringObjectFactory instance = new SpringObjectFactory();
    }

    private SpringObjectFactory()
    {
        setSpringContext(new ClassPathXmlApplicationContext(beanDefFiles,
              com.edifixio.soc.biz.util.SpringObjectFactory.getInstance().getSpringContext()));
    }

    public static SpringObjectFactory getInstance()
    {
       if (SingletonHolder.instance == null)
          SingletonHolder.instance = new SpringObjectFactory();
       return SingletonHolder.instance;
    }

    public Object getObject(String objectId) throws SVTException
    {
       // log.debug("retrieving Spring bean with id: " + objectId);
       if (ctx == null) {
          throw new SVTException("I should NOT have a null spring context here");
       }
       return getInstance().getSpringContext().getBean(objectId);
    }

    public ApplicationContext getSpringContext()
    {
       return ctx;
    }

    public void setSpringContext(ApplicationContext ctx)
    {
       SpringObjectFactory.ctx = ctx;
    }
}
