package com.arifkhan.devjobs.DevJobs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class ApplicationId implements Serializable {
    @Column(name = "developer_id")
    private Long developerId;

    @Column(name = "jobId")
    private Long jobId;
}
