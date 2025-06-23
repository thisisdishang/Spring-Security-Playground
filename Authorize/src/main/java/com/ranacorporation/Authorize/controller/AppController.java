package com.ranacorporation.Authorize.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
// authenticated resource
public class AppController {
    @GetMapping("/test")
    public String test() {
        return "Hello from app";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('READ')")
    public String getUsers(){
        return "I am a user endpoint";
    }
}
