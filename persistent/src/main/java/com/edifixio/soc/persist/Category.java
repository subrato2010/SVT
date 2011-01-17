// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="Category"
 */
public class Category  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String categoryId;
    private String categoryCode;
    private String categoryName;
    private String categoryDesc;
    private boolean activeStatus;
    private int displayOrder;
    private Channel channel;
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
     * @return Returns the channels.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="channelId" not-null="true"
     */
    public Channel getChannel() {
        return channel;
    }
    public void setChannel(Channel channel) {
        this.channel = channel;
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
    public String getCategoryCode() {
        return categoryCode;
    }
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
    /**
     * @hibernate.property length="1000"
     * 
     */
    public String getCategoryDesc() {
        return categoryDesc;
    }
    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
}
