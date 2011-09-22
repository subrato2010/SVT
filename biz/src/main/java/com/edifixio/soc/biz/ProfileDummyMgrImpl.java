// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfileDummy;

public class ProfileDummyMgrImpl extends BaseBizObject implements ProfileDummyMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(ProfileDummyMgrImpl.class);

    public List<ProfileDummy> findAll() throws SVTException {
        return getDaoProvider().getProfileDummyDAO().findall();
    }

    public List<ProfileDummy> getByProfileId(String profileId) throws SVTException {
        return getDaoProvider().getProfileDummyDAO().getByProfileId(profileId);
    }
    

}
