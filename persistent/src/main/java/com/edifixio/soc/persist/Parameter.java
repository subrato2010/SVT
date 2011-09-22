// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="Parameter"
 */
public class Parameter  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String parameterId;
    private String parameterCode;
    private String value;
    public String getParameterId() {
        return parameterId;
    }
    public void setParameterId(String parameterId) {
        this.parameterId = parameterId;
    }
    public String getParameterCode() {
        return parameterCode;
    }
    public void setParameterCode(String parameterCode) {
        this.parameterCode = parameterCode;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
 
}
