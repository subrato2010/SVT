package com.edifixio.soc.web.dto;

import java.util.List;



public class TwitterMentionsDTO extends BaseTwitterObject{
    private String success;
    private String name;
    private int mention_count;
    private int competitor_mention_count;
    public String getSuccess() {
        return success;
    }
    public void setSuccess(String success) {
        this.success = success;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMention_count() {
        return mention_count;
    }
    public void setMention_count(int mentionCount) {
        mention_count = mentionCount;
    }
    public int getCompetitor_mention_count() {
        return competitor_mention_count;
    }
    public void setCompetitor_mention_count(int competitorMentionCount) {
        competitor_mention_count = competitorMentionCount;
    }
    @Override
    public List<Tweets> getTweets() {
        
        return null;
    }
    
}