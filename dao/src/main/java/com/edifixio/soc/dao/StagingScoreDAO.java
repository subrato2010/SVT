// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.StagingScore;

public interface StagingScoreDAO<T extends StagingScore> {
    public List<T> findall()  throws SVTException;
    public T add(StagingScore stagingScore)  throws SVTException;
    
}
