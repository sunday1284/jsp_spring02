package kr.or.ddit.member.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import kr.or.ddit.CustomRootContextConfig;
import kr.or.ddit.member.exception.UserNotFoundException;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.paging.PaginationInfo;

@CustomRootContextConfig
class MemberServiceImplTest {
	@Autowired
	MemberService service;
	@Test
	void testCreateMember() {
		MemberVO dummy = service.readMember("a002");
		dummy.setMemId("a003");
		assertTrue(service.createMember(dummy));
	}

	@Test
	void testReadMemberList() {
		PaginationInfo<MemberVO> paging = new PaginationInfo<>();
		List<MemberVO> memberList = service.readMemberList(paging);
		assertTrue(memberList.size()>0);
	}

	@Test
	void testReadMember() {
		assertDoesNotThrow(()->service.readMember("b001"));
		
		assertThrows(UserNotFoundException.class,
					()-> service.readMember("asdasf"));		
	}

	@Test
	void testModifyMember() {
		MemberVO member = service.readMember("a001");
		member.setMemAdd1("서울");
		assertDoesNotThrow(() -> {
			assertTrue(service.modifyMember(member));
		});
		member.setMemPass("asdqas");
		assertThrows(AuthenticationException.class, () -> service.modifyMember(member));
	}

	@Test
	void testRemoveMember() {
		MemberVO inputData = new MemberVO();
		inputData.setMemId("j001");
		inputData.setMemPass("asdqfasd");
		assertThrows(AuthenticationException.class, ()-> service.removeMember(inputData));
		inputData.setMemPass("6262");
		assertTrue(service.removeMember(inputData)); 
	}

}
