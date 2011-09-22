package com.edifixio.jsf.tag;



import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import javax.faces.webapp.UIComponentTag;

public class CacheTag extends UIComponentTag {

	public static final String CACHE_ID = "cacheId";
	public static final String SCOPE = "scope";
	public static final String REFRESH_INTERVAL = "refreshInterval";
	public static final String ENABLE = "enable";

	private String cacheId;
	private String scope;
	private String refreshInterval = "-1";
	private String enable = "true";

	@Override
	public String getComponentType() {
		return "CacheComponent";
	}

	@Override
	public String getRendererType() {
		return "CacheRenderer";
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void setProperties(UIComponent component) {
		// TODO Auto-generated method stub
		super.setProperties(component);

		CacheComponent cacheComponent = (CacheComponent) component;

		setAttribute(cacheComponent, CACHE_ID, cacheId);
		setAttribute(cacheComponent, SCOPE, scope);
		setAttribute(cacheComponent, REFRESH_INTERVAL, refreshInterval);
		setAttribute(cacheComponent, ENABLE, enable);

	}
	
	/**
	 * 
	 * @param component
	 * @param name
	 * @param value
	 */
	private void setAttribute(UIComponent component, String name, String value){
		
		if(value !=null){
			if(isValueReference(value)){
				FacesContext context=FacesContext.getCurrentInstance();
				Application app=context.getApplication();
				ValueBinding vb=app.createValueBinding(value);
				component.setValueBinding(name, vb);
			}
			else
				component.getAttributes().put(name, value);
		}
	}

	public String getCacheId() {
		return cacheId;
	}

	public void setCacheId(String cacheId) {
		this.cacheId = cacheId;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getRefreshInterval() {
		return refreshInterval;
	}

	public void setRefreshInterval(String refreshInterval) {
		this.refreshInterval = refreshInterval;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	
	
}
