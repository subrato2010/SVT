package com.edifixio.soc.biz.util;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.common.SVTException;

public class UserProfileUtil {
    
 public List<UserProfileDetailDTO> searchUser(String query)
 {
        
        String name = LDAPConnector.getUserDN();
        List<UserProfileDetailDTO> userProfileList = null;
        LdapContext ldapContext = null;
        try{
            //get context
            ldapContext = LDAPConnector.getLDAPContext();
            if(ldapContext == null)
                return null;
            
            SearchControls constraints = new SearchControls();
            constraints.setSearchScope(SearchControls.ONELEVEL_SCOPE);
            NamingEnumeration<SearchResult> results 
                = ldapContext.search(name, query, constraints);
            
            userProfileList = getUserProfiles(results);
            
            //close context
            ldapContext.close();
            
        }catch(Exception e){
            e.printStackTrace();
            userProfileList = null;
            if(ldapContext != null)
                try{
                    //close context
                    ldapContext.close();
                }catch(Exception ex){
                    e.printStackTrace();
                }
        }
        return userProfileList;
 }
 
 private List<UserProfileDetailDTO> getUserProfiles(NamingEnumeration<SearchResult> results){
     
     List<UserProfileDetailDTO> list = null;
     
     try
     {
         if(results == null )
             return null;
         else
             list = new ArrayList<UserProfileDetailDTO>();
             
         while(results.hasMore())
         {
             
             SearchResult sr=(SearchResult)results.next();
             Attributes ar=sr.getAttributes();

             if(ar!=null)
             {
                 UserProfileDetailDTO userProfile = new UserProfileDetailDTO();
                 
                 if(ar.get(UserProfileDetailDTO.USER_ID)!=null)
                 {
                     String uid= ar.get(UserProfileDetailDTO.USER_ID).get().toString();
                     userProfile.setUid(uid);
                 }
                 if(ar.get(UserProfileDetailDTO.PASSWORD)!=null)
                 {
                     byte[] password =  (byte[])ar.get(UserProfileDetailDTO.PASSWORD).get();
                     String strPassword= new String(password, "UTF-8");
                     userProfile.setPassword(strPassword);
                 }
                 if(ar.get(UserProfileDetailDTO.NAME)!=null)
                 {
                     String name= ar.get(UserProfileDetailDTO.NAME).get().toString();
                     userProfile.setName(name);
                 }
                 if(ar.get(UserProfileDetailDTO.TITLE)!=null)
                 {
                     String title= ar.get(UserProfileDetailDTO.TITLE).get().toString();
                     userProfile.setTitle(title);
                 }
                 if(ar.get(UserProfileDetailDTO.COMPANY)!=null)
                 {
                     String company= ar.get(UserProfileDetailDTO.COMPANY).get().toString();
                     userProfile.setCompany(company);
                 }
                 if(ar.get(UserProfileDetailDTO.WORK_ADDRESS_LINE1)!=null)
                 {
                     String workAddressLine1= ar.get(UserProfileDetailDTO.WORK_ADDRESS_LINE1).get().toString();
                     userProfile.setWorkAddressLine1(workAddressLine1);
                 }
                 if(ar.get(UserProfileDetailDTO.WORK_ADDRESS_LINE2)!=null)
                 {
                     String workAddressLine2= ar.get(UserProfileDetailDTO.WORK_ADDRESS_LINE2).get().toString();
                     userProfile.setWorkAddressLine2(workAddressLine2);
                 }
                 if(ar.get(UserProfileDetailDTO.WORK_ADDRESS_LINE3)!=null)
                 {
                     String workAddressLine3= ar.get(UserProfileDetailDTO.WORK_ADDRESS_LINE3).get().toString();
                     userProfile.setWorkAddressLine3(workAddressLine3);
                 }
                 if(ar.get(UserProfileDetailDTO.CITY)!=null)
                 {
                     String city= ar.get(UserProfileDetailDTO.CITY).get().toString();
                     userProfile.setCity(city);
                 }
                 if(ar.get(UserProfileDetailDTO.STATE)!=null)
                 {
                     String state= ar.get(UserProfileDetailDTO.STATE).get().toString();
                     userProfile.setState(state);
                 }
                 if(ar.get(UserProfileDetailDTO.ZIP_CODE)!=null)
                 {
                     String ziPCode= ar.get(UserProfileDetailDTO.ZIP_CODE).get().toString();
                     userProfile.setZipCode(ziPCode);
                 }
                 if(ar.get(UserProfileDetailDTO.PHONE)!=null)
                 {
                     String phone= ar.get(UserProfileDetailDTO.PHONE).get().toString();
                     userProfile.setPhone(phone);
                 }
                 if(ar.get(UserProfileDetailDTO.EMAIL)!=null)
                 {
                     String email = ar.get(UserProfileDetailDTO.EMAIL).get().toString();
                     userProfile.setEmail(email);
                 }
                 if(ar.get(UserProfileDetailDTO.WEBSITE)!=null)
                 {
                     String website= ar.get(UserProfileDetailDTO.WEBSITE).get().toString();
                     userProfile.setWebsite(website);
                 }
                 if(ar.get(UserProfileDetailDTO.TWITTER)!=null)
                 {
                     String twitter= ar.get(UserProfileDetailDTO.TWITTER).get().toString();
                     userProfile.setTwitter(twitter);
                 }
                 if(ar.get(UserProfileDetailDTO.FACEBOOK)!=null)
                 {
                     String facebook= ar.get(UserProfileDetailDTO.FACEBOOK).get().toString();
                     userProfile.setFacebook(facebook);
                 }
                 if(ar.get(UserProfileDetailDTO.LOGO)!=null)
                 {
                     byte[]logo = (byte[])ar.get(UserProfileDetailDTO.LOGO).get();
                     
                     userProfile.setLogo(logo);
                 }
                 if(ar.get(UserProfileDetailDTO.PHOTO)!=null)
                 {
                     byte[]photo = (byte[])ar.get(UserProfileDetailDTO.PHOTO).get();
                     
                     userProfile.setPhoto(photo);
                 }
                 list.add(userProfile);
             }
         }
         
     }catch(Exception e){
         e.printStackTrace();
     }
     return list;
 }
 /**
  * This is a Inner Class to add the attribute into the LDAP server
  * @author NeelamadhabM
  *
  */
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
  * Added by Neel For entry the user profile for the first time from web services
  * @param userProfile
  * @author NeelamadhabM
 * @throws NamingException 
 * @throws SVTException 
 */
 public void createLDAPProfile(UserProfileDetailDTO userProfile) throws SVTException
 {     
     LdapContext ldapCtx = LDAPConnector.getLDAPContext();
     String userDN = LDAPConnector.getUserDN();
     String uid = userProfile.getUid();
     
     String strCn = "uid="+uid + "," + userDN;
     //String strCn = "uid="+uid + "," + "dc=terametric,dc=com";
     BasicAttribute attr = new BasicAttribute("objectClass");
     attr.add("inetOrgPerson"); // Base SCHEMA
     attr.add("twt"); // Which Schema is been used in LDAP Server name to set the attributes
     BasicAttributes attrs = new BasicAttributes();
     BasicAttributesPutter objBAP = new BasicAttributesPutter(attrs);
     
     try
     {
         attrs.put(attr);
      //Name Entry
         if(userProfile.getName() == null || userProfile.getName().trim().equals(""))
            userProfile.setName("");
            objBAP.put(UserProfileDetailDTO.NAME, userProfile.getName());
        
         
      //Password Entry
         if(userProfile.getPassword() == null || userProfile.getPassword().trim().equals(""))
            userProfile.setPassword("");
            objBAP.put(UserProfileDetailDTO.PASSWORD, userProfile.getPassword());
         
      // Title Entry
        if(userProfile.getTitle() == null || userProfile.getTitle().trim().equals(""))
        {
            userProfile.setTitle("");
            objBAP.put(UserProfileDetailDTO.TITLE, userProfile.getTitle());
        }

      // COMPANY 
        if(userProfile.getCompany() == null || userProfile.getCompany().trim().equals(""))
            userProfile.setCompany("");
            objBAP.put(UserProfileDetailDTO.COMPANY, userProfile.getCompany());
         
      // WORK_ADDRESS_LINE1  
        if(userProfile.getWorkAddressLine1() == null || userProfile.getWorkAddressLine1().trim().equals(""))
            userProfile.setWorkAddressLine1("");
            objBAP.put(UserProfileDetailDTO.WORK_ADDRESS_LINE1, userProfile.getWorkAddressLine1());
         
      // WORK_ADDRESS_LINE2  
            if(userProfile.getWorkAddressLine2() == null || userProfile.getWorkAddressLine2().trim().equals(""))
                userProfile.setWorkAddressLine2("");
                objBAP.put(UserProfileDetailDTO.WORK_ADDRESS_LINE2, userProfile.getWorkAddressLine2());
         
      // WORK_ADDRESS_LINE3  
            if(userProfile.getWorkAddressLine3() == null || userProfile.getWorkAddressLine3().trim().equals(""))
                userProfile.setWorkAddressLine3("");
                objBAP.put(UserProfileDetailDTO.WORK_ADDRESS_LINE3, userProfile.getWorkAddressLine3());
         
       //CITY
            if(userProfile.getCity() == null || userProfile.getCity().trim().equals(""))
                userProfile.setCity("");
                objBAP.put(UserProfileDetailDTO.CITY, userProfile.getCity());

       //STATE
            if(userProfile.getState() == null || userProfile.getState().trim().equals(""))
                userProfile.setState("");
                objBAP.put(UserProfileDetailDTO.STATE, userProfile.getState());

       //ZIP
            if(userProfile.getZipCode() == null || userProfile.getZipCode().trim().equals(""))
                userProfile.setZipCode("");
                objBAP.put(UserProfileDetailDTO.ZIP_CODE, userProfile.getZipCode());

       //PHONE
            if(userProfile.getPhone() == null || userProfile.getPhone().trim().equals(""))
                userProfile.setPhone("");
                objBAP.put(UserProfileDetailDTO.PHONE, userProfile.getPhone());

       //EMAIL
            if(userProfile.getEmail() == null || userProfile.getEmail().trim().equals(""))
                userProfile.setEmail("");
                objBAP.put(UserProfileDetailDTO.EMAIL, userProfile.getEmail());

       //WEBSITE
            if(userProfile.getWebsite() == null || userProfile.getWebsite().trim().equals(""))
                userProfile.setWebsite("");
                objBAP.put(UserProfileDetailDTO.WEBSITE, userProfile.getWebsite());

       //TWITTER
            if(userProfile.getTwitter() == null || userProfile.getTwitter().trim().equals(""))
                userProfile.setTwitter("");
                objBAP.put(UserProfileDetailDTO.TWITTER, userProfile.getTwitter());

       //FACEBOOK
            if(userProfile.getFacebook() == null || userProfile.getFacebook().trim().equals(""))
                userProfile.setFacebook("");
                objBAP.put(UserProfileDetailDTO.FACEBOOK, userProfile.getFacebook());

       //LOGO
            if(userProfile.getLogo() == null)
                userProfile.setLogo(new byte[]{});
                objBAP.put(UserProfileDetailDTO.LOGO, userProfile.getLogo());

       //PHOTO
            if(userProfile.getPhoto() == null)
                userProfile.setPhoto(new byte[]{});
                objBAP.put(UserProfileDetailDTO.PHOTO, userProfile.getPhoto());
          
       //Extra LDAP Parameter
                objBAP.put("sn", userProfile.getUid());
                objBAP.put("cn", userProfile.getName());
                
       //Insert to LDAP Server for Persistence
           ldapCtx.createSubcontext(strCn, attrs);
           //ldapCtx.createSubcontext("uid="+userProfile.getUid()+",ou=people,dc=terametric,dc=com",attrs);
     }
     
     catch(Exception e)
     {
         e.printStackTrace();
     }
 }
 

 
 public void modifyLDAPProfile(UserProfileDetailDTO userProfile)
 {
     
     LdapContext ldapCtx = LDAPConnector.getLDAPContext();
     String userDN = LDAPConnector.getUserDN();
     String uid = userProfile.getUid();
     String strCn = "uid="+uid + "," + userDN;
     String query = "(uid="+ uid + ")";
     List<UserProfileDetailDTO> userList = searchUser(query);
     UserProfileDetailDTO oldUserProfile = userList.get(0);
     
     try
     {
     // NAME
         if(userProfile.getName() == null) userProfile.setName("");
         if(userProfile.getName().equals("") && (oldUserProfile.getName() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.NAME,oldUserProfile.getName()));
         else if(!userProfile.getName().equals("") && (oldUserProfile.getName() == null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.NAME,userProfile.getName()));
         else if(!userProfile.getName().equals("") && (oldUserProfile.getName() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.NAME,userProfile.getName()));
         
      // PASSWORD
         if(userProfile.getPassword() == null) userProfile.setPassword("");
         if(userProfile.getPassword().equals("") && (oldUserProfile.getPassword() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.PASSWORD,oldUserProfile.getPassword()));
         else if(!userProfile.getPassword().equals("") && (oldUserProfile.getPassword() == null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.PASSWORD,"1111"));
         else if(!userProfile.getPassword().equals("") && (oldUserProfile.getPassword() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.PASSWORD,userProfile.getPassword()));
         
      // TITLE 
         if(userProfile.getTitle() == null) userProfile.setTitle("");
         if(userProfile.getTitle().equals("") && (oldUserProfile.getTitle() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.TITLE,oldUserProfile.getTitle()));
         else if(!userProfile.getTitle().equals("") && (oldUserProfile.getTitle() == null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.TITLE,userProfile.getTitle()));
         else if(!userProfile.getTitle().equals("") && (oldUserProfile.getTitle() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.TITLE,userProfile.getTitle()));
      // COMPANY 
         if(userProfile.getCompany() == null) userProfile.setCompany("");
         if(userProfile.getCompany().equals("") && (oldUserProfile.getCompany() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.COMPANY,oldUserProfile.getCompany()));
         else if(!userProfile.getCompany().equals("") && (oldUserProfile.getCompany() == null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.COMPANY,userProfile.getCompany()));
         else if(!userProfile.getCompany().equals("") && (oldUserProfile.getCompany() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.COMPANY,userProfile.getCompany()));
         
      // WORK_ADDRESS_LINE1  
         if(userProfile.getWorkAddressLine1() == null) userProfile.setWorkAddressLine1("");
         if(userProfile.getWorkAddressLine1().equals("") && (oldUserProfile.getWorkAddressLine1() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.WORK_ADDRESS_LINE1,oldUserProfile.getWorkAddressLine1()));
         else if(!userProfile.getWorkAddressLine1().equals("") && (oldUserProfile.getWorkAddressLine1() == null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.WORK_ADDRESS_LINE1,userProfile.getWorkAddressLine1()));
         else if(!userProfile.getWorkAddressLine1().equals("") && (oldUserProfile.getWorkAddressLine1() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.WORK_ADDRESS_LINE1,userProfile.getWorkAddressLine1()));
         
      // WORK_ADDRESS_LINE2  
         if(userProfile.getWorkAddressLine2() == null) userProfile.setWorkAddressLine2("");
         if(userProfile.getWorkAddressLine2().equals("") && (oldUserProfile.getWorkAddressLine2() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.WORK_ADDRESS_LINE2,oldUserProfile.getWorkAddressLine2()));
         else if(!userProfile.getWorkAddressLine2().equals("") && (oldUserProfile.getWorkAddressLine2() == null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.WORK_ADDRESS_LINE2,userProfile.getWorkAddressLine2()));
         else if(!userProfile.getWorkAddressLine2().equals("") && (oldUserProfile.getWorkAddressLine2() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.WORK_ADDRESS_LINE2,userProfile.getWorkAddressLine2()));
         
      // WORK_ADDRESS_LINE3  
         if(userProfile.getWorkAddressLine3() == null) userProfile.setWorkAddressLine3("");
         if(userProfile.getWorkAddressLine3().equals("") && (oldUserProfile.getWorkAddressLine3() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.WORK_ADDRESS_LINE3,oldUserProfile.getWorkAddressLine3()));
         else if(!userProfile.getWorkAddressLine3().equals("") && (oldUserProfile.getWorkAddressLine3() == null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.WORK_ADDRESS_LINE3,userProfile.getWorkAddressLine3()));
         else if(!userProfile.getWorkAddressLine3().equals("") && (oldUserProfile.getWorkAddressLine3() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.WORK_ADDRESS_LINE3,userProfile.getWorkAddressLine3()));
         
       //CITY
         if(userProfile.getCity() == null) userProfile.setCity("");
         if(userProfile.getCity().equals("") && (oldUserProfile.getCity() != null))
          ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.CITY,oldUserProfile.getCity()));
         else if(!userProfile.getCity().equals("") && (oldUserProfile.getCity() == null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.CITY,userProfile.getCity()));
         else if(!userProfile.getCity().equals("") && (oldUserProfile.getCity() != null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.CITY,userProfile.getCity()));



