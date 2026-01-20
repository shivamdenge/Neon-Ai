package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.PlanService;
import com.shivamdenge.NeonAi.dto.subscription.PlanResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponseDTO> getAllActivePlans() {
        return List.of();
    }
}
