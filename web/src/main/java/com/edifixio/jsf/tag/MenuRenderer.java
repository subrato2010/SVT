package com.edifixio.jsf.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.model.SelectItem;

import com.sun.faces.renderkit.html_basic.HtmlBasicInputRenderer;
import com.sun.faces.util.MessageUtils;

public class MenuRenderer extends HtmlBasicInputRenderer{

    public void encodeBegin(FacesContext context, UIComponent component)
    throws IOException
{
    if(context == null || component == null)
        throw new NullPointerException(MessageUtils.getExceptionMessageString("com.sun.faces.NULL_PARAMETERS_ERROR", new Object[0]));
    else
        return;
}

protected void getEndTextToRender(FacesContext context, UIComponent component, String currentValue)
    throws IOException
{
    ResponseWriter writer = context.getResponseWriter();
    
    Collection<SelectItem> options = null;
    String strOptions = (String)component.getAttributes().get("strOptions");
    
    if(strOptions == null){
        
        Object objOptions = component.getAttributes().get("options");
        
        //if array
        if(objOptions instanceof Object[]){
            options = Arrays.asList((SelectItem[]) objOptions);
        }else{
            options = (Collection<SelectItem>) objOptions;
        }
        
    }
    else{
        options = new ArrayList<SelectItem>();
        String[] stroptions = strOptions.split(",");
        for (int i = 0; i < stroptions.length; i++) {
            options.add(new SelectItem(stroptions[i]));
        }
    }
    String paramName = (String) component.getAttributes().get("paramName");
    
    String style = (String)component.getAttributes().get("style");
    if(style == null)
        style = "";
         
    String styleClass = (String)component.getAttributes().get("styleClass");
    if(styleClass == null)
        styleClass = "menu_main_div";
    
    String listStyle = (String)component.getAttributes().get("listStyle");
    if(listStyle == null)
        listStyle = "";
         
    String listStyleClass = (String)component.getAttributes().get("listStyleClass");
    if(listStyleClass == null)
        listStyleClass = "menu_list_div";
    
    
    String optionStyle = (String)component.getAttributes().get("optionStyle");
    if(optionStyle == null)
        optionStyle = "";
         
    String optionStyleClass = (String)component.getAttributes().get("optionStyleClass");
    if(optionStyleClass == null)
        optionStyleClass = "DropDownEachSubMenu";
    
    String lastOptionStyle = (String)component.getAttributes().get("lastOptionStyle");
    if(lastOptionStyle == null)
        lastOptionStyle = "border-bottom:0px;";
    lastOptionStyle = optionStyle + lastOptionStyle;
    
    String onchange = (String)component.getAttributes().get("onchange");
    onchange = (onchange == null)? "" : onchange;
    
    String onclick = (String)component.getAttributes().get("onclick");
    onclick = (onclick == null)? "" : onclick;
    
    //id
    String id = component.getClientId(context);
    
    //value and label
    String currentLable = null;
    if(currentValue == null ){   
        currentValue = "";
    }
    
    if(options != null){
        for (SelectItem option : options) {  
            if(currentValue.equals(option.getValue())){
                currentLable = option.getLabel();
            }   
        }
        //if value doesn't match with any option, choose first option
        if(currentLable == null){
            SelectItem firstOption = options.iterator().next();
            currentLable = firstOption.getLabel();
            currentValue = firstOption.getValue().toString();
        }
    }
    else
        currentLable = currentValue;
 
    
    if(currentValue == null){
        if(options != null && !options.isEmpty()){
            //if no value select first option
            currentValue = options.iterator().next().getValue().toString();
        }else{
            currentValue = "";
        }
    }
    
    {
        writer.write("<input id=\"" + id + "_hidden\" type=\"hidden\" name=\"" + id + "\" value=\"" + currentValue + "\" onchange=\"" + onchange + "\"/>");
        writer.write("<input id=\"" + id + "_init\" type=\"hidden\" name=\"" + id + "\" value=\"\" />");
        if(paramName != null){
            writer.write("<input id=\"" + id + "_param\" type=\"hidden\" name=\"" + paramName + "\" value=\"" + currentValue + "\" />");
        }
        
        if(options != null){
            
        }
        writer.write("<div class=\"" + styleClass + "\" style= \"" + style + "\" id=\"" + id + "_main\" onclick=\"toggleList('" + id+ "');\" >"+ currentLable +"</div>");
        writer.write("<div id=\"" + id + "_list\" class=\"" + listStyleClass + "\" style=\"" + listStyle + "\" >");

        if(options != null){
            int i = 0;
            for (SelectItem option : options) {
                i++;
                if(i == options.size()){
                    writer.write("<div onclick=\"" + onclick + "selectMe('" + option.getLabel() + "','" + option.getValue() + "', '" + id + "');\" class=\"" + optionStyleClass + "\" style=\"" + lastOptionStyle + "\">" + option.getLabel() + "</div>");
                }else{
                    writer.write("<div onclick=\"" + onclick + "selectMe('" + option.getLabel() + "','" + option.getValue() + "', '" + id + "');\" class=\"" + optionStyleClass + "\" style=\"" + optionStyle + "\" >" + option.getLabel() + "</div>");
                }
            }
        }   
        writer.write("</div>");
    }
    
}

}
