package com.edifixio.soc.biz.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.ldap.LdapContext;

import com.edifixio.soc.biz.dto.UserProfileDetailDTO;

public class LDAPConnector {
    
    private static final String JNDI_NAME = "external/ldap/twt";
    private static final String USER_DN = "ou=people";
    private static final String NAMINGCONTEXTS = "namingcontexts";
    private static final String BINARY_PROPERTY_NAME = "java.naming.ldap.attributes.binary";
    
    /**
     * 
     * @return
     */
    public static LdapContext getLDAPContext()
    {
        LdapContext ldapCtx = null;
        try{
           InitialContext iniCtx = new InitialContext();
           ldapCtx = (LdapContext) iniCtx.lookup(JNDI_NAME);
           try {
               ldapCtx.addToEnvironment(BINARY_PROPERTY_NAME, ""
                       + UserProfileDetailDTO.LOGO + " "
                       + UserProfileDetailDTO.PHOTO);
           } catch (NamingException ne) {
               ne.printStackTrace();
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        return ldapCtx;
    }
    
    /**
     * 
     * @return
     */
    public static String getBaseDN()
    {
        String baseDN = null;
        
        try {
            
            LdapContext ctx = getLDAPContext();
            if(ctx == null)
                return null;
            Attributes attr = ctx.getAttributes("", new String[]{NAMINGCONTEXTS});
            if(attr == null)
                return null;
            else{
                baseDN = attr.get(NAMINGCONTEXTS).get(0).toString().trim();  
            } 
            
        } catch (NamingException e) {
            e.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return baseDN;
    }
    
    /**
     * 
     * @return
     */
    public static String getUserDN(){
        return USER_DN + "," + getBaseDN();
    }
}
