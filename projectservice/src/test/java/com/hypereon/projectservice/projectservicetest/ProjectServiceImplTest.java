package com.hypereon.projectservice.projectservicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hypereon.projectservice.dto.ProjectDTO;
import com.hypereon.projectservice.exception.ProjectNotFoundException;
import com.hypereon.projectservice.mapper.ProjectMapper;
import com.hypereon.projectservice.model.Project;
import com.hypereon.projectservice.repository.ProjectRepository;
import com.hypereon.projectservice.service.InterviewPanelService;
import com.hypereon.projectservice.service.JobRoleService;
import com.hypereon.projectservice.service.LocationService;
import com.hypereon.projectservice.service.ProjectServiceImpl;

@ExtendWith({ MockitoExtension.class })
@SpringBootTest
public class ProjectServiceImplTest {

	@InjectMocks
	private ProjectServiceImpl projectService;

	@Mock
	private ProjectRepository projectRepository;

	@Mock
	private LocationService locationService;

	@Mock
	private InterviewPanelService interviewPanelService;

	@Mock
	private JobRoleService jobRoleService;

	@Mock
	private ProjectMapper projectMapper;

	// ... other mock dependencies as needed

	// Your test methods will go here
	@Test
	public void testFindProjectByName_WhenProjectExists() {
		// Arrange
		String projectName = "TestProject";
		Project project = new Project(
                32421,                              // projectId
                12345,                            // accountId
                "TestProject",                  // projectName
                Arrays.asList("ServiceA"),      // serviceLine
                "IT",                            // businessUnit
                "John Doe",                      // manager
                Collections.singletonList(1L),  // locationId
                true,                            // isBillable
                Collections.singletonList(2L),  // jobRoleId
                3L,                              // interviewPanelId
                LocalDateTime.now(),            // createdAt
                LocalDateTime.now()             // modifiedAt
        ); 
		when(projectRepository.findByProjectName(projectName)).thenReturn(Optional.of(project));
		when(projectMapper.projectToProjectDTO(project)).thenReturn(new ProjectDTO()); // Mock mapper

		// Act
		ProjectDTO result = projectService.findProjectByName(projectName);

		// Assert
		assertNotNull(result);
		// Add more assertions as needed
	}

    @Test
    void testFindProjectByName_ProjectNotFound_ShouldThrowProjectNotFoundException() {
        // Arrange
        String projectName = "NonExistentProject";
        when(projectRepository.findByProjectName(projectName)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(ProjectNotFoundException.class, () -> projectService.findProjectByName(projectName));
    }

}
