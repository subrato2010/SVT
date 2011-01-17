// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.Date;
import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.RawResult;

public interface RawResultDAO<T extends RawResult> {
    public List<T> findall()  throws SVTException;    
    public List<T> findByMetricId(String metricId) throws SVTException;
    public List<T> findByProfileIdMetricId(String profileId, String metricId) throws SVTException;
    public List<T> findByProfileIdMetricIdActionDate(String profileId, String metricId, Date actionDate) throws SVTException;
    public List<T> findByProfileIdActionDate(String profileId, Date actionDate) throws SVTException;
    
    public List<T> findByMetricIdSELF(String metricId) throws SVTException;
    public List<T> findByProfileIdMetricIdSELF(String profileId, String metricId) throws SVTException;
    public List<T> findByProfileIdMetricIdActionDateSELF(String profileId, String metricId, Date actionDate) throws SVTException;
    public List<T> findByProfileIdActionDateSELF(String profileId, Date actionDate) throws SVTException;
    
    public List<T> findByMetricIdNOTSELF(String metricId) throws SVTException;
    public List<T> findByProfileIdMetricIdNOTSELF(String profileId, String metricId) throws SVTException;
    public List<T> findByProfileIdMetricIdActionDateNOTSELF(String profileId, String metricId, Date actionDate) throws SVTException;
    public List<T> findByProfileIdActionDateNOTSELF(String profileId, Date actionDate) throws SVTException;
    
}
