// $Author: subratog $
package com.edifixio.soc.biz.test;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.dto.ProfileListMasterDTO;
import com.edifixio.soc.biz.dto.ProfilePreferenceDTO;
import com.edifixio.soc.biz.util.BizTestCase;
import com.edifixio.soc.common.SVTException;


public class ProfileListMasterMgrTest extends BizTestCase {
    private final static Log log = LogFactory.getLog(ProfileListMasterMgrTest.class);


    public void testSaveAndList() throws SVTException {
        ProfilePreferenceDTO dto = getProfilePreferenceMgr().getByProfilePreferenceId("2");
        
        ProfileListMasterDTO dto1 = new ProfileListMasterDTO();
        dto1.setActiveStatus(true);
        dto1.setDescription("Testing3 upd");
        dto1.setListName("Testing3");
        dto1.setPrivacy("public");
        dto1.setProfilePreference(dto.getProfilePreference());        
        List<ProfileListMasterDTO> dtos = getProfileListMasterMgr().saveAndList(dto1);
        
        for(ProfileListMasterDTO dto2 : dtos){
            log.debug("Listname: " + dto2.getListName());
            log.debug("Description: " + dto2.getDescription());
        }
        
    }
 }
