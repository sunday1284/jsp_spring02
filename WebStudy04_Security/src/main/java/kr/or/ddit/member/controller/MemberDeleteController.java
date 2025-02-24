package kr.or.ddit.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.security.RealUserWrapper;

@Controller
public class MemberDeleteController{
	//의존 관계 형성 -> service
	@Inject
	private MemberService service;
	
	@PostMapping("/member/memberDelete.do")
	public String MemDelete(
		Authentication authentication
		,@RequestParam("password") String password
		, HttpSession session
		, RedirectAttributes redirectAttributes
			
	){
		
		//인증 객체 확보 -> id만 꺼내옴
		
		//1. authMember확보
		MemberVO inputData = new MemberVO();
		inputData.setMemId(authentication.getName());
		inputData.setMemPass(password);
		
		String logicalName = null;
		//2. 성공시 웰컴 , 실패시 mypage로 이동
		try {
			service.removeMember(inputData);
			session.invalidate(); //탈퇴하면 세션 정보를 다 삭제해야함 -> 로그아웃
			logicalName = "redirect:/";	
		}catch(AuthenticationException e){
			redirectAttributes.addFlashAttribute("message", "비밀번호 오류");
			logicalName = "redirect:/mypage";
		}
		
	
		return logicalName;
	}
}

