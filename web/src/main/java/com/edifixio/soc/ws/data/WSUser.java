package com.edifixio.soc.ws.data;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.ws.common.BaseWebServiceDTO;

public class WSUser extends BaseWebServiceDTO{
    private String userId;
    private String firstName;
    private String middleName;
    private String lastName;
    
    private String workAddressLine1;
    private String workAddressLine2;
    private String workAddressLine3;
    private String city;
    private String state;
    private String zipCode;
    private String password;
    private String subscriptionId;
    private String company;
    private String subscriptionName;
    private String subscriptionDesc;
    private Date subscriptionDateFrom;
    private Date subscriptionDateTo;
    private String emailAddress;
    private String success;
    
    private static final Log log = LogFactory.getLog(WSUser.class);
    
    public WSUser()
    {
       log.debug("WSUser constructor");
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getSubscriptionDateFrom() {
        return subscriptionDateFrom;
    }

    public void setSubscriptionDateFrom(Date subscriptionDateFrom) {
        this.subscriptionDateFrom = subscriptionDateFrom;
    }

    public Date getSubscriptionDateTo() {
        return subscriptionDateTo;
    }

    public void setSubscriptionDateTo(Date subscriptionDateTo) {
        this.subscriptionDateTo = subscriptionDateTo;
    }

    public String getSubscriptionDesc() {
        return subscriptionDesc;
    }

    public void setSubscriptionDesc(String subscriptionDesc) {
        this.subscriptionDesc = subscriptionDesc;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getWorkAddressLine1() {
        return workAddressLine1;
    }

    public void setWorkAddressLine1(String workAddressLine1) {
        this.workAddressLine1 = workAddressLine1;
    }

    public String getWorkAddressLine2() {
        return workAddressLine2;
    }

    public void setWorkAddressLine2(String workAddressLine2) {
        this.workAddressLine2 = workAddressLine2;
    }

    public String getWorkAddressLine3() {
        return workAddressLine3;
    }

    public void setWorkAddressLine3(String workAddressLine3) {
        this.workAddressLine3 = workAddressLine3;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
