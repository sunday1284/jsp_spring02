package kr.or.ddit.case05.controller;

import java.time.LocalDate;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.case04.service.Case04DummyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case05")
public class FlowControlController {
	@Inject
	private Case04DummyService service;
	
	//redirect 
	/**
	 * RedirectAttributes -> redirect를 할때 속성값을 전달함
	 * addFlashAttribute -> 리다리렉션할 때 세션관리용이(FlashAttribute)
	 * @return
	 */
	@RequestMapping("start02")
	public String start2(RedirectAttributes redirectAttributes){
		LocalDate today = service.readToday();
		redirectAttributes.addFlashAttribute("today",today);
		return "redirect:/case05/dest02";
	}
	@RequestMapping("dest02")
	public String dest2(Model model){
		//today를 꺼내오는작업
		LocalDate today = (LocalDate)model.getAttribute("today");
		
		log.info("dest02--{}", today);
		return "case05/finalview01";
	}
	//dispatcher forward -> forward:
	/**
	 * HandlerAdapter 의 동작구조
	 * 1. 핸들러 메소드의 logical view name 과 - model (Model, RedirectAttributes)
	 * 2. logical view name는 최종적으로 ViewResolver 에게 전달됨.
	 * 3. model의 사용
	 * 	1) Model.addAttribute : request 에 attribute 를 옮겨담아줌.
	 *  2) RedirectAttributes.addFlashAttribute
	 *  			--> FlashMap으로 이동 
	 *  			--> redirect (FlashMap 에서 Model 을 옮겨담아줌)
	 *  			--> 이동 후 도착점(dest02)에서 Model 을 통해 확보  
	 * @param model
	 * @return
	 */
	@RequestMapping("start01")
	public String start1(Model model){
		LocalDate today = service.readToday();
		model.addAttribute("today",today);
		return "forward:/case05/dest01";
	}
	@RequestMapping("dest01")
	public String dest1(@RequestAttribute("today") LocalDate today){
		log.info("dest01--{}", today);
		return "case05/finalview01";
	}
}
