package kr.or.ddit.case11.objs.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.case11.config.Case11MybatisSpringJavaConfig;

@SpringJUnitConfig(Case11MybatisSpringJavaConfig.class)
class Case11LprodServiceTest {
	
	@Inject
	Case11LprodService service;
	
	@Test
	void testReadLprodList() {
		service.readLprodList();
	}
	@Test
	void textReadLprod() {
		assertNotNull(service.readLprod("P101"));
	}

}
