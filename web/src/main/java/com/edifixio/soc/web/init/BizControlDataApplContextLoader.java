package com.edifixio.soc.web.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.common.SVTException;

/** loads our static, "business control data" into the server's application context */
public class BizControlDataApplContextLoader extends BaseApplContextLoader implements ServletContextListener{
    
    private static final Log log = LogFactory.getLog(BizControlDataApplContextLoader.class);
    
    public void contextInitialized(ServletContextEvent ev)
    {
       log.debug("ApplicationContextLoader: contextInitialized() called");
       log.info("ApplicationContextLoader: STARTING initialization of our application context");

       // put maps with our static data into app context for JSPs to use
       try {
          loadStaticControlDataToAppContext(ev.getServletContext());
       }
       catch (Throwable ex) {
          log.error("Error initializing static data in web context: " + ex.getLocalizedMessage());
          ex.printStackTrace();
       }
       log.info("ApplicationContextLoader: COMPLETED initializing our application context");
    }

    /**
     * loads maps of all our very static "biz control" data into the server application context
     * 
     * @throws OMSException
     */
    public void loadStaticControlDataToAppContext(ServletContext servletContext)
    {
       BizControlDataApplContextLoader loader = (BizControlDataApplContextLoader) getFactoryObject(
             "bizControlDataApplContextLoader", servletContext);
       loader.loadData(servletContext);
    }
    
    /**
    * puts all the necessary data structures into the server application context, typically so JSPs can generate lists of things, e.g.
    * select lists, without ahving to re-read the same very static data over and over again subrato
    * 
    * @throws SVTException
    */
   public void loadData(ServletContext servletContext)
   {
       
   }
}
