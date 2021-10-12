package com.nicholas.officemanager.controllers;

import com.nicholas.officemanager.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventsController {
    @Autowired
    public EventsRepository eventsRepo;

    @GetMapping()
    public String createEvents(){

        return null;
    }
}
