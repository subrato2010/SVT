package com.edifixio.soc.web.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.web.dto.TwitterInformation1DTO;


public class TwitterController extends BaseWebObject {
    private String twtmessage;
    private String individualTweet;
    private String geoEnabled;
    private boolean operated = false;
    private int clickedIndex;
    private String totalClicked="";
    public String getGeoEnabled() {
        return geoEnabled;
    }

    public void setGeoEnabled(String geoEnabled) {
        this.geoEnabled = geoEnabled;
    }
    private List<TwitterInformation1DTO> twitterInfoList;

    public String getTwtmessage() {
        return twtmessage;
    }

    public void setTwtmessage(String twtmessage) {
        this.twtmessage = twtmessage;
    }
    public String getIndividualTweet() {
        System.out.println("Get Message :"+individualTweet);
        return individualTweet;
    }

    public void setIndividualTweet(String individualTweet) {
        this.individualTweet = individualTweet;
    }
    public TwitterController() throws SVTException, IOException {
       if(getSessionAttribute("GEO") == null)
           setSessionAttribute("GEO", "OFF");
       setGeoEnabled(getSessionAttribute("GEO"));
    }
    
    public String sendTweetBasedOnRule()  {
        setSessionAttribute("index", getParameter("sendMsg"));
        return "";
    }
    public void geoLocationEnable(ActionEvent ae) throws SVTException, IOException {
        setTotalClicked("");
        if(getGeoEnabled().trim().equals("ON"))  {
            setGeoEnabled("OFF");
            setSessionAttribute("GEO", getGeoEnabled());
        }  else  {    
            setGeoEnabled("ON");
            setSessionAttribute("GEO", getGeoEnabled());
        }
        twittMessage(ae);
    }
    public void twittMessage(ActionEvent ae) throws SVTException, IOException {
        setSessionAttribute("twitterController", this); 
        setTotalClicked("");
        setOperated(false);
        
        if(ae.getComponent().getId().equals("whatIsHappening"))
        {
                if (getTwtmessage().trim().equals("") || getTwtmessage() == null) {
                    System.out.println("Empty Data Can't Be Twitt !!!!");
                    setTwtmessage("");
                    return;
                }
                setSessionAttribute("twtMsg", twtmessage);
        }
        if(ae.getComponent().getId().equals("refreshTwitt") || ae.getComponent().getId().equals("geoEnabled") ||
           ae.getComponent().getId().equals("dropDown"))
            setSessionAttribute("Msg", "showTwitt");
        if(ae.getComponent().getId().equals("whatIsHappening"))
        {
            setSessionAttribute("Msg", "whatIsHappening");
            setSessionAttribute("twtMsg", getTwtmessage());
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("./signin");
        setTwtmessage("");
        setSessionAttribute("twitterController", this);
        setSessionAttribute("callbackURL", getParameterMgr().getCallbackURL());
        // HttpRequest request = (HttpRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    
    public List<TwitterInformation1DTO> getTwitterInfoList() {
        return twitterInfoList;
    }
    public ReplyTwitterDataController getTwitterReplyInstance()
    {
        return (ReplyTwitterDataController)FacesContext.getCurrentInstance().
                    getExternalContext().getRequestMap().
                    get("replyTwitterDataController");
    }
    public void sendReply(ActionEvent ae) throws IOException
    {
        setSessionAttribute("reply",getSessionAttribute("indexValue"));
        setSessionAttribute("clickSide",getSessionAttribute("sideClicked"));
        setSessionAttribute("replyTwitterController", getTwitterReplyInstance());
        FacesContext.getCurrentInstance().getExternalContext().redirect("./signin");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("./twitterChannelOptimization.jsp?refresh=0");
    }
    
    public void sendReTweet(ActionEvent ae) throws IOException
    {
        setSessionAttribute("retweet",getSessionAttribute("indexValue"));
        setSessionAttribute("clickSide",getSessionAttribute("sideClicked"));
        setSessionAttribute("replyTwitterController", getTwitterReplyInstance());
        FacesContext.getCurrentInstance().getExternalContext().redirect("./signin");
    }

    public void setTwitterInfoList(List<TwitterInformation1DTO> twitterInfoList) {
        twitterInfoList = noOfTwitterInfoList(twitterInfoList);
        this.twitterInfoList = twitterInfoList;
    }
 
    
    public List<TwitterInformation1DTO> noOfTwitterInfoList(List<TwitterInformation1DTO> twitterInfoList) {
        int count=0;
        List<TwitterInformation1DTO> tempDTO  = new ArrayList<TwitterInformation1DTO>();
        if(count <= twitterInfoList.size())
        {
            for(;count<twitterInfoList.size(); count++)
            {
                if(tempDTO.size()<4)
                    tempDTO.add(twitterInfoList.get(count));
                else break;
            }
        }
        /*for(TwitterInformation1DTO dto : twitterInfoList)
        {
            if(tempDTO.size()<3)
                tempDTO.add(dto);
            else break;
        }*/
        System.out.println("TempDTO size !!! :"+tempDTO.size());
        return tempDTO;
    }

    public boolean isOperated() {
        return operated;
    }

    public void setOperated(boolean operated) {
        this.operated = operated;
    }

    public int getClickedIndex() {
        return clickedIndex;
    }

    public void setClickedIndex(int clickedIndex) {
        this.clickedIndex = clickedIndex;
    }

    public String getTotalClicked() {
        return totalClicked;
    }

    public void setTotalClicked(String totalClicked) {
        this.totalClicked = totalClicked;
    }
}
