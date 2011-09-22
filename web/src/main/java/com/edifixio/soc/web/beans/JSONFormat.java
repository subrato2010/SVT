package com.edifixio.soc.web.beans;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;


public class JSONFormat {
	public JSONObject getJSONFormat(String searchURL) throws JSONException {
		return new JSONObject(forwardToNetwork(searchURL));
	}
	 private String forwardToNetwork(String searchURL) {
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
	            System.out.println("Error receiving JSON format "+e.getMessage());
	        }
	            return getValue.toString();
	    }
}
