package com.shivamdenge.NeonAi.dto.member;

import com.shivamdenge.NeonAi.enums.ProjectRole;

public record InviteMemberRequestDTO(String email,
                                     ProjectRole role) {
}
