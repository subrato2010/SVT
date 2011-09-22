package com.edifixio.soc.web.dto;

import java.util.List;


public class TwitterActionsInfluencersDTO extends BaseActionTwitterDTO{
    private String success;
    private String twitter;
    private List<ActionsInfluencers> influencers;
    
    
    public class ActionsInfluencers{
        
        private String screen_name;
        private String name;
        private String avatar;
        private String user_id;
        private String description;
        private String location;
        private int statuses_count;
        private int followers_count;
        private int friends_count;
        private int listed_count;
        private int influence_raw;
        private int influence;
        
        private int noOfListed;
        private int noOfFollowings;
        private int noOfTweets;     
        
        public int getNoOfListed() {
            return noOfListed;
        }

        public void setNoOfListed(int noOfListed) {
            this.noOfListed = noOfListed;
        }

        public int getNoOfFollowings() {
            return noOfFollowings;
        }

        public void setNoOfFollowings(int noOfFollowings) {
            this.noOfFollowings = noOfFollowings;
        }

        public int getNoOfTweets() {
            return noOfTweets;
        }

        public void setNoOfTweets(int noOfTweets) {
            this.noOfTweets = noOfTweets;
        }
        
        
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
        public String getAvatar() {
            return avatar;
        }
        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
        public String getUser_id() {
            return user_id;
        }
        public void setUser_id(String userId) {
            user_id = userId;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
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
        public int getInfluence_raw() {
            return influence_raw;
        }
        public void setInfluence_raw(int influenceRaw) {
            influence_raw = influenceRaw;
        }
        public int getInfluence() {
            return influence;
        }
        public void setInfluence(int influence) {
            this.influence = influence;
        }
    }


    public String getSuccess() {
        return success;
    }


    public void setSuccess(String success) {
        this.success = success;
    }


    public String getTwitter() {
        return twitter;
    }


    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }


    public List<ActionsInfluencers> getInfluencers() {
        return influencers;
    }


    public void setInfluencers(List<ActionsInfluencers> influencers) {
        this.influencers = influencers;
    }
}