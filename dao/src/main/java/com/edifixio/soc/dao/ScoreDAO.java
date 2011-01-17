// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Score;

public interface ScoreDAO<T extends Score> {
    public List<T> findall()  throws SVTException;    
    public T add(Score score)  throws SVTException;
}
