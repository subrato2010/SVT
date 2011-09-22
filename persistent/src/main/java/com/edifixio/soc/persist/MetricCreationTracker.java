// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;
import java.util.Date;

public class MetricCreationTracker  extends TrackedEntity implements Serializable {
    /**
     * SG: non-standard attribute, because of some reason....
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String twitterUsername;
    private Date actionDate;    
    private int state;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTwitterUsername() {
        return twitterUsername;
    }
    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }
    public Date getActionDate() {
        return actionDate;
    }
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
}
