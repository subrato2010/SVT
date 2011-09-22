
//TODO The structure of this DTO is same as that of TwitterActionsRTThanksDTO. Should be re-factored depending on the DM JSON structure

package com.edifixio.soc.web.dto;

import java.util.List;

public class TwitterActionsDMToReturnDTO extends BaseActionTwitterDTO{
    
    private String success;
    private String twitter;
    private List<DMReturns> dmReturns;
    
    
    public class DMReturns{
        
        private String screen_name;
        private String name;
        private String avatar;
        private String user_id;
        private String description;
        private String location;
        private String text;
        private String created_at;
        private String source;
        private String tweet_id;
        private String sentiment;
        private String keyword;
        private String inreplytostatus_id;
        private int statuses_count;
        private int followers_count;
        private int friends_count;
        private int listed_count;
        private int influence_raw;
        private int influence;
        private int retweet_count;
        private boolean is_retweet;        
        private Processing processing;
        
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
        
        public class Processing{
            private String last_filter;

            public String getLast_filter() {
                return last_filter;
            }

            public void setLast_filter(String lastFilter) {
                last_filter = lastFilter;
            }   
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

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
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

        public String getTweet_id() {
            return tweet_id;
        }

        public void setTweet_id(String tweetId) {
            tweet_id = tweetId;
        }

        public String getSentiment() {
            return sentiment;
        }

        public void setSentiment(String sentiment) {
            this.sentiment = sentiment;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getInreplytostatus_id() {
            return inreplytostatus_id;
        }

        public void setInreplytostatus_id(String inreplytostatusId) {
            inreplytostatus_id = inreplytostatusId;
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

        public int getRetweet_count() {
            return retweet_count;
        }

        public void setRetweet_count(int retweetCount) {
            retweet_count = retweetCount;
        }

        public boolean isIs_retweet() {
            return is_retweet;
        }

        public void setIs_retweet(boolean isRetweet) {
            is_retweet = isRetweet;
        }

        public Processing getProcessing() {
            return processing;
        }

        public void setProcessing(Processing processing) {
            this.processing = processing;
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
    public List<DMReturns> getDmReturns() {
        return dmReturns;
    }
    public void setDmReturns(List<DMReturns> dmReturns) {
        this.dmReturns = dmReturns;
    }
    
}
