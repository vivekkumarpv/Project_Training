package com.hypereon.projectservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hypereon.projectservice.model.JobRole;

public interface JobRoleRepository extends MongoRepository<JobRole, Long> {
    public Optional<JobRole> findByJobRoleId(Long jobRoleId);
}

