package com.shivamdenge.NeonAi.dto.subscription;

public record PlanLimitsResponseDTO(
        String planName,
        Integer maxTokensPerDay,
        Integer maxProjects,
        Boolean unlimitedAi
) {
}
