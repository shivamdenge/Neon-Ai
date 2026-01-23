package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.AuthService;
import com.shivamdenge.NeonAi.dto.auth.AuthResponseDTO;
import com.shivamdenge.NeonAi.dto.auth.LoginRequestDTO;
import com.shivamdenge.NeonAi.dto.auth.SignupRequestDTO;
import com.shivamdenge.NeonAi.entity.User;
import com.shivamdenge.NeonAi.error.BadRequestException;
import com.shivamdenge.NeonAi.mapper.UserMapper;
import com.shivamdenge.NeonAi.repository.UserRepository;
import com.shivamdenge.NeonAi.security.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final AuthUtil authUtil;

    @Override
    public AuthResponseDTO signup(SignupRequestDTO requestDTO) {

        //Check User Already Exists or not
        userRepository.findByUsername(requestDTO.username()).ifPresent(user -> {
           throw new BadRequestException("User already exists with username "+requestDTO.username());
        });

        User user  = userMapper.toUserEntity(requestDTO);
        user.setPassword(passwordEncoder.encode(requestDTO.password()));
        user = userRepository.save(user);

        String token = authUtil.generateAccessToken(user);

        return new AuthResponseDTO(token, userMapper.toUserProfileResponseDTO(user));
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO requestDTO) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDTO.username(),requestDTO.password())
        );

        User user = (User) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);
        return new AuthResponseDTO(token, userMapper.toUserProfileResponseDTO(user));
    }
}
