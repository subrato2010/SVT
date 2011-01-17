// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;
import java.util.Date;

public class RawResult  extends TrackedEntity implements Serializable {
    /**
     * SG: non-standard attribute, because of some reason....
     */
    private static final long serialVersionUID = 1L;
    private String resultSqId;
    private Metrics metric;
    private Date actionDate;    
    private TwitterAccount twitterAccount;
    private int state;
    private double rawScore;
    private int totalDataCount;
    private int validDataCount;
    public Date getActionDate() {
        return actionDate;
    }
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
    public Metrics getMetric() {
        return metric;
    }
    public void setMetric(Metrics metric) {
        this.metric = metric;
    }
    public double getRawScore() {
        return rawScore;
    }
    public void setRawScore(double rawScore) {
        this.rawScore = rawScore;
    }
    public String getResultSqId() {
        return resultSqId;
    }
    public void setResultSqId(String resultSqId) {
        this.resultSqId = resultSqId;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public int getTotalDataCount() {
        return totalDataCount;
    }
    public void setTotalDataCount(int totalDataCount) {
        this.totalDataCount = totalDataCount;
    }
    public TwitterAccount getTwitterAccount() {
        return twitterAccount;
    }
    public void setTwitterAccount(TwitterAccount twitterAccount) {
        this.twitterAccount = twitterAccount;
    }
    public int getValidDataCount() {
        return validDataCount;
    }
    public void setValidDataCount(int validDataCount) {
        this.validDataCount = validDataCount;
    }
    

}
