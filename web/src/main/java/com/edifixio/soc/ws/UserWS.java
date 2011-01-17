package com.edifixio.soc.ws;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * exposes all user-oriented web services 
 * @author Subrato
 *
 */
public interface UserWS  extends Remote{
    public UserServiceOut create(UserServiceIn serviceIn) throws RemoteException;
}

