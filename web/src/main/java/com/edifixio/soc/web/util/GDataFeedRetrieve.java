package com.edifixio.soc.web.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gdata.client.analytics.AnalyticsService;
import com.google.gdata.data.analytics.AccountEntry;
import com.google.gdata.data.analytics.AccountFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;


public class GDataFeedRetrieve {
	private static String UrlString = "https://www.google.com/analytics/feeds/accounts/default?max-results=50";
	private AnalyticsService analyticsService=null;
	
	public GDataFeedRetrieve(String userName, String password) throws AuthenticationException{
	      // Service Object to work with the Google Analytics Data Export API.
	      this.analyticsService = new AnalyticsService("gaExportAPI_acctSample_v1.0");

	      // Client Login Authorization.
	      this.analyticsService.setUserCredentials(userName, password);

	}

	public List<AccountEntry> getAccountFeed()throws IOException, MalformedURLException, ServiceException {
		ArrayList <AccountEntry> output=null;
		if(analyticsService!=null){
			// Construct query from a string.
		    URL queryUrl = new URL(UrlString);
		
		   // Make request to the API.
		   AccountFeed accountFeed = analyticsService.getFeed(queryUrl, AccountFeed.class);
		
		   // Output the data to the screen.
		   output=new ArrayList();
		   for (AccountEntry entry : accountFeed.getEntries()) {
			   output.add(entry);
		   }
		}
		return output;
	}
	
	public String[] getAccountFeedByProperty(String propertyName)throws IOException, MalformedURLException, ServiceException {
		String output[]=null;
		if(this.analyticsService!=null && propertyName!=null && propertyName.length()>1 ){
			// Construct query from a string.
		    URL queryUrl = new URL(UrlString);
		
		   // Make request to the API.
		   AccountFeed accountFeed = analyticsService.getFeed(queryUrl, AccountFeed.class);
		
		   // Output the data to the screen.
		   String str="";
		   for (AccountEntry entry : accountFeed.getEntries()) {
			   str=str+entry.getProperty(propertyName)+"|";
		   }
		   str=str.substring(0,str.length()-1);
		   output = str.split("\\|");
		}
		return output;
	}
	
	public String[][] getAccountFeedByPropertyWithTableId(String propertyName)throws IOException, MalformedURLException, ServiceException {
        String output[][]=null;
        String output1[]=null;
        String output2[]=null;
        if(this.analyticsService!=null && propertyName!=null && propertyName.length()>1 ){
            // Construct query from a string.
            URL queryUrl = new URL(UrlString);
        
           // Make request to the API.
           AccountFeed accountFeed = analyticsService.getFeed(queryUrl, AccountFeed.class);
        
           // Output the data to the screen.
           String str="";
           String strTableId="";
           for (AccountEntry entry : accountFeed.getEntries()) {
               
               //str=str+entry.getProperty(propertyName)+"|"; // currently not in use
               str=str+entry.getTitle().getPlainText()+"|"; // no property is associated with Title
               strTableId=strTableId+entry.getTableId().getValue()+"|";
           }
           str=str.substring(0,str.length()-1);
           strTableId=strTableId.substring(0,strTableId.length()-1);
           output1 = str.split("\\|");
           output2 = strTableId.split("\\|");

           output = new String[output1.length][2];
           for(int i=0;i<output1.length;i++){
               output[i][0]=output1[i];
               output[i][1]=output2[i];
           }
        }
        return output;
    }
}
