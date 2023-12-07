package com.hypereon.projectservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hypereon.projectservice.exception.JobRoleAlreadyExistException;
import com.hypereon.projectservice.exception.JobRoleNotFoundException;
import com.hypereon.projectservice.model.JobRole;
import com.hypereon.projectservice.repository.JobRoleRepository;

@Service
public class JobRoleServiceImpl implements JobRoleService {
    @Autowired
    JobRoleRepository jobRoleRepository;

    @Override
    public List<JobRole> findJobRolesByIds(List<Long> jobRoleIds) {
        List<JobRole> jobRoleList = new ArrayList<>();
        for (Long id : jobRoleIds) {
            Optional<JobRole> role = jobRoleRepository.findByJobRoleId(id);
            if (role.isPresent()) {
                jobRoleList.add(role.get());
            } else {
                throw new JobRoleNotFoundException("Job Role with ID " + id + " not found");
            }
        }
        return jobRoleList;

    }

    @Override
    public List<String> findJobRoleNamesForIds(List<Long> jobRoleIds) {
        List<String> jobRoleNamesList = new ArrayList<>();
        for (Long id : jobRoleIds) {
            Optional<JobRole> role = jobRoleRepository.findByJobRoleId(id);
            if (role.isPresent()) {
                jobRoleNamesList.add(role.get().getJobRoleName());
            } else {
                throw new JobRoleNotFoundException("Job Role with ID " + id + " not found");
            }
        }
        return jobRoleNamesList;
    }

    @Override
    public JobRole findJobRoleById(Long jobRoleId) {
        Optional<JobRole> role = jobRoleRepository.findByJobRoleId(jobRoleId);
        if (role.isPresent()) {
            return role.get();
        } else {
            throw new JobRoleNotFoundException("Job Role with ID " + jobRoleId + " not found");
        }
    }

    @Override
    public JobRole addJobRole(JobRole jobRole) {
       Optional<JobRole> optJobRole=jobRoleRepository.findByJobRoleId(jobRole.getJobRoleId());
       if(optJobRole.isPresent()){
        throw new JobRoleAlreadyExistException("Jobrole with id "+jobRole.getJobRoleId()+" already exists");
       }
       return jobRoleRepository.save(jobRole);
    }

}
