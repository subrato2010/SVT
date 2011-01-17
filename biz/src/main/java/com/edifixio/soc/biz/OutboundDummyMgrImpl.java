// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.OutboundMetricsDummy;

public class OutboundDummyMgrImpl extends BaseBizObject implements OutboundDummyMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(OutboundDummyMgrImpl.class);

    public List<OutboundMetricsDummy> findAll() throws SVTException {
        return getDaoProvider().getOutboundMetricsDummyDAO().findall();
    }

    public List<OutboundMetricsDummy> getByProfileId(String profileId) throws SVTException {
        return getDaoProvider().getOutboundMetricsDummyDAO().getByProfileId(profileId);
    }
    public List<OutboundMetricsDummy> getByProfileId(String profileId, String sortBy, String orderBy) throws SVTException {
        if(sortBy != null && sortBy.equalsIgnoreCase("cv")){
            return getDaoProvider().getOutboundMetricsDummyDAO().getByProfileId(profileId,"cmptVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yv")){
            return getDaoProvider().getOutboundMetricsDummyDAO().getByProfileId(profileId,"custVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yt")){
            return getDaoProvider().getOutboundMetricsDummyDAO().getByProfileId(profileId,"custTarget", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("pi")){
            return getDaoProvider().getOutboundMetricsDummyDAO().getByProfileId(profileId,"percentIncrease", orderBy);
        }
        return getDaoProvider().getOutboundMetricsDummyDAO().getByProfileId(profileId);


    }

}
