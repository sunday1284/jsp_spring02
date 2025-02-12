package kr.or.ddit.case11.objs.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.case11.config.Case11MybatisSpringJavaConfig;
import lombok.extern.slf4j.Slf4j;


/**
 * 스프링 테스트 케이스 작성시 config 파일을 읽어와서 해야함
 */
@Slf4j
@SpringJUnitConfig(Case11MybatisSpringJavaConfig.class)
class Case11PersonServiceTest {
	
	@Autowired
	Case11PersonService service;
	
	@Test
	void test() {
		log.info("service {}", service);
	}

}
