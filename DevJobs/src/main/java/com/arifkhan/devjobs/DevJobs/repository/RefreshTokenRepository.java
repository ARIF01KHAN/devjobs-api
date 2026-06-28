package com.arifkhan.devjobs.DevJobs.repository;

import com.arifkhan.devjobs.DevJobs.entity.RefreshToken;
import com.arifkhan.devjobs.DevJobs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {

    RefreshToken findByUser(User user);

    Optional<RefreshToken> findByToken(String token);

    void deleteByUser(User user);
}
