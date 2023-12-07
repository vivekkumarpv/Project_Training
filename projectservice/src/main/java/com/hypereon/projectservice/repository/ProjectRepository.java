package com.hypereon.projectservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hypereon.projectservice.dto.ProjectDTO;
import com.hypereon.projectservice.model.Project;

public interface ProjectRepository extends MongoRepository<Project, Long> {
    public Optional<Project>findByProjectName(String projectName);
    public Optional<Project>findByProjectId(Long projectId);
    List<ProjectDTO> findByAccountId(Long accountId);
}