         //STATE
         if(userProfile.getState() == null) userProfile.setState("");
         if(userProfile.getState().equals("") && (oldUserProfile.getState() != null))
          ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.STATE,oldUserProfile.getState()));
         else if(!userProfile.getState().equals("") && (oldUserProfile.getState() == null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.STATE,userProfile.getState()));
         else if(!userProfile.getState().equals("") && (oldUserProfile.getState() != null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.STATE,userProfile.getState()));

        //ZIP
         if(userProfile.getZipCode() == null) userProfile.setZipCode("");
         if(userProfile.getZipCode().equals("") && (oldUserProfile.getZipCode() != null))
          ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.ZIP_CODE,oldUserProfile.getZipCode()));
         else if(!userProfile.getZipCode().equals("") && (oldUserProfile.getZipCode() == null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.ZIP_CODE,userProfile.getZipCode()));
         else if(!userProfile.getZipCode().equals("") && (oldUserProfile.getZipCode() != null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.ZIP_CODE,userProfile.getZipCode()));


         //PHONE
         if(userProfile.getPhone() == null) userProfile.setPhone("");
         if(userProfile.getPhone().equals("") && (oldUserProfile.getPhone() != null))
         {
             System.out.println(1);
          ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.PHONE,oldUserProfile.getPhone()));
         }
         else if(!userProfile.getPhone().equals("") && (oldUserProfile.getPhone() == null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.PHONE,userProfile.getPhone()));
         else if(!userProfile.getPhone().equals("") && (oldUserProfile.getPhone() != null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.PHONE,userProfile.getPhone()));

         //EMAIL
         if(userProfile.getEmail() == null) userProfile.setEmail("");
         if(userProfile.getEmail().equals("") && (oldUserProfile.getEmail() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.EMAIL,oldUserProfile.getEmail()));
         else if(!userProfile.getEmail().equals("") && (oldUserProfile.getEmail() == null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.EMAIL,userProfile.getEmail()));
         else if(!userProfile.getEmail().equals("") && (oldUserProfile.getEmail() != null))
             ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.EMAIL,userProfile.getEmail()));


         //WEBSITE
         if(userProfile.getWebsite() == null) userProfile.setWebsite("");
         if(userProfile.getWebsite().equals("") && (oldUserProfile.getWebsite() != null))
          ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.WEBSITE,oldUserProfile.getWebsite()));
         else if(!userProfile.getWebsite().equals("") && (oldUserProfile.getWebsite() == null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.WEBSITE,userProfile.getWebsite()));
         else if(!userProfile.getWebsite().equals("") && (oldUserProfile.getWebsite() != null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.WEBSITE,userProfile.getWebsite()));



         //TWITTER
         if(userProfile.getTwitter() == null) userProfile.setTwitter("");
         if(userProfile.getTwitter().equals("") && (oldUserProfile.getTwitter() != null))
          ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.TWITTER,oldUserProfile.getTwitter()));
         else if(!userProfile.getTwitter().equals("") && (oldUserProfile.getTwitter() == null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.TWITTER,userProfile.getTwitter()));
         else if(!userProfile.getTwitter().equals("") && (oldUserProfile.getTwitter() != null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.TWITTER,userProfile.getTwitter()));



         //FACEBOOK
         if(userProfile.getFacebook() == null) userProfile.setFacebook("");
         if(userProfile.getFacebook().equals("") && (oldUserProfile.getFacebook() != null))
          ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.FACEBOOK,oldUserProfile.getFacebook()));
         else if(!userProfile.getFacebook().equals("") && (oldUserProfile.getFacebook() == null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.FACEBOOK,userProfile.getFacebook()));
         else if(!userProfile.getFacebook().equals("") && (oldUserProfile.getFacebook() != null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.FACEBOOK,userProfile.getFacebook()));



         //LOGO
         if(userProfile.getLogo() == null) userProfile.setLogo(new byte[]{});
         if(userProfile.getLogo()== null && (oldUserProfile.getLogo() != null))
          ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.LOGO,oldUserProfile.getLogo()));
         else if(userProfile.getLogo()!= null && (oldUserProfile.getLogo() == null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.LOGO,userProfile.getLogo()));
         else if(userProfile.getLogo()!= null && (oldUserProfile.getLogo() != null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.LOGO,userProfile.getLogo()));



         //PHOTO
         if(userProfile.getPhoto() == null) userProfile.setPhoto(new byte[]{});
         if(userProfile.getPhoto()== null && (oldUserProfile.getPhoto() != null))
          ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.PHOTO,oldUserProfile.getPhoto()));
         else if(userProfile.getPhoto() != null && (oldUserProfile.getPhoto() == null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.PHOTO,userProfile.getPhoto()));
         else if(userProfile.getPhoto() != null && (oldUserProfile.getPhoto() != null))
         ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDetailDTO.PHOTO,userProfile.getPhoto()));

     }
     
     catch(Exception e)
     {
         e.printStackTrace();
     }
 }
 
 public static void main1(String s[]){
     
     
     String fields[] = new String[]{"city","state","phone","website","twitter","facebook","logo","photo"};
    
     String str = "if(userProfile.getZZZ() == null) userProfile.setZZZ(\"\");\n" + 
     "if(userProfile.getZZZ().equals(\"\") && (oldUserProfile.getZZZ() != null))\n"+
        " ldapCtx.modifyAttributes(strCn,LdapContext.REMOVE_ATTRIBUTE,new BasicAttributes(UserProfileDTO.ppp,oldUserProfile.getZZZ()));\n"+
     "else if(!userProfile.getZZZ().equals(\"\") && (oldUserProfile.getZZZ() == null))\n"+
         "ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDTO.ppp,userProfile.getZZZ()));\n"+
     "else if(!userProfile.getZZZ().equals(\"\") && (oldUserProfile.getZZZ() != null))\n"+
         "ldapCtx.modifyAttributes(strCn,LdapContext.REPLACE_ATTRIBUTE,new BasicAttributes(UserProfileDTO.ppp,userProfile.getZZZ()));\n";
     
     
     for (int i = 0; i < fields.length; i++) {
        
         String a = fields[i];
         a = a.replaceFirst(""+a.charAt(0), ""+a.toUpperCase().charAt(0));
         System.out.println("\n\n//" + a.toUpperCase());
         String sx = str.replaceAll("ZZZ", a);
         sx = sx.replaceAll("ppp", a.toUpperCase());
         
         
         System.out.println(sx);        
    }
     
 }
 
 public static void main2(String[] ss){
     
             int i = 190;
             UserProfileDetailDTO userProfile = new UserProfileDetailDTO();
             userProfile.setCity("BBSR");
             userProfile.setName("Neel");
             userProfile.setPassword("Kumar");
             userProfile.setUid("new");
             try{
             new UserProfileUtil().createLDAPProfile(userProfile);
             }
             catch(Exception e){}
             /*String[] fields = new String[]{"svtName","svtTitle","svtCompany","svtWorkAddressLine1","svtWorkAddressLine2","svtWorkAddressLine3","svtCity","svtState",
                     "svtZiPCode","svtPhone","svtWebsite","svtTwitter","svtFacebook","svtLogo","svtPhoto"};
             //System.out.println(fields.length);
             String xx = 
                 
             "attributetype ( 1.1.2.1.ggg\n"+
             "\tNAME 'zzz'\n"+
             "\tDESC 'zzz of user'\n"+
             "\tEQUALITY caseIgnoreMatch\n"+
             "\tSUBSTR caseIgnoreSubstringsMatch\n"+
             "\tSYNTAX 1.3.6.1.4.1.1466.115.121.1.15 )";
             
             for (int j = 0; j < fields.length; j++) 
             {
                 String str = xx.replaceAll("zzz", fields[j]);
                 str = str.replaceAll("ggg", ""+i++);
                 System.out.println(str + "\n");
             }
            
     String sf = "";
             for (int j = 0; j < fields.length; j++) {
                sf = sf + fields[j] + " $ ";
            }
             System.out.println(sf);*/
 }
 
 
}
