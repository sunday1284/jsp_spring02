package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.CustomRootContextConfig;
import kr.or.ddit.vo.LprodVO;


@CustomRootContextConfig
class LprodMapperTest {
	
	@Autowired
	LprodMapper mapper;
	
	@Test
	void testSelectLprod() {
	}

	@Test
	void testSelectLprodList() {
	}

	@Test
	void testInsertLprod() {
		LprodVO lprod = new LprodVO();
		lprod.setLprodGu("P909");
		lprod.setLprodNm("신규분류");
		assertDoesNotThrow(()->{
			assertEquals(1, mapper.insertLprod(lprod));
		});
	}

}
