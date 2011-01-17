package com.edifixio.soc.biz;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfileDummy;

public interface ProfileDummyMgr {
    List<ProfileDummy> findAll() throws SVTException;
    List<ProfileDummy> getByProfileId(String profileId) throws SVTException;
}
