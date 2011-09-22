// $Author: neelamadhabm $
package com.edifixio.soc.persist;

import java.io.Serializable;
import java.util.Date;

/**
 * @hibernate.class table="TwitterAccount"
 */
public class TwitterAccount  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String twitterAccountId;
    private ProfilePreference profilePreference;
    private Company company;
    private boolean self;
    private String twitterUsername;
    private Brand brand;
    private Industry industry;
    private Product product;
    private Date benchmarkDate;
    private String brndProdInds;
    private String accessToken;
    private String accessTokenSecret;
   
    /**
     * @return Returns the Company.
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
     * @return Returns the ProfilePreference.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="profilePreferenceId" not-null="true"
     */
    public ProfilePreference getProfilePreference() {
        return profilePreference;
    }
    public void setProfilePreference(ProfilePreference profilePreference) {
        this.profilePreference = profilePreference;
    }
    /**
     * @hibernate.property
     * 
     */
    public boolean isSelf() {
        return self;
    }
    public void setSelf(boolean self) {
        this.self = self;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getTwitterAccountId() {
        return twitterAccountId;
    }
    public void setTwitterAccountId(String twitterAccountId) {
        this.twitterAccountId = twitterAccountId;
    }
    /**
     * @hibernate.property
     * 
     */
    public String getTwitterUsername() {
        return twitterUsername;
    }
    public void setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
    }
    
    /**
     * @hibernate.property 
     * 
     */
    public Date getBenchmarkDate() {
        return benchmarkDate;
    }
    public void setBenchmarkDate(Date benchmarkDate) {
        this.benchmarkDate = benchmarkDate;
    }
    /**
     * @hibernate.property 
     * 
     */
    public String getBrndProdInds() {
        return brndProdInds;
    }
    public void setBrndProdInds(String brndProdInds) {
        this.brndProdInds = brndProdInds;
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
     * @hibernate.property 
     * 
     */
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }
    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }
}
