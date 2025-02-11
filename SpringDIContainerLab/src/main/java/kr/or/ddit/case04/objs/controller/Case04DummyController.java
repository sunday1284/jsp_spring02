package kr.or.ddit.case04.objs.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.or.ddit.case04.objs.service.Case04DummyService;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@ToString
public class Case04DummyController {
	private Case04DummyService service;
	
	
//	@Autowired(required = true) //꼭 주입해야되는 조건 -> 파라미터 타입이 검색조건
	@Resource(name="case04DummyServiceImpl")
	public void setService(Case04DummyService service) {
		this.service = service;
		log.info("{} 주입이 되었음. (setter injection)", service.getClass().getSimpleName());
	}
	
	
	/**
	 * callback(init) -> 주입된 후에 호출 방법
	 */
	@PostConstruct
	public void init() {
		log.info("init method--- {}", this);
	}
	
	/**
	 * callback(destory) -> 종료되기 직전에 호출
	 */
	@PreDestroy
	public void destory() {
		log.info("destroy method==={}", this);
	}
}
