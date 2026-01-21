package com.shivamdenge.NeonAi.dto.member;

import com.shivamdenge.NeonAi.enums.ProjectRole;

import java.time.Instant;

public record MemberResponseDTo(
        Long userId,
        String email,
        String name,
        ProjectRole projectRole,
        Instant invitedAt
) {
}
