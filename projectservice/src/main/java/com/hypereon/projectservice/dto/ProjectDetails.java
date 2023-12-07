package com.hypereon.projectservice.dto;

import java.util.List;

import com.hypereon.projectservice.model.InterviewPanel;
import com.hypereon.projectservice.model.JobRole;
import com.hypereon.projectservice.model.Location;

public class ProjectDetails {
    private ProjectDTO project;
    private List<Location> locations;
    private List<JobRole> jobRoles;
    private InterviewPanel interviewPanel;

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<JobRole> getJobRoles() {
        return jobRoles;
    }

    public void setJobRoles(List<JobRole> jobRoles) {
        this.jobRoles = jobRoles;
    }

    public InterviewPanel getInterviewPanel() {
        return interviewPanel;
    }

    public void setInterviewPanel(InterviewPanel interviewPanel) {
        this.interviewPanel = interviewPanel;
    }

    public ProjectDetails(ProjectDTO project, List<Location> locations, List<JobRole> jobRoles,
            InterviewPanel interviewPanel) {
        this.project = project;
        this.locations = locations;
        this.jobRoles = jobRoles;
        this.interviewPanel = interviewPanel;
    }

    public ProjectDetails() {
    }

}
