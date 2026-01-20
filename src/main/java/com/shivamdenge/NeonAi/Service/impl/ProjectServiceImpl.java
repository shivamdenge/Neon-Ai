package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.ProjectService;
import com.shivamdenge.NeonAi.dto.project.ProjectRequestDTO;
import com.shivamdenge.NeonAi.dto.project.ProjectResponseDTO;
import com.shivamdenge.NeonAi.dto.project.ProjectSummaryResponseDTO;
import com.shivamdenge.NeonAi.entity.Project;
import com.shivamdenge.NeonAi.entity.User;
import com.shivamdenge.NeonAi.mapper.ProjectMapper;
import com.shivamdenge.NeonAi.repository.ProjectRepository;
import com.shivamdenge.NeonAi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper mapper;


    @Override
    public ProjectResponseDTO createProject(Long userId, ProjectRequestDTO requestDTO) {

        User owner = userRepository.findById(userId).orElseThrow();

        Project project = Project.builder().name(requestDTO.name()).isPublic(false).owner(owner).build();

        project = projectRepository.save(project);

        return mapper.toProjectResponseDTO(project);
    }

    @Override
    public List<ProjectSummaryResponseDTO> getUserProjects(Long userId) {

            /* This One Way And Below Is Second
                return projectRepository.findAllAccessibleByUser(userId).stream()
                .map(project -> mapper.toProjectSummaryResponseDTO(project))
                .collect(Collectors.toList());
            */

        return mapper.toListOfProjectSummaryResponseDTO(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    public ProjectResponseDTO getUserProjectById(Long id, Long userId) {
        return null;
    }

    @Override
    public ProjectResponseDTO updateProject(Long id, Long userId, ProjectRequestDTO requestDTO) {
        return null;
    }

    @Override
    public void softDelete(Long id, Long userId) {

    }
}
