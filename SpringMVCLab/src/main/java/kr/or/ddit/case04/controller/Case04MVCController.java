package kr.or.ddit.case04.controller;

import java.time.LocalDate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.case04.service.Case04DummyService;

@Controller
@RequestMapping("/case04")
public class Case04MVCController {
	
	@Resource(name="case04DummyService")
	private Case04DummyService service;
	
	
	/**
	 * 한 컨트롤러에서 스코프 값이 중복될떄 하나를 주면 다 들어간다.
	 * @return
	 */
	@ModelAttribute("today")
	public LocalDate addAttribute() {
		return service.readToday();
	}
	
	/**
	 * @return
	 */
	@RequestMapping("model03")
	public ModelAndView handler3(){
		ModelAndView mav = new ModelAndView();
		LocalDate today = service.readToday();		
//		mav.addObject("today", today);
		mav.setViewName("case04/model01");	
		return mav;
	}
	
	/**
	 * 
	 * @param model : call by reference 로 model 을 HandlerAdapter 에게 전달
	 * @return logicalViewName 을 HandlerAdapter 에게 전달
	 */
	@RequestMapping("model02")
	public String handler2(Model model){
		LocalDate today = service.readToday();
//		model.addAttribute("today", today);
		return "case04/model01";
	}
	@RequestMapping("model01")
	public void handler1(HttpServletRequest req){
		LocalDate today = service.readToday();
//		req.setAttribute("today", today);
	}
}
