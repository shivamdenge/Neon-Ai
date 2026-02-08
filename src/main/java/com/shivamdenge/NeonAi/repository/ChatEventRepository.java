package com.shivamdenge.NeonAi.repository;

import com.shivamdenge.NeonAi.entity.ChatEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatEventRepository extends JpaRepository<ChatEvent,Long> {
}
