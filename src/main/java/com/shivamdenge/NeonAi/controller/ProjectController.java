package com.shivamdenge.NeonAi.controller;

import com.shivamdenge.NeonAi.Service.ProjectService;
import com.shivamdenge.NeonAi.dto.project.ProjectRequestDTO;
import com.shivamdenge.NeonAi.dto.project.ProjectResponseDTO;
import com.shivamdenge.NeonAi.dto.project.ProjectSummaryResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectSummaryResponseDTO>> getMyProjects() {
        Long userId = 1L;
        return ResponseEntity.ok(projectService.getUserProjects(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable Long id) {
        Long userId = 1L;

        return ResponseEntity.ok(projectService.getUserProjectById(id, userId));
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectRequestDTO requestDTO) {
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(userId, requestDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> updateProject(@PathVariable Long id, @RequestBody ProjectRequestDTO requestDTO) {
        Long userId = 1L;
        return ResponseEntity.ok(projectService.updateProject(id, userId, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        Long userId = 1L;
        projectService.softDelete(id, userId);
        return ResponseEntity.noContent().build();
    }
}
