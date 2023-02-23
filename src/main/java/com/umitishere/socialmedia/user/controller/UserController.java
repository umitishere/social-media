package com.umitishere.socialmedia.user.controller;

import com.umitishere.socialmedia.user.entity.UserEntity;
import com.umitishere.socialmedia.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserEntity> searchUsers() {
        return userService.searchUsers();
    }

}
