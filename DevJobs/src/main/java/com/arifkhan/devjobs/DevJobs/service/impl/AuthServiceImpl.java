package com.arifkhan.devjobs.DevJobs.service.impl;

import com.arifkhan.devjobs.DevJobs.dto.AuthResponse;
import com.arifkhan.devjobs.DevJobs.dto.LoginRequest;
import com.arifkhan.devjobs.DevJobs.dto.RegisterRequest;
import com.arifkhan.devjobs.DevJobs.entity.Role;
import com.arifkhan.devjobs.DevJobs.entity.User;
import com.arifkhan.devjobs.DevJobs.repository.UserRepository;
import com.arifkhan.devjobs.DevJobs.security.JwtUtil;
import com.arifkhan.devjobs.DevJobs.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<AuthResponse> registerUser(RegisterRequest registerRequest) {
       String email  = registerRequest.getEmail();
       String password = registerRequest.getPassword();
       String name = registerRequest.getName();
        Role role = registerRequest.getRole();

       if (email == null || password == null || role == null) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "All fields are mandatory");
       }

       if (userRepository.existsByEmail(email)) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already registered");
       }

       User user = new User();
       user.setName(name);
       user.setEmail(email);
       user.setPassword(passwordEncoder.encode(password));
       user.setRole(role);
       user.setCreatedAt(new Timestamp(new Date().getTime()));
       userRepository.save(user);

       AuthResponse authResponse = AuthResponse.builder()
               .accessToken(jwtUtil.generateToken(email))
               .role(role)
               .build();
       return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AuthResponse> logIn(LoginRequest loginRequest) {
        return null;
    }
}
