// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ImprovementLevel;

public interface ImprovementLevelMgr extends BaseMgr{
    public List<ImprovementLevel> findAll() throws SVTException;
    public ImprovementLevel getById(String improvementLevelId) throws SVTException;
}
