//package com.nicholas.officemanager.services;
//
//import com.nicholas.officemanager.entitities.Users;
//import com.nicholas.officemanager.repositories.UsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class CustomUserDetailsService implements UserDetailsService {
//    //pass an object of userRepository
//    @Autowired
//    private UsersRepository usersRepo;
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Users user = usersRepo.findByEmail(email);
//        if(user == null){
//            throw  new UsernameNotFoundException("user not found");
//        }
//        return new CustomUserDetails(user);
//    }
//}
