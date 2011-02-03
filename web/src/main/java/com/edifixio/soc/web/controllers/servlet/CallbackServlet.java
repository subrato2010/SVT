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
import com.edifixio.soc.web.controllers.ReplyTwitterDataController;
import com.edifixio.soc.web.controllers.TwitterController;
import com.edifixio.soc.web.servlets.BaseServletObject;


public class CallbackServlet extends BaseServletObject {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(CallbackServlet.class);
    Twitter twitter;
    RequestToken requestToken;
    String verifier;
    AccessToken accessToken;
    TwitterController twitterController;
    ReplyTwitterDataController replyTwitterDataController;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        twitter = (Twitter) request.getSession().getAttribute("twitter");
        requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
        twitterController = (TwitterController) request.getSession().getAttribute("twitterController");
        replyTwitterDataController = (ReplyTwitterDataController) request.getSession().getAttribute("replyTwitterController");
        verifier = request.getParameter("oauth_verifier");
        boolean flag = false;
        try {
            ManageTwitterOperations opt = (ManageTwitterOperations)getManagedBean("manageTwitterOperations", getFacesContext(request, response));
            opt.createInstances(twitter,
                    requestToken, verifier, accessToken, request, response,
                    flag, twitterController, replyTwitterDataController);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    /*
     * for (Tweet tweet : result.getTweets()) {
     * //System.out.println(tweet.getFromUser() + ":" + tweet.getText()); }
     */
}
