// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Product;

public interface ProductDAO<T extends Product> {
    public List<T> findall()  throws SVTException;
    public T add(Product product)  throws SVTException;
     public T getById(String id) throws SVTException;
    public T getByName(String name) throws SVTException;    
}
