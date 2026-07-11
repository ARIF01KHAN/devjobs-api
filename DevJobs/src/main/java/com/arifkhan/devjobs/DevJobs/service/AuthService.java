package com.arifkhan.devjobs.DevJobs.service;

import com.arifkhan.devjobs.DevJobs.dto.AuthResponse;
import com.arifkhan.devjobs.DevJobs.dto.LoginRequest;
import com.arifkhan.devjobs.DevJobs.dto.RegisterRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    public ResponseEntity<AuthResponse> registerUser(RegisterRequest registerRequest);

    public ResponseEntity<AuthResponse> logIn(LoginRequest loginRequest);
}
