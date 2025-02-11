package kr.or.ddit.case04.objs.service;

import org.springframework.stereotype.Service;

import kr.or.ddit.case04.objs.dao.Case04DummyMapper;
import kr.or.ddit.case04.objs.dao.Case04DummyOthers;
import lombok.ToString;

@Service //생성자를 자동 호출해줌
@ToString
public class Case04DummyServiceImpl implements Case04DummyService {
	private final Case04DummyMapper case04DummyMapper;
	private Case04DummyOthers others;

	//생성자 주입방식
	public Case04DummyServiceImpl(Case04DummyMapper case04DummyMapper) {
		super();
		this.case04DummyMapper = case04DummyMapper;
	}
	//setter 주입방식
	public void setOthers(Case04DummyOthers others) {
		this.others = others;
	}
	
	
}
