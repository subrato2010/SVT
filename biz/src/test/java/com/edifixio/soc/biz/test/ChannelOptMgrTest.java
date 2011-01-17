// $Author: subratog $
package com.edifixio.soc.biz.test;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.util.BizTestCase;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.OverallPerformanceDummy;

public class ChannelOptMgrTest extends BizTestCase {
    private final static Log log = LogFactory.getLog(ChannelOptMgrTest.class);

    public void testFindAll() throws SVTException {
        log.debug("ChannelOptMgrTest.testFindAll");
        List<OverallPerformanceDummy> dtos = getOverallDummyMgr().findAll();
        for (OverallPerformanceDummy dto : dtos) {
            log.debug("=========================================================");
            log.debug("getDemographicsGrade   : "+ dto.getDemographicsGrade());
            log.debug("getProfileId           : "+ dto.getProfileId());
        }
    }
}
