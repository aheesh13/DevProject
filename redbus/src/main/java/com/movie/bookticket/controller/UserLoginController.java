package com.movie.bookticket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bookticket.service.impl.UserService;
import com.movie.bookticket.useradminmodel.User;

@RestController
@RequestMapping("/api/user")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        // Implement user login logic here
        // You can validate the user's credentials and generate a token (e.g., JWT) upon successful login

        // For simplicity, let's assume a successful login and return a success message
        return ResponseEntity.ok("User logged in successfully");
    }

    // Other login-related endpoints if needed
}

