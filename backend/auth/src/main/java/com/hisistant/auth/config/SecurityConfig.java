package com.hisistant.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .csrf((AbstractHttpConfigurer::disable))
        .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.requestMatchers("/api/auth/login","/api/auth/signup",
                                "/api/order/category","/api/order/menu/{category_id}").permitAll()
                        .anyRequest().authenticated()
        );
        return http.build();
    }
 }
