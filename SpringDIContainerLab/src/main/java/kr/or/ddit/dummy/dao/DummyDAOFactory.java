package kr.or.ddit.dummy.dao;

public class DummyDAOFactory {
	public DummyDAO getDummyDAO(){
		return new DummyDAOImplForOracle();
	}
}
