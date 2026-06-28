package com.arifkhan.devjobs.DevJobs.repository;

import com.arifkhan.devjobs.DevJobs.entity.RecruiterProfile;
import com.arifkhan.devjobs.DevJobs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruiterProfileRepository extends JpaRepository<RecruiterProfile,Long> {

    RecruiterProfile findByUser(User user);

    List<RecruiterProfile> findByCompanyName(String company);
}
