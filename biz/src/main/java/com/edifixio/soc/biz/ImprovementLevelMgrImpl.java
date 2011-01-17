// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ImprovementLevel;

public class ImprovementLevelMgrImpl extends BaseBizObject implements ImprovementLevelMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(ImprovementLevelMgrImpl.class);
    
    public List<ImprovementLevel> findAll() throws SVTException {
        return getDaoProvider().getImprovementLevelDAO().findall();
    }

}
