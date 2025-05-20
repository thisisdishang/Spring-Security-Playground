package com.ranacorporation.SpringSecurityPlayground.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    FilterChainProxy filterChainProxy;

    @GetMapping("/hello")
    public List<String> getHello() {
        List<SecurityFilterChain> securityFilterChainList = filterChainProxy.getFilterChains();
        List<String> filterNames = securityFilterChainList.stream()
                .flatMap(securityFilterChain -> securityFilterChain.getFilters().stream())
                .map(filter -> filter.getClass().getSimpleName())
                .toList();
        return filterNames;
    }
}