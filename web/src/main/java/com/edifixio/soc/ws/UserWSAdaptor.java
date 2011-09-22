package com.edifixio.soc.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.ws.common.BaseWebServiceAdaptor;
import com.edifixio.soc.ws.data.WSUser;

public class UserWSAdaptor extends BaseWebServiceAdaptor{

    private static Log log = LogFactory.getLog(UserWSAdaptor.class);
    
    /**
     * 
     * @param serviceIn-
     *           Required fields:
     * @throws NamingException 
     * 
     */
    public UserServiceOut createUsers(UserServiceIn serviceIn) throws NamingException
    {
        UserServiceOut serviceOut = new UserServiceOut();
       List<UserProfileDetailDTO> bizDTOs = getBizUserDTOs(serviceIn);
       if (bizDTOs == null || bizDTOs.size() <= 0) {
          serviceOut.setMainErrorMessage("InsufficientInputs");
       }
       else {
          try {
              /**
               * // TODO : incomplete - Neel to complete
               * List<UserProfileDTO> userProfile = getBizSvcFactory().getUserProfileMgr().createUsers(bizDTO);
               * This above line can be map with the UserProfileController's "public boolean createLDAPUser(UserProfileDTO userProfileDTO)"
               * method. That flow is already implemented by me, and it is working perfectly. (I have done the same thing for the timing ), 
               * If Other way, Please Suggest.
               */
              List<UserProfileDetailDTO> dtos = getBizSvcFactory().getUserProfileMgr().createProfile(bizDTOs); // manage rest from biz layer
              
//              List<UserProfileDTO> userProfile = getBizSvcFactory().getUserProfileMgr().createUserProfile(bizDTOs);
              
              //              List<UserProfileDTO> userProfile = getBizSvcFactory().getUserProfileMgr().createUsers(bizDTOs); //TODO : incomplete - Neel to complete
             
//              /**
//               * This Statement added by Neel for LDAP operation instead of above one (Started Here)
//               */
//             
//              for(UserProfileDetailDTO userProfileDTO : bizDTOs){
//                  UserProfileController us = new UserProfileController();
//                  us.createLDAPUser(userProfileDTO); //TODO : Will be Test With WEB Layer By Neel
//              }
//                  
//
//              // new UserProfileController().createLDAPUser(bizDTOs); //TODO: This part will implement later on
//              /*
//               `    for(int cnt=0;cnt<bizDTOs.size();cnt++)
//                      new UserProfileController().createLDAPUser(bizDTOs.get(cnt));
//              */
//              
//              //-----------------Ended Here--------------------
//              List<UserProfileDetailDTO> userProfiles = getBizSvcFactory().getUserProfileMgr().getAll();
//             System.out.println("found user: " + userProfiles.size());
//             serviceOut.setUser(new WSUser[userProfiles.size()]);
//             serviceOut = addUserDetails(userProfiles, serviceOut);

          
          // SG: Please complete the above logic's and then remove this tempo solution, added this,
          //    just to see if outer system is able to send info or not.
              serviceOut.setUser(new WSUser[dtos.size()]);
              serviceOut = addUserDetails(dtos, serviceOut);
          }
          catch(Exception ex){
              ex.printStackTrace();
          }
       }
       return serviceOut;
    }

