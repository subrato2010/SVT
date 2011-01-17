package com.edifixio.soc.web.servlets;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.edifixio.jboss.custom.service.mail.MailAttachmentBean;
import com.edifixio.jboss.custom.service.mail.MailService;
import com.edifixio.soc.biz.UserProfileMgrImpl;
import com.edifixio.soc.biz.dto.UserProfileDTO;
import com.edifixio.soc.biz.dto.UserProfileDetailDTO;
import com.edifixio.soc.web.util.PropertyReader;


/**
 * Servlet implementation class MailSenderServlet
 */
public class MailSenderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static final String TO_MAIL_ID = "mailId";
    private static final String FROM_MAIL_ID = "from";
    private static final String SUBJECT = "subject";
    private static final String MIME = "contentType";
    private static final String MAIL_TEMPLATE = "/templates/mail/mail.html";
    private static final String PROPERTY_PATH = "com/edifixio/soc/web/servlets/mail";
    private static final String ATTACHMANTS_PATH = "/images/mail";
    
    private static final String USERNAME = "\\$\\$username\\$\\$";
    private static final String PASSWORD = "\\$\\$password\\$\\$";
    
    
    private static final Log log = LogFactory.getLog(MailSenderServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailSenderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String strMailId = request.getParameter(TO_MAIL_ID);
        String userName = null;
        String password = null;
        if (strMailId != null) {
            try {
                UserProfileDetailDTO userProfile = new UserProfileMgrImpl()
                        .getProfileByUserMailId(strMailId);
                if (userProfile != null) 
                {
                    userName = userProfile.getUid();
                    password = userProfile.getPassword();
                    
                    MailService service = (MailService) new InitialContext()
                            .lookup("external/mail/svt");
                    java.util.Vector<String> vTo = new java.util.Vector<String>();
                    // To
                    vTo.add(strMailId);
                    PropertyReader reader = new PropertyReader(PROPERTY_PATH);
                    // From
                    String from = reader.getProperty(FROM_MAIL_ID);
                    // subject
                    String subject = reader.getProperty(SUBJECT);
                    // body
                    BufferedInputStream bis = new BufferedInputStream(
                            getServletContext().getResourceAsStream(
                                    MAIL_TEMPLATE));
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    int i = 0;
                    while ((i = bis.read()) != -1) {
                        bos.write(i);
                    }
                    bis.close();
                    
                    String bodyContent = new String( bos.toByteArray(),"ISO-8859-1");
                    bodyContent = bodyContent.replaceAll(USERNAME, userName);
                    bodyContent = bodyContent.replaceAll(PASSWORD, password);
                    
                    
                    // contentType
                    String contentType = reader.getProperty(MIME);
                    // attachmants
                    Vector<MailAttachmentBean> vAttachments = null;
                    File attachmantDir = new File(getServletContext()
                            .getRealPath(ATTACHMANTS_PATH));
                    if (attachmantDir.listFiles() != null) {
                        vAttachments = new Vector<MailAttachmentBean>();
                        for (int j = 0; j < attachmantDir.listFiles().length; j++) {
                            File file = attachmantDir.listFiles()[j];
                            MailAttachmentBean bean = new MailAttachmentBean();
                            bean.setName(file.getName());
                            bean.setInputStream(new FileInputStream(file));
                            bean.setMimeType("image/gif");
                            vAttachments.add(bean);
                        }
                    }
                    
                    // send
                    service.send(from, vTo, null, subject, bodyContent.getBytes("ISO-8859-1"),
                            contentType, vAttachments);
                    
                }else{
                    log.info("user not found with given email-id : " + strMailId);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            // redirect
            response.sendRedirect("index.jsp");
            
        }
    }
}
