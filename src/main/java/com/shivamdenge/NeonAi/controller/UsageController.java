package com.shivamdenge.NeonAi.controller;

import com.shivamdenge.NeonAi.Service.UsageService;
import com.shivamdenge.NeonAi.dto.subscription.PlanLimitsResponseDTO;
import com.shivamdenge.NeonAi.dto.subscription.UsageTodayResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usage")
public class UsageController {

    private final UsageService usageService;

    @GetMapping("/today")
    public ResponseEntity<UsageTodayResponseDTO> getTodayUsage(){
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId));
    }

    @GetMapping("/limits")
    public ResponseEntity<PlanLimitsResponseDTO> getPlansLimits(){
        Long userId = 1L;
        return ResponseEntity.ok(usageService.getCurrentSubscriptionLimitsOfUser(userId));
    }
}
