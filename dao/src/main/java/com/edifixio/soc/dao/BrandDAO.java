// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Brand;


public interface BrandDAO<T extends Brand> {
    public List<T> findall() throws SVTException;
    public T getByName(String name) throws SVTException;   
}
