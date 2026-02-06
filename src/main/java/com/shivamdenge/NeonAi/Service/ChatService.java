package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.Chat.ChatResponse;

import java.util.List;

public interface ChatService {
    List<ChatResponse> getProjectChatHistory(Long projectId);
}
