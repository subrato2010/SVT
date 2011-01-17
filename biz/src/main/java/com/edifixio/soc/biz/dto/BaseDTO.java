// $Author: subratog $
package com.edifixio.soc.biz.dto;

import java.util.Date;
import com.edifixio.soc.biz.util.DTOHelper;

public class BaseDTO extends DTOHelper{
    
    private Date createdOn;
    private Date updatedOn;
    private String updatedBy;
    private String benchmarkId;
    
    public String getBenchmarkId() {
        return benchmarkId;
    }
    public void setBenchmarkId(String benchmarkId) {
        this.benchmarkId = benchmarkId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Date getUpdatedOn() {
        return updatedOn;
    }
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

}
