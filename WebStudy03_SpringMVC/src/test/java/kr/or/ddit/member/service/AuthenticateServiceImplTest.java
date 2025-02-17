package kr.or.ddit.member.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.CustomRootContextConfig;
import kr.or.ddit.auth.exception.AuthenticateException;
import kr.or.ddit.auth.service.AuthenticateService;
import kr.or.ddit.member.vo.MemberVO;

@CustomRootContextConfig
class AuthenticateServiceImplTest {
	
	@Inject
	AuthenticateService service;
	
	@Test
	void testAuthenticate() {
		assertThrows(AuthenticateException.class, ()->service.authenticate("b001", "1004"));
		MemberVO result = service.authenticate("a004", "1234");
		assertNotNull(result);
	}

}
