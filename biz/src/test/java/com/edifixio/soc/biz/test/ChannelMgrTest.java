// $Author: subratog $
package com.edifixio.soc.biz.test;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.dto.ChannelDTO;
import com.edifixio.soc.biz.util.BizTestCase;
import com.edifixio.soc.common.SVTException;


public class ChannelMgrTest extends BizTestCase {
    private final static Log log = LogFactory.getLog(ChannelMgrTest.class);


    public void testChannelFindAll() throws SVTException {
        log.debug("ChannelMgrTest.testChannelFindAll");
        List<ChannelDTO> dtos = getChannelMgr().findAll();
        for (ChannelDTO dto : dtos) {
            log.debug("Channel Code: " + dto.getChannelCode());
        }
    }
 }
