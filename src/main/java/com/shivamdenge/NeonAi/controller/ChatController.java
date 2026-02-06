package com.shivamdenge.NeonAi.controller;

import com.shivamdenge.NeonAi.Service.AiGenerationService;
import com.shivamdenge.NeonAi.Service.ChatService;
import com.shivamdenge.NeonAi.dto.Chat.ChatRequest;
import com.shivamdenge.NeonAi.dto.Chat.ChatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final AiGenerationService aiGenerationService;
    private final ChatService chatService;

    @PostMapping(value = "/api/chat/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> streamChat(
            @RequestBody ChatRequest request) {

        return aiGenerationService.streamResponse(request.message(), request.projectId())
                .map(data -> ServerSentEvent.<String>builder()
                        .data(data)
                        .build());
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<List<ChatResponse>> getChatHistory(
            @PathVariable Long projectId) {

        return ResponseEntity.ok(chatService.getProjectChatHistory(projectId));
    }
}
