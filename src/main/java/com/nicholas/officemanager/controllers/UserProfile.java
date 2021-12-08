//package com.nicholas.officemanager.controllers;
//
//import com.nicholas.officemanager.entitities.Users;
//import com.nicholas.officemanager.repositories.RolesRepository;
//import com.nicholas.officemanager.repositories.UsersRepository;
//import com.nicholas.officemanager.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.security.Principal;
//
//@Controller
//public class UserProfile {
//    @Autowired
//    private UsersRepository usersRepository;
//    @Autowired
//    private RolesRepository rolesRepository;
//
//    @GetMapping({"/myProfile"})
//    public  String showProfile(Model model, Principal principal){
//        String email = principal.getName();
//        Users user=usersRepository.findByEmail(email);
//        model.addAttribute("users", user);
//        return "userProfile";
//    }
//}
