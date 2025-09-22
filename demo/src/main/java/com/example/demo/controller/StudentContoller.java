package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentContoller {
    @Autowired
    private StudentService service;

    @GetMapping("/std_home")
    public String homestudent(){
        return "student";
    }

    @GetMapping("/students")
    public List<Student> getallstudent(){
        return service.getallstudents();

    }



    @PostMapping("/students")
    public Student putstudent(@RequestBody Student std){
        return service.putstudents(std);

    }



//     put and update method must include CIRF TOKKEN
}
