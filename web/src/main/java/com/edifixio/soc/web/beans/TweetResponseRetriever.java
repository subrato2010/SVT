package com.edifixio.soc.web.beans;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;


public class TweetResponseRetriever {
    private static final long TIME_GAP_IN_MILLIS = 1 * 60 * 1000;
    private static final String FILE_BEAN = "FILE_BEAN_";
    private static final int COUNT = 200;

/**
 * 
 * @param twitter
 * @param handler
 * @param twitterlistId
 * @return
 * @throws TwitterException
 * Intention of twitterlistId is related to selected twitter account, will fetch only the tweets of selected list.
 */
    public List<Status> getResponse(Twitter twitter, String handler, int twitterlistId)
            throws TwitterException {
       //get http session
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
        //get session id
        String sessionId = session.getId();
        
        //try to get fileBean if already exist in session
        TwtFileBean fileBean = (TwtFileBean) session.getAttribute(FILE_BEAN
                + handler);
        
        //create if not already exist.
        if (fileBean == null) {
            fileBean = new TwtFileBean(sessionId, handler);
            session.setAttribute(FILE_BEAN + handler, fileBean);
        }
        
        //get result
        List<Status> alAllTweets = fileBean.getResult();
        
        //If called before timeGap then returned result(found from file)
        if (fileBean.getSinceLastSaved() < TIME_GAP_IN_MILLIS
                && fileBean.getSinceLastSaved() != -1 && twitterlistId == 0)
            return alAllTweets;
        
        //last id
        long lLastID = 0l;
        if (alAllTweets != null) {
            if (alAllTweets != null && alAllTweets.size() > 0)
                lLastID = alAllTweets.get(0).getId();
        }
        
        //response list (combined from file + from api(since last accessed))
        
        ResponseList<Status> rl = null;
        if(twitterlistId == 0){
            if (lLastID > 0)
                rl = twitter.getHomeTimeline(new Paging(1, COUNT, lLastID));
            else
                rl = twitter.getHomeTimeline(new Paging(1, COUNT));            
        }else{ // means you want to get only the tweets of passed listId
            if (lLastID > 0){
                //rl = twitter.getUserListStatuses(handler,twitterlistId,new Paging(1, COUNT, lLastID));
                rl = twitter.getUserListStatuses(handler,twitterlistId,new Paging(1, COUNT));
            }
            else
                rl = twitter.getUserListStatuses(handler,twitterlistId,new Paging(1, COUNT));    
            return rl;
        }

        //show ststus
        /*if (alAllTweets != null) {
            for (Status status : alAllTweets) {
                System.out.println(status.getId() + ":" + status.getText());
            }
        }
        for (Status status : rl) {
            System.out.println(status.getId() + ":" + status.getText());
        }
        */
        
        List<Status> alRefreshedList = null;
        if (lLastID > 0 && rl != null && rl.size() > 0) {
            alRefreshedList = alAllTweets
                    .subList(rl.size(), alAllTweets.size());
            alRefreshedList.addAll(0, rl);
        } else if (lLastID == 0 && rl != null && rl.size() > 0) {
            alRefreshedList = rl;
        } else {
            alRefreshedList = alAllTweets;
        }
        
        
        //save updates in file
        if (lLastID == 0 || rl.size() > 0) {
            try {
                fileBean.save(alRefreshedList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        //return result
        return alRefreshedList;
    }
}
