package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.project.ProjectRequestDTO;
import com.shivamdenge.NeonAi.dto.project.ProjectResponseDTO;
import com.shivamdenge.NeonAi.dto.project.ProjectSummaryResponseDTO;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponseDTO> getUserProjects(Long userId);

    ProjectResponseDTO getUserProjectById(Long id, Long userId);

    ProjectResponseDTO createProject(Long userId, ProjectRequestDTO requestDTO);

    ProjectResponseDTO updateProject(Long id, Long userId, ProjectRequestDTO requestDTO);

    void softDelete(Long id, Long userId);
}

