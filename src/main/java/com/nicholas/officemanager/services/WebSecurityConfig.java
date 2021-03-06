package com.nicholas.officemanager.services;

import com.nicholas.officemanager.CustomFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
    public  void configure(WebSecurity webSecurity){
        webSecurity.ignoring().antMatchers("/css/**","/js/**","/images/**");
    }
    @Autowired
    private CustomFailureHandler customFailureHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http); here we configure the login and the logout for the application
        http.authorizeRequests()

                .antMatchers("/index.html").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/start_Activities").authenticated()//means you have to be authenticated to view this page
                .antMatchers("/see_list").hasRole("Admin")
                .antMatchers("/start_Activities/see_events").hasAnyRole("User","Co-Admin", "Admin")
//                .anyRequest().authenticated()
                .and()
                .formLogin()
//                        form->form
//                                .defaultSuccessUrl("/start_Activities")
//                                .loginPage("/login")
//                                .failureHandler(customFailureHandler)
//                                .failureUrl("/login?error=true")
//                );
                .permitAll()
                .loginPage("/login")// using the default login page provided by spring security
                //implement a custom failureHandler here
                .failureHandler(customFailureHandler)
                .usernameParameter("email")
                //for the logout
                .and()
                .logout().logoutSuccessUrl("/login").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");

    }


}
