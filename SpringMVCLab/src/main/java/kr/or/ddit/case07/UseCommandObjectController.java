package kr.or.ddit.case07;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.vo.LprodVO;
import lombok.extern.slf4j.Slf4j;

/**
 * command object -> 명령과 관련된 모든 객체 
 * 회원가입 
 * 1. form을 통해 19개의 데이터 입력 및 전송 
 * 2. BeanUtils.populate -> MemberVO (command object)
 * 상품 등록 
 * 1. form을 통해 17개의 데이터 입력 및 전송 
 * 2. BeanUtils.populate -> ProdVO (command object)
 */
@Slf4j
@Controller
@RequestMapping("/case07")
public class UseCommandObjectController {
	//@Valid 어노테이션으로 대체 -> 검증 Map<String, String> errors -> Errors 로 대체
	private void validate(LprodVO lprod, Map<String, String> errors) {
//		@NotNull로 대체
		if(lprod.getLprodId()==null) {
			errors.put("lprodId", "아이디 누락");
		}
//		@NotBlank로 대체
		if(StringUtils.isBlank(lprod.getLprodGu())) {
			errors.put("lprodGu", "분류 코드 누락");
		}
	}
	
	/**
	 * Hibernate validator + Spring
	 * 1. pom.xml 에 hibernate validator 추가
	 * 2. Command Object(LprodVO) 에 검증룰(검증 어노테이션) 적용  
	 * 3. 핸들러 메소드의 파라미터 형태로 command object를 수신하는 경우,
	 * 		검증 대상이 되는 command object 앞에 @Valid 어노테이션 적용. 
	 * 4. 검증의 결과(Errors, BindingResult)를 핸들러 메소드의 아규먼트로 수신.
	 * 	  주의! 검증 결과 객체를 반드시 검증 대상이 되는 command object 바로 다음의 아규먼트로 수신해야함.
	 * 5. view layer 에서 검증 결과 메시지를 출력
	 * 	 1) 검증 결과 객체를 전달할 때 속성명 결정.
	 * 		ex) BindingResult.MODEL_KEY_PREFIX + "lprod"
	 * 	 2)form:errors 커스텀 태그로 출력 	  
	 * @param lprod
	 * @param errors
	 * @param redirectAttributes
	 * @return
	 */
	@PostMapping("formProcess1")
	public String formProcess3(
		@Valid @ModelAttribute("lprod") LprodVO lprod
		, Errors errors
		, RedirectAttributes redirectAttributes
	) {
		//에러가 없으면..
		if(!errors.hasErrors()) {
			log.info("lprod: {}", lprod);
			return "redirect:/prod/lprodList.do";	
		}else {
			//flashAttribute -> 새로고침시 기존 데이터를 지워준다
			redirectAttributes.addFlashAttribute("lprod", lprod);
			//스프링 내부적으로 에러 전달 -> 커스텀 태그가 읽을 수 있게 반환
			String errorAttrName = BindingResult.MODEL_KEY_PREFIX + "lprod";
			redirectAttributes.addFlashAttribute(errorAttrName, errors);
			//실패시 다시 폼UI로 이동 
			return "redirect:/case07/formUI1";
		}
	}
	
	public String formProcess2(
			@ModelAttribute("lprod") LprodVO lprod
			, RedirectAttributes redirectAttributes
			) {
		Map<String, String> errors = new HashMap<>();
		
		validate(lprod, errors);
		if(errors.isEmpty()) {
			log.info("lprod: {}", lprod);
			return "redirect:/prod/lprodList.do";	
		}else {
			//flashAttribute -> 새로고침시 기존 데이터를 지워준다
			redirectAttributes.addFlashAttribute("lprod", lprod);
			redirectAttributes.addFlashAttribute("errors", errors);
			//실패시 다시 폼UI로 이동 
			return "redirect:/case07/formUI1";
		}
	}
		
	
	public String formProcess1(
			@RequestParam("lprodId") long lprodId
			, @RequestParam("lprodGu") String lprodGu
			, @RequestParam(name = "lprodNm", required = false) String lprodNm
			) {
		
		return "redirect:/prod/lprodList.do";
	}
	
	@GetMapping("formUI1")
	public String formUI1(){
		return "tiles:case07/formUI1";
	}
}
