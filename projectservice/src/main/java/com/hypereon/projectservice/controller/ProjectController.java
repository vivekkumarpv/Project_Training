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

import com.hypereon.projectservice.dto.ProjectAccountDTO;
import com.hypereon.projectservice.dto.ProjectDTO;
import com.hypereon.projectservice.dto.ProjectDetails;
import com.hypereon.projectservice.model.Project;
import com.hypereon.projectservice.service.ProjectService;


@RestController
@RequestMapping("/api/project")
@CrossOrigin("*")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping("/name")
    public ResponseEntity<ProjectDTO> getProjectByName(@RequestParam String projectName) {
        return ResponseEntity.ok().body(projectService.findProjectByName(projectName));
    }
    
    @GetMapping("/test")
    public ResponseEntity<String>test() {
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping("/id")
    public ResponseEntity<ProjectDTO> getProjectById(@RequestParam Long projectId) {
        return ResponseEntity.ok().body(projectService.findProjectById(projectId));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        return ResponseEntity.ok().body(projectService.findAllProjects());
    }

    @PostMapping("/add")
    public ResponseEntity<Project> addNewProject(@RequestBody Project project){
        return ResponseEntity.ok().body(projectService.addProject(project));
    }

    @GetMapping("/details")
    public ResponseEntity<ProjectDetails> getProjectDetails(@RequestParam String projectName){
        return ResponseEntity.ok().body(projectService.findProjectDetails(projectName));
    }

    @GetMapping("/projectaccount")
    public ResponseEntity<ProjectAccountDTO> getProjectAndAccountDetails(@RequestParam Long projectId){
        return ResponseEntity.ok().body(projectService.findProjectAndAccountByProjectId(projectId));
    }

    @GetMapping("/allprojects")
    public ResponseEntity<List<ProjectDTO>> getProjecsByAccountId(@RequestParam Long accountId){
        return ResponseEntity.ok().body(projectService.findProjectsByAccountID(accountId));
    }
}
