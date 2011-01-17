// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Industry;

public interface IndustryDAO<T extends Industry> {
    public List<T> findall()  throws SVTException;
    public T add(Industry industry)  throws SVTException;
     public T getById(String id) throws SVTException;
    public T getByName(String name) throws SVTException;    
}
