package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.UsageService;
import com.shivamdenge.NeonAi.dto.subscription.PlanLimitsResponseDTO;
import com.shivamdenge.NeonAi.dto.subscription.UsageTodayResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponseDTO getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponseDTO getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
