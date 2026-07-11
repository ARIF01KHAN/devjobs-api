package com.arifkhan.devjobs.DevJobs.controller;

import com.arifkhan.devjobs.DevJobs.dto.AuthResponse;
import com.arifkhan.devjobs.DevJobs.dto.LoginRequest;
import com.arifkhan.devjobs.DevJobs.dto.RegisterRequest;
import com.arifkhan.devjobs.DevJobs.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody RegisterRequest registerRequest) {
        return authService.registerUser(registerRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> logIn(@RequestBody LoginRequest loginRequest) {
        return authService.logIn(loginRequest);
    }
}
