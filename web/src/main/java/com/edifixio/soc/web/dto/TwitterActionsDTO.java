package com.edifixio.soc.web.dto;

import java.util.List;


public class TwitterActionsDTO{
    private String success;
    private ActionsTotal total;
    private ActionsTotal actions;
    private String accountname;
    private List<ActionsTwitterAccounts> twitter_accounts;
    
    
    public class ActionsTotal{
        private int influencers;
        private int favourites;
        private int retweets;
        private int dmtoreturn;
        private int influencers_to_list;
        private ActionCount missingBio;
        private ActionCount missingProfilePicture;
        private ActionCount missingCustomBackground;
        private ActionCount missingGeolocation;
        private ActionCount influencersToFollow;
        private ActionCount influencersToList;
        private ActionCount tweetsToFavorite;
        private ActionCount rtToThanks;
        private ActionCount dmToReturn;
        
        public int getInfluencers() {
            return influencers;
        }
        public void setInfluencers(int influencers) {
            this.influencers = influencers;
        }
        public int getFavourites() {
            return favourites;
        }
        public void setFavourites(int favourites) {
            this.favourites = favourites;
        }
        public int getRetweets() {
            return retweets;
        }
        public void setRetweets(int retweets) {
            this.retweets = retweets;
        }
        public ActionCount getMissingBio() {
            return missingBio;
        }
        public void setMissingBio(ActionCount missingBio) {
            this.missingBio = missingBio;
        }
        public ActionCount getMissingProfilePicture() {
            return missingProfilePicture;
        }
        public void setMissingProfilePicture(ActionCount missingProfilePicture) {
            this.missingProfilePicture = missingProfilePicture;
        }
        public ActionCount getMissingCustomBackground() {
            return missingCustomBackground;
        }
        public void setMissingCustomBackground(ActionCount missingCustomBackground) {
            this.missingCustomBackground = missingCustomBackground;
        }
        public ActionCount getMissingGeolocation() {
            return missingGeolocation;
        }
        public void setMissingGeolocation(ActionCount missingGeolocation) {
            this.missingGeolocation = missingGeolocation;
        }
        public ActionCount getInfluencersToFollow() {
            return influencersToFollow;
        }
        public void setInfluencersToFollow(ActionCount influencersToFollow) {
            this.influencersToFollow = influencersToFollow;
        }
        public ActionCount getTweetsToFavorite() {
            return tweetsToFavorite;
        }
        public void setTweetsToFavorite(ActionCount tweetsToFavorite) {
            this.tweetsToFavorite = tweetsToFavorite;
        }
        public ActionCount getRtToThanks() {
            return rtToThanks;
        }
        public void setRtToThanks(ActionCount rtToThanks) {
            this.rtToThanks = rtToThanks;
        }
        public ActionCount getDmToReturn() {
            return dmToReturn;
        }
        public void setDmToReturn(ActionCount dmToReturn) {
            this.dmToReturn = dmToReturn;
        }
        public int getDmtoreturn() {
            return dmtoreturn;
        }
        public void setDmtoreturn(int dmtoreturn) {
            this.dmtoreturn = dmtoreturn;
        }
        public ActionCount getInfluencersToList() {
            return influencersToList;
        }
        public void setInfluencersToList(ActionCount influencersToList) {
            this.influencersToList = influencersToList;
        }
        public int getInfluencers_to_list() {
            return influencers_to_list;
        }
        public void setInfluencers_to_list(int influencersToList) {
            influencers_to_list = influencersToList;
        }


    }

    public class ActionsTwitterAccounts{
        private String accountname;
        private int influencers;
        private int favourites;
        private int retweets;
        private int influencers_to_list;
        
        public int getInfluencers() {
            return influencers;
        }
        public void setInfluencers(int influencers) {
            this.influencers = influencers;
        }
        public int getFavourites() {
            return favourites;
        }
        public void setFavourites(int favourites) {
            this.favourites = favourites;
        }
        public int getRetweets() {
            return retweets;
        }
        public void setRetweets(int retweets) {
            this.retweets = retweets;
        }
        public String getAccountname() {
            return accountname;
        }
        public void setAccountname(String accountname) {
            this.accountname = accountname;
        }
        public int getInfluencers_to_list() {
            return influencers_to_list;
        }
        public void setInfluencers_to_list(int influencersToList) {
            influencers_to_list = influencersToList;
        }

    }
    public class ActionCount{
        private int missingCount;
        private int actionStarCount;
        private int actionFlameCount;
        public int getMissingCount() {
            return missingCount;
        }
        public void setMissingCount(int missingCount) {
            this.missingCount = missingCount;
        }
        public int getActionStarCount() {
            return actionStarCount;
        }
        public void setActionStarCount(int actionStarCount) {
            this.actionStarCount = actionStarCount;
        }
        public int getActionFlameCount() {
            return actionFlameCount;
        }
        public void setActionFlameCount(int actionFlameCount) {
            this.actionFlameCount = actionFlameCount;
        }

    }


    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ActionsTotal getTotal() {
        return total;
    }

    public void setTotal(ActionsTotal total) {
        this.total = total;
    }

    public List<ActionsTwitterAccounts> getTwitter_accounts() {
        return twitter_accounts;
    }

    public void setTwitter_accounts(List<ActionsTwitterAccounts> twitterAccounts) {
        twitter_accounts = twitterAccounts;
    }

    public ActionsTotal getActions() {
        return actions;
    }

    public void setActions(ActionsTotal actions) {
        this.actions = actions;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }
}