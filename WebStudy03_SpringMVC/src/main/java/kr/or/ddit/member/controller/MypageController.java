package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.ddit.member.vo.MemberVO;

@Controller
public class MypageController {
	@GetMapping("/mypage")
	public String mypage(
			//세션을 어뎁터를 통해 받음
			@SessionAttribute("authMember") MemberVO authMember
			,Model model)  {
		//디테일에서 쓸 스코프
		model.addAttribute("member", authMember);
		//타일즈
		return "tiles:member/memberDetail";
		
	}
}
