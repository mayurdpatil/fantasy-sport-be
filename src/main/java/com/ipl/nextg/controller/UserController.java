package com.ipl.nextg.controller;

import com.ipl.nextg.request.CreateUserRequest;
import com.ipl.nextg.request.ValidateUserRequest;
import com.ipl.nextg.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @PostMapping(value="/createUsers")
    public String createUser(@RequestBody CreateUserRequest user)
    {
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        System.out.println(user.toString());
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        return "in to the wild";
    }


    @PostMapping(value="login")
    public ResponseEntity<Object> login(@RequestBody ValidateUserRequest user)
    {
        return ResponseHandler.generateResponse("Login successful", HttpStatus.OK, null);
    }

}
