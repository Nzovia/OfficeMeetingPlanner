package com.nicholas.officemanager.repositories;

import com.nicholas.officemanager.entitities.Employees;
import com.nicholas.officemanager.entitities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {
    @Query("SELECT u FROM Users u WHERE u.employeeEmail = ?1")
    Users findByEmail(String email);
}
