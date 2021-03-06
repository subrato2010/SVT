// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.RawResult;

public class RawResultMgrImpl extends BaseBizObject implements RawResultMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(RawResultMgrImpl.class);
    
    public List<RawResult> findAll() throws SVTException {
        return getDaoProvider().getRawResultDAO().findall();
    }

    public List<RawResult> findByMetricId(String metricId) throws SVTException {
        return getDaoProvider().getRawResultDAO().findByMetricId(metricId);
    }

    public List<RawResult> findByMetricIdNOTSELF(String metricId) throws SVTException {
        return getDaoProvider().getRawResultDAO().findByMetricIdNOTSELF(metricId);
    }

    public List<RawResult> findByMetricIdSELF(String metricId) throws SVTException {
        return getDaoProvider().getRawResultDAO().findByMetricIdSELF(metricId);
    }

    public List<RawResult> findByProfileIdActionDate(String profileId, Date actionDate) throws SVTException {
        return getDaoProvider().getRawResultDAO().findByProfileIdActionDate(profileId, actionDate);
    }

    public List<RawResult> findByProfileIdActionDateNOTSELF(String profileId, Date actionDate) throws SVTException {
        return getDaoProvider().getRawResultDAO().findByProfileIdActionDateNOTSELF(profileId, actionDate);
    }

    public List<RawResult> findByProfileIdActionDateSELF(String profileId, Date actionDate) throws SVTException {
        return getDaoProvider().getRawResultDAO().findByProfileIdActionDateSELF(profileId, actionDate);
    }

    public List<RawResult> findByProfileIdMetricId(String profileId, String metricId) throws SVTException {
        return getDaoProvider().getRawResultDAO().findByProfileIdMetricId(profileId, metricId);
    }

    public List<RawResult> findByProfileIdMetricIdActionDate(String profileId, String metricId, Date actionDate) throws SVTException {
        return getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDate(profileId, metricId, actionDate);
    }

    public List<RawResult> findByProfileIdMetricIdActionDateNOTSELF(String profileId, String twitterAccountId, String metricId, Date actionDate) throws SVTException {
        return getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateNOTSELF(profileId, twitterAccountId, metricId, actionDate);
    }

    public List<RawResult> findByProfileIdMetricIdActionDateSELF(String profileId, String twitterAccountId, String metricId, Date actionDate) throws SVTException {
        return getDaoProvider().getRawResultDAO().findByProfileIdMetricIdActionDateSELF(profileId, twitterAccountId, metricId, actionDate);
    }

    public List<RawResult> findByProfileIdMetricIdNOTSELF(String profileId, String metricId) throws SVTException {
        return getDaoProvider().getRawResultDAO().findByProfileIdMetricIdNOTSELF(profileId, metricId);
    }

    public List<RawResult> findByProfileIdMetricIdSELF(String profileId, String metricId) throws SVTException {
        return getDaoProvider().getRawResultDAO().findByProfileIdMetricIdSELF(profileId, metricId);
    }

    public Date getMaxActionDate(String profileId) throws SVTException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        // Set time fields to zero  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);
        //SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return cal.getTime();        
        //return new Date(); getDaoProvider().getRawResultDAO().getMaxActionDate(profileId);
    }

    public Date getMinActionDate(String profileId) throws SVTException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
        //return getDaoProvider().getRawResultDAO().getMinActionDate(profileId);
    }
}
