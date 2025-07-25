package com.ranacorporation.Authorize.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
// admin resource
public class AdminController {
    @GetMapping("/test")
    public String test() {
        return "Hello from admin";
    }

    @PostMapping("/test")
    public String postTest() {
        return "Hello from admin POST";
    }
}
