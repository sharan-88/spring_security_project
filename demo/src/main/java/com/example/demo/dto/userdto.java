package com.example.demo.dto;
import lombok.Data;
@Data

public class userdto {

    private String name;
    private String password;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


// if lombok does not work remove  lombok dependency from xml visit maven repository copy lombok add again in xml
//  add version tage in 2 plugins in xml
//check  external plugins in settings
//  in fiel->settings->annotation processers ->change first line
//