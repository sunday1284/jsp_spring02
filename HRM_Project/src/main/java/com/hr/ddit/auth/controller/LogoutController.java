package com.hr.ddit.auth.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController{
	
	@GetMapping("/Login/Logout")
	public String logout(HttpSession session){
		session.invalidate();
		//웰컴페이지 이동(redirect)
		return "redirect:/?state=logout";
	}
}
