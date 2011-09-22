package com.edifixio.soc.web.controllers.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class GeoLocationServlet
 * NeelamadhabM
 */
public class GeoLocationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try 
        {
            if (request.getParameter("geoLocation") != null) // || request.getParameter("geoLocation").equals(""))
                request.getSession().setAttribute("geoValue",request.getParameter("geoLocation"));
            if(request.getParameter("setGeoLocation") != null) // || request.getParameter("setGeoLocation").equals(""))
                request.getSession().setAttribute("yourLoc",request.getParameter("setGeoLocation"));
        } 
        catch (Exception e) 
        {
            System.out.println("Unable to fetch the GEO-location from browser....");
        }
    }
}
