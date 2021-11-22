package com.nicholas.officemanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired //note the datasource is for javax.sql
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return  authProvider;
    }
    //there to configure spring security for authentication we need to configure(override) some methods
    //i.e configure(HttpSecurity) and configure(AuthenticationManagerBuilder()
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//      super.configure(auth); configure the authentication provider
        auth.authenticationProvider(daoAuthenticationProvider());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http); here we configure the login and the logout for the application
        http.authorizeRequests()
                .antMatchers("/start_Activities").authenticated()//means you have to be authenticated to view this page
                .anyRequest().permitAll()
                .and()
                .formLogin()// using the default login page provided by spring security
                .usernameParameter("email")
                .defaultSuccessUrl("/start_Activities")
                .permitAll()
                //for the logout
                .and()
                .logout().logoutSuccessUrl("/index").permitAll();
    }

}
