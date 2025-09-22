package com.example.demo.controller;

import com.example.demo.dto.userdto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;



    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/Register")
    public ResponseEntity<?> register(@RequestBody userdto user) {
        User savedUser ;
        try {
            savedUser = userService.registeruserdata(user);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("user not registered successfully", HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> loginuser(@RequestBody userdto user){
//        return userService.loginuser(user);
//    }

    @PostMapping("/login")
    public String loginuser(@RequestBody userdto user){
        return userService.loginuser(user);
   }
}


