package com.nicholas.officemanager.controllers;

import com.nicholas.officemanager.entitities.BoardRooms;
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
//        modelAndView.addObject("createdRooms", boardRoomsRepo.findAll());
        modelAndView.addObject("my_rooms", myRooms);
        return modelAndView;
    }
    @PostMapping("/addRoom")
    public String createEvents(@ModelAttribute BoardRooms  rooms){
            boardRoomsRepo.save(rooms);
            return "add_rooms";

    }
    @GetMapping("/addRooms")
    public ModelAndView getAllRooms(){
        ModelAndView mov = new ModelAndView("add_rooms");
        mov.addObject("addingRooms", boardRoomsRepo.findAll());
        return mov;
    }
    @GetMapping("/roomUpdate")
    public ModelAndView showUpdate(@RequestParam Long boardroom_id){
        ModelAndView mov = new ModelAndView("add_rooms");
        BoardRooms rooms = boardRoomsRepo.findById(boardroom_id).get();
        mov.addObject("addingRooms", rooms);
        return mov;
    }
    @GetMapping("/roomDelete")
    public String showDeleteEmployee(@RequestParam (value = "params") Long boardroom_id){
        boardRoomsRepo.deleteById(boardroom_id);
        return "add_rooms";
    }

}
