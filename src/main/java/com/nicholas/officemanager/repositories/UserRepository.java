package com.nicholas.officemanager.repositories;

import com.nicholas.officemanager.entitities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository  extends JpaRepository<Users,Long> {
    //this is the interface for the data access layer
    //User is the domain class, and Long is type of the ID of the domain class
    @Query("SELECT u FROM Users u WHERE u.employeeEmail = ?1")
    Users findByEmail(String email);
}
