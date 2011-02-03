package com.edifixio.soc.web.controllers.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;
import twitter4j.http.Authorization;
import twitter4j.http.RequestToken;


public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(SigninServlet.class);


    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        Authorization authorization = new TwitterStreamFactory().getInstance().getAuthorization();
        request.setCharacterEncoding("UTF-8");
        Twitter twitter = new TwitterFactory().getOAuthAuthorizedInstance("O8EimOXvid1hEhRAqlw5Ow","5mXavX0NSoC9gox6I5RhJgp4lGQozSyhH0rAZXxgY");
        request.getSession().setAttribute("twitter", twitter);
        request.getSession().setAttribute("twt",request.getSession().getAttribute("twtMsg"));
        try {
            StringBuffer callbackURL = request.getRequestURL();
            int index = callbackURL.lastIndexOf("/");
            callbackURL.replace(index, callbackURL.length(), "").append("/callback");
            RequestToken requestToken = twitter.getOAuthRequestToken(request.getSession().getAttribute("callbackURL").toString());//(callbackURL.toString());
            request.getSession().setAttribute("requestToken", requestToken);
            response.sendRedirect(requestToken.getAuthenticationURL());
        } catch (TwitterException e) {
            throw new ServletException(e);
        }
    }
}
