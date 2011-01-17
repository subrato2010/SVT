// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;
import java.util.Date;

/**
 * @hibernate.class table="StagingScore"
 */
public class StagingScore  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String stagingScoreId;
    private TwitterAccount twitterAccount;
    private Metrics metrics;
    private Date asOfDateFrom;
    private Date asOfDateTo;
    private boolean benchmarkYN;
    
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
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getStagingScoreId() {
        return stagingScoreId;
    }
    public void setStagingScoreId(String stagingScoreId) {
        this.stagingScoreId = stagingScoreId;
    }
    /**
     * @return Returns the TwitterAccount.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="twitterAccountId" not-null="true"
     */
    public TwitterAccount getTwitterAccount() {
        return twitterAccount;
    }
    public void setTwitterAccount(TwitterAccount twitterAccount) {
        this.twitterAccount = twitterAccount;
    }    

}
