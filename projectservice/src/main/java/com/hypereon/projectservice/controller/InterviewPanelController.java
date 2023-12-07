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

import com.hypereon.projectservice.model.InterviewPanel;
import com.hypereon.projectservice.service.InterviewPanelService;

@RestController
@RequestMapping("/api/interviewpanel")
@CrossOrigin("*")
public class InterviewPanelController {
    @Autowired
    InterviewPanelService interviewPanelService;

    @GetMapping("/id")
    public ResponseEntity<InterviewPanel> getInterviewPanelByInterviewPanelId(@RequestParam Long interviewPanelId) {
        return ResponseEntity.ok().body(interviewPanelService.findInterviewPanelByInterviewPanelId(interviewPanelId));
    }

    @PostMapping("/add")
    public ResponseEntity<InterviewPanel> addInterviewPanel(@RequestBody InterviewPanel interviewPanel) {
        return ResponseEntity.accepted().body(interviewPanelService.addInterviewPanel(interviewPanel));
    }

    @GetMapping("/getbyskills")
    public ResponseEntity<List<InterviewPanel>> getInterviewPanelBySkills(@RequestParam List<String> skillList) {
        return ResponseEntity.ok().body(interviewPanelService.findInterviewPanelBySkill(skillList));
    }
}