package com.shivamdenge.NeonAi.controller;

import com.shivamdenge.NeonAi.Service.AuthService;
import com.shivamdenge.NeonAi.Service.UserService;
import com.shivamdenge.NeonAi.dto.auth.AuthResponseDTO;
import com.shivamdenge.NeonAi.dto.auth.LoginRequestDTO;
import com.shivamdenge.NeonAi.dto.auth.SignupRequestDTO;
import com.shivamdenge.NeonAi.dto.auth.UserProfileResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDTO> signup(@RequestBody SignupRequestDTO requestDTO) {
        return ResponseEntity.ok(authService.signup(requestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO requestDTO) {
        return ResponseEntity.ok(authService.login(requestDTO));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponseDTO> getProfile() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }
}
