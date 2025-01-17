package com.example.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class securityConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf()
        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // HttpOnly False로 설정
        .and()
        .authorizeRequests()
        .anyRequest().authenticated(); // 모든 요청에 대해 인증을 요구
		return http.build();
	}
}
