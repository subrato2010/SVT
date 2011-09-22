/*
 * @author: subrato
 */
package com.edifixio.soc.web.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import com.edifixio.soc.biz.dto.AlertPopupDTO;
import com.edifixio.soc.biz.dto.RTOPScheduleDTO;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.OutboundMetricsDummy;
import com.edifixio.soc.web.controllers.JSONController;
import com.edifixio.soc.web.controllers.TwitterControllerConstants;
import com.edifixio.soc.web.dto.BaseActionTwitterDTO;
import com.edifixio.soc.web.dto.ListItemDTO;
import com.edifixio.soc.web.dto.OptimizeActionDTO;
import com.edifixio.soc.web.dto.TwitterActionsAjaxDTO;
import com.edifixio.soc.web.dto.TwitterActionsDMToReturnDTO;
import com.edifixio.soc.web.dto.TwitterActionsDTO;
import com.edifixio.soc.web.dto.TwitterActionsFavouritesDTO;
import com.edifixio.soc.web.dto.TwitterActionsInfluencersDTO;
import com.edifixio.soc.web.dto.TwitterActionsInfluencersListDTO;
import com.edifixio.soc.web.dto.TwitterActionsRTThanksDTO;
import com.edifixio.soc.web.dto.TwitterCalculatorChannelPerformanceProfileActionDTO;
import com.edifixio.soc.web.dto.TwitterCalculatorProfileActionDTO;
import com.edifixio.soc.web.dto.TwitterTextSuggestionDTO;
import com.edifixio.soc.web.dto.TwitterTokens;
import com.edifixio.soc.web.dto.TwitterTrendingSuggestionDTO;
import com.edifixio.soc.web.dto.TwitterTrendingSuggestionResponseDTO;
import com.edifixio.soc.web.dto.TwitterActionsDTO.ActionCount;
import com.edifixio.soc.web.dto.TwitterActionsDTO.ActionsTwitterAccounts;
import com.edifixio.soc.web.dto.TwitterActionsFavouritesDTO.ActionsFavourites;
import com.edifixio.soc.web.dto.TwitterActionsInfluencersDTO.ActionsInfluencers;
import com.edifixio.soc.web.util.FilterSequence;
import com.edifixio.soc.web.util.TrendingGradeFilters;
import com.google.gson.Gson;


public class RTOPHandler extends JSONController
{
    private final static Log log = LogFactory.getLog(RTOPHandler.class);

    private List<ActionsTwitterAccounts> twitter_accounts;
    private ActionsInfluencers actionInfluencersObj;
    private TwitterActionsInfluencersDTO twitterActionsInfluencerDto;
    private TwitterActionsInfluencersListDTO twitterActionsInfluencersListDTO;
    private TwitterActionsFavouritesDTO twitterActionsFavouritesDto;
    private TwitterActionsRTThanksDTO twitterActionsRTThanksDto;
    private TwitterActionsDMToReturnDTO twitterActionsDMToReturnDTO;
    private String firstActionInfluencerTwitterAccount;
    
    private TwitterTextSuggestionDTO twitterTextSuggestionDTO;
    private List<TwitterTokens> textSuggestionTokens;
    private String trendingGrades = "";

    private List<ListItemDTO> customerHandlerLists;
    
    private boolean tokenAvailable;
    
    private boolean trendingGradeSet = false;
    
    private static final String POPULATE_TWT_TOKEN = "populateTokenHidden";
    private static final String POPULATE_HAPPENING_TOKEN = "viewTextSuggestion";
    
    private String tokenCount;
    private Date scheduleDate;
    private String scheduleTime;
    
    private List<String> keywordByProfilePreferenceList;
    
    /**
     * This method is invoked when the user clicks on the 'Optimize' button for Action
     * @throws Exception
     */
    public void optimizeAction(ActionEvent ae) throws Exception
    {        
        if(ae != null) {
            String actionId =  getParameter("actionId");  // getting the type of action (passed as parameter)       
            setActionId(actionId);
        }
                
        if(actionId != null && actionId.equals("1")){ // Influencers to Follow
            optimizeActionInfluencers(ae, actionId);
        } else if(actionId != null && actionId.equals("2")){ //Tweets to Favorite
            optimizeActionFavourites(ae, actionId);
        } else if(actionId != null && actionId.equals("3")){ //Influencers to List
            optimizeActionInfluencersToList(ae, actionId);
        } else if(actionId != null && actionId.equals("4")){ // Retweet to Thank
            optimizeActionRTThanks(ae, actionId);
        } else if(actionId != null && actionId.equals("9")){ // DM to Return
            optimizeActionDMToReturn(ae, actionId);
        }
    }

    /**
     * combo API to use for the grading, sentiment + instances
     * Param1: String(Sentence) for getting sentiment counts
     * Param2: String(keyword) search for occurrence
     * @param textToSearch
     * @return
     * @throws SVTException
     */
    public TwitterTrendingSuggestionResponseDTO getTwitterTrendingTextSuggestion(String fullText, String textToSearch) throws SVTException
    {
        String urlToHit = getDatashiftAPIURL("queryrecommend", null);
        TwitterTrendingSuggestionResponseDTO rdto = new TwitterTrendingSuggestionResponseDTO();        
       
        if(urlToHit != null && urlToHit.length() > 0)
        {
            TwitterTrendingSuggestionDTO dto = new TwitterTrendingSuggestionDTO();
            dto.setQuery(fullText); // Parameter1 : "Well this is a nice test message including a #test"
            dto.setText(textToSearch); // Parameter2 "Social"
            
            //convert java object to JSON
            Gson gson = new Gson(); // json-1.7.1
            String obj = gson.toJson(dto);
            System.out.println(urlToHit + "::" + obj);
            String json = postToURL(urlToHit, obj);
            
           //convert JSON into java object
           rdto = gson.fromJson(json, TwitterTrendingSuggestionResponseDTO.class);
            
        }        
       return rdto; 
    }

    public TwitterTextSuggestionDTO getTwitterTextSuggestion(String textToSearch) throws SVTException
    {
        String urlTextToSearch = getDatashiftAPIURL("textsuggestion", null);
        TwitterTextSuggestionDTO dto = new TwitterTextSuggestionDTO();
       
        if(urlTextToSearch != null && urlTextToSearch.length() > 0)
        {
            urlTextToSearch += textToSearch;
            System.out.println("urlTextToSearch ::: "+urlTextToSearch);
            String json = readFromURL(urlTextToSearch);
            Gson gson = new Gson(); // json-1.7.1
            //convert JSON into java object
            dto = gson.fromJson(json, TwitterTextSuggestionDTO.class);            
        }        
       return dto; 
    }
    
    /***
     * 
     * This method is used to get the text selected by the user in 'What's Happening' section
     * This text would be sent to DataShift 'queryrecommend' api as query string
     *
     * @param ae
     * @throws Exception
     * 
     ****/
    
    public void viewTextSuggestion(ActionEvent ae) throws Exception
    {
        String suggestionTokenAction = getParameter("suggestionTokenAction");
        
        if(suggestionTokenAction != null && suggestionTokenAction.equalsIgnoreCase(POPULATE_HAPPENING_TOKEN))
        {
            String index = getParameter("indexClk");
            String queryText = getParameter("textSelected_"+index);
            String textSelectedForGrade = getParameter("textSelectedForGrade_"+index);
            
            if(queryText !=null && queryText.trim().length() > 0 && textSelectedForGrade !=null && textSelectedForGrade.trim().length() > 0)
            {
                
                String trendingGrade = "";
                
                //TwitterTextSuggestionDTO suggestionDTO = getTwitterTextSuggestion(queryText.trim());
                TwitterTrendingSuggestionResponseDTO tsDto = getTwitterTrendingTextSuggestion(queryText.trim(), textSelectedForGrade.trim());
                
                trendingGrade = calculateTweetTrendingGrade(textSelectedForGrade.trim(), tsDto, queryText);
                setTrendingGrades(trendingGrade);
                
                setTrendingGradeSet(true);
                
                if(tsDto != null)
                {
                    //setTwitterTextSuggestionDTO(suggestionDTO);
                    List<TwitterTokens> twitterTokens = new ArrayList<TwitterTokens>();
                    //twitterTokens = suggestionDTO.getTokens();
                    twitterTokens = tsDto.getQuery();
                    setTextSuggestionTokens(twitterTokens);
                                        
                    if(twitterTokens != null && twitterTokens.size() > 0)
                    {
                        setTokenAvailable(true);
                    }
                    else
                    {
                        setTokenAvailable(false);
                    }
                }
            }
            else
            {
                System.out.println("*********** Empty Query text for suggestion ************");
            }
        }
        
        else if(suggestionTokenAction != null && suggestionTokenAction.equalsIgnoreCase(POPULATE_TWT_TOKEN))
        {
            String populateTokenText = getParameter("populateTokenText");
            
            if(populateTokenText !=null && populateTokenText.trim().length() > 0)
            {
                //TwitterTextSuggestionDTO suggestionDTO = getTwitterTextSuggestion(populateTokenText.trim());
                
                TwitterTrendingSuggestionResponseDTO tsDto = getTwitterTrendingTextSuggestion(populateTokenText.trim(), populateTokenText.trim());
                
                if(tsDto != null)
                {
                    //setTwitterTextSuggestionDTO(suggestionDTO);
                    List<TwitterTokens> twitterTokens = new ArrayList<TwitterTokens>();
                    twitterTokens = tsDto.getTokens();
                    
                    if(twitterTokens!=null && twitterTokens.size() > 0)
                    {
                        setTokenCount(""+twitterTokens.get(0).getCount());
                    }
                    else
                    {
                        setTokenCount(""+0);
                    }
                    
                }
            }
            else
            {
                System.out.println("*********** Empty Query text for suggestion ************");
            }
        }
    }

    /***
     * 
     * This method is used to calculate the value of trending grade for 'What's Happening' section
     * @return trendingGrade
     * @param queryTextForGrade
     * @param tsDto 
     * @param queryText 
     * @throws SVTException
     * 
     ***/
    
