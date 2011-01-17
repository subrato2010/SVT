// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.dto.ChannelDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Channel;

public class ChannelMgrImpl extends BaseBizObject implements ChannelMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(ChannelMgrImpl.class);
    
    public List<ChannelDTO> findAllLight() throws SVTException {
        log.debug("Successful in connecting to Biz layer");
        return getChannelDTOList(getDaoProvider().getChannelDAO().findall(), false);
    }

    public List<ChannelDTO> findAllLightOnlyChannel() throws SVTException {
        return getChannelDTOList(getDaoProvider().getChannelDAO().findAllLightOnlyChannel(),false);
    }

    public ChannelDTO getChannelByName(String name) throws SVTException {
        log.debug("Successful in connecting to Biz layer");
         return getChannelDTO(getDaoProvider().getChannelDAO().getChannelByName(name), false);
    }

    public List<ChannelDTO> findAll() throws SVTException {
        // Using spring to get the dao mgr
        log.debug("Successful in connecting to Biz layer");
        return getChannelDTOList(getDaoProvider().getChannelDAO().findall(), true);
    }

 
    public boolean saveOrUpdate(ChannelDTO channelDTO) throws SVTException {
        // TODO Auto-generated method stub
        return false;
    }


    public boolean saveOrUpdates(List<ChannelDTO> channelList)
            throws SVTException {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * 
     * @param channelList
     * @param isDetail true means will return all the child data as well ( category, subcategory etc)
     * @return
     * @throws SVTException 
     */
    private List<ChannelDTO> getChannelDTOList(List<Channel> channelList, boolean isDetail) throws SVTException {
        List<ChannelDTO> channelDTOList = null;
         if (channelList != null && channelList.size() > 0) {
            channelDTOList = new ArrayList<ChannelDTO>();
            for (Channel channel : channelList) {
                channelDTOList.add(getChannelDTO(channel, isDetail));
            }
        }
        return channelDTOList;
    }

    private ChannelDTO getChannelDTO(Channel channel, boolean isDetail) {
        ChannelDTO channelDTO = null;
        if (channel != null) {
            channelDTO = getDTOFromChannel(channel, isDetail);
        }
        return channelDTO;
    }


    private ChannelDTO getDTOFromChannel(Channel channel, boolean isDetail) {
        ChannelDTO channelDTO = new ChannelDTO();
        channelDTO.setChannelCode(channel.getChannelCode());
        channelDTO.setChannelDesc(channel.getChannelDesc());
        channelDTO.setChannelName(channel.getChannelName());
        channelDTO.setDisplayOrder(channel.getDisplayOrder());
        channelDTO.setActiveStatus(channel.isActiveStatus());
        channelDTO.setChannelId(channel.getChannelId());
        if(isDetail == true){
            //TODO       
        }

        return channelDTO;
    }
}
