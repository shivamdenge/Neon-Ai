package com.shivamdenge.NeonAi.mapper;

import com.shivamdenge.NeonAi.dto.subscription.PlanResponseDTO;
import com.shivamdenge.NeonAi.dto.subscription.SubscriptionResponseDTO;
import com.shivamdenge.NeonAi.entity.Plan;
import com.shivamdenge.NeonAi.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponseDTO toSubscriptionResponse(Subscription subscription);

    PlanResponseDTO toPlanResponse(Plan plan);
}
