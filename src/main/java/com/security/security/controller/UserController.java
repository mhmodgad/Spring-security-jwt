package com.security.security.controller;

import com.security.security.domain.User;
import com.security.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/secured")
//@EnableMethodSecurity
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Collection<User>> getAllUsers(){
        return  ResponseEntity.ok().body(userService.getAllUsers());
    }
}
