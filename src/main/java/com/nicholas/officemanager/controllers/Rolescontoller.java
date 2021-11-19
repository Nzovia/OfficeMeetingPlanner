package com.nicholas.officemanager.controllers;

import com.nicholas.officemanager.entitities.Organization;
import com.nicholas.officemanager.entitities.Roles;
import com.nicholas.officemanager.repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Rolescontoller {
    @Autowired
    private RolesRepository rolesRepo;


    @GetMapping("/createRoles")
    public ModelAndView createRole(){
        ModelAndView mode = new ModelAndView("roles");
        Roles userRoles = new Roles();
        mode.addObject("roles",userRoles);
        return mode;
    }
    @PostMapping("/addRole")
    public String addRole(@ModelAttribute Roles roles){
        rolesRepo.save(roles);
        return "successRequests";

    }
}
