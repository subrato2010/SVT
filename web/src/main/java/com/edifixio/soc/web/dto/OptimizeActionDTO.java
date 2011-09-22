package com.edifixio.soc.web.dto;

import java.util.Date;

import com.edifixio.soc.biz.dto.AlertPopupDTO;

public class OptimizeActionDTO extends AlertPopupDTO{

    private int actionStarCount;
    private int actionFlameCount;
    private String label;
    private String imageTagScript;
    private String actionId;
    private Date asOfPerformanceDate;
    public int getActionStarCount() {
        return actionStarCount;
    }
    public void setActionStarCount(int actionStarCount) {
        this.actionStarCount = actionStarCount;
    }
    public int getActionFlameCount() {
        return actionFlameCount;
    }
    public void setActionFlameCount(int actionFlameCount) {
        this.actionFlameCount = actionFlameCount;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public String getActionId() {
        return actionId;
    }
    public void setActionId(String actionId) {
        this.actionId = actionId;
    }
    public Date getAsOfPerformanceDate() {
        return asOfPerformanceDate;
    }
    public void setAsOfPerformanceDate(Date asOfPerformanceDate) {
        this.asOfPerformanceDate = asOfPerformanceDate;
    }
    public String getImageTagScript() {
        return imageTagScript;
    }
    public void setImageTagScript(String imageTagScript) {
        this.imageTagScript = imageTagScript;
    }    
 }