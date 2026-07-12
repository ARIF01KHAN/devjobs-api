package com.arifkhan.devjobs.DevJobs.dto;

import com.arifkhan.devjobs.DevJobs.entity.Role;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String accessToken;

    private String refreshToken;

    private Role role;
}

