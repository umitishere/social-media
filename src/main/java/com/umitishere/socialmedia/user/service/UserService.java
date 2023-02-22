package com.umitishere.socialmedia.user.service;

import com.umitishere.socialmedia.user.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<UserEntity> searchUsers();

}
