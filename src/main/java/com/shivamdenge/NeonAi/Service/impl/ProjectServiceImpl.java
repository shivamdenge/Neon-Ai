package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.ProjectService;
import com.shivamdenge.NeonAi.dto.project.ProjectRequestDTO;
import com.shivamdenge.NeonAi.dto.project.ProjectResponseDTO;
import com.shivamdenge.NeonAi.dto.project.ProjectSummaryResponseDTO;
import com.shivamdenge.NeonAi.entity.Project;
import com.shivamdenge.NeonAi.entity.ProjectMember;
import com.shivamdenge.NeonAi.entity.ProjectMemberId;
import com.shivamdenge.NeonAi.entity.User;
import com.shivamdenge.NeonAi.enums.ProjectRole;
import com.shivamdenge.NeonAi.error.ResourceNotFoundException;
import com.shivamdenge.NeonAi.mapper.ProjectMapper;
import com.shivamdenge.NeonAi.repository.ProjectMemberRepository;
import com.shivamdenge.NeonAi.repository.ProjectRepository;
import com.shivamdenge.NeonAi.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMapper mapper;
    private final ProjectMemberRepository projectMemberRepository;


    @Override
    public ProjectResponseDTO createProject(Long userId, ProjectRequestDTO requestDTO) {

        User owner = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", userId.toString())
        );

        Project project = Project.builder()
                .name(requestDTO.name())
                .isPublic(false).build();

        project = projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(),owner.getId());
        ProjectMember projectMember  = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();

        projectMemberRepository.save(projectMember);


        return mapper.toProjectResponseDTO(project);
    }

    @Override
    public List<ProjectSummaryResponseDTO> getUserProjects(Long userId) {

            /* This is One Way to get Project And Below Is Second
                return projectRepository.findAllAccessibleByUser(userId).stream()
                .map(project -> mapper.toProjectSummaryResponseDTO(project))
                .collect(Collectors.toList());
            */

        return mapper.toListOfProjectSummaryResponseDTO(projectRepository.findAllAccessibleByUser(userId));
    }

    @Override
    public ProjectResponseDTO getUserProjectById(Long id, Long userId) {
        Project project = getAccessibleByProjectId(id, userId);
        return mapper.toProjectResponseDTO(project);
    }

    @Override
    public ProjectResponseDTO updateProject(Long id, Long userId, ProjectRequestDTO requestDTO) {
        Project project = getAccessibleByProjectId(id, userId);



        project.setName(requestDTO.name());
        project = projectRepository.save(project);

        return mapper.toProjectResponseDTO(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {
        Project project = getAccessibleByProjectId(id, userId);



        project.setDeletedAt(Instant.now());
        projectRepository.save(project);

    }

    /// INTERNAL FUNCTION

    public Project getAccessibleByProjectId(Long projectId, Long userId) {
        return projectRepository.findAccessibleByProjectId(projectId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
    }
}
