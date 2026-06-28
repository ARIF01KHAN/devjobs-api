package com.arifkhan.devjobs.DevJobs.repository;

import com.arifkhan.devjobs.DevJobs.entity.DeveloperProfile;
import com.arifkhan.devjobs.DevJobs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperProfileRepository extends JpaRepository<DeveloperProfile,Long> {

    DeveloperProfile findByUser(User user);


}
