package com.ranacorporation.Authorize.controller;

import com.ranacorporation.Authorize.model.User;
import com.ranacorporation.Authorize.service.UserService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
// authenticated resource
public class AppController {

    private UserService userService;

    public AppController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello from app";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('READ')")
    public String getUsers() {
        return "I am a user endpoint";
    }

    @GetMapping("/users2")
    @PreAuthorize("hasAnyAuthority('READ','WRITE')")
    public String getUsers2() {
        return "I am a user 2 endpoint";
    }

    @GetMapping("/users3")
    @PreAuthorize("authentication != null")
    public String getUsers3() {
        return "I am a user 3 endpoint";
    }

    @GetMapping("/users4")
    @PreAuthorize("@authorizationApply.validation()")
    public String getUsers4() {
        return "I am a user 4 endpoint";
    }

    @GetMapping("/users/{id}")
    @PostAuthorize("returnObject.username == authentication.name")
    public User getUserById(@PathVariable("id") String id) {
        userService.init();
        return userService.getUser(id);
    }
}
