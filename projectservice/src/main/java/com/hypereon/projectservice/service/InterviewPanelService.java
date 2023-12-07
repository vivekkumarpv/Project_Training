package com.hypereon.projectservice.service;

import java.util.List;

import com.hypereon.projectservice.model.InterviewPanel;

public interface InterviewPanelService {
    public InterviewPanel addInterviewPanel(InterviewPanel interviewPanel);
    public InterviewPanel findInterviewPanelByInterviewPanelId(Long interviewPanelId);
    public List<InterviewPanel> findInterviewPanelBySkill(List<String> skillList);
}
