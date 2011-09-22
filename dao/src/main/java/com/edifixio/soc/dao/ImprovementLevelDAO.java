// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ImprovementLevel;

public interface ImprovementLevelDAO<T extends ImprovementLevel> {
    public List<T> findall()  throws SVTException;
    public T add(ImprovementLevel improvementLevel)  throws SVTException;
     public T getById(String id) throws SVTException;
    public T getByName(String name) throws SVTException;    
}
