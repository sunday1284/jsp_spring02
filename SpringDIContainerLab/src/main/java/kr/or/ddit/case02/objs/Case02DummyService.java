package kr.or.ddit.case02.objs;

import kr.or.ddit.case01.objs.ObjectWithDefaultConstructor;
import lombok.ToString;

@ToString
public class Case02DummyService {
	//필수 의존객체
	private final Case02DummyDAO dummyDAO;
	
	private ObjectWithDefaultConstructor owdc;
	
	// 유일한 생성자 -> 생성자 주입
	public Case02DummyService(Case02DummyDAO dummyDAO) {
		super();
		this.dummyDAO = dummyDAO;
	}
	
	//setter 주입 -> 외부에서 가져올 수 있음
	public void setOwdc(ObjectWithDefaultConstructor owdc) {
		this.owdc = owdc;
	}
	
}
