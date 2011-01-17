// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Category;


public interface CategoryDAO<T extends Category> {
    public List<T> findall() throws SVTException;
    //public T getByName(String name) throws SVTException;
    public T getById(String id) throws SVTException;
    public List findByName(String name) throws SVTException;
    public T getByNameChannelId(String name, String channelId) throws SVTException;
    
    public T addCategory(Category category) throws SVTException;
    public T saveOrUpdate(Category category) throws SVTException;    
}
