// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.OverallPerformanceDummy;

public class OverallDummyMgrImpl extends BaseBizObject implements OverallDummyMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(OverallDummyMgrImpl.class);

    public List<OverallPerformanceDummy> findAll() throws SVTException {
        return getDaoProvider().getOverallPerformanceDummyDAO().findall();

    }

    public List<OverallPerformanceDummy> getByProfileId(String profileId) throws SVTException {
        return getDaoProvider().getOverallPerformanceDummyDAO().getByProfileId(profileId);
    }
}
