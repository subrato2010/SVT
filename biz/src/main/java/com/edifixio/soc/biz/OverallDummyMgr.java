package com.edifixio.soc.biz;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.OverallPerformanceDummy;

public interface OverallDummyMgr {
    List<OverallPerformanceDummy> findAll() throws SVTException;
    List<OverallPerformanceDummy> getByProfileId(String profileId) throws SVTException;
}
