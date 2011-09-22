package com.edifixio.soc.web.controllers;

    import java.io.File;
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
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.http.AccessToken;
import twitter4j.internal.org.json.JSONException;
    
public class TwitterUTIL {
    
        
        static Twitter twitter;
        static{
            try        {
                //String consumerKey="9fYYcY3Rrtf9FYsQmxnfTQ";
                //String consumerSecret = "rHEZXMRzh2PERdhtmQfpaK2XdjyRhCD3xlRx0JrrxM";
                //String token = "213184628-iC9YdA3Es1LEdJWZ433grSQDBEZxIjqQjRK9XRYN";
                //String tokenSecrete = "zA8IybEVPmXS9D1dR513frP8NFgW7Mws4CGUXbL4E";
                
                String consumerKey = "ryk2PdQ9XTLdvKgyCYBpw";
                String consumerSecret = "qhurtva6Z6uwH398ED0F41CUDr82lFyPksFRRWFFkk";
                
                String token = "293913155-kvlcxgXN9jAwGUg32eP87Hb6XGkPlhojQgUm03pa";
                String tokenSecrete = "DAtOYs9fRu3KfQBRXdc5GyZfiUqUcuQ5hkwKPvLDQ";
                
                
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
                Paging paging = new Paging(1,7);
                List<Status> response = twitter.getHomeTimeline(paging);
                for (Status twittStatus : response) {
                    System.out.println(twittStatus.getText()+" Is Retweeted By Me : "+twittStatus.isRetweetedByMe());
                    System.out.println(twittStatus.getText()+" Is Retweeted : "+twittStatus.isRetweet());
                }
                
            
        }
     public void getGEOLocation1() throws TwitterException {
             long startTime = System.currentTimeMillis();
             Query query = new Query("andrewhyde");
             //Query query = new Query("neel8100");
             query.setGeoCode(new GeoLocation(50.0, 10.0), 1000.0,Query.KILOMETERS);
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
     public void getGEOLocation() throws TwitterException 
     {
         long startTime = System.currentTimeMillis();
         
         GeoLocation geoLocation = twitter.showUser("andrewhyde").getStatus().getGeoLocation();
         //GeoLocation geoLocation = twitter.showUser("themattharris").getStatus().getGeoLocation();
         
         //System.out.println(twitter.showUser("andrewhyde").getStatus());
         
         if(geoLocation != null)
         {
             GeoQuery query = new GeoQuery(geoLocation);
             
             System.out.println("Latitude :"+geoLocation.getLatitude());
             System.out.println("Longitude :"+geoLocation.getLongitude());
             
             for(Place place : twitter.getNearbyPlaces(query))
                 System.out.println(" Reverse Geo Code Is : "+place.getFullName() +"  :  "+ place.getId());
             
             for(Place place : twitter.reverseGeoCode(query))
                 System.out.println(" Reverse Geo Code Is : "+place.getFullName());
         }
         
         System.out.println("Total Execution Time : "+(System.currentTimeMillis()-startTime));
    }  
     
     private boolean isFileExtensionImage(String fileName)
     {
         boolean fileExtensionFlag = false;
         String extension = "";
         
         int dotPosition = fileName.lastIndexOf(".");
         extension = fileName.substring(dotPosition+1);
         
         System.out.println(extension);
         
         return fileExtensionFlag;
     }
     
     
        public static void main(String ar[]) throws TwitterException,InterruptedException, JSONException    {
            
           // new TwitterUTIL().getAllTwitterData();
           // new TwitterUTIL().getList();
            
            File image = new File("C:\\Documents and Settings\\All Users\\Documents\\My Pictures\\Sample Pictures\\Winter.jpg");

              
            //new TwitterUTIL().reportUserAsSpam("");
            //new TwitterUTIL().isFileExtensionImage("C:\\Documents and Settings\\All Users\\Documents\\My Pictures\\Sample Pictures\\Winter.jpg");
            //new TwitterUTIL().updateUserProfileBackgroungImage(image);
            
            //new TwitterUTIL().getListOfFollowers("neel8100");
            //new TwitterUTIL().getListOfFollowing("neel8100");
            
            //new TwitterUTIL().followUser("google");
            
            long tweetId = 68044728729481220L;
            //new TwitterUTIL().setTweetToFavorite(tweetId);
            twitter.updateStatus("@neel8100 Welcome to Twitter world, by Sandipan.");
            
            //new TwitterUTIL().getMyLocation();
           // new TwitterUTIL().getGEOLocation();
            //new TwitterUTIL().getGEOLocation1();
            
            
            /*ArrayList<String> arrayList1 = new ArrayList<String>();
            arrayList1.add("1");
            arrayList1.add("2");
            arrayList1.add("3");

            ArrayList<String> arrayList2 = new ArrayList<String>();

            arrayList2.add("One");
            arrayList2.add("Two");
            arrayList2.add("Three");
            arrayList2.add("Four");
            arrayList2.add("Five");

            //System.out.println(arrayList2);

            //Collections.copy(arrayList2, arrayList1);
            
            arrayList1.addAll(arrayList2);
            System.out.println(arrayList1);*/
        }
        
        
        public void setTweetToFavorite(long tweetId) throws TwitterException
        {
            System.out.println(twitter.createFavorite(tweetId));
        }
        
        
        public void getList() throws TwitterException
        {
            //System.out.println("List : "+twitter.showUserList("subrato9009", twitter.getId()));
            //System.out.println(twitter.getUserLists("neel8100",-1));
            
            for(UserList list : twitter.getUserLists("neel8100",-1))
                System.out.println(list.getName());
        }
        
        public void getMyLocation() throws TwitterException, JSONException {
            //System.out.println(twitter.getAccountSettings().isGeoEnabled());
            Place place = twitter.getGeoDetails("96683cc9126741d1");
            System.out.println(place);
        }
        
        // returns the names of users following the given screenName 
        public void getListOfFollowers(String screenName) throws TwitterException
        {
            int [] followersList = twitter.getFollowersIDs(screenName).getIDs();
            
            for(int i=0;i<followersList.length;i++)
            {
                System.out.println("Follower name : "+twitter.showUser(followersList[i]).getScreenName());
            }
        }
        
     // returns the names of users followed by the given screenName 
        public void getListOfFollowing(String screenName) throws TwitterException
        {
            int[] followingList = twitter.getFriendsIDs(screenName).getIDs();
            
            for(int i=0;i<followingList.length;i++)
            {
                System.out.println("Following name : "+twitter.showUser(followingList[i]).getScreenName());
            }
            
           
        }
        
        // to follow a given user
        public void followUser(String screenName) throws TwitterException
        {
            if(!twitter.existsFriendship(twitter.getScreenName(), screenName))
            {
              User user = twitter.createFriendship(screenName);
              System.out.println("Started following : "+user.getName());
            }
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
        
        public void reportUserAsSpam(String screenName) throws TwitterException
        {
            
            if(screenName != null && screenName.trim().length() > 0)
            {
                User user = twitter.reportSpam(screenName);
                             
                System.out.println("user ::: "+user);
                System.out.println("user status ::: "+user.getStatus());
            }
            else
            {
                System.out.println("Twitter screenName is null or empty !!!!!!!!!");
            }
        }
        
        public void updateUserProfilePic(File profilePic) throws TwitterException
        {
            twitter.updateProfileImage(profilePic);
        }
        
        public void updateUserProfileBackgroungImage(File profileBkgPic) throws TwitterException
        {
            twitter.updateProfileBackgroundImage(profileBkgPic, true);
        }
        
       
}
