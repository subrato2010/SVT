// $Author: neelamadhabm $
package com.edifixio.soc.biz.dto;

import com.edifixio.soc.persist.Company;
import com.edifixio.soc.persist.ProfilePreference;
import com.edifixio.soc.persist.TwitterAccount;

public class TwitterAccountDTO extends BaseDTO{
 
    private static final long serialVersionUID = 1L;
    private String twitterAccountId;
    private ProfilePreference profilePreference;
    private Company company;
    private boolean self;
    private String twitterUsername;
    private TwitterAccount twitterAccount;
    private String handlerName;
    private String brndProdInds;
    
    private String accessToken;
    private String accessTokenSecret;
    private String profilePreferenceId; // needs to be passed from servlet manageTwitterOperatrion

    public String getHandlerName() {
        return handlerName;
    }
    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }
    public TwitterAccount getTwitterAccount() {
        return twitterAccount;
    }
    public void setTwitterAccount(TwitterAccount twitterAccount) {
        this.twitterAccount = twitterAccount;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public ProfilePreference getProfilePreference() {
        return profilePreference;
    }
    public void setProfilePreference(ProfilePreference profilePreference) {
        this.profilePreference = profilePreference;
    }
    public boolean isSelf() {
        return self;
    }
    public void setSelf(boolean self) {
        this.self = self;
    }
    public String getTwitterAccountId() {
        return twitterAccountId;
    }
    public void setTwitterAccountId(String twitterAccountId) {
        this.twitterAccountId = twitterAccountId;
    }
    public String getTwitterUsername() {
        return twitterUsername;
    }
    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }
    public String getBrndProdInds() {
        return brndProdInds;
    }
    public void setBrndProdInds(String brndProdInds) {
        this.brndProdInds = brndProdInds;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }
    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }
    public String getProfilePreferenceId() {
        return profilePreferenceId;
    }
    public void setProfilePreferenceId(String profilePreferenceId) {
        this.profilePreferenceId = profilePreferenceId;
    }
 }
