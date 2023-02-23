package com.umitishere.socialmedia.auth.service;

import com.umitishere.socialmedia.auth.dto.LoginRequestDto;
import com.umitishere.socialmedia.auth.dto.RegisterRequestDto;
import com.umitishere.socialmedia.user.entity.UserEntity;

public interface AuthService {

    boolean login(LoginRequestDto loginRequestDto);

    void register(RegisterRequestDto registerRequestDto);

}
