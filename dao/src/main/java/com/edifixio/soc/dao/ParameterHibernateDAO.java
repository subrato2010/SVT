// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.util.BaseHibernateDAO;
import com.edifixio.soc.persist.Parameter;


@SuppressWarnings("unchecked")
public class ParameterHibernateDAO<T extends Parameter> extends BaseHibernateDAO<T>
        implements ParameterDAO {
    private static final Log log = LogFactory.getLog(ParameterHibernateDAO.class);


    public List findall() {
        List<T> t = find().list();
        return t;
    }

    public Parameter getCallbackURL() throws SVTException {
        T parameter = find().where("this.parameterId=1").get(); 
        return parameter;
    }
    
    public Parameter getConsumerKey() throws SVTException {
        T parameter = find().where("this.parameterId=2").get(); 
        return parameter;
    }
    
    public Parameter getConsumerKeySecret() throws SVTException {
        T parameter = find().where("this.parameterId=3").get(); 
        return parameter;
    }

    public Parameter getBitlyCallbackURL() throws SVTException {
        T parameter = find().where("this.parameterCode='BITLYCALLBCK'").get(); 
        return parameter;
    }
    
    public Parameter getBitlyClientId() throws SVTException {
        T parameter = find().where("this.parameterCode='BITLYCID'").get(); 
        return parameter;
    }
    
    public Parameter getBitlyClientSecret() throws SVTException {
        T parameter = find().where("this.parameterCode='BITLYCSCRT'").get(); 
        return parameter;
    }

    public Parameter getBitlyAuthUrl() throws SVTException {
        T parameter = find().where("this.parameterCode='BITLYAUTHURL'").get(); 
        return parameter;
    }

    public Parameter getBitlyAccessTokenUrl() throws SVTException {
        T parameter = find().where("this.parameterCode='BITLYTKNURL'").get(); 
        return parameter;
    }

    public Parameter getInfluencers() throws SVTException {
        T parameter = find().where("this.parameterId=4").get(); 
        return parameter;
    }

    public long getDelayInSeconds() throws SVTException {
        T parameter = find().where("this.parameterCode='DELAYINSECOND'").get(); 
        if(parameter != null && parameter.getValue() != null){
            return Long.parseLong(parameter.getValue());
        }
        return 3600000; // default 1hrs (60*60*1000)
    }
    public long getRTOPActionDelayInSeconds() throws SVTException {
        T parameter = find().where("this.parameterCode='DELAYINSECONDRTOP'").get(); 
        if(parameter != null && parameter.getValue() != null){
            return Long.parseLong(parameter.getValue());
        }
        return 1800; // default 30mins (60*5*1000)
    }
    
    
    public Parameter getDatashiftAppURL() throws SVTException {
        T parameter = find().where("this.parameterCode='DSAPPURL'").get(); 
        return parameter;
    }

    public Parameter getGoogleMapKey() throws SVTException {
        T parameter = find().where("this.parameterCode='GOOGLEMAPKEY'").get(); 
        return parameter;
    }

    @Override
    protected Class getConcreteClass() {
        // TODO Auto-generated method stub
        return Parameter.class;
    }
}
