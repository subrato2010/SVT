package com.edifixio.soc.web.dto;

public class Processing{
    private String collectMention;
    private String collectCompetitor;
    private String collectBrand;
    private String collectIndustry;
    private String collectProduct;
    private String collectPositive;
    private String collectNegative;
    private String collectBitly;
    private String collectThemes;
    private String collectHashtags;
    private String collectInfluence;
    private String picker;
    
    public String getCollectMention() {
        return collectMention;
    }
    public void setCollectMention(String collectMention) {
        this.collectMention = collectMention;
    }
    public String getCollectBrand() {
        return collectBrand;
    }
    public void setCollectBrand(String collectBrand) {
        this.collectBrand = collectBrand;
    }
    public String getCollectBitly() {
        return collectBitly;
    }
    public void setCollectBitly(String collectBitly) {
        this.collectBitly = collectBitly;
    }
    public String getCollectIndustry() {
        return collectIndustry;
    }
    public void setCollectIndustry(String collectIndustry) {
        this.collectIndustry = collectIndustry;
    }
    public String getCollectPositive() {
        return collectPositive;
    }
    public void setCollectPositive(String collectPositive) {
        this.collectPositive = collectPositive;
    }
    public String getCollectNegative() {
        return collectNegative;
    }
    public void setCollectNegative(String collectNegative) {
        this.collectNegative = collectNegative;
    }
    public String getCollectProduct() {
        return collectProduct;
    }
    public void setCollectProduct(String collectProduct) {
        this.collectProduct = collectProduct;
    }
    public String getCollectThemes() {
        return collectThemes;
    }
    public void setCollectThemes(String collectThemes) {
        this.collectThemes = collectThemes;
    }
    public String getCollectHashtags() {
        return collectHashtags;
    }
    public void setCollectHashtags(String collectHashtags) {
        this.collectHashtags = collectHashtags;
    }
    public String getPicker() {
        return picker;
    }
    public void setPicker(String picker) {
        this.picker = picker;
    }
    public String getPickerKeyword() {
        if(this.picker != null){
            if(this.picker.equalsIgnoreCase("collectMention")){
                return getCollectMention();
            }else if(this.picker.equalsIgnoreCase("collectCompetitor")){
                return getCollectCompetitor();
            }else if(this.picker.equalsIgnoreCase("collectBrand")){
                return getCollectBrand();
            }if(this.picker.equalsIgnoreCase("collectIndustry")){
                return getCollectIndustry();
            }if(this.picker.equalsIgnoreCase("collectProduct")){
                return getCollectProduct();
            }if(this.picker.equalsIgnoreCase("collectPositive")){
                return getCollectPositive();
            }if(this.picker.equalsIgnoreCase("collectNegative")){
                return getCollectNegative();
            }if(this.picker.equalsIgnoreCase("collectBitly")){
                return getCollectBitly();
            }if(this.picker.equalsIgnoreCase("collectThemes")){
                return getCollectThemes();
            }if(this.picker.equalsIgnoreCase("collectHashtags")){
                return getCollectHashtags();
            }
        }
        return "";
        
    }
    public String getCollectInfluence() {
        return collectInfluence;
    }
    public void setCollectInfluence(String collectInfluence) {
        this.collectInfluence = collectInfluence;
    }
    public String getCollectCompetitor() {
        return collectCompetitor;
    }
    public void setCollectCompetitor(String collectCompetitor) {
        this.collectCompetitor = collectCompetitor;
    }
}
