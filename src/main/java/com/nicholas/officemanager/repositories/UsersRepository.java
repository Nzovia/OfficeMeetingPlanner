package com.nicholas.officemanager.repositories;

import com.nicholas.officemanager.entitities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
//    @Query("SELECT u FROM Users u WHERE u.employee_email = ?1")
////    public Users getUsersByEmployee_email(@Param("employee_email")String employee_email);
//    Users findByEmail(String email);
     @Query("SELECT u FROM Users u WHERE u.employee_email = ?1")
     Users findByEmail(String email);
}


