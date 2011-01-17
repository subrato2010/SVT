package com.edifixio.soc.ws;

import java.util.ArrayList;
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
//              /**
//               * // TODO : incomplete - Neel to complete
//               * List<UserProfileDTO> userProfile = getBizSvcFactory().getUserProfileMgr().createUsers(bizDTO);
//               * This above line can be map with the UserProfileController's "public boolean createLDAPUser(UserProfileDTO userProfileDTO)"
//               * method. That flow is already implemented by me, and it is working perfectly. (I have done the same thing for the timing ), 
//               * If Other way, Please Suggest.
//               */
//              //List<UserProfileDTO> userProfile = getBizSvcFactory().getUserProfileMgr().createUsers(bizDTOs); //TODO : incomplete - Neel to complete
//             
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
//             log.debug("found user: " + userProfiles.size());
//             serviceOut.setUser(new WSUser[userProfiles.size()]);
//             serviceOut = addUserDetails(userProfiles, serviceOut);

          
          // SG: Please complete the above logic's and then remove this tempo solution, added this,
          //    just to see if outer system is able to send info or not.
              serviceOut.setUser(new WSUser[bizDTOs.size()]);
              serviceOut = addUserDetails(bizDTOs, serviceOut);
          }
          catch(Exception ex){
              ex.printStackTrace();
          }
//          catch (SVTException ex2) {
//              ex2.printStackTrace();
//             log.error(ex2);
//             log.error(ex2.getStackTrace());
//             serviceOut.setMainErrorMessage(ex2.getMessage());
//          }
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
       wsDto.setUserId(userProfile.getUid()); // TODO: neel to complete
       wsDto.setFirstName(userProfile.getName());
       wsDto.setEmailAddress(userProfile.getEmailAddress());
       wsDto.setWorkAddressLine1(userProfile.getWorkAddressLine1());
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
