package com.nicholas.officemanager.controllers;

import com.nicholas.officemanager.entitities.Events;
import com.nicholas.officemanager.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventsController {
    @Autowired
    public EventsRepository eventsRepo;

    @GetMapping({"/addEvent","/see_events"})
    public ModelAndView createEvents(){
        ModelAndView modelAndView = new ModelAndView("CreateEvent");
        Events ourEvents = new Events();
        modelAndView.addObject("meeting_events", ourEvents);

        return modelAndView;
    }
    @PostMapping("/addEvent")
    public String createEvents(@ModelAttribute EventsRepository eventsRepo){
        //eventsRepo.save(meeting_events);
        return "redirect:/list_employees";

    }
}
