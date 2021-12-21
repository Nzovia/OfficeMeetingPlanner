package com.nicholas.officemanager.controllers;

import com.nicholas.officemanager.entitities.Utility;
import com.nicholas.officemanager.services.UserService;
import com.nicholas.officemanager.services.UsersNotFoundException;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class ResetPassword {
    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/resetPassword")
    public ModelAndView resetPassword(){
        ModelAndView modelView = new ModelAndView("passwordReset");
         return modelView;
    }
    //add handler o handle the submission of the form
    @PostMapping("/forgot_password")
    public String processForgotPasswordForm(HttpServletRequest request, Model model){
        //HTTpServletRequest helps us get the values of the parameter
        String email = request.getParameter("email");
        //Note: To generate the random string for the token we will use the Random Class in java bytebuddy.utility
        String token = RandomString.make(45);
        //for testing we can just generate random string token
        System.out.println("Email: "+ email);
        System.out.println("Token: "+ token);
        try{
            userService.resetUserPassword(token,email);
            //

            //generate reset password link
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token =" + token; // remember we have utility class that will return absolute url to the application
            //System.out.println(resetPasswordLink);
            model.addAttribute("message", "We have send reset password link please check your email");


            //send email to the user
            try {
                sendEmail(email, resetPasswordLink);
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }catch (UsersNotFoundException exception){
            model.addAttribute("error", exception.getMessage());

        }

        return "passwordReset";
    }
    //composing the password to be sent to the user
    private void sendEmail(String email, String resetLink) throws MessagingException, UnsupportedEncodingException {
        //here create a mimeMessage
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("eworkske@gmail.com", "Office Meeting Planner");
        helper.setTo(email);
        String subject = "Here is the link for you to reset password";
        String content = "<p>Hello, </p>"
                +"<p> We noticed that you requested to reset your password.</p>"
                +"<p> Click the link below to proceed: </p>"
                + "<p><b><a href=\"" + resetLink + "\">Change my password</a><b></p>"
                +"<p>Ignore if you did not make the request</p>";

        helper.setSubject(subject);
        helper.setText(content,true);

        mailSender.send(message);
    }
}
