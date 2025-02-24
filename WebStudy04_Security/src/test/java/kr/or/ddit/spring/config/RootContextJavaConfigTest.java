package kr.or.ddit.spring.config;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;
import javax.security.sasl.SaslServerFactory;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.CustomRootContextConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CustomRootContextConfig
class RootContextJavaConfigTest {
	
	@Inject
	SqlSessionFactory sqlSessionFactory;
	
	@Test
	void test() {
		log.info("sqlSessionFactory : {}", sqlSessionFactory);
	}


}
