/**
 * @author NeelamadhabM
 *
 */
package com.edifixio.soc.web.dto;

import java.util.Date;

import twitter4j.Status;

import com.edifixio.soc.web.util.FilterSequence;

public class TwitterInformationDTO{
    private String twitterName;
    private String twitterScreenName;
    private String twittMessage;
    private String twittLocation;
    private int noOfTweets;
    private int noOfFollowers;
    private int noOfFollowings;
    private int noOfListed;
    private int influence;
    private String twittDate;
    private String source;
    private String backGroundImage;
    private String profileImage;
    private String individualMessage;
    private String loggedInName;
    private boolean retwittable;
    private long tweetID;
    private long twitterStatusID;
    private long replyStatusID;
    private int cnt;
    private boolean geoEnabled;
    private String tweetReferenceType;
    private String textAreaImage;
    private String textAreaLogoTooltip;
    private String referenceName;
    private String referenceType;
    private String fullTweetMsg;
    private Date createdAt;
    
    private Status tweetStat;
    private String boxHeaderColor;
    
    
    public String getTwitterName() {
        return twitterName;
    }
    public String getTwittMessage() {
        return twittMessage;
    }
    public String getTwittLocation() {
        return twittLocation;
    }
    public int getNoOfTweets() {
        return noOfTweets;
    }
    public int getNoOfFollowers() {
        return noOfFollowers;
    }
    public int getNoOfFollowings() {
        return noOfFollowings;
    }
    public int getNoOfListed() {
        return noOfListed;
    }
    public void setTwitterName(String twitterName) {
        this.twitterName = twitterName;
    }
    public void setTwittMessage(String twittMessage) {
        this.twittMessage = twittMessage;
    }
    public void setTwittLocation(String twittLocation) {
        this.twittLocation = twittLocation;
    }
    public void setNoOfTweets(int noOfTweets) {
        this.noOfTweets = noOfTweets;
    }
    public void setNoOfFollowers(int noOfFollowers) {
        this.noOfFollowers = noOfFollowers;
    }
    public void setNoOfFollowings(int noOfFollowings) {
        this.noOfFollowings = noOfFollowings;
    }
    public void setNoOfListed(int noOfListed) {
        this.noOfListed = noOfListed;
    }
    public String getTwittDate() {
        return twittDate;
    }
    public void setTwittDate(String twittDate) {
        this.twittDate = twittDate;
    }
    public String getBackGroundImage() {
        return backGroundImage;
    }
    public void setBackGroundImage(String backGroundImage) {
        this.backGroundImage = backGroundImage;
    }
    public String getProfileImage() {
        return profileImage;
    }
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
    public long getTweetID() {
        return tweetID;
    }
    public void setTweetID(long twitterID) {
        this.tweetID = twitterID;
    }
    public long getTwitterStatusID() {
        return twitterStatusID;
    }
    public void setTwitterStatusID(long twitterStatusID) {
        this.twitterStatusID = twitterStatusID;
    }
    public String getIndividualMessage() {
        return individualMessage;
    }
    public void setIndividualMessage(String individualMessage) {
        this.individualMessage = individualMessage;
    }
    public boolean isRetwittable() {
        return retwittable;
    }
    public void setRetwittable(boolean retwittable) {
        this.retwittable = retwittable;
    }
    public long getReplyStatusID() {
        return replyStatusID;
    }
    public void setReplyStatusID(long replyStatusID) {
        this.replyStatusID = replyStatusID;
    }
    public String getLoggedInName() {
        return loggedInName;
    }
    public void setLoggedInName(String loggedInName) {
        this.loggedInName = loggedInName;
    }
    public boolean isGeoEnabled() {
        return geoEnabled;
    }
    public void setGeoEnabled(boolean geoEnabled) {
        this.geoEnabled = geoEnabled;
    }
    public String getTweetReferenceType() {
        return tweetReferenceType;
    }
    public void setTweetReferenceType(String tweetReferenceType) {
        this.tweetReferenceType = tweetReferenceType;
    }
    public String getTextAreaImage() {
        return textAreaImage;
    }
    public void setTextAreaImage(String textAreaImage) {
        this.textAreaImage = textAreaImage;
    }
    public String getReferenceName() {
        return referenceName;
    }
    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }
    public String getReferenceType() {
        return referenceType;
    }
    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }
    public String getFullTweetMsg() {
        return fullTweetMsg;
    }
    public void setFullTweetMsg(String fullTweetMsg) {
        this.fullTweetMsg = fullTweetMsg;
    }
    public Status getTweetStat() {
        return tweetStat;
    }
    
    public String addHyperlinkIfBitlyURL(Status tweetStat)
    {
        if(getTweetReferenceType() != null)
        {
            if(getTweetReferenceType().equalsIgnoreCase(FilterSequence.BITLY))
            {
                return tweetStat.getText().trim().replaceFirst(getReferenceName().trim(), "<a style='font-size:13px;text-decoration: none;cursor: pointer' target='_blank' href='"+getReferenceName().trim()+"'>"+getReferenceName().trim()+"</a>");
            }
            else
            {
                return tweetStat.getText().trim().replaceAll(getReferenceName().trim(), "<font style='background-color:lightblue;'>"+getReferenceName().trim()+"</font>");
            }
       }
            return tweetStat.getText().trim();
    }
    
    public void setTweetStat(Status tweetStat)
    {
        this.tweetStat = tweetStat;
        setTwitterName(tweetStat.getUser().getScreenName().trim());
        
        setTwittMessage(addHyperlinkIfBitlyURL(tweetStat));
        
        setFullTweetMsg(tweetStat.getText().trim());
        setNoOfFollowers(tweetStat.getUser().getFollowersCount());
        setNoOfFollowings(tweetStat.getUser().getFriendsCount());
        setNoOfListed(tweetStat.getUser().getListedCount());

        setNoOfTweets(tweetStat.getUser().getStatusesCount());

        setTwittLocation(tweetStat.getUser().getLocation().trim());
        setTwittDate(tweetStat.getCreatedAt().toString().trim());
        setProfileImage(tweetStat.getUser().getProfileImageURL().toString().trim());

        setTweetID(tweetStat.getUser().getId());
        setTwitterStatusID(tweetStat.getId());
        setRetwittable(tweetStat.isRetweet());
        setReplyStatusID(tweetStat.getInReplyToStatusId());
        setCreatedAt(tweetStat.getCreatedAt());
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public String getBoxHeaderColor() {
        return boxHeaderColor;
    }
    public void setBoxHeaderColor(String boxHeaderColor) {
        this.boxHeaderColor = boxHeaderColor;
    }
    public String getTwitterScreenName() {
        return twitterScreenName;
    }
    public void setTwitterScreenName(String twitterScreenName) {
        this.twitterScreenName = twitterScreenName;
    }
    public String getTextAreaLogoTooltip() {
        return textAreaLogoTooltip;
    }
    public void setTextAreaLogoTooltip(String textAreaLogoTooltip) {
        this.textAreaLogoTooltip = textAreaLogoTooltip;
    }
    public int getInfluence() {
        return influence;
    }
    public void setInfluence(int influence) {
        this.influence = influence;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    
    private boolean is_friend;

    public boolean isIs_friend() {
        return is_friend;
    }
    public void setIs_friend(boolean is_friend) {
        this.is_friend = is_friend;
    }
    
}