    // --------------------------------------------//
    /**
     * input to adaptor, this method will translate the wsDTOs to bizDTOs
     * 
     * @param wsdto
     */
    private UserProfileDetailDTO translateToBizDDH(WSUserIn wsdto)
    {
        UserProfileDetailDTO dto = new UserProfileDetailDTO();
       if (wsdto != null) {
          dto.setName(wsdto.getFirstName()); // TODO: neel to complete
          dto.setUid(wsdto.getEmailAddress()); // email address will be the loginid
          dto.setName(wsdto.getFirstName()); //middleName  lastName
          dto.setWorkAddressLine1(wsdto.getWorkAddressLine1());
          dto.setWorkAddressLine2(wsdto.getWorkAddressLine2());
          dto.setWorkAddressLine3(wsdto.getWorkAddressLine3());
          dto.setCity(wsdto.getCity());
          dto.setState(wsdto.getState());
          dto.setZipCode(wsdto.getZipCode());
          dto.setPassword(wsdto.getPassword());
          dto.setEmail(wsdto.getEmailAddress());
          dto.setSubscriptionId(wsdto.getSubscriptionId());
          dto.setSubscriptionCompany(wsdto.getCompany());          
          dto.setSubscriptionDateFrom(wsdto.getSubscriptionDateFrom());
          dto.setSubscriptionDateTo(wsdto.getSubscriptionDateTo());
          dto.setSubscriptionDesc(wsdto.getSubscriptionDesc());
          dto.setSubscriptionName(wsdto.getSubscriptionName());
          dto.setUpdatedBy("WService");
          dto.setUpdatedOn(new Date());
       }
       return dto;
    }
   
    /**
     * output from assembler to adaptor for customerDetails
     * 
     * @param wsDto
     * @param customer
     */
    public WSUser translateToDetailWSDTO(WSUser wsDto, UserProfileDetailDTO userProfile)
    {
       if (null == userProfile) {
          return null;
       }
       wsDto.setUserId(userProfile.getUid()); // email address will be the loginid
       wsDto.setFirstName(userProfile.getName());
       wsDto.setEmailAddress(userProfile.getEmailAddress());
       wsDto.setWorkAddressLine1(userProfile.getWorkAddressLine1());
       wsDto.setSuccess(userProfile.getMessageWS());
       
       wsDto.setWorkAddressLine2(userProfile.getWorkAddressLine2());
       wsDto.setWorkAddressLine3(userProfile.getWorkAddressLine3());
       wsDto.setCity(userProfile.getCity());
       wsDto.setState(userProfile.getState());
       wsDto.setZipCode(userProfile.getZipCode());
       wsDto.setSubscriptionId(userProfile.getSubscriptionId());
       wsDto.setCompany(userProfile.getSubscriptionCompany());          
       wsDto.setSubscriptionDateFrom(userProfile.getSubscriptionDateFrom());
       wsDto.setSubscriptionDateTo(userProfile.getSubscriptionDateTo());
       wsDto.setSubscriptionDesc(userProfile.getSubscriptionDesc());
       wsDto.setSubscriptionName(userProfile.getSubscriptionName());
       return wsDto;
    }
    
    /**
     * This method will translate from webserviceDTO to bizDTO for user
     * 
     * @param serviceIn
     */
    private List<UserProfileDetailDTO> getBizUserDTOs(UserServiceIn serviceIn)
    {
       log.debug("getBizUserDTOs() called");
       if (null == serviceIn.getUserList() || serviceIn.getUserList().size() <= 0) {
          log.warn("no WSUsers in UserServiceIn");
          return null;
       }
       List<UserProfileDetailDTO> dtos = new ArrayList<UserProfileDetailDTO>();
       log.debug("getBizUserDTOs.size: " + serviceIn.getUserList().size());

       for (WSUserIn wsDTO : serviceIn.getUserList()) {
          if (wsDTO == null) {
             continue;
          }
          log.debug("getBizUserDTOs() found wsDTO: lastName: " + wsDTO.getFirstName());
           dtos.add(translateToBizDDH(wsDTO));
       }
       return dtos;
    }
 
    /**
     * 
     * @param customers
     * @param serviceOut
     */
    private UserServiceOut addUserDetails(List<UserProfileDetailDTO> userProfiles, UserServiceOut serviceOut)
    {
       if (userProfiles != null && userProfiles.size() > 0) {
          for (UserProfileDetailDTO userProfile : userProfiles) {
             log.debug("user is: " + userProfile);
             if (userProfile == null) {
                log.error("This user should NOT be null");
             }
             else {
                WSUser wsDTO = new WSUser();
                serviceOut.addUser(translateToDetailWSDTO(wsDTO, userProfile));
             }
          }
       }
       return serviceOut;
    }
}
