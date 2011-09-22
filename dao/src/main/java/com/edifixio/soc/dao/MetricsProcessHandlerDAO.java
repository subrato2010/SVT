// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.MetricsProcessHandler;

public interface MetricsProcessHandlerDAO<T extends MetricsProcessHandler> {
    public List<T> findall()  throws SVTException;
    public MetricsProcessHandler getByMetricsId(String metricId)  throws SVTException;
    
}
