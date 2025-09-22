package com.example.demo.service;

import com.example.demo.dto.userdto;
import com.example.demo.model.User;
import com.example.demo.repository.Userrepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private final Userrepository userrepository;
    private  final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserService(Userrepository userrepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager) {
        this.userrepository = userrepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
    }




    public User registeruserdata(userdto userdata) {
        User u = new User();
        // u.setId(userdata.getId());  <-- remove this line
        u.setUsername(userdata.getName());
//        u.setPassword(userdata.getPassword());
//        encrypt the password
        u.setPassword(bCryptPasswordEncoder.encode(userdata.getPassword()));

        System.out.println("this is value"+u.getUsername()+u.getPassword());
//      example =u.username =  manu, u.password  = $2a$12$Vhmh04zjOxWdUVVx5EJgMeqZiQQ/RI.KqvrkcEHY525nc4/WJQ1E
        return userrepository.save(u);
    }


    public String loginuser(userdto user) {
        Authentication aoth =authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));
// here authentication has method authenticate which takes object of method authentication and return authentication
//        since authentication is interface we look for class that implements authentication that is userpasswordauthenticationtoken
//        User founduser = userrepository.findByUsername(user.getName());
        if(aoth.isAuthenticated()){
             System.out.println(aoth.toString());
             System.out.println(aoth.getName());
            return "098765sdfghjhgfdfdyuio";}
        return "no possible to login, register first";
    }
}
