// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;
import com.edifixio.soc.biz.dto.ChannelDTO;
import com.edifixio.soc.common.SVTException;

public interface ChannelMgr extends BaseMgr{
    public List<ChannelDTO> findAll() throws SVTException;
    public List<ChannelDTO> findAllLight() throws SVTException;
    public List<ChannelDTO> findAllLightOnlyChannel() throws SVTException;
    public ChannelDTO getChannelByName(String name) throws SVTException;  
}
