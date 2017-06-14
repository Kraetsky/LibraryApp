package com.example.demo.controllers;


import com.example.demo.domain.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @RequestMapping("/")
    public String greeting(){
        return "index";
    }
//    @RequestMapping("/books")
//    public String showBooksPage(){
//        return "books";
//    }
//    @RequestMapping("/users")
//    public String showUsersPage(){
//        return "users";
//    }

}
