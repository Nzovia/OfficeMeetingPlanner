package com.nicholas.officemanager.controllers;

import com.nicholas.officemanager.entitities.BoardRooms;
import com.nicholas.officemanager.entitities.Roles;
import com.nicholas.officemanager.entitities.Users;
import com.nicholas.officemanager.repositories.RolesRepository;
import com.nicholas.officemanager.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {
        @Autowired
        private UsersRepository usersRepository;
        @Autowired
        private RolesRepository rolesRepository;

        @GetMapping({"/"})
        public String viewHomePage(){
            return "/index";

        }
        @GetMapping("/start_Activities")
        public String startActivities(){
            return "/adminDash";
        }

        @GetMapping("/login")
        public String loginHere(){
        return "/customizedLogin";
    }

    //add users into the database
        @GetMapping({"/showEmployees","/list_employees","/see_list"})
        public ModelAndView getAllEmployees(){
            ModelAndView mov = new ModelAndView("list_employees");
            mov.addObject("users", usersRepository.findAll());
            return mov;
        }
        //display a list of all users added in the database
        @GetMapping("/addEmployee")
        private ModelAndView addEmployees(){
            ModelAndView modelAndView = new ModelAndView("add_employee");
            List<Roles> rolesList = rolesRepository.findAll();
            modelAndView.addObject("roless",rolesList);
            Users newEmployee = new Users();
            modelAndView.addObject("users",newEmployee);
            return modelAndView;
        }
        @PostMapping("/addEmployee")
        public String addEmployees(@ModelAttribute Users employees){
            //encode user password during registration
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(employees.getEmpPassword());
            employees.setEmpPassword(encodedPassword);
            usersRepository.save(employees);
            return "redirect:/list_employees";
        }
        @GetMapping("/showUpdate")
        public ModelAndView showUpdate(@RequestParam Long employeeId){
            ModelAndView mov = new ModelAndView("add_employee");
            Users employeesU = usersRepository.findById(employeeId).get();
            mov.addObject("users", employeesU);
            return mov;
        }
        @GetMapping("/showDeleteEmployee")
        public String showDeleteEmployee(@RequestParam Long employeeId){
            usersRepository.deleteById(employeeId);
            return "redirect:/list_employees";
        }
    }

