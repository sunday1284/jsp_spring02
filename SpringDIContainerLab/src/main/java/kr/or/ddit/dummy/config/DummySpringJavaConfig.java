package kr.or.ddit.dummy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.or.ddit.dummy.dao.DummyDAO;
import kr.or.ddit.dummy.dao.DummyDAOImplForMariaDB;
import kr.or.ddit.dummy.dao.DummyDAOImplForOracle;
import kr.or.ddit.dummy.service.DummyServiceImpl;

/**
 * 환경설정파일 -> 객체 등록
 */
@Configuration
public class DummySpringJavaConfig {
	
	
	@Bean
	public DummyDAO dummyDAOMariaDB() {
		return new DummyDAOImplForMariaDB();
	}
	
	@Bean
	public DummyDAO dummyDAOOracle() {
		return new DummyDAOImplForOracle();
	}
	
	@Bean
	public DummyServiceImpl dummyService(DummyDAO dummyDAOOracle) {
		return new DummyServiceImpl(dummyDAOOracle);
	}
}
