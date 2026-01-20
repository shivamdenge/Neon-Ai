package com.shivamdenge.NeonAi.dto.subscription;

public record PlanResponseDTO( Long id,
                               String name,
                               Integer maxProjects,
                               Integer maxTokensPerDay,
                               Boolean unlimitedAi,
                               String price) {
}
