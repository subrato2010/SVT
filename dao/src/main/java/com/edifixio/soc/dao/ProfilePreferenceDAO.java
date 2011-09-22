// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfilePreference;

public interface ProfilePreferenceDAO<T extends ProfilePreference> {
    public List<T> findall()  throws SVTException;
    public T getByProfilePreferenceId(String id) throws SVTException;
    public T getByProfileUserId(String userId) throws SVTException;
    public T add( ProfilePreference profilePreference)  throws SVTException;
    public T update( ProfilePreference profilePreference)  throws SVTException;
}
