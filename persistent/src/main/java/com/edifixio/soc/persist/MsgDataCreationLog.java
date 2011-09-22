// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;
import java.util.Date;

public class MsgDataCreationLog  extends TrackedEntity implements Serializable {
    /**
     * SG: non-standard attribute, because of some reason....
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private Date actionDate;    
    private int level;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public Date getActionDate() {
        return actionDate;
    }
    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }
}
