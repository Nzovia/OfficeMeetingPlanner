package com.nicholas.officemanager.repositories;

import com.nicholas.officemanager.entitities.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Events, Long> {


}
