package kr.or.ddit.case04.objs.controller;

import org.springframework.stereotype.Controller;

import kr.or.ddit.case04.objs.service.Case04DummyService;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@ToString
public class Case04DummyController {
	private Case04DummyService service;
	
	public void setService(Case04DummyService service) {
		this.service = service;
	}
	
	public void init() {
		log.info("{}", this);
	}
}
