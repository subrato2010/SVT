// $Author: subratog $
package com.edifixio.soc.biz.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import twitter4j.TwitterException;
import com.edifixio.soc.biz.util.BizTestCase;
import com.edifixio.soc.common.SVTException;


public class TwitterMgrTest extends BizTestCase {
    private final static Log log = LogFactory.getLog(TwitterMgrTest.class);

    public void testProcessTwitterData() throws SVTException, TwitterException {
        log.debug("TwitterMgrTest.testProcessTwitterData");
        
        getTwitterMgr().callTwitterAPI();
//        Twitter twitter = new TwitterFactory().getInstance();        
//        Paging paging = new Paging();
//        paging.setCount(500);
//        ResponseList<Status> st = twitter.getUserTimeline("JasonFalls",paging);
//        log.debug(":::::::::::::::::::::::::::::" + st.size());
    }
 }
