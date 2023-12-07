package com.hypereon.projectservice.dto;

import java.util.List;

public class ProjectAccountDTO {

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
    private List<String> accountManager;
    private String accountName;
    private List<String> hiringManager;
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
    public List<String> getAccountManager() {
        return accountManager;
    }
    public void setAccountManager(List<String> accountManager) {
        this.accountManager = accountManager;
    }
    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public List<String> getHiringManager() {
        return hiringManager;
    }
    public void setHiringManager(List<String> hiringManager) {
        this.hiringManager = hiringManager;
    }
    public ProjectAccountDTO(long projectId, long accountId, String projectName, List<String> serviceLine,
            String businessUnit, String manager, List<Long> locationId, boolean isBillable, List<Long> jobRoleId,
            long interviewPanelId, List<String> accountManager, String accountName, List<String> hiringManager) {
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
        this.accountManager = accountManager;
        this.accountName = accountName;
        this.hiringManager = hiringManager;
    }
    public ProjectAccountDTO() {
    }
    
}
