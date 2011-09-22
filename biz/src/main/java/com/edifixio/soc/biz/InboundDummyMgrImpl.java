// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.InboundMetricsDummy;

public class InboundDummyMgrImpl extends BaseBizObject implements InboundDummyMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(InboundDummyMgrImpl.class);

    public List<InboundMetricsDummy> findAll() throws SVTException {
        return getDaoProvider().getInboundMetricsDummyDAO().findall();
    }

    public List<InboundMetricsDummy> getByProfileId(String profileId) throws SVTException {
        return getDaoProvider().getInboundMetricsDummyDAO().getByProfileId(profileId);
    }
    public List<InboundMetricsDummy> getByProfileId(String profileId, String sortBy, String orderBy) throws SVTException {
        if(sortBy != null && sortBy.equalsIgnoreCase("cv")){
            return getDaoProvider().getInboundMetricsDummyDAO().getByProfileId(profileId,"cmptVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yv")){
            return getDaoProvider().getInboundMetricsDummyDAO().getByProfileId(profileId,"custVolume", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("yt")){
            return getDaoProvider().getInboundMetricsDummyDAO().getByProfileId(profileId,"custTarget", orderBy);
        }else if(sortBy != null && sortBy.equalsIgnoreCase("pi")){
            return getDaoProvider().getInboundMetricsDummyDAO().getByProfileId(profileId,"percentIncrease", orderBy);
        }
        return getDaoProvider().getInboundMetricsDummyDAO().getByProfileId(profileId);

    }

}
