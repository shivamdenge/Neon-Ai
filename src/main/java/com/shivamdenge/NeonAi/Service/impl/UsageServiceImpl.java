package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.SubscriptionService;
import com.shivamdenge.NeonAi.Service.UsageService;
import com.shivamdenge.NeonAi.dto.subscription.PlanLimitsResponseDTO;
import com.shivamdenge.NeonAi.dto.subscription.PlanResponseDTO;
import com.shivamdenge.NeonAi.dto.subscription.SubscriptionResponseDTO;
import com.shivamdenge.NeonAi.dto.subscription.UsageTodayResponseDTO;
import com.shivamdenge.NeonAi.entity.UsageLog;
import com.shivamdenge.NeonAi.repository.UsageLogRepository;
import com.shivamdenge.NeonAi.security.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UsageServiceImpl implements UsageService {

    private final UsageLogRepository usageLogRepository;
    private final AuthUtil authUtil;
    private final SubscriptionService subscriptionService;

    @Override
    public void recordTokenUsage(Long userId, int actualTokens) {
        LocalDate today = LocalDate.now();

        UsageLog todayLog = usageLogRepository.findByUserIdAndDate(userId, today).
                orElseGet(() -> createNewDailyLog(userId, today));

        todayLog.setTokensUsed(todayLog.getTokensUsed() + actualTokens);
        usageLogRepository.save(todayLog);
    }

    @Override
    public void checkDailyTokensUsage() {
        Long userId = authUtil.getCurrentUserId();
        SubscriptionResponseDTO subscriptionResponse = subscriptionService.getCurrentSubscription();
        PlanResponseDTO plan = subscriptionResponse.plan();

        LocalDate today = LocalDate.now();

        UsageLog todayLog = usageLogRepository.findByUserIdAndDate(userId, today).
                orElseGet(() -> createNewDailyLog(userId, today));

        if (plan.unlimitedAi()) return;

        int currentUsage = todayLog.getTokensUsed();
        int limit = plan.maxTokensPerDay();

        if (currentUsage >= limit) {
            throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS,
                    "Daily limit reached, Upgrade now");
        }

    }

    private UsageLog createNewDailyLog(Long userId, LocalDate date) {
        UsageLog newLog = UsageLog.builder()
                .userId(userId)
                .date(date)
                .tokensUsed(0)
                .build();
        return usageLogRepository.save(newLog);
    }
}


