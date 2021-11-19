//package com.nicholas.officemanager.services;
//
//import com.nicholas.officemanager.entitities.Roles;
//import com.nicholas.officemanager.entitities.Users;
//import com.nicholas.officemanager.repositories.RolesRepository;
//import com.nicholas.officemanager.repositories.UsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    @Autowired
//    private UsersRepository userRepo;
//
//    @Autowired
//    RolesRepository roleRepo;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    public void registerDefaultUser(Users user) {
//        Roles roleUser = roleRepo.findByName("User");
//        user.addRole(roleUser);
//
//        userRepo.save(user);
//    }
//}

