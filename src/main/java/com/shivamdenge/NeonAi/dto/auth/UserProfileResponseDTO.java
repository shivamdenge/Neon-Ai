package com.shivamdenge.NeonAi.dto.auth;

public record UserProfileResponseDTO(
        Long id,
        String email,
        String name,
        String avatarUrl
) {
}
