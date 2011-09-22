// $Author: subratog $
package com.edifixio.soc.batch;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import twitter4j.TwitterException;

import com.edifixio.soc.biz.dto.MetricsDTO;
import com.edifixio.soc.common.SVTException;


public class TwitterMgrImpl extends TwitterMgrAssembler implements TwitterMgr{
   
    private final static Log log = LogFactory.getLog(TwitterMgrImpl.class);

    public String callTwitterAPI() throws SVTException, TwitterException {
        log.debug("TwitterMgrImpl.callTwitterAPI");

        // Looping through all metrics and call API accordingly        
        List<MetricsDTO> mdtos = getMetricsMgr().findAll();
        log.debug("Total metrics: " + mdtos.size());
        for(MetricsDTO mdto: mdtos){
            log.debug("mdto.getApiName(): " + mdto.getApiName());
            if(mdto != null && mdto.getApiName() != null){
                assembleForMetrics(mdto);
                //assembleMetricsData(mdto);
             }
        }
        return null;
    }
    
    private void assembleForMetrics(MetricsDTO mdto) throws TwitterException, SVTException {
        // Need to call and do logic based on what API you are calling
        int methodHandlerNumber = getMetricsHandlerNumber(mdto.getMetricId());
        if(methodHandlerNumber > 0){
            setRawScoreDTO(methodHandlerNumber, mdto);
        }
    }
    
    public void setMetrics1(int callerNumber,MetricsDTO mdto) throws TwitterException, SVTException{
        setCompletedBio(callerNumber,mdto); 
    }
    public void setMetrics2(int callerNumber,MetricsDTO mdto) throws TwitterException, SVTException{
        setBackgroundImage(callerNumber,mdto); 
    }
    public void setMetric4(int callerNumber,MetricsDTO mdto) throws TwitterException, SVTException{
        setProfileImage(callerNumber,mdto); 
    }
}
