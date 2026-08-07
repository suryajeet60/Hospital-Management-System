package com.JavaSpringBoot.Roles_And_Permissions.controller;

import com.JavaSpringBoot.Roles_And_Permissions.dto.LoginRequestDto;
import com.JavaSpringBoot.Roles_And_Permissions.dto.LoginResponseDto;
import com.JavaSpringBoot.Roles_And_Permissions.dto.SignUpRequestDto;
import com.JavaSpringBoot.Roles_And_Permissions.dto.SignupResponseDto;
import com.JavaSpringBoot.Roles_And_Permissions.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController
{
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto)
    {
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignUpRequestDto signupRequestDto)
    {
        return ResponseEntity.ok(authService.signup(signupRequestDto));
    }
}
