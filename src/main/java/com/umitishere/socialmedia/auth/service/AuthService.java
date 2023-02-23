package com.umitishere.socialmedia.auth.service;

import com.umitishere.socialmedia.user.entity.UserEntity;

public interface AuthService {

    void login();

    void register(UserEntity user);

}
