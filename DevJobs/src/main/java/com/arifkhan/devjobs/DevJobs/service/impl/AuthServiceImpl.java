package com.arifkhan.devjobs.DevJobs.service.impl;

import com.arifkhan.devjobs.DevJobs.dto.AuthResponse;
import com.arifkhan.devjobs.DevJobs.dto.LoginRequest;
import com.arifkhan.devjobs.DevJobs.dto.RegisterRequest;
import com.arifkhan.devjobs.DevJobs.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public ResponseEntity<AuthResponse> registerUser(RegisterRequest registerRequest) {
        return null;
    }

    @Override
    public ResponseEntity<AuthResponse> logIn(LoginRequest loginRequest) {
        return null;
    }
}
