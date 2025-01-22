package com.example.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.dto.ResponseDto;
import com.example.blog.model.RoleType;
import com.example.blog.model.Users;
import com.example.blog.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody Users user) {
		
		//특별한 설정이 없으니 USER 권한으로 세팅한다. 
		// 이건 기본값으로 USER넣어도될듯?
		int result = userService.join(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
	}

	@PutMapping("/user")
	public ResponseDto<Integer> updateUser(@RequestBody Users user) {
		userService.updateUser(user);
		//위 서비스가 실행되고나서 DB에 commit이 된 상태이다.
		//하지만 시큐리티세션의 user값은 변경되지 않은상태니, 직접 변경해줘야한다.
		
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	
	
	
	/*
	 * ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ 스프링 시큐리티 적용 전 간단한 로그인 로직
	 * @PostMapping("/api/user/login") public ResponseDto<Integer>
	 * login(@RequestBody Users user, HttpSession session) {
	 * 
	 * Users principal = userService.login(user); System.out.println(principal !=
	 * null); if(principal != null) { session.setAttribute("user", principal); }
	 * return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); }
	 */
	
}
