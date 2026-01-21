package com.shivamdenge.NeonAi.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignupRequestDTO(
        @Email @NotBlank String username,
        @NotBlank String name,
        @NotBlank String password
) {
}
