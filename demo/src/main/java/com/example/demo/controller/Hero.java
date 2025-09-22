package com.example.demo.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hero {
    @GetMapping("/")
    public String great(HttpServletRequest req){
        return "hello we again to learn security in spring"+req.getSession().getId();
    }
    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        if(token == null) {
            throw new IllegalStateException("CSRF token not available");
        }
        return token;
    }

}


//  To see a class definition → put cursor on it and press Ctrl + B
// To see class implementing interface → put cursor on it and press Ctrl + Alt + B