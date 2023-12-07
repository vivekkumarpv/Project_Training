package com.hypereon.projectservice.service;

import java.util.List;

import com.hypereon.projectservice.dto.ProjectAccountDTO;
import com.hypereon.projectservice.dto.ProjectDTO;
import com.hypereon.projectservice.dto.ProjectDetails;
import com.hypereon.projectservice.model.Project;

public interface ProjectService {
    public ProjectDTO findProjectByName(String projectName);
    public ProjectDTO findProjectById(Long id);
    public List<ProjectDTO> findAllProjects();
    public Project addProject(Project project);
    public ProjectAccountDTO findProjectAndAccountByProjectId(Long id);
    public List<ProjectDTO> findProjectsByAccountID(Long id);

    public ProjectDetails findProjectDetails(String projectName);
}
