package kr.or.ddit.member.controller;

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
