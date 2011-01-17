// $Author: subratog $
package com.edifixio.soc.biz.dto;

import com.edifixio.soc.persist.Category;
import com.edifixio.soc.persist.Metrics;


public class MetricsDTO extends BaseDTO{
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
    private int lowerBound;
    private int upperBound;
    private String urlAPI1;
    private String urlAPI2;
    private String apiName;
    private Category category;
    private Metrics metrics;
    
    public Metrics getMetrics() {
        return metrics;
    }
    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }
    public boolean isActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    public boolean isAutomated() {
        return automated;
    }
    public void setAutomated(boolean automated) {
        this.automated = automated;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public int getDisplayOrder() {
        return displayOrder;
    }
    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
    public int getLowerBound() {
        return lowerBound;
    }
    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }
    public String getMetricCode() {
        return metricCode;
    }
    public void setMetricCode(String metricCode) {
        this.metricCode = metricCode;
    }
    public String getMetricDesc() {
        return metricDesc;
    }
    public void setMetricDesc(String metricDesc) {
        this.metricDesc = metricDesc;
    }
    public String getMetricId() {
        return metricId;
    }
    public void setMetricId(String metricId) {
        this.metricId = metricId;
    }
    public String getMetricName() {
        return metricName;
    }
    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }
    public String getMetricsType() {
        return metricsType;
    }
    public void setMetricsType(String metricsType) {
        this.metricsType = metricsType;
    }
    public double getNormalizedWt() {
        return normalizedWt;
    }
    public void setNormalizedWt(double normalizedWt) {
        this.normalizedWt = normalizedWt;
    }
    public double getRelativeWt() {
        return relativeWt;
    }
    public void setRelativeWt(double relativeWt) {
        this.relativeWt = relativeWt;
    }
    public int getUpperBound() {
        return upperBound;
    }
    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }
    public String getUrlAPI1() {
        return urlAPI1;
    }
    public void setUrlAPI1(String urlAPI1) {
        this.urlAPI1 = urlAPI1;
    }
    public String getUrlAPI2() {
        return urlAPI2;
    }
    public void setUrlAPI2(String urlAPI2) {
        this.urlAPI2 = urlAPI2;
    }
    public String getApiName() {
        return apiName;
    }
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    
 }
