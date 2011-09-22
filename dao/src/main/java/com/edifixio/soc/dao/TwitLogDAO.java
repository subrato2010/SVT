// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.Date;
import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.TwitLog;

public interface TwitLogDAO<T extends TwitLog> {
    public List<T> findall()  throws SVTException;
    public T add(TwitLog twitLog)  throws SVTException;
    public T update(TwitLog twitLog) throws SVTException;
    public T getById(String id) throws SVTException;
    public List<T> findByFrom(String accountId)  throws SVTException;
    public List<T> findByToWhom(String accountId)  throws SVTException;
    public List<T> findByTwitterUsername(String twitterUsername) throws SVTException;
    public List<T> findByTwitterUsername(String twitterUsername, Date date) throws SVTException;
    public T findByTwitterStatusId(long twittStatusId) throws SVTException;
}
