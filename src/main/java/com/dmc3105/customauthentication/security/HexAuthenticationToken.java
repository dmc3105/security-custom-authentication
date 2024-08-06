package com.dmc3105.customauthentication.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.codec.Hex;

import java.nio.charset.StandardCharsets;

public class HexAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public HexAuthenticationToken(String hexToken) {
        super(extractUsername(hexToken), extractPassword(hexToken));
    }

    private static String extractUsername(String hexToken) {
        byte[] bytes = Hex.decode(hexToken);
        String decodedToken = new String(bytes, StandardCharsets.UTF_8);
        return decodedToken.split(":")[0];
    }

    private static String extractPassword(String hexToken) {
        byte[] bytes = Hex.decode(hexToken);
        String decodedToken = new String(bytes, StandardCharsets.UTF_8);
        return decodedToken.split(":")[1];
    }
}
