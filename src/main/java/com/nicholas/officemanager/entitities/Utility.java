package com.nicholas.officemanager.entitities;

import javax.servlet.http.HttpServletRequest;

//Note: we have the method in the controller class that calls this class
public class Utility {
    public String getSiteURL(HttpServletRequest request){
        String siteURL = request.getRequestURI();
        return siteURL.replace(request.getServletPath()," ");
    }
}

