// $Author: subratog $
package com.edifixio.soc.biz.util;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.ChannelDAO;
import com.edifixio.soc.dao.ProfilePreferenceDAO;
import com.edifixio.soc.dao.StateProvinceDAO;
import com.edifixio.soc.dao.TwitterAccountDAO;
import com.edifixio.soc.dao.UserProfileDetailDAO;
import com.edifixio.soc.dao.util.DAOProvider;
import com.edifixio.soc.persist.Benchmark;
import com.edifixio.soc.persist.Channel;
import com.edifixio.soc.persist.ProfilePreference;
import com.edifixio.soc.persist.StateProvince;
import com.edifixio.soc.persist.TwitterAccount;
import com.edifixio.soc.persist.UserProfileDetail;


public class BaseBizObject {
    private static final Log log = LogFactory.getLog("BaseBizObject");
    private DAOProvider daoProvider;
    protected static final String PIPE = "|";
    protected static final String BACKSLASH = "\\";
    private String formatDouble = "#.#";
    DecimalFormat twoDForm = new DecimalFormat("#.##");  
    
    private String currentBenchmarkId;
    protected static final String TWITTERCHANNEL ="1"; // points to twitter channel
    protected static final String SENTIMENT = "Sentiment";
    protected static final String RETENTION = "Retention";
    protected static final String REACH = "Reach";
    protected static final String LOYALTY = "Loyalty";
    protected static final String INFLUENCE = "Influence";
    protected static final String DEMOGRAPHICS = "Demographics";
    protected static final String ENGAGEMENT = "Engagement";
    
    public DAOProvider getDaoProvider() {
        daoProvider.setBenchmarkId(currentBenchmarkId);
        return daoProvider;
    }

    public String getCurrentBenchmarkId(){
        return this.currentBenchmarkId;
    }

    public Benchmark getCurrentBenchmark() throws SVTException{
        return getDaoProvider().getBenchmarkDAO().getByIdOrLatest(getCurrentBenchmarkId());
    }
    
    public void setCurrentBenchmarkId(String currentBenchmarkId){
        this.currentBenchmarkId = currentBenchmarkId;
    }
    
    public void setDaoProvider(DAOProvider daoProvider) {
        this.daoProvider = daoProvider;
    }


    public ChannelDAO<Channel> getChannelDAO() {
        log.debug("daoprovider: " + getDaoProvider());
        return getDaoProvider().getChannelDAO();
    }

    public ProfilePreferenceDAO<ProfilePreference> getProfilePreferenceDAO() {
        return getDaoProvider().getProfilePreferenceDAO();
    }
    
    public UserProfileDetailDAO<UserProfileDetail> getUserProfileDetailDAO() {
        return getDaoProvider().getUserProfileDetailDAO();
    }
    
    public TwitterAccountDAO<TwitterAccount> getTwitterAccountDAO() {
        return getDaoProvider().getTwitterAccountDAO();
    }
    
    public StateProvinceDAO<StateProvince> getStateProvinceDAO() {
        return getDaoProvider().getStateProvinceDAO();
    }

    
    /**
     * uses apache BeanUtils to copy all matching properties to the dest (arg 1)
     * from the source (arg 2)
     */
    protected void copyPropertiesQuietly(Object dest, Object source) {
        quietlyCopyProperties(dest, source);
    }


    /**
     * uses apache BeanUtils to copy all matching properties to the dest (arg 1)
     * from the source (arg 2)
     */
    protected void quietlyCopyProperties(Object dest, Object source) {
        try {
            BeanUtils.copyProperties(dest, source);
        } catch (IllegalAccessException ex) {
            // nothing to worry about
        } catch (InvocationTargetException ex) {
            // nothing to worry about
        } 
    }
    
    public double getDoubleNumber(double number) {
        DecimalFormat twoDForm = new DecimalFormat(formatDouble);
        return Double.valueOf(twoDForm.format(Math.abs(number)));
    }
    
    public double getDoubleNumber2Decimal(double number){
        if(Double.isNaN(number)){
            return number;
        }
        return Double.valueOf(twoDForm.format(number));
    }
    public String getDoubleFormatedAsString(double number){
        int integerPart = (int) number;
        double decimalPart = number - integerPart;
        //TODO
        return (decimalPart==0)?("" + integerPart):("" +number);
    }
}
