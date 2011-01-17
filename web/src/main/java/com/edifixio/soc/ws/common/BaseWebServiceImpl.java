package com.edifixio.soc.ws.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.remoting.jaxrpc.ServletEndpointSupport;
import com.edifixio.soc.common.ThreadLocalData;

public class BaseWebServiceImpl extends ServletEndpointSupport {
    private static final Log log = LogFactory.getLog(BaseWebServiceImpl.class);
    private static final String BIZ_CONTROL_DATA_MGR = "bizControlDataMgr";
    
    public BaseWebServiceImpl(){
        
    }
    protected Object getFactoryObject(String springId)
    {
       // this uses the "standard" Spring root web ApplicationContext
       return getWebApplicationContext().getBean(springId);
    }

    /** returns the ThreadLocal loginId we should all use */
    public String getLoginId()
    {
       String loginId = ThreadLocalData.getLoginId();
       if (!isGoodString(loginId)) {
          loginId = "BaseWebServiceImpl";
          setLoginId(loginId);
       }
       return loginId;
    }
    
    private boolean isGoodString(String s)
    {
       return s != null && s.length() > 0;
    }

    public void setLoginId(String id)
    {
       if (!isGoodString(id)) {
          id = "BaseWebServiceImplDefault";
       }
       log.debug("BaseWebServiceImpl.setLoginId(): setting loginId to " + id);
       ThreadLocalData.setLoginId(id);
    }

   
}
