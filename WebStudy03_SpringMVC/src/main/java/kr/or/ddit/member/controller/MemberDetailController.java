package kr.or.ddit.member.controller;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberVO;


@Controller
public class MemberDetailController{
	@Inject
	private MemberService service;
	
	@GetMapping("/member/memberDetail.do")
	public String MemberDetail(
		@RequestParam("who") String memId
		,Model model
	) {

//		4. model 확보(logic 사용 - readMember) 
		MemberVO member = service.readMember(memId);
//		5. scope 에 저장 : member (attribute name)
		model.addAttribute("member", member);
//		6. view layer 선택(/WEB-INF/views/member/memberDetail.jsp)
		return "tiles:member/memberDetail";
		
	}
}
