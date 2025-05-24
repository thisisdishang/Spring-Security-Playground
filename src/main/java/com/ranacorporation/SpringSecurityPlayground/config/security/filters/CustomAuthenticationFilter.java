package com.ranacorporation.SpringSecurityPlayground.config.security.filters;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // CustomAuthenticationManager => CustomAuthenticationProvider => CustomUserDetailsService => ....
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
