package com.nicholas.officemanager.securityconfiguration;

import com.nicholas.officemanager.entitities.Users;
import com.nicholas.officemanager.entitities.MyUserDetails;
import com.nicholas.officemanager.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserService implements UserDetailsService {
    //get an instance of the usersRepository
    @Autowired
    private UsersRepository usersRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       Users users = usersRepository.getUsersByEmployee_email(email);
       if (users == null){
           throw new UsernameNotFoundException("could not find user");
       }
       return  new MyUserDetails(users);
    }
}