package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.UserService;
import com.shivamdenge.NeonAi.dto.auth.UserProfileResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponseDTO getProfile(Long userId) {
        return null;
    }
}
