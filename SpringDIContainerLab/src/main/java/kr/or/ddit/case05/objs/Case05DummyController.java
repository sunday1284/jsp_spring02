package kr.or.ddit.case05.objs;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@ToString
@Controller
public class Case05DummyController {
//	@Autowired
//	@Inject
//	@Named("case05DummyService")
	@Resource(name = "case05DummyService")
	private Case05DummyService service;
	
	public void init() {
		log.info("init method 실행");
	}
	
	public void destroy() {
		log.info("destroy method 실행");
	}
}
