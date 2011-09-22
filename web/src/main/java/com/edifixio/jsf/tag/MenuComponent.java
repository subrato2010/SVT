package com.edifixio.jsf.tag;

import javax.el.ValueExpression;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;


public class MenuComponent extends UIInput{
    
    private Object submittedValue;
    private boolean localValueSet;
    
    public String getFamily()
    {
        return "menu";
    }
    
    public Object getSubmittedValue()
    {
        return submittedValue;
    }

    public void setSubmittedValue(Object obj)
    {
        submittedValue = obj;
    }

    public void setValue(Object obj)
    {
        super.setValue(obj);
        setLocalValueSet(true);
    }

    public void resetValue()
    {
        setValue(null);
        setSubmittedValue(null);
        setLocalValueSet(false);
        setValid(true);
    }

    public boolean isLocalValueSet()
    {
        return localValueSet;
    }

    public void setLocalValueSet(boolean flag)
    {
        localValueSet = flag;
    }

    public void updateModel(FacesContext facescontext)
    {
        if(facescontext == null)
            throw new NullPointerException();
        if(!isValid() || !isLocalValueSet())
            return;
        ValueExpression valueexpression = getValueExpression("value");
        if(valueexpression != null){
            try
            {
                valueexpression.setValue(facescontext.getELContext(), getLocalValue());
                setValue(null);
                setLocalValueSet(false);
                return;
            }
            catch(Exception exception)
            {
               exception.printStackTrace();
            }
        }
    }
}
