// $Author: subratog $
package com.edifixio.soc.biz.dto;

import org.apache.commons.lang.StringEscapeUtils;

public class ChannelDTO extends BaseDTO{
    
    private String channelId;
    private String channelCode;
    private String channelName;
    private String channelDesc;
    private boolean activeStatus;
    private boolean channel;
    private int displayOrder;

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public boolean isChannel() {
        return channel;
    }

    public void setChannel(boolean channel) {
        this.channel = channel;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getChannelDesc() {
        return channelDesc;
    }

    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getChannelNameEscaped() {
        if( channelName == null){
            return channelName;
        }else{
            //TODO this is non-standard code, please use other way to resolve this.
            return StringEscapeUtils.escapeHtml(channelName).replaceAll("&amp;", "%26");
        }
        
    }
}
