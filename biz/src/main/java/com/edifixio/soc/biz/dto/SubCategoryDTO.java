// $Author: subratog $
package com.edifixio.soc.biz.dto;


public class SubCategoryDTO extends BaseDTO {
    private String subCategoryId;
    private String subCategoryCode;
    private String subCategoryName;
    private String subCategoryDesc;
    private boolean activeStatus;
    private int displayOrder;
    private String metricsType;
    private CategoryDTO categoryDTO;
    
    public boolean isActiveStatus() {
        return activeStatus;
    }
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
    public int getDisplayOrder() {
        return displayOrder;
    }
    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }
    public String getMetricsType() {
        return metricsType;
    }
    public void setMetricsType(String metricsType) {
        this.metricsType = metricsType;
    }
    public String getSubCategoryCode() {
        return subCategoryCode;
    }
    public void setSubCategoryCode(String subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }
    public String getSubCategoryDesc() {
        return subCategoryDesc;
    }
    public void setSubCategoryDesc(String subCategoryDesc) {
        this.subCategoryDesc = subCategoryDesc;
    }
    public String getSubCategoryId() {
        return subCategoryId;
    }
    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }
    public String getSubCategoryName() {
        return subCategoryName;
    }
    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }
    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }
    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

}
