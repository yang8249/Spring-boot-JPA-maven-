package com.example.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

//컨피그레이션 설정을 해야 스프링 컨테이너에서 빈 관리를 할 수있다.
// 결론 : 컨피그레이션을 써야 빈 등록이 됨.

//EnableWebSecurity : 시큐리티라는 필터를 추가
// 기존 스프링 시큐리티 설정을 이 파일에서 진행하겠다. 라는 의미이다.

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests()
			.requestMatchers("/auth/**")
			.permitAll()
			.anyRequest()
			.authenticated()
		.and()
		    .csrf().disable()  // CSRF 비활성화
	        .formLogin()
	        .loginPage()
        .and()
	        .httpBasic();
		return http.build();
	}
}
