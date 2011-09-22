package com.edifixio.soc.web.dto;


public class Tweets{
    private String screen_name;
    private String name;
    private String text;
    private String avatar;
    private String created_at;
    private String source;
    private Long tweet_id;
    private Long user_id;
    private String location;
    private int statuses_count;
    private int followers_count;
    private int friends_count;
    private int listed_count;
    private int influence;
    private String keyword;
    private Long inreplytostatus_id;
    private Processing processing;
    private boolean is_friend;
    private boolean is_follower;
    
    public String getScreen_name() {
        return screen_name;
    }
    public void setScreen_name(String screenName) {
        screen_name = screenName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getAvatar() {
        return avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getCreated_at() {
        return created_at;
    }
    public void setCreated_at(String createdAt) {
        created_at = createdAt;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public Long getTweet_id() {
        return tweet_id;
    }
    public void setTweet_id(Long tweetId) {
        tweet_id = tweetId;
    }
    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long userId) {
        user_id = userId;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getStatuses_count() {
        return statuses_count;
    }
    public void setStatuses_count(int statusesCount) {
        statuses_count = statusesCount;
    }
    public int getFollowers_count() {
        return followers_count;
    }
    public void setFollowers_count(int followersCount) {
        followers_count = followersCount;
    }
    public int getFriends_count() {
        return friends_count;
    }
    public void setFriends_count(int friendsCount) {
        friends_count = friendsCount;
    }
    public int getListed_count() {
        return listed_count;
    }
    public void setListed_count(int listedCount) {
        listed_count = listedCount;
    }
    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public Long getInreplytostatus_id() {
        return inreplytostatus_id;
    }
    public void setInreplytostatus_id(Long inreplytostatusId) {
        inreplytostatus_id = inreplytostatusId;
    }
    public Processing getProcessing() {
        return processing;
    }
    public void setProcessing(Processing processing) {
        this.processing = processing;
    }
    public int getInfluence() {
        return influence;
    }
    public void setInfluence(int influence) {
        this.influence = influence;
    }
    public boolean isIs_friend() {
        return is_friend;
    }
    public void setIs_friend(boolean isFriend) {
        is_friend = isFriend;
    }
    public boolean isIs_follower() {
        return is_follower;
    }
    public void setIs_follower(boolean isFollower) {
        is_follower = isFollower;
    }
}