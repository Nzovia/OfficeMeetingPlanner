package com.nicholas.officemanager.repositories;

import com.nicholas.officemanager.entitities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    //we will perform all the operations inside the meting controller
}
