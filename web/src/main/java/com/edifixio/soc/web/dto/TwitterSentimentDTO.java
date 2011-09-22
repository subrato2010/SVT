package com.edifixio.soc.web.dto;

import java.util.List;

public class TwitterSentimentDTO{

    private int score;
    private List<String> positive;
    private List<String> negative;
    private String keywords;
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public List<String> getPositive() {
        return positive;
    }
    public void setPositive(List<String> positive) {
        this.positive = positive;
    }
    public List<String> getNegative() {
        return negative;
    }
    public void setNegative(List<String> negative) {
        this.negative = negative;
    }
    public String getKeywords() {
        return keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}