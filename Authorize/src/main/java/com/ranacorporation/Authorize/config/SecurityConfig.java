package com.ranacorporation.Authorize.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager() {
        UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        // create two user
        UserDetails firstUser = User.builder().username("jarvis").password("gameison").authorities("READ").build();
        UserDetails secondUser = User.builder().username("lucifer").password("gameison").authorities("WRITE").build();

        userDetailsManager.createUser(firstUser);
        userDetailsManager.createUser(secondUser);

        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
