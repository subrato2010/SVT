// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.Date;
import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.RawResult;

public interface RawResultMgr extends BaseMgr{
    public List<RawResult> findAll() throws SVTException;
    
    public List<RawResult> findByMetricId(String metricId) throws SVTException;
    public List<RawResult> findByProfileIdMetricId(String profileId, String metricId) throws SVTException;
    public List<RawResult> findByProfileIdMetricIdActionDate(String profileId, String metricId, Date actionDate) throws SVTException;
    public List<RawResult> findByProfileIdActionDate(String profileId, Date actionDate) throws SVTException;
    
    public List<RawResult> findByMetricIdSELF(String metricId) throws SVTException;
    public List<RawResult> findByProfileIdMetricIdSELF(String profileId, String metricId) throws SVTException;
    public List<RawResult> findByProfileIdMetricIdActionDateSELF(String profileId, String metricId, Date actionDate) throws SVTException;
    public List<RawResult> findByProfileIdActionDateSELF(String profileId, Date actionDate) throws SVTException;
    
    public List<RawResult> findByMetricIdNOTSELF(String metricId) throws SVTException;
    public List<RawResult> findByProfileIdMetricIdNOTSELF(String profileId, String metricId) throws SVTException;
    public List<RawResult> findByProfileIdMetricIdActionDateNOTSELF(String profileId, String metricId, Date actionDate) throws SVTException;
    public List<RawResult> findByProfileIdActionDateNOTSELF(String profileId, Date actionDate) throws SVTException;

}
