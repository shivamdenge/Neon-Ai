package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.subscription.PlanLimitsResponseDTO;
import com.shivamdenge.NeonAi.dto.subscription.UsageTodayResponseDTO;

public interface UsageService {
    UsageTodayResponseDTO getTodayUsageOfUser(Long userId);

    PlanLimitsResponseDTO getCurrentSubscriptionLimitsOfUser(Long userId);
}
