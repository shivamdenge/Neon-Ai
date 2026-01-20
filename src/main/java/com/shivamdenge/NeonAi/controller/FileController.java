package com.shivamdenge.NeonAi.controller;

import com.shivamdenge.NeonAi.Service.FileService;
import com.shivamdenge.NeonAi.dto.project.FileContentResponseDTO;
import com.shivamdenge.NeonAi.dto.project.FileNodeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{id}/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    public ResponseEntity<List<FileNodeDTO>> getFileTree(@PathVariable Long projectId) {
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileTree(userId, projectId));
    }

    @GetMapping("/{*path}")
    public ResponseEntity<FileContentResponseDTO> getFile(
            @PathVariable Long projectId,
            @PathVariable String path
    ) {
        Long userId = 1L;
        return ResponseEntity.ok(fileService.getFileContent(projectId, path, userId));
    }
}

