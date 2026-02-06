package com.shivamdenge.NeonAi.dto.Chat;

import com.shivamdenge.NeonAi.enums.ChatEventType;

public record ChatEventResponse(
        Long id,
        ChatEventType type,
        Integer sequenceOrder,
        String content,
        String filePath,
        String metadata
) {
}
