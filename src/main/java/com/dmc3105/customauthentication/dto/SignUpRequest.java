package com.dmc3105.customauthentication.dto;

public record SignUpRequest(String email, String password, String firstname, String lastname) {
}
