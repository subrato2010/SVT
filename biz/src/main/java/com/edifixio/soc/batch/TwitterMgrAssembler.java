package com.edifixio.soc.batch;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import com.edifixio.soc.biz.MetricsMgr;
import com.edifixio.soc.biz.ProfilePreferenceMgr;
import com.edifixio.soc.biz.TwitterAccountMgr;
import com.edifixio.soc.biz.dto.MetricsDTO;
import com.edifixio.soc.biz.dto.ProfilePreferenceDTO;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Company;
import com.edifixio.soc.persist.MetricsProcessHandler;
import com.edifixio.soc.persist.Score;
import com.edifixio.soc.persist.StagingRawScore;
import com.edifixio.soc.persist.StagingScore;

public class TwitterMgrAssembler extends BaseBizObject{
 
    private static final String SUBRATO = "subrato";
    private final static Log log = LogFactory.getLog(TwitterMgrImpl.class);
    Twitter twitter = new TwitterFactory().getInstance();
    private MetricsMgr metricsMgr;
    private ProfilePreferenceMgr profilePreferenceMgr;
    private TwitterAccountMgr twitterAccountMgr;
    
    protected void setRawScoreDTO(int callerNumber, MetricsDTO mdto) throws TwitterException, SVTException {

        // This is the block where you should add the method, if you are creating new logic
        if(callerNumber == 1){
            setCompletedBio(callerNumber, mdto); // Percentage of Completed Bio(s) 
        }else if(callerNumber == 2){
            setBackgroundImage(callerNumber, mdto); // Percentage of Custom Background Image(s)
        }else if(callerNumber == 4){
            setProfileImage(callerNumber, mdto);
        }
        
    }
 
    /**
     * This method actually makes twitter call
     * @param twitterUsername
     * @param ss
     * @param callerNumber
     * @return
     * @throws TwitterException
     * @throws SVTException
     */
    private double callTwitterAPI(String twitterUsername, StagingScore ss, int callerNumber) throws TwitterException, SVTException {
        if(callerNumber == 1){
            return withCompletedBio(twitterUsername, ss) ;
        }else if(callerNumber == 2){
            return withBackroundImage(twitterUsername, ss); 
        }else if(callerNumber == 4){
            return addedProfileImage(twitterUsername, ss);
        }
        return 0;
    }
    
    protected void setProfileImage(int callerNumber, MetricsDTO mdto) throws TwitterException, SVTException {
        // Calling for the metrics : Percentage of Custom Background Image(s)
        // getting all the company
        List<Company> companies = getDaoProvider().getCompanyDAO().findall();
    
       // getting Twitter account by profilePreference
       List<ProfilePreferenceDTO> ppdtos = getProfilePreferenceMgr().findAll();
      
       for(ProfilePreferenceDTO ppdto: ppdtos){                
           // getting all the twitter accounts pointing to the passed profilePref
           List<TwitterAccountDTO> selfdtos = getTwitterAccountMgr().getByProfilePreferenceIdSELF(ppdto.getProfilePrefrenceId());
           double totalTwtAccountSelfInProfile = selfdtos.size();
           addTwitterInformation(mdto, ppdto, selfdtos, totalTwtAccountSelfInProfile,ppdto.getCompany(),true,callerNumber);
           
           // competitors--
           for(Company comp : companies){
               List<TwitterAccountDTO> compdtos = getTwitterAccountMgr().getByProfilePreferenceIdCompIdNOTSELF(ppdto.getProfilePrefrenceId(), comp.getCompanyId());
               double totalTwtAccountCompInProfile = compdtos.size();
               addTwitterInformation(mdto, ppdto, compdtos, totalTwtAccountCompInProfile,comp, false,callerNumber);
           } 
       }
       
    }
    protected void setBackgroundImage(int callerNumber, MetricsDTO mdto) throws TwitterException, SVTException {
        // Calling for the metrics : Percentage of Custom Background Image(s)
        // getting all the company
        List<Company> companies = getDaoProvider().getCompanyDAO().findall();
    
       // getting Twitter account by profilePreference
       List<ProfilePreferenceDTO> ppdtos = getProfilePreferenceMgr().findAll();
      
       for(ProfilePreferenceDTO ppdto: ppdtos){                
           // getting all the twitter accounts pointing to the passed profilePref
           List<TwitterAccountDTO> selfdtos = getTwitterAccountMgr().getByProfilePreferenceIdSELF(ppdto.getProfilePrefrenceId());
           double totalTwtAccountSelfInProfile = selfdtos.size();
           addTwitterInformation(mdto, ppdto, selfdtos, totalTwtAccountSelfInProfile,ppdto.getCompany(),true,callerNumber);
           
           // competitors--
           for(Company comp : companies){
               List<TwitterAccountDTO> compdtos = getTwitterAccountMgr().getByProfilePreferenceIdCompIdNOTSELF(ppdto.getProfilePrefrenceId(), comp.getCompanyId());
               double totalTwtAccountCompInProfile = compdtos.size();
               addTwitterInformation(mdto, ppdto, compdtos, totalTwtAccountCompInProfile,comp, false,callerNumber);
           } 
       }
       
    }

