// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="Company"
 */
public class Company  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String companyId;
    private String companyName;
    private int displayOrder;
    private String keyWordIdentBrand;
    private String keyWordIdentProd;
    private String keyWordIdentIndu;
    private boolean activeStatus;
    
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
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getCompanyId() {
        return companyId;
    }
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    /**
     * @hibernate.property
     * 
     */
    public int getDisplayOrder() {
        return displayOrder;
    }
    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
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
     * 
     */
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    

}
