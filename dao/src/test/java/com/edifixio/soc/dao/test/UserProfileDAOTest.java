// jarfile required: junit-4.8.1.jar
// $Author: subratog $
package com.edifixio.soc.dao.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.dao.TwitterAccountDAO;
import com.edifixio.soc.dao.TwitterAccountHibernateDAO;
import com.edifixio.soc.dao.UserProfileDetailDAO;
import com.edifixio.soc.dao.UserProfileDetailHibernateDAO;
import com.edifixio.soc.persist.TwitterAccount;

public class UserProfileDAOTest extends TestCase {
    private static final Log log = LogFactory.getLog(UserProfileDAOTest.class);
    Random rand = new Random();

    public void testfindall() throws SVTException {
        List<TwitterAccount> tws = getTwitterAccountDAO().findall();
        for (TwitterAccount tw : tws) {
            log.debug("------------------------------------------");
            log.debug("getUserProfileDetailId: " + tw.getProfilePreference().getUserProfileDetail().getSubscriptionName());                        
        }
    }
    
    private UserProfileDetailDAO getUserProfileDetailDAO() {
        UserProfileDetailDAO dao = new UserProfileDetailHibernateDAO();
        return dao;
    }
    private TwitterAccountDAO getTwitterAccountDAO() {
        TwitterAccountDAO dao = new TwitterAccountHibernateDAO();
        return dao;
    }
    private String getUniqueString() {
        return (new Long((new Date()).getTime())) + "" + rand.nextInt();
    }

    public void xtestDate() {
        getCurrentDate(0);
        getCurrentDate(10);
        getCurrentDate(-5);
    }


    private String getCurrentDate(int days) {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, days);
        return DATE_FORMAT.format(c1.getTime());
    }
}
