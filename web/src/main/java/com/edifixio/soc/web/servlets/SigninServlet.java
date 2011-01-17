package com.edifixio.soc.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import twitter4j.Relationship;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.http.RequestToken;

public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final Log log = LogFactory.getLog(SigninServlet.class);
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Twitter twitter = new Twitter();
        log.debug("DISPLAY.....");
        Twitter twitter = new TwitterFactory().getInstance();
        request.getSession().setAttribute("twitter", twitter);
        try {
            User user1 = twitter.showUser("neel8100");
             
            StringBuffer callbackURL = request.getRequestURL();
            int index = callbackURL.lastIndexOf("/");
            callbackURL.replace(index, callbackURL.length(), "").append("/callback");
            twitter.setOAuthConsumer("VwdZx7sdiB9R82qgQXE4vw", "QSDQKChkbnlhRywtw8tr6XGhFeLzx00qDybwfEuEzY");
            //twitter.setOAuthConsumer("zQpyhhaSSwY61mxH9C8ojw", "bAc1kurQZCdQzuAzVTFWj3HAprCn7aiNzErWGQa7lHk");
            RequestToken requestToken = twitter.getOAuthRequestToken(callbackURL.toString());
            request.getSession().setAttribute("requestToken", requestToken);
            response.sendRedirect(requestToken.getAuthenticationURL());

        } catch (TwitterException e) {
            throw new ServletException(e);
        }
    }
}
