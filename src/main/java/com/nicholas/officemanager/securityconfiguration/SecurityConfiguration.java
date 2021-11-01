package com.nicholas.officemanager.securityconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    //webSecurity gives an opportunity to get hold for authenticationBuilder
    @Autowired
    UserDetailsService userDetailsService;
    @Override//for authentication
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.userDetailsService(userDetailsService);
        //this lets configure the authentication method that you want

    }
    //for user authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                .antMatchers("/adminDashboard").hasRole("male")
                .antMatchers("/userDashboard").hasAnyRole("male","female")
                .antMatchers("/index").permitAll()
                .and().formLogin();


    }
}
