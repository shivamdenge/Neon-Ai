package com.shivamdenge.NeonAi.mapper;

import com.shivamdenge.NeonAi.dto.Chat.ChatResponse;
import com.shivamdenge.NeonAi.entity.ChatMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);
}
