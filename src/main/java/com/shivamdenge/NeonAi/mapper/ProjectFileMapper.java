package com.shivamdenge.NeonAi.mapper;

import com.shivamdenge.NeonAi.dto.project.FileNodeDTO;
import com.shivamdenge.NeonAi.entity.Project;
import com.shivamdenge.NeonAi.entity.ProjectFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectFileMapper {

    List<FileNodeDTO> toListOfFileNodeDTO(List<ProjectFile> projectFiles);
}
