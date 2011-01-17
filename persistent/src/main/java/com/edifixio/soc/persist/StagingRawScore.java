// $Author: subratog $
package com.edifixio.soc.persist;

import java.io.Serializable;

/**
 * @hibernate.class table="StagingRawScore"
 */
public class StagingRawScore  extends TrackedEntity implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String stagingRawScoreId;    
    private StagingScore stagingScore;
    private String rawScore;
    
    /**
     * @hibernate.property
     * 
     */
    public String getRawScore() {
        return rawScore;
    }
    public void setRawScore(String rawScore) {
        this.rawScore = rawScore;
    }
    /**
     * @hibernate.id generator-class="uuid.hex"
     * 
     */
    public String getStagingRawScoreId() {
        return stagingRawScoreId;
    }
    public void setStagingRawScoreId(String stagingRawScoreId) {
        this.stagingRawScoreId = stagingRawScoreId;
    }
    /**
     * @return Returns the StagingScore.
     * @hibernate.many-to-one cascade="none"
     * @hibernate.column name="stagingScoreId" not-null="true"
     */
    public StagingScore getStagingScore() {
        return stagingScore;
    }
    public void setStagingScore(StagingScore stagingScore) {
        this.stagingScore = stagingScore;
    }
}
