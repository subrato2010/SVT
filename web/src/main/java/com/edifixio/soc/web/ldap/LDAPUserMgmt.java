package com.edifixio.soc.web.ldap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.faces.event.ActionEvent;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import com.edifixio.soc.biz.dto.UserProfileDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.biz.util.LDAPConnector;
import com.edifixio.soc.common.SVTException;
import com.edifixio.soc.web.controllers.BaseWebObject;


public class LDAPUserMgmt extends BaseWebObject {
    DirContext dirCtx = null;
   static LdapContext ldapCtx = null;
    // String userid ="uid=neel,ou=people,dc=terametric,dc=com";
    String userid = "ou=people,dc=terametric,dc=com";

    public LDAPUserMgmt() throws NamingException, SVTException {
        if (dirCtx == null)
            dirCtx = getLdapMyJNDIConnection(); // authenticate();//
    }
    /*
     * public void userCreationProcess(ActionEvent e) throws SVTException,
     * NamingException { System.out.println(createUser()); }
     */
    /*
     * public void userUpdationProcess(ActionEvent e) throws SVTException,
     * NamingException { System.out.println(editUser()); }
     */
    public boolean editUser(UserProfileDetailDTO userProfileDTO, String userID)
            throws SVTException, NamingException {
        return editExistingUser(userProfileDTO, userID);
    }


    public boolean createUser(UserProfileDetailDTO userProfileDTO)
            throws SVTException, NamingException {
        return createNewUser(userProfileDTO);
    }

    private class BasicAttributesPutter {
        BasicAttributes ba;
        BasicAttributesPutter(BasicAttributes _ba) {
            ba = _ba;
        }
        void put(String attrID, Object val) {
            if (val == null || val.equals(""))
                return;
            ba.put(attrID, val);
        }
        void put(Attribute objba) {
            ba.put(objba);
        }
    }
    /**
     * It searches for existing user, if not found then it returns false. 
     * @param userProfileDTO
     * @param searchString
     * @return
     * @throws NamingException
     */
    public boolean searchForLDAPUser(UserProfileDetailDTO userProfileDTO,String searchString) throws NamingException {
        
        Map<String, String> _stroreLDAPUser = new HashMap<String, String>();  
        Attributes matchAttrs = new BasicAttributes(true);
        matchAttrs.put(new BasicAttribute("uid", searchString));
        NamingEnumeration searchUser = dirCtx.search(userid, matchAttrs);
        Attributes attributes = validateUser(searchUser);
        if(attributes == null)
        {
            System.out.println("!!! Searching Failed, Searched Instance Not Found !!!");
            return false;
        }
        
        String s = attributes.toString().substring(1,attributes.toString().length()-1);
        String str[] = s.toString().split(",");
        for(String st : str)
            System.out.println(st.substring(st.indexOf("=")+1, st.length()));
        return true;
    }
    
    private Attributes validateUser(NamingEnumeration searchUser) throws NamingException
    {
        if(searchUser.hasMore()== false)
            return null;
        return ((SearchResult) searchUser.next()).getAttributes();
    }

    /**
     * !!!--LDAP Attributes listed below --!!! twtName $ twtTitle $ twtCompany $
     * twtWorkAddressLine1 $ twtWorkAddressLine2 $ twtWorkAddressLine3 $ twtCity
     * $ twtState $ twtZiPCode $ twtPhone $ twtEmail $ twtWebsite $ twtTwitter $
     * twtFacebook $ twtLogo $ twtPhoto )
     */
    public boolean createNewUser(UserProfileDetailDTO userProfileDTO)
            throws SVTException, NamingException {
        // TODO photo and logo addition in LDAP Database
        BasicAttribute attr = new BasicAttribute("objectClass");
        attr.add("inetOrgPerson"); // Base SCHEMA
        attr.add("twt"); // Which Schema is been used in LDAP Server name to set the attributes
        BasicAttributes attrs = new BasicAttributes();
        BasicAttributesPutter objBAP = new BasicAttributesPutter(attrs);
        attrs.put(attr);
        objBAP.put("uid", userProfileDTO.getUid());
        objBAP.put("userPassword", userProfileDTO.getPassword());
        objBAP.put("twtName", userProfileDTO.getName());
        objBAP.put("twtTitle", userProfileDTO.getTitle());
        objBAP.put("twtCompany", userProfileDTO.getCompany());
        objBAP.put("twtWorkAddressLine1", userProfileDTO.getWorkAddressLine1());
        objBAP.put("twtWorkAddressLine2", userProfileDTO.getWorkAddressLine2());
        objBAP.put("twtWorkAddressLine3", userProfileDTO.getWorkAddressLine3());
        objBAP.put("twtCity", userProfileDTO.getCity());
        objBAP.put("twtState", userProfileDTO.getState());
        objBAP.put("twtZiPCode", userProfileDTO.getZipCode());
        objBAP.put("twtPhone", userProfileDTO.getPhone());
        objBAP.put("twtEmail", userProfileDTO.getEmail());
        objBAP.put("twtWebsite", userProfileDTO.getWebsite());
        objBAP.put("twtTwitter", userProfileDTO.getTwitter());
        objBAP.put("twtFacebook", userProfileDTO.getFacebook());
        objBAP.put("twtLogo", userProfileDTO.getLogo());
        objBAP.put("twtPhoto", userProfileDTO.getPhoto());
        objBAP.put("givenName", userProfileDTO.getName());
        objBAP.put("sn", userProfileDTO.getName());
        objBAP.put("cn", userProfileDTO.getName());
        dirCtx.createSubcontext("uid=" + userProfileDTO.getUid() + "," + userid, attrs);
        System.out.println("!!! Data Insertion !!!");
        return true;
    }


