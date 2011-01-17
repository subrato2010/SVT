// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;
import java.util.Date;

/**
 * @hibernate.class table="Score"
 */
public class Score  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String scoreId;
    
    private ProfilePreference profilePreference;
    private Metrics metrics;    
    private Date asOfDateFrom;
    private Date asOfDateTo;
    private boolean benchmarkYN;
    private boolean self;
    private double score;
    private Company company;
    
    /**
     * @return Returns the Company.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="companyId" not-null="true"
     */
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    /**
     * @hibernate.property
     * 
     */
    public Date getAsOfDateFrom() {
        return asOfDateFrom;
    }
    public void setAsOfDateFrom(Date asOfDateFrom) {
        this.asOfDateFrom = asOfDateFrom;
    }
    /**
     * @hibernate.property
     * 
     */
    public Date getAsOfDateTo() {
        return asOfDateTo;
    }
    public void setAsOfDateTo(Date asOfDateTo) {
        this.asOfDateTo = asOfDateTo;
    }
    /**
     * @hibernate.property
     * 
     */
    public boolean isBenchmarkYN() {
        return benchmarkYN;
    }
    public void setBenchmarkYN(boolean benchmarkYN) {
        this.benchmarkYN = benchmarkYN;
    }
    /**
     * @return Returns the Metrics.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="metricId" not-null="true"
     */
    public Metrics getMetrics() {
        return metrics;
    }
    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }
    /**
     * @return Returns the ProfilePreference.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="profilePreferenceId" not-null="true"
     */
    public ProfilePreference getProfilePreference() {
        return profilePreference;
    }
    public void setProfilePreference(ProfilePreference profilePreference) {
        this.profilePreference = profilePreference;
    }
    /**
     * @hibernate.property
     * 
     */
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getScoreId() {
        return scoreId;
    }
    public void setScoreId(String scoreId) {
        this.scoreId = scoreId;
    }
    /**
     * @hibernate.property
     * 
     */
    public boolean isSelf() {
        return self;
    }
    public void setSelf(boolean self) {
        this.self = self;
    }

    
   

}
