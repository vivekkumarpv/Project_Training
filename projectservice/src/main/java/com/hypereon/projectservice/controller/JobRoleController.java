package com.hypereon.projectservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hypereon.projectservice.model.JobRole;
import com.hypereon.projectservice.service.JobRoleService;

@RestController
@RequestMapping("/api/jobrole")
@CrossOrigin("*")
public class JobRoleController {
    @Autowired
    JobRoleService jobRoleService;

    @GetMapping("/id")
    public ResponseEntity<JobRole> getJobRoleByJobRoleId(@RequestParam Long jobRoleId) {
        return ResponseEntity.ok().body(jobRoleService.findJobRoleById(jobRoleId));
    }

    @GetMapping("/ids")
    public ResponseEntity<List<JobRole>> getJobRolesByJobRoleIds(@RequestParam List<Long> jobRoleIds) {
        return ResponseEntity.ok().body(jobRoleService.findJobRolesByIds(jobRoleIds));
    }

    @GetMapping("/getrolenames")
    public ResponseEntity<List<String>> getJobRolesNamesByJobRoleIds(@RequestParam List<Long> jobRoleIds) {
        return ResponseEntity.ok().body(jobRoleService.findJobRoleNamesForIds(jobRoleIds));
    }

    @PostMapping("/add")
    public ResponseEntity<JobRole> addJobRole(@RequestBody JobRole jobRole) {
        return ResponseEntity.accepted().body(jobRoleService.addJobRole(jobRole));
    }
}
