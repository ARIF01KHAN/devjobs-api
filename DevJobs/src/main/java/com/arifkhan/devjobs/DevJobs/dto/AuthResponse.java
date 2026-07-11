package com.arifkhan.devjobs.DevJobs.dto;

import com.arifkhan.devjobs.DevJobs.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String accessToken;

    private String refreshToken;

    private Role role;
}

