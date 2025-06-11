package com.ranacorporation.SpringSecurityPlayground.config;

import com.ranacorporation.SpringSecurityPlayground.config.security.filters.CustomAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final CustomAuthenticationFilter customAuthenticationFilter;

    public SecurityConfig(CustomAuthenticationFilter customAuthenticationFilter) {
        this.customAuthenticationFilter = customAuthenticationFilter;
    }

    //    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails userDetails = User.builder().username("jarvis").password("iamon").build();
//        userDetailsManager.createUser(userDetails);
//        return userDetailsManager;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated())
                .build();
    }
}
