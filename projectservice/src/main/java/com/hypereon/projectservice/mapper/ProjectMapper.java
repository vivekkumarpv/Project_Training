package com.hypereon.projectservice.mapper;


import org.mapstruct.Mapper;

import com.hypereon.projectservice.dto.ProjectDTO;
import com.hypereon.projectservice.model.Project;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
	
	ProjectDTO projectToProjectDTO(Project project);
}

