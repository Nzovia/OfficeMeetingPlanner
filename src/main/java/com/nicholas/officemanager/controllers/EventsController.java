package com.nicholas.officemanager.controllers;

import com.nicholas.officemanager.entitities.BoardRooms;
import com.nicholas.officemanager.entitities.Events;
import com.nicholas.officemanager.repositories.BoardRoomsRepository;
import com.nicholas.officemanager.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EventsController {
    @Autowired
    public EventsRepository eventsRepo;
    @Autowired
    public BoardRoomsRepository roomsRepository;

    @GetMapping({"/addEvent","/see_events"})
    public ModelAndView createEvents(){
        ModelAndView modelAndView = new ModelAndView("createEvent");
        List<BoardRooms> roomsList = roomsRepository.findAll();
        modelAndView.addObject("boardRoom",roomsList);
        Events ourEvents = new Events();
        modelAndView.addObject("meeting_events", ourEvents);

        return modelAndView;
    }
    @PostMapping("/addEvent")
    public String createEvents(@ModelAttribute Events  meeting_event){
//        if(meeting_event.end_time <= meeting_event.start_time){

            eventsRepo.save(meeting_event);
            return "redirect:/eventsOperations";
//        }else {
//            //make a toast and return to creation page
//            return "createEvent";
//        }


    }
    @GetMapping({ "/eventsOperations"})
    public ModelAndView getAllEmployees(){
        ModelAndView mov = new ModelAndView("eventsOperations");
        mov.addObject("meeting_events", eventsRepo.findAll());
        return mov;
    }
    @GetMapping("/update")
    public ModelAndView showUpdate(@RequestParam Long eventsId){
        ModelAndView mov = new ModelAndView("createEvent");
        Events ourEvents = eventsRepo.findById(eventsId).get();
        List<BoardRooms> roomsList = roomsRepository.findAll();
        mov.addObject("meeting_events", ourEvents);
        return mov;
    }
    @GetMapping("/deleteEmployee")
    public String showDeleteEmployee(@RequestParam Long eventsId){
        eventsRepo.deleteById(eventsId);
        return "redirect:/eventsOperations";
    }
}
