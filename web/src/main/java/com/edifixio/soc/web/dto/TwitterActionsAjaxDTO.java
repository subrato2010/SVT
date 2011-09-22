package com.edifixio.soc.web.dto;

public class TwitterActionsAjaxDTO extends BaseActionTwitterDTO{
    private String type;
    private String user_id;
    private String tweet_id;
    private String action;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String userId) {
        user_id = userId;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public String getTweet_id() {
        return tweet_id;
    }
    public void setTweet_id(String tweetId) {
        tweet_id = tweetId;
    }
    

}