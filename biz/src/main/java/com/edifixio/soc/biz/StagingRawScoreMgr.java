// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;
import com.edifixio.soc.biz.dto.StagingRawScoreDTO;
import com.edifixio.soc.common.SVTException;

public interface StagingRawScoreMgr extends BaseMgr{
    public List<StagingRawScoreDTO> findAll() throws SVTException;
    public void add(StagingRawScoreDTO dto) throws SVTException;
}
