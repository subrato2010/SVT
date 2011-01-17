package com.edifixio.soc.common;

import java.sql.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** contains any data we want in our system to be ThreadLocal */
public class ThreadLocalData {
    
    @SuppressWarnings("unused")
    private static final Log log = LogFactory.getLog(ThreadLocalData.class);

    private static ThreadLocal<String> loginId = new ThreadLocal<String>();
    private static ThreadLocal<String> remoteIPAddress = new ThreadLocal<String>();
    private static ThreadLocal<Boolean> endUserProcess = new ThreadLocal<Boolean>();
    private static ThreadLocal<Connection> jdbcConnection = new ThreadLocal<Connection>();

    public static String getLoginId()
    {
       return loginId.get();
    }

    public static void setLoginId(String id)
    {
       //log.debug("ThreadLocalData.setLoginId(): " + id);
       loginId.set(id);
    }

    public static String getRemoteIPAddress()
    {
       return remoteIPAddress.get();
    }
    
    public static void setRemoteIPAddress(String ip)
    {
       remoteIPAddress.set(ip);
    }

    public static boolean isEndUserProcess()
    {
       if (endUserProcess.get() == null) {
          setEndUserProcess(true); // default to 'yes, there is a user at the end of this wire
       }
       return endUserProcess.get().booleanValue();
    }
    
    public static void setEndUserProcess(boolean b)
    {
       endUserProcess.set(new Boolean(b));
    }
    
    public static Connection getConnection()
    {
       return jdbcConnection.get();
    }
    
    public static void setConnection(Connection c)
    {
       jdbcConnection.set(c);
    }
}

