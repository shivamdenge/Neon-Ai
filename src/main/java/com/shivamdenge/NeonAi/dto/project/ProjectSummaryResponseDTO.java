package com.shivamdenge.NeonAi.dto.project;

import com.shivamdenge.NeonAi.enums.ProjectRole;

import java.time.Instant;

public record ProjectSummaryResponseDTO(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        ProjectRole role
) {
}
