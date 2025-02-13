package kr.or.ddit.prod.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.CustomRootContextConfig;
import kr.or.ddit.spring.config.RootContextJavaConfig;


@CustomRootContextConfig
class lprodServiceImplTest {
	
	@Inject
	LprodService service;
	
	@Test
	void testreadLprodList() {
		service.readLprodList();
	}
	
	@Test
	void testreadLprod() {
		service.readLprod("P101");
	}
	

}
