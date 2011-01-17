package com.edifixio.soc.web.controllers.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.web.controllers.TwitterController;
import com.edifixio.soc.web.dto.TwitterInformation1DTO;
import com.edifixio.soc.web.dto.TwitterInformationDTO;
import twitter4j.AsyncTwitter;
import twitter4j.AsyncTwitterFactory;
import twitter4j.IDs;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.http.AccessToken;
import twitter4j.http.Authorization;
import twitter4j.http.RequestToken;


public class CallbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(CallbackServlet.class);
    Twitter twitter;
    RequestToken requestToken;
    String verifier;
    AccessToken accessToken;


    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        twitter = (Twitter) request.getSession().getAttribute("twitter");
        requestToken = (RequestToken) request.getSession().getAttribute(
                "requestToken");
        TwitterController twitterController = (TwitterController) request
                .getSession().getAttribute("twitterController");
        verifier = request.getParameter("oauth_verifier");
        boolean flag = false;
        try {
            new ManageTwitterOperations().createInstances(twitter,
                    requestToken, verifier, accessToken, request, response,
                    flag, twitterController);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * for (Tweet tweet : result.getTweets()) {
     * //System.out.println(tweet.getFromUser() + ":" + tweet.getText()); }
     */
}
