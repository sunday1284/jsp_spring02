package kr.or.ddit.case08.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.prod.service.LprodService;
import kr.or.ddit.vo.LprodVO;

/**
 * 스프링을 이용한 JSON 변환(marshalling) 방식
 * 1. JsonView 와 ViewResolver 를 이용하는 방식 
 * 	  :  Model 객체 전체를 마샬링함.
 * 2. @ResponseBody를 이용하고, HttpMessageConverter 를 활용해 변환하는 방식
 * 	  :  @ResponseBody 으로 수식하는 반환객체를 마샬링함.
 */
@Controller
@RequestMapping(value = "/case08", produces = MediaType.APPLICATION_JSON_VALUE)
public class JsonResponseController {
	@Inject
	private LprodService service;
	
	@GetMapping("/dummy02")
	@ResponseBody
	public Map<String, Object> dummy2() {
		Map<String, Object> map = new HashMap<>();
		map.put("text", "텍스트");
		map.put("number", 34);
		map.put("frag", true);
		map.put("today", LocalDate.now());
		return map;
	}
	@GetMapping("/dummy01")
	public void dummy1(Model model) {
		Map<String, Object> map = new HashMap<>();
		map.put("text", "텍스트");
		map.put("number", 34);
		map.put("frag", true);
		map.put("today", LocalDate.now());
		model.addAttribute("map",map);
	}
	
	@GetMapping("/lprod03")
	@ResponseBody
	public List<LprodVO> lprodList() {
		return service.readLprodList();	
	}
	@GetMapping("/lprod02/{lprodGu}")
	@ResponseBody
	public LprodVO lprod2(
			@PathVariable("lprodGu") String lprodGu
			) {
		return service.readLprod(lprodGu);
		
	}
	@GetMapping("/lprod01/{lprodGu}")
	public void lprod1(
		@PathVariable("lprodGu") String lprodGu
		, Model model
	) {
		LprodVO lprod = service.readLprod(lprodGu);
		model.addAttribute("lprod", lprod);
	}
}
