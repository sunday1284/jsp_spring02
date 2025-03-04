package kr.or.ddit.prod.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.CustomRootContextConfig;
import kr.or.ddit.prod.exception.ProdNotExistException;

@CustomRootContextConfig
class ProdServiceImplTest {
<<<<<<< HEAD

=======
	
>>>>>>> branch 'main' of https://github.com/sunday1284/jsp_spring02.git
	@Inject
	ProdService service;
	@Test
	void testReadProd() {
		assertThrows(ProdNotExistException.class, ()-> service.readProd("asdfasd"));
		assertDoesNotThrow(()-> service.readProd("P101000001"));
	}
	

}
