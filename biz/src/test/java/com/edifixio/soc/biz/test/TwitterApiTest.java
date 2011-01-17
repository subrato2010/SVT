// $Author: subratog $
package com.edifixio.soc.biz.test;

import java.net.URL;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import com.edifixio.soc.biz.dto.MetricsDTO;
import com.edifixio.soc.biz.dto.ProfilePreferenceDTO;
import com.edifixio.soc.biz.dto.StagingRawScoreDTO;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.util.BizTestCase;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.Company;
import com.edifixio.soc.persist.Metrics;
import com.edifixio.soc.persist.ProfilePreference;
import com.edifixio.soc.persist.StagingScore;
import com.edifixio.soc.persist.TwitterAccount;

public class TwitterApiTest extends BizTestCase {
    private final static Log log = LogFactory.getLog(TwitterApiTest.class);
    Twitter twitter = new TwitterFactory().getInstance();
    
    public void testApiCall1() throws SVTException, TwitterException {
        log.debug("TwitterApiTest.testApiCall1");
        
        // Looping through all metrics and call API accordingly
        // Calling for the metrics : Percentage of Completed Bio(s)
        List<MetricsDTO> mdtos = getMetricsMgr().findAll();
        for(MetricsDTO mdto: mdtos){
            if(mdto != null && mdto.getUrlAPI1() != null){                
                if(mdto.getMetricName().equalsIgnoreCase("Percentage of Completed Bio(s)")){
                    setStagingRawScoreDTO(mdto, 0);
                }
             }
        }
     }

    private void setStagingRawScoreDTO(MetricsDTO mdto, int metricNumber) throws TwitterException, SVTException {
         if(metricNumber == 0){
            // getting Twitter account by profilePreference
            List<ProfilePreferenceDTO> ppdtos = getProfilePreferenceMgr().findAll();
           
            for(ProfilePreferenceDTO dto: ppdtos){                
                // getting all the twitter accounts pointing to the passed profilePref
                List<TwitterAccountDTO> selfdtos = getTwitterAccountMgr().getByProfilePreferenceIdSELF(dto.getProfilePrefrenceId());
                List<TwitterAccountDTO> compdtos = getTwitterAccountMgr().getByProfilePreferenceIdNOTSELF(dto.getProfilePrefrenceId());
                
                double totalTwtAccountSelfInProfile = selfdtos.size();
                double totalTwtAccountCompInProfile = compdtos.size();
                double totalWithCompletedBio = 0;
                log.debug("Self: totalTwitterActForProfile: " + totalTwtAccountSelfInProfile);
                log.debug("Comp: totalTwitterActForProfile: " + totalTwtAccountCompInProfile);
                
                for(TwitterAccountDTO dto1: selfdtos){
                    log.debug("Fetching information for the user: " + dto1.getTwitterUsername());
                    totalWithCompletedBio += completedBio(dto1.getTwitterUsername());
                    log.debug("value.................................: " + totalWithCompletedBio);
                }                
                // now % of compeleted Bio's
                log.debug("% of compeleted Bio: " + (totalWithCompletedBio/totalTwtAccountSelfInProfile) * 100.0);
                
                StagingRawScoreDTO sdto = new StagingRawScoreDTO();
                sdto.setCreatedOn(new Date());
                sdto.setRawScore(""+(totalWithCompletedBio/totalTwtAccountSelfInProfile) * 100.0);
                sdto.setStagingScore(getStagingScore(mdto, true));
                sdto.setUpdatedBy("subrato");
                sdto.setUpdatedOn(new Date());
                
                // insert into database
                getStagingRawScoreMgr().add(sdto);
            }
        }        
    }

    private StagingScore getStagingScore(MetricsDTO mdto, boolean self) {
        StagingScore ss = new StagingScore();
        ss.setAsOfDateFrom(new Date());
        ss.setAsOfDateTo(new Date());
        ss.setBenchmark(null);
        ss.setBenchmarkYN(false);
        
        ss.setTwitterAccount(getTwitterAccount());
        ss.setUpdatedBy("subrato");
        ss.setUpdatedOn(new Date());
        return ss;
    }
    
    private double completedBio(String twitterUsername) throws TwitterException {
        User twitUser = twitter.showUser(twitterUsername);
        
        String name = twitUser.getName();
        URL url = twitUser.getURL();
        String location = twitUser.getLocation();
        String description = twitUser.getDescription();

        if(url == null || name == null || location == null || description == null){
            return 0;
        }
        return 1;
    }

    private int getDataByMetrics(String twitterUsername) throws SVTException, TwitterException {
        
        // Looping through all metrics and call API accordingly
        // Calling for the metrics : Percentage of Completed Bio(s)
        
        List<MetricsDTO> mdtos = getMetricsMgr().findAll();
        for(MetricsDTO mdto: mdtos){
            if(mdto != null && mdto.getUrlAPI1() != null){
                
                if(mdto.getMetricName().equalsIgnoreCase("Percentage of Completed Bio(s)")){
                    
                }
                
                return getTwitterAPI(mdto.getUrlAPI1(), twitterUsername);
            }
        }
        
        
        
        // Here, I got twitterUser and the api to call
        
        return 0;        
    }

    private int getTwitterAPI(String apiMethod, String twitterUsername) throws TwitterException {
        
        User twitUser = twitter.showUser(twitterUsername);
        
        String name = twitUser.getName();
        URL url = twitUser.getURL();
        String location = twitUser.getLocation();
        String description = twitUser.getDescription();

        if(url == null || name == null || location == null || description == null){
            return 0;
        }
        return 1;
    }

    private TwitterAccount getTwitterAccount() {
        // TODO Auto-generated method stub
        return null;
    }

    private ProfilePreference getProfilePreference() {
        // TODO Auto-generated method stub
        return null;
    }

    private Metrics getMetrics() {
        // TODO Auto-generated method stub
        return null;
    }

    private Company getCompany() {
        Company cmp = new Company();
        
        return null;
    }
}
