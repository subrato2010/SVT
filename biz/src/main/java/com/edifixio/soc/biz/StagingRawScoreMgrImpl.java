// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.dto.StagingRawScoreDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.StagingRawScore;

public class StagingRawScoreMgrImpl extends BaseBizObject implements StagingRawScoreMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(StagingRawScoreMgrImpl.class);

    public List<StagingRawScoreDTO> findAll() throws SVTException {
        // Using spring to get the dao mgr
        log.debug("Successful in connecting to Biz layer");
        return getStagingRawScoreList(getDaoProvider().getStagingRawScoreDAO().findall());
    }
    public void add(StagingRawScoreDTO dto) throws SVTException {
        getDaoProvider().getStagingRawScoreDAO().add(getStagingRawScore(dto));
       
    }

    private StagingRawScore getStagingRawScore(StagingRawScoreDTO dto) {
        StagingRawScore sdto = new StagingRawScore();
        sdto.setRawScore(dto.getRawScore());
        sdto.setUpdatedBy(dto.getUpdatedBy());
        sdto.setUpdatedOn(dto.getUpdatedOn()); 
        
        sdto.setStagingScore(dto.getStagingScore());

        
        return sdto;
    }
    private List<StagingRawScoreDTO> getStagingRawScoreList(List<StagingRawScore> srsdtos) {
        
        List<StagingRawScoreDTO> dtos = new ArrayList<StagingRawScoreDTO>();
        
        for(StagingRawScore srsdto: srsdtos){
            StagingRawScoreDTO dto = new StagingRawScoreDTO();
            dto.setRawScore(srsdto.getRawScore());
            dtos.add(dto);
        }
        return dtos;
    }
    public void createUsers(List<UserProfileDetailDTO> bizDTOs)
    {
        
    }
}
