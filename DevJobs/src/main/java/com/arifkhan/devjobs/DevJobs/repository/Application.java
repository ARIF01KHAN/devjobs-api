package com.arifkhan.devjobs.DevJobs.repository;

import com.arifkhan.devjobs.DevJobs.entity.ApplicationId;
import com.arifkhan.devjobs.DevJobs.entity.Job;
import com.arifkhan.devjobs.DevJobs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Application extends JpaRepository<Application, ApplicationId> {

    Optional<List<Application>> findByUser(User user);

    Optional<List<Application>> findByJob(Job job);
}
