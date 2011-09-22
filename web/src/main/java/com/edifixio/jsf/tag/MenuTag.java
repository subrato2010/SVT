package com.edifixio.jsf.tag;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;


public class MenuTag extends UIComponentELTag {
    private ValueExpression options;
    private ValueExpression strOptions;
    private ValueExpression paramName;
    
    
    private ValueExpression listStyle;
    private ValueExpression listStyleClass;
    private ValueExpression optionStyle;
    private ValueExpression optionStyleClass;
    private ValueExpression lastOptionStyle;
    


    public String getRendererType() {
        return "MenuComponent";
    }


    public String getComponentType() {
        return "MenuRenderer";
    }


    protected void setProperties(UIComponent component) {
        super.setProperties(component);
        MenuComponent input = null;
        try {
            input = (MenuComponent) component;
        } catch (ClassCastException cce) {
            throw new IllegalStateException(
                    (new StringBuilder())
                            .append("Component ")
                            .append(component.toString())
                            .append(
                                    " not expected type.  Expected: javax.faces.component.UIInput.  Perhaps you're missing a tag?")
                            .toString());
        }
        if (options != null)
            if (!options.isLiteralText())
                input.setValueExpression("options", options);
            else
                input.getAttributes().put("options",
                        options.getExpressionString());
        
        if (strOptions != null)
            if (!strOptions.isLiteralText())
                input.setValueExpression("strOptions", strOptions);
            else
                input.getAttributes().put("strOptions",
                        strOptions.getExpressionString());
        
        if (paramName != null)
            if (!paramName.isLiteralText())
                input.setValueExpression("paramName", paramName);
            else
                input.getAttributes().put("paramName",
                        paramName.getExpressionString());
        
        if (listStyle != null)
            if (!listStyle.isLiteralText())
                input.setValueExpression("listStyle", listStyle);
            else
                input.getAttributes().put("listStyle",
                        listStyle.getExpressionString());
        if (listStyleClass != null)
            if (!listStyleClass.isLiteralText())
                input.setValueExpression("listStyleClass", listStyleClass);
            else
                input.getAttributes().put("listStyleClass",
                        listStyleClass.getExpressionString());
        if (optionStyle != null)
            if (!optionStyle.isLiteralText())
                input.setValueExpression("optionStyle", optionStyle);
            else
                input.getAttributes().put("optionStyle",
                        optionStyle.getExpressionString());
        if (optionStyleClass != null)
            if (!optionStyleClass.isLiteralText())
                input.setValueExpression("optionStyleClass", optionStyleClass);
            else
                input.getAttributes().put("optionStyleClass",
                        optionStyleClass.getExpressionString());
        if (lastOptionStyle != null)
            if (!lastOptionStyle.isLiteralText())
                input.setValueExpression("lastOptionStyle", lastOptionStyle);
            else
                input.getAttributes().put("lastOptionStyle",
                        lastOptionStyle.getExpressionString());
    }


    public void setListStyle(ValueExpression listStyle) {
        this.listStyle = listStyle;
    }


    public void setListStyleClass(ValueExpression listStyleClass) {
        this.listStyleClass = listStyleClass;
    }


    public void setOptionStyle(ValueExpression optionStyle) {
        this.optionStyle = optionStyle;
    }


    public void setOptionStyleClass(ValueExpression optionStyleClass) {
        this.optionStyleClass = optionStyleClass;
    }


    public void setLastOptionStyle(ValueExpression lastOptionStyle) {
        this.lastOptionStyle = lastOptionStyle;
    }
    
    public void setStrOptions(ValueExpression strOptions) {
        this.strOptions = strOptions;
    }
    public void setParamName(ValueExpression paramName) {
        this.paramName = paramName;
    }
    
    
    @Override
    public void release() {
        // TODO Auto-generated method stub
        super.release();
       
        options = null;
        strOptions = null;
        paramName = null;
        listStyle = null;
        listStyleClass = null;
        optionStyle = null;
        optionStyleClass = null;
        lastOptionStyle = null;
    }
    
}
