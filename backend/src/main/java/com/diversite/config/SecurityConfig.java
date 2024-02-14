package com.diversite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/api/login").permitAll() // Allow login without being authenticated
                        .anyRequest().authenticated() // All other requests require authentication
                );
        return http.build();
    }



    // Define customAuthenticationSuccessHandler and customAuthenticationFailureHandler beans
}
