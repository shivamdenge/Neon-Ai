package com.shivamdenge.NeonAi.dto.project;


import jakarta.validation.constraints.NotBlank;

public record ProjectRequestDTO(
        @NotBlank String name
) {
}
