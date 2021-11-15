package com.nicholas.officemanager.controllers;

import com.nicholas.officemanager.entitities.BoardRooms;
import com.nicholas.officemanager.entitities.Events;
import com.nicholas.officemanager.entitities.Users;
import com.nicholas.officemanager.repositories.BoardRoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardRoomsController {
    @Autowired
    private BoardRoomsRepository boardRoomsRepo;

    @GetMapping("/addRoom")
    public ModelAndView createEvents(){
        ModelAndView modelAndView = new ModelAndView("add_rooms");
        BoardRooms myRooms = new BoardRooms();
        modelAndView.addObject("my_rooms", myRooms);
        return modelAndView;
    }
    @PostMapping("/addRoom")
    public String createEvents(@ModelAttribute BoardRooms  rooms){
            boardRoomsRepo.save(rooms);
            return "add_rooms..";



    }
    @GetMapping("/addRooms")
    public ModelAndView getAllRooms(){
        ModelAndView mov = new ModelAndView("add_rooms");
        mov.addObject("myRooms", boardRoomsRepo.findAll());
        return mov;
    }
    @GetMapping("/roomUpdate")
    public ModelAndView showUpdate(@RequestParam Long employeeId){
        ModelAndView mov = new ModelAndView("add_rooms");
        BoardRooms rooms = boardRoomsRepo.findById(employeeId).get();
        mov.addObject("my_rooms", rooms);
        return mov;
    }
    @GetMapping("/roomDelete")
    public String showDeleteEmployee(@RequestParam Long employeeId){
        boardRoomsRepo.deleteById(employeeId);
        return "redirect: /";
    }

}
