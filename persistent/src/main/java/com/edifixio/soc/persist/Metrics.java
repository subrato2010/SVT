// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="Metrics"
 */
public class Metrics  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String metricId;
    private String metricCode;
    private String metricName;
    private String metricDesc;
    private boolean activeStatus;
    private int displayOrder;
    private String metricsType;
    private boolean automated;
    private double relativeWt;
    private double normalizedWt;
    private double siWt;
    private double relativeSIWt;
    private double weight;
    private int lowerBound;
    private int upperBound;
    private String urlAPI1;
    private String urlAPI2;
    private String apiMethod;
    private String calcMethod;
    private Category category;
    private OverallCategory overallCategory;
    private String jspAlertToDisplay;
    private int jspAlertHeight;
    private int jspAlertWidth;
    private String jspAlertTitleBarText;
    private int calcLogic;
    private boolean goalPct;
    private double goalMetricWeight;
    private int goalPctCalcLogic;
    private int goalPctDisplayOrder;
    
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
    public boolean isAutomated() {
        return automated;
    }
    public void setAutomated(boolean automated) {
        this.automated = automated;
    }
    /**
     * @return Returns the category.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="categoryId" not-null="true"
     */
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     * @return Returns the category.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="overallCategoryId" not-null="true"
     */
    public OverallCategory getOverallCategory() {
        return overallCategory;
    }
    public void setOverallCategory(OverallCategory overallCategory) {
        this.overallCategory = overallCategory;
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
    public int getLowerBound() {
        return lowerBound;
    }
    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getMetricCode() {
        return metricCode;
    }
    public void setMetricCode(String metricCode) {
        this.metricCode = metricCode;
    }
    /**
     * @hibernate.property length="1000"
     * 
     */
    public String getMetricDesc() {
        return metricDesc;
    }
    public void setMetricDesc(String metricDesc) {
        this.metricDesc = metricDesc;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getMetricId() {
        return metricId;
    }
    public void setMetricId(String metricId) {
        this.metricId = metricId;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getMetricName() {
        return metricName;
    }
    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getMetricsType() {
        return metricsType;
    }
    public void setMetricsType(String metricsType) {
        this.metricsType = metricsType;
    }
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
    public int getUpperBound() {
        return upperBound;
    }
    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getUrlAPI1() {
        return urlAPI1;
    }
    public void setUrlAPI1(String urlAPI1) {
        this.urlAPI1 = urlAPI1;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getUrlAPI2() {
        return urlAPI2;
    }
    public void setUrlAPI2(String urlAPI2) {
        this.urlAPI2 = urlAPI2;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getApiMethod() {
        return apiMethod;
    }
    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getCalcMethod() {
        return calcMethod;
    }
    public void setCalcMethod(String calcMethod) {
        this.calcMethod = calcMethod;
    }
    public double getSiWt() {
        return siWt;
    }
    public void setSiWt(double siWt) {
        this.siWt = siWt;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getRelativeSIWt() {
        return relativeSIWt;
    }
    public void setRelativeSIWt(double relativeSIWt) {
        this.relativeSIWt = relativeSIWt;
    }
    public String getJspAlertToDisplay() {
        return jspAlertToDisplay;
    }
    public void setJspAlertToDisplay(String jspAlertToDisplay) {
        this.jspAlertToDisplay = jspAlertToDisplay;
    }
    public int getJspAlertHeight() {
        return jspAlertHeight;
    }
    public void setJspAlertHeight(int jspAlertHeight) {
        this.jspAlertHeight = jspAlertHeight;
    }
    public int getJspAlertWidth() {
        return jspAlertWidth;
    }
    public void setJspAlertWidth(int jspAlertWidth) {
        this.jspAlertWidth = jspAlertWidth;
    }
    public String getJspAlertTitleBarText() {
        return jspAlertTitleBarText;
    }
    public void setJspAlertTitleBarText(String jspAlertTitleBarText) {
        this.jspAlertTitleBarText = jspAlertTitleBarText;
    }
    public int getCalcLogic() {
        return calcLogic;
    }
    public void setCalcLogic(int calcLogic) {
        this.calcLogic = calcLogic;
    }
    public boolean isGoalPct() {
        return goalPct;
    }
    public void setGoalPct(boolean goalPct) {
        this.goalPct = goalPct;
    }
    public double getGoalMetricWeight() {
        return goalMetricWeight;
    }
    public void setGoalMetricWeight(double goalMetricWeight) {
        this.goalMetricWeight = goalMetricWeight;
    }
    public int getGoalPctCalcLogic() {
        return goalPctCalcLogic;
    }
    public void setGoalPctCalcLogic(int goalPctCalcLogic) {
        this.goalPctCalcLogic = goalPctCalcLogic;
    }
    public int getGoalPctDisplayOrder() {
        return goalPctDisplayOrder;
    }
    public void setGoalPctDisplayOrder(int goalPctDisplayOrder) {
        this.goalPctDisplayOrder = goalPctDisplayOrder;
    }
}
