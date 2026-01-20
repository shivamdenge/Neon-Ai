package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.SubscriptionService;
import com.shivamdenge.NeonAi.dto.subscription.CheckoutRequestDTO;
import com.shivamdenge.NeonAi.dto.subscription.CheckoutResponseDTO;
import com.shivamdenge.NeonAi.dto.subscription.PortalResponseDTO;
import com.shivamdenge.NeonAi.dto.subscription.SubscriptionResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public CheckoutResponseDTO createCheckoutSessionUrlD(CheckoutRequestDTO request, Long userId) {
        return null;
    }

    @Override
    public SubscriptionResponseDTO getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public PortalResponseDTO openCustomerPortal(Long userId) {
        return null;
    }
}
