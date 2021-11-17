package com.nicholas.officemanager.controllers;

import com.nicholas.officemanager.entitities.Organization;
import com.nicholas.officemanager.entitities.Users;
import com.nicholas.officemanager.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrganizationController {
    @Autowired
    private OrganizationRepository organizationRepo;

    @GetMapping("/newOrganization")
    public String startActivities(){
        return "addOrganization";
    }

    @GetMapping("/createOrganization")
    public ModelAndView addOrg(){
        ModelAndView modell = new ModelAndView("addOrganization");
        Organization newOrganization = new Organization();
        modell.addObject("organization",newOrganization);
        return modell;
    }

}
