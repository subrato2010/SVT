// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="ProfilePreference"
 */
public class ProfilePreference  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String profilePrefrenceId;
    private String profileUserId;
    private String googleAnalyticsUsername;
    private String googleAnalyticsPassword;
    private String bitlyUsername;
    private String bitlyAccessToken;
    private String bitlyAPIKey;
    private Company company;
    private Brand brand;
    private Industry industry;
    private Product product;
    private boolean activeStatus;
    private boolean googleAnalyticsAuth;
    private UserProfileDetail userProfileDetail;
    private Role role;
    private boolean warningAlert;
    private Benchmark benchmark;
    
    /**
     * @return Returns the ProfilePreference.
     * @hibernate.many-to-one cascade="true"
     * @hibernate.column name="userProfileDetailId" not-null="true"
     */
    public UserProfileDetail getUserProfileDetail() {
        return userProfileDetail;
    }
    public void setUserProfileDetail(UserProfileDetail userProfileDetail) {
        this.userProfileDetail = userProfileDetail;
    }
    /**
     * @return Returns the Role.
     * @hibernate.many-to-one cascade="true"
     * @hibernate.column name="roleId" not-null="true"
     */
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @hibernate.property
     * 
     */
    public boolean isActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    /**
     * @return Returns the brand.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="brandId" not-null="true"
     */
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    /**
     * @return Returns the company.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="companyId" not-null="true"
     */
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    /**
     * @return Returns the industry.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="industryId" not-null="true"
     */
    public Industry getIndustry() {
        return industry;
    }
    public void setIndustry(Industry industry) {
        this.industry = industry;
    }
    /**
     * @return Returns the product.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="productId" not-null="true"
     */
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getProfilePrefrenceId() {
        return profilePrefrenceId;
    }
    public void setProfilePrefrenceId(String profilePrefrenceId) {
        this.profilePrefrenceId = profilePrefrenceId;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getProfileUserId() {
        return profileUserId;
    }
    public void setProfileUserId(String profileUserId) {
        this.profileUserId = profileUserId;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getGoogleAnalyticsUsername() {
        return googleAnalyticsUsername;
    }
    public void setGoogleAnalyticsUsername(String googleAnalyticsUsername) {
        this.googleAnalyticsUsername = googleAnalyticsUsername;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getGoogleAnalyticsPassword() {
        return googleAnalyticsPassword;
    }
    public void setGoogleAnalyticsPassword(String googleAnalyticsPassword) {
        this.googleAnalyticsPassword = googleAnalyticsPassword;
    }
    /**
     * @hibernate.property
     * 
     */
    public boolean isGoogleAnalyticsAuth() {
        return googleAnalyticsAuth;
    }
    public void setGoogleAnalyticsAuth(boolean googleAnalyticsAuth) {
        this.googleAnalyticsAuth = googleAnalyticsAuth;
    }
    public Benchmark getBenchmark() {
        return benchmark;
    }
    public void setBenchmark(Benchmark benchmark) {
        this.benchmark = benchmark;
    }
    public String getBitlyUsername() {
        return bitlyUsername;
    }
    public void setBitlyUsername(String bitlyUsername) {
        this.bitlyUsername = bitlyUsername;
    }
    public boolean isWarningAlert() {
        return warningAlert;
    }
    public void setWarningAlert(boolean warningAlert) {
        this.warningAlert = warningAlert;
    }
    public String getBitlyAccessToken() {
        return bitlyAccessToken;
    }
    public void setBitlyAccessToken(String bitlyAccessToken) {
        this.bitlyAccessToken = bitlyAccessToken;
    }
    public String getBitlyAPIKey() {
        return bitlyAPIKey;
    }
    public void setBitlyAPIKey(String bitlyAPIKey) {
        this.bitlyAPIKey = bitlyAPIKey;
    }
 }
