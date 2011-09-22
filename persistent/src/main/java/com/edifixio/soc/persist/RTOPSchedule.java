// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;
import java.util.Date;

/**
 * @hibernate.class table="RTOPSchedule"
 */
public class RTOPSchedule  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String rtopScheduleId;
    private TwitterAccount twitterAccount;
    private String tweetMessage;
    private Date scheduleDateTime;
    private String scheduleType; // M/A: M=manual, A=Auto
    private int status; //1=success, 2=failed, 0=scheduled, 3=remove
    private String statusMessage; // store exception message if any
    private String grade;
    public String getRtopScheduleId() {
        return rtopScheduleId;
    }
    public void setRtopScheduleId(String rtopScheduleId) {
        this.rtopScheduleId = rtopScheduleId;
    }
    public TwitterAccount getTwitterAccount() {
        return twitterAccount;
    }
    public void setTwitterAccount(TwitterAccount twitterAccount) {
        this.twitterAccount = twitterAccount;
    }
    public String getTweetMessage() {
        return tweetMessage;
    }
    public void setTweetMessage(String tweetMessage) {
        this.tweetMessage = tweetMessage;
    }
    public Date getScheduleDateTime() {
        return scheduleDateTime;
    }
    public void setScheduleDateTime(Date scheduleDateTime) {
        this.scheduleDateTime = scheduleDateTime;
    }
    public String getScheduleType() {
        return scheduleType;
    }
    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getStatusMessage() {
        return statusMessage;
    }
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

}
