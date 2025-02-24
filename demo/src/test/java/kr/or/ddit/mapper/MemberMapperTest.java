package kr.or.ddit.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberMapperTest {

	@Autowired
	MemberMapper mapper;

	@Test
	void testSelectAll() {
		mapper.selectAll();
	}

	@Test
	void testSelectOne() {
		mapper.selectOne("a001");
	}

}
