package kr.or.ddit.m1.config;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.m1.objs.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//1
@SpringJUnitConfig(Misson01AutoWiredJavaConfig.class)
class Misson01AutoWiredJavaConfigTest {
	
	//2
	@Inject
	Foo foo;
	
	@Test
	void test() {
		log.info("{}", foo);
	}

}
