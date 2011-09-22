// $Author: subratog $
package com.edifixio.soc.ws.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @author Subrato
 * To run test using JUnit
 */
public class SpringWSObjectFactory {
    private final static Log log = LogFactory.getLog(SpringWSObjectFactory.class);

    // get the path names from the default list of Constants
    public final static String SPRING_CONFIG_FILE = "spring-web-services.xml";

    private static String[] springPaths = { SPRING_CONFIG_FILE };

    private static ApplicationContext ctx = null;

    private static final class SingletonHolder {
        static SpringWSObjectFactory instance = new SpringWSObjectFactory();
    }

    private SpringWSObjectFactory() {
        setSpringContext(new ClassPathXmlApplicationContext(springPaths,
                com.edifixio.soc.biz.util.SpringObjectFactory.getInstance()
                        .getSpringContext()));
    }

    public static SpringWSObjectFactory getInstance() {
        if (SingletonHolder.instance == null) {
            SingletonHolder.instance = new SpringWSObjectFactory();
        }
        return SingletonHolder.instance;
    }

    public Object getObject(String springId) {
        if (ctx == null) {
            log.debug("I should NOT have a null spring context here");
        }
        //getObjectList();
        return getInstance().getSpringContext().getBean(springId);
    }

    public SessionFactory getSessionFactory() {
        log
                .debug("getSessionFactory() returning spring object called sessionFactory");
        return (SessionFactory) getObject("sessionFactory");
    }

    public void getObjectList(){
        for(String abc: getInstance().getSpringContext().getBeanDefinitionNames()){
            log.debug("Currently loaded Beans......................." + abc);
        }
    }
    public ApplicationContext getSpringContext() {
        return ctx;
    }

    public void setSpringContext(ApplicationContext ctx) {
        SpringWSObjectFactory.ctx = ctx;
    }
}