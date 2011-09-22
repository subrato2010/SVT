package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.dto.StateProvinceDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.StateProvince;

public class StateProvinceMgrImpl extends BaseBizObject implements StateProvinceMgr{
    private final static Log log = LogFactory.getLog(StateProvinceMgrImpl.class);
    public List<StateProvinceDTO> findAll() throws SVTException {
        return setStateProvinceDTO(getStateProvinceDAO().findall());
     }

    private List<StateProvinceDTO> setStateProvinceDTO(List<StateProvince> sps) {
        List<StateProvinceDTO> dtos = new ArrayList<StateProvinceDTO>();
        for(StateProvince sp: sps ){
            StateProvinceDTO dto = new StateProvinceDTO();
            quietlyCopyProperties(dto, sp);
            dtos.add(dto);
        }
        return dtos;
    }

    public void setCurrentBenchmarkId(String currentBenchmarkId) {
        // TODO Auto-generated method stub
        
    }
}
