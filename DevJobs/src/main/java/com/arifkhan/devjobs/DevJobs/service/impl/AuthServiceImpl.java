package com.arifkhan.devjobs.DevJobs.service.impl;

import com.arifkhan.devjobs.DevJobs.dto.AuthResponse;
import com.arifkhan.devjobs.DevJobs.dto.LoginRequest;
import com.arifkhan.devjobs.DevJobs.dto.RegisterRequest;
import com.arifkhan.devjobs.DevJobs.entity.RefreshToken;
import com.arifkhan.devjobs.DevJobs.entity.Role;
import com.arifkhan.devjobs.DevJobs.entity.User;
import com.arifkhan.devjobs.DevJobs.repository.RefreshTokenRepository;
import com.arifkhan.devjobs.DevJobs.repository.UserRepository;
import com.arifkhan.devjobs.DevJobs.security.JwtUtil;
import com.arifkhan.devjobs.DevJobs.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RefreshTokenRepository refreshTokenRepository;

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
       userRepository.save(user);

       String refreshToken = createRefreshToken(user);

       AuthResponse authResponse = AuthResponse.builder()
               .accessToken(jwtUtil.generateToken(email))
               .refreshToken(refreshToken)
               .role(role)
               .build();
       return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AuthResponse> logIn(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        String refreshToken = createRefreshToken(user);

        AuthResponse authResponse = AuthResponse.builder()
                .accessToken(jwtUtil.generateToken(email))
                .refreshToken(refreshToken)
                .role(user.getRole())
                .build();
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    private String createRefreshToken(User user) {
        String token = UUID.randomUUID().toString();
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setToken(token);
        refreshTokenRepository.save(refreshToken);
        return token;
    }
}
