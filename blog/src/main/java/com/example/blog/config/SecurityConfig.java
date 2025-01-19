package com.example.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import jakarta.servlet.DispatcherType;

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
		 .csrf((csrfConfig) ->
         		csrfConfig.disable()
			 ) // csrf 토큰 비활성화 (테스트시 걸어두는게 좋음) 추후 지울 예정 (보안설정필요)
		 .authorizeHttpRequests((request) -> 
		 	
		 	// 서버 내부에서 처리하는건 FORWARD인데, 스프링시큐리티는
		 	// 기본적으로 REQUEST 방식에 대한 필터라서 이렇게 dispatcher 설정을 해줘야한다.
		 	// 이거 안하면 무한 리다이렉트 걸림 ㅠ
            request.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
		     .requestMatchers("/auth/**")
		     .permitAll() //permitAll은 권한없어도 OK해주는 옵션
		     .anyRequest()
		     .authenticated()
		 )
	     .formLogin(login -> login
	    		 //초기 로그인 페이지를 커스텀해서 내 JSP로 넘기는 필터임.
	 		     .loginPage("/auth/loginForm")
	             .defaultSuccessUrl("/", true)
	             .permitAll() //permitAll은 권한없어도 OK해주는 옵션
	     );
		
		return http.build();
	}
}
