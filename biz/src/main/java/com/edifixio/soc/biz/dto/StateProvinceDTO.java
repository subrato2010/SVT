package com.edifixio.soc.biz.dto;

public class StateProvinceDTO extends BaseDTO{

    private String stateId;
    private String abbrev;
    private String name;
    private String countryName;
    private boolean activStatus;
    public String getAbbrev() {
        return abbrev;
    }
    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }
    public boolean isActivStatus() {
        return activStatus;
    }
    public void setActivStatus(boolean activStatus) {
        this.activStatus = activStatus;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStateId() {
        return stateId;
    }
    public void setStateId(String stateId) {
        this.stateId = stateId;
    }
    
}
