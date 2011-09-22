package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.OverallPerformanceDummy;

public interface OverallPerformanceDummyDAO<T extends OverallPerformanceDummy> {
    public List<T> findall()  throws SVTException;
    public List<T> getByProfileId(String profileId) throws SVTException;
    public List<T> getByProfileIdTarget(String profileId, String target) throws SVTException;    
}
