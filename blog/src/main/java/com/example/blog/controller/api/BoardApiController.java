package com.example.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.config.auth.PrincipalDetail;
import com.example.blog.dto.ResponseDto;
import com.example.blog.model.Board;
import com.example.blog.model.RoleType;
import com.example.blog.model.Users;
import com.example.blog.service.BoardService;
import com.example.blog.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDto<Board> saveBoard(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
		
		boardService.saveContent(board, principal.getUser());
		
		return new ResponseDto<Board>(HttpStatus.OK.value(), board);
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
