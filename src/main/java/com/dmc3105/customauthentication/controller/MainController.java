package com.dmc3105.customauthentication.controller;

import com.dmc3105.customauthentication.dto.UserInfo;
import com.dmc3105.customauthentication.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/public/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/profile")
    public UserInfo userInfo(@AuthenticationPrincipal User user) {
        return new UserInfo(user.getUsername(), user.getFirstname(), user.getLastname());
    }
}
