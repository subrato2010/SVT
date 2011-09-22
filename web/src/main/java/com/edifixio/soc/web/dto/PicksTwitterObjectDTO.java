package com.edifixio.soc.web.dto;

import java.util.List;


public class PicksTwitterObjectDTO  extends BaseTwitterObject{
    private String success;
    private List<Tweets> picks;
    public String getSuccess() {
        return success;
    }
    public void setSuccess(String success) {
        this.success = success;
    }
    @Override
    public List<Tweets> getTweets() {
        return picks;
    }
    public List<Tweets> getPicks() {
        return picks;
    }
    public void setPicks(List<Tweets> picks) {
        this.picks = picks;
    }
}