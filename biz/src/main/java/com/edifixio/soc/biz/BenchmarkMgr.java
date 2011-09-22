// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.List;

import com.edifixio.soc.biz.dto.BenchmarkDTO;
import com.edifixio.soc.common.SVTException;

public interface BenchmarkMgr extends BaseMgr{
    public List<BenchmarkDTO> findAll() throws SVTException;
    public List<BenchmarkDTO> findAllActive() throws SVTException;
    public BenchmarkDTO getByName(String benchmarkName) throws SVTException;
    public BenchmarkDTO getById(String benchmarkId) throws SVTException;
}