    protected void setCompletedBio(int callerNumber,MetricsDTO mdto) throws TwitterException, SVTException {
        // Calling for the metrics : Percentage of Completed Bio(s)
        
            // getting all the company
            List<Company> companies = getDaoProvider().getCompanyDAO().findall();
        
           // getting Twitter account by profilePreference
           List<ProfilePreferenceDTO> ppdtos = getProfilePreferenceMgr().findAll();
          
           for(ProfilePreferenceDTO ppdto: ppdtos){                
               // getting all the twitter accounts pointing to the passed profilePref
               List<TwitterAccountDTO> selfdtos = getTwitterAccountMgr().getByProfilePreferenceIdSELF(ppdto.getProfilePrefrenceId());
               double totalTwtAccountSelfInProfile = selfdtos.size();
               addTwitterInformation(mdto, ppdto, selfdtos, totalTwtAccountSelfInProfile,ppdto.getCompany(),true, callerNumber);
               
               // competitors--
               for(Company comp : companies){
                   List<TwitterAccountDTO> compdtos = getTwitterAccountMgr().getByProfilePreferenceIdCompIdNOTSELF(ppdto.getProfilePrefrenceId(), comp.getCompanyId());
                   double totalTwtAccountCompInProfile = compdtos.size();
                   addTwitterInformation(mdto, ppdto, compdtos, totalTwtAccountCompInProfile,comp, false, callerNumber);
               } 
           }
   }
    
    private double withCompletedBio(String twitterUsername, StagingScore ss) throws TwitterException, SVTException {
        User twitUser = getTwitterUser(twitterUsername);
        double returnValue = 0;
        String name = twitUser.getName();
        URL url = twitUser.getURL();
        String location = twitUser.getLocation();
        String description = twitUser.getDescription();

        StagingRawScore srs = new StagingRawScore();
        srs.setStagingScore(ss);
        srs.setUpdatedBy(SUBRATO);
        srs.setUpdatedOn(new Date());
        
        if(url == null || name == null || location == null || description == null){
            srs.setRawScore("0"); // means incomplete
        }else{
            returnValue=1;
            srs.setRawScore("1"); // means completed
        }
        getDaoProvider().getStagingRawScoreDAO().add(srs);
        return returnValue;
    }

    
    private double withBackroundImage(String twitterUsername, StagingScore ss) throws TwitterException, SVTException {
        User twitUser = getTwitterUser(twitterUsername);
        double returnValue = 0;
        String backgroundImageUrl = twitUser.getProfileBackgroundImageUrl();

        StagingRawScore srs = new StagingRawScore();
        srs.setStagingScore(ss);
        srs.setUpdatedBy(SUBRATO);
        srs.setUpdatedOn(new Date());
        
        if(backgroundImageUrl.toLowerCase().indexOf("profile_background_images") > 0){
            returnValue=1;
            srs.setRawScore("1"); // customized backround image
        }else{

            srs.setRawScore("0"); // with default
        }
        getDaoProvider().getStagingRawScoreDAO().add(srs);
        return returnValue;
    }

    private double addedProfileImage(String twitterUsername, StagingScore ss) throws TwitterException, SVTException {
        User twitUser = getTwitterUser(twitterUsername);
        double returnValue = 0;
        String profileImageUrl = twitUser.getProfileImageURL().toString();

        StagingRawScore srs = new StagingRawScore();
        srs.setStagingScore(ss);
        srs.setUpdatedBy(SUBRATO);
        srs.setUpdatedOn(new Date());
        
        if(profileImageUrl.toLowerCase().indexOf("profile_images") > 0){
            returnValue=1;
            srs.setRawScore("1"); // have added a profile image
        }else{

            srs.setRawScore("0"); // with default
        }
        getDaoProvider().getStagingRawScoreDAO().add(srs);
        return returnValue;
    }
    
