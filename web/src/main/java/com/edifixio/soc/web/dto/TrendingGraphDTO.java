package com.edifixio.soc.web.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TrendingGraphDTO {

    private Date asOfPerformanceDate;
    private String mode;
    private boolean self;
    private String strAsOfPerformanceDate;
    
    private TrendingGraphDetailDTO gradeDetail;
    public Date getAsOfPerformanceDate() {
        return asOfPerformanceDate;
    }
    public void setAsOfPerformanceDate(Date asOfPerformanceDate) {
        this.asOfPerformanceDate = asOfPerformanceDate;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public boolean isSelf() {
        return self;
    }
    public void setSelf(boolean self) {
        this.self = self;
    }
    public TrendingGraphDetailDTO getGradeDetail() {
        return gradeDetail;
    }
    public void setGradeDetail(TrendingGraphDetailDTO gradeDetail) {
        this.gradeDetail = gradeDetail;
    }
    
    public String getStrAsOfPerformanceDate() {
        
        Date perfDate = this.asOfPerformanceDate;
        this.strAsOfPerformanceDate = new SimpleDateFormat("MM/dd/yyyy").format(perfDate);
        return strAsOfPerformanceDate;
    }
    
    public void setStrAsOfPerformanceDate(String strAsOfPerformanceDate) {
        this.strAsOfPerformanceDate = strAsOfPerformanceDate;
    }
    


}