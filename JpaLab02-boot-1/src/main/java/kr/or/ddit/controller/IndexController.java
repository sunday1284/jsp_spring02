package kr.or.ddit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ddit.vo.DummyVO;

@Controller
public class IndexController {
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("dummy", "더미 모델");
		model.addAttribute("dummyList",List.of("a","b","c")); 
		model.addAttribute("voList",List.of(new DummyVO("이름1", 23), new DummyVO("이름2", 54))); 
		return "dummy/index";
	}
}
