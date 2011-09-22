package com.edifixio.soc.web.controllers.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.web.beans.ManageBitlyOperations;
import com.edifixio.soc.web.controllers.BaseWebObject;
import com.edifixio.soc.web.servlets.BaseServletObject;

/**
 * Servlet implementation class BitlySigninServlet
 */
public class BitlyCallbackServlet extends BaseServletObject
{
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
    {
        System.out.println("**************** BitlyCallbackServlet called ****************");
        String bitlyUserName = (String) request.getSession().getAttribute(BaseWebObject.BITLY_USER_NAME);
        String bitlyAccessPoint = (String) request.getSession().getAttribute(BaseWebObject.BITLY_ACCESSTOKEN_URL);
        String bitlyClientId = (String) request.getSession().getAttribute(BaseWebObject.BITLY_CLIENT_ID);
        String bitlyClientSecret = (String) request.getSession().getAttribute(BaseWebObject.BITLY_CLIENT_SECRET);
        String redirectURI = (String) request.getSession().getAttribute(BaseWebObject.BITLY_CALLBACK_URL);
        
        String bitlyLogin = "";
        String bitlyAccessToken = "";
        String bitlyApiKey = "";
        
        int responseCode;
        
        String bitlyCode = request.getParameter("code");
        URL authURL = null;
        
        if(bitlyCode != null)
        {
            bitlyAccessPoint = bitlyAccessPoint + "?client_id=" + bitlyClientId + "&client_secret=" + bitlyClientSecret + "&code=" + bitlyCode + "&redirect_uri=" + redirectURI;
            
            authURL = new URL(bitlyAccessPoint);           
            
            
            HttpURLConnection httpCon = (HttpURLConnection) authURL.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("POST");
            
            responseCode = httpCon.getResponseCode();
            
            StringBuffer result = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
            String line;
            
            while ((line = reader.readLine()) != null)
            {
                result.append(line);
            }
            
            StringTokenizer token = new StringTokenizer(result.toString(), "&");
            String strToken = "";
            
            HashMap<String, String> bitlyAuthMap = new HashMap<String, String>();
            
            String mapkey = "";
            String mapValue = "";
            
            while (token.hasMoreTokens())
            {
                strToken = token.nextToken();
                
                mapkey = strToken.substring(0,strToken.indexOf("="));
                mapValue = strToken.substring(strToken.indexOf("=")+1);
                
                bitlyAuthMap.put(mapkey, mapValue);  
                
                bitlyAccessToken = bitlyAuthMap.get("access_token");
                bitlyLogin = bitlyAuthMap.get("login");
                bitlyApiKey = bitlyAuthMap.get("apiKey");
                 
            }
            
            reader.close();
            
            if(responseCode == 200 && bitlyLogin.equalsIgnoreCase(bitlyUserName))  // Status = OK Successful Authentication
            {
                System.out.println("************* Bitly Auth successful *************");
                
                ManageBitlyOperations bitlyOpt = (ManageBitlyOperations)getManagedBean("manageBitlyOperations", getFacesContext(request, response));
                try
                {
                    bitlyOpt.persistBitlyAccessToken(bitlyUserName, bitlyAccessToken, bitlyApiKey);
                    
                    request.getSession().setAttribute("actionTakenOnPopup","editProfile");
                    request.getSession().setAttribute("validCredentials",true);
                    
                    response.sendRedirect("./twt.jsp");
                } 
                catch (SVTException e) 
                {
                    e.printStackTrace();
                }        
                
            }
            
            else
            {
                System.out.println("************* Invalid Bitly Credentials *************");
                
                request.getSession().setAttribute("actionTakenOnPopup","editProfile");
                request.getSession().setAttribute("validCredentials",false);  // Authentication failed popup
                
                response.sendRedirect("./twt.jsp");
            }
            
        }
        else
        {
            System.out.println("************* Clicked Deny on Bitly Login Page *************");
            
            request.getSession().setAttribute("actionTakenOnPopup","editProfile");
            request.getSession().setAttribute("validCredentials",true);
            
            response.sendRedirect("./twt.jsp");
        }
    }

}
