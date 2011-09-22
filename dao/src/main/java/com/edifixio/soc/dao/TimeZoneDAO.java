// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.TimeZone;


public interface TimeZoneDAO<T extends TimeZone> {
    public List<T> findall() throws SVTException;
    public T getById(String id) throws SVTException;
}
