// $Author: subratog $
package com.edifixio.soc.biz.dto;

import com.edifixio.soc.persist.Benchmark;
import com.edifixio.soc.persist.Brand;
import com.edifixio.soc.persist.Company;
import com.edifixio.soc.persist.Industry;
import com.edifixio.soc.persist.Product;
import com.edifixio.soc.persist.ProfilePreference;

public class ProfilePreferenceDTO extends BaseDTO{

    private String profilePrefrenceId;
    private Company company;
    private Brand brand;
    private Industry industry;
    private Product product;
    private Benchmark benchmark;
    private boolean activeStatus;
    
    private ProfilePreference profilePreference;
    
    public ProfilePreference getProfilePreference() {
        return profilePreference;
    }
    public void setProfilePreference(ProfilePreference profilePreference) {
        this.profilePreference = profilePreference;
    }
    public boolean isActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public Industry getIndustry() {
        return industry;
    }
    public void setIndustry(Industry industry) {
        this.industry = industry;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public String getProfilePrefrenceId() {
        return profilePrefrenceId;
    }
    public void setProfilePrefrenceId(String profilePrefrenceId) {
        this.profilePrefrenceId = profilePrefrenceId;
    }
    public Benchmark getBenchmark() {
        return benchmark;
    }
    public void setBenchmark(Benchmark benchmark) {
        this.benchmark = benchmark;
    }

 }
