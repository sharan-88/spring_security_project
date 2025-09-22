package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserDetails_model;
import com.example.demo.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailservice_imp implements UserDetailsService {
    @Autowired
    private Userrepository userrepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User u =  userrepository.findByUsername(username);
        if(u == null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found ");
        }
        return new UserDetails_model(u);

    }
}
