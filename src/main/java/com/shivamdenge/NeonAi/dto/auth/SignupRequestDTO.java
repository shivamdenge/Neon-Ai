package com.shivamdenge.NeonAi.dto.auth;

public record SignupRequestDTO(
        String email,
        String name,
        String password
) {
}
