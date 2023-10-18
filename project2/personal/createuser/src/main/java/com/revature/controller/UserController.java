package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin()
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAccounts() {
        List<User> returnedUser;
        try{
            returnedUser = userService.getAllUsers();
            return ResponseEntity.ok().body(returnedUser);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("id/{userId}")
    public ResponseEntity<Object> getUserByUserId(@PathVariable("userId") int userId) {
        try {
            return ResponseEntity.accepted().body(userService.findByUserId(userId));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}