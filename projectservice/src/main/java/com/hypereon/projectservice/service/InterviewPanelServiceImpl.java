package com.hypereon.projectservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hypereon.projectservice.exception.InterviewPanelAlreadyExistException;
import com.hypereon.projectservice.exception.InterviewPanelNotFoundException;
import com.hypereon.projectservice.model.InterviewPanel;
import com.hypereon.projectservice.repository.InterviewPanelRepository;

@Service
public class InterviewPanelServiceImpl implements InterviewPanelService {

    @Autowired
    InterviewPanelRepository interviewPanelRepository;

    @Override
    public InterviewPanel addInterviewPanel(InterviewPanel interviewPanel) {
        Optional<InterviewPanel> optInterviewPanel = interviewPanelRepository
                .findByInterviewPanelId(interviewPanel.getInterviewPanelId());
        if (optInterviewPanel.isEmpty()) {
            return interviewPanelRepository.save(interviewPanel);
        }
        throw new InterviewPanelAlreadyExistException(
                "Interview Panel with ID " + interviewPanel.getInterviewPanelId() + " already exists");

    }

    @Override
    public InterviewPanel findInterviewPanelByInterviewPanelId(Long interviewPanelId) {
        Optional<InterviewPanel> optInterviewPanel=interviewPanelRepository.findByInterviewPanelId(interviewPanelId);
        if(optInterviewPanel.isPresent()){
            return optInterviewPanel.get();
        }else {
            throw new InterviewPanelNotFoundException("Interview Panel with ID " + interviewPanelId + " not found");
        }
    }

    @Override
    public List<InterviewPanel> findInterviewPanelBySkill(List<String> skillList) {
        return interviewPanelRepository.findBySkillsIn(skillList);
    }
}