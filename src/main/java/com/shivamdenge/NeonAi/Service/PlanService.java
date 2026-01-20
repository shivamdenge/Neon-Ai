package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.subscription.PlanResponseDTO;

import java.util.List;

public interface PlanService {
    List<PlanResponseDTO> getAllActivePlans();
}
