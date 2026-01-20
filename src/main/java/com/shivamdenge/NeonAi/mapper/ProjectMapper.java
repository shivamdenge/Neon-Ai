package com.shivamdenge.NeonAi.mapper;

import com.shivamdenge.NeonAi.dto.project.ProjectResponseDTO;
import com.shivamdenge.NeonAi.dto.project.ProjectSummaryResponseDTO;
import com.shivamdenge.NeonAi.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponseDTO toProjectResponseDTO(Project project);

    @Mapping(source = "name" ,target = "projectName")
    ProjectSummaryResponseDTO toProjectSummaryResponseDTO(Project project);

    List<ProjectSummaryResponseDTO> toListOfProjectSummaryResponseDTO(List<Project> projects);

}
