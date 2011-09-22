package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.InboundMetricsDummy;

public interface InboundMetricsDummyDAO<T extends InboundMetricsDummy> {
    public List<T> findall()  throws SVTException;
    public List<T> getByProfileId(String profileId) throws SVTException;
    public List<T> getByProfileId(String profileId, String orderByColumn, String sortOrder) throws SVTException;
}
