package com.revature.SpringWithLambda.service;

import com.revature.SpringWithLambda.daos.UserDAO;
import com.revature.SpringWithLambda.models.AuthResponseDTO;
import com.revature.SpringWithLambda.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.revature.SpringWithLambda.utils.JwtTokenUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class AddAUserService {

    //autowire a JwtTokenUtil and AuthenticationManager
    private AuthenticationManager authManager;
    private JwtTokenUtil jwtUtil;
    private PasswordEncoder passwordEncoder;

    private UserDAO userDAO;

    @Autowired
    public AddAUserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public ResponseEntity<Object> insertUser(User user){
        try{
            //encode the incoming password
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponseDTO aDTO = new AuthResponseDTO(user.getUsername(), accessToken);
            //return a 202 (ACCEPTED) status code, as well as the new user in the response body
            userDAO.save(user);
            return ResponseEntity.ok().body(aDTO);
            //accepted() is a shorthand of .status(202). They do the same thing

        } catch(IllegalArgumentException e){
            e.printStackTrace();

            //return a 400 status code (BAD REQUEST) and error message
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
