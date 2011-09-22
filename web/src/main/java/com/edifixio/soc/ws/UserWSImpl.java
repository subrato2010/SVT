package com.edifixio.soc.ws;

import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.ws.common.BaseWebServiceImpl;

public class UserWSImpl extends BaseWebServiceImpl implements UserWS{

    /** Logger */
    private static Log log = LogFactory.getLog(UserWSImpl.class);
    public static final String USER_WSADAPTOR_ID = "userWSAdaptor";

    public UserServiceOut create(UserServiceIn serviceIn) throws RemoteException {
        setLoginId(serviceIn.getLoginId());
        try
        {
            return (getUserWSAdaptor().createUsers(serviceIn));            
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        return null;
        //return (getUserWSAdaptor().createUsers(serviceIn));
    }
    
    private UserWSAdaptor getUserWSAdaptor()
    {       
       return (UserWSAdaptor) getFactoryObject(USER_WSADAPTOR_ID);
    }    
}
 