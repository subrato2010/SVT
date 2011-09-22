// author: subrato
package com.edifixio.soc.ws;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class UserServiceIn extends BaseWebServiceIn{
    
    @SuppressWarnings("unused")
    private static final Log log = LogFactory.getLog(UserServiceIn.class);
   
    private WSUserIn[] user = new WSUserIn[MAX_SVC_BUF_SIZE];

    public WSUserIn[] getUser() // the singular name is important for the generated WSDL
    {
       return user;
    }

    public void setUser(WSUserIn[] users)
    {
       this.user = users;
       log.debug("setUser(): users...............>" + users);
       if (users != null) {
          log.debug("setUser(): users.length........>" + users.length);
        }
    }

    /** @return */
    public List<WSUserIn> getUserList()
    {
       return Arrays.asList(this.user);
    }
}
