package com.edifixio.soc.web.init;

import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.edifixio.soc.ws.common.BaseWebServiceImpl;

/** base class for objects that load data into the ApplicationContext, usually at server startup */
public class BaseApplContextLoader {
    
    private static final Log log = LogFactory.getLog(BaseApplContextLoader.class);
    
    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
     */
    public void contextDestroyed(@SuppressWarnings("unused") ServletContextEvent arg0)
    {
    }
    
    @SuppressWarnings("unchecked")
    protected void loadMap(ServletContext servletContext, String mapKey, Map map)
    {
       // log.debug("loading into servletContext: " + servletContext);
       servletContext.setAttribute(mapKey, map);
    }

    protected void loadObject(ServletContext servletContext, String mapKey, Object object)
    {
//       log.debug("setting servletContext attribute " + mapKey + " with Object of type "
       servletContext.setAttribute(mapKey, object);
    }

    /**
     * returns a spring-supplied object with the given handle
     * 
     * @param serviceName
     */
    protected Object getFactoryObject(String serviceName, ServletContext servletContext)
    {
       return WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).getBean(serviceName);
    }
}
