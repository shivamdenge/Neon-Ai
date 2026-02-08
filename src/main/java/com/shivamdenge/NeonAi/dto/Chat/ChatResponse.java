package com.shivamdenge.NeonAi.dto.Chat;

import com.shivamdenge.NeonAi.entity.ChatEvent;
import com.shivamdenge.NeonAi.entity.ChatSession;
import com.shivamdenge.NeonAi.enums.MessageRole;

import java.time.Instant;
import java.util.List;

public record ChatResponse(
        Long id,
        //ChatSession chatSession,
        MessageRole role,
        List<ChatEventResponse> events,
        String content,
        Integer tokensUsed,
        Instant createdAt

) {
}
