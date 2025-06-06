package com.ranacorporation.SpringSecurityPlayground.config.security.filters;

import com.ranacorporation.SpringSecurityPlayground.config.security.manager.CustomAuthenticationManager;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    CustomAuthenticationManager customAuthenticationManager;

    public CustomAuthenticationFilter(CustomAuthenticationManager customAuthenticationManager) {
        this.customAuthenticationManager = customAuthenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /*
        1. header: authentication
        2. if the header values matches, then move on the next filter
        */
        filterChain.doFilter(request, response);
    }

//    filter call: forward, include
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        // CustomAuthenticationManager => CustomAuthenticationProvider => CustomUserDetailsService => ....
//        filterChain.doFilter(servletRequest, servletResponse);
//    }

}
