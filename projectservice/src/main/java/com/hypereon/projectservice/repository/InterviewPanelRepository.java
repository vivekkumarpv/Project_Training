package com.hypereon.projectservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hypereon.projectservice.model.InterviewPanel;

public interface InterviewPanelRepository extends MongoRepository<InterviewPanel, Long> {
    public Optional<InterviewPanel> findByInterviewPanelId(Long interviewPanelId);
    public List<InterviewPanel> findBySkillsIn(List<String> skills);
}
