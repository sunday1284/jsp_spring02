package kr.or.ddit.dummy.service;

import kr.or.ddit.dummy.dao.DummyDAO;
import lombok.Data;

@Data
public class DummyServiceImpl {
//	1. 의존관계 형성 : new 키워드로 의존 객체 직접 생성.
//	private DummyDAO dao = new DummyDAOImplForMariaDB();
//	2. Factory Method[Object] Pattern 적용 
//	private DummyDAO dao = new DummyDAOFactory().getDummyDAO();
//	3. strategy pattern 적용 : 전략의 주입자(결합력을 모두 감당해야함.)가 필요하고, 주입 방법이 결정되어야 함.
	private DummyDAO dao;

	public DummyServiceImpl(DummyDAO dao) {
		super();
		this.dao = dao;
	}
	
	
}
