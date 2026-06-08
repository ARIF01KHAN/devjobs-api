package com.arifkhan.devjobs.DevJobs.repository;

import com.arifkhan.devjobs.DevJobs.entity.Job;
import com.arifkhan.devjobs.DevJobs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {

    List<Job> findByTitle(String title);

    List<Job> findByActiveTrue();

    List<Job> findByLocation(String location);

    List<Job> findByUser(User user);

    List<Job> findByRemoteTrue();
}