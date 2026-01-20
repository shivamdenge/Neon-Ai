package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.FileService;
import com.shivamdenge.NeonAi.dto.project.FileContentResponseDTO;
import com.shivamdenge.NeonAi.dto.project.FileNodeDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNodeDTO> getFileTree(Long userId, Long projectId) {
        return List.of();
    }

    @Override
    public FileContentResponseDTO getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
