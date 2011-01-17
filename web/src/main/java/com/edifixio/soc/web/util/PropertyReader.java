package com.edifixio.soc.web.util;

import java.util.ResourceBundle;

public class PropertyReader {
    
    private ResourceBundle bundle;
    
    public PropertyReader(String baseName){
       this.bundle = ResourceBundle.getBundle(baseName);
    }
    
    public String getProperty(String key){
        String value = null;
        if(this.bundle != null){
            value =  bundle.getString(key);
        }
        return value;
    }
     
}
