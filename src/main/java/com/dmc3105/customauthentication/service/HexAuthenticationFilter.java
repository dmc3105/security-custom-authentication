package com.dmc3105.customauthentication.service;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
public class HexAuthenticationFilter extends OncePerRequestFilter {

    private AuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (!isHexAuthenticationHeaderValid(authorizationHeader)) {
            filterChain.doFilter(request, response);
            return;
        }

        String encodedToken = authorizationHeader.substring(4);
        Authentication authenticationRequest = new HexAuthenticationToken(encodedToken);
        Authentication authenticationResult = authenticationManager.authenticate(authenticationRequest);

        SecurityContextHolder.getContext().setAuthentication(authenticationResult);

        filterChain.doFilter(request, response);
    }

    private static boolean isHexAuthenticationHeaderValid(String authorizationHeader) {
        return authorizationHeader != null && authorizationHeader.startsWith("Hex ");
    }
}
