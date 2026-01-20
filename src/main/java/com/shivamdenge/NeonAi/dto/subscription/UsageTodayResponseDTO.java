package com.shivamdenge.NeonAi.dto.subscription;

public record UsageTodayResponseDTO(
        Integer tokensUsed,
        Integer tokensLimit,
        Integer previewsRunning,
        Integer previewsLimit
) {
}
