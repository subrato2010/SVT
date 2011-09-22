// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.Date;
import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.RTOPSchedule;


public interface RTOPScheduleDAO<T extends RTOPSchedule> {
    public List<T> findall() throws SVTException;
    public T getById(String id) throws SVTException;
    public List<T> getByStatus(int status) throws SVTException; 
    public List<T> getByTwitterAccountScheduledTweet(String twitterAccountId) throws SVTException;
    public List<T> getSentTweetsByProfilePrefIdFromDate(String profileId, Date fromDate) throws SVTException;
    public List<T> getByScheduledTweet() throws SVTException;
    public T add(RTOPSchedule rtopSchedule) throws SVTException;
    public T saveOrUpdate(RTOPSchedule rtopSchedule) throws SVTException;
}
