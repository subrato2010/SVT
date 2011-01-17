package com.edifixio.soc.biz.dto;

public class UserDTO extends BaseDTO
{
    
    private String uid;
    private String password;
    private String name;
    private String title;
    private String company;
    private String workAddressLine1;
    private String workAddressLine2;
    private String workAddressLine3;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String email;
    private String website;
    private String twitter;
    private String facebook;
    
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
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
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getTwitter() {
        return twitter;
    }
    public String getTwitterLink(){
        String twitterLink = twitter;
        if(twitterLink != null){
            if(!twitterLink.startsWith("http://")){
                twitterLink = "http://" + twitterLink;
            }
        }
        return twitter;
    }
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
    public String getFacebook() {
        return facebook;
    }
    public String getFacebookLink(){
        String facebookLink = facebook;
        if(facebookLink != null){
            if(!facebookLink.startsWith("http://")){
                facebookLink = "http://" + facebookLink;
            }
        }
        return facebookLink;
    }
    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
    
    
    //ldap attributes-----------------------------------------------------
    public static final String preString="twt";
    
    public static final String USER_ID                  =       "uid";
    public static final String PASSWORD                 =       "userPassword";
    public static final String NAME                     =       preString+"Name";
    public static final String TITLE                    =       preString+"Title";
    public static final String COMPANY                  =       preString+"Company";
    public static final String WORK_ADDRESS_LINE1       =       preString+"WorkAddressLine1";
    public static final String WORK_ADDRESS_LINE2       =       preString+"WorkAddressLine2";
    public static final String WORK_ADDRESS_LINE3       =       preString+"WorkAddressLine3";
    public static final String CITY                     =       preString+"City";
    public static final String STATE                    =       preString+"State";
    public static final String ZIP_CODE                 =       preString+"ZiPCode";
    public static final String PHONE                    =       preString+"Phone";
    public static final String EMAIL                    =       preString+"Email";
    public static final String WEBSITE                  =       preString+"Website";
    public static final String TWITTER                  =       preString+"Twitter";
    public static final String FACEBOOK                 =       preString+"Facebook";
    public static final String LOGO                     =       preString+"Logo";
    public static final String PHOTO                    =       preString+"Photo";
   /* public static final String USER_ID = "uid";
    public static final String PASSWORD = "userPassword";
    public static final String NAME = "svtName";
    public static final String TITLE ="svtTitle";
    public static final String COMPANY = "svtCompany";
    public static final String WORK_ADDRESS_LINE1 = "svtWorkAddressLine1";
    public static final String WORK_ADDRESS_LINE2 ="svtWorkAddressLine2";
    public static final String WORK_ADDRESS_LINE3 = "svtWorkAddressLine3";
    public static final String CITY = "svtCity";
    public static final String STATE = "svtState";
    public static final String ZIP_CODE = "svtZiPCode";
    public static final String PHONE = "svtPhone";
    public static final String EMAIL = "svtEmail";
    public static final String WEBSITE = "svtWebsite";
    public static final String TWITTER = "svtTwitter";
    public static final String FACEBOOK = "svtFacebook";
    public static final String LOGO = "svtLogo";
    public static final String PHOTO = "svtPhoto";*/
    
}
