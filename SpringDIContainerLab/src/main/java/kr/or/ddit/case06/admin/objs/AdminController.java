package kr.or.ddit.case06.admin.objs;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import kr.or.ddit.case04.objs.service.Case04DummyService;
import lombok.ToString;

@Controller
@ToString
public class AdminController {
	private Case04DummyService service;
	
	@Inject
	public void setService(Case04DummyService service) {
		this.service = service;
	}
}
