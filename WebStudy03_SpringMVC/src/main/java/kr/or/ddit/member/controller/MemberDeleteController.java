package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.auth.exception.AuthenticateException;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@Controller
public class MemberDeleteController{
	//의존 관계 형성 -> service
	@Inject
	private MemberService service;
	
	@PostMapping("/member/memberDelete.do")
	public String MemDelete(
		@SessionAttribute("authMember") MemberVO authMember
		,@RequestParam("password") String password
		, HttpSession session
		, RedirectAttributes redirectAttributes
			
	){
		//1. authMember확보
		MemberVO inputData = new MemberVO();
		inputData.setMemId(authMember.getMemId());
		inputData.setMemPass(password);
		
		String logicalName = null;
		//2. 성공시 웰컴 , 실패시 mypage로 이동
		try {
			service.removeMember(inputData);
			session.invalidate(); //탈퇴하면 세션 정보를 다 삭제해야함 -> 로그아웃
			logicalName = "redirect:/";	
		}catch(AuthenticateException e){
			redirectAttributes.addFlashAttribute("message", "비밀번호 오류");
			logicalName = "redirect:/mypage";
		}
		
	
		return logicalName;
	}
}

