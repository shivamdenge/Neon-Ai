package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.Chat.StreamResponse;
import com.stripe.net.HttpHeaders;
import reactor.core.publisher.Flux;

public interface AiGenerationService {
     Flux<StreamResponse> streamResponse(String message, Long projectId);
}
