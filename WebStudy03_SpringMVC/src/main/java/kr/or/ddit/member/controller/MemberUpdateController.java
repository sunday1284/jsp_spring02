package kr.or.ddit.member.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.ddit.auth.exception.AuthenticateException;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberVO;

@Controller
public class MemberUpdateController{
	@Inject
	private MemberService service;
	
	
	@GetMapping("/member/memberUpdate.do")
	public String GetUpdateMember(
		HttpSession session
		,Model model
		
	) {
//		1. 인증 객체 확보 
		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
		// 이미 실패한 요청에 대한 정보를 가진 객체 
		MemberVO member =  (MemberVO) session.getAttribute("member");
		Map<String, String> errors =  (Map)session.getAttribute("errors");
		if(member == null) {
			// 수정을 위한 요청이 처음 발생한 경우.
			//2. 현재 사용자의 기본 정보 조회
			member = service.readMember(authMember.getMemId());
			//3. scope를 이용해 2번에서 조회한 모델을 전달
			model.addAttribute("member", member);	
		}else {
			// 실패한 요청으로 디라이렉션한 경우.
			model.addAttribute("member", member);
			model.addAttribute("errors", errors);
			session.removeAttribute("member");
			session.removeAttribute("errors");
		}
//		4. logicalName 결정 
		return "tiles:member/memberEdit";
		
	}
	
	@PostMapping("/member/memberUpdate.do")
	public String PostMemUpdate(
		HttpSession session
		, Model model
		, HttpServletRequest req
	)
	{
		//memberinsert랑 비슷함 
		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
		MemberVO member = new MemberVO();
		member.setMemId(authMember.getMemId());
		//2. 파라미터 설정 -> beanutils로 다 가져옴
		try {
			BeanUtils.populate(member, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		//3. 서비스에서 값 받아옴 -> logicalName 설정
		//에러를 해쉬맵으로 셋팅함
		Map<String, String> errors = new HashMap<>();
		validate(member, errors);
		//에러가 비어 있으면 valid , 비어있지 않으면 !valid
		boolean valid = errors.isEmpty();
		
		//4. 수정 성공 실패 여부 확인
		session.setAttribute("member", member);
		session.setAttribute("errors", errors);
		
		String logicalName = null;
		if(valid) {
			try {
				//수정 성공 
				service.modifyMember(member);
				//완료 후 삭제
				session.removeAttribute("member");
				session.removeAttribute("errors");
				
				// 기존 인증 객체 변경 
				session.setAttribute("authMember", service.readMember(member.getMemId()));
				logicalName = "redirect:/mypage";
				
			} catch(AuthenticateException e) {
				session.setAttribute("message", "비밀번호 오류");
				logicalName = "redirect:/member/memberUpdate.do";
			}
		} else {
			//수정 실패시 다시 원래 폼 화면
			logicalName = "redirect:/member/memberUpdate.do";
		}
		
		
		return logicalName;
	}

	// Call by Reference 구조
	private void validate(MemberVO member, Map<String, String> errors) {
//		if (StringUtils.isBlank(member.getMemId())) {
//			errors.put("memId", "회원아이디 누락");
//		}
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
