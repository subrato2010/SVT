// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Channel;

public interface ChannelDAO<T extends Channel> {
    public List<T> findall()  throws SVTException;
    public List<T> findAllLightOnlyChannel() throws SVTException;
    public T addChannel(Channel channel)  throws SVTException;
    public T update(Channel channel) throws SVTException;
    public T getChannelById(String id) throws SVTException;
    public T getChannelByCode(String code) throws SVTException;
    public T getChannelByName(String name) throws SVTException;    
}
