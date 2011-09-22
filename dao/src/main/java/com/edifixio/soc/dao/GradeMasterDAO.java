// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.GradeMaster;

public interface GradeMasterDAO<T extends GradeMaster> {
    public List<T> findall()  throws SVTException;   
    public List<T> findPerformanceTrue() throws SVTException;
    public List<T> findPerformanceFalse() throws SVTException;
}