    protected int getMetricsHandlerNumber(String metricId) throws SVTException {
        MetricsProcessHandler mph = getDaoProvider().getMetricsProcessHandlerDAO().getByMetricsId(metricId);
        if(mph != null && mph.getHandlerNumber() > 0){
            return mph.getHandlerNumber();
        }
        return 0;
    }
    
    // ----------------- dont touch ---------------------------//

    private User getTwitterUser(String twitterUsername) throws TwitterException {
        //TODO : if already called this function, then we can persist and reuse
        User twitUser = twitter.showUser(twitterUsername);
        ResponseList<Status> st = twitter.getUserTimeline(twitterUsername);
        log.debug(":::::::::::::::::::::::::::::" + st.size());
        return twitUser;
    }
    
    private void addTwitterInformation(MetricsDTO mdto, ProfilePreferenceDTO ppdto, List<TwitterAccountDTO> twtdtos, double totalTwtAccountSelfInProfile, Company comp, boolean self, int callerNumber) throws SVTException, TwitterException {
        if(twtdtos == null || twtdtos.size() == 0){
            return;
        }
        double totalWithCompletedBio = 0;
        for(TwitterAccountDTO dto: twtdtos){
               log.debug("Fetching information for the user: " + dto.getTwitterUsername());
               
               // Master - StagingScore
               StagingScore ss = new StagingScore();
               ss.setAsOfDateFrom(new Date());
               ss.setAsOfDateTo(new Date());
               ss.setBenchmarkYN(false);
               ss.setMetrics(mdto.getMetrics());
               ss.setTwitterAccount(dto.getTwitterAccount());
               ss.setUpdatedBy(SUBRATO);
               ss.setUpdatedOn(new Date());
               ss = getDaoProvider().getStagingScoreDAO().add(ss);
               
               // insert into StagingRawScore
               totalWithCompletedBio += callTwitterAPI(dto.getTwitterUsername(), ss, callerNumber);             
           }

           // Insert it into final table
           Score score = new Score();
           score.setAsOfDateFrom(new Date());
           score.setAsOfDateTo(new Date());
           score.setBenchmarkYN(false);
           score.setMetrics(mdto.getMetrics());
           score.setProfilePreference(ppdto.getProfilePreference());
           score.setScore(getDoubleNumber2Decimal((totalWithCompletedBio/totalTwtAccountSelfInProfile) * 100.0));
           score.setSelf(self);
           score.setCompany(comp);
           score.setUpdatedBy(SUBRATO);
           score.setUpdatedOn(new Date());
           getDaoProvider().getScoreDAO().add(score);
    }
    
  
    // --------------- dont touch, I will use this logic later ---------------------//
    protected void assembleMetricsData(MetricsDTO mdto) throws TwitterException, SVTException {
        // Need to call and do logic based on what API you are calling
        String methodName = getMethodName(mdto.getMetricId());
        if(methodName.length() > 0){            
            invokeMethod(mdto, 0, methodName); 
        }
    }
    
    private String getMethodName(String metricId) throws SVTException {
        MetricsProcessHandler mph = getDaoProvider().getMetricsProcessHandlerDAO().getByMetricsId(metricId);
        if(mph != null && mph.getHandlerNumber() > 0){
            return mph.getMethodName();
        }
        return "";
    }

    private void invokeMethod(MetricsDTO mdto, int methodHandlerNumber, String methodName) {
        Object obj = this;
        try {
            Class parameterTypes[] = new Class[2];
            parameterTypes[0] = Integer.TYPE;
            parameterTypes[1] = MetricsDTO.class;


            Method method= obj.getClass().getDeclaredMethod(methodName, parameterTypes);
            try {
                Object parameterList[] = new Object[2];
                parameterList[0] = new Integer(1);
                parameterList[1] = mdto;                
                method.invoke(obj, parameterList);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    //  --------------- ------------------------------------- ---------------------//
    public MetricsMgr getMetricsMgr() {
        return metricsMgr;
    }

    public void setMetricsMgr(MetricsMgr metricsMgr) {
        this.metricsMgr = metricsMgr;
    }


    public ProfilePreferenceMgr getProfilePreferenceMgr() {
        return profilePreferenceMgr;
    }


    public void setProfilePreferenceMgr(ProfilePreferenceMgr profilePreferenceMgr) {
        this.profilePreferenceMgr = profilePreferenceMgr;
    }


    public TwitterAccountMgr getTwitterAccountMgr() {
        return twitterAccountMgr;
    }


    public void setTwitterAccountMgr(TwitterAccountMgr twitterAccountMgr) {
        this.twitterAccountMgr = twitterAccountMgr;
    }
}
