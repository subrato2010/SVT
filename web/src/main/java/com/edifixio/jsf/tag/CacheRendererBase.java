package com.edifixio.jsf.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public class CacheRendererBase extends RendererBase {

	private static final String REQUEST = "request";
	private static final String SESSION = "session";
	private static final String APPLICATION = "application";

	public CacheRendererBase() {
	}

	protected Class getComponentClass() {
		return CacheComponent.class;
	}

	
	protected void doEncodeChildren(ResponseWriter writer,
			FacesContext context, UIComponent component) throws IOException {
		CacheComponent cacheComponent = (CacheComponent) component;

		boolean enable = getEnable(cacheComponent);
		String scope = getScope(cacheComponent);
		long refInterval = getRefreshInterval(cacheComponent);
		String key = getCacheId(cacheComponent);

		
		if (getRefreshInterval(cacheComponent) == 0) {
			enable =  false;
		}

		if (enable) {
			Object cachedContent = getFromCache(key, scope, refInterval);

			if (cachedContent == null) {
				writeAndCache(writer, context, key,
						cacheComponent);
			} else {
				writer.write(cachedContent.toString());
			}
		} else {
			writeAndCache(writer, context, key, cacheComponent);
		}
	}

	
	/**
	 * 
	 * @param writer
	 * @param context
	 * @param component
	 * @param key
	 * @param cacheComponent
	 * @throws IOException
	 */
	private void writeAndCache(ResponseWriter writer, FacesContext context,
			String key, CacheComponent cacheComponent)
			throws IOException {
		StringWriter stringWriter = new StringWriter();
		ResponseWriter cachingResponseWriter = writer
				.cloneWithWriter(stringWriter);
		context.setResponseWriter(cachingResponseWriter);
		renderChildren(context, cacheComponent);
		context.setResponseWriter(writer);
		String output = stringWriter.getBuffer().toString();
		writer.write(output);

		// cache it
		cacheContent(output, key, getScope(cacheComponent));
	}

	public boolean getRendersChildren() {
		return true;
	}

	/**
	 * 
	 * @param content
	 * @param key
	 * @param scope
	 */
	private void cacheContent(String content, String key, String scope) {

		Object cachebleObject = new CacheHolder(content, System
				.currentTimeMillis());
		if (scope.equalsIgnoreCase(APPLICATION)) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getApplicationMap().put(key, cachebleObject);
		} else if (scope.equalsIgnoreCase(SESSION)) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put(key, cachebleObject);
		} else if (scope.equalsIgnoreCase(REQUEST)) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getRequestMap().put(key, cachebleObject);
		}
	}

	/**
	 * 
	 * @return
	 */
	private Object getFromCache(String key, String scope, long refreshInterval) {
		Object object = null;
		CacheHolder cachable = (CacheHolder) getCachableFromCache(key, scope);
		if (cachable == null)
			return null;
		else
			object = cachable.getObject();

		if (refreshInterval >= 0 && cachable != null) {

			// is cache period over
			if ((System.currentTimeMillis() - cachable.getTimeStamp()) >= (refreshInterval * 1000)) {
				return null;
			}
		}

		return object;

	}

	/**
	 * 
	 * @param key
	 * @param scope
	 * @return
	 */
	private Object getCachableFromCache(String key, String scope) {
		Object cachebleObject = null;
		if (scope.equalsIgnoreCase(APPLICATION)) {
			cachebleObject = FacesContext.getCurrentInstance()
					.getExternalContext().getApplicationMap().get(key);
		} else if (scope.equalsIgnoreCase(SESSION)) {
			cachebleObject = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap().get(key);
		} else if (scope.equalsIgnoreCase(REQUEST)) {
			cachebleObject = FacesContext.getCurrentInstance()
					.getExternalContext().getRequestMap().get(key);
		}

		return cachebleObject;
	}

	/**
	 * 
	 * @param component
	 * @return
	 */
	public String getCacheId(UIComponent component) {
		return (String)component.getAttributes().get(CacheTag.CACHE_ID);
	}

	/**
	 * 
	 * @param component
	 * @return
	 */
	public String getScope(UIComponent component) {
		return (String)component.getAttributes().get(CacheTag.SCOPE);
	}

	/**
	 * 
	 * @param component
	 * @return
	 */
	public Long getRefreshInterval(UIComponent component) {
		Long rInterval = -1l;
		try{
			String strRefreshInterval = (String)component.getAttributes().get(CacheTag.REFRESH_INTERVAL);
			if (strRefreshInterval != null) {
				rInterval = Long.parseLong(strRefreshInterval.trim());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return rInterval;
	}

	/**
	 * 
	 * @param component
	 * @return
	 */
	public Boolean getEnable(UIComponent component) {
		
		Boolean enable = Boolean.TRUE;
		try{
		String strEnable = (String)component.getAttributes().get(CacheTag.ENABLE);
		if (strEnable != null) {
				enable = Boolean.parseBoolean(strEnable.trim());
			} 
		}catch (Exception e) {
			e.printStackTrace();
			enable = Boolean.TRUE;
		}
		return enable;
	}
	
	/**
	 * 
	 * @author NileshB
	 * 
	 */
	private class CacheHolder {
		private static final long serialVersionUID = 1L;

		private Object object;
		long timeStamp;

		CacheHolder(Object object, long timeStamp) {
			super();
			this.object = object;
			this.timeStamp = timeStamp;
		}

		public Object getObject() {
			return object;
		}

		public void setObject(Object object) {
			this.object = object;
		}

		public long getTimeStamp() {
			return timeStamp;
		}

		public void setTimeStamp(long timeStamp) {
			this.timeStamp = timeStamp;
		}
	}

}