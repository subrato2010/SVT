package com.edifixio.soc.web.controllers.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edifixio.soc.web.controllers.TwitterController;
import com.edifixio.soc.web.dto.TwitterInformation1DTO;
import com.edifixio.soc.web.dto.TwitterInformationDTO;

import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.http.AccessToken;
import twitter4j.http.Authorization;
import twitter4j.http.RequestToken;


public class ManageTwitterOperations {
    Twitter twitter;
    RequestToken requestToken;
    String verifier;
    AccessToken accessToken;
    HttpServletRequest request;
    HttpServletResponse response;
    TwitterController twitterController;
    boolean flag;
    public void createInstances(Twitter twitter, RequestToken requestToken,
            String verifier, AccessToken accessToken,
            HttpServletRequest request, HttpServletResponse response, 
            boolean flag, TwitterController twitterController) throws ServletException, IOException
     {
        this.twitter = twitter;
        this.requestToken = requestToken;
        this.verifier = verifier;
        this.request = request;
        this.response = response;
        this.twitterController = twitterController;
        this.flag = flag;
        try {
            this.accessToken = twitter.getOAuthAccessToken(requestToken, verifier);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        operateOnTwitter();
    }
    public void operateOnTwitter() throws ServletException, IOException
    {
        try {
             if(request.getSession().getAttribute("Msg")!=null)
             {
                 if(request.getSession().getAttribute("Msg").equals("showTwitt")) {
                     twitterController.setTwitterInfoList(assignTwitterInformations());
                     flag=true;
                 }
                 else if(request.getSession().getAttribute("Msg").equals("whatIsHappening")) 
                     twitter.updateStatus(request.getSession().getAttribute("twtMsg").toString());
                 request.getSession().setAttribute("Msg", "");
             }
             if(request.getSession().getAttribute("reply") !=null)
             {
                 System.out.println("The Session Value REPLY :"+request.getSession().getAttribute("reply"));
                 if(request.getSession().getAttribute("reply").equals(""));
                 else {
                     replyToTweet(Integer.parseInt(request.getSession().getAttribute("reply")+"")-1);
                     flag=true;
                     request.getSession().setAttribute("reply", "");
                 }
             }
             if(request.getSession().getAttribute("retweet") !=null)
             {
                 System.out.println("The Session Value RETWEET :"+request.getSession().getAttribute("retweet"));
                 if(request.getSession().getAttribute("retweet").equals(""));
                 else {
                     reTwittMessage(Integer.parseInt(request.getSession().getAttribute("retweet")+"")-1);
                     flag=true;
                     request.getSession().setAttribute("retweet", "");
                 }
             }
     } catch (TwitterException e) {
         request.getSession().setAttribute("retweet", "");
         request.getSession().setAttribute("reply", "");
         request.getSession().setAttribute("Msg", "");
     }
         if( flag == true )
             response.sendRedirect("./twitterChannelOptimization.jsp?refresh=0");
         else
             response.sendRedirect("./twt.jsp");
    }
    int index;
    long statusID;
    String status;
    long id;
    public void reTwittMessage(int index) throws TwitterException //Tested OK
    {
        try
        {
            this.index = index;
            this.statusID = assignTwitterInformations().get(index).getDtoLeft().getTwitterStatusID();
            Status status = twitter.retweetStatus(id);
            System.out.println("Retwitted : "+status.isRetweet()+" : "+status.getRetweetCount());
        }catch(Exception e){
            System.out.println("Error : This Message can't retwitt or already retwitted...");
        }
    }
    public void replyToTweet(int index) throws TwitterException 
    {
            //TODO: this code will be change according to the getDTOLeft and getDTORight
            /*this.index = index;
            this.statusID = assignTwitterInformations().get(index).getDtoLeft().getTwitterStatusID();
            this.id = assignTwitterInformations().get(index).getDtoLeft().getTwitterID();
            status = assignTwitterInformations().get(index).getDtoLeft().getTwittMessage();
            StatusUpdate reply = new StatusUpdate("This Is My Reply From JBOSS Server...").inReplyToStatusId(statusID);
            System.out.println(reply.getInReplyToStatusId()+"  :  "+reply.getStatus()+" : "+reply.isDisplayCoordinates());*/
            
            String twittName = assignTwitterInformations().get(index).getDtoLeft().getTwitterName();
            String twitMessage = assignTwitterInformations().get(index).getDtoLeft().getTwittMessage();
            twitter.updateStatus("@"+twittName+" "+twitMessage);
            System.out.println("Reply Twitt Successful ....");
    }
    
    public List<TwitterInformation1DTO> assignTwitterInformations() throws TwitterException    {
        List <TwitterInformation1DTO> informationDTOList = new ArrayList<TwitterInformation1DTO>();
        TwitterInformationDTO twitterInformationDTO=null;
        int flag=0;
        int cnt=0;
        TwitterInformation1DTO dto = new TwitterInformation1DTO();
        for(Status twittStatus : twitter.getHomeTimeline()) {
            try  {
                    Query query = new Query(twittStatus.getUser().getScreenName());
                    QueryResult result = twitter.search(query);
                   
                    cnt++;
                   twitterInformationDTO = new TwitterInformationDTO();
                   twitterInformationDTO.setTwitterName(twittStatus.getUser().getScreenName());
                   twitterInformationDTO.setTwittMessage(twittStatus.getText());
                   twitterInformationDTO.setNoOfFollowers(twittStatus.getUser().getFollowersCount());
                   twitterInformationDTO.setNoOfFollowings(twittStatus.getUser().getFriendsCount());
                   twitterInformationDTO.setNoOfListed(twittStatus.getUser().getListedCount()); 
                   twitterInformationDTO.setNoOfTweets(result.getTweets().size());
                   twitterInformationDTO.setTwittLocation(twittStatus.getUser().getLocation());
                   twitterInformationDTO.setTwittDate(twittStatus.getCreatedAt().toString());
                   twitterInformationDTO.setBackGroundImage(twittStatus.getUser().getProfileBackgroundImageUrl());
                   twitterInformationDTO.setProfileImage(twittStatus.getUser().getProfileImageURL().toString());
                   twitterInformationDTO.setCnt(cnt);
                   twitterInformationDTO.setTwitterID(twittStatus.getUser().getId());
                   twitterInformationDTO.setTwitterStatusID(twittStatus.getId());
                   
                   if(flag==0) {
                       dto.setDtoLeft(twitterInformationDTO);
                       flag=1;
                   } else {
                       dto.setDtoRight(twitterInformationDTO);
                       informationDTOList.add(dto);
                       dto = new TwitterInformation1DTO();
                       flag=0;
                   }
            }
            catch(Exception e){
                System.out.println("Error :"+e.getMessage());
            }
        }
        dto.setDtoLeft(twitterInformationDTO); 
        return informationDTOList;
    }
}
