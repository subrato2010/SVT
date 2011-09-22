package com.edifixio.soc.web.dto;

import java.util.List;

import com.edifixio.soc.web.beans.RTOPHandler;

/**
 * This class is used to create object from json by factory pattern 
 * @author tapasb
 * @see RTOPHandler#optimizeActionInfluencersToList(javax.faces.event.ActionEvent)
 */
public class TwitterActionsInfluencersListDTO extends BaseActionTwitterDTO {
    private String success;
    private String twitter;
    private List<InfluencersToList> influencers_to_list;

    public class InfluencersToList {
        private String screen_name;
        private String name;
        private String avatar;
        private String user_id;
        private String description;
        private String lang;
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


        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
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


        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }


        public String getDescription() {
            return description;
        }


        public void setDescription(String description) {
            this.description = description;
        }


        public String getLang() {
            return lang;
        }


        public void setLang(String lang) {
            this.lang = lang;
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


        public void setStatuses_count(int statuses_count) {
            this.statuses_count = statuses_count;
        }


        public int getFollowers_count() {
            return followers_count;
        }


        public void setFollowers_count(int followers_count) {
            this.followers_count = followers_count;
        }


        public int getFriends_count() {
            return friends_count;
        }


        public void setFriends_count(int friends_count) {
            this.friends_count = friends_count;
        }


        public int getListed_count() {
            return listed_count;
        }


        public void setListed_count(int listed_count) {
            this.listed_count = listed_count;
        }


        public int getInfluence_raw() {
            return influence_raw;
        }


        public void setInfluence_raw(int influence_raw) {
            this.influence_raw = influence_raw;
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

    public List<InfluencersToList> getInfluencers_to_list() {
        return influencers_to_list;
    }

    public void setInfluencers_to_list(List<InfluencersToList> influencers_to_list) {
        this.influencers_to_list = influencers_to_list;
    }    
}
