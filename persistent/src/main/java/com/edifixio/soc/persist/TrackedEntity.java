// $Author: subratog $
package com.edifixio.soc.persist;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public abstract class TrackedEntity {
    private Date updatedOn;
    private String updatedBy;
    private Benchmark benchmark;
    public static final TimeZone utc = TimeZone.getTimeZone("UTC");
    
    public TrackedEntity()
    {
    }
    public TrackedEntity(String user)
    {
       this(user, true);
    }
    private TrackedEntity(String user, boolean setUuid)
    {
       Calendar now = new GregorianCalendar(utc);
       setUpdatedBy(user);
       setUpdatedOn(now.getTime());       
    }
    
    /**
     * @hibernate.property 
     * 
     */
    public Date getUpdatedOn() {
        return updatedOn;
    }
    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
    /**
     * @hibernate.property unsaved-value="subrato"
     * 
     */
    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    
    /**
     * @return Returns the benchmark.
     * @hibernate.many-to-one cascade="none" update="false" insert="true"
     * @hibernate.column name="benchMarkId" not-null="false"
     */
    public Benchmark getBenchmark() {
        return benchmark;
    }
    public void setBenchmark(Benchmark benchmark) {
        this.benchmark = benchmark;
    }
}
