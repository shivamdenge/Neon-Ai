package com.shivamdenge.NeonAi.repository;

import com.shivamdenge.NeonAi.entity.ChatSession;
import com.shivamdenge.NeonAi.entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}
