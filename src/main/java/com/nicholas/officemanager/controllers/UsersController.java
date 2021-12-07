package com.nicholas.officemanager.controllers;

import com.nicholas.officemanager.entitities.BoardRooms;
import com.nicholas.officemanager.entitities.Roles;
import com.nicholas.officemanager.entitities.Users;
import com.nicholas.officemanager.entitities.Utility;
import com.nicholas.officemanager.repositories.RolesRepository;
import com.nicholas.officemanager.repositories.UsersRepository;
import com.nicholas.officemanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {
        @Autowired
        private UsersRepository usersRepository;
        @Autowired
        private RolesRepository rolesRepository;
        @Autowired
        private UserService userService;
       @Autowired
       private JavaMailSender mailSender;

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
        public String addEmployees(Model model, Users users, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(users.getEmpPassword());
            users.setEmpPassword(encodedPassword);

            userService.register(users);

            String siteURL = Utility.getSiteURL(request);
            //error
            userService.sendVerificationEmail(users,siteURL);

            model.addAttribute("pageTitle", "user Registered Successfully");
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
    //???inside the @postmapping
//encode user password during registration---- trying to encode the code from the service class


