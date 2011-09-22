// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;
import java.util.Date;

/**
 * @hibernate.class table="TwitLog"
 */
public class TwitLog  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String twitLogId;
    private Long twittStatusId;
    //private String tweetMessage;
    private boolean retweet;
    private boolean reply;
    private boolean sendTweet;
    private Date actionTakenOn;
    private String toWhom;
    //private String fromWhom;
    private TwitterAccount twitterAccount;
    
    public Long getTwittStatusId() {
        return twittStatusId;
    }
    public void setTwittStatusId(Long twittStatusId) {
        this.twittStatusId = twittStatusId;
    }
//    public String getTweetMessage() {
//        return tweetMessage;
//    }
//    public void setTweetMessage(String tweetMessage) {
//        this.tweetMessage = tweetMessage;
//    }
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
//    public String getFromWhom() {
//        return fromWhom;
//    }
//    public void setFromWhom(String fromWhom) {
//        this.fromWhom = fromWhom;
//    }
    public String getTwitLogId() {
        return twitLogId;
    }
    public void setTwitLogId(String twitLogId) {
        this.twitLogId = twitLogId;
    }
    public TwitterAccount getTwitterAccount() {
        return twitterAccount;
    }
    public void setTwitterAccount(TwitterAccount twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

 }
