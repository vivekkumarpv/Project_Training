package com.hypereon.projectservice.service;

import java.util.List;

import com.hypereon.projectservice.model.JobRole;

public interface JobRoleService {
    public List<JobRole> findJobRolesByIds(List<Long> jobRoleIds);
    public List<String> findJobRoleNamesForIds(List<Long> jobRoleIds);
    public JobRole findJobRoleById(Long jobRoleId);
    public JobRole addJobRole(JobRole jobRole);
}
