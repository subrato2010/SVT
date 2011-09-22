package com.edifixio.soc.web.controllers.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edifixio.soc.web.controllers.BaseWebObject;
import com.edifixio.soc.web.servlets.BaseServletObject;

/**
 * Servlet implementation class BitlySigninServlet
 */
public class BitlySigninServlet extends BaseServletObject
{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
    {
	    
	    String bitlyAuthPoint = (String) request.getSession().getAttribute(BaseWebObject.BITLY_AUTH_URL);
	    String bitlyClientId = (String) request.getSession().getAttribute(BaseWebObject.BITLY_CLIENT_ID);
	    String redirectURI = (String) request.getSession().getAttribute(BaseWebObject.BITLY_CALLBACK_URL);
	    
	    bitlyAuthPoint = bitlyAuthPoint + "?client_id=" + bitlyClientId + "&redirect_uri=" + redirectURI;
	    System.out.println("*************** BitlySigninServlet :: "+bitlyAuthPoint);
        response.sendRedirect(bitlyAuthPoint);  
	    
    }

}
