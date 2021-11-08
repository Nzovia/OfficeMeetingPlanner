package com.nicholas.officemanager.controllers;

import com.nicholas.officemanager.entitities.Events;
import com.nicholas.officemanager.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventsController {
    @Autowired
    public EventsRepository eventsRepo;

    @GetMapping({"/addEvent","/see_events"})
    public ModelAndView createEvents(){
        ModelAndView modelAndView = new ModelAndView("createEvent");
        Events ourEvents = new Events();
        modelAndView.addObject("meeting_event", ourEvents);

        return modelAndView;
    }
    @PostMapping("/addEvent")
    public String createEvents(@ModelAttribute Events  meeting_event){
        eventsRepo.save(meeting_event);
        return "redirect:/createEvent";

    }
    @GetMapping({ "/eventsOperations"})
    public ModelAndView getAllEmployees(){
        ModelAndView mov = new ModelAndView("eventsOperations");
        mov.addObject("meeting_event", eventsRepo.findAll());
        return mov;
    }
    @GetMapping("/update")
    public ModelAndView showUpdate(@RequestParam Long employeeId){
        ModelAndView mov = new ModelAndView("createEvent");
        Events ourEvents = eventsRepo.findById(employeeId).get();
        mov.addObject("meeting_event", ourEvents);
        return mov;
    }
    @GetMapping("/deleteEmployee")
    public String showDeleteEmployee(@RequestParam Long eventsId){
        eventsRepo.deleteById(eventsId);
        return "redirect:/eventsOperations";
    }
}
