package com.edifixio.soc.web.beans;

import org.json.JSONException;
import org.json.JSONObject;

import com.edifixio.soc.web.controllers.TwitterControllerConstants;

public class FindLocationOrLatLng //extends BaseWebObject
{
    
    public static final String BY_LAT_LNG = "byLatLng";
    public static final String BY_LOCATION = "byLocation";
    
    private static final String KEY="ABQIAAAAXT0mj7siFsB-HYkwOMz48RTSZqmqvjWs2LaaVIY6NfBDPgeSxBTuAECAcDo5lBRjpLubm7bGz0WIag";
    private static final String GOOGLE_URL = "http://maps.google.com/maps/geo?q="; 
    private static final String EXTRA_PARAM = "&output=json" +"&oe=utf8/&sensor=true_or_false&key=";
    
    private JSONObject jsonObjectFromArray;
    
    private String address;
    private String administrativeAreaName;
    private String subAdministrativeAreaName;
    private String locality;
    private String latLong;
    private String postalCode;
    
    public String getLocationOrLatLng(String placeOrLatLng, String searchType) throws JSONException    {
        System.out.println("Inside GetLocationOrLatLng : "+placeOrLatLng);
        JSONObject getValue=null;
        if(placeOrLatLng == null || placeOrLatLng.equals(""))
            return "";
        getValue = initializeJSONFromURL(placeOrLatLng, searchType);
        setJsonObjectFromArray(getValue.getJSONArray(TwitterControllerConstants.PLACEMARK).getJSONObject(0));
        return collectInformation(searchType);
    }
    
    private String collectInformation(String searchType) throws JSONException {
        if(searchType.equals(BY_LOCATION)) {
            setAdministrativeAreaName(findAdminAreaFromJSON()); //set administrative area name 
            setLocality(findLocalityFromJSON());
            return getLocOrLatLng(getLocality(), getAdministrativeAreaName());
        }  else  {
            setLatLong(getLatLngJSON());
            return getLatLong();
        }
    }
    
    public String findLocationFromAddress(String location) {
        String str[] = location.split(",");
        return str[0].trim()+","+str[1].trim();
    }
    
    private JSONObject initializeJSONFromURL(String placeOrLatLng, String searchType) throws JSONException {
        placeOrLatLng = deleteIfAnySpaceBetween(placeOrLatLng,searchType);
        String url = GOOGLE_URL+placeOrLatLng+EXTRA_PARAM+KEY;
        return new JSONFormat().getJSONFormat(url);
    }
    
    private String getLocOrLatLng(String locality, String adminAreaName) throws JSONException {
        if(locality.equals("") && adminAreaName.equals(""))  {
            //setAddress(findAddresFromJSON());  //set address, Use if necessary
            setAddress(findLocationFromAddress(findAddresFromJSON()));
            return getAddress();
            //return "";
        }
        else  
            return getLocality()+", "+getAdministrativeAreaName();
    }
    
