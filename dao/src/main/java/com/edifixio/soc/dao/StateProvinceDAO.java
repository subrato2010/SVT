// $Author: subratog $
package com.edifixio.soc.dao;

import java.util.List;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.StateProvince;


public interface StateProvinceDAO<T extends StateProvince> {
    public List<T> findall() throws SVTException;


    public T add(StateProvince stateProvince) throws SVTException;
}