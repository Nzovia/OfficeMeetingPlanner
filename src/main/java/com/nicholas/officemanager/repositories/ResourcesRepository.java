package com.nicholas.officemanager.repositories;

import com.nicholas.officemanager.entitities.Resources;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourcesRepository extends JpaRepository<Resources, Long> {
}
