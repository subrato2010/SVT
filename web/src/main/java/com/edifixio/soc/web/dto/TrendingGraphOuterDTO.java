package com.edifixio.soc.web.dto;

public class TrendingGraphOuterDTO 
{
    private TrendingGraphDTO selfGraphDTO;
    private TrendingGraphDTO compGraphDTO;
    
    /**
     * @return the selfGraphDTO
     */
    public TrendingGraphDTO getSelfGraphDTO() {
        return selfGraphDTO;
    }
    /**
     * @param selfGraphDTO the selfGraphDTO to set
     */
    public void setSelfGraphDTO(TrendingGraphDTO selfGraphDTO) {
        this.selfGraphDTO = selfGraphDTO;
    }
    /**
     * @return the compGraphDTO
     */
    public TrendingGraphDTO getCompGraphDTO() {
        return compGraphDTO;
    }
    /**
     * @param compGraphDTO the compGraphDTO to set
     */
    public void setCompGraphDTO(TrendingGraphDTO compGraphDTO) {
        this.compGraphDTO = compGraphDTO;
    }
    
    
}
