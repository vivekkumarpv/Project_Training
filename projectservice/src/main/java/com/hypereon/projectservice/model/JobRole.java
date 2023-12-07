package com.hypereon.projectservice.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hypereon.projectservice.dto.Skill;

@Document
public class JobRole {

    private long jobRoleId;
    private long projectId;
    private String jobRoleName;
    private List<Skill> skills;
    private String jobRoleDescription;
    private String grade;
    private double billableAmount;
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public JobRole() {
    }

    public JobRole(long jobRoleId, long projectId, String jobRoleName, List<Skill> skills,
            String jobRoleDescription, String grade, double billableAmount, LocalDateTime createdAt,
            LocalDateTime modifiedAt) {
        this.jobRoleId = jobRoleId;
        this.projectId = projectId;
        this.jobRoleName = jobRoleName;
        this.skills = skills;
        this.jobRoleDescription = jobRoleDescription;
        this.grade = grade;
        this.billableAmount = billableAmount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public long getJobRoleId() {
        return jobRoleId;
    }

    public void setJobRoleId(long jobRoleId) {
        this.jobRoleId = jobRoleId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getJobRoleName() {
        return jobRoleName;
    }

    public void setJobRoleName(String jobRoleName) {
        this.jobRoleName = jobRoleName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public String getJobRoleDescription() {
        return jobRoleDescription;
    }

    public void setJobRoleDescription(String jobRoleDescription) {
        this.jobRoleDescription = jobRoleDescription;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getBillableAmount() {
        return billableAmount;
    }

    public void setBillableAmount(double billableAmount) {
        this.billableAmount = billableAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

}
