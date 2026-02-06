package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.ChatService;
import com.shivamdenge.NeonAi.dto.Chat.ChatResponse;
import com.shivamdenge.NeonAi.entity.ChatMessage;
import com.shivamdenge.NeonAi.entity.ChatSession;
import com.shivamdenge.NeonAi.entity.ChatSessionId;
import com.shivamdenge.NeonAi.mapper.ChatMapper;
import com.shivamdenge.NeonAi.repository.ChatMessageRepository;
import com.shivamdenge.NeonAi.repository.ChatSessionRepository;
import com.shivamdenge.NeonAi.security.AuthUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatSessionRepository chatSessionRepository;
    private final AuthUtil authUtil;
    private final ChatMapper chatMapper;

    @Override
    public List<ChatResponse> getProjectChatHistory(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        ChatSession chatSession = chatSessionRepository.getReferenceById(
                new ChatSessionId(projectId, userId)
        );

        List<ChatMessage> chatMessageList = chatMessageRepository.findByChatSession(chatSession);

        return chatMapper.fromListOfChatMessage(chatMessageList);
    }
}
