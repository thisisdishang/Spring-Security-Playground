package com.ranacorporation.SpringSecurityPlayground.config.security.manager;

import com.ranacorporation.SpringSecurityPlayground.config.security.providers.CustomAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

    // Authentication object: not authenticate

    // AM => go to Authentication Provider

    // Authentication object: authenticated

    CustomAuthenticationProvider customAuthenticationProvider;

    public CustomAuthenticationManager(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (customAuthenticationProvider.supports(authentication.getClass())) {
            return customAuthenticationProvider.authenticate(authentication);
        }
        throw new AuthenticationServiceException("We do not support the authentication type provided!");
    }
}
