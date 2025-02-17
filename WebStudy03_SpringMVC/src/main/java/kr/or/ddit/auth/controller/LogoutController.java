package kr.or.ddit.auth.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
