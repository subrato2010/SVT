// $Author: subratog $
package com.edifixio.soc.biz.dto;

import com.edifixio.soc.persist.StagingScore;

public class StagingRawScoreDTO extends BaseDTO{
 
    private String stagingRawScoreId;    
    private StagingScore stagingScore;
    private String rawScore;
    public String getRawScore() {
        return rawScore;
    }
    public void setRawScore(String rawScore) {
        this.rawScore = rawScore;
    }
    public String getStagingRawScoreId() {
        return stagingRawScoreId;
    }
    public void setStagingRawScoreId(String stagingRawScoreId) {
        this.stagingRawScoreId = stagingRawScoreId;
    }
    public StagingScore getStagingScore() {
        return stagingScore;
    }
    public void setStagingScore(StagingScore stagingScore) {
        this.stagingScore = stagingScore;
    }    

 }
