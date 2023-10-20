package com.revature.SpringWithLambda.service;

import com.revature.SpringWithLambda.daos.UserDAO;
import com.revature.SpringWithLambda.models.LoginDTO;
import com.revature.SpringWithLambda.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.SpringWithLambda.models.AuthResponseDTO;
import com.revature.SpringWithLambda.utils.JwtTokenUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class LoginToUserService {

    private UserDAO userDAO;
    private AuthenticationManager authManager;
    private JwtTokenUtil jwtUtil;
    private PasswordEncoder passwordEncoder;


    static public HttpSession ses;

    @Autowired
    public LoginToUserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public ResponseEntity<Object> login(LoginDTO loginDTO, HttpServletRequest request) {
        try{

            //attempt to log in (notice no direct calls of the DAO)
            //this is where the username and password go to get validated
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
            );

            //build up the user based on the validation
            User authUser = (User) authentication.getPrincipal();

            //if the user is valid, generate our JWT!
            String accessToken = jwtUtil.generateAccessToken(authUser);

            //generate our AuthResponseDTO and send it back with a 200 status code
            AuthResponseDTO aDTO = new AuthResponseDTO(authUser.getUsername(), accessToken);

            //TODO: Start HTTP session with session attributes

            ses = request.getSession();
            System.out.println("session " + ses);
            ses.setAttribute("userId", authUser.getUserId());
            ses.setAttribute("username", authUser.getUsername());

            return ResponseEntity.ok().body(aDTO);

        } catch (BadCredentialsException e){
            //if login fails, return a 401 (UNAUTHORIZED) and the exception message
            System.out.println("BAD CREDENTIALS!!");
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
