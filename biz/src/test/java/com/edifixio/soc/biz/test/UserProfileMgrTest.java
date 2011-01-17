// $Author: neelamadhabm $
package com.edifixio.soc.biz.test;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.edifixio.soc.biz.dto.TwitterAccountDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.biz.util.BizTestCase;
import com.edifixio.soc.common.SVTException;


public class UserProfileMgrTest extends BizTestCase {
    private final static Log log = LogFactory.getLog(UserProfileMgrTest.class);
    static LdapContext lCtx = null;
    static DirContext dirContext = null;

    public void testForProfile() throws SVTException {
        log.debug("UserProfileMgrTest.testForProfile");
        UserProfileDetailDTO dto = getUserProfileMgr().getProfileByUserId("guest");
        log.debug("getReportingEmail3: " + dto.getReportingEmail3());
        for(TwitterAccountDTO ta: dto.getSelfTwtAccounts()){
            log.debug("getTwitterUsername: " + ta.getTwitterUsername());
        }
    }
    
    
    public void xtestSaveProfile() throws Exception {
        log.debug("UserProfileMgrTest.testSaveProfile");
        getUserProfileMgr().updateUserProfile(getUserProfileDTO()); 
    }
    
    private UserProfileDetailDTO getUserProfileDTO() {
        UserProfileDetailDTO dto = new UserProfileDetailDTO();
        dto.setUid("subrato1");
        dto.setName("subrato goswami");
        dto.setWorkAddressLine1("test");
        dto.setBrandName("DB2");
        dto.setProductName("Database");
        dto.setIndustryName("Software");
        dto.setCompany("IBM");
        //dto.setReportingEmail1("test@test.com");
        dto.setReportingEmail2("test111@test.com");
        return dto;
    }

//======================================================================================================//
    private UserProfileDetailDTO getProfileByUserId(String string) throws Exception {
        UserProfileDetailDTO dto = new UserProfileDetailDTO();
//      connect();
        log.debug("successfully connected to admin user");
        boolean exist = searchTest("ou=people,dc=terametric,dc=com","(&(objectClass=twt)(cn=guest))");
        return dto;
    }
    
    
    /**
     * Connect to server.
     */
    public void connect()
        throws NamingException
    {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL,"ldap://192.168.15.40:389");
        env.put(Context.REFERRAL,"follow");
        env.put(Context.SECURITY_PRINCIPAL, "cn=directory manager,dc=terametric,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "edifixio");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        dirContext = new InitialDirContext(env);
        lCtx = new InitialLdapContext(env,null);
    }
    
    /**
     * Filter  the data in the ldap directory for the given search base.
     *  
     * @param  searchBase   where the search should start
     * @param  searchFilter filter this value from the base  
     */
    public boolean searchTest(String searchBase, String searchFilter) throws Exception{

        log.debug("Base: "+searchBase+" Filter="+searchFilter);
        SearchControls constrains = new SearchControls();
        constrains.setSearchScope(SearchControls.SUBTREE_SCOPE);
        NamingEnumeration results = null;
        int totalResults = 0;
        String value = "";
        try {
            // find all users
            results = dirContext.search(searchBase, searchFilter, constrains);
            while (results.hasMoreElements()) {
                SearchResult sr = (SearchResult) results.next();
                System.out.println("============================");
                totalResults++;
                log.debug("Name         :" + sr.getName());
                
                
                // Print out some of the attributes, catch the exception if the
                // attributes have no values
                Attributes attrs = sr.getAttributes();
                NamingEnumeration t1 = attrs.getAll();
                while(t1.hasMoreElements()){
                    value = "" + t1.next();
                    log.debug(value);
                }
            }
            log.debug("Total result:"+ totalResults);
        } catch (NamingException e1) {
            e1.printStackTrace();
            throw new Exception("An Error Occured during Ldap search");
        }
        return((totalResults>0));
    }
    
 }
