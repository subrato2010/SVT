// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.TrendingGrade;

public interface TrendingGradeDAO<T extends TrendingGrade> {
    public List<T> findall()  throws SVTException;  
    public T getGradeBetweenFromTo(float value) throws SVTException;
}
