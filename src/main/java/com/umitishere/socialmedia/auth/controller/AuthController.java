package com.umitishere.socialmedia.auth.controller;

import com.umitishere.socialmedia.auth.dto.LoginRequestDto;
import com.umitishere.socialmedia.auth.dto.RegisterRequestDto;
import com.umitishere.socialmedia.auth.service.AuthService;
import com.umitishere.socialmedia.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequestDto loginRequestDto) {
        return authService.login(loginRequestDto);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequestDto registerRequestDto) {
        authService.register(registerRequestDto);
    }

}
