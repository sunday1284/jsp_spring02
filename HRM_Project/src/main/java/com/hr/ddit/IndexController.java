package com.hr.ddit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class IndexController{
	@GetMapping("/")
	public String index() {
		return "tiles:index"; 
	}
}
