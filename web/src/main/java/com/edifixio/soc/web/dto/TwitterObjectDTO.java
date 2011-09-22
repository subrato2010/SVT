package com.edifixio.soc.web.dto;

import java.util.List;


public class TwitterObjectDTO extends BaseTwitterObject{
    private String name;
    private int count;
    private int limit;
    private List<Tweets> tweets;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    
    @Override
    public List<Tweets> getTweets() {
        return tweets;
    }
    public void setTweets(List<Tweets> tweets) {
        this.tweets = tweets;
    }
}