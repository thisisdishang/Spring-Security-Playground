package com.ranacorporation.SpringSecurityPlayground.config.security.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationManager implements AuthenticationManager {

    // Authentication object: not authenticate

    // AM => go to Authentication Provider

    // Authentication object: authenticated
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }
}
