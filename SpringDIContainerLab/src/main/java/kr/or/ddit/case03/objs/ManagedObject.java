package kr.or.ddit.case03.objs;

import kr.or.ddit.case01.objs.ObjectWithDefaultConstructor;
import kr.or.ddit.case02.objs.Case02DummyDAO;
import lombok.extern.slf4j.Slf4j;

/**
 * PlainOldJavaObject container
 * 
 */
@Slf4j
public class ManagedObject {
	//has a required
	private final ObjectWithDefaultConstructor owdc;

	//has a optional
	private Case02DummyDAO dao;
	
	public ManagedObject(ObjectWithDefaultConstructor owdc) {
		super();
		this.owdc = owdc;
		log.info("{} 생성자로 객체 생성, {} 주입 완료( 생성자 주입 방식 )",
						this.getClass().getSimpleName(), owdc.getClass().getSimpleName());
	}
	public void setDao(Case02DummyDAO dao) {
		this.dao = dao;
		log.info("setter를 통해 {} 주입완료 (setter 주입 방식)", dao.getClass().getSimpleName());
	}


	public void initCustom() {
		log.info("{} 객체 생성 후 초기화 완료", this.getClass().getSimpleName());
	}
	
	
	public void destroyCustom() {
		log.info("{} 객체 소멸", this.getClass().getSimpleName());
		
	}
}
