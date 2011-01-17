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
import com.edifixio.soc.dao.StagingScoreDAO;
import com.edifixio.soc.dao.StagingScoreHibernateDAO;
import com.edifixio.soc.persist.StagingScore;

public class StagingScoreDAOTest extends TestCase {
    private static final Log log = LogFactory.getLog(StagingScoreDAOTest.class);
    Random rand = new Random();

    public void testStagingScoreFindAll() throws SVTException {
        List<StagingScore> stagingScores = getStagingScoreDAO().findall();
        for (StagingScore stagingScore : stagingScores) {
            log.debug("------------------------------------------");
            log.debug("StagingScoreId: " + stagingScore.getStagingScoreId());                        
        }
    }
    
    private StagingScoreDAO getStagingScoreDAO() {
        StagingScoreDAO stagingScoreDAO = new StagingScoreHibernateDAO();
        return stagingScoreDAO;
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
