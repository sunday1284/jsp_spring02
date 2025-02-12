package kr.or.ddit.m2.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.m2.objs.HuntingGround;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(Misson02JavaConfig.class)
class Misson02JavaConfigTest {
	
	@Autowired
	HuntingGround ground;
	@Test
	void test() {
		log.info("{}", ground);
	}

}
