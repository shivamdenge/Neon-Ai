package com.shivamdenge.NeonAi.dto.project;

import com.shivamdenge.NeonAi.dto.auth.UserProfileResponseDTO;

import java.time.Instant;

public record ProjectResponseDTO(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt,
        UserProfileResponseDTO owner

) {
}
