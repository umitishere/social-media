package com.umitishere.socialmedia.auth.service.impl;

import com.umitishere.socialmedia.auth.service.AuthService;
import com.umitishere.socialmedia.user.entity.UserEntity;
import com.umitishere.socialmedia.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.umitishere.socialmedia.exceptions.enums.UserExceptions.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImplementation implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void login() {

    }

    @Override
    public void register(UserEntity user) {
        String registerEmail = user.getEmail();
        String registerPassword = user.getPassword();

        Optional<UserEntity> optionalUser = userRepository.findByEmail(registerEmail);

        if (optionalUser.isPresent()) {
            throw EMAIL_IS_ALREADY_TAKEN.instance();
        } else {
            UserEntity registerUser = UserEntity.builder()
                    .id(UUID.randomUUID())
                    .email(registerEmail)
                    .password(passwordEncoder.encode(registerPassword))
                    .build();

            userRepository.save(registerUser);
        }
    }

}
