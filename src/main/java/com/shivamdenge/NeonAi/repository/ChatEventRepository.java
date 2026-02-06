package com.shivamdenge.NeonAi.repository;

import com.shivamdenge.NeonAi.entity.ChatEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatEventRepository extends JpaRepository<ChatEvent,Long> {
}
