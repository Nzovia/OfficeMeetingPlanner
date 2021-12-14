package com.nicholas.officemanager.controllers;

import com.nicholas.officemanager.services.UserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ResetPassword {
    @Autowired
    private UserService userService;

    @GetMapping("/resetPassword")
    public ModelAndView resetPassword(){
        ModelAndView modelView = new ModelAndView("passwordReset");
         return modelView;
    }
    //add handler o handle the submission of the form
    @PostMapping("/resetPassword")
    public String processForgotPasswordForm(HttpServletRequest request){
        //HTTpServletRequest helps us get the values of the parameter
        String email = request.getParameter("email");
        //Note: To generate the random string for the token we will use the Random Class in java bytebuddy.utility
        String token = RandomString.make(45);
        //for testing we can just generate random string token
        System.out.println("Email: "+ email);
        System.out.println("Token: "+ token);


        return "passwordReset";
    }
}
