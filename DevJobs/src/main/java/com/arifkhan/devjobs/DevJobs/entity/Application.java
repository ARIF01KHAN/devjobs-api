package com.arifkhan.devjobs.DevJobs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "applications")
public class Application {
    @EmbeddedId
    private ApplicationId id;

    @ManyToOne
    @MapsId("developerId")
    @JoinColumn(name = "developer_id", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("jobId")
    @JoinColumn(name = "jobId", nullable = false)
    private Job job;

    @Column(name = "cover_note", columnDefinition = "TEXT")
    private String coverNote;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @Column(name = "applied_at")
    private Timestamp appliedAt;
}
