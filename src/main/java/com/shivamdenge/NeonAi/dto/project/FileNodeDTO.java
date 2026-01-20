package com.shivamdenge.NeonAi.dto.project;

import java.time.Instant;

public record FileNodeDTO(
        String path,
        Instant modifiedAt,
        Long size,
        String type
) {
}
