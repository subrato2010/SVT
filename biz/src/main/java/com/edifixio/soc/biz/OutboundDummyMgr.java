package com.edifixio.soc.biz;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.OutboundMetricsDummy;

public interface OutboundDummyMgr {
    List<OutboundMetricsDummy> findAll() throws SVTException;
    List<OutboundMetricsDummy> getByProfileId(String profileId) throws SVTException;
    List<OutboundMetricsDummy> getByProfileId(String profileId, String sortBy, String orderBy) throws SVTException;
}
