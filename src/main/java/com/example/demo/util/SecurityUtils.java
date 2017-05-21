package com.example.demo.util;

import com.example.demo.security.CurrentUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by kraet on 20.05.2017.
 */
public class SecurityUtils {
    public static CurrentUser getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ((CurrentUser) principal);

    }
}
