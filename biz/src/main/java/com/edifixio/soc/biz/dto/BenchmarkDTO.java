package com.edifixio.soc.biz.dto;

import java.util.Date;

public class BenchmarkDTO extends BaseDTO{
    private String benchMarkId;
    private String benchMarkCode;
    private String benchMarkName;
    private Date benchmarkStDate;
    private Date benchmarkEdDate;    
    private boolean activeStatus;
    public boolean isActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    public String getBenchMarkCode() {
        return benchMarkCode;
    }
    public void setBenchMarkCode(String benchMarkCode) {
        this.benchMarkCode = benchMarkCode;
    }
    public Date getBenchmarkEdDate() {
        return benchmarkEdDate;
    }
    public void setBenchmarkEdDate(Date benchmarkEdDate) {
        this.benchmarkEdDate = benchmarkEdDate;
    }
    public String getBenchMarkId() {
        return benchMarkId;
    }
    public void setBenchMarkId(String benchMarkId) {
        this.benchMarkId = benchMarkId;
    }
    public String getBenchMarkName() {
        return benchMarkName;
    }
    public void setBenchMarkName(String benchMarkName) {
        this.benchMarkName = benchMarkName;
    }
    public Date getBenchmarkStDate() {
        return benchmarkStDate;
    }
    public void setBenchmarkStDate(Date benchmarkStDate) {
        this.benchmarkStDate = benchmarkStDate;
    }
    
}
