package com.edifixio.soc.web.util;

import java.util.Date;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.jboss.custom.service.mail.MailService;

public class ErrorNotifier {
    
    private static final Log log = LogFactory.getLog(ErrorNotifier.class);
    
    
    public void notifyErrorByMail()
    {
        
        MailService service;
        try {
            service = (MailService) new InitialContext().lookup("external/mail/svt");
            service.send("passwordreset@terametric.com", "sgi@edifixio.com", null, "Error in SVT" 
                    , ("Error in svt at " + new Date()).getBytes() , "text/plain", null);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        
    }
    
}
