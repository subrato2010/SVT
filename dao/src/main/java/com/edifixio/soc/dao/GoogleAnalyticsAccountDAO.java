// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.GoogleAnalyticsAccount;

public interface GoogleAnalyticsAccountDAO<T extends GoogleAnalyticsAccount> {
    public List<T> findall()  throws SVTException;
    public GoogleAnalyticsAccount getByGoogleAnalyticsAccountId(String id) throws SVTException;
    public List<T> getByProfilePreferenceId(String profilePreferenceId) throws SVTException;
    public T add(GoogleAnalyticsAccount googleAnalyticsAccount)  throws SVTException;
    public T update(GoogleAnalyticsAccount googleAnalyticsAccount) throws SVTException;
}
