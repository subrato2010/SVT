// $Author: subratog $
package com.edifixio.soc.persist.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Subrato
 * 
 */
public class SpringObjectFactory {
    private final static Log log = LogFactory.getLog(SpringObjectFactory.class);

    // get the path names from the default list of Constants
    public final static String SPRING_CONFIG_FILE = "spring-session-factory.xml";

    private static String[] springPaths = { SPRING_CONFIG_FILE };

    private static ApplicationContext ctx = null;

    private static final class SingletonHolder {
        static SpringObjectFactory instance = null;
    }

    private SpringObjectFactory() {
        setSpringContext(new ClassPathXmlApplicationContext(springPaths));
    }

    public static SpringObjectFactory getInstance() {
        if (SingletonHolder.instance == null) {
            SingletonHolder.instance = new SpringObjectFactory();
        }
        return SingletonHolder.instance;
    }

    public Object getObject(String springId) {
        if (ctx == null) {
            log.debug("I should NOT have a null spring context here");
        }
        return getInstance().getSpringContext().getBean(springId);
    }

    public ApplicationContext getSpringContext() {
        return ctx;
    }

    public void setSpringContext(ApplicationContext ctx) {
        SpringObjectFactory.ctx = ctx;
    }
}
