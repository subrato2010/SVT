// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;
import java.util.Date;

/**
 * @hibernate.class table="Benchmark"
 */
public class Benchmark  extends TrackedEntity implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String benchmarkId;
    private String benchmarkCode;
    private String benchmarkName;
    private Date benchmarkStDate;
    private Date benchmarkEdDate;    
    private boolean activeStatus;
    private boolean defaultBenchmark;
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
    public String getBenchmarkCode() {
        return benchmarkCode;
    }
    public void setBenchmarkCode(String benchmarkCode) {
        this.benchmarkCode = benchmarkCode;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getBenchmarkId() {
        return benchmarkId;
    }
    public void setBenchmarkId(String benchmarkId) {
        this.benchmarkId = benchmarkId;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getBenchmarkName() {
        return benchmarkName;
    }
    public void setBenchmarkName(String benchmarkName) {
        this.benchmarkName = benchmarkName;
    }
    /**
     * @hibernate.property
     * 
     */
    public Date getBenchmarkEdDate() {
        return benchmarkEdDate;
    }
    public void setBenchmarkEdDate(Date benchmarkEdDate) {
        this.benchmarkEdDate = benchmarkEdDate;
    }
    /**
     * @hibernate.property
     * 
     */
    public Date getBenchmarkStDate() {
        return benchmarkStDate;
    }
    public void setBenchmarkStDate(Date benchmarkStDate) {
        this.benchmarkStDate = benchmarkStDate;
    }
    /**
     * @hibernate.property
     * 
     */
    public boolean isDefaultBenchmark() {
        return defaultBenchmark;
    }
    public void setDefaultBenchmark(boolean defaultBenchmark) {
        this.defaultBenchmark = defaultBenchmark;
    }

}
