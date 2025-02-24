package kr.or.ddit.member.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.validate.UpdateGroup;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member/memberUpdate.do")
public class MemberUpdateController{
	//생성자 주입
	private final MemberService service;
	public static final String MODELNAME = "member";
	
	@GetMapping
	public String FormUI(
		Authentication authentication
		,Model model
	) {
	
		if(!model.containsAttribute(MODELNAME)) {
			// 수정을 위한 요청이 처음 발생한 경우.
			//2. 현재 사용자의 기본 정보 조회
			MemberVO member = service.readMember(authentication.getName());
			//3. scope를 이용해 2번에서 조회한 모델을 전달
			model.addAttribute(MODELNAME, member);	
		}
//		4. logicalName 결정 
		return "tiles:member/memberEdit";
		
	}
	
	@PostMapping
	public String FormProcess(
		Authentication authentication
		,@Validated(UpdateGroup.class) @ModelAttribute(MODELNAME) MemberVO member
		, BindingResult errors
		, HttpSession session
		, RedirectAttributes redirectAttributes
	)
	{
		//memberinsert랑 비슷함 
		member.setMemId(authentication.getName());
		//2. 파라미터 설정 -> beanutils로 다 가져옴
		
		boolean valid = !errors.hasErrors();
		
		String logicalName = null;
		if(valid) {
			//4. 수정 성공 실패 여부 확인
			try {
				//수정 성공 
				service.modifyMember(member);
				//완료 후 삭제
				
				
				
				
				logicalName = "redirect:/mypage";
				
			} catch(AuthenticationException e) {
				redirectAttributes.addFlashAttribute("message", "비밀번호 오류");
				logicalName = "redirect:/member/memberUpdate.do";
			  }
			}else {
				redirectAttributes.addFlashAttribute(MODELNAME,member);
				
				Map<String, String> errorMap = errorsToMap(errors);
//				String errorName = BindingResult.MODEL_KEY_PREFIX + MODELNAME;
//				redirectAttributes.addFlashAttribute(errorName,errors);
				redirectAttributes.addFlashAttribute("errors", errorMap);
				
				//수정 실패시 다시 원래 폼 화면
				logicalName = "redirect:/member/memberUpdate.do";
			}
			return logicalName;
		}

	private Map<String, String> errorsToMap(BindingResult errors) {
//		errors -> Map (attribute name : errors) 모든 에러메시지 생성 
		List<ObjectError> allErrors = errors.getAllErrors();
		Map<String, String> errorMap = new HashMap<>();
		for(ObjectError single : allErrors) {
			//타입 체크 연산자 instanceof
			if(single instanceof FieldError) {
				FieldError fe = (FieldError) single;
				// 하나의 프로퍼티에 대한 에러 
				String propName = fe.getField();
				//기본 에러 메시지
				String errorMsg = fe.getDefaultMessage();
				errorMap.put(propName, errorMsg);
				
			}
		}
		return errorMap;
	}
		
}
