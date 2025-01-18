package com.example.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
	
	@GetMapping({"", "/"})
	public String index(HttpSession session) {
		System.out.println(session.getAttribute("user"));
		return "index";
	}
}