package com.edifixio.soc.ws;

import com.edifixio.soc.ws.data.WSUser;

public class UserServiceOut  extends BaseWebServiceOut {
    private WSUser[] user = new WSUser[MAX_SVC_BUF_SIZE];

    public WSUser[] getUser()
    {
       return user;
    }

    public void setUser(WSUser[] user)
    {
       this.user = user;
    }

    /** puts the given user into the array, allocating more space if necessary */
    public void addUser(WSUser c)
    {
       boolean added = addObjectToArray(user, c);
       if (!added) {
           WSUser[] arr = new WSUser[user.length + MAX_SVC_BUF_SIZE];
          copyArray(user, arr);
          user = arr;
          addUser(c); // recurse now with a bigger array
       }
    }
}
