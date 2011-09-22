// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Metrics;


public interface MetricsDAO<T extends Metrics> {
    public List<T> findall() throws SVTException;
    public T getByName(String name) throws SVTException;
    public T getById(String id) throws SVTException;
    public List<T> findByNameCategoryIdChannelId(String name,String categoryId, String channelId) throws SVTException;
    public List<T> findCategoryByChannelIdInbound(String channelId) throws SVTException;
    public List<T> findCategoryByChannelIdOutbound(String channelId) throws SVTException;    
    public List<T> findByCategoryId(String categoryId) throws SVTException;
    public List<T> findByGoalPct(String channelId) throws SVTException;
    
    public T addMetrics(Metrics metrics) throws SVTException;
    public T saveOrUpdate(Metrics metrics) throws SVTException;    
}
