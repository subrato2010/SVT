// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="TrendingGrade"
 */
public class TrendingGrade  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String gradeId;
    private boolean activeStatus;
    private float fromPctValue;
    private float toPctValue;
    private String gradeValue;
    public String getGradeId() {
        return gradeId;
    }
    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }
    public boolean isActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    public float getFromPctValue() {
        return fromPctValue;
    }
    public void setFromPctValue(float fromPctValue) {
        this.fromPctValue = fromPctValue;
    }
    public float getToPctValue() {
        return toPctValue;
    }
    public void setToPctValue(float toPctValue) {
        this.toPctValue = toPctValue;
    }
    public String getGradeValue() {
        return gradeValue;
    }
    public void setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
    }
}
