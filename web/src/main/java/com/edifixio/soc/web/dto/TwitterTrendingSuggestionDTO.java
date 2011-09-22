package com.edifixio.soc.web.dto;



public class TwitterTrendingSuggestionDTO{
    private String text;
    private String query;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    
}