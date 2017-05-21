package com.example.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String greeting(){
        return "index";
    }
    @RequestMapping("/books")
    public String showBooksPage(){
        return "books";
    }
    @RequestMapping("/users")
    public String showUsersPage(){
        return "users";
    }


}
