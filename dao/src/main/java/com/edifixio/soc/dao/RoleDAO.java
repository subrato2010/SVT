// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Role;


public interface RoleDAO<T extends Role> {
    public List<T> findall() throws SVTException;
    public T getById(String id) throws SVTException;
    public T getAdminRole() throws SVTException;
    public T getUserRole() throws SVTException;
}
