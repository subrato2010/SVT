// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="OverallCategory"
 */
public class OverallCategory  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String overallCategoryId;
    private String code;
    private String name;
    private String overallCategoryDesc;
    private boolean activeStatus;
    private int displayOrder;
    private double outboundWt;
    private double inboundWt;
    public String getOverallCategoryId() {
        return overallCategoryId;
    }
    public void setOverallCategoryId(String overallCategoryId) {
        this.overallCategoryId = overallCategoryId;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOverallCategoryDesc() {
        return overallCategoryDesc;
    }
    public void setOverallCategoryDesc(String overallCategoryDesc) {
        this.overallCategoryDesc = overallCategoryDesc;
    }
    public boolean isActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    public int getDisplayOrder() {
        return displayOrder;
    }
    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
    public double getOutboundWt() {
        return outboundWt;
    }
    public void setOutboundWt(double outboundWt) {
        this.outboundWt = outboundWt;
    }
    public double getInboundWt() {
        return inboundWt;
    }
    public void setInboundWt(double inboundWt) {
        this.inboundWt = inboundWt;
    }
 
}
