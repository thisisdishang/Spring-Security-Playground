package com.ranacorporation.Authorize.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationApply {
    public boolean validation() {
        var a = SecurityContextHolder.getContext().getAuthentication();
        return a.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("READ"));
    }
}
