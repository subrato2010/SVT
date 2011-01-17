// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.TwitterAccount;

public interface TwitterAccountDAO<T extends TwitterAccount> {
    public List<T> findall()  throws SVTException;
    public List<T> getByProfilePreferenceId(String id) throws SVTException;
    public List<T> getByProfilePreferenceIdSELF(String id) throws SVTException;
    public List<T> getByProfilePreferenceIdNOTSELF(String id) throws SVTException;
    public List<T> getByProfilePreferenceIdCompIdNOTSELF(String id, String companyId) throws SVTException;
    public List<T> getByProfileUserIdSELF(String profileUserId) throws SVTException;
    public List<T> getByProfileUserIdNOTSELF(String profileUserId) throws SVTException;
    public List<T> getByProfileUserIdCompIdNOTSELF(String profileUserId, String companyId) throws SVTException;

    public T getTwitterAccountById(String id) throws SVTException; 
}
