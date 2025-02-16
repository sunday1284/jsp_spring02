package com.ddit.hr.prod.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ddit.hr.prod.service.LprodService;
import com.ddit.hr.vo.LprodVO;

import lombok.Data;

@Controller
@Data
public class LprodController {
	
	private final LprodService service;
	
	@GetMapping("/prod/lprodDetail.do")
	public ModelAndView lprodDetail(
		@RequestParam(value = "what", required = true) String what
	) {
		ModelAndView mav = new ModelAndView();
		LprodVO lprod = service.readLprod(what);
		mav.addObject("lprod",lprod);
		//view단으로 보내기
		mav.setViewName("tiles:prod/lprodDetail");
		return mav;
	}
	
	
	
	@GetMapping("/prod/lprodList.do")
	public String lprodList(Model model) {
		List<LprodVO> lprodList = service.readLprodList();
		model.addAttribute("lprodList", lprodList);
		return "tiles:prod/lprodList";
	}
	
	
}
