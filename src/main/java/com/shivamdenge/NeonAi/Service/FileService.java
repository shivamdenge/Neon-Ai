package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.project.FileContentResponseDTO;
import com.shivamdenge.NeonAi.dto.project.FileNodeDTO;

import java.util.List;

public interface FileService {
    List<FileNodeDTO> getFileTree(Long userId, Long projectId);

    FileContentResponseDTO getFileContent(Long projectId, String path, Long userId);
}
