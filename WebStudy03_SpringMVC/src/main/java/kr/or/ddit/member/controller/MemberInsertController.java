package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@Controller
public class MemberInsertController {
	@Inject
	private MemberService service;

	@GetMapping("/member/memberInsert.do")
	 public String GetMemInsert(
		 HttpSession session
		 ,Model model
	){
		model.addAttribute("member", session.getAttribute("member")); 
		model.addAttribute("errors", session.getAttribute("errors")); 
		//세션 삭제 -> flash attribute 방식
		session.removeAttribute("member");
		session.removeAttribute("errors");
		
		return "tiles:member/memberForm";

	}

	@PostMapping("/member/memberInsert.do")
	public String PostMemInsert(
		HttpSession session
		, HttpServletRequest req
		, RedirectAttributes redirectAttributes
		,Model model
	){
		MemberVO member = new MemberVO();
		session.setAttribute("member", member);
		
		try {
			BeanUtils.populate(member, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		

		String logicalName = null;
//		3. 요청 검증 
		Map<String, String> errors = new HashMap<>();
		redirectAttributes.addFlashAttribute("errors", errors);
		validate(member, errors);
		boolean valid = errors.isEmpty();
		if (valid) {
//		2) 검증 통과 
//			a) 등록(createMember) 처리
			service.createMember(member);
//			b) 등록 성공 : 웰컴 페이지로 이동(redirect)
			logicalName = "redirect:/";
			session.removeAttribute("member");
			session.removeAttribute("errors");
		} else {
//		1) 검증 실패
//			: 가입 양식으로 다시 이동(기존 입력 데이터 검증 결과 메시지를 전달).
//				dispatch -> redirect
			logicalName = "redirect:/member/memberInsert.do";
		}
		
		return logicalName;
	}

	// Call by Reference 구조
	private void validate(MemberVO member, Map<String, String> errors) {
		if (StringUtils.isBlank(member.getMemId())) {
			errors.put("memId", "회원아이디 누락");
		}
		if (StringUtils.isBlank(member.getMemPass())) {
			errors.put("memPass", "비밀번호 누락");
		}
		if (StringUtils.isBlank(member.getMemName())) {
			errors.put("memName", "회원명 누락");
		}
		if (StringUtils.isBlank(member.getMemZip())) {
			errors.put("memZip", "우편번호 누락");
		}
		if (StringUtils.isBlank(member.getMemAdd1())) {
			errors.put("memAdd1", "주소1 누락");
		}
		if (StringUtils.isBlank(member.getMemAdd2())) {
			errors.put("memAdd2", "주소2 누락");
		}
		if (StringUtils.isBlank(member.getMemHp())) {
			errors.put("memHp", "휴대폰 누락");
		}

	}
}
