package com.example.accessingdatajpa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
	private final CustomerService service;
	
	@GetMapping("create")
	public String formUI() {
		return "customer/form";
	}
	
	@PostMapping("create")
	public String formProcess(@ModelAttribute CustomerDTO dto) {
		log.info("dto : {}", dto);
		service.create(dto);
		return "redirect:/customer/list";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("customerList",service.readAll()); 
		return "customer/list";
	}
}
