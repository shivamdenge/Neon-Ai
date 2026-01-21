package com.shivamdenge.NeonAi.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequestDTO(
        @Email @NotBlank String username,
        @Size(min = 4) String password
        ) {
}
