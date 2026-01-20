package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.AuthService;
import com.shivamdenge.NeonAi.dto.auth.AuthResponseDTO;
import com.shivamdenge.NeonAi.dto.auth.LoginRequestDTO;
import com.shivamdenge.NeonAi.dto.auth.SignupRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponseDTO signup(SignupRequestDTO requestDTO) {
        return null;
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO requestDTO) {
        return null;
    }
}
