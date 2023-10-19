package com.revature;


import com.revature.sharedLibraries.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreateUserMS {


    UserService userService;
    @Autowired
    public CreateUserMS(UserService userService){
        this.userService = userService;
    }



}
