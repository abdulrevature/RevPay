package com.revature.SpringWithLambda.service;

import com.revature.SpringWithLambda.daos.UserDAO;
import com.revature.SpringWithLambda.models.LoginDTO;
import com.revature.SpringWithLambda.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginToUserService {

    private UserDAO userDAO;

    @Autowired
    public LoginToUserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public User login(LoginDTO loginDTO) {
        Optional<User> user = userDAO.findByUsername(loginDTO.getUsername());
        User loginUser = user.get();
        System.out.println(loginUser);
        return loginUser;
    }
}
