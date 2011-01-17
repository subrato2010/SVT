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
    private List<TwitterInformation1DTO> twitterInfoList;

    public String getTwtmessage() {
        return twtmessage;
    }

    public void setTwtmessage(String twtmessage) {
        this.twtmessage = twtmessage;
    }

    public TwitterController() throws SVTException, IOException {
        System.out.println("Parameter Value Is :"+getParameter("sendTwt"));
        if(getParameter("sendTwt")== null ||getParameter("sendTwt").equals(""));
        else
        if(getParameter("sendTwt").equalsIgnoreCase("sendTwt"))
            sendIndividualTwitt(null);
    }

    public void twittMessage(ActionEvent ae) throws SVTException, IOException {
        
        if(ae.getComponent().getId().equals("whatIsHappening"))
        {
                if (getTwtmessage().trim().equals("") || getTwtmessage() == null) {
                    System.out.println("Empty Data Can't Be Twitt !!!!");
                    setTwtmessage("");
                    return;
                }
                setSessionAttribute("twtMsg", twtmessage);
        }
        if(ae.getComponent().getId().equals("refreshTwitt"))
            setSessionAttribute("Msg", "showTwitt");
        if(ae.getComponent().getId().equals("whatIsHappening"))
        {
            System.out.println("Clicked On :"+ae.getComponent().getId());
            setSessionAttribute("Msg", "whatIsHappening");
            setSessionAttribute("twtMsg", getTwtmessage());
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("./signin");
        setTwtmessage("");
        setSessionAttribute("twitterController", this);
        // HttpRequest request = (HttpRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    
    public List<TwitterInformation1DTO> getTwitterInfoList() {
        return twitterInfoList;
    }
    
    public void sendIndividualTwitt(ActionEvent ae) throws IOException
    {
        int index;
        if(ae.getComponent().getId().equals("reply"))        {
            index= Integer.parseInt(getParameter("reply"));
            setSessionAttribute("reply",index);
        }
        
        else if(ae.getComponent().getId().equals("retweet")) {
            index= Integer.parseInt(getParameter("retweet"));
            setSessionAttribute("retweet",index);
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("./signin");
        //FacesContext.getCurrentInstance().getExternalContext().redirect("./twitterChannelOptimization.jsp?refresh=0");
    }

    public void setTwitterInfoList(List<TwitterInformation1DTO> twitterInfoList) {
        twitterInfoList = noOfTwitterInfoList(twitterInfoList);
        this.twitterInfoList = twitterInfoList;
    }
    public List<TwitterInformation1DTO> noOfTwitterInfoList(List<TwitterInformation1DTO> twitterInfoList) {
        List<TwitterInformation1DTO> tempDTO  = new ArrayList<TwitterInformation1DTO>();
        for(TwitterInformation1DTO dto : twitterInfoList)
        {
            if(tempDTO.size()<6)
                tempDTO.add(dto);
            else break;
        }
        return tempDTO;
    }
}
