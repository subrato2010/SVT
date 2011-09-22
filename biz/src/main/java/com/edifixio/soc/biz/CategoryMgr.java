// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;

import com.edifixio.soc.biz.dto.CategoryDTO;
import com.edifixio.soc.common.SVTException;

public interface CategoryMgr extends BaseMgr{
    public List<CategoryDTO> findAll() throws SVTException;
}
