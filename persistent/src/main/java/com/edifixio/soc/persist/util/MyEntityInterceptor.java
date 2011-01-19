// $Author: subratog $
package com.edifixio.soc.persist.util;

import java.io.Serializable;
import java.lang.reflect.Type;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.EmptyInterceptor;

@SuppressWarnings("serial")
public class MyEntityInterceptor extends EmptyInterceptor {

	private static final Log log = LogFactory.getLog(MyEntityInterceptor.class);
    public MyEntityInterceptor(){
        log.debug("constructor called..........");
    }
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {

		log.debug("onSave..................................................................");
 		return true;
	}
}
