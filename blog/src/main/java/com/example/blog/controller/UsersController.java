package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//인증이 안된 유저들에 대해서는 /auth~ 경로만 허용하는 필터를 적용한다.
@Controller
public class UsersController {
	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		
		return "user/joinForm";
	}

	@GetMapping("/auth/loginForm")
	public String loginForm() {
		
		return "user/loginForm";
	}
}