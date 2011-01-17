package com.edifixio.soc.web.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.dto.ChannelDTO;
import com.edifixio.soc.biz.dto.UserProfileDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.web.controllers.UserProfileController;
import com.edifixio.soc.web.ldap.LDAPUserMgmt;

public class LdapMgrTest extends ProjectTestCase{
    private final static Log log = LogFactory.getLog(LdapMgrTest.class);


    public void testChannelFindAll() throws SVTException {
        log.debug("ChannelMgrTest.testChannelFindAll");
       /* List<ChannelDTO> dtos = getChannelMgr().findAll();
        for (ChannelDTO dto : dtos) {
            log.debug("Channel Code: " + dto.getChannelCode());
        }*/
    }
    /**
     * Tested OK, Working
     * @throws SVTException
     * @throws NamingException
     */
    public void testLdap() throws SVTException, NamingException
    {
        UserProfileController profileController  = new UserProfileController();
        UserProfileDetailDTO profileDTO = new UserProfileDetailDTO();
        profileDTO.setUid("updated"); //For updation, no need to change the uid.
        profileDTO.setCity("testCity");
        profileDTO.setCompany("testCompany");
        profileDTO.setEmail("test@testmail.com");
        profileDTO.setFacebook("myFaceBook");
        profileDTO.setName("testName");
        profileDTO.setPassword("testPassword");
        profileDTO.setPhone("testPhone");
        profileDTO.setState("testState");
        profileDTO.setTitle("testTitle");
        
        byte[] encodeImage= new byte[500];
        try
        {
              File file = new File("D:/ANLogo.gif");
              InputStream is = new FileInputStream(file);
              encodeImage = streamToByteArray(is);
        }
       catch (Exception ex)
       {

          ex.printStackTrace();
       }
        profileDTO.setLogo(encodeImage);
        //profileController.createLDAPUser(profileDTO);
        //profileController.updateLDAPUser(profileDTO,"updated");
        profileController.searchLDAPUser(profileDTO, "updated");
    }
    
    private static byte[] streamToByteArray(InputStream in) throws IOException {
        byte[] readBytes = new byte[in.available()];
       in.read(readBytes);
        return readBytes;
   }
}
