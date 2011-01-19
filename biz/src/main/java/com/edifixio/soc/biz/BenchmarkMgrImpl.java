package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.dto.BenchmarkDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Benchmark;

public class BenchmarkMgrImpl extends BaseBizObject implements BenchmarkMgr{
    private static Log log = LogFactory.getLog(BenchmarkMgrImpl.class);

	public List<BenchmarkDTO> findAllActive() throws SVTException {
        // Using spring to get the dao mgr
        return getBenchmarkDTOList(getDaoProvider().getBenchmarkDAO().findall());
	}

    public List<BenchmarkDTO> findAll() throws SVTException {
        // Using spring to get the dao mgr
        return getBenchmarkDTOList(getDaoProvider().getBenchmarkDAO().findall());
    }

    public BenchmarkDTO getById(String benchmarkId) throws SVTException {
        BenchmarkDTO dto = new BenchmarkDTO();
        Benchmark benchmark = getDaoProvider().getBenchmarkDAO().getById(benchmarkId);
        copyPropertiesQuietly(dto,benchmark);
        return dto;
    }

    public BenchmarkDTO getByName(String benchmarkName) throws SVTException {
        BenchmarkDTO dto = new BenchmarkDTO();
        Benchmark benchmark = getDaoProvider().getBenchmarkDAO().getByName(benchmarkName);
        copyPropertiesQuietly(dto,benchmark);
        return dto;
    }
    
	private List<BenchmarkDTO> getBenchmarkDTOList(List<Benchmark> benchmarks) {
		List<BenchmarkDTO> benchMarkDTOs = new ArrayList<BenchmarkDTO>();
		for(Benchmark benchmark : benchmarks){
            BenchmarkDTO dto = new BenchmarkDTO();
		copyPropertiesQuietly(dto,benchmark);
        benchMarkDTOs.add(dto);
		}
		return benchMarkDTOs;
	}

}
