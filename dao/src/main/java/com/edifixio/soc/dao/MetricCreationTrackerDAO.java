// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.Date;
import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.MetricCreationTracker;

public interface MetricCreationTrackerDAO<T extends MetricCreationTracker> {
    public List<T> findall()  throws SVTException;    
    public Date getMaxActionDate(List<String> twitterUsername) throws SVTException;
    public Date getMinActionDate(List<String> twitterUsername) throws SVTException;

    public Date getMaxActionDateByUser(String twitterUsername) throws SVTException;
    public Date getMinActionDateByUser(String twitterUsername) throws SVTException;
}
