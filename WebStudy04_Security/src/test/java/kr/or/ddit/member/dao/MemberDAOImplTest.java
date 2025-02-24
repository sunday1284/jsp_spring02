package kr.or.ddit.member.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.CustomRootContextConfig;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.paging.PaginationInfo;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@CustomRootContextConfig
class MemberDAOImplTest {
	@Autowired
	MemberDAO dao;

	@Test
	void testInsertMember() {
		MemberVO dummy = dao.selectMember("a001");
		System.out.printf("mem_bir : %s\n", dummy.getMemBir());
		System.out.printf("mem_memorialday : %s\n", dummy.getMemMemorialday());
		dummy.setMemId("n002");
		assertDoesNotThrow(()->dao.insertMember(dummy));
	}

	@Test
	void testSelectMemberList() {
		assertDoesNotThrow(()->{
			PaginationInfo<MemberVO> paging = new PaginationInfo<>();
			List<MemberVO> memberList = dao.selectMemberList(paging);
			assertNotEquals(0, memberList.size());
		});
	}

	@Test
	void testSelectMember() {
		assertDoesNotThrow(()->{
			MemberVO member = dao.selectMember("c001");
			assertNotNull(member);
			assertEquals(false, member.isMemDelete());
			log.info("authorities : {}", member.getAuthorities());
		});
	}

	@Test
	void testUpdateMember() {
		MemberVO member = dao.selectMember("a004");
		member.setMemAdd1("대전");
		member.setMemAdd2("광역시");
		assertDoesNotThrow(()->{
			assertEquals(1, dao.updateMember(member));
		});
	}

	
	@Test
	void testDeleteMember() {
		assertDoesNotThrow(()->{
			assertEquals(1, dao.deleteMember("a001"));	
		});
	}

}
