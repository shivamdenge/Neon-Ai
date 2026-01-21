package com.shivamdenge.NeonAi.dto.member;

import com.shivamdenge.NeonAi.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record InviteMemberRequestDTO(
        @Email @NotBlank String username,
        @NotBlank ProjectRole role) {
}