    /**
     * !!!--LDAP Attributes listed below --!!! twtName $ twtTitle $ twtCompany $
     * twtWorkAddressLine1 $ twtWorkAddressLine2 $ twtWorkAddressLine3 $ twtCity
     * $ twtState $ twtZiPCode $ twtPhone $ twtEmail $ twtWebsite $ twtTwitter $
     * twtFacebook $ twtLogo $ twtPhoto )
     */
    public boolean editExistingUser(UserProfileDetailDTO userProfileDTO, String userID)
            throws SVTException, NamingException {
        ModificationItem[] mods = new ModificationItem[20];
        
        Attribute mod0  = new BasicAttribute("userPassword", userProfileDTO.getPassword());
        Attribute mod1  = new BasicAttribute("twtName", userProfileDTO.getName());
        Attribute mod2  = new BasicAttribute("twtTitle", userProfileDTO.getTitle());
        Attribute mod3  = new BasicAttribute("twtCompany", userProfileDTO.getCompany());
        Attribute mod4  = new BasicAttribute("twtWorkAddressLine1",userProfileDTO.getWorkAddressLine1());
        Attribute mod5  = new BasicAttribute("twtWorkAddressLine2",userProfileDTO.getWorkAddressLine2());
        Attribute mod6  = new BasicAttribute("twtWorkAddressLine3",userProfileDTO.getWorkAddressLine3());
        Attribute mod7  = new BasicAttribute("twtCity", userProfileDTO.getCity());
        Attribute mod8  = new BasicAttribute("twtState", userProfileDTO.getState());
        Attribute mod9  = new BasicAttribute("twtZiPCode", userProfileDTO.getZipCode());
        Attribute mod10 = new BasicAttribute("twtPhone", userProfileDTO.getPhone());
        Attribute mod11 = new BasicAttribute("twtEmail", userProfileDTO.getEmail());
        Attribute mod12 = new BasicAttribute("twtWebsite", userProfileDTO.getWebsite());
        Attribute mod13 = new BasicAttribute("twtTwitter", userProfileDTO.getTwitter());
        Attribute mod14 = new BasicAttribute("twtFacebook", userProfileDTO.getFacebook());
        Attribute mod15 = new BasicAttribute("twtLogo", userProfileDTO.getLogo());
        Attribute mod16 = new BasicAttribute("twtPhoto", userProfileDTO.getPhoto());
        Attribute mod17 = new BasicAttribute("givenName", userProfileDTO.getName());
        Attribute mod18 = new BasicAttribute("sn", userProfileDTO.getName());
        Attribute mod19 = new BasicAttribute("cn", userProfileDTO.getName());
        
            mods[0]  = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);
            mods[1]  = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod1);
            mods[2]  = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod2);
            mods[3]  = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod3);
            mods[4]  = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod4);
            mods[5]  = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod5);
            mods[6]  = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod6);
            mods[7]  = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod7);
            mods[8]  = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod8);
            mods[9]  = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod9);
            mods[10] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod10);
            mods[11] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod11);
            mods[12] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod12);
            mods[13] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod13);
            mods[14] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod14);
            mods[15] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod15);
            mods[16] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod16);
            mods[17] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod17);
            mods[18] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod18);
            mods[19] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod19);
        dirCtx.modifyAttributes("uid=" + userID + "," + userid, mods);
        System.out.println("Edit Existing "+"uid=" + userID + "," + userid+"  :  "+ mods);
        return true;
    }


    /**
     * This method 'getLdapmyJNDIConnection' is not useful for web base, this is
     * been created for testing purpose from public static void main(String a[]){}
     * @return
     * @throws Exception
     */
    public static LdapContext getLdapMyJNDIConnection() throws SVTException,
            NamingException {
        if (ldapCtx != null)
            return ldapCtx;
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://192.168.15.40:389");
        env.put(Context.SECURITY_PRINCIPAL,
                "cn=Directory Manager,dc=terametric,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "edifixio");
        try {
            ldapCtx = new InitialLdapContext(env, null);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return ldapCtx;
    }


    public LdapContext authenticate() throws NamingException {
        String baseDN = "";
        LdapContext ctx = null;
        ctx = LDAPConnector.getLDAPContext();
        if (ctx == null)
            return null;
        Attributes attr = ctx.getAttributes("",
                new String[] { "namingcontexts" });
        if (attr == null)
            return null;
        else {
            baseDN = attr.get("namingcontexts").get(0).toString().trim();
        }
        System.out.println("!!! Authenticated !!!");
        return ctx;
    }


    /**
     * This part will call if the "action" will associates attribute with the
     * commandButton <a4j:commandButton value="LDAP Connect"
     * action="#{ldapCommunication.callAction}">
     * 
     * @return
     */
    public String callAction() {
        System.out.println("callAction()");
        return null;
    }
}
