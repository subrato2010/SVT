package com.edifixio.soc.web.beans;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class GenerateLocationOrLatLng {
    
    public static final String BY_LAT_LNG = "byLatLng";
    public static final String BY_LOCATION = "byLocation";
    public static final String KEY="ABQIAAAAXT0mj7siFsB-HYkwOMz48RTSZqmqvjWs2LaaVIY6NfBDPgeSxBTuAECAcDo5lBRjpLubm7bGz0WIag";
    public static final String GOOGLE_URL = "http://maps.google.com/maps/geo?q="; 
    public static final String EXTRA_PARAM = "&output=json" +"&oe=utf8/&sensor=true_or_false&key=";
    
    public String getLocationOrLatLng(String placeOrLatLng, String searchType)    {
        
        System.out.println("Inside GetLocationOrLatLng : "+placeOrLatLng);
        String getValue="";
        if(placeOrLatLng == null){
            return "";
        }
        placeOrLatLng = deleteIfAnySpaceBetween(placeOrLatLng,searchType);
        
        String url = GOOGLE_URL+placeOrLatLng+EXTRA_PARAM+KEY;
        getValue = forwardToNetwork(url);
        try {
        JSONObject fullJSONFormat = new JSONObject(getValue);
        /**
          * If search by location, then it will return the latitude and longitude and vice versa
          * If it is search by ZIP code then, it will return latitude and longitude.
          */
         if(searchType.equals(BY_LOCATION))
             return getLatLong(fullJSONFormat);
         else
             return getLocation(fullJSONFormat);
        } catch(Exception e) {
            System.out.println("JSON Parsing Error "+e.getMessage());
        }
        return null;
    }
    
    public String forwardToNetwork(String searchURL) {
        BufferedReader rd =null;
        InputStream in=null;
        URL url = null; 
        URLConnection con = null;
        
        StringBuffer getValue = new StringBuffer();
        try
        {
            url = new URL(searchURL);
            con = url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            
            in = new DataInputStream(con.getInputStream());
            rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
            
            String lineRead = "";
            
            while ((lineRead = rd.readLine()) != null)
                getValue.append(lineRead);
            rd.close();
            in.close();
        }  catch(Exception e)  {
            e.printStackTrace();
        }
            //System.out.println(getValue);
            return getValue.toString();
    }
    
    public String getLatLong(JSONObject fullJSONFormat) throws JSONException {
        JSONObject extractValueObject = new JSONObject(fullJSONFormat.getJSONArray("Placemark").get(0).toString());
        String latLng =extractValueObject.getJSONObject("Point")
                                        .getString("coordinates")
                                        .replace("[", "")
                                        .replace("]","")
                                        .replace(",0","");
        System.out.println("Lat-Lng : "+latLng);
        return latLng;
    }
    
    public String getLocation(JSONObject fullJSONFormat) throws JSONException {
        JSONObject extractValueObject = new JSONObject(fullJSONFormat.getJSONArray("Placemark").get(0).toString());
        String state = extractValueObject.getJSONObject("AddressDetails")
                                         .getJSONObject("Country")
                                         .getJSONObject("AdministrativeArea")
                                         .getString("AdministrativeAreaName");
        
        String city = extractValueObject.getJSONObject("AddressDetails")
                    .getJSONObject("Country").getJSONObject("AdministrativeArea")
                    .getJSONObject("SubAdministrativeArea")
                    .getJSONObject("Locality")
                    .getString("LocalityName");

        String country = extractValueObject.getJSONObject("AddressDetails")
                          .getJSONObject("Country")
                          .getString("CountryName");
        System.out.println(state+","+city+":"+country);
        return state+","+city;
    }
    
    /*public String findNearByLocationByGeoNameAPI(String lat, String lng) {
        String url = "http://api.geonames.org/findNearbyPostalCodesJSON?lat="+lat+"&lng="+lng+"&username=demo";
        JSONObject fullJSONFormat = new JSONObject(forwardToNetwork(url));
        getNearByPostalCode(fullJSONFormat);
        return "";
    }*/
    
    public String deleteIfAnySpaceBetween(String str, String searchType)
    {
        String temp="";
        if(searchType.equals(BY_LOCATION))
            temp=str.replace(" ", ",");
        else if(searchType.equals(BY_LAT_LNG))
            temp=str.replace(" ", "");
        return temp;
    }
}
