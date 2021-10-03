package com.nicholas.officemanager.repositories;

import com.nicholas.officemanager.entitities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Users,Long> {
}
