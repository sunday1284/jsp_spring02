package kr.or.ddit.case06.user.objs;

import org.springframework.stereotype.Controller;

import kr.or.ddit.case04.objs.service.Case04DummyService;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Controller
//필수 생성자 
@RequiredArgsConstructor
@ToString
public class UserController {
	private final Case04DummyService service;
	
	
	
}
