package com.hypereon.projectservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hypereon.projectservice.dto.AccountDto;
import com.hypereon.projectservice.dto.ProjectAccountDTO;
import com.hypereon.projectservice.dto.ProjectDTO;
import com.hypereon.projectservice.dto.ProjectDetails;
import com.hypereon.projectservice.exception.ProjectNotFoundException;
import com.hypereon.projectservice.feingclient.AccountService;
import com.hypereon.projectservice.mapper.ProjectMapper;
import com.hypereon.projectservice.model.InterviewPanel;
import com.hypereon.projectservice.model.JobRole;
import com.hypereon.projectservice.model.Location;
import com.hypereon.projectservice.model.Project;
import com.hypereon.projectservice.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    LocationService locationService;

    @Autowired
    InterviewPanelService interviewPanelService;

    @Autowired
    JobRoleService jobRoleService;

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    AccountService accountService;

    @Override
    public ProjectDTO findProjectByName(String projectName) {
        Optional<Project> optProject = projectRepository.findByProjectName(projectName);
        Project project = optProject.orElseThrow(
                () -> new ProjectNotFoundException(String.format("Project with name %s not found", projectName)));

        // Use the mapper to convert Project to ProjectDTO
        return projectMapper.projectToProjectDTO(project);
    }

    @Override
    public ProjectDTO findProjectById(Long id) {
        Project project = projectRepository.findByProjectId(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + id + " not found"));

        return projectMapper.projectToProjectDTO(project);
    }

    @Override
    public List<ProjectDTO> findAllProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (Project project : projects) {
            projectDTOList.add(projectMapper.projectToProjectDTO(project));
        }
        return projectDTOList;
    }

    // @Override
    // public Project findProjectByName(String projectName) {
    // Optional<Project> optProject =
    // projectRepository.findByProjectName(projectName);
    // return optProject.orElseThrow(
    // () -> new ProjectNotFoundException(String.format("Project with name %s not
    // found", projectName)));

    // }

    // @Override
    // public Project findProjectById(Long id) {
    // Optional<Project> optProject = projectRepository.findByProjectId(id);
    // if (optProject.isEmpty()) {
    // throw new ProjectNotFoundException("Project with id " + id + " not found");
    // }
    // return optProject.get();
    // }

    // @Override
    // public List<Project> findAllProjects() {
    // return projectRepository.findAll();
    // }

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);

    }

    @Override
    public ProjectDetails findProjectDetails(String projectName) {
        ProjectDTO project = findProjectByName(projectName);
        List<Location> locations = locationService.findLocationsByIds(project.getLocationId());
        List<JobRole> jobRoles = jobRoleService.findJobRolesByIds(project.getJobRoleId());
        InterviewPanel interviewPanel = interviewPanelService
                .findInterviewPanelByInterviewPanelId(project.getInterviewPanelId());
        ProjectDetails projectDetails = new ProjectDetails(project, locations,
                jobRoles, interviewPanel);
        return projectDetails;
    }

    @Override
    public ProjectAccountDTO findProjectAndAccountByProjectId(Long id) {
        Project project = projectRepository.findByProjectId(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project with id " + id + " not found"));
        AccountDto account = accountService.getAccountById(project.getAccountId());
        ProjectAccountDTO projectAccountDTO = new ProjectAccountDTO(project.getProjectId(), account.getAccountId(),
                project.getProjectName(), project.getServiceLine(),
                project.getBusinessUnit(), project.getManager(), project.getLocationId(), project.isBillable(),
                project.getJobRoleId(), project.getInterviewPanelId(),
                account.getAccountManager(), account.getAccountName(), account.getHiringManager());
        return projectAccountDTO;
    }

    @Override
    public List<ProjectDTO> findProjectsByAccountID(Long id) {
        return projectRepository.findByAccountId(id);
    }

    // @Override
    // public ProjectDetails findProjectDetails(String projectName) {
    // Criteria matchCriteria = Criteria.where("projectName").is(projectName);

    // AggregationOperation match = Aggregation.match(matchCriteria);

    // AggregationOperation lookupLocations = Aggregation.lookup("locations",
    // "locationIds", "_id", "locations");
    // AggregationOperation unwindLocations = Aggregation.unwind("locations", true);

    // AggregationOperation lookupJobRoles = Aggregation.lookup("jobRoles",
    // "jobRoleIds", "_id", "jobRoles");
    // AggregationOperation unwindJobRoles = Aggregation.unwind("jobRoles", true);

    // AggregationOperation lookupInterviewPanel =
    // Aggregation.lookup("interviewPanels", "interviewPanelId", "_id",
    // "interviewPanel");
    // AggregationOperation unwindInterviewPanel =
    // Aggregation.unwind("interviewPanel", true);

    // Aggregation aggregation = Aggregation.newAggregation(match, lookupLocations,
    // unwindLocations,
    // lookupJobRoles, unwindJobRoles, lookupInterviewPanel, unwindInterviewPanel);

    // AggregationResults<ProjectDetails> results =
    // mongoTemplate.aggregate(aggregation, "projects", ProjectDetails.class);

    // if (results.getMappedResults().isEmpty()) {
    // throw new ProjectNotFoundException("Project with name " + projectName + " not
    // found");
    // }

    // return results.getMappedResults().get(0);
    // }
}
