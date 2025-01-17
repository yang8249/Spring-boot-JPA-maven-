package com.example.blog.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.model.Users;

@RestController
public class UserApiController {

	@PostMapping("/api/user")
	public int save(@RequestBody Users user) {
		System.out.println("ajax요청");
		return 1;
	}
}
