package com.hypereon.projectservice.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hypereon.projectservice.dto.Employee;

@Document
public class InterviewPanel {

    private long interviewPanelId;
    private List<Employee> employees;
    private List<String> skills;
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public InterviewPanel(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public InterviewPanel(long interviewPanelId, List<Employee> employees,List<String> skills, LocalDateTime createdAt,
            LocalDateTime modifiedAt) {
        this.interviewPanelId = interviewPanelId;
        this.employees = employees;
        this.skills=skills;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        
    }

    public InterviewPanel() {
   
    }
    public long getInterviewPanelId() {
        return interviewPanelId;
    }

    public void setInterviewPanelId(long interviewPanelId) {
        this.interviewPanelId = interviewPanelId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployeeId(List<Employee> employees) {
        this.employees = employees;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

}
