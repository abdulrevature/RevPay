package com.revature;

import com.revature.models.User;
import com.revature.utils.JwtTokenUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersistentData {
    public static void main(String[] args) {
        SpringApplication.run(PersistentData.class, args);

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        User user = new User();
        user.setUserId(1);
        user.setUsername("Bob");
        System.out.println(jwtTokenUtil.generateAccessToken(user));

    }

}