    private JSONObject getPointJSON() throws JSONException {
        try {
            return getJsonObjectFromArray().getJSONObject(TwitterControllerConstants.POINT);
        }   catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    private String findAddresFromJSON() throws JSONException {
        try {
            return getJsonObjectFromArray().getString(TwitterControllerConstants.ADDRESS);
        }   catch(Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("Address not found !!!");
            return "";
        }
        
    }
    
    private String  findAdminAreaFromJSON()  {
        try {
         return getAdminAreaJSON().getString(TwitterControllerConstants.ADMINISTRATIVE_AREA_NAME);
        }   catch(Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("Administrative area not found !!!");
            return "";
        }
    }
    
    private String  findLocalityFromJSON()  {
        try {
            if(getLocalityJSON() != null)
                return getLocalityJSON().getString(TwitterControllerConstants.LOCALITY_NAME);
            else if(getLocalityWithoutSubAdminAreaJSON() != null)
                return getLocalityWithoutSubAdminAreaJSON().getString(TwitterControllerConstants.LOCALITY_NAME);
            else 
                return getDependentLocalityJSON().getString(TwitterControllerConstants.DEPENDENT_LOCALITY_NAME);
        }   catch(Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("Locality name not found !!!");
            return "";
        }
     }
    
    private JSONObject getAddressDetailsJSON()  {
        try {
            return getJsonObjectFromArray().getJSONObject(TwitterControllerConstants.ADDRESS_DETAILS);
        }   catch(Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("Address Details not found !!!");
            return null;
        }
    }
    
    private JSONObject getCountryDetailsJSON()  {
        try {
            return getAddressDetailsJSON().getJSONObject(TwitterControllerConstants.COUNTRY);
        }   catch(Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("Country not found !!!");
            return null;
        }
    }
    
    private JSONObject getAdminAreaJSON()  {
        try {
            return getCountryDetailsJSON().getJSONObject(TwitterControllerConstants.ADMINISTRATIVE_AREA);
        }   catch(Exception e)  {
            System.out.println(e.getMessage());
            //System.out.println("Administrative area not found !!!");
            return null;
        }
    }
    
    private JSONObject getSubAdminAreaJSON()  {
        try {
                return getAdminAreaJSON().getJSONObject(TwitterControllerConstants.SUB_ADMINISTRATIVE_AREA);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("Sub-administrative area not found !!!");
            return null;
        }
    }
    
    private JSONObject getLocalityJSON()  {
        try  {
        if(getSubAdminAreaJSON() != null)
            return getSubAdminAreaJSON().getJSONObject(TwitterControllerConstants.LOCALITY);
        else
            return getLocalityWithoutSubAdminAreaJSON();
        }   catch(Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("Localty (sub-admin) not found !!!");
            return null;
        }
    }
    
    private JSONObject getLocalityWithoutSubAdminAreaJSON()  {
       try {
                return getAdminAreaJSON().getJSONObject(TwitterControllerConstants.LOCALITY);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("Locality (admin) not found !!!");
            return null;
        }
    }
    
    private String getLatLngJSON()  {
        try     {
        String latLng = getPointJSON().getString(TwitterControllerConstants.COORDINATES)
                                      .replace("[", "").replace("]","").replace(",0","");
        return latLng;
        }   catch(Exception e)  {
            System.out.println(e.getMessage());
            //System.out.println("LatLng not found");
            return null;
        }
    }
    
    private JSONObject getDependentLocalityJSON()  {
        try {
            return getAdminAreaJSON().getJSONObject(TwitterControllerConstants.DEPENDENT_LOCALITY);
        }   catch(Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("Dependent locality not found !!!");
            return null;
        }
    }
    
    private String deleteIfAnySpaceBetween(String str, String searchType)
    {
        String temp="";
        if(searchType.equals(BY_LOCATION))
            temp=str.replace(" ", "");
        else if(searchType.equals(BY_LAT_LNG))
            temp=str.replace(" ", ",");
        return temp;
    }
    
    public String getAddress() {                        
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAdministrativeAreaName() {
        return administrativeAreaName;
    }
    public void setAdministrativeAreaName(String administrativeAreaName) {
        this.administrativeAreaName = administrativeAreaName;
    }
    public String getSubAdministrativeAreaName() {
        return subAdministrativeAreaName;
    }
    public void setSubAdministrativeAreaName(String subAdministrativeAreaName) {
        this.subAdministrativeAreaName = subAdministrativeAreaName;
    }
    public String getLocality() {
        return locality;
    }
    public void setLocality(String locality) {
        this.locality = locality;
    }
    public JSONObject getJsonObjectFromArray() {
        return jsonObjectFromArray;
    }
    public void setJsonObjectFromArray(JSONObject jsonObjectFromArray) {
        this.jsonObjectFromArray = jsonObjectFromArray;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getLatLong() {
        return latLong;
    }
    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }
}
