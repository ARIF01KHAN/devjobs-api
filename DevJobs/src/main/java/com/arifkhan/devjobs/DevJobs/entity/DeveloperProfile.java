package com.arifkhan.devjobs.DevJobs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "developer_profiles")
public class DeveloperProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developerProfileId")
    private Long developerProfileId;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(name = "resume_url")
    private String resumeUrl;

    private String skills;

    @Column(name = "github_url")
    private String githubUrl;

    @Column(name = "linked_url")
    private String linkedUrl;

    @Column(name = "portfolio_url")
    private String portfolioUrl;

    @Column(name = "job_title", length = 100)
    private String jobTitle;
}
