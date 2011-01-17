// $Author: subratog $
package com.edifixio.soc.biz.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @author Subrato
 * To run test using JUnit
 */
public class SpringObjectFactory {
    private final static Log log = LogFactory.getLog(SpringObjectFactory.class);

    // get the path names from the default list of Constants
    public final static String SPRING_CONFIG_FILE = "spring-biz.xml";

    private static String[] springPaths = { SPRING_CONFIG_FILE };

    private static ApplicationContext ctx = null;

    private static final class SingletonHolder {
        static SpringObjectFactory instance = new SpringObjectFactory();
    }

    private SpringObjectFactory() {
        setSpringContext(new ClassPathXmlApplicationContext(springPaths,
                com.edifixio.soc.dao.util.SpringObjectFactory.getInstance()
                        .getSpringContext()));
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
        //getObjectList();
        return getInstance().getSpringContext().getBean(springId);
    }

    public SessionFactory getSessionFactory() {
        log
                .debug("getSessionFactory() returning spring object called sessionFactory");
        return (SessionFactory) getObject("sessionFactory");
    }

/*    public void getObjectList(){
        for(String abc: getInstance().getSpringContext().getBeanDefinitionNames()){
            log.debug("Currently loaded Beans......................." + abc);
        }
    }
*/    public ApplicationContext getSpringContext() {
        return ctx;
    }

    public void setSpringContext(ApplicationContext ctx) {
        SpringObjectFactory.ctx = ctx;
    }
}