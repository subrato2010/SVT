// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.UserProfileDetail;

public interface UserProfileDetailDAO<T extends UserProfileDetail> {
    public List<T> findall()  throws SVTException;
    public List<T> getByProfilePreferenceId(String id) throws SVTException;
    public T getByProfileDetailId(String id) throws SVTException; 
    public T add( UserProfileDetail userProfileDetail)  throws SVTException;
    public T update( UserProfileDetail userProfileDetail)  throws SVTException;
}
