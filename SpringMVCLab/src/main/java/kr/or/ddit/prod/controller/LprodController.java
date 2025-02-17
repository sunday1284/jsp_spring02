package kr.or.ddit.prod.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.case07.validate.InsertGroup;
import kr.or.ddit.case07.validate.UpdateGroup;
import kr.or.ddit.prod.service.LprodService;
import kr.or.ddit.vo.LprodVO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@Data
public class LprodController {
	private final LprodService service;
	
	
	@PostMapping("/prod/lprodUpdate.do")
	public String lprodUpdate(
			//group 적용
		 @Validated(UpdateGroup.class) @ModelAttribute("lprod") LprodVO lprod
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	) {
		//실패시
		if(errors.hasErrors()) {
			redirectAttributes.addFlashAttribute("lprod", lprod);
			//에러 셋팅 
			String errorName = BindingResult.MODEL_KEY_PREFIX + "lprod";
			redirectAttributes.addFlashAttribute(errorName, errors);
			return "redirect:/prod/lprodUpdate.do?what="+lprod.getLprodGu();
		}else {
			//성공시
			log.info("lprod {}",lprod);
			service.modifyLprod(lprod);
			return "redirect:/prod/lprodDetail.do?what="+lprod.getLprodGu();
		}
	}
	@GetMapping("/prod/lprodUpdate.do")
	public String lprodEdit(
		@RequestParam("what") String lprodGu
		, Model model
	) {	
		//lprod가 들어있을때 
		if(!model.containsAttribute("lprod")) {
			LprodVO lprod = service.readLprod(lprodGu);
			model.addAttribute("lprod",lprod);	
		}
		
		
		return "tiles:prod/lprodEdit";
		
	}
	
	@PostMapping("/prod/lprodInsert.do")
	public String lprodInsert(
		@Validated(InsertGroup.class) @ModelAttribute("lprod") LprodVO lprod
		//반드시 errors는 커맨드 오브젝트 다음에 생성
		, BindingResult errors
		, RedirectAttributes redirectAttributes
	){
		//성공시 
		if(errors.hasErrors()) {
			redirectAttributes.addFlashAttribute("lprod", lprod);
			//에러 셋팅 
			String errorName = BindingResult.MODEL_KEY_PREFIX + "lprod";
			redirectAttributes.addFlashAttribute(errorName, errors);
			return "redirect:/prod/lprodInsert.do";
		}else {
			log.info("lprod {}",lprod);
			service.createLprod(lprod);
			return "redirect:/prod/lprodList.do";
		}
		
		
		
	}
	@GetMapping("/prod/lprodInsert.do")
	public String lprodForm(){
		return "tiles:prod/lprodForm";
	}
	
	@GetMapping("/prod/lprodDetail.do")
	public ModelAndView lprodDetail(
			@RequestParam(value="what", required = true) String what
//			, Model model
	) {
		ModelAndView mav = new ModelAndView();
		LprodVO lprod = service.readLprod(what);
		mav.addObject("lprod", lprod);
		mav.setViewName("tiles:prod/lprodDetail");
		return mav;
	}
	
	// Model -> setAttribute랑 같음 @RequestMapping -> 클라이언트 사용할 주소 
	@RequestMapping("/prod/lprodList.do")
	public String lprodList(Model model) {
		List<LprodVO> lprodList = service.readLprodList();
		model.addAttribute("lprodList", lprodList);
		return "tiles:prod/lprodList";
	}
}
