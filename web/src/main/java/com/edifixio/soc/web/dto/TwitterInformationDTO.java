/**
 * @author NeelamadhabM
 *
 */
package com.edifixio.soc.web.dto;

public class TwitterInformationDTO {
    private String twitterName;
    private String twittMessage;
    private String twittLocation;
    private int noOfTweets;
    private int noOfFollowers;
    private int noOfFollowings;
    private int noOfListed;
    private String twittDate;
    private String backGroundImage;
    private String profileImage;
    private long twitterID;
    private long twitterStatusID;
    private int cnt;
    
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
    public long getTwitterID() {
        return twitterID;
    }
    public void setTwitterID(long twitterID) {
        this.twitterID = twitterID;
    }
    public long getTwitterStatusID() {
        return twitterStatusID;
    }
    public void setTwitterStatusID(long twitterStatusID) {
        this.twitterStatusID = twitterStatusID;
    }
    
}
