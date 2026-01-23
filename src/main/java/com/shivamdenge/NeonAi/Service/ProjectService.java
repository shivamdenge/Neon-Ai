package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.project.ProjectRequestDTO;
import com.shivamdenge.NeonAi.dto.project.ProjectResponseDTO;
import com.shivamdenge.NeonAi.dto.project.ProjectSummaryResponseDTO;

import java.util.List;

public interface ProjectService {
    List<ProjectSummaryResponseDTO> getUserProjects();

    ProjectResponseDTO getUserProjectById(Long id);

    ProjectResponseDTO createProject(ProjectRequestDTO request);

    ProjectResponseDTO updateProject(Long id, ProjectRequestDTO request);

    void softDelete(Long id);
}

