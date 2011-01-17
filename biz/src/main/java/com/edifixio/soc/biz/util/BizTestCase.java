// $Author: subratog $
package com.edifixio.soc.biz.util;

import java.text.DecimalFormat;
import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import com.edifixio.soc.batch.TwitterMgr;
import com.edifixio.soc.biz.CategoryMgr;
import com.edifixio.soc.biz.ChannelMgr;
import com.edifixio.soc.biz.InboundDummyMgr;
import com.edifixio.soc.biz.MetricsMgr;
import com.edifixio.soc.biz.OutboundDummyMgr;
import com.edifixio.soc.biz.OverallDummyMgr;
import com.edifixio.soc.biz.ProfileDummyMgr;
import com.edifixio.soc.biz.ProfileListMasterMgr;
import com.edifixio.soc.biz.ProfilePreferenceMgr;
import com.edifixio.soc.biz.RawResultMgr;
import com.edifixio.soc.biz.SocIntellDummyMgr;
import com.edifixio.soc.biz.StagingRawScoreMgr;
import com.edifixio.soc.biz.StateProvinceMgr;
import com.edifixio.soc.biz.TwitterAccountMgr;
import com.edifixio.soc.biz.UserProfileMgr;

public class BizTestCase extends TestCase {
    /** Logger */
    private static Log logger = LogFactory.getLog(BizTestCase.class);
    DecimalFormat twoDForm = new DecimalFormat("#.##"); 

    public RawResultMgr getRawResultMgr() {
        return (RawResultMgr) getFactoryObject("rawResultMgr");
    }
    public TwitterMgr getTwitterMgr() {
        return (TwitterMgr) getFactoryObject("twitterMgr");
    }
    public MetricsMgr getMetricsMgr() {
        return (MetricsMgr) getFactoryObject("metricsMgr");
    }
    public StagingRawScoreMgr getStagingRawScoreMgr() {
        return (StagingRawScoreMgr) getFactoryObject("stagingRawScoreMgr");
    }
    public TwitterAccountMgr getTwitterAccountMgr() {
        return (TwitterAccountMgr) getFactoryObject("twitterAccountMgr");
    }
    public ProfilePreferenceMgr getProfilePreferenceMgr() {
        return (ProfilePreferenceMgr) getFactoryObject("profilePreferenceMgr");
    }
    public ChannelMgr getChannelMgr() {
        return (ChannelMgr) getFactoryObject("channelMgr");
    }
    public CategoryMgr getCategoryMgr() {
        return (CategoryMgr) getFactoryObject("categoryMgr");
    }
    public UserProfileMgr getUserProfileMgr() {
        return (UserProfileMgr) getFactoryObject("userProfileMgr");
    }
    
    public InboundDummyMgr getInboundDummyMgr() {
        return (InboundDummyMgr) getFactoryObject("inboundDummyMgr");
    }
    public OutboundDummyMgr getOutboundDummyMgr() {
        return (OutboundDummyMgr) getFactoryObject("outboundDummyMgr");
    }
    public OverallDummyMgr getOverallDummyMgr() {
        return (OverallDummyMgr) getFactoryObject("overallDummyMgr");
    }
    public ProfileDummyMgr getProfileDummyMgr() {
        return (ProfileDummyMgr) getFactoryObject("profileDummyMgr");
    }
    public SocIntellDummyMgr getSocIntellDummyMgr() {
        return (SocIntellDummyMgr) getFactoryObject("socIntellDummyMgr");
    }
    public StateProvinceMgr getStateProvinceMgr() {
        return (StateProvinceMgr) getFactoryObject("stateProvinceMgr");
    } 
    public ProfileListMasterMgr getProfileListMasterMgr() {
        return (ProfileListMasterMgr) getFactoryObject("profileListMasterMgr");
    }
    public Object getFactoryObject(String id) {
        return SpringObjectFactory.getInstance().getObject(id);
    }

    public double getDoubleNumber2Decimal(double number){
        if(Double.isNaN(number)){
            return number;
        }
        return Double.valueOf(twoDForm.format(number));
    }

    // This is new
    public SessionFactory getSessionFactory() {
        return SpringObjectFactory.getInstance().getSessionFactory();
    }


    /**
     * we must bind a session to the current thread to get the behavior we want,
     * otherwise will get lazy load problem
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setupHibernateForTests();
    }


    private void setupHibernateForTests() {
        Interceptor intercept = (Interceptor) getFactoryObject("entityInterceptor");
        assertNotNull(intercept);
        Session session = SessionFactoryUtils.getSession(getSessionFactory(),
                intercept, null);
        if (TransactionSynchronizationManager.getResource(getSessionFactory()) != null) {
            // log.debug("SessionHolder already bound to thread");
        } else {
            // log.debug("binding sessionHolder to thread");
            TransactionSynchronizationManager.bindResource(getSessionFactory(),
                    new SessionHolder(session));
        }
    }


    /** and here we clean up the session */
    @Override
    protected void tearDown() throws Exception {
        // log.debug("unbinding hibernate session");
        SessionHolder sessionHolder = (SessionHolder) TransactionSynchronizationManager
                .unbindResource(getSessionFactory());
        SessionFactoryUtils.releaseSession(sessionHolder.getSession(),
                getSessionFactory());
    }
}
