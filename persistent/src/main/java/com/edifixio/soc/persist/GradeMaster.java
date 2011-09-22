// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="GradeMaster"
 */
public class GradeMaster  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String gradeId;
    private boolean performance; // is action or grade
    private int flameCount;
    private int starCount;
    private float percentValue;
    private String gradeValue;
    
    public String getGradeId() {
        return gradeId;
    }
    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }
    public boolean isPerformance() {
        return performance;
    }
    public void setPerformance(boolean performance) {
        this.performance = performance;
    }
    public int getFlameCount() {
        return flameCount;
    }
    public void setFlameCount(int flameCount) {
        this.flameCount = flameCount;
    }
    public int getStarCount() {
        return starCount;
    }
    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }
    public float getPercentValue() {
        return percentValue;
    }
    public void setPercentValue(float percentValue) {
        this.percentValue = percentValue;
    }
    public String getGradeValue() {
        return gradeValue;
    }
    public void setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
    }
}
