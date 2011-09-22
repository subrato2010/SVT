package com.edifixio.soc.web.dto;

import java.util.List;


public class TwitterTextSuggestionDTO{
    private String success;
    private String query;
    private List<TwitterTokens> tokens;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getQuery() {
        return query;
    }
    
    public int getMaxOccurance(){
        if(tokens != null && tokens.size()> 0){
            return tokens.get(0).getCount();
        }
        return 0;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<TwitterTokens> getTokens() {
        return tokens;
    }

    public void setTokens(List<TwitterTokens> tokens) {
        this.tokens = tokens;
    }


}