// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.StagingRawScore;

public interface StagingRawScoreDAO<T extends StagingRawScore> {
    public List<T> findall()  throws SVTException;
    public T add(StagingRawScore stagingRawScore)  throws SVTException;
    
}
