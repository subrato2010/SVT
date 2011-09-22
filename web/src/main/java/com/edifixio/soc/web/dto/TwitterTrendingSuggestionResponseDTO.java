package com.edifixio.soc.web.dto;

import java.util.List;



public class TwitterTrendingSuggestionResponseDTO{

    private String success;
    private String text;
    private List<TwitterTokens> query;
    private List<TwitterTokens> tokens;
    private List<TwitterTokens> trending;
    private TwitterSentimentDTO sentiment;
    public String getSuccess() {
        return success;
    }
    public void setSuccess(String success) {
        this.success = success;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public List<TwitterTokens> getQuery() {
        return query;
    }
    public void setQuery(List<TwitterTokens> query) {
        this.query = query;
    }
    public List<TwitterTokens> getTokens() {
        return tokens;
    }
    public void setTokens(List<TwitterTokens> tokens) {
        this.tokens = tokens;
    }
    public TwitterSentimentDTO getSentiment() {
        return sentiment;
    }
    public void setSentiment(TwitterSentimentDTO sentiment) {
        this.sentiment = sentiment;
    }
    public List<TwitterTokens> getTrending() {
        return trending;
    }
    public void setTrending(List<TwitterTokens> trending) {
        this.trending = trending;
    }
}