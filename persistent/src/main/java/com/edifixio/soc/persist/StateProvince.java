// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="StateProvince"
 */
public class StateProvince extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String stateId;
    private String abbrev;
    private String name;
    private String countryName; // will make country object later
    private boolean activStatus;

    /**
     * @hibernate.property
     * 
     */
    public String getAbbrev() {
        return abbrev;
    }


    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    /**
     * @hibernate.property
     * 
     */
    public String getCountryName() {
        return countryName;
    }


    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @hibernate.property
     * 
     */
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getStateId() {
        return stateId;
    }


    public void setStateId(String stateId) {
        this.stateId = stateId;
    }


    /**
     * @hibernate.property
     * 
     */
    public boolean isActivStatus() {
        return activStatus;
    }


    public void setActivStatus(boolean activStatus) {
        this.activStatus = activStatus;
    }
}
