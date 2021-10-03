package com.nicholas.officemanager.controllers;

import com.nicholas.officemanager.entitities.Users;
import com.nicholas.officemanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;
    @GetMapping("/")
    public  String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){//to send a new user object
        model.addAttribute("user", new Users());
        return "signup_form";
    }
    @PostMapping("/registration") // registration is the action in the form
    public String processRegistration(Users user){
        //add the encryption Criteria to ensure that the password added is encrypted
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);
        return "register_success";
    }
    @GetMapping("/users")
    public  String listUsers(Model model){
        //implement a method to list all the users
        List<Users> listAllUsers = userRepo.findAll();
        model.addAttribute("list", listAllUsers);

        return "users_list";
    }
    @GetMapping("/login")
    public String userLogin(){
        return "login";
    }
}
