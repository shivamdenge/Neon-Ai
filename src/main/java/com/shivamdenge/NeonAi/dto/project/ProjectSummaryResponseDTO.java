package com.shivamdenge.NeonAi.dto.project;

import java.time.Instant;

public record ProjectSummaryResponseDTO(
        Long id,
        String projectName,
        Instant createdAt,
        Instant updatedAt
) {
}
