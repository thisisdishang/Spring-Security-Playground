package com.ranacorporation.Authorize.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// @EnableGlobalMethodSecurity(prePostEnabled = true)
// AspectJ
@EnableMethodSecurity
// Spring Aspects
/*
    PreAuthorize, PostAuthorize, PreFilter, PostFilter
*/
public class SecurityConfig {

    private UserDetails secondUser;

    @Bean
    public UserDetailsManager userDetailsManager() {
        UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        // create two user
        UserDetails firstUser = User.builder().username("jarvis").password("gameison").authorities("READ").build();
        UserDetails secondUser = User.builder().username("lucifer").password("gameison").authorities("WRITE").build();
        UserDetails thirdUser = User.builder().username("peaky").password("gameison").build();

        userDetailsManager.createUser(firstUser);
        userDetailsManager.createUser(secondUser);
        userDetailsManager.createUser(thirdUser);

        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /*
    matching_method().rules()

    matching methods:
    anyRequest()
    requestMatchers
    dispatcherMatchers(FORWARD, INCLUDE)

    rules:
    authenticated()
    hasAuthority()
    permitAll()

    401: Authentication Failure => Unauthorized
    403: Authorization Fail / Access Rights => Forbidden

    Request (no auth) => authorization filter (permit all) => response
    Request (basic auth) => authentication => authorization => permit all => response
    Request (invalid basic auth) => authentication => invalid

    GrantedAuthority: role and authority
    role: ROLE_MANAGER
    authority: READ
    */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic(Customizer.withDefaults())
//                .authorizeHttpRequests(customizer -> customizer
//                        .requestMatchers("/public/**").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/admin/**").hasAuthority("READ")
//                        .requestMatchers(HttpMethod.POST, "/admin/**").hasAuthority("WRITE")
//                        .anyRequest().authenticated())
//                .csrf(customizer -> customizer.disable()) // do not do this in production
                .build();
    }
}
