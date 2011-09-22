package com.edifixio.flex.location;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.GeoLocation;
import twitter4j.GeoQuery;
import twitter4j.Place;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import com.edifixio.soc.web.beans.FindLocationOrLatLng;

public class GatewayServletLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GatewayServletLocation() {
        super();
    }
    
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter writer = response.getWriter();
	    List<String> locationList=new ArrayList<String>();
	    String locationParameter = request.getParameter("location");
        try {
            if(locationParameter == null || locationParameter.equals(""))
                System.out.println("Location not found.");
            else
                locationList = getNearByLocUsingTwitterAPI(locationParameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
	    writer.print(locationList);
	}
	
	public List<String> getNearByLocUsingTwitterAPI(String location) throws TwitterException {
        List<String> handlerGeoLocationList=new ArrayList<String>();
        try  {
                String [] latLng =new FindLocationOrLatLng()
                        .getLocationOrLatLng(location,FindLocationOrLatLng.BY_LAT_LNG).split(",");  
                GeoLocation geoLocation = new GeoLocation(Double.parseDouble(latLng[1].trim()),
                                        Double.parseDouble(latLng[0].trim()));
                GeoQuery query = new GeoQuery(geoLocation);
                Twitter twitter = getTwitterInstance();
                for(Place place : twitter.getNearbyPlaces(query))
                    handlerGeoLocationList.add(place.getFullName()+"|");
        }
        catch(Exception e) {
            System.out.println("Wrong location OR location not found. "+e.getMessage());
        }
        System.out.println("Near by location  : "+handlerGeoLocationList);
        return handlerGeoLocationList;
    }
	
	public Twitter getTwitterInstance() {
	       try  {
	           TwitterFactory twitterFactory = new TwitterFactory();
	           Twitter twitter = twitterFactory.getInstance();
	           return twitter;
	       }  catch (Exception e) {
	               System.out.println("Twitter instance couldn't be created. "+e.getMessage());
	       }
	       return null;
	   }
	
}
