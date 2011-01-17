// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfileInfluence;

public interface ProfileInfluenceDAO<T extends ProfileInfluence> {
    public List<T> findall()  throws SVTException;
    public List getByProfilePreferenceId(String id) throws SVTException;
    public T getByProfileInfluenceId(String userId) throws SVTException;
    public T add( ProfileInfluence profileInfluence)  throws SVTException;
    public T update( ProfileInfluence profileInfluence)  throws SVTException;
}
