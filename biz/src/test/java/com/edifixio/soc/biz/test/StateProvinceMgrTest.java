// $Author: subratog $
package com.edifixio.soc.biz.test;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.dto.StateProvinceDTO;
import com.edifixio.soc.biz.util.BizTestCase;
import com.edifixio.soc.common.SVTException;


public class StateProvinceMgrTest extends BizTestCase {
    private final static Log log = LogFactory.getLog(StateProvinceMgrTest.class);


    public void testFindAll() throws SVTException {
         List<StateProvinceDTO> dtos = getStateProvinceMgr().findAll();
        for (StateProvinceDTO dto : dtos) {
            log.debug("name: " + dto.getName());
        }
    }
 }
