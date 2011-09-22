package com.edifixio.soc.web.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import twitter4j.TwitterException;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.web.dto.TwitterActionsAjaxDTO;
import com.edifixio.soc.web.dto.TwitterRTOPNotifyDTO;
import com.google.gson.Gson;

public class JSONController extends BaseWebObject{
    private final static Log log = LogFactory.getLog(JSONController.class);
    
    
    /**
     * Post for influencers(action: "delete" or "followed"), favourites(action: "delete" or "favorited"), retweets(action: "delete" or "thanked")
     * @param twitterUserId
     * @param jsonApiName
     * @param ajaxDto
     * @return
     * @throws TwitterException
     * @throws SVTException
     */
    public String postToJSONApi(String twitterUserId, String jsonApiName, TwitterActionsAjaxDTO ajaxDto) throws TwitterException, SVTException
    {
        Gson gson = new Gson(); // json-1.7.1        
        //convert java object to JSON  
        if(ajaxDto == null){
            log.debug("Invalid Object: cannot be null.");
            return ""; // invalid object
        }
        String obj = gson.toJson(ajaxDto);
        System.out.println("[" + obj + "]");
        postToURL(getDatashiftAPIURL(jsonApiName, twitterUserId),obj);

        return obj;
    }

    /**
     * notify RTOP on login{ "type": "login" } and profile change({ "type": "update" } )
     * @param jsonApiName
     * @param ajaxDto
     * @return
     * @throws TwitterException
     * @throws SVTException
     */
    public String postToJSONApi(String jsonApiName, TwitterRTOPNotifyDTO ajaxDto) throws TwitterException, SVTException
    {
        Gson gson = new Gson(); // json-1.7.1        
        //convert java object to JSON  
        if(ajaxDto == null){
            log.debug("Invalid Object: cannot be null.");
            return ""; // invalid object
        }
        String obj = gson.toJson(ajaxDto);
        System.out.println("[" + obj + "]");
        postToURL(getDatashiftAPIURL(jsonApiName, null),obj);

        return obj;
    }

    //------------ Don't touch after this line -------------------------//

    protected String getDatashiftAPIURL(String apiName, String twitterUserId) throws SVTException{
        String url = getParameterMgr().getDatashiftAppURL();
        if(url == null){
            url = "http://twitterroiqa.edifixio.co.in:8001/";
        }
        if(apiName.equalsIgnoreCase("collectNegative")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectNegative"; 
        }else if(apiName.equalsIgnoreCase("collectPositive")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectPositive"; 
        }else if(apiName.equalsIgnoreCase("collectBitly")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectBitly"; 
        }
        else if(apiName.equalsIgnoreCase("collectInfluence")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectInfluence"; 
        }
        else if(apiName.equalsIgnoreCase("collectBrand")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectBrand"; 
        }
        else if(apiName.equalsIgnoreCase("collectProduct")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectProduct"; 
        }
        else if(apiName.equalsIgnoreCase("collectIndustry")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectIndustry"; 
        }
        else if(apiName.equalsIgnoreCase("collectMention")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectMention"; 
        }
        else if(apiName.equalsIgnoreCase("collectThemes")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectThemes"; 
        }
        else if(apiName.equalsIgnoreCase("collectHashtags")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/status/collectHashtags"; 
        }
        else if(apiName.equalsIgnoreCase("all")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/picks"; 
        }
        else if(apiName.equalsIgnoreCase("actions")){
            //http://twitterroiqa.edifixio.co.in:8001/profile/1/actions
            if(twitterUserId != null){
                url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId +"/actions";   
            }else{
                url += "profile/" + getCurrentProfileId() + "/actions";    
            }             
        }
        else if(apiName.equalsIgnoreCase("actionsinfluencers")){
            //http://twitterroiqa.edifixio.co.in:8001/profile/1/twitter/terametric/actions/influencers
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/actions/influencers"; 
        }else if(apiName.equalsIgnoreCase("actionsinfluencerstolist")){
            //http://twitterroiqa.edifixio.co.in:8001/profile/1/twitter/terametric/actions/influencers_to_list
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/actions/influencers_to_list"; 
        }        
        else if(apiName.equalsIgnoreCase("actionsfavourites")){
            //http://twitterroiqa.edifixio.co.in:8001/profile/1/twitter/terametric/actions/influencers
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/actions/favourites"; 
        }else if(apiName.equalsIgnoreCase("actionsretweets")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/actions/retweets"; 
        }
        
        // TODO This should invoke the DM to Return API. Change the API endpoint to that of DM. For testing it now invokes retweets API endpoint
        else if(apiName.equalsIgnoreCase("actionsdmtoreturn")){
            url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/actions/retweets"; 
        }
        
        else if(apiName.equalsIgnoreCase("textsuggestion")){
            //http://twitterroiqa.edifixio.co.in:8001/profile/1/query?q=f
            url += "profile/" + getCurrentProfileId() + "/query?q="; 
        }else if(apiName.equalsIgnoreCase("queryrecommend")){
            //http://twitterroiqa.edifixio.co.in:8001/profile/1/text
            url += "profile/" + getCurrentProfileId() + "/text"; 
        }else if(apiName.equalsIgnoreCase("ajax")){
            //profile/_profile_/twitter/_twitter_/ajax
            if(twitterUserId != null){
                url += "profile/" + getCurrentProfileId() + "/twitter/" + twitterUserId + "/ajax";    
            }else{
                url += "profile/" + getCurrentProfileId() + "/ajax";    
            }
        }
        
        System.out.println(url);
        return url;
    }
    
    public String getSampleJSON(String filename) {
        File aFile = new File("D:\\samplejson\\" + filename);
        
        StringBuilder contents = new StringBuilder();
        try {
          //use buffering, reading one line at a time
          //FileReader always assumes default encoding is OK!
          BufferedReader input =  new BufferedReader(new FileReader(aFile));
          try {
            String line = null; //not declared within while loop
            /*
            * readLine is a bit .... :
            * it returns the content of a line MINUS the newline.
            * it returns null only for the END of the stream.
            * it returns an empty String if two newlines appear in a row.
            */
            while (( line = input.readLine()) != null){
              contents.append(line);
              contents.append(System.getProperty("line.separator"));
            }
          }
          finally {
            input.close();
          }
        }
        catch (IOException ex){
          ex.printStackTrace();
        }
        
        return contents.toString();
      }
    
    /**
     * This method posts the response to rtop api
     * @param type - type of post
     * @throws TwitterException
     * @throws SVTException
     */
    public void sendResponseToRTOP(String type) throws TwitterException, SVTException {
        TwitterRTOPNotifyDTO ajaxDto = new TwitterRTOPNotifyDTO();
        ajaxDto.setType(type);
        postToJSONApi("ajax", ajaxDto);   
    }
    
   /**
    * This method posts the response to rtop api  
    * @param id - id will be either tweet-id or user-id
    * @param action - action to be performed
    * @param type - type of post
    * @param twitterUserName - username
    * @throws TwitterException
    * @throws SVTException
    */
    public void sendResponseToRTOP(String id, String action, String type, String twitterUserName) throws TwitterException, SVTException {        
        TwitterActionsAjaxDTO ajaxDto = new TwitterActionsAjaxDTO();        
        ajaxDto.setAction(action);
        ajaxDto.setType(type);
        if(type != null && (type.equalsIgnoreCase("influencers") || type.equalsIgnoreCase("influencers_to_list"))){
            ajaxDto.setUser_id(id);
        } else {            
            ajaxDto.setTweet_id(id);            
        }
        postToJSONApi(twitterUserName, "ajax", ajaxDto);
    }
}
