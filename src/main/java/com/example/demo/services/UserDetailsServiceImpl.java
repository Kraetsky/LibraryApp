package com.example.demo.services;

import com.example.demo.domain.User;
import com.example.demo.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by kraet on 20.05.2017.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User u = userService.getUserByUserName(name);
        return new CurrentUser(u.getPassword(),u.getName(),u.getId());
    }

}