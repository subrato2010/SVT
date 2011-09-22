package com.edifixio.soc.web.dto;

import java.util.Date;

import com.edifixio.soc.dao.TwitLogDAO;
import com.edifixio.soc.dao.TwitLogHibernateDAO;
import com.edifixio.soc.persist.TwitLog;

public class FilterTwitterDataDTO {
    private long twittStatusID;
    private String tweetMessage;
    private boolean retweet, reply, sendTweet;
    private Date actionTakenOn;
    private String toWhom;
    private String from;
    private String twitterUsername;
    private String loginProfileId; // profilePreferenceUsername
    
    public long getTwittStatusID() {
        return twittStatusID;
    }
    public void setTwittStatusID(long twittStatusID) {
        this.twittStatusID = twittStatusID;
    }
    public String getTweetMessage() {
        return tweetMessage;
    }
    public void setTweetMessage(String tweetMessage) {
        this.tweetMessage = tweetMessage;
    }
    public boolean isRetweet() {
        return retweet;
    }
    public void setRetweet(boolean retweet) {
        this.retweet = retweet;
    }
    public boolean isReply() {
        return reply;
    }
    public void setReply(boolean reply) {
        this.reply = reply;
    }
    public boolean isSendTweet() {
        return sendTweet;
    }
    public void setSendTweet(boolean sendTweet) {
        this.sendTweet = sendTweet;
    }
    public Date getActionTakenOn() {
        return actionTakenOn;
    }
    public void setActionTakenOn(Date actionTakenOn) {
        this.actionTakenOn = actionTakenOn;
    }
    public String getToWhom() {
        return toWhom;
    }
    public void setToWhom(String toWhom) {
        this.toWhom = toWhom;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public TwitLogDAO<TwitLog> getTwittLogDAOInstance() {
        return new TwitLogHibernateDAO<TwitLog>();
    }
    public String getTwitterUsername() {
        return twitterUsername;
    }
    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }
    public String getLoginProfileId() {
        return loginProfileId;
    }
    public void setLoginProfileId(String loginProfileId) {
        this.loginProfileId = loginProfileId;
    }
}
