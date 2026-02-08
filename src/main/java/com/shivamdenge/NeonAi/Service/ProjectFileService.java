package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.project.FileContentResponseDTO;
import com.shivamdenge.NeonAi.dto.project.FileTreeResponse;

public interface ProjectFileService {
    FileTreeResponse getFileTree(Long projectId);

    FileContentResponseDTO getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);
}
