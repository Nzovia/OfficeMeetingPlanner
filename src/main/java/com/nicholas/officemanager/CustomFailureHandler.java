package com.nicholas.officemanager;

import com.nicholas.officemanager.entitities.Users;
import com.nicholas.officemanager.repositories.UsersRepository;
import com.nicholas.officemanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    //since login attempts are implemented in the UserService Class So we inject spring it here
    @Autowired
    private UserService userService;
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        //configure the authentication failure handler in spring security
        //upon failed login we need to call this method
        String email = request.getParameter("email");
        Users users = usersRepository.findByEmail(email);
        if (users != null){
            if (users.isEnabled() && users.isAccountNonLocked()){
                if (users.getFailedAttempt()< 3 - 1){

                }
            }
            System.out.println("user failed to login: " + email);
        }else{
            System.out.println("Email does not exist");
        }
        super.setDefaultFailureUrl("/login?error");
        super.onAuthenticationFailure(request, response, exception);
    }
}
