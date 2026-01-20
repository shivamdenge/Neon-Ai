package com.shivamdenge.NeonAi.dto.subscription;

import java.time.Instant;

public record SubscriptionResponseDTO(
        PlanResponseDTO plan,
        String status,
        Instant periodEnd,
        Long tokensUsedThisCycle
) {
}
