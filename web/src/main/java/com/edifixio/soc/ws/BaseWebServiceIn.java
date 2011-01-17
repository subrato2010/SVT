package com.edifixio.soc.ws;

import java.util.Calendar;

public class BaseWebServiceIn {
    protected static final int MAX_SVC_BUF_SIZE = 1;
    private Calendar dateTimeSent;
    private Calendar dateTimeReceived;
    private String loginId;
    
    public String getLoginId() {
        return loginId;
    }
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
    public Calendar getDateTimeReceived() {
        return dateTimeReceived;
    }
    public void setDateTimeReceived(Calendar dateTimeReceived) {
        this.dateTimeReceived = dateTimeReceived;
    }
    public Calendar getDateTimeSent() {
        return dateTimeSent;
    }
    public void setDateTimeSent(Calendar dateTimeSent) {
        this.dateTimeSent = dateTimeSent;
    }

}
