package kr.or.ddit.member.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.validate.InsertGroup;

@Controller
@RequestMapping("/member/memberInsert.do")
public class MemberInsertController {
	@Inject
	private MemberService service;
	// 모델 네임 상수로 선언
	public static final String MODELNAME = "member";
	
	@GetMapping
	 public String FormUI(Model model){
		
		return "tiles:member/memberForm";

	}

	@PostMapping
	public String PostMemInsert(
		 @Validated(InsertGroup.class) @ModelAttribute(MODELNAME) MemberVO member
		, BindingResult errors
		 , RedirectAttributes redirectAttributes
		
	){		
		String logicalName = null;
		
		
//		3. 요청 검증 
		if(!errors.hasErrors()) {
//		2) 검증 통과 
//			a) 등록(createMember) 처리
			service.createMember(member);
			
//			b) 등록 성공 : 웰컴 페이지로 이동(redirect)
			logicalName = "redirect:/";
		}else {
//			1) 검증 실패
//			: 가입 양식으로 다시 이동(기존 입력 데이터 검증 결과 메시지를 전달).
//				dispatch -> redirect
			redirectAttributes.addFlashAttribute(MODELNAME,member);
			String errorName = BindingResult.MODEL_KEY_PREFIX + MODELNAME;
			redirectAttributes.addFlashAttribute(errorName,errors);
			logicalName = "redirect:/member/memberInsert.do";
		}	
		
		return logicalName;
	}


}
