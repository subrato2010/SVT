package com.edifixio.soc.biz;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.InboundMetricsDummy;

public interface InboundDummyMgr {
    List<InboundMetricsDummy> findAll() throws SVTException;
    List<InboundMetricsDummy> getByProfileId(String profileId) throws SVTException;
    List<InboundMetricsDummy> getByProfileId(String profileId, String sortBy, String orderBy) throws SVTException;

}
