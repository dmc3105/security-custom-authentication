package com.dmc3105.customauthentication.service;

import com.dmc3105.customauthentication.dto.SignUpRequest;
import com.dmc3105.customauthentication.entity.User;
import com.dmc3105.customauthentication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationService {

    private PasswordEncoder passwordEncoder;
    private UserRepository repository;

    public void register(SignUpRequest signUpRequest) {
        User newUser = User.builder()
                .email(signUpRequest.email())
                .password(passwordEncoder.encode(signUpRequest.password()))
                .firstname(signUpRequest.firstname())
                .lastname(signUpRequest.lastname())
        .build();

        repository.save(newUser);
    }
}
