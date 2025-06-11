package com.ranacorporation.SpringSecurityPlayground.config.security.providers;

import com.ranacorporation.SpringSecurityPlayground.config.security.model.CustomAuthentication;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication ca = (CustomAuthentication) authentication;

        if (ca.getHeader().equals("jarvis")) {
            return new CustomAuthentication(true, ca.getHeader());
        }
        throw new BadCredentialsException("Key value is invalid");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
