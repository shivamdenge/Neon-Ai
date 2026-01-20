package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.auth.AuthResponseDTO;
import com.shivamdenge.NeonAi.dto.auth.LoginRequestDTO;
import com.shivamdenge.NeonAi.dto.auth.SignupRequestDTO;

public interface AuthService {

    AuthResponseDTO signup(SignupRequestDTO requestDTO) ;

    AuthResponseDTO login(LoginRequestDTO requestDTO);
}
