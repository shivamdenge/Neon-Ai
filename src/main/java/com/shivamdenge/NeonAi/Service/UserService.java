package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.auth.UserProfileResponseDTO;

public interface UserService {
    UserProfileResponseDTO getProfile(Long userId);
}
