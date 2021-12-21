package com.nicholas.officemanager.repositories;

import com.nicholas.officemanager.entitities.Users;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE u.employee_email = ?1")
    public Users getUsersByEmployee_email(@Param("employee_email")String employee_email);
     @Query("SELECT u FROM Users u WHERE u.employee_email = ?1")
     Users findByEmail(String email);

//     @Modifying
//     public void enable(Integer id);
//     @Query("select  u FROM Users u where u.verificationCode = ?1")
//     public Users findByVerificationCode (String code);

     @Query("UPDATE Users  u SET u.failedAttempt = ?1 WHERE  u.employee_email = ?2")
     @Modifying
     public void updateFailedAttempt(int failedAttempt, String email);

     Users findByResetPasswordToken(String token);
}



