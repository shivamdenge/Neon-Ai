package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.project.FileContentResponseDTO;
import com.shivamdenge.NeonAi.dto.project.FileNodeDTO;

import java.util.List;

public interface ProjectFileService {
    List<FileNodeDTO> getFileTree(Long projectId);

    FileContentResponseDTO getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);
}
