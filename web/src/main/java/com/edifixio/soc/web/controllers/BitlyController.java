package com.edifixio.soc.web.controllers;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.edifixio.soc.biz.ParameterMgr;

public class BitlyController extends BaseWebObject
{
    
    private UserProfileController userProfileController;
    private String bitlyUserName;

    public void authenticateBitlyAccount(ActionEvent ae) throws IllegalStateException, Exception
    {
        
        System.out.println("********** BitlyController authenticateBitlyAccount() called *****************");
        bitlyUserName = getUserProfileController().getUserProfile().getBitlyUsername();
        
        if(this.bitlyUserName != null && this.bitlyUserName.trim().length()>0)
        {
            ParameterMgr paramMgr = getParameterMgr();
            
            setSessionAttribute(BaseWebObject.BITLY_USER_NAME, this.bitlyUserName);
            setSessionAttribute(BaseWebObject.BITLY_CALLBACK_URL, paramMgr.getBitlyCallbackURL());
            setSessionAttribute(BaseWebObject.BITLY_CLIENT_ID, paramMgr.getBitlyClientId());
            setSessionAttribute(BaseWebObject.BITLY_CLIENT_SECRET, paramMgr.getBitlyClientSecret());
            setSessionAttribute(BaseWebObject.BITLY_AUTH_URL, paramMgr.getBitlyAuthUrl());
            setSessionAttribute(BaseWebObject.BITLY_ACCESSTOKEN_URL, paramMgr.getBitlyAccessTokenUrl());
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("./bitlysignin");
        }
        else
        {
            System.out.println("*********** Bitly Username is empty ************");
        }
        
    }
    
    /**
     * @return the userProfileController
     */
    public UserProfileController getUserProfileController()
    {
        return userProfileController;
    }

    /**
     * @param userProfileController the userProfileController to set
     */
    public void setUserProfileController(UserProfileController userProfileController)
    {
        this.userProfileController = userProfileController;
    }
    
}
