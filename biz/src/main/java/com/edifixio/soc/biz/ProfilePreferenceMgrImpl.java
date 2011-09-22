// $Author: subratog $
package com.edifixio.soc.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.dto.ProfilePreferenceDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.biz.util.BaseBizObject;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.persist.ProfilePreference;
import com.edifixio.soc.persist.UserProfileDetail;

public class ProfilePreferenceMgrImpl extends BaseBizObject implements ProfilePreferenceMgr {
    /** Logger */
    private static Log log = LogFactory.getLog(ProfilePreferenceMgrImpl.class);

    public List<ProfilePreferenceDTO> findAll() throws SVTException {
        // Using spring to get the dao mgr
        log.debug("Successful in connecting to Biz layer");
        return getProfilePreferenceDTOList(getDaoProvider().getProfilePreferenceDAO().findall());
    }
    public ProfilePreferenceDTO getByProfilePreferenceId(String id) throws SVTException {
        // TODO Auto-generated method stub
        return getProfilePreferenceDTO(getDaoProvider().getProfilePreferenceDAO().getByProfilePreferenceId(id));
    }
    public ProfilePreferenceDTO getByProfileUserId(String profileUserId) throws SVTException {
        // TODO Auto-generated method stub
        return getProfilePreferenceDTO(getDaoProvider().getProfilePreferenceDAO().getByProfileUserId(profileUserId));
    }
    
    //TODO: Function name should be change to updateEmails or something like that.
    public UserProfileDetailDTO update(UserProfileDetailDTO dto) throws SVTException {
         ProfilePreference pp = dto.getProfilePreference();
        if(pp != null && pp.getUserProfileDetail() != null){
            UserProfileDetail upd = pp.getUserProfileDetail();
            upd.setReportingEmail1(dto.getReportingEmail1());
            upd.setReportingEmail2(dto.getReportingEmail2());
            upd.setReportingEmail3(dto.getReportingEmail3());   

            pp.setUserProfileDetail(upd);
            ProfilePreference pp1 =  getProfilePreferenceDAO().update(pp);
            dto.setProfilePreference(pp1);
            upd = pp1.getUserProfileDetail();
            updateUserProfileDetailObject(dto, upd);
        }
        return dto;
    }

    /**
     * Dont know why we are doing this?
     * @param dto
     * @return
     * @throws SVTException
     */
    public UserProfileDetailDTO updateKeyword(UserProfileDetailDTO dto) throws SVTException {
         ProfilePreference pp = dto.getProfilePreference();
        if(pp != null && pp.getUserProfileDetail() != null){
            UserProfileDetail upd = pp.getUserProfileDetail();
            pp.setUserProfileDetail(upd);
            ProfilePreference pp1 =  getProfilePreferenceDAO().update(pp);
            dto.setProfilePreference(pp1);
            upd = pp1.getUserProfileDetail();
            updateUserProfileDetailObject(dto, upd);
        }
        return dto;
    }

    
    
    private void updateUserProfileDetailObject(UserProfileDetailDTO dto,
            UserProfileDetail upd) {
        if(dto.getProfilePreference() != null){
            dto.getProfilePreference().setUserProfileDetail(upd);
        }
    }
    
    public UserProfileDetailDTO updateVanityURL(UserProfileDetailDTO dto) throws SVTException {
        ProfilePreference pp = dto.getProfilePreference();
       if(pp != null && pp.getUserProfileDetail() != null){
           UserProfileDetail upd = pp.getUserProfileDetail();
           
           upd.setVanityUrl(dto.getVanityUrl());

           pp.setUserProfileDetail(upd);
           ProfilePreference pp1 =  getProfilePreferenceDAO().update(pp);
           dto.setProfilePreference(pp1);
       }
       return dto;
   }
    
    public UserProfileDetailDTO updateGoogleAnalytics(UserProfileDetailDTO dto) throws SVTException {
        ProfilePreference pp = dto.getProfilePreference();
       if(pp != null && dto.getGoogleAnalyticsUsername() != null){
           pp.setGoogleAnalyticsUsername(dto.getGoogleAnalyticsUsername());
           
           pp.setGoogleAnalyticsPassword(dto.getGoogleAnalyticsPassword()); // Added by NEEL
           
           ProfilePreference pp1 =  getProfilePreferenceDAO().update(pp);
           dto.setProfilePreference(pp1);
       }
       return dto;
   }

    /**
     * To update bitly token, ProfilePreference Object is mandatory
     * @param dto
     * @return
     * @throws SVTException
     */
    public UserProfileDetailDTO updateBitlyToken(UserProfileDetailDTO dto) throws SVTException {
        ProfilePreference pp = dto.getProfilePreference();
       if(pp != null && dto.getBitlyAccessToken() != null){
           pp.setBitlyAccessToken(dto.getBitlyAccessToken());
           pp.setBitlyAPIKey(dto.getBitlyAPIKey());
           pp.setBitlyUsername(dto.getBitlyUsername());           
           ProfilePreference pp1 =  getProfilePreferenceDAO().update(pp);
           dto.setProfilePreference(pp1);
       }
       return dto;
   }

    public UserProfileDetailDTO updateAlwaysAskWarningAlert(UserProfileDetailDTO dto) throws SVTException {
        ProfilePreference pp = dto.getProfilePreference();
       if(pp != null && pp.getUserProfileDetail() != null){
           pp.setWarningAlert(dto.isWarningAlert());
           ProfilePreference pp1 =  getProfilePreferenceDAO().update(pp);
           dto.setProfilePreference(pp1);
       }
       return dto;
   }

    public ProfilePreferenceDTO add(ProfilePreferenceDTO dto) throws SVTException {
        // TODO Auto-generated method stub
        return null;
    }

    private List<ProfilePreferenceDTO> getProfilePreferenceDTOList(List<ProfilePreference> ppdtos) {
        List<ProfilePreferenceDTO> dtos = new ArrayList<ProfilePreferenceDTO>();
        for(ProfilePreference ppdto: ppdtos){
            dtos.add(getProfilePreferenceDTO(ppdto));
        }
        return dtos;
    }
    private ProfilePreferenceDTO getProfilePreferenceDTO(ProfilePreference ppdto) {
        ProfilePreferenceDTO dto = new ProfilePreferenceDTO();
        if(ppdto != null){
        dto.setProfilePrefrenceId(ppdto.getProfilePrefrenceId());
        dto.setCompany(ppdto.getCompany());
        dto.setProfilePreference(ppdto);
        dto.setBenchmark(ppdto.getBenchmark());
        }
        return dto;
    }


}
