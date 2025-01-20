package com.example.blog.controller;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.blog.config.auth.PrincipalDetail;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	
	@GetMapping({"", "/"})
	public String index(@AuthenticationPrincipal PrincipalDetail principal) {
		//스프링 시큐리티에서 작성한 로그인처리 로직이 끝난다음에 principal 객체에 정보가 담겨진다.
		
		System.out.println("로그인 사용자 : "+principal.getUsername());
		
		return "index";
	}
}