    private String calculateTweetTrendingGrade(String queryTextForGrade, TwitterTrendingSuggestionResponseDTO tsDto, String queryText) throws SVTException 
    {
        
        String trendingGrade = "";
        
        System.out.println("----------- queryTextForGrade :: "+queryTextForGrade);
        System.out.println("----------- queryText :: "+queryText);
        
        int countHashTags = calculateTrendingTags(queryTextForGrade, TrendingGradeFilters.HASHTAGS);
        int countBitlyTags = calculateTrendingTags(queryTextForGrade.toLowerCase(), TrendingGradeFilters.BITLY);
        int countReferenceTags = calculateTrendingTags(queryTextForGrade, TrendingGradeFilters.REFERENCE);
        int countKeywords = calculateKeywords(queryTextForGrade, tsDto, queryText);
        
        float totalGrade = ((countHashTags * TrendingGradeFilters.HASHTAG_CONTAINS) + (countBitlyTags * TrendingGradeFilters.BITLY_CONTAINS) + (countReferenceTags * TrendingGradeFilters.REFERENCE_CONTAINS) + (countKeywords * TrendingGradeFilters.KEYWORDS_CONTAINS));
        
        trendingGrade = getTrendingGradeMgr().getGradeBetweenFromTo(totalGrade).getGradeValue();
        
        System.out.println("----------- trendingGrade :: "+trendingGrade);
        
        return trendingGrade;
    }
    
    
    /***
     * 
     * This method is used to count the instances of keywords present in the query for 'What's Happening' section
     *  
     * @return keywordCount
     * @param queryTextForGrade
     * @param tsDto 
     * @param queryText 
     * @throws SVTException
     * 
     ***/
    
    private int calculateKeywords(String queryTextForGrade, TwitterTrendingSuggestionResponseDTO tsDto, String queryText) throws SVTException
    {
        int keywordCount = 0;
        
        if(tsDto != null)
        {
            List<TwitterTokens> tokens = tsDto.getTokens();
            
            if(tokens != null && tokens.size() > 0)
            {
                keywordCount = calculateTrendingTags(queryTextForGrade, queryText);
            }
        }
        
        return keywordCount;
    }

    /***
     * 
     * This method is used to count the number of occurrences of various types of tags. 'searchFor' is the type of tag to be searched
     * @return countHashTags
     * @param queryTextForGrade, searchFor
     * @throws SVTException
     * 
     ***/
    

    private int calculateTrendingTags(String queryTextForGrade, String searchFor)
    {
        
        int len = searchFor.length();
        int countHashTags = 0;
        
        if (len > 0)
        {  
            int start = queryTextForGrade.indexOf(searchFor);
            while (start != -1)
            {
                countHashTags++;
                start = queryTextForGrade.indexOf(searchFor, start+len);
            }
        }
        
        return countHashTags;
   }
   

    /**
     * This method is used to get the list of possible actions along-with flame/star count in ROI Optimization
     * @return optimizeActionList
     * @throws Exception 
     * 
     **/
    
    public List<OptimizeActionDTO> getOptimizeActionList() throws Exception{   
        System.out.println("OptimizeActionDTOs is: " + (getOptimizeActionDTOs() == null ? "null" : "not null"));
        if(getOptimizeActionDTOs() != null) {
            return getOptimizeActionDTOs();
        }
        
        if(StringUtils.isNotBlank(getParameter("actionId"))) {
            setActionId(getParameter("actionId"));
        }
        
        List<OptimizeActionDTO> optimizeActionList = new ArrayList<OptimizeActionDTO>();        
        String json = readFromURL(getDatashiftAPIURL("actions", getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME)));
        String json1 = readFromURL(getDatashiftAPIURL("actions", null));

//        json1 = getSampleJSON("action.txt");
//        if(getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME).equalsIgnoreCase("neel8100")){
//            json = getSampleJSON("handleactionneel8100.txt");
//        }else if(getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME).equalsIgnoreCase("subrato9009")){
//            json = getSampleJSON("handleactionsubrato9009.txt");
//        }
        
        Gson gson = new Gson(); // json-1.7.1
        
        //Store accountList (getting from rtop API, profileLevel)
        //convert JSON into java object
        TwitterActionsDTO obj1 = gson.fromJson(json1, TwitterActionsDTO.class);
        if(obj1 != null) {
            setTwitter_accounts(getCustomerHandler(obj1.getTwitter_accounts(),obj1));    
        }        
        
        //convert JSON into java object
        TwitterActionsDTO obj = gson.fromJson(json, TwitterActionsDTO.class);
        if( obj != null && obj.getActions() != null) {
            obj.setTotal(obj.getActions()); // non-standard JSON structure (Tim please change this)
        }         
        
        if(obj!= null && obj.getTotal() != null) {
            OptimizeActionDTO optimizeActionDTO = new OptimizeActionDTO();
  
            if(StringUtils.isBlank(getActionId()) & StringUtils.isBlank(getParameter("actionId"))) {
                setProfileAlertFromBackendProcess(obj);    
            }             
            
            if(obj.getTotal().getInfluencers() > 0) {                
                optimizeActionDTO.setPageWidth(690);
                optimizeActionDTO.setPageHeight(355);
                optimizeActionDTO.setPageLeft(324);
                optimizeActionDTO.setPageTop(220);
                optimizeActionDTO.setJspPageToDisplay("influFollowAlert.jsp");                
                optimizeActionDTO.setTitleBarText("Influencers to Follow");
                optimizeActionDTO.setAsOfPerformanceDate(new Date());
                optimizeActionDTO.setLabel(obj.getTotal().getInfluencers() + " Influencer(s) to Follow");
                optimizeActionDTO.setActionId("1");//Influencers to Follow
                
                if(obj.getTotal().getInfluencersToFollow() != null) {
                    optimizeActionDTO.setActionStarCount(obj.getTotal().getInfluencersToFollow().getActionStarCount());
                    optimizeActionDTO.setActionFlameCount(obj.getTotal().getInfluencersToFollow().getActionFlameCount());
                } else {
                    //dummy data, should not come here (mismatch with backendprocess and RTOP API
                    optimizeActionDTO.setActionStarCount(0);
                    optimizeActionDTO.setActionFlameCount(2);
                }
                optimizeActionDTO.setImageTagScript(getImageJSTag(optimizeActionDTO.getActionFlameCount(), optimizeActionDTO.getActionStarCount()));
                optimizeActionList.add(optimizeActionDTO);                
            }                        
            
            if(obj.getTotal().getInfluencers_to_list() > 0) {
                optimizeActionDTO = new OptimizeActionDTO();
                optimizeActionDTO.setPageWidth(820);
                optimizeActionDTO.setPageHeight(320);
                optimizeActionDTO.setPageLeft(180);
                optimizeActionDTO.setPageTop(220);
                optimizeActionDTO.setJspPageToDisplay("addToListAlert.jsp");                
                optimizeActionDTO.setTitleBarText("Add to List");
                optimizeActionDTO.setAsOfPerformanceDate(new Date());
                optimizeActionDTO.setLabel(obj.getTotal().getInfluencers_to_list() + " Influencer(s) to List");  
                optimizeActionDTO.setActionId("3");//Influencers to List
                
                if(obj.getTotal().getInfluencersToList() != null){
                    optimizeActionDTO.setActionStarCount(obj.getTotal().getInfluencersToList().getActionStarCount());
                    optimizeActionDTO.setActionFlameCount(obj.getTotal().getInfluencersToList().getActionFlameCount());
                }else{
                    //dummy data, should not come here (mismatch with backendprocess and RTOP API
                    optimizeActionDTO.setActionStarCount(0);
                    optimizeActionDTO.setActionFlameCount(2);
                }
                optimizeActionDTO.setImageTagScript(getImageJSTag(optimizeActionDTO.getActionFlameCount(), optimizeActionDTO.getActionStarCount()));                
                optimizeActionList.add(optimizeActionDTO);
            }
            
            if(obj.getTotal().getFavourites() > 0) {
                optimizeActionDTO = new OptimizeActionDTO();
                optimizeActionDTO.setPageWidth(820);
                optimizeActionDTO.setPageHeight(320);
                optimizeActionDTO.setPageLeft(240);
                optimizeActionDTO.setPageTop(220);
                optimizeActionDTO.setJspPageToDisplay("tweetsFavoriteAlert.jsp");                
                optimizeActionDTO.setTitleBarText("Tweets to favorite");
                optimizeActionDTO.setAsOfPerformanceDate(new Date());
                optimizeActionDTO.setLabel(obj.getTotal().getFavourites() + " Tweet(s) to Favorite");  
                optimizeActionDTO.setActionId("2");//Tweets to favorite
               
                if(obj.getTotal().getTweetsToFavorite() != null){
                    optimizeActionDTO.setActionStarCount(obj.getTotal().getTweetsToFavorite().getActionStarCount());
                    optimizeActionDTO.setActionFlameCount(obj.getTotal().getTweetsToFavorite().getActionFlameCount());
                }else{
                    //dummy data, should not come here (mismatch with backendprocess and RTOP API
                    optimizeActionDTO.setActionStarCount(0);
                    optimizeActionDTO.setActionFlameCount(2);
                }
                optimizeActionDTO.setImageTagScript(getImageJSTag(optimizeActionDTO.getActionFlameCount(), optimizeActionDTO.getActionStarCount()));
                optimizeActionList.add(optimizeActionDTO);
            }
            
            if(obj.getTotal().getRetweets() > 0) {
                optimizeActionDTO = new OptimizeActionDTO();                
                optimizeActionDTO.setPageWidth(930);
                optimizeActionDTO.setPageHeight(320);
                optimizeActionDTO.setPageLeft(150);
                optimizeActionDTO.setPageTop(220);
                optimizeActionDTO.setJspPageToDisplay("RTThanks.jsp");                
                optimizeActionDTO.setTitleBarText("RT (Retweets) to Thank");                
                optimizeActionDTO.setAsOfPerformanceDate(new Date());
                optimizeActionDTO.setLabel(obj.getTotal().getRetweets() + " Retweet(s) to Thank");  
                optimizeActionDTO.setActionId("4");//Retweets to Thank
               
                if(obj.getTotal().getRtToThanks() != null){
                    optimizeActionDTO.setActionStarCount(obj.getTotal().getRtToThanks().getActionStarCount());
                    optimizeActionDTO.setActionFlameCount(obj.getTotal().getRtToThanks().getActionFlameCount());
                }else{
                    //dummy data, should not come here (mismatch with backendprocess and RTOP API
                    optimizeActionDTO.setActionStarCount(0);
                    optimizeActionDTO.setActionFlameCount(2);
                }
                optimizeActionDTO.setImageTagScript(getImageJSTag(optimizeActionDTO.getActionFlameCount(), optimizeActionDTO.getActionStarCount()));
                optimizeActionList.add(optimizeActionDTO);
            }
            
            if(obj.getTotal().getDmtoreturn() > 0) {
                optimizeActionDTO = new OptimizeActionDTO();
                optimizeActionDTO.setPageWidth(820);
                optimizeActionDTO.setPageHeight(320);
                optimizeActionDTO.setPageLeft(240);
                optimizeActionDTO.setPageTop(220);
                optimizeActionDTO.setJspPageToDisplay("DMToReturn.jsp");                
                optimizeActionDTO.setTitleBarText("Return DM");
                optimizeActionDTO.setAsOfPerformanceDate(new Date());
                optimizeActionDTO.setLabel(obj.getTotal().getDmtoreturn() + " DM to Return");  
                optimizeActionDTO.setActionId("9");//DM to Return

                if(obj.getTotal().getDmToReturn() != null){
                    optimizeActionDTO.setActionStarCount(obj.getTotal().getDmToReturn().getActionStarCount());
                    optimizeActionDTO.setActionFlameCount(obj.getTotal().getDmToReturn().getActionFlameCount());
                }else{
                    //dummy data, should not come here (mismatch with backendprocess and RTOP API
                    optimizeActionDTO.setActionStarCount(0);
                    optimizeActionDTO.setActionFlameCount(2);
                }
                optimizeActionDTO.setImageTagScript(getImageJSTag(optimizeActionDTO.getActionFlameCount(), optimizeActionDTO.getActionStarCount()));
                optimizeActionList.add(optimizeActionDTO);
            }
            
            if(obj.getTotal().getMissingBio() != null &&  obj.getTotal().getMissingBio().getMissingCount() > 0) {
                optimizeActionDTO = new OptimizeActionDTO();
                optimizeActionDTO.setActionFlameCount(obj.getTotal().getMissingBio().getActionFlameCount());
                optimizeActionDTO.setPageWidth(430);
                optimizeActionDTO.setPageHeight(310);
                optimizeActionDTO.setPageLeft(454);
                optimizeActionDTO.setPageTop(220);
                optimizeActionDTO.setJspPageToDisplay("missingProfileBio.jsp");                
                optimizeActionDTO.setTitleBarText("Missing Profile Bio");
                optimizeActionDTO.setActionStarCount(obj.getTotal().getMissingBio().getActionStarCount());
                optimizeActionDTO.setAsOfPerformanceDate(new Date());
                optimizeActionDTO.setLabel(obj.getTotal().getMissingBio().getMissingCount() + " Missing Profile Bio");
                optimizeActionDTO.setActionId("5");
                optimizeActionDTO.setImageTagScript(getImageJSTag(optimizeActionDTO.getActionFlameCount(), optimizeActionDTO.getActionStarCount()));
                optimizeActionList.add(optimizeActionDTO);
            }
            
            if(obj.getTotal().getMissingCustomBackground() != null &&  obj.getTotal().getMissingCustomBackground().getMissingCount() > 0) {
                optimizeActionDTO = new OptimizeActionDTO();
                optimizeActionDTO.setActionFlameCount(obj.getTotal().getMissingCustomBackground().getActionFlameCount());
                optimizeActionDTO.setPageWidth(430);
                optimizeActionDTO.setPageHeight(300);
                optimizeActionDTO.setPageLeft(454);
                optimizeActionDTO.setPageTop(220);                
                optimizeActionDTO.setJspPageToDisplay("missingCustomBkg.jsp");                                                                                        
                optimizeActionDTO.setTitleBarText("Missing Custom Bkg");
                optimizeActionDTO.setActionStarCount(obj.getTotal().getMissingCustomBackground().getActionStarCount());
                optimizeActionDTO.setAsOfPerformanceDate(new Date());
                optimizeActionDTO.setLabel(obj.getTotal().getMissingCustomBackground().getMissingCount() + " Missing Custom Bkg");  
                optimizeActionDTO.setActionId("6");
                optimizeActionDTO.setImageTagScript(getImageJSTag(optimizeActionDTO.getActionFlameCount(), optimizeActionDTO.getActionStarCount()));
                optimizeActionList.add(optimizeActionDTO);
            }
            
            if(obj.getTotal().getMissingProfilePicture() != null &&  obj.getTotal().getMissingProfilePicture().getMissingCount() > 0) {
                optimizeActionDTO = new OptimizeActionDTO();
                optimizeActionDTO.setActionFlameCount(obj.getTotal().getMissingProfilePicture().getActionFlameCount());
                optimizeActionDTO.setPageWidth(430);
                optimizeActionDTO.setPageHeight(300);
                optimizeActionDTO.setPageLeft(454);
                optimizeActionDTO.setPageTop(220);                
                optimizeActionDTO.setJspPageToDisplay("missingProfilePicture.jsp");                                                             
                optimizeActionDTO.setTitleBarText("Missing Profile Picture");
                optimizeActionDTO.setActionStarCount(obj.getTotal().getMissingProfilePicture().getActionStarCount());
                optimizeActionDTO.setAsOfPerformanceDate(new Date());
                optimizeActionDTO.setLabel(obj.getTotal().getMissingProfilePicture().getMissingCount() + " Missing Profile Picture");  
                optimizeActionDTO.setActionId("7");
                optimizeActionDTO.setImageTagScript(getImageJSTag(optimizeActionDTO.getActionFlameCount(), optimizeActionDTO.getActionStarCount()));
                optimizeActionList.add(optimizeActionDTO);
            }
            
            if(obj.getTotal().getMissingGeolocation() != null &&  obj.getTotal().getMissingGeolocation().getMissingCount() > 0) {
                optimizeActionDTO = new OptimizeActionDTO();
                optimizeActionDTO.setActionFlameCount(obj.getTotal().getMissingGeolocation().getActionFlameCount());
                optimizeActionDTO.setPageWidth(430);
                optimizeActionDTO.setPageHeight(310);
                optimizeActionDTO.setPageLeft(454);
                optimizeActionDTO.setPageTop(220);
                optimizeActionDTO.setJspPageToDisplay("geoLocationSetting.jsp");                
                optimizeActionDTO.setTitleBarText("Geolocation Setting");
                optimizeActionDTO.setActionStarCount(obj.getTotal().getMissingGeolocation().getActionStarCount());
                optimizeActionDTO.setAsOfPerformanceDate(new Date());
                optimizeActionDTO.setLabel(obj.getTotal().getMissingGeolocation().getMissingCount() + " Geolocation Setting");  
                optimizeActionDTO.setActionId("8");
                optimizeActionDTO.setImageTagScript(getImageJSTag(optimizeActionDTO.getActionFlameCount(), optimizeActionDTO.getActionStarCount()));
                optimizeActionList.add(optimizeActionDTO);
            }                        
        }

