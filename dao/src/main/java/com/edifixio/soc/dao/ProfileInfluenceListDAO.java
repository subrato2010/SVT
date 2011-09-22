// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfileInfluenceList;

public interface ProfileInfluenceListDAO<T extends ProfileInfluenceList> {
    public List<T> findall()  throws SVTException;
    public T getByProfileInfluenceId(String userId) throws SVTException;
    public T getByProfInfluIdProfListMastId(String profileInfluenceId, String profileListMasterId) throws SVTException;
    public List getByProfileListMasterId(String id) throws SVTException;
    public T add( ProfileInfluenceList profileInfluenceList)  throws SVTException;
    public T update( ProfileInfluenceList profileInfluenceList)  throws SVTException;
}
