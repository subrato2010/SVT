package com.edifixio.soc.web.dto;


public class TwitterCalculatorChannelPerformanceProfileActionDTO {   
    
    private TwitterCalculatorProfileActionDTO twitterCalculatorProfileActionDTO;
    private TwitterCalculatorChlPerfDTO twitterCalculatorChlPerfDTO;
    
    public TwitterCalculatorProfileActionDTO getTwitterCalculatorProfileActionDTO() {
        return twitterCalculatorProfileActionDTO;
    }
    
    public void setTwitterCalculatorProfileActionDTO(TwitterCalculatorProfileActionDTO twitterCalculatorProfileActionDTO) {
        this.twitterCalculatorProfileActionDTO = twitterCalculatorProfileActionDTO;
    }
    
    public TwitterCalculatorChlPerfDTO getTwitterCalculatorChlPerfDTO() {
        return twitterCalculatorChlPerfDTO;
    }
    
    public void setTwitterCalculatorChlPerfDTO(TwitterCalculatorChlPerfDTO twitterCalculatorChlPerfDTO) {
        this.twitterCalculatorChlPerfDTO = twitterCalculatorChlPerfDTO;
    }    
}
