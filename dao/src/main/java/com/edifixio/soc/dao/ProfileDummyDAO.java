package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfileDummy;

public interface ProfileDummyDAO<T extends ProfileDummy> {
    public List<T> findall()  throws SVTException;
    public List<T> getByProfileId(String profileId) throws SVTException;
}
