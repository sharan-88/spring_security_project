package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<User, Integer> {



    User findByUsername(String username);
}


//It’s a specification (not a framework) in Java for managing relational data (like data in SQL databases).
//It defines how Java objects (classes) can be mapped to database tables, and how you can query,
// insert, update, and delete data using Java code instead of raw SQL.

//PA = Specification (just a set of rules, like an interface).
//
//Hibernate = Implementation of JPA (the most popular one).
//
//Other JPA implementations: EclipseLink, OpenJPA.