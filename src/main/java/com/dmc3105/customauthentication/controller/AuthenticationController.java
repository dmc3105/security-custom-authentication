package com.dmc3105.customauthentication.controller;

import com.dmc3105.customauthentication.dto.SignUpRequest;
import com.dmc3105.customauthentication.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationService service;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody SignUpRequest request) {
        service.register(request);
    }
}
