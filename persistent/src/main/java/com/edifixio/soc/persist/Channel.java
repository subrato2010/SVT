// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="Channel"
 */
public class Channel  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String channelId;
    private String channelCode;
    private String channelName;
    private String channelDesc;
    private boolean activeStatus;
    private boolean channel;
    private int displayOrder;
    private double relativeWt;
    private double normalizedWt;
   
    /**
     * @hibernate.property
     * 
     */
     public double getNormalizedWt() {
        return normalizedWt;
    }
    public void setNormalizedWt(double normalizedWt) {
        this.normalizedWt = normalizedWt;
    }
    /**
     * @hibernate.property
     * 
     */
    public double getRelativeWt() {
        return relativeWt;
    }
    public void setRelativeWt(double relativeWt) {
        this.relativeWt = relativeWt;
    }
    /**
     * @hibernate.property
     * 
     */
    public boolean isActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getChannelCode() {
        return channelCode;
    }
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }
    /**
     * @hibernate.property length="1000"
     * 
     */
    public String getChannelDesc() {
        return channelDesc;
    }
    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getChannelId() {
        return channelId;
    }
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getChannelName() {
        return channelName;
    }
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
    /**
     * @hibernate.property
     * 
     */
    public int getDisplayOrder() {
        return displayOrder;
    }
    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
    /**
     * @hibernate.property
     * 
     */
    public boolean isChannel() {
        return channel;
    }
    public void setChannel(boolean channel) {
        this.channel = channel;
    }

}
