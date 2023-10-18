package com.revature.service;

import com.revature.auth.controller.AuthController;
import com.revature.user.dao.UserDAO;
import com.revature.auth.model.LoginDTO;
import com.revature.user.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getAllUsers(){
        //admin check
        boolean adminChk = (boolean) AuthController.ses.getAttribute("userIsAdmin");

        if (!adminChk) {
            throw new IllegalArgumentException("You do not have permission to access this information");
        }
        return userDAO.findAll();
    }

    public User insertUser(User user){
        return userDAO.save(user); //save the Employee to the DB, and return the saved Employee
    }

    public User findByUserId(int id){
        //self or admin = true
        boolean adminChk = (boolean) AuthController.ses.getAttribute("userIsAdmin");
        int sesId = (int) AuthController.ses.getAttribute("userId");

        if (!adminChk && sesId != id) {
            throw new IllegalArgumentException("You do not have permission to access this information");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("Users with an id of 0 or less surely can't exist!");
        }

        Optional<User> user = userDAO.findById(id);

        if (user.isPresent()) {
            return user.get(); //we can extract the Optional's data with .get()
        } else {
            throw new IllegalArgumentException("User id " + id + " does not exist!");
        }
    }

    public User login(LoginDTO loginDTO) {
        Optional<User> user = userDAO.findByUsername(loginDTO.getUsername());
        User loginUser = user.get();
        System.out.println(loginUser);
        return loginUser;
    }
}