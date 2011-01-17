// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfileListMaster;

public interface ProfileListMasterDAO<T extends ProfileListMaster> {
    public List<T> findall()  throws SVTException;
    public List getByProfilePreferenceId(String id) throws SVTException;
    public T getByProfilePreferenceIdName(String id, String listName) throws SVTException;
    public T getByProfileListMasterId(String id) throws SVTException;
    public T add( ProfileListMaster profileListMaster)  throws SVTException;
    public T update( ProfileListMaster profileListMaster)  throws SVTException;
}
