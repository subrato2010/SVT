package com.edifixio.soc.ws;

import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.ws.common.BaseWebServiceIO;

public class BaseWebServiceOut extends BaseWebServiceIO{
    private static final Log log = LogFactory.getLog(BaseWebServiceOut.class);
    protected static final int MAX_SVC_BUF_SIZE = 500;
    
    private int mainErrorCode;
    private String mainErrorType;
    private String mainErrorMessage;
    private Calendar dateTimeCreated;
    private Calendar dateTimeSent;
    public Calendar getDateTimeCreated() {
        return dateTimeCreated;
    }
    public void setDateTimeCreated(Calendar dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }
    public Calendar getDateTimeSent() {
        return dateTimeSent;
    }
    public void setDateTimeSent(Calendar dateTimeSent) {
        this.dateTimeSent = dateTimeSent;
    }
    public int getMainErrorCode() {
        return mainErrorCode;
    }
    public void setMainErrorCode(int mainErrorCode) {
        this.mainErrorCode = mainErrorCode;
    }
    public String getMainErrorMessage() {
        return mainErrorMessage;
    }
    public void setMainErrorMessage(String mainErrorMessage) {
        this.mainErrorMessage = mainErrorMessage;
    }
    public String getMainErrorType() {
        return mainErrorType;
    }
    public void setMainErrorType(String mainErrorType) {
        this.mainErrorType = mainErrorType;
    }
}
