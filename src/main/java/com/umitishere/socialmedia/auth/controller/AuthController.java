package com.umitishere.socialmedia.auth.controller;

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
    public void login() {
        authService.login();
    }

    @PostMapping("/register")
    public void register(@RequestBody UserEntity user) {
        authService.register(user);
    }

}
