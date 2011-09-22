// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Parameter;

public interface ParameterDAO<T extends Parameter> {
    public List<T> findall()  throws SVTException;   
    public Parameter getCallbackURL() throws SVTException;
    public Parameter getConsumerKey() throws SVTException;
    public Parameter getConsumerKeySecret() throws SVTException;
    public Parameter getBitlyCallbackURL() throws SVTException;
    public Parameter getBitlyClientId() throws SVTException;
    public Parameter getBitlyClientSecret() throws SVTException;
    public Parameter getBitlyAuthUrl() throws SVTException;
    public Parameter getBitlyAccessTokenUrl() throws SVTException;
    public Parameter getDatashiftAppURL() throws SVTException ;
    public Parameter getGoogleMapKey() throws SVTException;
    public long getDelayInSeconds() throws SVTException;
    public long getRTOPActionDelayInSeconds() throws SVTException;
    //Added by neel
    public Parameter getInfluencers() throws SVTException;
    
}
