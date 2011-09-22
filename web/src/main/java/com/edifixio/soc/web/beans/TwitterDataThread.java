package com.edifixio.soc.web.beans;

import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitterDataThread {
    
    Twitter twitter;
    public void getAllTwitterData() 
    {
        try        {
            String consumerKey="9fYYcY3Rrtf9FYsQmxnfTQ";
            String consumerSecret = "rHEZXMRzh2PERdhtmQfpaK2XdjyRhCD3xlRx0JrrxM";
            
            //String token = "213184628-iC9YdA3Es1LEdJWZ433grSQDBEZxIjqQjRK9XRYN";
            //String tokenSecrete = "zA8IybEVPmXS9D1dR513frP8NFgW7Mws4CGUXbL4E";
            //AccessToken accessToken = new AccessToken(token,tokenSecrete);
            
            //twitter = new TwitterFactory().getOAuthAuthorizedInstance(consumerKey,consumerSecret,accessToken);
            twitter = new TwitterFactory().getOAuthAuthorizedInstance(consumerKey,consumerSecret);
            /*
             * //Working Block
             Paging paging = new Paging(1,200);
            List<Status> response = twitter.getHomeTimeline(paging.sinceId(47155764846002178l));
            */
            
            Paging paging = new Paging(1,10);//,47128848831221760l,47137660099239936l);
            //Paging paging = new Paging(1,200,47128848831221760L,47137660099239936L);
            List<Status> response = twitter.getHomeTimeline(paging);
            //Search From  : 47137660099239936 (max ID)
            // Up to  : 47128848831221760 (since ID)
            int i=0;
            for (Status twittStatus : response) {
                //System.out.println(twittStatus.getText()+" : "+twittStatus.getCreatedAt());
                i++;
                System.out.println(i+" : "+twittStatus.getText()+" : "+twittStatus.getCreatedAt()+" : "+twittStatus.getId());
                System.out.println(twitter.getScreenName()+" : "+twittStatus.getUser().getScreenName());
            }
            //System.out.println("\n\nShow Tweet By Status ID : "+twitter.showStatus(47137660099239936L).getText());
            System.out.println("\n\nShow Tweet By Status ID : "+ ((Status)response.get((response.indexOf(47137660099239936l)))).getText());
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String ar[]) throws TwitterException,InterruptedException    {
        new TwitterDataThread().getAllTwitterData();
    }
 }
