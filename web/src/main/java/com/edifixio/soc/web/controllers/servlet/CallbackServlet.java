package com.edifixio.soc.web.controllers.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import twitter4j.Twitter;
import twitter4j.http.AccessToken;
import twitter4j.http.RequestToken;

import com.edifixio.soc.web.beans.ManageTwitterOperations;
import com.edifixio.soc.web.servlets.BaseServletObject;


public class CallbackServlet extends BaseServletObject {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(CallbackServlet.class);
    

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
    {
        
        Twitter twitter;
        RequestToken requestToken;
        String oauth_verifier;
        AccessToken accessToken=null;

        twitter = (Twitter) request.getSession().getAttribute("twitter");
        requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
        oauth_verifier = request.getParameter("oauth_verifier");
        
        boolean flag = false;
        try {
            ManageTwitterOperations opt = (ManageTwitterOperations)getManagedBean("manageTwitterOperations", getFacesContext(request, response));
            opt.createInstances(twitter,requestToken, oauth_verifier, accessToken, request, response,
                    flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
