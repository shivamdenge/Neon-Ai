package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.subscription.PlanLimitsResponseDTO;
import com.shivamdenge.NeonAi.dto.subscription.UsageTodayResponseDTO;

public interface UsageService {
    void recordTokenUsage(Long id, int totalTokens);
    void checkDailyTokensUsage();
}
