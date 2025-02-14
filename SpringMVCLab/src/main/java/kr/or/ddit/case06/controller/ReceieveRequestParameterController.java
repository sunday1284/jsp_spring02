package kr.or.ddit.case06.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case06")
public class ReceieveRequestParameterController {
	
	
	
	/**
	 * MultiValueMap으로 여러 파라미터값 받기
	 * @param params
	 * @param model
	 */
	@PostMapping("param04")
	public void handler4( 
		@RequestParam MultiValueMap<String, String> params
		, Model model
	) {
		model.addAllAttributes(params);
	}
	
	@PostMapping("param03")
	public void handler3( 
		@RequestParam("what") String what
		,@RequestParam("number") int number
		,@RequestParam("kor1") String kor1
		,@RequestParam("kor2") String kor2
		, Model model
	) {
		model.addAttribute("what",what);
		model.addAttribute("number",number);
		model.addAttribute("kor1",kor1);
		model.addAttribute("kor2",kor2);
	}
	
	
	@GetMapping("param02")
	public void handler2(
			@RequestParam(name = "what", required = false) String[] what
			, @RequestParam(name="number", required = false, defaultValue = "-1") int number
			, Model model) {
//		req.getParameterValues("what");
		
		log.info("what : {}", what);
		log.info("number : {}", number);
		model.addAttribute("what",what);
		model.addAttribute("number",number);
	}
	@GetMapping("param01")
	public void handler1(@RequestParam(name = "what", required = false) String what, Model model) {
//		req.getParameter("what");		
		log.info("what : {}", what);
		model.addAttribute("what",what);
	}
}
