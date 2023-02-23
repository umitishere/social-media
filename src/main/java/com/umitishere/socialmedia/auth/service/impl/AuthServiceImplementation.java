package com.umitishere.socialmedia.auth.service.impl;

import com.umitishere.socialmedia.auth.dto.LoginRequestDto;
import com.umitishere.socialmedia.auth.dto.RegisterRequestDto;
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
    public boolean login(LoginRequestDto loginRequestDto) {
        String loginEmail = loginRequestDto.getEmail();
        String loginPassword = loginRequestDto.getPassword();

        Optional<UserEntity> user = userRepository.findByEmail(loginEmail);

        if (user.isEmpty()) {
            throw EMAIL_NOT_EXIST.instance();
        } else if (!passwordEncoder.matches(loginPassword, user.get().getPassword())) {
            throw INVALID_USERNAME_OR_PASSWORD.instance();
        } else {
            return true;
        }
    }

    @Override
    public void register(RegisterRequestDto registerRequestDto) {
        String registerEmail = registerRequestDto.getEmail();
        String registerPassword = registerRequestDto.getPassword();

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
