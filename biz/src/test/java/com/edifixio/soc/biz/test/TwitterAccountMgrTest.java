// $Author: subratog $
package com.edifixio.soc.biz.test;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import twitter4j.TwitterException;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.util.BizTestCase;
import com.edifixio.soc.common.SVTException;


public class TwitterAccountMgrTest extends BizTestCase {
    private final static Log log = LogFactory.getLog(TwitterAccountMgrTest.class);

    public void testProfileSelf() throws SVTException, TwitterException {
        log.debug("TwitterAccountMgrTest.testProfileSelf");
        display(getTwitterAccountMgr().getByProfilePreferenceIdSELF("1"));
    }

    private void display(List<TwitterAccountDTO> byProfilePreferenceIdSELF) {
        for(TwitterAccountDTO dto: byProfilePreferenceIdSELF){
           log.debug("Name: " + dto.getTwitterUsername());
        }
        
    }
 }
