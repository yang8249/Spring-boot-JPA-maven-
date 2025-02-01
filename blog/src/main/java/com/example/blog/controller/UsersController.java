package com.example.blog.controller;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.blog.model.OAuthToken;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//인증이 안된 유저들에 대해서는 /auth~ 경로만 허용하는 필터를 적용한다.
@Controller
public class UsersController {
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		
		return "auth/joinForm";
	}

	@GetMapping("/auth/loginForm")
	public String loginForm() {
		
		return "auth/loginForm";
	}

	@GetMapping("/auth/updateForm")
	public String updateForm() {
		
		return "auth/updateForm";
	}

	//@ResponseBody를 사용하면 데이터를 리턴하는 컨트롤러가 된다.
	@GetMapping("/auth/kakao/callback")
	public @ResponseBody String kakaoCallback(String code) {

		//카카오 토큰발급 API 경로로 웹클라이언트 생성
        WebClient webClient = WebClient.create("https://kauth.kakao.com/oauth/token");
        
        // MultiValueMap을 사용해 x-www-form-urlencoded 데이터 생성
        // x-www-form-urlencoded 형식으로 전송할때에는 Map이 아닌 다중값Map 자료형을 사용해야한다. (같은 Key값 적용.)
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "authorization_code");
        requestBody.add("client_id", "dec6846c84164e1751cadf8f9581c8dc");
        requestBody.add("redirect_uri", "http://localhost:8000/auth/kakao/callback");
        requestBody.add("code", code);
        
        
        // Jackson라이브러리가 Map자료형을 자동으로 JSON형식으로 변환하여 전송한다.
        // 생성한 경로로 POST 요청을 보낸다.
        String response = webClient.post()
            .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8") // 헤더 설정
            .bodyValue(requestBody) // JSON 데이터
            .retrieve() // 응답 받기
            .bodyToMono(String.class) // 비동기 처리
            .block(); // 동기 방식으로 결과 가져오기


        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oauthToken = null;
        try {
			oauthToken = objectMapper.readValue(response, OAuthToken.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("oauthToken: " + oauthToken.getAccess_token());
        
					
		return "카카오 인증 완료 / 코드 : "+oauthToken;
	}
}