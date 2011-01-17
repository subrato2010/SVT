package com.edifixio.soc.biz;

import java.util.List;
import com.edifixio.soc.biz.dto.StateProvinceDTO;
import com.edifixio.soc.common.SVTException;

public interface StateProvinceMgr extends BaseMgr{
    public List<StateProvinceDTO> findAll() throws SVTException;
}