        optimizeAction(null);//TODO this is used to populate ChildDTO for the first time. But this invocation needs to be refactored
        
//      optimizeActionInfluencers(null); //TODO this is used to populate TwitterActionsInfluencersDTO for the first time. But this invocation needs to be refactored 
//      optimizeActionFavourites(null); //TODO this is used to populate TwitterActionsFavouritesDTO for the first time. But this invocation needs to be refactored
//      optimizeActionRTThanks(null); //TODO this is used to populate RTThanksDTO for the first time. But this invocation needs to be refactored
//      optimizeActionDMToReturn(null); //TODO this is used to populate DMToReturnDTO for the first time. But this invocation needs to be refactored
        
        setOptimizeActionDTOs(optimizeActionList);
        return optimizeActionList;
    }

    private void setProfileAlertFromBackendProcess(TwitterActionsDTO obj) throws SVTException {        
        //setSessionAttribute("tccppaDTOCounter", Integer.valueOf(1).toString());
        
        TwitterCalculatorProfileActionDTO twitterCalculatorProfileActionDTO = getTwitterCalculatorChannelPerformanceProfileActionDTO().getTwitterCalculatorProfileActionDTO();
        if(twitterCalculatorProfileActionDTO.getOutboundMetricsDummy() != null){
            for(OutboundMetricsDummy outbound: twitterCalculatorProfileActionDTO.getOutboundMetricsDummy()){
                System.out.println("metricId: " + outbound.getMetricId());
                setMissingAlert(outbound, obj);
            }                
        }     
        
        /*if(Integer.parseInt(getSessionAttribute("tccppaDTOCounter")) == 2) {
            getRTOPHandler().setTwitterCalculatorChannelPerformanceProfileActionDTO(null);
        }*/
    }

    public boolean getDisplayProfileAlert(){
        String rtopSelectedHandler = getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME);
        return (rtopSelectedHandler != null);
    }
    
    private void setMissingAlert(OutboundMetricsDummy outbound, TwitterActionsDTO obj) {
        int flameCount = outbound.getAlertFlameCount(); // This will check and set if Flame needs to be displayed
        int starCount = outbound.getAlertStarCount(); // This will check and set if Flame needs to be displayed
        int cmptVolume = (outbound.getCmptVolume() != null)?(getOnlyNumbers(outbound.getCmptVolume())):(0);
        int target = (outbound.getCustTarget() != null)?(getOnlyNumbers(outbound.getCustTarget())):(0);
        int missingCount = (cmptVolume - target);
        
        if(outbound.getMetricId().equalsIgnoreCase("1")){ // missingBio
            obj.getTotal().setMissingBio(getActionCount(obj, flameCount,starCount, cmptVolume, target, getMissingHandlerCount(outbound.getAlertMessageHandlers()))); 
            setSessionAttribute("alertTHMissingbio", outbound.getAlertMessageHandlers());
        }else if(outbound.getMetricId().equalsIgnoreCase("2")){ // missingBackground
            obj.getTotal().setMissingCustomBackground(getActionCount(obj, flameCount,starCount, cmptVolume, target, getMissingHandlerCount(outbound.getAlertMessageHandlers())));
            setSessionAttribute("alertTHmissingbkg", outbound.getAlertMessageHandlers());
        }else if(outbound.getMetricId().equalsIgnoreCase("3")){ // missingGeolocation
            //obj.getTotal().setMissingGeolocation(getActionCount(obj, flameCount,starCount, cmptVolume, target, getMissingHandlerCount(outbound.getAlertMessageHandlers())));
            setSessionAttribute("alertTHmissinggeo", outbound.getAlertMessageHandlers());
        }else if(outbound.getMetricId().equalsIgnoreCase("5")){ // missingProfilePics
            obj.getTotal().setMissingProfilePicture(getActionCount(obj, flameCount,starCount, cmptVolume, target, getMissingHandlerCount(outbound.getAlertMessageHandlers())));
            setSessionAttribute("alertTHmissingPics", outbound.getAlertMessageHandlers());
        }else if(outbound.getMetricId().equalsIgnoreCase("38")){ // influencertoFollow (Take only star and flame count)
            obj.getTotal().setInfluencersToFollow(getActionCount(obj, flameCount,starCount, cmptVolume, target, missingCount));
        }else if(outbound.getMetricId().equalsIgnoreCase("6")){ // InfluencersToList (Take only star and flame count)
            obj.getTotal().setInfluencersToList(getActionCount(obj, flameCount,starCount, cmptVolume, target, missingCount));
        }else if(outbound.getMetricId().equalsIgnoreCase("7")){ // TweetsToFavorite (Take only star and flame count)
            obj.getTotal().setTweetsToFavorite(getActionCount(obj, flameCount,starCount, cmptVolume, target, missingCount));
        }else if(outbound.getMetricId().equalsIgnoreCase("10")){ // RtToThanks (Take only star and flame count)
            obj.getTotal().setRtToThanks(getActionCount(obj, flameCount,starCount, cmptVolume, target, missingCount));
        }else if(outbound.getMetricId().equalsIgnoreCase("19")){ // DmToReturn (Take only star and flame count)
            obj.getTotal().setDmToReturn(getActionCount(obj, flameCount,starCount, cmptVolume, target, missingCount));
        }
    }

    private int getMissingHandlerCount(List<String> alertMessageHandlers) {
        if(alertMessageHandlers != null){
            return alertMessageHandlers.size(); 
        }
        return 0;
    }

    private ActionCount getActionCount(TwitterActionsDTO obj, int flameCount,
            int starCount, int cmptVolume, int target, int missingCount) {
        ActionCount actionAccount = obj.new ActionCount();
        actionAccount.setMissingCount(missingCount);
        actionAccount.setActionFlameCount(flameCount);
        actionAccount.setActionStarCount(starCount);
        return actionAccount;
    }
    
    /**
     * 
     * This method is invoked when the user clicks on the 'Optimize' button for Action 'Influencers to follow'
     * @throws Exception
     * 
     * 
     * **/
    private void optimizeActionInfluencers(ActionEvent ae, String actionId) throws Exception
    {                       
        String twitterUserId =  getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME);
        setFirstActionInfluencerTwitterAccount(twitterUserId);
        TwitterActionsInfluencersDTO tempList = (TwitterActionsInfluencersDTO) getActionDetails(twitterUserId,"actionsinfluencers" );
        
        if(tempList != null){
            setTwitterAccountByActionId(actionId); // This will filter list by actionId
            setTwitterActionsInfluencerDto(tempList); 
        }  
    }

    /**
     * 
     * This method is invoked when the user clicks on the 'Optimize' button for Action 'Tweets to favorite'
     * @throws Exception
     */
    private void optimizeActionFavourites(ActionEvent ae, String actionId) throws Exception
    {
        String twitterUserId =  getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME);
        setFirstActionInfluencerTwitterAccount(twitterUserId);    
        TwitterActionsFavouritesDTO tempList = (TwitterActionsFavouritesDTO) getActionDetails(twitterUserId,"actionsfavourites" );
        
        if(tempList != null){
            setTwitterAccountByActionId(actionId); // This will filter list by actionId
            //setTwitterActionsFavouritesDto(tempList);
            setTwitterActionsFavouritesDto(setTweetFav(tempList));
        }        
    }
    
    /**
     * This method will translate the collectpicker value to UI dependent text
     * @param twtFav
     * @return
     */
    private TwitterActionsFavouritesDTO setTweetFav(TwitterActionsFavouritesDTO twtFav){
      String type = "";
      List<ActionsFavourites> favs = twtFav.getFavourites();
      if(favs != null && favs.size()>0){
          for(ActionsFavourites fav: favs){
              if(fav.getProcessing() != null ){
                  type = fav.getProcessing().getPicker();
                  fav.setTweetType(getTweetType(type));
              }
          }          
      }
      return twtFav;
    }



    /**
     * 
     * This method is invoked when the user clicks on the 'Optimize' button for Action 'Influencers to list'
     * @throws Exception
     */
    private void optimizeActionInfluencersToList(ActionEvent ae, String actionId) throws Exception {        
        String twitterUserId =  getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME);
        setFirstActionInfluencerTwitterAccount(twitterUserId);                
        TwitterActionsInfluencersListDTO twitterActionsInfluencersListDTO = (TwitterActionsInfluencersListDTO) getActionDetails(twitterUserId,"actionsinfluencerstolist");
        
        if(twitterActionsInfluencersListDTO != null) {
            setTwitterAccountByActionId(actionId); // This will filter list by actionId
            setTwitterActionsInfluencersListDTO(twitterActionsInfluencersListDTO); 
        }        
    }
    
    /**
     * 
     * This method is invoked when the user clicks on the 'Optimize' button for Action 'Retweets to Thanks'
     * @throws Exception
     */
    private void optimizeActionRTThanks(ActionEvent ae, String actionId) throws Exception
    {
        String twitterUserId =  getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME);
        setFirstActionInfluencerTwitterAccount(twitterUserId);    
        TwitterActionsRTThanksDTO tempList = (TwitterActionsRTThanksDTO) getActionDetails(twitterUserId,"actionsretweets");
        
        if(tempList != null)
        {
            setTwitterAccountByActionId(actionId); // This will filter list by actionId
            setTwitterActionsRTThanksDto(tempList);
            
        }        
    }

    private void setTwitterAccountByActionId(String actionId)
            throws SVTException {
        Gson gson = new Gson(); // json-1.7.1   
        String json1 = readFromURL(getDatashiftAPIURL("actions", null));
        TwitterActionsDTO obj1 = gson.fromJson(json1, TwitterActionsDTO.class);
        if(obj1 != null) {
            setTwitter_accounts(getCustomerHandlerByActionType(obj1.getTwitter_accounts(),obj1,actionId));    
        }
    }
    
    /**
     * 
     * This method is invoked when the user clicks on the 'Optimize' button for Action 'DM to Return'
     * @throws Exception
     */
    private void optimizeActionDMToReturn(ActionEvent ae, String actionId) throws Exception
    {
        String twitterUserId =  getSessionAttribute(TwitterControllerConstants.FIRST_CUST_NAME);
        setFirstActionInfluencerTwitterAccount(twitterUserId);    
        TwitterActionsDMToReturnDTO tempList = (TwitterActionsDMToReturnDTO) getActionDetails(twitterUserId,"actionsdmtoreturn");
        
        if(tempList != null)
        {
            setTwitterAccountByActionId(actionId); // This will filter list by actionId
            setTwitterActionsDMToReturnDTO(tempList); 
        }        
    }
    
    public BaseActionTwitterDTO getActionDetails(String twitterUserId, String jsonApiName) throws TwitterException, SVTException
    {
        if(twitterUserId != null && twitterUserId.trim().length()> 0){
            String json = readFromURL(getDatashiftAPIURL(jsonApiName, twitterUserId));
            Gson gson = new Gson(); // json-1.7.1        
            //convert JSON into java object
            BaseActionTwitterDTO obj = (BaseActionTwitterDTO) gson.fromJson(json, getClassName(jsonApiName));
           
            return obj;            
        }
        return null;
    }

    /**
     * 
     * This method is used to populate the drop-down list in for 'Optimize Action' popups
     * @throws Exception
     * @return accList
     * 
     ***/
    public SelectItem[] getActionInfluencerTwitterAccounts() throws SVTException
    {
        List<ActionsTwitterAccounts> twtAccList = getTwitter_accounts();
        SelectItem[] accList = new SelectItem[1];
        if(twtAccList !=null && twtAccList.size()>0)
        {
            accList = new SelectItem[twtAccList.size()];            
            for (int i = 0; i <twtAccList.size(); i++)
            {
                accList[i] = new SelectItem();
                accList[i].setLabel("@"+twtAccList.get(i).getAccountname());
                accList[i].setValue(twtAccList.get(i).getAccountname());
            }
        }else{
            accList[0] = new SelectItem();
            accList[0].setLabel("");
            accList[0].setValue("");
        }
        return accList;
    }
    
    /**
     * 
     * This method is used to populate the drop-down list in for Manual Schedule Time
     * @throws Exception
     * @return accList
     * @throws Exception 
     * 
     ***/
    public SelectItem[] getManualScheduleTimes() throws Exception
    {
        List<String> manualTimeList = new ArrayList<String>();
        manualTimeList = getTimeList();
        
        if(manualTimeList != null && manualTimeList.size() > 0)
        {
            SelectItem[] timeList = new SelectItem[manualTimeList.size()];
            
            for (int i = 0; i <manualTimeList.size(); i++)
            {
                timeList[i] = new SelectItem();
                
                timeList[i].setLabel(manualTimeList.get(i));
                timeList[i].setValue(manualTimeList.get(i));
            }
            
            return timeList;
        }
        else
        {
            return null; 
        }
    }
    
    /**
     * 
     * This method is used generate a String List of time from 12:00 AM to 11:45 PM with regular intervals of 15 minutes
     * 
     * JodaTime Api used
     * 
     * @throws Exception
     * @return timeList
     * 
     ***/
    
    private List<String> getTimeList() throws Exception
    {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("h:mm a");
        DateTime startDate = new DateTime();        
        startDate = new DateTime(startDate.getYear(), startDate.getMonthOfYear(), startDate.getDayOfMonth(), 0, 0, 0, 0);
        
        List<String> timeList = new ArrayList<String>();
        
        DateTime endDate = new DateTime();        
        endDate = new DateTime(endDate.getYear(), endDate.getMonthOfYear(), endDate.getDayOfMonth(), 23, 45, 0, 0).plusMinutes(15);
        
        while(!startDate.isEqual(endDate))
        {
            timeList.add(formatter.print(startDate));
            startDate = startDate.plusMinutes(15);
        }
        
        return timeList;
    }
    
    /**
     * Factory to get specific class
     * @param jsonApiName
     * @return
     */
    private Class getClassName(String jsonApiName) {
        if(jsonApiName.equalsIgnoreCase("actionsretweets")){
            return TwitterActionsRTThanksDTO.class;
        }else if(jsonApiName.equalsIgnoreCase("actionsinfluencers")){
            return TwitterActionsInfluencersDTO.class;
        }else if(jsonApiName.equalsIgnoreCase("actionsfavourites")){
            return TwitterActionsFavouritesDTO.class;            
        }else if(jsonApiName.equalsIgnoreCase("actionsdmtoreturn")){
            return TwitterActionsDMToReturnDTO.class;            
        }else if(jsonApiName.equalsIgnoreCase("ajax")){
            return TwitterActionsAjaxDTO.class;
        }else if(jsonApiName.equalsIgnoreCase("actionsinfluencerstolist")) {
            return TwitterActionsInfluencersListDTO.class;
        }
        return null;
    }

    private String getTweetType(String sentimentName) {
        if(sentimentName == null){
            sentimentName="";
        }
        if(sentimentName.equalsIgnoreCase("collectNegative")){
            return FilterSequence.NEGATIVE;
        }
        else if(sentimentName.equalsIgnoreCase("collectPositive")){
            return FilterSequence.POSITIVE;
        }
        else if(sentimentName.equalsIgnoreCase("collectBitly")){
            return FilterSequence.BITLY;
        }
        else if(sentimentName.equalsIgnoreCase("collectInfluence")){
            return FilterSequence.INFLUENCER;
        }
        else if(sentimentName.equalsIgnoreCase("collectBrand")){
            return FilterSequence.BRAND;
        }
        else if(sentimentName.equalsIgnoreCase("collectProduct")){
            return FilterSequence.PRODUCT;
        }
        else if(sentimentName.equalsIgnoreCase("collectIndustry")){
            return FilterSequence.INDUSTRY;
        }
        else if(sentimentName.equalsIgnoreCase("collectMention")){
            return FilterSequence.MENTION;
        }
        else if(sentimentName.equalsIgnoreCase("collectCompetitor")){
            return FilterSequence.MENTIONCMPT;
        }
        else if(sentimentName.equalsIgnoreCase("collectThemes")){
            return FilterSequence.THEME;
        }
        else if(sentimentName.equalsIgnoreCase("collectHashtags")){
            return FilterSequence.HASHTAGS;
        }
        else{
            // Picker is not sending the correct theme, so lets put defaultValue
            return "FOLLOWING";
            }
    }
    /**
     * API returning all the handler, need to show only customer Handler
     * @param twitterAccounts
     * @return
     * @throws SVTException 
     */
    private List<ActionsTwitterAccounts> getCustomerHandler(
            List<ActionsTwitterAccounts> twitterAccounts, TwitterActionsDTO obj) throws SVTException {
        List<ActionsTwitterAccounts> dtos = new ArrayList<ActionsTwitterAccounts>();
        List<TwitterAccountDTO> tadto =new ArrayList<TwitterAccountDTO>();
        // need to get only customer Handler
        if(getCurrentProfileId() != null){
            tadto = getTwitterAccountMgr().getByProfilePreferenceIdSELF(getCurrentProfileId()); 
        }
        if(twitterAccounts == null){
            ActionsTwitterAccounts dto = obj.new ActionsTwitterAccounts();
            dto.setAccountname(obj.getAccountname());
            if(obj.getActions() != null){
                dto.setFavourites(obj.getActions().getFavourites());
                dto.setInfluencers(obj.getActions().getInfluencers());
                dto.setRetweets(obj.getActions().getRetweets());                
            }
            dtos.add(dto);
        }else{
            for(ActionsTwitterAccounts dto : twitterAccounts){
                if(isExist(dto.getAccountname(),tadto)){
                    dtos.add(dto);                 
                }
            }
        }
        return dtos;
    }

    private List<ActionsTwitterAccounts> getCustomerHandlerByActionType(
            List<ActionsTwitterAccounts> twitterAccounts, TwitterActionsDTO obj, String actionId) throws SVTException {
        List<ActionsTwitterAccounts> dtos = new ArrayList<ActionsTwitterAccounts>();
        
        if(twitterAccounts == null){
            ActionsTwitterAccounts dto = obj.new ActionsTwitterAccounts();
            dto.setAccountname(obj.getAccountname());
            if(obj.getActions() != null){
                dto.setFavourites(obj.getActions().getFavourites());
                dto.setInfluencers(obj.getActions().getInfluencers());
                dto.setRetweets(obj.getActions().getRetweets());                
            }
            dtos.add(dto);
        }else{
            for(ActionsTwitterAccounts dto : twitterAccounts){               
                if(actionId != null && actionId.equals("1") && dto.getInfluencers() > 0){                // Influencers to Follow
                    dtos.add(dto);  
                } else if(actionId != null && actionId.equals("2") && dto.getFavourites() > 0){          //Tweets to Favorite
                    dtos.add(dto); 
                } else if(actionId != null && actionId.equals("3") && dto.getInfluencers_to_list() > 0){ //Influencers to List
                    dtos.add(dto); 
                } else if(actionId != null && actionId.equals("4") && dto.getRetweets() > 0){            // Retweet to Thank
                    dtos.add(dto); 
                } else if(actionId != null && actionId.equals("9")){                                     // DM to Return
                    dtos.add(dto); 
                }
            }
        }
        return dtos;
    }
    
    private boolean isExist(String accountname, List<TwitterAccountDTO> tadto)
    {
        for(TwitterAccountDTO dto: tadto)
        {
           if(dto.getTwitterUsername() != null && dto.getTwitterUsername().equalsIgnoreCase(accountname))
           {
             return true;  
           }
        }
        return false;
    }

    public String getFirstActionInfluencerTwitterAccount()
    {
        String actionInfluencerTwitterAccount = "";
        
        if(this.firstActionInfluencerTwitterAccount != null && this.firstActionInfluencerTwitterAccount.trim().length() > 0)
        {
            actionInfluencerTwitterAccount = this.firstActionInfluencerTwitterAccount;
            //System.out.println("user selected ::::::::::: "+actionInfluencerTwitterAccount);
        }
        
        // getting first accountName from the list of accounts receiving from API call
        else
        {
            if(getTwitter_accounts() != null && getTwitter_accounts().size() > 0)
            { 
                //System.out.println("1st user: " + getTwitter_accounts().get(0).getAccountname());
                actionInfluencerTwitterAccount = getTwitter_accounts().get(0).getAccountname();
            } 
        }
       
        return actionInfluencerTwitterAccount;
    }
    
    /**
     * 
     * This method is used to populate the RTOPScheduleDTO with RTOP params
     * The dto is then sent to biz layer manager for persisting the dto to DB with status = 0.
     * 
     *  @param ae
     *  @throws SVTException, TwitterException, ParseException
     * 
     * 
     ***/
    
    
    public void persistScheduleData(ActionEvent ae) throws SVTException, TwitterException, ParseException
    {
        String index = getParameter("indexClk");
        String timezoneString = getParameter("timezonename");
        String grade = getParameter("rtopGrade_"+index);
        String twitterUsername = getParameter("twitterUserName");
        String tweetMessage = getParameter("rtopMsg_"+index);
        String scheduleId = getParameter("scheduleId");
        String rtopScheduleDate = getParameter("rtopScheduleDate_"+index);
        String manualScheduleTime = getParameter("rtopScheduleTime_"+index);
        String scheduleType = getParameter("scheduleType_"+index);
        
        String dateFormat = detectDateFormat(rtopScheduleDate);
        //DateFormat format = getLocaleDateFormat(dateFormat, timezoneString);
        DateFormat format = new SimpleDateFormat(dateFormat);
        Date manualScheduleDate = format.parse(rtopScheduleDate);
        TwitterAccountDTO accountDTO = getTwitterAccountMgr().getByTwitterProfIdUsername(getCurrentProfileId(), twitterUsername);
        
        if(grade == null || grade.trim().length() == 0)
        {
            if(getTrendingGrades()!=null && getTrendingGrades().trim().length()>0)
            {
                grade = getTrendingGrades();
            }
            else
            {
                grade = getParameter("scheduleGrade");
            }
        }
        
        if(accountDTO!=null && accountDTO.getTwitterAccount()!=null)
        {
            RTOPScheduleDTO dto = new RTOPScheduleDTO();
            
            if(scheduleId != null && scheduleId.trim().length() > 0)
            {
                dto.setRtopScheduleId(scheduleId);
            }
            
            dto.setScheduleType(scheduleType);
            dto.setTweetMessage(tweetMessage);
            dto.setTwitterAccount(accountDTO.getTwitterAccount());
            dto.setGrade(grade);
            
            dto.setScheduleDateTime(manipulateDateTime(manualScheduleTime,getDateYYYYMMDDHHMISS(manualScheduleDate)));
            dto.setStatus(0); // for scheduled
            
            getRTOPScheduleMgr().saveOrUpdate(dto);
            
            setTrendingGradeSet(false);
            
        }
    }    
    
    private SimpleDateFormat getLocaleDateFormat(String dateFormat, String timezoneString) {
        System.out.println("Convert to timezone: " + timezoneString);
        if(timezoneString == null){
            timezoneString = "EST"; // default
        }
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
       TimeZone tz = TimeZone.getTimeZone(timezoneString);
       formatter.setTimeZone(tz);
       return formatter;
    }

    @SuppressWarnings("unused")
    private Date manipulateDateTime1(String manualScheduleTime, String timezoneString, String rtopScheduleDate) throws ParseException {
        System.out.println("Date Entered: " + rtopScheduleDate);
        System.out.println("Time Entered: " + manualScheduleTime);

        String dateFormat = detectDateFormat(rtopScheduleDate);        
        /////////////////////////
        DateFormat format1 = new SimpleDateFormat(dateFormat);
        Date manualScheduleDate1 = format1.parse(rtopScheduleDate);
        Date newDate = getDateInTimeZone(manualScheduleDate1, timezoneString);
        System.out.println("IST DATE...............: " + manualScheduleDate1);
        System.out.println("EST DATE...............: " + newDate);
        ////////////////////////
        
        return null;
    }

    public Date getDateInTimeZone(Date dateToConvert, String timeZoneAbbr)
    {
        if(timeZoneAbbr == null){
            timeZoneAbbr = "EST"; // default
        }
        timeZoneAbbr = "EST"; // default
        TimeZone tz = TimeZone.getTimeZone(timeZoneAbbr);
        Calendar mbCal = new GregorianCalendar(tz);
        mbCal.setTimeInMillis(dateToConvert.getTime());
    
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, mbCal.get(Calendar.YEAR));
        cal.set(Calendar.MONTH, mbCal.get(Calendar.MONTH));
        cal.set(Calendar.DAY_OF_MONTH, mbCal.get(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, mbCal.get(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, mbCal.get(Calendar.MINUTE));
        cal.set(Calendar.SECOND, mbCal.get(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, mbCal.get(Calendar.MILLISECOND));
    
        return cal.getTime();
    }
    
    
    /**
     * 
     * This method is used to populate the RTOPScheduleDTO with RTOP params
     * The dto is then sent to biz layer manager for persisting the dto to DB with status = 3.
     * 
     *  @param ae
     *  @throws SVTException, TwitterException, ParseException
     * 
     * 
     ***/
    
    public void removeScheduledTweetFromDB(ActionEvent ae) throws Exception
    {
        String grade = "";
        String index = getParameter("indexClk");
        
        String twitterUsername = getParameter("twitterUserName");
        String tweetMessage = getParameter("rtopMsg_"+index);
        String scheduleId = getParameter("scheduleId");
        String rtopScheduleDate = getParameter("rtopScheduleDate_"+index);
        
        String dateFormat = detectDateFormat(rtopScheduleDate);
        
        DateFormat format = new SimpleDateFormat(dateFormat);
        
        Date manualScheduleDate = format.parse(rtopScheduleDate);
        String manualScheduleTime = getParameter("rtopScheduleTime_"+index);
        
        TwitterAccountDTO accountDTO = getTwitterAccountMgr().getByTwitterProfIdUsername(getCurrentProfileId(), twitterUsername);
        
        if(getTrendingGrades()!=null && getTrendingGrades().trim().length()>0)
        {
            grade = getTrendingGrades();
        }
        else
        {
            grade = getParameter("scheduleGrade");
        }
        
        String scheduleType = "M";
        
        if(accountDTO!=null && accountDTO.getTwitterAccount()!=null)
        {
            RTOPScheduleDTO dto = new RTOPScheduleDTO();
            
            if(scheduleId != null && scheduleId.trim().length() > 0)
            {
                dto.setRtopScheduleId(scheduleId);
            }
            
            dto.setScheduleType(scheduleType);
            dto.setTweetMessage(tweetMessage);
            dto.setTwitterAccount(accountDTO.getTwitterAccount());
            dto.setGrade(grade);
            
            dto.setScheduleDateTime(manipulateDateTime(manualScheduleTime,getDateYYYYMMDDHHMISS(manualScheduleDate)));
            dto.setStatus(3); // for remove
            
            getRTOPScheduleMgr().saveOrUpdate(dto);
            
            setTrendingGradeSet(false);
            
        }
    }
    
    /**
     * 
     * This method is used to manipulate the time & date to get the format yyyy-MM-dd HH:mm:ss
     * Uses Joda Time Api
     * 
     *  @param manualScheduleTime, manualScheduleDate
     *  @return Date
     * 
     ***/
    
    private Date manipulateDateTime(String manualScheduleTime, Date manualScheduleDate)
    {
        if(manualScheduleTime != null){
            manualScheduleTime = manualScheduleTime.trim();
        }
        DateTimeFormatter formatter = DateTimeFormat.forPattern("h:mm a");
        
        DateTime time = formatter.parseDateTime(getScheduleTime12Hr(manualScheduleTime));
        DateTime dateTime = new DateTime(manualScheduleDate);
        DateTime manualScheduleDateTime = new DateTime(dateTime.getYear(),dateTime.getMonthOfYear(), dateTime.getDayOfMonth(), time.getHourOfDay(), time.getMinuteOfHour(),0,0);
                    
        return manualScheduleDateTime.toDate();
    }
    
    private String getScheduleTime12Hr(String manualScheduleTime) {
        // because this is bug in chrome, needs to take care just like twt.js-> getTime12Hr(value) 
        if(manualScheduleTime != null && manualScheduleTime.indexOf("M") >= 0){//FF and IE ( 12hrs )
            // no need to do anything
            return manualScheduleTime;
        }else{ // for Chrome
            String[] temp;
            temp = manualScheduleTime.split(":");
            int hours=0;
            int mins=0;
            if(temp[0] != null){
                hours = Integer.parseInt(temp[0]);    
            }
            if(temp[1] != null){
                mins = Integer.parseInt(temp[1]);    
            }
            
            String returnString= manualScheduleTime + " AM";
            if(hours == 0){
                returnString = hours + ":" + mins + " AM";
             }else if(hours == 12){
                returnString = hours + ":" + mins + " PM";
             }else if(hours > 12){
                returnString = (hours - 12) + ":" + mins + " PM";
             }
             return returnString;
        }
    }

    private String getImageJSTag(int flameCount, int starCount) {
        String imgTag = "";        
        for(int scount=0; scount<starCount; scount++){
            imgTag += "<img style=\"margin-left: 4px;\" src=\"../images/yellowStarSmall.gif\" onmouseover=\"this.src=\'../images/yellowStarSmallRollover.gif\';\" onmouseout=\"this.src=\'../images/yellowStarSmall.gif\';\" ></img>";
        }
        for(int scount=0; scount<flameCount; scount++){
            imgTag += "<img style=\"margin-left: 4px;\" src=\"../images/orangeFlameSmall.gif\" onmouseover=\"this.src=\'../images/orangeFlameSmallRollover.gif\';\" onmouseout=\"this.src=\'../images/orangeFlameSmall.gif\';\" ></img>";
        }
        if(flameCount>0){ // gray
            for(int scount=flameCount; scount<5; scount++){
                imgTag += "<img style=\"margin-left: 4px;\" src=\"../images/grayFlameSmall.gif\" onmouseover=\"this.src=\'../images/grayFlameSmall.gif\';\" onmouseout=\"this.src=\'../images/grayFlameSmall.gif\';\" ></img>";
            }       
        }
        if(starCount>0){ // gray 
            for(int scount=starCount; scount<5; scount++){
                imgTag += "<img style=\"margin-left: 4px;\"  src=\"../images/grayStarSmall.gif\" onmouseover=\"this.src=\'../images/grayStarSmall.gif\';\" onmouseout=\"this.src=\'../images/grayStarSmall.gif\';\" ></img>";
            }       
        }        
        return imgTag;
    }
    public void setFirstActionInfluencerTwitterAccount(String firstActionInfluencerTwitterAccount)
    {
        this.firstActionInfluencerTwitterAccount = firstActionInfluencerTwitterAccount;
    }

    public List<ActionsTwitterAccounts> getTwitter_accounts() {
        return twitter_accounts;
    }

    public void setTwitter_accounts(List<ActionsTwitterAccounts> twitterAccounts) {
        twitter_accounts = twitterAccounts;
    }

    public TwitterActionsInfluencersDTO getTwitterActionsInfluencerDto() {
        return twitterActionsInfluencerDto;
    }

    public void setTwitterActionsInfluencerDto(
            TwitterActionsInfluencersDTO twitterActionsInfluencerDto) {
        this.twitterActionsInfluencerDto = twitterActionsInfluencerDto;
    }
    
    public List<TwitterActionsInfluencersDTO> getActionInfluencersDetails1(String twitterUserId) throws TwitterException, SVTException
    {
        return new ArrayList<TwitterActionsInfluencersDTO>();
    }
   public ActionsInfluencers getActionInfluencersObj() {
        return actionInfluencersObj;
    }

    public void setActionInfluencersObj(ActionsInfluencers actionInfluencersObj) {
        this.actionInfluencersObj = actionInfluencersObj;
    }

    public TwitterActionsFavouritesDTO getTwitterActionsFavouritesDto() {
        return twitterActionsFavouritesDto;
    }

    public void setTwitterActionsFavouritesDto(
            TwitterActionsFavouritesDTO twitterActionsFavouritesDto) {
        this.twitterActionsFavouritesDto = twitterActionsFavouritesDto;
    }


    public TwitterActionsRTThanksDTO getTwitterActionsRTThanksDto() {
        return twitterActionsRTThanksDto;
    }


    public void setTwitterActionsRTThanksDto(
            TwitterActionsRTThanksDTO twitterActionsRTThanksDto) {
        this.twitterActionsRTThanksDto = twitterActionsRTThanksDto;
    }

    public TwitterTextSuggestionDTO getTwitterTextSuggestionDTO() {
        return twitterTextSuggestionDTO;
    }

    public void setTwitterTextSuggestionDTO(
            TwitterTextSuggestionDTO twitterTextSuggestionDTO) {
        this.twitterTextSuggestionDTO = twitterTextSuggestionDTO;
    }

    public List<TwitterTokens> getTextSuggestionTokens() {
        return textSuggestionTokens;
    }

    public void setTextSuggestionTokens(List<TwitterTokens> textSuggestionTokens) {
        this.textSuggestionTokens = textSuggestionTokens;
    }

    public boolean isTokenAvailable() {
        return tokenAvailable;
    }

    public void setTokenAvailable(boolean tokenAvailable) {
        this.tokenAvailable = tokenAvailable;
    }
    
    public List<ListItemDTO> getCustomerHandlerLists() {
        return customerHandlerLists;
    }

    public void setCustomerHandlerLists(List<ListItemDTO> customerHandlerLists) {
        
        this.customerHandlerLists = customerHandlerLists;
    }
    
    public String getTokenCount()
    {
        return tokenCount;
    }

    public void setTokenCount(String tokenCount)
    {
        this.tokenCount = tokenCount;
    }
    
    public String getTrendingGrades()
    {
        return trendingGrades;
    }

    public void setTrendingGrades(String trendingGrades)
    {
        this.trendingGrades = trendingGrades;
    }
    
    public Date getScheduleDate()
    {
        
        return getCurrentDate();
        
        /*if(this.scheduleDate != null)
        {
            return scheduleDate;
        }
        else
        {
            return getCurrentDate();
        }*/            
    }

    public void setScheduleDate(Date scheduleDate)
    {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleTime()
    {
        /*if(this.scheduleTime != null)
        {
            return scheduleTime;
        }
        else
        {
            Calendar currentTime = Calendar.getInstance();
            SimpleDateFormat fmt = new SimpleDateFormat("h:00 a");
            
            this.scheduleTime = fmt.format(currentTime.getTime());
            return scheduleTime;
        }*/
        
        return getCurrentTime();
    }

    public int getOnlyNumbers(String strValue) {        
        if (strValue == null) {
            return 0;
        }

        StringBuffer strBuff = new StringBuffer();
        char c;        
        for (int i = 0; i < strValue.length() ; i++) {
            c = strValue.charAt(i);
            
            if (Character.isDigit(c)) {
                strBuff.append(c);
            }
        }
        return Integer.parseInt(strBuff.toString());
    }
    public void setScheduleTime(String scheduleTime)
    {
        this.scheduleTime = scheduleTime;
    }
    
    public boolean isTrendingGradeSet()
    {
        return trendingGradeSet;
    }

    public void setTrendingGradeSet(boolean trendingGradeSet)
    {
        this.trendingGradeSet = trendingGradeSet;
    }

    public TwitterActionsDMToReturnDTO getTwitterActionsDMToReturnDTO() {
        return twitterActionsDMToReturnDTO;
    }

    public void setTwitterActionsDMToReturnDTO(TwitterActionsDMToReturnDTO twitterActionsDMToReturnDTO) {
        this.twitterActionsDMToReturnDTO = twitterActionsDMToReturnDTO;
    }
        
    private int iIndex;
    private String actionsInfluencersId;
    private String actionId;
    private List<ListItemDTO> userList;    

    /**
     * get the iIndex
     * @return iIndex
     * @author tapasb
     */
    public int getiIndex() {
        return iIndex;
    }

    /**
     * set the iIndex
     * @param iIndex
     * @author tapasb
     */
    public void setiIndex(int iIndex) {
        this.iIndex = iIndex;
    }

    /**
     * get the actionsInfluencersId
     * @return actionsInfluencersId
     * @author tapasb
     */
    public String getActionsInfluencersId() {
        return actionsInfluencersId;
    }

    /**
     * set the actionsInfluencersId 
     * @param actionsInfluencersId
     * @author tapasb
     */
    public void setActionsInfluencersId(String actionsInfluencersId) {
        this.actionsInfluencersId = actionsInfluencersId;
    }

    /**
     * get the userList
     * @return userList
     * @author tapasb
     */
    public List<ListItemDTO> getUserList() {
        return userList;
    }

    /**
     * set the userList
     * @param userList
     * @author tapasb
     */
    public void setUserList(List<ListItemDTO> userList) {
        this.userList = userList;
    }

    /**
     * get the actionId
     * @return actionId
     * @author tapasb
     */
    public String getActionId() {
        return actionId;
    }

    /**
     * set the actionId
     * @param actionId
     * @author tapasb
     */
    public void setActionId(String actionId) {
        this.actionId = actionId;
    }    
    
    /**
     * this method is called when user change the dropdown of the popup of influencer-to-follow
     * @param actionEvent
     * @throws Exception
     * @author tapasb
     */
    public void optimizeActionInfluencersChange(ActionEvent actionEvent) throws Exception {        
        setActionId(getParameter("actionId"));        
        TwitterActionsInfluencersDTO tempList = (TwitterActionsInfluencersDTO) getActionDetails(getFirstActionInfluencerTwitterAccount(),"actionsinfluencers" );
        
        if(tempList != null){
            setTwitterActionsInfluencerDto(tempList); 
        }  
    }        
    

    /**
     * this method returns a js array of keywords
     * @author NileshB
     */
    public String getKeywordsJSArray()throws Exception
    {
        String jsArray = "";
        System.out.println("getCurrentProfileId = " + getCurrentProfileId());
        if(keywordByProfilePreferenceList == null) {
            keywordByProfilePreferenceList = getCompanyMgr().getKeywordByProfilePreferenceSelf(getCurrentProfileId());
        }            

        if(keywordByProfilePreferenceList != null){
            Gson gson = new Gson(); // json-1.7.1
            jsArray = gson.toJson(keywordByProfilePreferenceList);
        }

        return jsArray;
    }

    /**
     * get the twitterActionsInfluencersListDTO
     * @return twitterActionsInfluencersListDTO
     * @author tapasb
     */
    public TwitterActionsInfluencersListDTO getTwitterActionsInfluencersListDTO() {    
        return twitterActionsInfluencersListDTO;
    }

    /**
     * set the twitterActionsInfluencersListDTO
     * @param twitterActionsInfluencersListDTO
     * @author tapasb
     */
    public void setTwitterActionsInfluencersListDTO(TwitterActionsInfluencersListDTO twitterActionsInfluencersListDTO) {
        this.twitterActionsInfluencersListDTO = twitterActionsInfluencersListDTO;
    }

    private List<OptimizeActionDTO> optimizeActionDTOs;

    /**
     * get the optimizeActionDTOs - list of OptimizeActionDTO object
     * @return optimizeActionDTOs
     * @author tapasb
     */
    public List<OptimizeActionDTO> getOptimizeActionDTOs() {
        return optimizeActionDTOs;
    }

    /**
     * set the optimizeActionDTOs
     * @param optimizeActionDTOs
     * @author tapasb
     */
    public void setOptimizeActionDTOs(List<OptimizeActionDTO> optimizeActionDTOs) {
        this.optimizeActionDTOs = optimizeActionDTOs;
    }    
    
    private boolean renderROIOptimizePanel = false;

    /**
     * get the boolean renderROIOptimizePanel
     * @return renderROIOptimizePanel
     * @author tapasb
     */
    public boolean isRenderROIOptimizePanel() {
        return renderROIOptimizePanel;
    }

    /**
     * set the renderROIOptimizePanel
     * @param renderROIOptimizePanel
     * @author tapasb
     */
    public void setRenderROIOptimizePanel(boolean renderROIOptimizePanel) {
        this.renderROIOptimizePanel = renderROIOptimizePanel;
    }
        
    /**
     * Re-renderer of optimize action panel
     * @param event
     * @author tapasb
     */
    public void reRenderROIOptimizePanel(ActionEvent event) {        
        setRenderROIOptimizePanel(true);
        setRenderRoiOptimizePanelPoll(false);
        setRoiOptimizeDivDisplay("block");
        setRoiOptimizeLoadingDivDisplay("none");
        setRenderPerformanceControllerPanel(true);    
        setRenderChannelOptimizationDataGeneratorPanel(true);
    }
    
    private boolean renderRoiOptimizePanelPoll = true;

    /**
     * get the boolean renderRoiOptimizePanelPoll
     * @return renderRoiOptimizePanelPoll
     * @author tapasb
     */
    public boolean isRenderRoiOptimizePanelPoll() {
        return renderRoiOptimizePanelPoll;
    }

    /**
     * set the boolean renderRoiOptimizePanelPoll
     * @param renderRoiOptimizePanelPoll
     * @author tapasb
     */
    public void setRenderRoiOptimizePanelPoll(boolean renderRoiOptimizePanelPoll) {
        this.renderRoiOptimizePanelPoll = renderRoiOptimizePanelPoll;
    }
    
    private String roiOptimizeDivDisplay = "none";

    /**
     * get the roiOptimizeDivDisplay value - "none" or "block"
     * @return roiOptimizeDivDisplay
     * @author tapasb
     */
    public String getRoiOptimizeDivDisplay() {
        return roiOptimizeDivDisplay;
    }

    /**
     * set the roiOptimizeDivDisplay value - "none" or "block"
     * @param roiOptimizeDivDisplay
     * @author tapasb
     */
    public void setRoiOptimizeDivDisplay(String roiOptimizeDivDisplay) {
        this.roiOptimizeDivDisplay = roiOptimizeDivDisplay;
    }
    
    private String roiOptimizeLoadingDivDisplay = "block";

    /**
     * get the roiOptimizeLoadingDivDisplay value - "none" or "block"
     * @return roiOptimizeLoadingDivDisplay
     * @author tapasb
     */
    public String getRoiOptimizeLoadingDivDisplay() {
        return roiOptimizeLoadingDivDisplay;
    }

    /**
     * set the roiOptimizeLoadingDivDisplay value - "none" or "block"
     * @param roiOptimizeLoadingDivDisplay
     * @author tapasb
     */
    public void setRoiOptimizeLoadingDivDisplay(String roiOptimizeLoadingDivDisplay) {
        this.roiOptimizeLoadingDivDisplay = roiOptimizeLoadingDivDisplay;
    }    
    
    private String[] checkBoxes;
    private String[] listIds;
    
    /**
     * get the checkBoxes - an array of String having false/true
     * @return checkBoxes
     * @author tapasb 
     */
    public String[] getCheckBoxes() {
        return checkBoxes;
    }

    /**
     * set the checkBoxes - an array of String having false/true
     * @param checkBoxes
     * @author tapasb
     */
    public void setCheckBoxes(String[] checkBoxes) {
        this.checkBoxes = checkBoxes;
    }

    /**
     * get the listIds - an array of String containing the ids of twitter user-list
     * @return listIds
     * @author tapasb
     * @see Twitter#getUserLists(String, long)
     */
    public String[] getListIds() {
        return listIds;
    }

    /**
     * set the listIds
     * @param listIds
     * @author tapasb
     */
    public void setListIds(String[] listIds) {
        this.listIds = listIds;
    }        
    
    private String elemID;
    private String divToPopupId;
    private String index;
    private String scrollTop;

    /**
     * get the elemID - required for jsFunction renderUserListPanel
     * @return elemID
     * @author tapasb
     */
    public String getElemID() {
        return elemID;
    }

    /**
     * set the elemID - required for jsFunction renderUserListPanel
     * @param elemID
     * @author tapasb
     */
    public void setElemID(String elemID) {
        this.elemID = elemID;
    }

    /**
     * get the divToPopupId - required for jsFunction renderUserListPanel
     * @return divToPopupId
     * @author tapasb
     */
    public String getDivToPopupId() {
        return divToPopupId;
    }

    /**
     * set the divToPopupId - required for jsFunction renderUserListPanel
     * @param divToPopupId
     * @author tapasb
     */
    public void setDivToPopupId(String divToPopupId) {
        this.divToPopupId = divToPopupId;
    }

    /**
     * get the index - required for jsFunction renderUserListPanel
     * @return index
     * @author tapasb
     */
    public String getIndex() {
        return index;
    }

    /**
     * set the index - required for jsFunction renderUserListPanel
     * @param index
     * @author tapasb
     */
    public void setIndex(String index) {
        this.index = index;
    }

    /**
     * get the scrollTop - required for jsFunction renderUserListPanel
     * @return scrollTop
     * @author tapasb
     */
    public String getScrollTop() {
        return scrollTop;
    }

    /**
     * set the scrollTop - required for jsFunction renderUserListPanel
     * @param scrollTop
     * @author tapasb
     */
    public void setScrollTop(String scrollTop) {
        this.scrollTop = scrollTop;
    }    
    
    /**
     * this method is called when user change the dropdown of the popup of add-to-list
     * @param event
     * @throws Exception
     * @author tapasb
     */
    public void optimizeActionInfluencersToListChange(ActionEvent event) throws Exception {        
        setActionId(getParameter("actionId"));        
        TwitterActionsInfluencersListDTO twitterActionsInfluencersListDTO = (TwitterActionsInfluencersListDTO) getActionDetails(getFirstActionInfluencerTwitterAccount(),"actionsinfluencerstolist");
        
        if(twitterActionsInfluencersListDTO != null){
            setTwitterActionsInfluencersListDTO(twitterActionsInfluencersListDTO); 
        }  
    }
    
    /**
     * this method is called when user change the dropdown of the popup of tweets-to-favorite
     * @param event
     * @throws Exception
     * @author tapasb
     */
    public void optimizeActionFavoriteChange(ActionEvent event) throws Exception {        
        setActionId(getParameter("actionId"));        
        TwitterActionsFavouritesDTO twitterActionsFavouritesDTO = (TwitterActionsFavouritesDTO) getActionDetails(getFirstActionInfluencerTwitterAccount(),"actionsfavourites");
        
        if(twitterActionsFavouritesDTO != null){
            //setTwitterActionsFavouritesDto(twitterActionsFavouritesDTO);
            setTwitterActionsFavouritesDto(setTweetFav(twitterActionsFavouritesDTO));
        }  
    }
    
    /**
     * this method is called when user change the dropdown of the popup of re-tweet-to-thansks
     * @param event
     * @throws Exception
     * @author tapasb
     */
    public void optimizeActionRetweetToThanksChange(ActionEvent event) throws Exception {                
        setActionId(getParameter("actionId"));        
        TwitterActionsRTThanksDTO twitterActionsRTThanksDTO = (TwitterActionsRTThanksDTO) getActionDetails(getFirstActionInfluencerTwitterAccount(),"actionsretweets");
        
        if(twitterActionsRTThanksDTO != null){
            setTwitterActionsRTThanksDto(twitterActionsRTThanksDTO);
        }  
    }
    
    /**
     * this method is called when user change the dropdown of the popup of direct-message-to-return
     * @param event
     * @throws Exception
     * @author tapasb
     */
    public void optimizeActionDirectMessageToReturnChange(ActionEvent event) throws Exception {        
        setActionId(getParameter("actionId"));        
        TwitterActionsDMToReturnDTO twitterActionsDMToReturnDTO = (TwitterActionsDMToReturnDTO) getActionDetails(getFirstActionInfluencerTwitterAccount(),"actionsdmtoreturn");
        
        if(twitterActionsDMToReturnDTO != null){
            setTwitterActionsDMToReturnDTO(twitterActionsDMToReturnDTO);
        }  
    }      
        
    private TwitterCalculatorChannelPerformanceProfileActionDTO twitterCalculatorChannelPerformanceProfileActionDTO;
    
    /**
     * this method initiate the data generation of Channel Performance and Profile Action Calculation
     * @return blank
     * @throws SVTException
     * @throws FileNotFoundException
     * @throws IOException
     * @author tapasb
     */
    public String getChannelOptimizationOutboundAndProfileActionList() throws SVTException, FileNotFoundException, IOException {
        //setSessionAttribute("tccppaDTOCounter", Integer.valueOf(0).toString());
        System.out.println("Channel Performance and Profile Action Calculation started ...");
        TwitterCalculatorChannelPerformanceProfileActionDTO twitterCalculatorChannelPerformanceProfileActionDTO = getTwitterCalculatorMgr().getTwitterCalculatorChannelPerformanceProfileActionDTO(getChannelPerformanceController().getPerformanceAsOfDate(), getCurrentUid(), getChannelPerformanceController().getTwitterAccountId(), getChannelPerformanceController().getBenchmarkDateFrom(), getChannelPerformanceController().getBenchmarkDateTo(), getChannelPerformanceController().getTargetId());
        setTwitterCalculatorChannelPerformanceProfileActionDTO(twitterCalculatorChannelPerformanceProfileActionDTO);
        System.out.println("Channel Performance and Profile Action Calculation completed ...");
        
        // ObjectOutput objectOutput = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("/home/tapasb/twitterCalculatorChannelPerformanceProfileActionDTO.ser"))));
        // objectOutput.writeObject(twitterCalculatorChannelPerformanceProfileActionDTO);
        // objectOutput.close();
        return "";
    }

    public TwitterCalculatorChannelPerformanceProfileActionDTO getTwitterCalculatorChannelPerformanceProfileActionDTO() {
        return twitterCalculatorChannelPerformanceProfileActionDTO;
    }

    public void setTwitterCalculatorChannelPerformanceProfileActionDTO(TwitterCalculatorChannelPerformanceProfileActionDTO twitterCalculatorChannelPerformanceProfileActionDTO) {
        this.twitterCalculatorChannelPerformanceProfileActionDTO = twitterCalculatorChannelPerformanceProfileActionDTO;
    }        
    
    private boolean renderPerformanceControllerPanel = false;

    public boolean isRenderPerformanceControllerPanel() {
        return renderPerformanceControllerPanel;
    }

    public void setRenderPerformanceControllerPanel(boolean renderPerformanceControllerPanel) {
        this.renderPerformanceControllerPanel = renderPerformanceControllerPanel;
    }
    
    private boolean renderChannelOptimizationDataGeneratorPanel = false;

    public boolean isRenderChannelOptimizationDataGeneratorPanel() {
        return renderChannelOptimizationDataGeneratorPanel;
    }

    public void setRenderChannelOptimizationDataGeneratorPanel(boolean renderChannelOptimizationDataGeneratorPanel) {
        this.renderChannelOptimizationDataGeneratorPanel = renderChannelOptimizationDataGeneratorPanel;
    }
    
    public void reRenderchannelOptimizationDataGeneratorPanel(ActionEvent event) {        
        setRenderChannelOptimizationDataGeneratorPanel(true);
        setChannelOptimizationDataGeneratorPanelRendererPoll(false);
    }
    
    private boolean channelOptimizationDataGeneratorPanelRendererPoll = false;

    public boolean isChannelOptimizationDataGeneratorPanelRendererPoll() {
        return channelOptimizationDataGeneratorPanelRendererPoll;
    }

    public void setChannelOptimizationDataGeneratorPanelRendererPoll(boolean channelOptimizationDataGeneratorPanelRendererPoll) {
        this.channelOptimizationDataGeneratorPanelRendererPoll = channelOptimizationDataGeneratorPanelRendererPoll;
    }
    
    public void setTwitterCalculatorChannelPerformanceProfileActionDTOToNull(ActionEvent event) {        
        setTwitterCalculatorChannelPerformanceProfileActionDTO(null);
    }
    
    private boolean closeIt = false;

    public boolean isCloseIt() {
        return closeIt;
    }

    public void setCloseIt(boolean closeIt) {
        this.closeIt = closeIt;
    }
    
    public void reRenderOptimizeActionsAfter5Minute(ActionEvent event) {
        System.out.println("Re-rendering of optimize actions initiated...");        
        setOptimizeActionDTOs(null);
    }
    
    public void actionFor5MinuteJSFunction(ActionEvent event) {        
        setRoiOptimizeDivDisplay("none");
        setRoiOptimizeLoadingDivDisplay("block");
    }
    
    private long interval;

    public long getInterval() throws SVTException {        
        interval = getParameterMgr().getRTOPActionDelayInSeconds() * 1000;
        System.out.println("Interval for refreshing: " + interval + " ms.");
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }
    
    private List<OutboundMetricsDummy> outboundMetricsDummy;
    
    public List<OutboundMetricsDummy> getOutboundMetricsDummy() {
        return outboundMetricsDummy;
    }
    
    public void setOutboundMetricsDummy(List<OutboundMetricsDummy> outboundMetricsDummy) {
        this.outboundMetricsDummy = outboundMetricsDummy;
    }
    
    private String selectedHandler;

    public String getSelectedHandler() {
        return selectedHandler;
    }

    public void setSelectedHandler(String selectedHandler) {
        this.selectedHandler = selectedHandler;
    }
    
    private boolean renderChannelPerformanceActionsPanel = false;

    public boolean isRenderChannelPerformanceActionsPanel() {
        return renderChannelPerformanceActionsPanel;
    }

    public void setRenderChannelPerformanceActionsPanel(boolean renderChannelPerformanceActionsPanel) {
        this.renderChannelPerformanceActionsPanel = renderChannelPerformanceActionsPanel;
    }    
    
    public String getNavigationActions() throws Exception {        
        System.out.println("=========================== Executing Navigation Actions ===========================");
        
        setRenderChannelPerformanceActionsPanel(false);                                                  
        
        if(isRenderPopupPanel()) {
            if(StringUtils.isNotBlank(getPopupDTO().getActionId())) {
                setActionId(getPopupDTO().getActionId());
                if(actionId.equals("1")){ 
                    optimizeActionInfluencers(null, actionId);                // Influencers to Follow
                } else if(actionId.equals("2")){ 
                    optimizeActionFavourites(null, actionId);                 // Tweets to Favorite
                } else if(actionId.equals("3")){ 
                    optimizeActionInfluencersToList(null, actionId);          // Influencers to List
                } else if(actionId.equals("4")){ 
                    optimizeActionRTThanks(null, actionId);                   // Retweet to Thank
                } else if(actionId.equals("9")){ 
                    optimizeActionDMToReturn(null, actionId);                 // DM to Return
                }
            }                        
        }                
                        
        return "JYM";
    }
    
    private AlertPopupDTO popupDTO;

    public AlertPopupDTO getPopupDTO() {
        return popupDTO;
    }

    public void setPopupDTO(AlertPopupDTO popupDTO) {
        this.popupDTO = popupDTO;
    }
    
    private String filterId;

    public String getFilterId() {
        return filterId;
    }

    public void setFilterId(String filterId) {
        this.filterId = filterId;
    }    
    
    private boolean renderPopupPanel = false;

    public boolean isRenderPopupPanel() {
        return renderPopupPanel;
    }

    public void setRenderPopupPanel(boolean renderPopupPanel) {
        this.renderPopupPanel = renderPopupPanel;
    }
    
    private boolean renderFilterPanel = false;

    public boolean isRenderFilterPanel() {
        return renderFilterPanel;
    }

    public void setRenderFilterPanel(boolean renderFilterPanel) {
        this.renderFilterPanel = renderFilterPanel;
    }
    
    public String getFactorInitializer() {
        setPopupDTO(null);
        setRenderPopupPanel(false);
        setRenderFilterPanel(false);
        return "";
    }
      
    public void test(ActionEvent event) {        
        String gmapFolderName = "wsdl";
        File gmapFolder = null;
        String serverHomeName = System.getProperty("jboss.server.home.dir");
        File serverHomeDirectory = new File(serverHomeName);
        outer:
        for(File file : serverHomeDirectory.listFiles()) {
            if(file.isDirectory()) {
                if(file.getName().equals("data")) {
                    for (File dataFiles : file.listFiles()) {
                        if(dataFiles.isDirectory()) {
                            if(dataFiles.getName().equals(gmapFolderName)) {
                               gmapFolder = dataFiles; 
                               break outer;
                            }
                        }
                    }
                }
            }
        }
        if(gmapFolder != null) {
            System.out.println(gmapFolder.getAbsolutePath());
        }
    }
}

