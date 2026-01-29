package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.subscription.CheckoutRequestDTO;
import com.shivamdenge.NeonAi.dto.subscription.CheckoutResponseDTO;
import com.shivamdenge.NeonAi.dto.subscription.PortalResponseDTO;
import com.stripe.model.StripeObject;

import java.util.Map;


public interface PaymentProcessor {
    CheckoutResponseDTO createCheckoutSessionUrl(CheckoutRequestDTO request);


    PortalResponseDTO openCustomerPortal();

    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);
}
