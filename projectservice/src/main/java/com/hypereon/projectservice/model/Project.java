package com.hypereon.projectservice.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Project {

    private long projectId;
    private long accountId;
    private String projectName;
    private List<String> serviceLine;
    private String businessUnit;
    private String manager;
    private List<Long> locationId;
    private boolean isBillable;
    private List<Long> jobRoleId;
    private long interviewPanelId;
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public Project() {
    }

    public Project(long projectId, long accountId, String projectName, List<String> serviceLine,
            String businessUnit, String manager, List<Long> locationId, boolean isBillable, List<Long> jobRoleId,
            long interviewPanelId, LocalDateTime createdAt, LocalDateTime modifiedAt) {

        this.projectId = projectId;
        this.accountId = accountId;
        this.projectName = projectName;
        this.serviceLine = serviceLine;
        this.businessUnit = businessUnit;
        this.manager = manager;
        this.locationId = locationId;
        this.isBillable = isBillable;
        this.jobRoleId = jobRoleId;
        this.interviewPanelId = interviewPanelId;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<String> getServiceLine() {
        return serviceLine;
    }

    public void setServiceLine(List<String> serviceLine) {
        this.serviceLine = serviceLine;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<Long> getLocationId() {
        return locationId;
    }

    public void setLocationId(List<Long> locationId) {
        this.locationId = locationId;
    }

    public boolean isBillable() {
        return isBillable;
    }

    public void setBillable(boolean isBillable) {
        this.isBillable = isBillable;
    }

    public List<Long> getJobRoleId() {
        return jobRoleId;
    }

    public void setJobRoleId(List<Long> jobRoleId) {
        this.jobRoleId = jobRoleId;
    }

    public long getInterviewPanelId() {
        return interviewPanelId;
    }

    public void setInterviewPanelId(long interviewPanelId) {
        this.interviewPanelId = interviewPanelId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    

}
