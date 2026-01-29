package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.ProjectService;
import com.shivamdenge.NeonAi.Service.SubscriptionService;
import com.shivamdenge.NeonAi.dto.project.ProjectRequestDTO;
import com.shivamdenge.NeonAi.dto.project.ProjectResponseDTO;
import com.shivamdenge.NeonAi.dto.project.ProjectSummaryResponseDTO;
import com.shivamdenge.NeonAi.entity.Project;
import com.shivamdenge.NeonAi.entity.ProjectMember;
import com.shivamdenge.NeonAi.entity.ProjectMemberId;
import com.shivamdenge.NeonAi.entity.User;
import com.shivamdenge.NeonAi.enums.ProjectRole;
import com.shivamdenge.NeonAi.error.BadRequestException;
import com.shivamdenge.NeonAi.error.ResourceNotFoundException;
import com.shivamdenge.NeonAi.mapper.ProjectMapper;
import com.shivamdenge.NeonAi.repository.ProjectMemberRepository;
import com.shivamdenge.NeonAi.repository.ProjectRepository;
import com.shivamdenge.NeonAi.repository.UserRepository;
import com.shivamdenge.NeonAi.security.AuthUtil;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil authUtil;
    SubscriptionService subscriptionService;

    @Override
    public ProjectResponseDTO createProject(ProjectRequestDTO request) {

        if(!subscriptionService.canCreateNewProject()) {
            throw new BadRequestException("User cannot create a New project with current Plan, Upgrade plan now.");
        }

        Long userId = authUtil.getCurrentUserId();
        /// This Line will fetch entire user that we don't need as below .user(owner) here we only need owner

       /* User owner = userRepository.findById(userId).orElseThrow(
            () -> new ResourceNotFoundException("User", userId.toString())
      );*/

        /// Instead of above we can use this  will not make Any db call it only store data in dummy table
        User owner = userRepository.getReferenceById(userId);

        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();
        project = projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(projectMember);

        return projectMapper.toProjectResponseDTO(project);
    }

    @Override
    public List<ProjectSummaryResponseDTO> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();

         /* This is One Way to get Project And Below Is Second
                return projectRepository.findAllAccessibleByUser(userId).stream()
                .map(project -> mapper.toProjectSummaryResponseDTO(project))
                .collect(Collectors.toList());
            */

        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponseDTO(projects);
    }

    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public ProjectResponseDTO getUserProjectById(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        return projectMapper.toProjectResponseDTO(project);
    }

    @Override
    @PreAuthorize("@security.canEditProject(#projectId)")
    public ProjectResponseDTO updateProject(Long projectId, ProjectRequestDTO request) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);

        project.setName(request.name());
        project = projectRepository.save(project);

        return projectMapper.toProjectResponseDTO(project);
    }

    @Override
    @PreAuthorize("@security.canDeleteProject(#projectId)")
    public void softDelete(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    ///  INTERNAL FUNCTIONS

    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
    }
}
