package com.example.demo.controllers;

import com.example.demo.domain.User;
import com.example.demo.security.CurrentUser;
import com.example.demo.services.UserService;
import com.example.demo.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Currency;
import java.util.List;

/**
 * Created by kraet on 16.05.2017.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping("/users/add")
    public User add(@RequestBody User user) throws IOException {
        return userService.add(user);
    }
    @PostMapping("/users/delete")
    public void delete(@RequestBody User user) throws IOException{
        userService.delete(user);

    }
    @PostMapping("/users/update")
    public User update(@RequestBody User user) throws IOException {
        user.setId(SecurityUtils.getCurrentUser().getId());
        return userService.update(user);
    }
    @GetMapping("/users/showAll")
    public List<User> showAll()throws IOException{
        return userService.list();
    }
}

