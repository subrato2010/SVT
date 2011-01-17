// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;
import com.edifixio.soc.biz.dto.MetricsDTO;
import com.edifixio.soc.common.SVTException;

public interface MetricsMgr extends BaseMgr{
    public List<MetricsDTO> findAll() throws SVTException;
    public List<MetricsDTO> findByNameCategoryIdChannelId(String name,String categoryId, String channelId) throws SVTException;
    public List<MetricsDTO> findCategoryByChannelIdInbound(String channelId) throws SVTException;
    public List<MetricsDTO> findCategoryByChannelIdOutbound(String channelId) throws SVTException;    

    public MetricsDTO add(MetricsDTO dto) throws SVTException;
    public MetricsDTO getById(String id) throws SVTException;
}
