package com.shivamdenge.NeonAi.controller;

import com.shivamdenge.NeonAi.Service.PlanService;
import com.shivamdenge.NeonAi.Service.SubscriptionService;
import com.shivamdenge.NeonAi.dto.subscription.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BillingController {

    private final SubscriptionService subscriptionService;
    private final PlanService planService;

    @GetMapping("/api/plans")
    public ResponseEntity<List<PlanResponseDTO>> getAllPlans() {
        return ResponseEntity.ok(planService.getAllActivePlans());


    }

    @GetMapping("/api/me/subscription")
    public ResponseEntity<SubscriptionResponseDTO> getMySubscription() {
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.getCurrentSubscription(userId));
    }

    @PostMapping("/api/stripe/checkout")
    public ResponseEntity<CheckoutResponseDTO> createCheckoutResponse(
            @RequestBody CheckoutRequestDTO request
    ) {
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.createCheckoutSessionUrlD(request, userId));
    }

    @PostMapping("/api/stripe/portal")
    public ResponseEntity<PortalResponseDTO> openCustomerPortal() {
        Long userId = 1L;
        return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId));
    }
}
