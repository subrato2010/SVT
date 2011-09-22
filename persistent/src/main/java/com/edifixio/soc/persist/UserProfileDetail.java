// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;
import java.util.Date;

/**
 * @hibernate.class table="UserProfileDetail"
 */
public class UserProfileDetail  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String userProfileDetailId;
    private String keyWordIdentBrand;
    private String keyWordIdentProd;
    private String keyWordIdentIndu;
    private String reportingEmail1;
    private String reportingEmail2;
    private String reportingEmail3;
    private String vanityUrl;
    private String subscriptionCompany; // jackson need this info
    private String subscriptionId;
    private String subscriptionName;
    private String subscriptionDesc;
    private Date subscriptionDateFrom;
    private Date subscriptionDateTo;
    private boolean firstTimeLogin;
    private boolean activeStatus;
    private ImprovementLevel improvementLevel;
    private String timeZone;
    
    /**
     * @hibernate.property
     */
    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    /**
     * @hibernate.property
     * 
     */
    public boolean isFirstTimeLogin() {
        return firstTimeLogin;
    }
    public void setFirstTimeLogin(boolean firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }    

    /**
     * @return Returns the improvmentLevel.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="improvementLevelId" not-null="true"
     */
    public ImprovementLevel getImprovementLevel() {
        return improvementLevel;
    }

    public void setImprovementLevel(ImprovementLevel improvementLevel) {
        this.improvementLevel = improvementLevel;
    }
    /**
     * @hibernate.property
     */
    public String getKeyWordIdentBrand() {
        return keyWordIdentBrand;
    }

    public void setKeyWordIdentBrand(String keyWordIdentBrand) {
        this.keyWordIdentBrand = keyWordIdentBrand;
    }
    /**
     * @hibernate.property
     */
    public String getKeyWordIdentIndu() {
        return keyWordIdentIndu;
    }

    public void setKeyWordIdentIndu(String keyWordIdentIndu) {
        this.keyWordIdentIndu = keyWordIdentIndu;
    }
    /**
     * @hibernate.property
     */
    public String getKeyWordIdentProd() {
        return keyWordIdentProd;
    }

    public void setKeyWordIdentProd(String keyWordIdentProd) {
        this.keyWordIdentProd = keyWordIdentProd;
    }

    /**
     * @hibernate.property
     */
    public Date getSubscriptionDateFrom() {
        return subscriptionDateFrom;
    }

    public void setSubscriptionDateFrom(Date subscriptionDateFrom) {
        this.subscriptionDateFrom = subscriptionDateFrom;
    }
    /**
     * @hibernate.property
     */
    public Date getSubscriptionDateTo() {
        return subscriptionDateTo;
    }

    public void setSubscriptionDateTo(Date subscriptionDateTo) {
        this.subscriptionDateTo = subscriptionDateTo;
    }
    /**
     * @hibernate.property
     */
    public String getSubscriptionDesc() {
        return subscriptionDesc;
    }

    public void setSubscriptionDesc(String subscriptionDesc) {
        this.subscriptionDesc = subscriptionDesc;
    }
    /**
     * @hibernate.property
     */
    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }
    /**
     * @hibernate.property
     */
    public String getVanityUrl() {
        return vanityUrl;
    }

    public void setVanityUrl(String vanityUrl) {
        this.vanityUrl = vanityUrl;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getUserProfileDetailId() {
        return userProfileDetailId;
    }

    public void setUserProfileDetailId(String userProfileDetailId) {
        this.userProfileDetailId = userProfileDetailId;
    }
    /**
     * @hibernate.property
     */
    public String getReportingEmail1() {
        return reportingEmail1;
    }

    public void setReportingEmail1(String reportingEmail1) {
        this.reportingEmail1 = reportingEmail1;
    }
    /**
     * @hibernate.property
     */
    public String getReportingEmail2() {
        return reportingEmail2;
    }

    public void setReportingEmail2(String reportingEmail2) {
        this.reportingEmail2 = reportingEmail2;
    }
    /**
     * @hibernate.property
     */
    public String getReportingEmail3() {
        return reportingEmail3;
    }

    public void setReportingEmail3(String reportingEmail3) {
        this.reportingEmail3 = reportingEmail3;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriptionCompany() {
        return subscriptionCompany;
    }

    public void setSubscriptionCompany(String subscriptionCompany) {
        this.subscriptionCompany = subscriptionCompany;
    }

 }
