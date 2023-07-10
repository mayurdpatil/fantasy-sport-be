package com.ipl.nextg.controller;

import com.ipl.nextg.config.MemoryUsers;
import com.ipl.nextg.dto.User;
import com.ipl.nextg.request.CreateUserRequest;
import com.ipl.nextg.request.ValidateUserRequest;
import com.ipl.nextg.response.ResponseHandler;
import com.ipl.nextg.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value="/createUser")
    public String createUser(@RequestBody CreateUserRequest user)
    {
        return "in to the wild";
    }

    @PostMapping(value="login")
    public ResponseEntity<Object> login(@RequestBody ValidateUserRequest user)
    {
        Optional<User> userData = userService.checkUserCredentials(user);
        if(userData.isPresent()) {
            //Create session Token
            return ResponseHandler.generateResponse("Login successful", HttpStatus.OK, userService.setUserSession(userData));
        }
        else
            return ResponseHandler.generateResponse("Unable to login", HttpStatus.UNAUTHORIZED, user);
    }

    @GetMapping(value="getTokens")
    public ResponseEntity<Object> getTokens()
    {
        return ResponseHandler.generateResponse("Login successful", HttpStatus.OK, MemoryUsers.getSessionToken());
    }

}
