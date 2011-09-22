package com.edifixio.soc.web.dto;

public class TwitterTokens {
    private String name;
    private int count;
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
    
    public int getAbscount(){
        return Math.abs(count);
    }
    
    public boolean getTrendup(){
        return count >= 0;
    }

}
