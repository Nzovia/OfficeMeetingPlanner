package com.nicholas.officemanager.services;

import com.nicholas.officemanager.CustomUserDetails;
import com.nicholas.officemanager.entitities.Users;
import com.nicholas.officemanager.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    //create an instance of userRepository
    @Autowired
    private UsersRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //inside here declare a method to find user by email that returns a single user object since the email is unique
        //to achieve that you to create a query in the repo o select users by email
        Users user = userRepo.findByEmail(email);

        if (user == null){
            throw new UsernameNotFoundException("email not valid");
        }
        //if user email is valid then....the following is returned (new CustomUserDetails overlapping user object)
        return new CustomUserDetails(user);
    }
    }

