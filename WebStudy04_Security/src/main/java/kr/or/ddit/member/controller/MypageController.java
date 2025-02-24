package kr.or.ddit.member.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.security.RealUserWrapper;

@Controller
public class MypageController {
	@GetMapping("/mypage")
	public String mypage(
			//세션을 어뎁터를 통해 받음
			Authentication authentication 
			,Model model)  {
		
		//인증 객체를 꺼내와서 세션에 직접 접근x
		RealUserWrapper principal = (RealUserWrapper) authentication.getPrincipal();
		MemberVO authMember = principal.getRealUser();
		//디테일에서 쓸 스코프
		model.addAttribute("member", authMember);
		//타일즈
		return "tiles:member/memberDetail";
		
	}
}
