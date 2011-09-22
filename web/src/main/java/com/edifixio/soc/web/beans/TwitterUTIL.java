package com.edifixio.soc.web.beans;

    import java.util.List;

import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.Paging;
import twitter4j.Place;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UserList;
import twitter4j.http.AccessToken;
import twitter4j.internal.org.json.JSONException;
    
public class TwitterUTIL {
    
        
        static Twitter twitter;
        static{
            try        {
                String consumerKey="9fYYcY3Rrtf9FYsQmxnfTQ";
                String consumerSecret = "rHEZXMRzh2PERdhtmQfpaK2XdjyRhCD3xlRx0JrrxM";
                
                String token = "213184628-iC9YdA3Es1LEdJWZ433grSQDBEZxIjqQjRK9XRYN";
                String tokenSecrete = "zA8IybEVPmXS9D1dR513frP8NFgW7Mws4CGUXbL4E";
                AccessToken accessToken = new AccessToken(token,tokenSecrete);
                
                TwitterFactory twitterFactory = new TwitterFactory();
                
                twitter = twitterFactory.getInstance();
                twitter.setOAuthConsumer(consumerKey, consumerSecret);

                twitter.setOAuthAccessToken(accessToken);
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
        public void getAllTwitterData() throws TwitterException        {
           
                Paging paging = new Paging(1,10);
                
                //Twitter twitter1 = new TwitterFactory().getInstance();
                List<Status> response = twitter.getHomeTimeline();
                //List<Status> response = twitter1.getUserTimeline("neel8100", paging);
                /*Query query = new Query("andrewhyde");
                QueryResult result = twitter.search(query);
                result.getTweets();
                for(Tweet tweet : result.getTweets())
                    if(tweet.getGeoLocation() != null)
                        System.out.println(tweet.getGeoLocation());*/
                for (Status twittStatus : response) {
                    if(twittStatus.getUser().getId() == twitter.getId())
                        twitter.updateStatus(twittStatus.getText()+" Newly Added...", twitter.getId());
                    //System.out.println(twittStatus.getId()+" : "+twittStatus.getInReplyToUserId()+" : "+twittStatus.getUser().getId()+":"+twitter.getId());
                }
                
        }
        
        public void getUserListTweets() throws TwitterException {
        }
        
        public static void main(String ar[]) throws TwitterException,InterruptedException, JSONException    {
            new TwitterUTIL().getAllTwitterData();
        }
        
     public void getGEOLocation1() throws TwitterException {
             long startTime = System.currentTimeMillis();
             Query query = new Query("andrewhyde");
             //Query query = new Query("neel8100");
             //query.setGeoCode(new GeoLocation(50.0, 10.0), 1000.0,Query.KILOMETERS);
             QueryResult result = twitter.search(query);
             
             
             
             for (Tweet tweet : result.getTweets())     {
                 if(tweet.getGeoLocation() != null) {
                     GeoLocation geoLocation = tweet.getGeoLocation();
                         System.out.println(tweet.getText()+" : "+geoLocation.getLatitude()+"  :  "+geoLocation.getLongitude());
                 }
             /*System.out.println(tweet.getCreatedAt() +" user: " +tweet.getFromUser()+" text: " 
                     + " loc: " + tweet.getGeoLocation());*/
         }
             System.out.println("Total Execution Time : "+(System.currentTimeMillis()-startTime));
     }
     public void getGEOLocation() throws TwitterException {
         System.out.println("Inside getGEOLOcation ....");
         Twitter twitter1 = new TwitterFactory().getInstance();
         //GeoLocation geoLocation = twitter1.showUser("andrewhyde").getStatus().getGeoLocation();
         GeoLocation geoLocation = new GeoLocation(51.5001524,-0.1262362);//twitter1.showUser("andrewhyde").getStatus().getGeoLocation();
         System.out.println(geoLocation.getLatitude()+"   :   "+geoLocation.getLongitude());
         // London : 51.3026 :  0.739
         // Kolkata : 22.3411 : 88.2211
         // Delhi : 28.3650 : 77.1232
         // 51.5001524 : -0.1262362
         
         //Query query = new Query("geocode="+geoLocation.getLatitude()+","+geoLocation.getLongitude());
         GeoQuery query = new GeoQuery(geoLocation);
                  
         System.out.println(twitter1.getNearbyPlaces(query));
         for(Place place : twitter1.getNearbyPlaces(query))
             System.out.println(" Reverse Geo Code Is : "+place.getPlaceType()+"  :  "+place.getName()+"  :  "+place.getURL());
    }  
        
        public void getList() throws TwitterException
        {
            for(UserList list : twitter.getUserLists("terametric",-1))
                System.out.println(list.getFullName());
        }
        
        void getMyLocation() throws TwitterException, JSONException {
            Place place = twitter.getGeoDetails("086752cb03de1d5d");
            System.out.println(place.getFullName());
        }
        
        public String getBitlyUrlString(String twtMsg)
        {
            int place = 0; 
            String fullBitlyURL="";
            
            String[] tempMsgArr = twtMsg.trim().split(" ");
            for (String bitly : tempMsgArr) {
                if(bitly.startsWith("http://bit.ly/"))   {
                    fullBitlyURL = tempMsgArr[place];
                    break;
                }
                place++; 
            }
            return fullBitlyURL;
        }
}
