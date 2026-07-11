package com.arifkhan.devjobs.DevJobs.dto;

import com.arifkhan.devjobs.DevJobs.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String name;

    private String email;

    private String password;

    private Role role;
}
