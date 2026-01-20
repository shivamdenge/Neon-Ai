package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.subscription.CheckoutRequestDTO;
import com.shivamdenge.NeonAi.dto.subscription.CheckoutResponseDTO;
import com.shivamdenge.NeonAi.dto.subscription.PortalResponseDTO;
import com.shivamdenge.NeonAi.dto.subscription.SubscriptionResponseDTO;

public interface SubscriptionService {
    CheckoutResponseDTO createCheckoutSessionUrlD(CheckoutRequestDTO request, Long userId);

    SubscriptionResponseDTO getCurrentSubscription(Long userId);

    PortalResponseDTO openCustomerPortal(Long userId);
}
