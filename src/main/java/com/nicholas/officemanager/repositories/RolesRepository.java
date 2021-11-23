package com.nicholas.officemanager.repositories;

import com.nicholas.officemanager.entitities.Roles;
import com.nicholas.officemanager.entitities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    @Query("SELECT r FROM Roles r WHERE r.role_id = ?1")
    Users findRolesBy(String title);
}
