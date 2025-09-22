package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private Studentrepository repo;
    public List<Student> getallstudents() {
        return repo.findAll();
    }

    public Student putstudents(Student std) {
        return repo.save(std);
    }
}
