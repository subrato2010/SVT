// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Menu;


public interface MenuDAO<T extends Menu> {
    public List<T> findall() throws SVTException;
    //public T getByName(String name) throws SVTException;
    public T getById(String id) throws SVTException;
    public List<T> findByRoleId(String roleId) throws SVTException;
    public List<T> findByRoleId(String roleId, String menuCode) throws SVTException;
    public List<T> findByRoleIdAccountOption(String roleId) throws SVTException;
}
