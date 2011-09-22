// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.dto.MetricsDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Metrics;

public class MetricsMgrImpl extends BaseBizObject implements MetricsMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(MetricsMgrImpl.class);

    public List<MetricsDTO> findAll() throws SVTException {
        // Using spring to get the dao mgr
        log.debug("Successful in connecting to Biz layer");
        return getMetricsDTOList(getDaoProvider().getMetricsDAO().findall());
    }   

    public List<MetricsDTO> findByNameCategoryIdChannelId(String name, String categoryId, String channelId) throws SVTException {
        return getMetricsDTOList(getDaoProvider().getMetricsDAO().findByNameCategoryIdChannelId(name, categoryId, channelId));
    }

    public List<MetricsDTO> findCategoryByChannelIdInbound(String channelId) throws SVTException {
        return getMetricsDTOList(getDaoProvider().getMetricsDAO().findCategoryByChannelIdInbound(channelId));
    }

    public List<MetricsDTO> findCategoryByChannelIdOutbound(String channelId) throws SVTException {
        return getMetricsDTOList(getDaoProvider().getMetricsDAO().findCategoryByChannelIdOutbound(channelId));
    }
    
    public MetricsDTO getById(String id) throws SVTException {
        return getMetricsDTO(getDaoProvider().getMetricsDAO().getById(id));
    }  

    public MetricsDTO add(MetricsDTO dto) throws SVTException {
        // TODO Auto-generated method stub
        return null;
    }

    private List<MetricsDTO> getMetricsDTOList(List<Metrics> mdtos) {
        
        List<MetricsDTO> dtos = new ArrayList<MetricsDTO>();
        
        for(Metrics mdto: mdtos){
            dtos.add(getMetricsDTO(mdto));
        }
        return dtos;
    }
    private MetricsDTO getMetricsDTO(Metrics mdto) {
        MetricsDTO dto = new MetricsDTO();
        quietlyCopyProperties(dto, mdto);
//        dto.setMetricCode(mdto.getMetricCode());
//        dto.setMetricId(mdto.getMetricId());
//        dto.setMetricName(mdto.getMetricName()); 
//        dto.setUrlAPI1(mdto.getUrlAPI1());
//        dto.setApiName(mdto.getApiMethod());
//        dto.setMetrics(mdto);
        return dto;
    }

}
